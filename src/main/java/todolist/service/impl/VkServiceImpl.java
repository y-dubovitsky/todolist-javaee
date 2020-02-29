package todolist.service.impl;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.account.UserSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import todolist.exception.InternalApplicationException;
import todolist.exception.SocialNetworkException;
import todolist.model.SocialAccount;
import todolist.model.impl.VkAccount;
import todolist.service.SocialNetworkService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. Синтаксис запроса
 * Чтобы обратиться к методу API ВКонтакте, Вам необходимо выполнить POST или GET запрос такого вида:
 * https://vk.com/dev/api_requests
 *
 * Что дальше
 * После успешной авторизации Вы можете осуществлять запросы к API.
 */
public class VkServiceImpl implements SocialNetworkService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VkServiceImpl.class);
    private static final Integer APP_ID = 7339092; // Id приложения
    private static final String CLIENT_SECRET = "tKtsiBCR6qcWxfBzrNoa"; //? секретный ключ
    private static final String SCOPE = "email"; // права доступа
    private static final String REDIRECT_URI = "http://localhost:8080/from-social"; // Куда делать редирект
    private VkApiClient vk;

    public VkServiceImpl() {
        super();
        vk = init();
    }

    /**
     * 1. Инициализация
     * Создайте объект VkApiClient следующим образом:
     */
    public VkApiClient init() {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        return vk;
    }

    /**
     * 2. Authorization Code Flow для получения ключа доступа пользователя
     */
    public void getCode(HttpServletResponse resp) {
        try {
            resp.sendRedirect("https://oauth.vk.com/authorize?client_id=" + APP_ID +
                    "&display=" + "page" +
                    "&redirect_uri=" + REDIRECT_URI +
                    "&scope=" + SCOPE +
                    "&response_type=code" +
                    "&v=5.103");
        } catch (Exception e) {
            e.getMessage();
        }
    }


    /**
     * 3. Authorization Code Flow для пользователя
     *
     * Метод принимает в качестве параметров ID приложения, секретный ключ, redirect URI, список прав доступа и "code", полученный на первом этапе.
     */
    public UserActor userAuth(String code) {
        try {
            UserAuthResponse authResponse = this.vk.oauth() //! VkApiClient - позволяет работать с API Vk
                    .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
                    .execute();
            UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
            return actor;
        } catch (Exception e) {
            LOGGER.error("Cant do Authorization Code Flow " + e.getMessage(), e);
            throw new InternalApplicationException("Cant do Authorization Code Flow " + e.getMessage(), e);
        }
    }

    /**
     * Получаем модель пользователя из Соц-Сети
     * @param vk - объект, позволяющий работать с API VK.
     * @param actor - UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
     * @return
     */
    public VkAccount getSocialAccount(UserActor actor) {
        try {
            VkAccount vkAccount = new VkAccount();
            UserSettings execute = this.vk.account().getProfileInfo(actor).execute(); //! Ошибки доступа
            String firstName = execute.getFirstName();
            String lastName = execute.getLastName();
            vkAccount.setName(firstName + " " + lastName);
            return vkAccount;
        } catch (ApiException | ClientException e) {
            LOGGER.error("Access error in method VkAccount getSocialAccount(VkApiClient vk, UserActor actor) " + e.getMessage(), e);
            throw new SocialNetworkException("Access error in method VkAccount getSocialAccount(VkApiClient vk, UserActor actor) " + e.getMessage(), e);
        }
    }

    /**
     * Данный метод делает GET запрос с методом users.get и получает ответ с полями
     *
     * Описание методов API, Ниже приводятся все методы для работы с данными ВКонтакте.:
     * https://vk.com/dev/methods
     */
    public void usersGet (HttpServletResponse resp, UserActor actor) { //! Разобраться с методами из VkApi, так как много ошибок доступа.
        try {
            resp.sendRedirect( //* https://vk.com/dev/api_requests
                    "https://api.vk.com/method/users.get?user_ids=" + actor.getId() +
                    "&fields=bdate&access_token=" + actor.getAccessToken() +
                    "&v=5.103");
        } catch (Exception e) {
            LOGGER.error("Access error in method void apiRequest(HttpServletResponse resp, UserActor actor, VkApiClient vk) " + e.getMessage(), e);
            throw new SocialNetworkException("Access error in method void apiRequest(HttpServletResponse resp, UserActor actor, VkApiClient vk) " + e.getMessage(), e);
        }
    }

    /**
     *  4. Получение access_token и email
     *
     *  Краткий алгоритм действий:
     *  1) Регистрируешь приложение в ВКонтакте
     *  2) Формируешь ссылку как в документации API https://vk.com/dev/auth_sites (если нужен email, то указываешь &scope=email )
     *  3) После получения кода делаешь запрос на получение access_token, в ответе приходит id и email пользователя
     *
     *  В результате выполнения данного запроса Ваш сервер получит вновь созданный access_token.
     *  Вместе с access_token серверу возвращается время жизни ключа expires_in в секундах.
     *  Процедуру авторизации приложения необходимо повторять в случае истечения срока действия access_token,
     *  смены пользователем своего логина или пароля или удаления приложения из настроек.
     *
     *  {"access_token":"533bacf01e11f55b536a565b57531ac114461ae8736d6506a3", "expires_in":43200, '''user_id":66748}
     */
    public void getAccessTokenAndUserEmail(HttpServletResponse resp, String code) { //? https://vk.com/dev/authcode_flow_user что то тут не то
        try {
            resp.sendRedirect( //? редирект?
                    "https://oauth.vk.com/access_token?client_id=" + APP_ID +
                            "&client_secret=" + CLIENT_SECRET +
                            "&redirect_uri=" + REDIRECT_URI +
                            "&code=" + code
            );
        } catch (IOException e) {
            LOGGER.error("Bad try to getAccessToken " + e.getMessage(), e);
        }
    }

    public SocialAccount getSocialAccount(HttpServletRequest req) {
        VkAccount socialAccount = new VkAccount();
        String email = req.getParameter("email");
        socialAccount.setEmail(email);
        return socialAccount;
    }
}

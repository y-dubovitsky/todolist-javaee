package todolist.service;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import todolist.model.SocialAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SocialNetworkService {

    void getCode(HttpServletResponse resp);

    void getAccessTokenAndUserEmail(HttpServletResponse resp, String code);

    SocialAccount getSocialAccount(HttpServletRequest req);
}

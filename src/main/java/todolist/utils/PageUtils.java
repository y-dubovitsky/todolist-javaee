package todolist.utils;

import javax.servlet.http.HttpServletRequest;

public class PageUtils {

    /**
     * Эта функция возвращает максимальное количество страниц с задачми
     * @param totalTasks - общее количество задач
     * @param maxTaskPerPage - максимальное количество задач для одновременного отображения на странице
     * @return
     */
    public static final long pagesTotalCount(long totalTasks, int maxTaskPerPage) {
        long pages = totalTasks / maxTaskPerPage;
        if (totalTasks * maxTaskPerPage > pages) {
            pages++;
        }
        return pages;
    }

    /**
     * Возвращает номер страницы из строки запроса
     * @param request
     * @return
     */
    public final int getPage(HttpServletRequest request) {
        try {
            Integer page = Integer.parseInt(request.getParameter("page"));
            return page;
        } catch (NumberFormatException e) {
            return 1;
        }
    }

}

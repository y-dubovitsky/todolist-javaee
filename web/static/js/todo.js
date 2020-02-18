(function() {

    /**
     * Initialization function
     */
    let start = function() {
        timeChange($(".current-time"));
        changeTheme();
    };

    /**
     * Функция загрузки дополнительных задач вниз страницы
     */
    $(document).ready(function() {
        $("#loadMore").bind("click", function () {
            $.ajax({
                url: "/ajax/html/more/products", // обращение к сервлету, обрабатывающема аякс запросы
                before: function() {
                    $("#loadMore").addClass("hide-button"); // прячем кнопку загрузки
                    $("#load-img").removeClass("hide-button "); // крутиться колесико =)
                },
                success: function (html) {
                    $('#pager-nav').prepend(html); // выводим список задач
                    $("#load-img").addClass("hide-button ");
                    $("#loadMore").removeClass("hide-button ");
                }
            });
        });
    });

    /**
     * Загрузить старые задачи, а текущие убрать заменить
     */
    var loadOlderTasks = function() {
        // Обработчик клавиши Older
    }

    /**
     * Загрузить новые задачи, а текущие убрать заменить
     */
    var loadNewerTasks = function() {

    }

    /**
     * Returns current date and time
     * @returns {string}
     */
    let getCurrentTime = function() {
        let currentdate = new Date();
        let datetime = "Current Time: " + currentdate.getDate() + "/"
            + (currentdate.getMonth()+1)  + "/"
            + currentdate.getFullYear() + " @ "
            + currentdate.getHours() + ":"
            + currentdate.getMinutes() + ":"
            + currentdate.getSeconds();
        return datetime;
    };

    let timeChange = function(arg) {
        setInterval(function () {
            arg.text(getCurrentTime());
        }, 100);
    };

    /**
     * This function change main theme
     */
    var changeTheme = function() {
        $("#switcher").bind("click", function() {
            if($("#switcher").prop("checked") == 'checked') {
                $(".theme.switcher").text("Light Theme");
                $("#switcher").prop('checked', false);
            }
            else {
                $(".row.container-context").addClass("dark-theme");
                $(".theme.switcher").text("Dark Theme");
                $("#switcher").prop('checked', true);
            }
        });
    };


    /**
     * Start up init function
     */
  start();
})();

(function() {

    /**
     * Initialization function
     */
    let start = function() {
        timeChange($(".current-time"));
        $('#loadMore').on("click", loadMoreTasks);
        $(".btn.btn-danger").on("click", deleteTask);
        //TODO https://www.bootstraptoggle.com/
        toogle();
        $('#toggle-two').change(changeTheme);
    };

    /**
     * 		var pathname = window.location.pathname; // Returns path only (/path/example.html)
     // 	var url      = window.location.href;     // Returns full URL (https://example.com/path/example.html)
     // 	var origin   = window.location.origin;   // Returns base URL (https://example.com)

     // 	https://www.w3schools.com/jsref/prop_loc_search.asp
     */
    var loadMoreTasks = function () {
        var pageCount = parseInt($('#tasks-panel').attr("data-page-count"));
        var pageNumber = parseInt($('#tasks-panel').attr("data-page-number"));
        var url = '/ajax/html/more' + location.pathname + '?page=' + (pageNumber + 1);
        $.ajax({
            url : url,
            success : function(html) {
                $('#pager-nav').prepend(html); //TODO Разобраться с порядком вставки элементов! Задачи вставляются не по порядку
                pageNumber++; // Увеличиваем page number
                if (pageNumber < pageCount) { // Если есть еще страницы для отображения
                    $('#tasks-panel').attr("data-page-number", pageNumber);
                } else { // В противном случае удаляем кнопку
                    $('#loadMore').remove();
                }
            },
            error : function(data) {
                alert('Error' + data);
            }
        });
    };

    //TODO Усли были подгружены новые задачи - эта функция не сработает!!! Разобраться!
    var deleteTask = function() {
        var task = $(this).closest(".panel.panel-default");
        var taskId = $(task).attr("data-task-id");
        var url = "/delete-task" + "?task-id=" + taskId;
        $.ajax({
                type : "GET",
                url : url,
                success : function(html) {
                    task.remove();
                },
                error : function() {
                    alert("Task dont deleted")
                }
            }
        )
    };

    /**
     * Загрузить старые задачи, а текущие убрать заменить
     */
    var loadOlderTasks = function() {
        // Обработчик клавиши Older
    };

    /**
     * Загрузить новые задачи, а текущие убрать заменить
     */
    var loadNewerTasks = function() {

    };

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

    var toogle = function() {
        $('#toggle-two').bootstrapToggle({
            //TODO Дописать
            on: 'Light Theme',
            off: 'Dark Theme'
        });
    };

    //TODO Дописать функцию
    var changeTheme = function() {
        if(this.checked) {
            alert("please rewrite my js function!");
            $(".row.container-context").addClass("dark-theme");
            this.attr("checked", "");
        }
    };

    /**
     * Start up init function
     */
    start();
})();

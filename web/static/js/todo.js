(function() {

    /**
     * Initialization function
     */
    let start = function() {
        $("#loadMore").click(removeProductFromCart);
        timeChange($(".current-time"));
    };

    /**
     * Deletes the "load more" button and instead shows load.gif
     */
    let removeProductFromCart = function () {
        let btn = $(this);
        let b = document.getElementById("loadMore");
        btn.addClass("hide-button ");
        $("#load-img").removeClass("hide-button ");
        setTimeout(function() {
            $("#load-img").addClass("hide-button ");
            btn.removeClass("hide-button ");
        }, 1000);
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

    /**
     * Start up init function
     */
  start();
})();

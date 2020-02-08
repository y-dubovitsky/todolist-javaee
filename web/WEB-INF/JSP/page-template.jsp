<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>TO DO List</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
              integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous" />
        <link rel="stylesheet" href="../static/css/style.css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet" />
    </head>

    <body>
        <header>
            <jsp:include page="fragment/header.jsp"/>
        </header>
        <div class="row container-context">
            <div class="col-md-1">
                <aside>
                    <jsp:include page="fragment/aside.jsp"/>
                </aside>
            </div>
            <div class="col-md-11">
                <main>
                    <jsp:include page="${currentPage}"/>
                </main>
            </div>
        </div>
        <footer>
            <jsp:include page="fragment/footer.jsp"/>
        </footer>

        <script src="https://code.jquery.com/jquery-1.12.4.min.js"
                integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
                crossorigin="anonymous"></script>

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
                integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
                crossorigin="anonymous"></script>
        <script src="../static/js/todo.js"></script>
    </body>

</html>
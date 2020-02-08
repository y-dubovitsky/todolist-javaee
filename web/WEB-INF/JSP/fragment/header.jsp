<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/tasks-list">
                <img alt="Brand" src="static/img/og-image.png">
            </a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><button id="btn-log-in" class="btn btn-link" data-toggle="modal" data-target="#log-in-modal">Sign In</button></li>
                <li><button id="btn-registration-modal" class="btn btn-link" data-toggle="modal" data-target="#registration-modal">Sign Up</button></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                       aria-haspopup="true" aria-expanded="false">Main menu<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Log out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <%--Modal log-in start--%>
    <div class="modal fade" id="log-in-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Enter login details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">@</span>
                        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="password" aria-describedby="basic-addon2">
                        <span class="input-group-addon" id="basic-addon2">password</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Log in</button>
                </div>
            </div>
        </div>
    </div>
    <%--Modal log-in end--%>

    <%--Modal registration start--%>
    <div class="modal fade" id="registration-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="registration">Enter registration data</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="input-group">
                        <span class="input-group-addon" id="registration-addon1">@</span>
                        <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon" id="registration-addon2"><img src="https://img.icons8.com/pastel-glyph/64/000000/key--v1.png">
                        <input type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon1"></span>
                    </div>

                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Email" aria-describedby="basic-addon2">
                        <span class="input-group-addon" id="registration-addon3">@example.com</span>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputFile">Your photo</label>
                        <input type="file" id="exampleInputFile">
                        <p class="help-block">Enter the path to your photo</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Sign up</button>
                </div>
            </div>
        </div>
    </div>
    <%--Modal registration end--%>
</nav>

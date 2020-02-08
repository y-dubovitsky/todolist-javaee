<%@page pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<div class="panel panel-default">
    <div class="panel-body">
        <div class="jumbotron">
            <h1>Hello, User</h1>
            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ratione libero, ex modi
                asperiores possimus reprehenderit maxime. Perferendis tempora exercitationem
                perspiciatis minima. Aliquid, odio laudantium! Veniam autem saepe praesentium maxime
                qui.</p>
        </div>
        <table class="table table-bordered">
            <div class="row">
                <tr>
                    <td class="success col-xs-2">The number of successfully completed tasks</td>
                    <td class="success">
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped"
                                 role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
                                 style="width: 40%">
                                <span class="sr-only">40% Complete (success)</span>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td class="info col-xs-2">The number of tasks that are currently being performed</td>
                    <td class="info">
                        <div class="progress">
                            <div class="progress-bar progress-bar-info progress-bar-striped"
                                 role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
                                 style="width: 20%">
                                <span class="sr-only">20% Complete</span>
                            </div>
                        </div>.
                    </td>
                </tr>
                <tr>
                    <td class="danger col-xs-2">Number of Pending Tasks</td>
                    <td class="danger">
                        <div class="progress">
                            <div class="progress-bar progress-bar-danger progress-bar-striped"
                                 role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
                                 style="width: 80%">
                                <span class="sr-only">80% Complete (danger)</span>
                            </div>
                    </td>
                </tr>
            </div>
        </table>
    </div>
</div>
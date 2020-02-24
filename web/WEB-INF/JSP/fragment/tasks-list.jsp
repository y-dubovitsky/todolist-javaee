<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:forEach var="t" items="${tasks}" >
<!-- Task -->
<div class="panel panel-default" data-task-id="${t.id}">
    <div class="panel-body">
        <div class="jumbotron">
            <h2>${t.name} ID: ${t.id}</h2>
            <h4>${t.creationTime}</h4>
            <p>${t.description}</p>
            <button type="button" class="btn btn-success">Done</button>
            <button type="button" class="btn btn-danger">Delete task</button>
            <!-- При нажатии кнопки, появляется модальное окно, для изменения задачи -->
            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#myModal">
                Edit task
            </button>
        </div>
    </div>
</div>
</c:forEach>

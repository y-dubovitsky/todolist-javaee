<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div id="tasks-panel" class="panel panel-default" data-page-count="${totalPages}" data-page-number="1">
    <div class="panel-body">
        <jsp:include page="../fragment/tasks-list.jsp"/>
        <tags:pager-nav/>
        <tags:task-edit-modal/>
    </div>
</div>


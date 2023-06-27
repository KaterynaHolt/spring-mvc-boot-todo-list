<%@ page import="com.todolist.app.springmvcboottodolist.models.Item" %>
<%@ page import="com.todolist.app.springmvcboottodolist.models.Tag" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit task</title>
    <link rel="stylesheet" href="edit-task.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <script type="text/javascript" src="newtask.js"></script>
    <script type="text/javascript" src="edittask.js"></script>
</head>
<body>
<div class="edittask">
    <% Optional<Map.Entry<String, Item>> item = (Optional<Map.Entry<String, Item>>) request.getAttribute("item");
        String uuid = (String) request.getAttribute("uuid");
        if(item.isPresent()){ %>
    <form name="form" action="/edit-task" method="post">
        <h2 class="main-text">Edit task</h2>
        <div class="form-group">
            <label class="text">Text <br>
                <input type="text" class="textbox" name="text" value="<%= "  " + item.get().getValue().getValue().trim()%>" />
            </label>
        </div>
        <div class="form-group">
            <label class="text">Due date <br>
                <input type="date" class="textbox" name="date" value="<%=item.get().getValue().getDate()%>" />
            </label>
        </div>
        <div class="form-group">
            <label class="text">Status</label> <br>
            <select class="select" name="status">
                <option value="<%= item.get().getValue().getStatus().toString().toUpperCase(java.util.Locale.ROOT)%>"
                        hidden="hidden"><%= item.get().getValue().getStatus()%></option>
                <option value="INPROGRESS">In progress</option>
                <option value="PENDING">Pending</option>
                <option value="COMPLETED">Completed</option>
                <option value="INCOMPLETED">Incompleted</option>
            </select>
        </div>
        <div class="form-group">
            <label class="text-priority">Priority</label> <br>
            <select class="select" name="priority">
                <option value="<%= item.get().getValue().getPriority().toString().toUpperCase(java.util.Locale.ROOT)%>"
                        hidden="hidden"><%= item.get().getValue().getPriority()%></option>
                <option value="MINOR">Minor</option>
                <option value="CRITICAL">Critical</option>
                <option value="NORMAL">Normal</option>
            </select>
        </div>
        <div class="form-group">
            <label class="text">Tags</label> <br>
            <select class="select-mult" name="tags" multiple="true">
                <%  Tag[] tags = Tag.values();
                    for(Tag t : tags){
                        if(item.get().getValue().getTags().contains(t)){ %>
                <option value="<%= t.toString().toUpperCase(java.util.Locale.ROOT)%>" selected><%= t%></option>
                <% }
                else { %>
                <option value="<%= t.toString().toUpperCase(java.util.Locale.ROOT)%>"><%= t%></option>
                <% }
                } %>
            </select>
        </div>
        <div class="form-group">
            <button class="edit" type="submit" name="EDIT" onclick="return validateForm()" >Edit</button>
            <button class="cancel" type="submit" name="CANCEL">Cancel</button>
        </div>
        <input hidden="hidden" name="uuid" value="<%= uuid%>"/>
        <% } %>
    </form>
</div>
</body>
</html>

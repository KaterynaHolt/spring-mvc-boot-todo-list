<%@ page import="java.util.Map" %>
<%@ page import="com.todolist.app.springmvcboottodolist.models.Item" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.todolist.app.springmvcboottodolist.models.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Notification</title>
    <link rel="stylesheet" href="notification.css">
</head>
<body>
<div class="notification">
    <form action="/notification" method="post">
        <h2>Information about task</h2>
        <%  String operation = (String) request.getAttribute("operation");
            //Optional<Map.Entry<String, Item>> foundElement = (Optional<Map.Entry<String, Item>>) request.getAttribute("result");
            Optional<Task> foundElement = (Optional<Task>) request.getAttribute("result");
            if(foundElement.isPresent()){ %>
        <p> Text - <%= foundElement.get().getValue() %></p>
        <p> Date - <%= foundElement.get().getDate() %></p>
        <p> Status - <%= foundElement.get().getStatus() %></p>
        <p> Priority - <%= foundElement.get().getPriority() %></p>
        <p> Tags - <%= foundElement.get(). getTag() %></p>
        <p> Task - was <%= operation %></p>
        <%  }
        else{ %>
        <p> No task has been found.Maybe it was removed. Check your logs </p>
        <% } %>
        <button class="button" type="submit" name="RETURN">Return</button>
    </form>
</div>
</body>
</html>

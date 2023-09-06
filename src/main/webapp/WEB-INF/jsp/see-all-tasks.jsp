<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.todolist.app.springmvcboottodolist.models.Item" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.todolist.app.springmvcboottodolist.models.Task" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>See all tasks</title>
    <link rel="stylesheet" href="see-all-tasks.css">
    <link href='https://unpkg.com/css.gg@2.0.0/icons/css/more-o.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href='https://unpkg.com/css.gg@2.0.0/icons/css/shape-circle.css' rel='stylesheet'>
</head>
<body>
<div class="see-all">
    <form action="/see-all-tasks" method="post">
        <h2>You have <span style="color:#F32276"><%= request.getAttribute("count") %> task(s) </span> to do
            <button class="button" type="submit" name="ADD">Add new </button> </h2>
        <div class="incompleted">
            <label>On Hold</label>
        </div>
        <div class="table-incompleted">
            <table>
                <thead>
                <tr>
                    <th>Text</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Tags</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% //Map<String, Item> onhold = (Map<String, Item>) request.getAttribute("onhold");
                    //for(Map.Entry<String, Item> entry : onhold.entrySet()){
                    List<Task> onhold = (List<Task>) request.getAttribute("onhold");
                    for(Task t : onhold){
                %>
                <tr>
                    <td><i class="gg-shape-circle"></i><%= t.getValue() %></td>
                    <td><%= t.getDate() %></td>
                    <td><%= t.getStatus() %></td>
                    <td><%= t.getPriority() %></td>
                    <td><span style="color:#437CF5"><%= t.getTag() %></span></td>
                    <td>
                        <div class="dropdown">
                            <button class="dropbtn" disabled="disabled"><i class="gg-more-o"></i></button>
                            <div class="dropdown-content">
                                <a href="<%= request.getContextPath() %>/notification?operation=COMPLETE&id=
<%=t.getId()%>">Complete</a>
                                <a href="<%= request.getContextPath() %>/edit-task?id=<%=t.getId()%>">Edit</a>
                                <a href="<%= request.getContextPath() %>/notification?operation=REMOVE&id=
<%=t.getId()%>">Remove</a>
                            </div>
                        </div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
        <div class="completed">
            <label>Completed <label id="inactive">Inactive</label></label>
        </div>
        <div class="table-completed">
            <table>
                <thead>
                <tr>
                    <th>Text</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Priority</th>
                    <th>Tags</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <% //Map<String, Item> completed = (Map<String, Item>) request.getAttribute("completed");
                    //for(Map.Entry<String, Item> entrycom : completed.entrySet()){
                    List<Task> completed = (List<Task>) request.getAttribute("completed");
                    for(Task t : completed){
                %>
                <tr>
                    <td><i class="gg-shape-circle"></i><%= t.getValue() %></td>
                    <td><%= t.getDate() %></td>
                    <td><%= t.getStatus() %></td>
                    <td><%= t.getPriority() %></td>
                    <td><span style="color:#437CF5"><%= t.getTag() %></span></td>
                    <td>
                        <div class="dropdown">
                            <button class="dropbtn" disabled="disabled"><i class="gg-more-o"></i></button>
                            <div class="dropdown-content">
                                <a href="<%= request.getContextPath() %>/notification?operation=INCOMPLETE&id=
<%=t.getId()%>">Incomplete</a>
                                <a href="<%= request.getContextPath() %>/notification?operation=REMOVE&id=
<%=t.getId()%>">Remove</a>
                            </div>
                        </div>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </form>
</div>
</body>
</html>
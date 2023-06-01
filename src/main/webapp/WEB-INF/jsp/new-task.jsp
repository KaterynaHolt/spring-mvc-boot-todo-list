<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New task</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>
    <script type="text/javascript" src="newtask.js"></script>
    <script type="text/javascript" src="edittask.js"></script>
    <link rel="stylesheet" href="new-task.css">
</head>
<body>
<div class="newtask">
    <form name="form" action="/new-task" method="post">
        <h2 class="main-text">New task</h2>
        <div class="form-group">
            <label class="text">Text <br>
                <input type="text" class="textbox" name="text" value="  "/>
            </label>
        </div>
        <div class="form-group">
            <label class="text">Due date <br>
                <input type="date" class="textbox" name="date"/>
            </label>
        </div>
        <div class="form-group">
            <label class="text">Status</label> <br>
            <select class="select" name="status">
                <option> </option>
                <option value="INPROGRESS">In progress</option>
                <option value="PENDING">Pending</option>
                <option value="COMPLETED">Completed</option>
                <option value="INCOMPLETED">Incompleted</option>
            </select>
        </div>

        <div class="form-group">
            <label class="text-priority">Priority</label> <br>
            <select class="select" name="priority">
                <option> </option>
                <option value="MINOR">Minor</option>
                <option value="CRITICAL">Critical</option>
                <option value="NORMAL">Normal</option>
            </select>
        </div>

        <div class="form-group">
            <label class="text">Tags</label> <br>
            <select class="select-mult" name="tags" multiple="true">
                <option> </option>
                <option value="DAILYROUTINE">Daily routine</option>
                <option value="HOME">Home</option>
                <option value="WORK">Work</option>
                <option value="READING">Reading</option>
            </select>
        </div>
        <div class="form-group">
            <button class="add" type="submit" name="ADD" onclick="return validateForm()">Add</button>
            <button class="cancel" type="submit" name="CANCEL">Cancel</button>
        </div>
    </form>
</div>
</body>
</html>

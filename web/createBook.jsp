<%--
  Created by IntelliJ IDEA.
  User: Sawzdziu
  Date: 03.02.2019
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Create Book</title>
</head>
<body>
<form class="form-signin" action='createBook' method="POST">
    <div id="legend">
        <legend class="">Add book</legend>
    </div>
    <%
        if (request.getParameter("validationError") != null) {

    %>
    <div class="alert alert-danger" role="alert">
        You need to fill all the fields!
    </div>
    <% }
    %>
    <div class="control-group">
        <!-- Title -->
        <label class="control-label" for="title">Name</label>
        <div class="controls">
            <input type="text" id="title" name="title" placeholder="" class="input-xlarge">
            <p class="help-block">Title of a book</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Surname -->
        <label class="control-label" for="isbn">ISBN</label>
        <div class="controls">
            <input type="text" id="isbn" name="isbn" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide ISBN of a book</p>
        </div>
    </div>

    <div class="control-group">
        <!-- City -->
        <label class="control-label" for="year">Year</label>
        <div class="controls">
            <input type="number" id="year" name="year" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide year of publish</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Button -->
        <div class="controls">
            <button class="btn btn-success" type="submit">Register</button>
        </div>
    </div>

</form>
</body>
</html>

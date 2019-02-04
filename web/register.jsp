<%--
  Created by IntelliJ IDEA.
  User: Sawzdziu
  Date: 01.02.2019
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/signin.css">
    <title>Register</title>
</head>
<body class="text-center">
<form class="form-signin" action='register' method="POST">
    <div id="legend">
        <legend class="">Register</legend>
    </div>
    <%
        if (request.getParameter("userExist") != null) {

    %>
    <div class="alert alert-danger" role="alert">
        User with provided username exist!
    </div>

    <% }
    %>
    <%
        if (request.getParameter("validationError") != null) {

    %>
    <div class="alert alert-danger" role="alert">
        You need to fill all the fields!
    </div>

    <% }
    %>
    <div class="control-group">
        <!-- Name -->
        <label class="control-label" for="name">Name</label>
        <div class="controls">
            <input type="text" id="name" name="name" placeholder="" class="input-xlarge">
            <p class="help-block">Name can contain any letters</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Surname -->
        <label class="control-label" for="surname">Surname</label>
        <div class="controls">
            <input type="text" id="surname" name="surname" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide your surname</p>
        </div>
    </div>

    <div class="control-group">
        <!-- City -->
        <label class="control-label" for="city">City</label>
        <div class="controls">
            <input type="text" id="city" name="city" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide your city</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Role -->
        <label class="control-label" for="role">Role</label>
        <div class="controls">
            <input type="text" id="role" name="role" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide your role</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Username -->
        <label class="control-label" for="username">Username</label>
        <div class="controls">
            <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
            <p class="help-block">Username can contain any letters or numbers, without spaces</p>
        </div>
    </div>

    <div class="control-group">
        <!-- E-mail -->
        <label class="control-label" for="email">E-mail</label>
        <div class="controls">
            <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
            <p class="help-block">Please provide your E-mail</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Password-->
        <label class="control-label" for="password">Password</label>
        <div class="controls">
            <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
            <p class="help-block">Password should be at least 4 characters</p>
        </div>
    </div>

    <label>
        <a href="login.jsp"> Do You want to Sign in?</a>
    </label>

    <div class="control-group">
        <!-- Button -->
        <div class="controls">
            <button class="btn btn-success" type="submit">Register</button>
        </div>
    </div>
</form>
</body>
</html>

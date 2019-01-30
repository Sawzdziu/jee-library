<%--
  Created by IntelliJ IDEA.
  User: Sawzdziu
  Date: 24.01.2019
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Authentication</title>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <link rel="stylesheet" href="css/signin.css">
</head>
<body class="text-center">
<form class="form-signin" method="post" action="login">
    <img class="mb-4" src="assets/baseline-local_library-24px.svg" alt="Library" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="username" class="sr-only">Username</label>
    <input type="email" id="username" class="form-control" placeholder="Username" required="" autofocus="">
    <label for="password" class="sr-only">Password</label>
    <input type="password" id="password" class="form-control" placeholder="Password" required="">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2019</p>
</form>
</body>
</html>

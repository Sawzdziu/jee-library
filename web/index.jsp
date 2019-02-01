<%--
  Created by IntelliJ IDEA.
  User: Sawzdziu
  Date: 24.01.2019
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Library</title>
</head>
<body>
<% String username = (String) request.getSession().getAttribute("username");%>
<h1>Welcome <%=username%>!</h1>
<a href="books.jsp">Books</a>
<a href="logout">Logout</a>
</body>
</html>

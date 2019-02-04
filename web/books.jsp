<%@ page import="library.model.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="library.model.dao.BookDAO" %><%--
  Created by IntelliJ IDEA.
  User: Sawzdziu
  Date: 01.02.2019
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Books</title>
</head>
<body style="font">
<%
    List<Book> books = BookDAO.getAllBooks();
%>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">ISBN</th>
        <th scope="col">Year</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <% for (Book book : books) {%>
    <tr>
        <th scope="row"><%= book.getId()%>
        </th>
        <td><%= book.getTitle()%>
        </td>
        <td><%= book.getIsbn()%>
        </td>
        <td><%= book.getYear()%>
        </td>
        <td><a href="editBook.jsp?id=<%=book.getId()%>">
            <button class="btn btn-info">Edit</button>
        </a>
            <a href="deleteBook.jsp?id=<%=book.getId()%>">
                <button class="btn btn-danger">Delete</button>
            </a>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>

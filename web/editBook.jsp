<%@ page import="library.model.entity.Book" %>
<%@ page import="library.model.dao.BookDAO" %><%--
  Created by IntelliJ IDEA.
  User: psawzdar
  Date: 04.02.2019
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Edit Book</title>
</head>
<body>
<%
    String bookId = request.getParameter("id");
    Book editBook = null;
    for (Book book : BookDAO.getAllBooks()) {
        if (book.getId().equals(Integer.valueOf(bookId)))
            editBook = book;
    }
%>
<form class="form-signin" action='editBook' method="POST">
    <div id="legend">
        <legend class="">Edit book</legend>
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
        <!-- ID -->
        <input type='hidden' name='bookId' id='bookId' value='<%= editBook.getId()%>'/>

        <!-- Title -->
        <label class="control-label" for="title">Name</label>
        <div class="controls">
            <input type="text" id="title" name="title" placeholder="" class="input-xlarge"
                   value="<%= editBook.getTitle()%>">
            <p class="help-block">Title of a book</p>
        </div>
    </div>

    <div class="control-group">
        <!-- ISBN -->
        <label class="control-label" for="isbn">ISBN</label>
        <div class="controls">
            <input type="text" id="isbn" name="isbn" placeholder="" class="input-xlarge"
                   value="<%= editBook.getIsbn()%>">
            <p class="help-block">Please provide ISBN of a book</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Year -->
        <label class="control-label" for="year">Year</label>
        <div class="controls">
            <input type="number" id="year" name="year" placeholder="" class="input-xlarge"
                   value="<%= editBook.getYear()%>">
            <p class="help-block">Please provide year of publish</p>
        </div>
    </div>

    <div class="control-group">
        <!-- Button -->
        <div class="controls">
            <button class="btn btn-success" type="submit">Edit book</button>
        </div>
    </div>

</form>
</body>
</html>

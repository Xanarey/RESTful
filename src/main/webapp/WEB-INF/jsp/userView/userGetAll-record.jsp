<%@ page import="com.model.User" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Get All Records</title>
</head>
<body>
<%
    if (request.getAttribute("userGetAllRecord") != null) {
        List<User> userList = (List<User>) request.getAttribute("userGetAllRecord");
%>

<h1>Users Records</h1>
<table>
    <% for (User user: userList) {%>
    <tr>
        <td><%= user.getId()%></td>
        <td><%= user.getName()%></td>
    </tr>
    <%}%>
</table>
<br>
<h3>Update user</h3>
<form action="UserUpdateServlet" method="POST">
    Id: <label>
    <input type="text" name="id">
</label>
    <br/>
    Name: <label>
    <input type="text" name="name"/>
</label>
    <input type="submit" value="Update"/>
</form>
<h3>Create user</h3>
<form action="UserCreateServlet" method="POST">
    <br/>
    Name: <label>
    <input type="text" name="name"/>
</label>
    <input type="submit" value="Create"/>
</form>
<h3>Delete user by id</h3>
<form action="UserDeleteByIdServlet" method="POST">
    <br/>
    Id: <label>
    <input type="text" name="id"/>
</label>
    <input type="submit" value="Delete"/>
</form>
<%
} else {
%>

<h1>No users record found.</h1>

<% } %>
</body>
</html>
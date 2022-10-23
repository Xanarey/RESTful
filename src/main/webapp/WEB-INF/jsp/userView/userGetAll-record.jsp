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
        <td><%= user.getFirstname()%></td>
        <td><%= user.getLastname()%></td>
    </tr>
    <%}%>
</table>

<%
} else {
%>

<h1>No users record found.</h1>

<% } %>
</body>
</html>
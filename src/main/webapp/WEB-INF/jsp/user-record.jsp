<%@ page import="com.model.User" %>
<html>
<head>
    <title>User Record</title>
</head>
<body>
<%
    if (request.getAttribute("userRecord") != null) {
        User user = (User) request.getAttribute("studentRecord");
%>

<h1>User Record</h1>
<div>ID: <%= user.getId()%></div>
<div>First Name: <%= user.getFirstname()%></div>
<div>Last Name: <%= user.getLastname()%></div>

<%
} else {
%>

<h1>No user record found.</h1>

<% } %>
</body>
</html>
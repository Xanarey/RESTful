<%@ page import="com.model.User" %>
<html>
<head>
    <title>User Record</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("userRecord");
    if (user.getId() != null) {
%>

<h1>User Record</h1>
<div>ID: <%= user.getId()%></div>
<div>First Name: <%= user.getName()%></div>

<form method="post" action="/uploadFile" enctype="multipart/form-data">
    <input type="text" name="upload-file">
    <input type="file" name="file-name">
    <button>Send</button>
</form>
<%
} else {
%>

<h1>No user record found.</h1>

<% } %>
</body>
</html>
<%@ page import="com.model.File" %>
<html>
<head>
    <title>User Record</title>
</head>
<body>
<%
    File file = (File) request.getAttribute("fileRecord");
    if (file.getId() != null) {
%>

<h1>User Record</h1>
<div>ID: <%= user.getId()%></div>
<div>First Name: <%= user.getName()%></div>
<div>Download file from FileStorage</div>
<form method="post" action="/uploadFile" enctype="multipart/form-data">
    <input type="text" name="upload-file">
    <input type="file" name="file-name">
    <button>Send</button>
</form>
<div>Load file in FileStorage</div>
<form method="post" action="/loadFile" enctype="multipart/form-data">
    <input type="text" name="load-file">
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
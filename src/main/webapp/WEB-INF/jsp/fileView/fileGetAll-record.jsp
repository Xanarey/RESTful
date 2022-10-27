<%@ page import="com.model.File" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Get All Records</title>
</head>
<body>
<%
    if (request.getAttribute("FileGetAllServlet") != null) {
        List<File> fileList = (List<File>) request.getAttribute("FileGetAllServlet");
%>

<h1>Files Records</h1>
<table>
    <% for (File file: fileList) {%>
    <tr>
        <td><%= file.getId()%></td>
        <td><%= file.getUrl()%></td>
    </tr>
    <%}%>
</table>
<br>
<h3>Update file</h3>
<form action="FileGetByIdServlet" method="POST">
    Id: <label>
    <input type="text" name="id">
</label>
    <br/>
    Url: <label>
    <input type="text" name="name"/>
</label>
    <input type="submit" value="Update"/>
</form>
<h3>Create file</h3>
<form action="FileGetByIdServlet" method="POST">
    <br/>
    Url: <label>
    <input type="text" name="name"/>
</label>
    <input type="submit" value="Create"/>
</form>
<h3>Delete file by id</h3>
<form action="FileGetByIdServlet" method="POST">
    <br/>
    Id: <label>
    <input type="text" name="id"/>
</label>
    <input type="submit" value="Delete"/>
</form>
<%
} else {
%>

<h1>No files record found.</h1>

<% } %>
</body>
</html>
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
<ul>
<%--    <%--%>
<%--        if (userList != null && !userList.isEmpty()) {--%>
<%--            System.out.println("<ui>");--%>
<%--            for (User s : userList) {--%>
<%--                System.out.println("<li>" + s.getId().toString() + "</li>");--%>
<%--            }--%>
<%--            System.out.println("</ui>");--%>
<%--        } else System.out.println("<p>There are no users yet!</p>");--%>
<%--    %>--%> // TODO не работает вывод коллекции , остановился здесь ...
</ul>

<%
} else {
%>

<h1>No users record found.</h1>

<% } %>
</body>
</html>
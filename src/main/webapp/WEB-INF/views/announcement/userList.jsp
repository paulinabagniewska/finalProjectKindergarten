
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Announcement List</title>
    <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Description</th>
    </tr>
    <c:forEach items="${announcements}" var="announcement">
        <tr>
            <td>${announcement.id}</td>
            <td>${announcement.description}</td>
        </tr>
    </c:forEach>
    <tr>
        <td> <a href="/user/loggedIn"> Main Menu </a></td>
    </tr>
</table>
</body>
</html>

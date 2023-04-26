<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Child List</title>
    <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Group</th>
        <th>Parent</th>

    </tr>
    <c:forEach items="${children}" var="child">
        <tr>
            <td>${child.id}</td>
            <td>${child.name}</td>
            <td>${child.surname}</td>
            <td>${child.group.name}</td>
            <td>${child.parent.name}         ${child.parent.surname}</td>
            <td> <a href="/child/update/${child.id}">Edit</a>
            <td> <a href="/child/delete/${child.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
        <td> <a href="/child/add">Add New Child</a></td>
        </td>
    </tr>
    <tr>
        <td> <a href="/user/loggedIn"> Main Menu </a></td>
    </tr>
</table>
</body>
</html>

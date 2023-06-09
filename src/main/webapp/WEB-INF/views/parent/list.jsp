<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parent List</title>
    <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    <c:forEach items="${parents}" var="parent">
        <tr>
            <td>${parent.id}</td>
            <td>${parent.name}</td>
            <td>${parent.surname}</td>
            <td>${parent.email}</td>
            <td>${parent.phone}</td>
            <td> <a href="/parent/update/${parent.id}">Edit</a>
            <td> <a href="/parent/delete/${parent.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
        <td> <a href="/parent/add">Add New Parent</a></td>
        </td>
    </tr>
    <tr>
        <td> <a href="/user/loggedIn"> Main Menu </a></td>
    </tr>
</table>
</body>
</html>

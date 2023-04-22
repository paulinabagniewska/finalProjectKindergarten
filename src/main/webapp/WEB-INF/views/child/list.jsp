<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Child List</title>
</head>
<body>
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
            <td> <a href="/child/add/${child.id}">Edit</a>
            <td> <a href="/child/delete/${child.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
        <td> <a href="/child/add/${child.id}">Add New Child</a></td>
        </td>
    </tr>
</table>
</body>
</html>

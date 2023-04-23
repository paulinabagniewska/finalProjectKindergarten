<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group List</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Group Name</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td> <a href="/group/update/${group.id}">Edit</a>
            <td> <a href="/group/delete/${group.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
        <td> <a href="/group/add/${group.id}">Add New Group</a></td>
        </td>
    </tr>
</table>
</body>
</html>

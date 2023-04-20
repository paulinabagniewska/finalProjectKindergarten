<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                <form action="delete/${group.id}" method="post">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

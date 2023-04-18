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
            <td><button>Edit</button></td>
            <td>
                <form action="delete/${parent.id}" method="post">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

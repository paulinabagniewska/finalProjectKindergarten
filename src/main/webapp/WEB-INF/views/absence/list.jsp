<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Absence List</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Starts of Absence</th>
        <th>Ends of Absence</th>
        <th>Cause of Absence</th>
        <th>Child</th>

    </tr>
    <c:forEach items="${absences}" var="absence">
        <tr>
            <td>${absence.id}</td>
            <td>${absence.startsOfAbsence}</td>
            <td>${absence.endsOfAbsence}</td>
            <td>${absence.causeOfAbsence}</td>
            <td>${absence.child.name} ${absence.child.surname}</td>
            <td> <a href="/absence/add/${absence.id}">Edit</a>
            <td> <a href="/absence/delete/${absence.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
        <td> <a href="/absence/add/${absence.id}">Add New Absence</a></td>
    </tr>
</table>
</body>
</html>

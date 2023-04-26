<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Absence List</title>
    <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="80%"></center>
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
        </tr>
    </c:forEach>
    <tr>
        <td> <a href="/user/loggedIn"> Main Menu </a></td>
    </tr>
</table>
</body>
</html>


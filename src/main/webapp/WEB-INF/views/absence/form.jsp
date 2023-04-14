<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="pl.coderslab.finalproject.child.Child" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Absence form </title>
</head>
<body>
<h1>Absence Form</h1>
<form method="post" action="/absence/add">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" value="">
    <br>
    <label for="startsOfAbsence">Starts of Absence:</label>
    <input type="date" id="startsOfAbsence" name="startsOfAbsence" value="">
    <br>
    <label for="endsOfAbsence">Ends of Absence:</label>
    <input type="date" id="endsOfAbsence" name="endsOfAbsence" value="">
    <br>
    <label for="causeOfAbsence">Cause of Absence:</label>
    <input type="text" id="causeOfAbsence" name="causeOfAbsence" value="">
    <br>
    <label for="child">Child:</label>
    <select id="child" name="child.id">
        <option value="">Select a child</option>
        <c:forEach items="${childList}" var="child">
            <option value="${child.id}">${child.name}</option>
        </c:forEach>
    </select>
    <br>
    <input type="submit" value="Save">
</form>
</body>
</html>

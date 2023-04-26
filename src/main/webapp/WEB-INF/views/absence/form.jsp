<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="pl.coderslab.finalproject.child.Child" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Absence form </title>
    <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<h3>Welcome, Enter the Absence</h3>
<form:form method="POST" action="/absence/add" modelAttribute="absence" >
    <table>
        <tr>
            <td><form:label path="startsOfAbsence">Starts of Absence</form:label></td>
            <td><form:input path = "startsOfAbsence" type="date"/></td>
        </tr>
        <tr>
            <td><form:label path="endsOfAbsence">Ends of Absence</form:label></td>
            <td><form:input path="endsOfAbsence" type="date"/></td>
        </tr>
        <tr>
            <td><form:label path="causeOfAbsence">Cause of Absence</form:label></td>
            <td><form:textarea path="causeOfAbsence"/></td>
        </tr>
        <tr>
            <td><form:label path="child">Child</form:label></td>
            <td><form:select path="child" name="child.id">
                <form:option value="">Select a child</form:option>
                <c:forEach items="${children}" var="child">
                    <form:option value="${child.id}">${child.name}      ${child.surname}</form:option>
                </c:forEach>
            </form:select></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
    <tr>
        <td> <a href="/user/loggedIn"> Main Menu </a></td>
    </tr>
</form:form>
</body>
</html>

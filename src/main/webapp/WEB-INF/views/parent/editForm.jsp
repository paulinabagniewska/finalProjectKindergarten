<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Parent Form</title>
</head>
<body>
<form:form method="POST"
action="/parent/update"   modelAttribute ="parent">
<table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:textarea  path="name" id="name" name="name" rows="4" cols="50"/></td>
        <td><form:hidden path="id" id="id" name="id"/></td>
    </tr>
    <tr>
        <td><form:label path="surname">Surname</form:label></td>
        <td><form:textarea  path="surname" id="surname" name="surname" rows="4" cols="50"/></td>

    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:textarea  path="email" id="email" name="email" rows="4" cols="50"/></td>
    </tr>
    <tr>
        <td><form:label path="phone">Phone</form:label></td>
        <td><form:textarea  path="phone" id="phone" name="phone" rows="4" cols="50"/></td>
    </tr>
    <tr>
        <td><input type="submit" value="Save"/></td>
    </tr>
</table>
</form:form>
</body>
</html>


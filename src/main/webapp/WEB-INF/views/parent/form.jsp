<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parent</title>
</head>
<body>
<h3>Welcome, Enter The Parent Details</h3>

<form:form method="POST"
           action="/parent/add"   modelAttribute ="parent">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" id="name" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname" id="surname" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email" id="email" type="text"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">Phone</form:label></td>
            <td><form:input path="phone" id="phone" type="text"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

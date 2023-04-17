<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Announcement Form</title>
</head>
<body>
<h3>Welcome, Enter The Announcement Description</h3>
<form:form method="POST"
           action="/announcement/add" modelAttribute="announcement">
    <table>
        <tr>
            <td><form:label path="description">
                Description</form:label></td>
            <td><form:textarea path="description"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

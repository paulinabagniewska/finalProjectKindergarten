<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Announcement Form</title>
    <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="80%"></center>
<h3>Welcome, Enter The Announcement Description</h3>
<form:form method="POST"
           action="/announcement/add"   modelAttribute ="announcement">
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

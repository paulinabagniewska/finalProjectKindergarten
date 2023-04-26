<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Form</title>
    <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<h3>Welcome, Enter The Group name</h3>

<form:form method="POST"
           action="/group/add"   modelAttribute ="group">
    <table>
    <tr>
    <td><form:label path="name">Group Name</form:label></td>
    <td><form:input path="name" id="name" type="text"/></td>
    </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

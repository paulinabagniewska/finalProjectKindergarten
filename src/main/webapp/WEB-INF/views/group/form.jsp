<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Form</title>
</head>
<body>
<h3>Welcome, Enter The Group name</h3>

<form:form method="POST"
           action="/group/save"   modelAttribute ="group">
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

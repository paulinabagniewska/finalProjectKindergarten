<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form:form method="POST"
           action="/user/add"   modelAttribute ="user">
    <table>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login" id="login" type="text"/></td>
        </tr>
            <td> <form:label path="password" for="password" >Password</form:label></td>
        <td><form:input path="password" id="password" name="password" type="password"/></td>
        </tr>
            <td><input type="submit" value="Register"/></td>
        </tr>
        <tr>
           <td><p>Already have an account? <a href="/user/login">Click here</a></p></td>
        </tr>
    </table>
</form:form>
</body>
</html>

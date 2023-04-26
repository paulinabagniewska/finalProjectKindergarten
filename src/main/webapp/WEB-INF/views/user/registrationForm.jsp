<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="/css/registration.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<form:form method="POST"
           action="/user/add"   modelAttribute ="user">

        <tr>
            <td> <p>Welcome at the Kindergarten's App!
            Now you can have all matters related to kindergarten in one place!
            We invite you to register below </p></td>
        </tr>


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

</form:form>
</body>
</html>

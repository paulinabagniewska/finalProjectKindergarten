<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<form:form method="POST"
           action="/user/login"   modelAttribute ="user">
  <table>
    <tr>
      <td><form:label path="login">Enter Login</form:label></td>
      <td><form:input path="login" id="login" type="text"/></td>
    </tr>
    <tr>
      <td> <form:label path="password" for="password" >Enter Password </form:label></td>
      <td><form:input path="password" id="password" name="password" type="password"/></td>
    </tr>

    <td><input type="submit" value="Log in"/></td>

  </table>
</form:form>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="80%"></center>
<form:form method="POST"
           action="/group/update"   modelAttribute ="group">
  <table>
    <tr>
      <td><form:label path="name">Group Name</form:label></td>
      <td><form:textarea  path="name" id="name" name="name" rows="4" cols="50"/></td>
      <td><form:hidden path="id" id="id" name="id"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Update"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>

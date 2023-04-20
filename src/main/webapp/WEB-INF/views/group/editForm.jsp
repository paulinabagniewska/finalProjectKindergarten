<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST"
           action="/group/update"   modelAttribute ="group">
  <table>
    <tr>
      <td><form:label path="name">Group Name</form:label></td>
      <td><form:textarea  path="name" id="name" name="name" rows="4" cols="50"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Update"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>

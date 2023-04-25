<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Menu Edit Form</title>
  <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<form:form method="POST"
           action="/menu/update"  modelAttribute="menu">
  <table>
    <tr>
      <td><form:label path="date">Date</form:label></td>
      <td><form:input path="date" id="date" type="date"/></td>
      <td><form:hidden path="id" id="id" name="id"/></td>
    </tr>
    <tr>
      <td><form:label path="breakfast">Breakfast</form:label></td>
      <td><form:textarea  path="breakfast" id="breakfast" name="breakfast" rows="4" cols="50"/></td>
    </tr>
    <tr>
      <td><form:label path="secondBreakfast">Second Breakfast</form:label></td>
      <td><form:textarea  path="secondBreakfast" id="secondBreakfast" name="secondBreakfast" rows="4" cols="50"/></td>
    </tr>
    <tr>
      <td><form:label path="lunch">Lunch</form:label></td>
      <td><form:textarea  path="lunch" id="lunch" name="lunch" rows="4" cols="50"/></td>
    </tr>
    <tr>
      <td><form:label path="dessert">Dessert</form:label></td>
      <td><form:textarea  path="dessert" id="dessert" name="dessert" rows="4" cols="50"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Save Menu"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>

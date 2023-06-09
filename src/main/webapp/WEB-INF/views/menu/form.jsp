<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
     <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<h3>Welcome, Enter The Menu Details</h3>

<form:form method="POST"
           action="/menu/add"   modelAttribute ="menu">
  <table>
    <tr>
      <td><form:label path="date">Date</form:label></td>
      <td><form:input path="date" id="date" type="date"/></td>
    </tr>
    <tr>
      <td><form:label path="breakfast">Breakfast</form:label></td>
      <td><form:input path="breakfast" id="breakfast" type="text"/></td>
    </tr>
    <tr>
      <td><form:label path="secondBreakfast">Second Breakfast</form:label></td>
      <td><form:input path="secondBreakfast" id="secondBreakfast" type="text"/></td>
    </tr>
    <tr>
      <td><form:label path="lunch">Lunch</form:label></td>
      <td><form:input path="lunch" id="lunch" type="text"/></td>
    </tr>
    <tr>
      <td><form:label path="dessert">Dessert</form:label></td>
      <td><form:input path="dessert" id="dessert" type="text"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Save Menu"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>

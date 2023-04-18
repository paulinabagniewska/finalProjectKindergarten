<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h3>Welcome, Enter The Menu Details</h3>

<form:form method="POST"
           action="/menu/save"   modelAttribute ="menu">
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
      <td><form:label path="secondbreakfast">Second Breakfast</form:label></td>
      <td><form:input path="secondBreakfast" id="secondbreakfast" type="text"/></td>
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

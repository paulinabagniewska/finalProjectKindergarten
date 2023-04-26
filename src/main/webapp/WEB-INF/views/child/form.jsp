<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Child form</title>
    <link rel="stylesheet" type="text/css" href="/css/form.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<h3>Welcome, Enter The Child details</h3>

<form:form method="POST"
           action="/child/add"   modelAttribute ="child">
  <table>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name" id="name" type="text"/></td>
    </tr>
    <tr>
      <td><form:label path="surname">Surname</form:label></td>
      <td><form:input path="surname" id="surname" type="text"/></td>
    </tr>
    
    <tr>
      <td><form:label path="group">Group</form:label></td>
      <td><form:select path="group" id="group" name="group.id">
        <form:option value="">Select a group</form:option>
        <c:forEach items="${groups}" var="group">
          <form:option value="${group.id}">${group.name}</form:option>
        </c:forEach>
      </form:select></td>
    </tr>
    <tr>
      <td><form:label path="parent">Parent</form:label></td>
      <td><form:select path="parent"  id="group" name="parent.id">
        <form:option value="">Select a parent</form:option>
        <c:forEach items="${parents}" var="parent">
          <form:option value="${parent.id}">${parent.name} ${parent.surname}</form:option>
        </c:forEach>
      </form:select></td>
    </tr>
    <tr>
      <td><input type="submit" value="Save"/></td>
    </tr>
  </table>
</form:form>
</body>
</html>

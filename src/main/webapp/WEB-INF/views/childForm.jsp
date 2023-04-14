
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Child form</title>
</head>
<body>
<body>
<h1>Child Form</h1>
<form method="post" action="/child/add">
  <label for="id">ID:</label>
  <input type="text" id="id" name="id" value="">
  <br>
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="">
  <br>
  <label for="surname">Surname:</label>
  <input type="text" id="surname" name="surname" value="">
  <br>
  <label for="group">Group:</label>
  <select id="group" name="group.id">
    <option value="">Select a group</option>
    <c:forEach items="${groupList}" var="group">
      <option value="${group.id}">${group.name}</option>
    </c:forEach>
  </select>
  <br>
  <label for="parent">Parent:</label>
  <select id="parent" name="parent.id">
    <option value="">Select a parent</option>
    <c:forEach items="${parentList}" var="parent">
      <option value="${parent.id}">${parent.name} ${parent.surname}</option>
    </c:forEach>
  </select>
  <br>
  <input type="submit" value="Save">
</form>
</body>
</html>

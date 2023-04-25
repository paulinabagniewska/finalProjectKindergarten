<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Menu List</title>
  <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<table>
  <tr>
    <th>Id</th>
    <th>Date</th>
    <th>Breakfast</th>
    <th>Second breakfast</th>
    <th>Lunch</th>
    <th>Dessert</th>
  </tr>
  <c:forEach items="${menuList}" var="menu">
    <tr>
      <td>${menu.id}</td>
      <td>${menu.date}</td>
      <td>${menu.breakfast}</td>
      <td>${menu.secondBreakfast}</td>
      <td>${menu.lunch}</td>
      <td>${menu.dessert}</td>

  </c:forEach>
</table>
</body>
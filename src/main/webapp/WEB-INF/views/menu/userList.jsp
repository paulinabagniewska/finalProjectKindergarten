<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Menu List</title>
  <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
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

  <tr>
    <td> <a href="/user/loggedIn"> Main Menu </a></td>
  </tr>
</table>
</body>
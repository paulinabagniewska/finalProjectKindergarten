<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Announcement List</title>
</head>
<body>
<table>
  <tr>
    <th>Id</th>
    <th>Description</th>
  </tr>
  <c:forEach items="${announcements}" var="announcement">
    <tr>
      <td>${announcement.id}</td>
      <td>${announcement.description}</td>
      <td> <a href="/announcement/update/${announcement.id}">Edit</a>
        <td> <a href="/announcement/delete/${announcement.id}" >Delete</a>
      </td>
    </tr>
  </c:forEach>
  <tr>
    <td>
    <td> <a href="/announcement/add/${announcement.id}">Add New Announcement</a></td>
    </td>
  </tr>
</table>
</body>
</html>

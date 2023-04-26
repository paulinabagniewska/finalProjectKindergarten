<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/list.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
  <tr>
    <th>Id</th>
    <th>Login</th>
    <th>Password</th>
  </tr>
  <c:forEach items="${userList}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.login}</td>>
      <td>${user.password}</td>

      <td> <a href="/user/update/${parent.id}">Edit</a>
      <td> <a href="/user/delete/${parent.id}" >Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

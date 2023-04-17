
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Announcement Form</title>
</head>
<body>
<h1>Announcement </h1>
<form method="post" action="/announcement/add">
  <label for="description">Description:</label>
  <input type="text" id="description" name="description" value="">
  <br>
  <input type="submit" value="Save">
</form>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Menu Form</h1>
<form action="AddMenu" method="post">
  <label for="date">Data:</label>
  <input type="date" id="date" name="date" required><br><br>
  <label for="breakfast">Śniadanie:</label>
  <input type="text" id="breakfast" name="breakfast" required><br><br>
  <label for="secondBreakfast">Drugie śniadanie:</label>
  <input type="text" id="secondBreakfast" name="secondBreakfast"><br><br>
  <label for="lunch">Obiad:</label>
  <input type="text" id="lunch" name="lunch" required><br><br>
  <label for="dessert">Deser:</label>
  <input type="text" id="dessert" name="dessert"><br><br>
  <input type="submit" value="Add Menu">
</form>
</body>
</html>

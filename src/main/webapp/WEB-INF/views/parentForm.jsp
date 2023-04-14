
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parent</title>
</head>
<body>
<h1>Formularz Parent</h1>
<form action="AddParent" method="post">
    <label for="name">Imię:</label>
    <input type="text" id="name" name="name" required><br><br>
    <label for="surname">Nazwisko:</label>
    <input type="text" id="surname" name="surname" required><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>
    <label for="phone">Telefon:</label>
    <input type="text" id="phone" name="phone" required><br><br>
    <input type="submit" value="Add Parent">
</form>
</body>
</html>

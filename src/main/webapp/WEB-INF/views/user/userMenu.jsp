
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Parent</title>
    <link rel="stylesheet" type="text/css" href="/css/userMenu.css">
</head>
<body>
<center> <img src="/images/kindergartenapp-high-resolution-color-logo.png" width="50%"></center>
<h3>Welcome to your child's kindergarten app!</h3>
<h3>Below you can report your child's absence on a given day.</h3>
<h3>You can also view the menu and announcements.</h3>
<h3>Enjoy!</h3>

    <tr>
        <td> <a href="/menu/userList">Menu List</a> </td>
        <td> <a href="/absence/add">Add New Absence</a></td>
        <td> <a href="/absence/userList">List of Absences</a></td>
        <td><a href="/announcement/userList"> Announcements List</a></td>
    </tr>


<tr>
    <td> <a href="/user/logoutUser"> Logout </a></td>
</tr>

</body>
</html>

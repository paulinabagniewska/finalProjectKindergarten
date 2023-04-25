
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Menu</title>
    <link rel="stylesheet" type="text/css" href="/css/adminMenu.css">
</head>
<body>
<h3>Welcome in Admin Menu!</h3>
    <h3>Here you can manage your kindergarten.</h3>
        <h3>Below you have the option to manage the data of Parents and Children.</h3>
            <h3>You can also manage your kindergarten's Groups and Menu.</h3>
<table>
    <tr>
        <td> <a href="/absence/list/${absences}">Absences</a></td>

        <td><a href="/announcement/list/${announcements}"> Announcements</a></td>

        <td><a href="/child/list/${children}">Children </a> </td>

        <td><a href="/group/list/${groups}">Group </a> </td>

        <td> <a href="/menu/list/${menuList}">Menu </a> </td>

        <td><a href="/parent/list/${parents}">Parents </a></td>
    </tr>
</table>
</body>
</html>

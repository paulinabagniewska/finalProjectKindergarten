
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Menu</title>
</head>
<body>
<table>
        <td> <a href="/absence/list/${absences}">Absences</a></td>
    </tr>
    <tr>
    <td><a href="/announcement/list/${announcements}"> Announcements</a></td>
    </tr>
    <tr>
        <td><a href="/child/list/${children}">Children </a> </td>
    </tr>
    <tr>
        <td><a href="/group/list/${groups}">Group </a> </td>
    </tr>
    <tr>
        <td> <a href="/menu/list/${menuList}">Menu </a> </td>
    <tr>
    <tr>
        <td><a href="/parent/list/${parents}">Parents </a></td>
    </tr>

</table>
</body>
</html>

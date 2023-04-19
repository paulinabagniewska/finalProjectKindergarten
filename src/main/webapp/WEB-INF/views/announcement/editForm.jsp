<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
</head>
<body>
<form:form method="POST"
           action="/announcement/update"   modelAttribute ="announcement">
    <table>
        <tr>
            <td><form:label path="description">
                Description</form:label></td>
            <td><form:textarea  path="description" id="description" name="description" rows="4" cols="50"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring Boot + JSP</title>
</head>
<body>
<h2>Employee Info</h2>
<table>
    <tr>
        <td>Id: </td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Contact Number: </td>
        <td>${employee.contactNumber}</td>
    </tr>
    <tr>
        <td>Office: </td>
        <td>${employee.office}</td>
    </tr>
</table>
</body>
</html>
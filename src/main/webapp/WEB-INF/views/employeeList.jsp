<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>
<h2>Employees</h2>
<button><a href="/employee">Add</a></button>
<form action="/employee">
    <input type="button" value="Add">
</form>
<table border="1">
    <tr>
        <th>Id</th>
        <th>name</th>
        <th>Contact number</th>
        <th>Office</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.contactNumber}</td>
            <td>${employee.office}</td>
            <td><a href="/employees-delete?id=${employee.id}">Delete</a></td>
            <td><a href="/employees-update?id=${employee.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
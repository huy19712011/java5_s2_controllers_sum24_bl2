<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring Boot + JSP</title>
</head>
<body>
<form:form method="post" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssStyle="color: red"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Contact Number</form:label></td>
            <td><form:input path="contactNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="office">Office</form:label></td>
            <td><form:input path="office"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
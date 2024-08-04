<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Form Example - Register an Employee</title>
</head>
<body>
<h3>Welcome, Enter The Customer Details</h3>
<form:form method="POST" modelAttribute="customer">
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
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
                <%--            <td><label>Country</label></td>--%>
            <td><form:label path="country">Country</form:label></td>
            <td>
                <select name="country">
                    <c:forEach items="${countries}" var="country">
                        <option value="${country.id}">${country.name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
            <%--        <tr>--%>
            <%--            <td><form:label path="country">Country</form:label></td>--%>
            <%--            <td>--%>
            <%--                <form:select path="country" items="${countries}" itemValue="id" itemLabel="name">--%>
            <%--                </form:select>--%>
            <%--            </td>--%>
            <%--        </tr>--%>
        <tr>
            <td><form:label path="country">Country</form:label></td>
            <td>
                <form:select path="country">
                    <form:option value="---"></form:option>
                    <form:options items="${countries}" itemLabel="name" itemValue="id"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

</body>

</html>
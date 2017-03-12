<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<h1>Edit User</h1>
<c:url var="editUser" value="/users/add"/>
<form:form action="${editUser}" commandName="user">
    <table>
        <tbody>
        <tr>
            <td>ID</td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Age</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>Admin</td>
            <td><form:input path="admin"/></td>
        </tr>
        </tbody>
    </table>
    <td colspan="2">
        <input type="submit"
               value="<spring:message text="Edit User"/>"/>
    </td>
</form:form>
</body>
</html>

<%-- 
    Author     : Alexander Lebed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактировать</title>
        <style type="text/css">
        body { text-align: center}
        table {margin: 0px auto;}
        </style>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Измените данные, чтобы редактировать информацию о служащем</caption>
        <tr>
            <th>Выберите должность</th>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Email</th>
            <th>Подтвердить</th>
        </tr>
        <form action="doneEdit.html" method="POST">
        <td>
            <select name="roleId">
                <option selected value="${emp.getRoleId()}">
                    <c:if test="${emp.getRoleId() == 2}">HR</c:if>
                    <c:if test="${emp.getRoleId() == 3}">Tech</c:if>
                    <c:if test="${emp.getRoleId() == 4}">Admin</c:if>
                </option>
                <option value="2">HR</option>
                <option value="3">Tech</option>
                <option value="4">Admin</option>
            </select>
        </td>
        <td><input type="hidden" name="employeeId" value="<c:out value='${emp.getUserId()}'/>"/>${emp.getUserId()}</td>
        <td><input type="text" name="firstName" value="<c:out value='${emp.getFirstName()}'/>"/></td>
        <td><input type="text" name="lastName" value="<c:out value='${emp.getLastName()}'/>"/></td>
        <td><input type="text" name="email" value="<c:out value='${emp.getEmail()}'/>"/></td>
        <td><input type="submit" value="Ok"><input type=button value="Cancel" onCLick="history.back()"></td>
        </form>
        </table>
    </body>
</html>

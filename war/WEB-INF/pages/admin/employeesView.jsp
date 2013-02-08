<%-- 
    Author     : Alexander Lebed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Employees</caption>
        <tr>
            <th>Должность</th>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Email</th>
            <th>Пароль</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        <c:forEach items="${employees}" var="emp">
            <form action="employees.html" method="POST">
                <tr>
                    <td>
                        <c:if test="${emp.getRoleId() == 2}"><b>HR</b></c:if>
                        <c:if test="${emp.getRoleId() == 3}"><b>Tech</b></c:if>
                        <c:if test="${emp.getRoleId() == 4}"><b>Admin</b></c:if>
                    </td>
                    <td>${emp.getUserId()}</td>
                    <td>${emp.getFirstName()}</td>
                    <td>${emp.getLastName()}</td>
                    <td>${emp.getEmail()}</td>
                    <td>${emp.getPassword()}</td>
                    <td><a href="editEmployee.html?employee=<c:out value='${emp.getUserId()}'/>">редактировать</a></td>
                    <td><a href="deleteEmployee.html?employee=<c:out value='${emp.getUserId()}'/>">удалить</a></td>
                </tr>
            </form>
            </c:forEach>
        
        </table>
    </body>
</html>

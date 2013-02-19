<%-- 
    Author     : Alexander Lebed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Служащие</title>
    </head>
    <body>
        <form action="sortedEmployees.html" method="POST">
        <tr>
            <!-- radio buttons "role" -->
             <td><input type="radio" name="role" value="0" checked>Все</td>
             <td><input type="radio" name="role" value="2">HR</td>
             <td><input type="radio" name="role" value="3">Tech</td>
             <td><input type="radio" name="role" value="4">Admin</td>
             <td>
                 <!-- check box "byWhat" -->
                <select name="byWhat">
                    <option selected value="ALL">Показать всех</option>
                    <option value="FULL_NAME">По имени и фамилии</option>
                    <option value="FIRST_NAME">По имени</option>
                    <option value="LAST_NAME">По фимилии</option>
                    <option value="EMAIL">По email</option>
                </select>
             </td>
             <!-- text box "textValue" -->
             <td><input type="text" name="textValue"></td>
             <td><input type="submit" value="Поиск"></td>
        </tr>
        </form>
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Список служащих</caption>
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
                    <td><a href="editEmployee.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\edit.png"  width="25" height="25" border="0" title="Редактировать"/></a></td>
                    <td><a href="deleteSure.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\del.jpg"  width="25" height="25" border="0" title="Удалить"/></a></td>
                </tr>
            </form>
            </c:forEach>
        </table>
        <!-- Выдача сообщения в случае нулевого результата -->
        <c:if test="${employees.isEmpty()}"> ${noResults} </c:if>
        
        <br><a href="addEmloyee.html">Добавить служащего</a>
    </body>
</html>

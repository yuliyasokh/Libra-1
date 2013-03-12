<%-- 
    Author     : Alexander Lebed

- radio buttons "role" for filtering by a job title
- check box "byWhat" for searching by a full name, first name, last name, email
- links like "sortEmployees.html?orderBy..." for sorting by a job title, ID, 
    first name, last name, email, password in ascending or descending order
- displaying the employees by searhing/filtering/sorting (HR, Tech.interviewer, Administrator)
    all employees by default
- editing employee
- remote employee
- change employee's password
- addition employee

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Служащие</title>
        <style type="text/css">
        body { text-align: center}
        table {margin: 0px auto;}
        </style>
    </head>
    <body>
        <form action="sortedEmployees.html" method="POST">
        <tr>
            <!-- radio buttons "role" -->
             <td><input type="radio" name="role" value="0" ${checkedAll}>Все</td>
             <td><input type="radio" name="role" value="2" ${checkedHR}>HR</td>
             <td><input type="radio" name="role" value="3" ${checkedTech}>Tech</td>
             <td><input type="radio" name="role" value="4" ${checkedAdmin}>Admin</td>
             <td>
                 <!-- check box "byWhat" -->
                <select name="byWhat">
                    <option ${selectedAll} value="ALL">Показать всех</option>
                    <option ${selectedFull} value="FULL_NAME">По имени и фамилии</option>
                    <option ${selectedFirst} value="FIRST_NAME">По имени</option>
                    <option ${selectedLast} value="LAST_NAME">По фимилии</option>
                    <option ${selectedEmail} value="EMAIL">По email</option>
                </select>
             </td>
             <!-- text box "textValue" -->
             <td><input type="text" name="textValue" value="${text}"></td>
             <!-- submit button -->
             <td><input type="submit" value="Поиск"></td>
        </tr>
        </form>
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Список служащих</caption>
        <tr>
            <th><a href="sortEmployees.html?orderBy=FIRST_NAME">Имя</a> <a href="sortEmployees.html?orderBy=LAST_NAME">Фамилия</a></th>
            <th><a href="sortEmployees.html?orderBy=ID">ID</a></th>
            <th><a href="sortEmployees.html?orderBy=ROLE">Должность</a></th>
            <th><a href="sortEmployees.html?orderBy=EMAIL">Email</a></th>
            <th>Пароль</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        <c:forEach items="${employees}" var="emp">
            <form action="employees.html" method="POST">
                <tr>
                    <td>${emp.getFirstName()} ${emp.getLastName()}</td>
                    <td>${emp.getUserId()}</td>
                    <td>
                        <c:if test="${emp.getRoleId() == 2}"><b>HR</b></c:if>
                        <c:if test="${emp.getRoleId() == 3}"><b>Tech</b></c:if>
                        <c:if test="${emp.getRoleId() == 4}"><b>Admin</b></c:if>
                    </td>
                    
                    
                    <td>${emp.getEmail()}</td>
                    <td><a href="changeEmployeePassword.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\edit.png"  width="25" height="25" border="0" title="Сменить пароль"/></a></td>
                    <td><a href="editEmployee.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\edit.png"  width="25" height="25" border="0" title="Редактировать"/></a></td>
                    <td><a href="deleteSure.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\del.jpg"  width="25" height="25" border="0" title="Удалить"/></a></td>
                </tr>
            </form>
            </c:forEach>
        </table>
        <!-- Issuing message when no results -->
        <c:if test="${employees.isEmpty()}"> ${noResults} </c:if>
        
        <br><a href="addEmployee.html">Добавить служащего</a>
        
        <br><br>${message}
        
    </body>
</html>

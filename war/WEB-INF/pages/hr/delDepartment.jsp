<%-- 
    Document   : delDepartment
    Created on : 23.02.2013, 15:26:26
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление кафедрами - Удаление</title>
    </head>
    <body>
       <h2>Удаление кафедры</h2>
        Вы действительно хотите удалить кафедру?
        <form  action="deletedDepartments.html" method="post">
        <table border ="1">
            <tr>
                <td>№ кафедры </td>
                <td>Кафедра</td>
                <td>Факультет</td>
                <td>Университет</td>
            </tr>
           <c:forEach items="${depts}" var="d">
                <tr>
                    <input type="hidden" name="departmentId" value="<c:out value='${d.departmentId}'/>" />
                    <td><c:out value="${d.departmentId}"/> </td>
                    <td><c:out value="${d.departmentName}"/> </td>
                    <td><c:out value="${d.facultyName}"/></td>
                    <td><c:out value="${d.universityName}"/></td>
                </tr>
        </c:forEach >
        </table>          
            <input type="submit" value="Удалить" name="delete">
        </form>
        <br>
        <input value="Назад" onclick="location.href='showDepartments.html'" type="button"/>
    </body>
</html>

<%-- 
    Document   : showDepartments
    Created on : 22.02.2013, 12:05:03
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление кафедрами</title>
    </head>
        <body>
        <br>
        <center>
        <a href="addDepartments.html">Добавить новую кафедру</a>
        <br>
        <br>
        <center> 
            <form name="myForm" action="showDepartmentsSearch.html" method="get">
        <select name="departmentSearch">
            <option value="0"> - </option>
            <option value="1">№ кафедры </option>
            <option value="2">Кафедра</option>
            <option value="3">Факультет</option>
            <option value="4">Университет</option>
        </select>
        <input type="text" name ="textBox">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <center>
        <table border ="1">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>№ кафедры </td>
                <td>Кафедра</td>
                <td>Факультет</td>
                <td>Университет</td>
            </tr>
           <c:forEach items="${depts}" var="d">
                <tr>
                    <td><a href= "delDepartment.html?departmentId=<c:out value='${d.departmentId}'/> ">удалить</a> </td>
                    <td><a href="editDepartment.html?departmentId=<c:out value='${d.departmentId}'/>">править</a></td>
                    <td><c:out value="${d.departmentId}"/></td>
                    <td><c:out value="${d.departmentName}"/></td>
                    <td><c:out value="${d.facultyName}"/></td>
                    <td><c:out value="${d.universityName}"/></td>
                </tr>
        </c:forEach>
        </table>
       
    </body>
</html>

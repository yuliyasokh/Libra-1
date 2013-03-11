<%-- 
    Document   : showDepartmentsSearch
    Created on : 22.02.2013, 12:46:47
    Author     : Yuliya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление кафедрами - Поиск</title>
    </head>
        <body>
        <br>
        <center>
        <a href="addDepartments.html?textBox=<c:out value='${textBoxString}'/>&departmentSearch=<c:out value='${departmentSearchInt}'/>">
            Добавить новую кафедру
        </a>
        <br>
        <br>
            <form name="myForm" action="showDepartmentsSearch.html" method="get">
        <select name="departmentSearch">
            <option value="0" ${departmentSearchInt == '0' ? 'selected' : ''}>Все </option>
            <option value="1" ${departmentSearchInt == '1' ? 'selected' : ''}>№ кафедры </option>
            <option value="2" ${departmentSearchInt == '2' ? 'selected' : ''}>Кафедра</option>
            <option value="3" ${departmentSearchInt == '3' ? 'selected' : ''}>Факультет </option>
            <option value="4" ${departmentSearchInt == '4' ? 'selected' : ''}>Университет</option>
        </select>
                <input type="text" name ="textBox" value="${textBoxString}">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <table border ="1">
            <tr>               
                <td>№ кафедры </td>
                <td>Кафедра</td>
                <td>Факультет</td>
                <td>Университет</td>
                <td>Править</td>
                <td>Удалить</td>
            </tr>
           <c:forEach items="${depts}" var="d">
                <tr>                  
                    <td><c:out value="${d.departmentId}"/></td>
                    <td><c:out value="${d.departmentName}"/></td>
                    <td><c:out value="${d.facultyName}"/></td>
                    <td><c:out value="${d.universityName}"/></td>
                    <td>
                        <a href="editDepartment.html?departmentId=<c:out value='${d.departmentId}'/>">
                            править
                        </a>
                    </td>
                    <td>
                        <a href= "delDepartment.html?departmentId=<c:out value='${d.departmentId}'/> ">
                            удалить
                        </a> 
                    </td>
                </tr>
        </c:forEach>
        </table>
       </center>
    </body>
</html>

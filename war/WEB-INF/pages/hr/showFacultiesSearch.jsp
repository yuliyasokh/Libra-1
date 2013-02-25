<%-- 
    Document   : showFacultiesSearch
    Created on : 22.02.2013, 11:30:13
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление факультетами - Поиск </title>
    </head>
    <body>
        <br>
        <center>
        <a href="addFaculties.html">Добавить новый факультет</a>
        <br>
        <br>
        <center> 
            <form name="myForm" action="showFacultiesSearch.html" method="get">
        <select name="facultySearch">
            <option value="0" ${facultySearchInt == '0' ? 'selected' : ''}> - </option>
            <option value="1" ${facultySearchInt == '1' ? 'selected' : ''}>№ факультета </option>
            <option value="2" ${facultySearchInt == '2' ? 'selected' : ''}>Факультет </option>
            <option value="3" ${facultySearchInt == '3' ? 'selected' : ''}>Университет</option>
        </select>
                <input type="text" name ="textBox" value="${textBoxString}">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <center>
        <table border ="1">
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>№ факультета </td>
                <td>Факультет</td>
                <td>Университет</td>
            </tr>
           <c:forEach items="${facts}" var="f">
                <tr>
                    <td><a href= "delFaculty.html?facultyId=<c:out value='${f.facultyId}'/> ">удалить</a> </td>
                    <td><a href="editFaculty.html?facultyId=<c:out value='${u.facultyId}'/>">править</a></td>
                    <td><c:out value="${f.facultyId}"/></td>
                    <td><c:out value="${f.facultyName}"/></td>
                    <td><c:out value="${f.universityName}"/></td>
                </tr>
        </c:forEach>
        </table>
       
    </body>
</html>

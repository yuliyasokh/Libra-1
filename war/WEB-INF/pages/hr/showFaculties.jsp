<%-- 
    Document   : showFaculties
    Created on : 20.02.2013, 9:26:47
    Author     : Yuliya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление факультетами</title>
    </head>
    <body>
        <br>
        <center>
        <a href="addFaculties.html">Добавить новый факультет</a>
        <br>
        <br>
        <center> 
            <h3>${msg}</h3>
            <form name="myForm" action="showFacultiesSearch.html" method="get">
        <select name="facultySearch">
            <option value="0"> - </option>
            <option value="1">№ факультета </option>
            <option value="2">Факультет</option>
            <option value="3">Университет</option>
        </select>
        <input type="text" name ="textBox">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
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
                    <td><a href="editFaculty.html?facultyId=<c:out value='${f.facultyId}'/>">править</a></td>
                    <td><c:out value="${f.facultyId}"/></td>
                    <td><c:out value="${f.facultyName}"/></td>
                    <td><c:out value="${f.universityName}"/></td>
                </tr>
        </c:forEach>
        </table>
        </center>
    </body>
</html>

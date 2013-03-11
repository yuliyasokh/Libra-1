<%-- 
    Document   : addUniversities
    Created on : 22.02.2013, 13:14:51
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление университетами - Добавить университет </title>
    </head>
    <body>
        <center>
            <h3>${msg}</h3>
            <form name="Form" action="addUniversitiesAdded.html" method="get">
                Введите название университета: 
                <input type="text" name ="univerName">
                <input type="submit" value="Добавить" name="add">
            </form><br>
        <form name="myForm" action="showUniversitiesSearch.html" method="get">
        <select name="univerSearch">
            <option value="0"  ${univerSearchInt == '0' ? 'selected' : ''}>Все </option>
            <option value="1"  ${univerSearchInt == '1' ? 'selected' : ''}>№ университета </option>
            <option value="2"  ${univerSearchInt == '2' ? 'selected' : ''}>Университет</option>
        </select>
        <input type="text" name ="textBox" value="${textBox}">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <table border ="1">
            <tr>
                <td>№ университета </td>
                <td>Университет</td>
                <td>Править</td>
                <td>Удалить</td>
            </tr>
           <c:forEach items="${univers}" var="u">
                <tr>
                    <td><c:out value="${u.universityId}"/></td>
                    <td><c:out value="${u.universityName}"/></td>
                    <td>
                        <a href="editUniversity.html?universityId=<c:out value='${u.universityId}'/>">
                            править
                        </a>
                    </td>
                    <td>
                        <a href= "delUniversity.html?universityId=<c:out value='${u.universityId}'/> ">
                            удалить
                        </a> 
                    </td>
                </tr>
        </c:forEach>
        </table>
        </center>
    </body>
</html>

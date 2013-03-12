<%-- 
    Document   : showUniversities
    Created on : 20.02.2013, 17:45:27
    Author     : Yuliya
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление университетами</title>
    </head>
    <body>
        <br>
        <center>
        <a href="addUniversities.html">Добавить новый университет</a>
        <br>
        <br>
            <h3>${msg}</h3>
        <form name="myForm" action="showUniversitiesSearch.html" method="get">
        <select name="univerSearch">
            <option value="0">Все </option>
            <option value="1">№ университета </option>
            <option value="2">Университет</option>
        </select>
        <input type="text" name ="textBox">
        <input type="submit" value="Показать" name="search"> </form>
        <br><br>
        <table border ="1">
            <tr>
                <td>№ университета </td>
                <td>Университет</td>
                <td>Правка</td>
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

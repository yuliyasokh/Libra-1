<%-- 
    Document   : delUniversity
    Created on : 23.02.2013, 0:18:08
    Author     : Yuliya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление универами - Удаление</title>
    </head>
    <body>
        <h2>Удаление университета</h2>
        Вы действительно хотите удалить университет, все его факультеты и кафедры?
        <form  action="deletedUniversities.html" method="post">
        <table border ="1">
            <tr>
                <td>№ университета </td>
                <td>Университет</td>
            </tr>
           <c:forEach items="${univers}" var="u">
               <tr>
               <input type="hidden" name="universityId" value="<c:out value='${u.universityId}'/>" />
                    <td><c:out value="${u.universityId}"/></td>
                    <td><c:out value="${u.universityName}"/></td>
                </tr>
        </c:forEach>
        </table>
            <input type="submit" value="Удалить" name="delete">
        </form>
        <br>
        <input value="Назад" onclick="location.href='showUniversities.html'" type="button"/>

    </body>
</html>

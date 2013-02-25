<%-- 
    Document   : editUniversity
    Created on : 23.02.2013, 16:33:04
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление университетами - Правка</title>
    </head>
    <body>
        <center>
        <h2>Редактирование университета</h2>
         <center>
        <h3>${msg}</h3>
         <center>
        <form method="POST" action="editedUniversity.html">
         <table border="1" cellspacing="0" cellpadding="4">
             <tr>
                 <td>№ университета</td>
                  <td>Университет</td>
             </tr>
             <c:forEach items="${u}" var="u">
        <td>
            <label for="universityId">${u.universityId}</label>
        <input type="hidden" name="universityId" value="<c:out value='${u.universityId}  '/>"/></td>
        <td>
            <input type="text" name="universityName" value="${u.universityName}"/></td>
        </c:forEach>
        </table>
             <center>
         <input type="submit" name="submitUniversity" value="Изменить">
         </form>
        <br>
        <br>
         <center>
        <input value="Назад" onclick="location.href='showUniversities.html'" type="button"/>

    </body>
</html>

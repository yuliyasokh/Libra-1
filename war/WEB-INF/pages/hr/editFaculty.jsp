<%-- 
    Document   : editFaculty
    Created on : 23.02.2013, 18:23:53
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление факультетами - Правка</title>
    </head>
    <body>
        <center>
        <h2>Редактирование факультета</h2>
        <h3>${msg}</h3>
        <form method="POST" action="editedFaculty.html">
         <table border="1" cellspacing="0" cellpadding="4">
             <tr>
                 <td>№ факультета</td>
                  <td>Факультет</td>
                  <td>Университет</td>
             </tr>
             <c:forEach items="${f}" var="f"> 
        <td><label for="facultyId">${f.facultyId}</label>
        <input type="hidden" name="facultyId" value="<c:out value='${f.facultyId}  '/>"/></td>
        <td><input type="text" name="facultyName" value="${f.facultyName}"/></td>
        </c:forEach>
        <td><select name="univ">
            <c:forEach items="${selectedUniv}" var="ff"> 
            <option value="${ff.universityId}" selected> ${ff.universityName} </option>
             </c:forEach>
            <c:forEach items="${unselectedUniv}" var ="u">
            <option value="${u.universityId}"> ${u.universityName} </option>
                </c:forEach> 
            </select>
        </td>
       
        </table>
         <input type="submit" name="submitFaculty" value="Изменить">
         </form>
        <br>
        <br>
        
        <input value="Назад" onclick="location.href='showFaculties.html'" type="button"/>
        </center>
    </body>
</html>


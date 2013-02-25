<%-- 
    Document   : editDepartment
    Created on : 24.02.2013, 0:33:12
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление кафедрами - Правка</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript" charset="utf-8">   
</script>
        <script>
            function getFact(){
            $.post("faculty.html",{"universityId":$("#univ").val() },
                function(data) {
                   $("#fact").html(data);
                }   
               );
            }
        </script>
    </head>
    <body>
    <center>        
        <h2>Редактирование кафедры</h2>
        <h3>${msg}</h3>
        <form method="POST" action="editedDepartment.html">
         <table border="1" cellspacing="0" cellpadding="4">
             <tr>
                  <td>№ кафедры</td>
                  <td>Кафедра</td>
                  <td>Факультет</td>
                  <td>Университет</td>
             </tr>
             <c:forEach items="${depts}" var="d"> 
        <td><label for="departmentId">${d.departmentId}</label>
        <input type="hidden" name="departmentId" value="<c:out value='${d.departmentId}  '/>"/></td>
        <td><input type="text" name="departmentName" value="${d.departmentName}"/></td>
        </c:forEach>
        <td>
            <select name="fact" id="fact">
             <c:forEach items="${selFacts}" var="ff"> 
            <option value="${ff.facultyId}" selected> ${ff.facultyName} </option>
             </c:forEach>
            <c:forEach items="${unselFacts}" var ="u">
            <option value="${u.facultyId}"> ${u.facultyName} </option>
                </c:forEach>  
        </select>
        </td>
        <td><select name="univ"  onchange="getFact();" id="univ">
            <c:forEach items="${selectedUniv}" var="ff"> 
            <option value="${ff.universityId}" selected> ${ff.universityName} </option>
             </c:forEach>
            <c:forEach items="${unselectedUniv}" var ="u">
            <option value="${u.universityId}"> ${u.universityName} </option>
                </c:forEach> 
            </select>
        </td>       
        </table>
         <input type="submit" name="submitdepartment" value="Изменить">
         </form>
        <br>
        <br>
        
        <input value="Назад" onclick="location.href='showDepartments.html'" type="button"/>
    </center>
        
    </body>
</html>

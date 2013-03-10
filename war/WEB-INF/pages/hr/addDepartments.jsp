<%-- 
    Document   : addDepartments
    Created on : 22.02.2013, 17:09:44
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление кафедрами - Добавить кафедру</title>
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
        <form name="Form" action="addDepartmentAdded.html" method="get">
                Введите название кафедры: 
                <input type="text" name ="deptName">
                Выберите университет: 
                <select onchange="getFact();" name="univ" id="univ">
                    <option value="0"> - </option> 
                    <c:forEach items="${univers}" var="u">
                    <option value="${u.universityId}"> ${u.universityName}  
                    </option> 
                    </c:forEach>  
                </select> 
                <br>
                Факультет:
                <select name="fact" id="fact">
                    <option value="0"> Выберите университет </option> 
                </select>
                    <br>
                <input type="submit" value="Добавить" name="add">
            </form>
        <br>
        <br>
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
        <table border ="1">
            <tr>            
                <td>№ кафедры </td>
                <td>Кафедра</td>
                <td>Факультет</td>
                <td>Университет</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
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

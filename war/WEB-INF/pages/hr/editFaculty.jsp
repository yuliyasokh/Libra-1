<%-- 
    Document   : editFaculty
    Created on : 23.02.2013, 18:23:53
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
    <head>
        <jsp:include page="../resources.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление факультетами - Правка</title>
        <link rel="stylesheet" type="text/css" href="../resources/css/table.css" />
    </head>
    <body>
        <div class="navmenu">
		<jsp:include page="../navbar.jsp" />
	</div>
	
	<div class="container-fluid">
		<div class="row-fluid">
		<div class="sidebar">
				<jsp:include page="../sidebar.jsp" />
			</div>
			<div class="span9">
				<div class="hero-unit">
        <center>
        <h2>Редактирование факультета</h2>
        <h3>${msg}</h3>
        <form method="POST" action="editedFaculty.html">
         <table border="1" class="bordered">
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
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>


<%-- 
    Document   : delFaculty
    Created on : 23.02.2013, 14:24:58
    Author     : Yuliya
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <title>Управление факультетами - Удаление</title>
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
       <h2>Удаление факультета</h2>
        Вы действительно хотите удалить факультет и все его кафедры?
        <form  action="deletedFaculties.html" method="post">
        <table border ="1">
            <tr>
                <td>№ факультета </td>
                <td>Факультет</td>
                <td>Университет</td>
            </tr>
           <c:forEach items="${facts}" var="f">
                <tr>
                  <input type="hidden" name="facultyId" value="<c:out value='${f.facultyId}'/>" />
                    <td><c:out value="${f.facultyId}"/> </td>
                    <td><c:out value="${f.facultyName}"/></td>
                    <td><c:out value="${f.universityName}"/></td>
                </tr>
        </c:forEach >
        </table>
        <br>
        Количество кафедр: ${countDept}<br>
        При удалении этого факультета также удаляется студенты, которые на нем учатся!<br>
        Количество студентов: ${countStudents}
        <br>
        <br>
        <input value="Назад" onclick="location.href='showFaculties.html'" type="button"/>
            <input type="submit" value="Удалить" name="delete">
        </form>        
        </center>
                                </div>
                        </div>
                </div>
        </div>
        </body>
    
</html>
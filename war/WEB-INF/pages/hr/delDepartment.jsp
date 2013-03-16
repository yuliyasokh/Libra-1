<%-- 
    Document   : delDepartment
    Created on : 23.02.2013, 15:26:26
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
        <title>Управление кафедрами - Удаление</title>
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
       <h2>Удаление кафедры</h2>
        Вы действительно хотите удалить кафедру?
        <form  action="deletedDepartments.html" method="post">
        <table border ="1">
            <tr>
                <td>№ кафедры </td>
                <td>Кафедра</td>
                <td>Факультет</td>
                <td>Университет</td>
            </tr>
           <c:forEach items="${depts}" var="d">
                <tr>
                    <input type="hidden" name="departmentId" value="<c:out value='${d.departmentId}'/>" />
                    <td><c:out value="${d.departmentId}"/> </td>
                    <td><c:out value="${d.departmentName}"/> </td>
                    <td><c:out value="${d.facultyName}"/></td>
                    <td><c:out value="${d.universityName}"/></td>
                </tr>
        </c:forEach >
        </table><br>
        При удалении это кафедры также удаляется студенты, которые на ней учатся!<br>
        Количество студентов: ${countStudents}
        <br><br>
        <input value="Назад" onclick="location.href='showDepartments.html'" type="button"/>
            <input type="submit" value="Удалить" name="delete">
        </form>        
        </center>
                                </div>
                        </div>
                </div>
        </div>
        </body>
</html>

<%-- 
    Document   : delUniversity
    Created on : 23.02.2013, 0:18:08
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
        <title>Управление универами - Удаление</title>
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
        </table><br>
        Количество факультетов: ${countFact}<br>
        Количество кафедр: ${countDept}<br>
        При удалении этого университета также удаляется студенты, которые в нем учатся!<br>
        Количество студентов: ${countStudents}<br>
        <br>
           <input value="Назад" onclick="location.href='showUniversities.html'" type="button"/> 
           <input type="submit" value="Удалить" name="delete">
        </form>
        
        </center>
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>

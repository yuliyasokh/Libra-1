<%-- 
    Author     : Alexander Lebed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->

<html class="no-js">
<!--<![endif]-->
<head>
	<jsp:include page="../resources.jsp" />
	
	<title>Удалить?</title>
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
			<!-- Removal request -->
        <form action="deleteEmployee.html" method="GET">
            <b>Вы уверены что хотите удалить служащего с именем <c:out value='${emp.getFirstName()}'/> <c:out value='${emp.getLastName()}'/>?</b>
                <input type="hidden" name="employeeId" value="<c:out value='${emp.getUserId()}'/>"/>
                <br><input type="submit" style="height: 25px; width: 100px" value="Да"/><input type=button style="height: 25px; width: 100px" value="Нет" onCLick="history.back()">
        </form>
			</div>
		</div>
	</div>
</body>
</html>
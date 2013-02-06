<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Регистрация - шаг 2</title>
<meta name="description" content="Libra">
<link rel="stylesheet" href="<c:url value="resources/css/main.css"/>" />
<link rel="stylesheet"
	href="<c:url value="resources/css/bootstrap-responsive.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="resources/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="resources/css/style.css"/>" />

<script src="<c:url value="resources/js/jquery-1.9.0.min.js" />"></script>
<script
	src="<c:url value="resources/js/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>
</head>
<body>
		<div class="span3">
			
			<form:form method="PUT" commandName="appForm" action="interests.html">
			
					<label>Электронный адрес для входа в систему</label>
					<form:input path="email" type="text" class="span3" />
					<label>Дополнительный электронный адрес</label>
					<form:input path="email2" type="text" class="span3" />
					<label>Номер телефона</label>
					<form:input path="phoneNumber" type="text" class="span3"/>
					<label>Другое</label>
					<form:input path="miscContact" type="text" class="span3" />
					<br>
					
	    			<input type="submit" value="Далее" class="btn btn-primary">
				</form:form>
				
		</div>
</body>
</html>
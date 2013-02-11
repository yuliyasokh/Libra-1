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
<title>Регистрация</title>
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
	<div class="container">

		<form:form method="POST" commandName="registerForm" action="register/proceed.html">
			<h2>Добро пожаловать</h2>
			<h5>Вы ввели следующую информацию: </h5>
			<table>
				<tr>
					<td><strong>Фамилия: </strong> ${registerForm.lastName}</td>
				</tr>
				<tr>
					<td><strong>Имя: </strong>${registerForm.name}</td>
				</tr>
				<tr>
					<td><strong>Email: </strong>${registerForm.email}</td>
				</tr>
			</table>
			<br>
			<span>На ваш электронный адрес было отправлено письмо с кодом подтверждения</span>
			<br><br>							
			<span>Пожалуйста, введите код из письма <form:input path="enteredCode" type="text" class="span3" /></span>
			
				
	
				<div class="form-actions">
					<button type="submit" class="btn pull-left">Вернуться</button>
  					<button type="submit" class="btn btn-primary pull-right">Далее</button>
				</div>
		</form:form>

	</div>
</body>
</html>
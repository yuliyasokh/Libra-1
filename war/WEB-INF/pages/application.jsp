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
<title>Libra :: Анкета кандидата</title>
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
			<form:form method="POST" commandName="signupForm">

					<form:input path="lastName" type="text" placeholder="Фамилия" class="span3" />
					<form:input path="name" type="text" placeholder="Имя" class="span3"/>

					<form:input path="email" type="email" placeholder="Электронная почта" class="span3" />
					<form:input path="phoneNumber" type="tel" placeholder="Номер телефона" class="span3" />

					<form:input path="university" type="text" placeholder="ВУЗ" class="span3" />
					<form:input path="faculty" type="text" placeholder="Факультет" class="span3" />

					<form:input path="univerTerm" type="text" placeholder="Курс" class="span3" />
					<form:input path="graduated" type="text" placeholder="Год окончания" class="span3" />
					
	    			<input type="submit" value="Sign up" class="btn btn-primary pull-right">
    				<div class="clearfix"></div>
				</form:form>
		</div>
</body>
</html>
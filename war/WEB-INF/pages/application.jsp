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

	<div class="wrapper">
		<div class="formContainer">
			<form:form method="POST" commandName="signupForm">
			<table>
					
				<tr>
					<td>
						<fieldset>
							<form:input path="lastName" type="text" placeholder="Фамилия" class="input-medium" />
							<form:input path="name" type="text" placeholder="Имя" class="input-medium"/>
						</fieldset>
					</td>	
				</tr>

				<tr>
					<td>
						<fieldset>
							<form:input path="email" type="email" placeholder="Электронная почта" />
							<form:input path="phoneNumber" type="tel" placeholder="Номер телефона" />
						</fieldset>
					</td>
				</tr>

				<tr>
					<td>
						<fieldset>
							<form:input path="university" type="text" placeholder="ВУЗ" />
							<form:input path="faculty" type="text" placeholder="Факультет" />
						</fieldset>
					</td>
				</tr>
				
				<tr>
					<td>
						<fieldset>
							<form:input path="univerTerm" type="text" placeholder="Курс" class="input-mini" />
							<form:input path="graduated" type="text" placeholder="Год окончания" class="input-mini" />
						</fieldset>
					</td>
				</tr>
				

				
				<tr>
					<td>
						<div class="form-actions">
							<button type="submit" class="btn btn-primary">Save changes</button>
							<button type="button" class="btn">Cancel</button>
						</div>
					</td>
				</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>
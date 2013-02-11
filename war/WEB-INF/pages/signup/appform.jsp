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
<meta name="description" content="Libra">
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script src="<c:url value="/resources/js/jquery-1.9.0.min.js" />"></script>
<script src="<c:url value="/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>
<title>Регистрация</title>
</head>
<body>
	<div class="container">
				<h3>Анкета кандидата (1/2)</h3>
		<form:form commandName = "appForm" method="POST" action="appform2.html">
			
				<div class="row">	
					<div class="span4">
						<h5>Личные данные:</h5>
						<div class="controls controls-row">
							<span class="span2 uneditable-input">${registerForm.lastName}</span>
							<span class="span2 uneditable-input">${registerForm.name}</span>
						</div>
							<input class="span4" name="patronymic" placeholder="Отчество" type="text"/>
							<input class="span4" name="phoneNumber" placeholder="Номер телефона" type="text"/>
							<input class="span4" name="otherContacts" placeholder="Другие контакты" type="text"/>
					</div>
					<div class="span1"></div>
					<div class="span4">

						<h5>Образование:</h5>
							<input class="span4" name="university" placeholder="Название университета" type="text"/>
  							<input class="span4" name="faculty" placeholder="Факультет" type="text"/>
  						<div class="controls controls-row">
							<input class="span2" name="term" placeholder="Курс" type="text"/>
							<input class="span2" name="graduated" placeholder="Год выпуска" type="text">
						</div>
					</div>
				</div>
				<div class="row"><br></div>
				<div class="row">
					<div class="span4">
						<h5>Укажите, что вас заинтересовало:</h5>
						<c:forEach var="t" items="${appForm.whatsInterestedList}">
							<label class="checkbox">${t.value} <form:checkbox path="interests" value="${t.key}"></form:checkbox></label>
						</c:forEach>
						<label class="checkbox"><form:checkbox path="interests" value="otherOccupation"></form:checkbox>
						<form:input path="interests" placeholder="Другое"></form:input>
						</label>
					</div>
					<div class="span1"></div>
					<div class="span4">
						<h5>Укажите предпочитаемый тип работы:</h5>
						<c:forEach var="r" items="${appForm.workTypeList}">
							<label class="checkbox">${r.value} <form:checkbox path="workType" value="${r.key}"></form:checkbox></label>
						</c:forEach>
						<label class="checkbox"><form:checkbox path="interests" value="otherOccupation"></form:checkbox>
						<form:input path="workType" placeholder="Другое"></form:input>
						</label>
					</div>
				</div>
					<div class="span9">
						<div class="form-actions">
							<button type="reset" class="btn pull-left">Назад</button>
  							<button type="submit" class="btn btn-primary pull-right">Далее</button>
						</div>
					</div>
		</form:form>
	</div>
</body>
</html>
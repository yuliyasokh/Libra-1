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
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script src="<c:url value="/resources/js/jquery-1.9.0.min.js" />"></script>
<script
	src="<c:url value="/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>

<title>Регистрация</title>
</head>
<body>
	<div class="container">
		<h3>Анкета кандидата (1/2)</h3>
		<form:form commandName="appForm" method="POST" action="success.html" enctype="multipart/form-data">

			<c:forEach var="blocksList" items="${grade}">
				<div class="span8">
					<h5>${blocksList.value.header}:</h5>
					<c:forEach items="${blocksList.value.values}" var="valueMap">
						<label> <span class="span7">${valueMap.value}</span> <input
							class="span1" type="number" min="0" max="5" step="1"
							name="gradeAnswers['${valueMap.key}']" value="${valueMap.value}"
							required />
						</label>
					</c:forEach>
					<div class="span1"></div>
				</div>
			</c:forEach>

			<div class="row">
				<c:forEach var="blocksList" items="${checkbox}">
					<div class="span4">
						<h5>${blocksList.value.header}:</h5>
						<c:forEach items="${blocksList.value.values}" var="valueMap">
							<label class="checkbox">${valueMap.value} <input
								type="checkbox" 
								name="checkboxAnswers['${valueMap.value}']"
								value="${blocksList.value.blockID}" />
							</label>					
						</c:forEach>
					</div>
				</c:forEach>
			</div>


			<c:forEach var="blocksList" items="${textFields}">
				<div class="span8">
					<h6>${blocksList.value.header}:</h6>
					<label> <textarea
							name="textFieldsAnswers['${blocksList.value.blockID}']"
							class="span8" rows="2"></textarea>
					</label>
				</div>
			</c:forEach>

			<div class="span8">
				<div class="form-actions">
					<button type="reset" class="btn pull-left">Назад</button>
					<button type="submit" class="btn btn-primary pull-right">Далее</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
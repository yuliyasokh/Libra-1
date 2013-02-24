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
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-fileupload.min.css"/>" />
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
<script src="<c:url value="/resources/js/jquery-1.9.0.min.js" />"></script>
<script
	src="<c:url value="/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-fileupload.min.js"/>"></script>
<title>Регистрация</title>
</head>
<body>
	<div class="container">
		<h3>Анкета кандидата (1/2)</h3>
		<form:form commandName="appForm" method="POST" action="step2.html"
			enctype="multipart/form-data">

			<div class="row">

				<div class="span4">
					<h5>Фотография</h5>
					<div class="fileupload fileupload-new" data-provides="fileupload" required>
						<div class="fileupload-new thumbnail"
							style="width: 250px; height: 320px;">
							<img
								src="http://www.placehold.it/250x320/EFEFEF/AAAAAA&text=no+image" />
						</div>
						<div class="fileupload-preview fileupload-exists thumbnail"
							style="max-width: 250px; max-height: 320px; line-height: 20px;"></div>
						<div>
							<span class="btn btn-file"><span class="fileupload-new">Обзор..</span><span
								class="fileupload-exists">Изменить</span> <input name="photo"
								type="file" /></span> <a href="#" class="btn fileupload-exists"
								data-dismiss="fileupload">Remove</a>
						</div>
					</div>
				</div>

				<div class="span4">
					<h5>Личные данные:</h5>
					<div class="controls controls-row">
						<span class="span2 uneditable-input">${registerForm.lastName}</span>
						<span class="span2 uneditable-input">${registerForm.name}</span>
					</div>
					<input class="span4" name="personal['patronymic${personal.value}']"
						placeholder="Отчество" type="text" required/> 
						
						<input class="span4"
						name="personal['phoneNumber${personal.value}']"
						placeholder="Номер телефона" type="text" required />
						<!--   
						<input class="span4"
						name="personal['otherContact${personal.value}']"
						placeholder="Другие контакты" type="text" required/>
						-->
					<div class="row">

						<div class="span4"></div>

						<div class="span4">

							<h5>Образование:</h5>

							<form:select required="1" class="span4"
								path="personal['university${personal.value}']">
								<option value="" disabled selected>Университет</option>
								<form:options items="${appForm.getUniversityList()}" />
							</form:select>

							<form:select required="1" class="span4"
								path="personal['faculty${personal.value}']">
								<option value="" disabled selected>Факультет</option>
								<form:options items="${appForm.getFacultyList()}" />
							</form:select>

							<form:select required="1" class="span4"
								path="personal['departmentid${personal.value}']">
								<option value="" disabled selected>Кафедра</option>
								<form:options items="${appForm.getDepartmentList()}" />
							</form:select>

							<div class="controls controls-row">
								<input class="span2" name="personal['course${personal.value}']"
									placeholder="Курс" type="number" min="0" max="5" /> <input
									class="span2" name="personal['graduated${personal.value}']"
									placeholder="Год выпуска" type="number" min="2000" max="2020">
							</div>
						</div>
					</div>
				</div>
			</div>

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
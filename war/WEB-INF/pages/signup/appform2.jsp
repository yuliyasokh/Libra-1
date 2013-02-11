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
				<h3>Анкета кандидата (2/2)</h3>
				
		<form:form commandName = "appForm" method="POST" action="success.html">
		
				<div class="row">	
					<div class="span5">
						<h5>Владение языками программирования</h5>
						<br>1 - писал простые программы с книгой\справкой 
						<br>3 - хорошо помню синтаксис и некоторые библиотеки 
						<br>5 - написал крупный проект 
						<br><br>
							<label><span class="span4">Java</span><input class="span1" name="javaGrade" type="text"/></label>
							<label><span class="span4">C++</span><input class="span1" name="cGrade" type="text"/></label>
							<label><span class="span4">C#</span><input class="span1" name="otherLanguageGrade" type="text"/></label>
							<label><span class="span4">.NET</span><input class="span1" name="otherLanguage2Grade" type="text"/></label>
							<label><span class="span4">Python</span><input class="span1" name="otherLanguage3Grade" type="text"/></label>
					</div>
					<div class="span1"></div>
						<div class="span5">
						<h5>Как ты оцениваешь свои знания по разделам (от 0 до 5):</h5>
						
							<label><span class="span4">Сетевые технологии:</span> <input class="span1" type="text"/></label>
  							<label><span class="span4">Эффективные алгоритмы:</span> <input class="span1" type="text"/></label>
							<label><span class="span4">Объектно-ориентированное программирование:</span> <input class="span1" type="text"/></label>
							<label><span class="span4">Базы данных:</span> <input class="span1" type="text"/></label>
							<label><span class="span4">WEB:</span> <input class="span1" type="text"/></label>
  							<label><span class="span4">Графический интерфейс (не WEB):</span> <input class="span1" type="text"/></label>
							<label><span class="span4">Сетевое программированое:</span> <input class="span1" type="text"/></label>
							<label><span class="span4">Проектирование программ:</span> <input class="span1" type="text"/></label>
					</div>
				</div>
				
				<div class="row"></div>
				
				<div class="row">

				</div>
				
		
				<div class="row"><br></div>
					<div class="row">	
						
						<div class="span5">
							<h5>Владение английским языком (от 1=elementary до 5=advanced)</h5>
							<label><span class="span4">Чтение:</span> <input class="span1" type="text"/></label>
  							<label><span class="span4">Письмо:</span> <input class="span1" type="text"/></label>
							<label><span class="span4">Устная речь:</span> <input class="span1" type="text"/></label>
						</div>
						
						<div class="span1"></div>
						
						<div class="span5">
							<h5>Если у тебя есть опыт работы и\или выполненные учебные проекты, опиши их</h5>
							<textarea rows="3" class="span5"></textarea>
						</div>
					</div>
					
				<div class="row">
					<div class="span5">
						<h5>Почему именно тебя следует взять в NetCracker? Важные достоинства, возможно обещания?</h5>
							<textarea rows="3" class="span5"></textarea>
					</div>
					
					<div class="span1"></div>
					
					<div class="span5">
						<h5>Дополнительные сведения о себе: олимпиады, курсы, поощрения, сертификаты и т.п.</h5>
							<textarea rows="3" class="span5"></textarea>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="span5">
						<label>Откуда ты узнал о наборе в учебный центр?</label>
					</div>
					
					<div class="span1"></div>
					
					<div class="span5">
						<input name="advert" type="text" class="span5">
					</div>
				</div>	
					
					<div class="span11">
						<div class="form-actions">
							<button type="reset"  class="btn pull-left">Назад</button>
  							<button type="submit" class="btn btn-primary pull-right">Далее</button>
						</div>
					</div>
		</form:form>
	</div>
</body>
</html>
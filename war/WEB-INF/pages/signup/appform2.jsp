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
			
				<div class="span4">
					<h6>Владение языками программирования</h6>
						1 - писал простые программы с книгой\справкой 
						<br>3 - хорошо помню синтаксис и некоторые библиотеки 
						<br>5 - написал крупный проект 
						<br><br>
					<c:forEach items="${appForm.programmingLanguagesList}" var="l" varStatus="status">	
								<label>
									<span class="span3">${l}</span>
									<input class="span1" 
										required 
										name="programmingLanguagesMap['${l}${programmingLanguagesMap.value}']" 
										type="number" 
										min="0" max="5"/>
								</label>
					</c:forEach>
				</div>		
				
				<div class="span1"></div>
				
				<div class="span4">
				
					<h6>Как ты оцениваешь свои знания по разделам (от 0 до 5):</h6>
					<c:forEach items="${appForm.knowledgesList}" var="m" varStatus="status">
							
								<label>
									<span class="span3">${m}</span>
									<input class="span1" 
									name="knowledgesMap['${m}${knowledgesMap.value}']" 
									required 
									type="number"
									min="0" max="5"/>
								</label>
							
						<div class="span1"></div>
					</c:forEach>
				</div>
				
				<div class="span1"></div>
				
					<c:forEach items="${appForm.textFieldsList}" var="t">
							<div class="span4"><h6>${t}</h6>
								<textarea name="textFieldsMap['${t}${textFieldsMap.value}']" class="span4" rows="2"></textarea>
							</div>
						<div class="span1"></div>
					</c:forEach>
					
				<div class="span4">
					<h6>Владение английским языком (от 1=elementary до 5=advanced)</h6>
					<div class="row">
						<span class="span1"><label>Чтение:</label></span>
						<span class="span1"><label>Письмо:</label></span>
						<span class="span2"><label>Устная речь:</label></span>
					</div>
					<div class="row">
						<c:forEach items="${appForm.englishGradesMap}" var="el">
						<span class="span1"><input name="englishGradesMap['${m}${knowledgesMap.value}']" class="span1" type="number" min="0" max="5"/></span>
						</c:forEach>
					</div>
				</div>
				
				<div class="span4">
					<h6>Откуда ты узнал о наборе в учебный центр?</h6>
					<input name="advert" type="text" class="span4">
				</div>
					
				</div>
			<div class="span9">
				<div class="form-actions">
					<button type="reset"  class="btn pull-left">Назад</button>
  					<button type="submit" class="btn btn-primary pull-right">Далее</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
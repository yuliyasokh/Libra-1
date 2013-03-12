<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<jsp:include page="resources.jsp" />
<title>Добро пожаловать</title>
</head>
<body>

	<div class="navmenu">
		<jsp:include page="navbar.jsp" />
	</div>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<jsp:include page="sidebar.jsp" />
			</div>
			<div class="span9">
				<div class="hero-unit">
					<h1>Libra&nbsp;</h1>
					<p>Войдите или зарегистрируйтесь.</p>
					<p>
						<button class="btn btn-large btn-primary" type="button">Вход</button>
						<button class="btn btn-large btn-success" type="button">Регистрация</button>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
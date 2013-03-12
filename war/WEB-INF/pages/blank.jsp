<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->

<html class="no-js">
<!--<![endif]-->
<head>
	<jsp:include page="resources.jsp" />
	
	<title><!-- YOUR PAGE TITLE HERE --></title>
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
			<!-- YOUR CONTENT HERE  -->
			</div>
		</div>
	</div>
</body>
</html>
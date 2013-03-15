<%-- 
    Document   : doneDate
    Created on : 13.02.2013, 5:46:16
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
    <head>
        <jsp:include page="../resources.jsp" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successful edited</title>
    </head>
    <body>
        <div class="navmenu">
		<jsp:include page="../navbar.jsp" />
	</div>
	
	<div class="container-fluid">
		<div class="row-fluid">
		<div class="sidebar">
				<jsp:include page="../sidebar.jsp" />
			</div>
			<div class="span9">
				<div class="hero-unit">
        <h2>Дата успешно изменена</h2>
        <input value="Назад" onclick="location.href='interviewDate.html'" type="button"/>
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>

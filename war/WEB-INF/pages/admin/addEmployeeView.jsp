<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->

<html class="no-js">
<!--<![endif]-->
<head>
	<jsp:include page="../resources.jsp" />
	<title>ADD</title>
        <style type="text/css">
        body {text-align: center;}
        </style>
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
                            
                            <form class="form-horizontal" action="doneAdd.html" method="POST">
                                
                                <div class="control-group">
                                    <div class="controls">
                                    <select name="roleId">
                                        <option value="2">HR</option>
                                        <option selected value="3">TECH</option>
                                        <option value="4">ADMIN</option>
                                    </select>
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" name="firstName" placeholder="Имя">
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" name="lastName" placeholder="Фамилия">
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" name="email" placeholder="Эл. почта">
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="password" name="password" placeholder="Пароль">
                                    </div>
                                </div>
                                
                                <div class="control-group">
                                    <div class="controls">
                                        <button class="btn btn-success" type="submit"><i class="icon-white icon-ok"></i> Add</button>
                                        <button type=button class="btn" onClick="parent.location='currentEmployees.html'">Cancel</button>
                                    </div>
                                </div>
                                
                            </form>
                            
                            
                    </div>
            </div>
    </div>
</body>
</html>
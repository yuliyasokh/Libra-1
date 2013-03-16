<%-- 
    Author     : Alexander Lebed
--%>

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
	
	<title>Редактировать</title>
        <style type="text/css">
        select {
            width:100px;
        }
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
                            
	<table class="table">
        <caption>Измените данные, чтобы редактировать информацию о служащем</caption>
        <tr>
            <th>Должность</th>
            <th>ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Email</th>
            <th>Подтвердить</th>
        </tr>

        <form action="doneEdit.html" method="POST">
        <td>
            <select name="roleId">
                <option selected value="${emp.getRoleId()}">
                    <c:if test="${emp.getRoleId() == 2}">HR</c:if>
                    <c:if test="${emp.getRoleId() == 3}">Tech</c:if>
                    <c:if test="${emp.getRoleId() == 4}">Admin</c:if>
                </option>
                <option value="2">HR</option>
                <option value="3">Tech</option>
                <option value="4">Admin</option>
            </select>
        </td>
        <td><input type="hidden" name="employeeId"/>${emp.getUserId()}</td>
        <td><input class="input-medium" type="text" name="firstName" value="<c:out value='${emp.getFirstName()}'/>"/></td>
        <td><input class="input-medium" type="text" name="lastName" value="<c:out value='${emp.getLastName()}'/>"/></td>
        <td><input class="input-medium" type="text" name="email" value="<c:out value='${emp.getEmail()}'/>"/></td>
        <td><button type="submit" class="btn btn-primary">Ok</button><button type=button class="btn" onCLick="history.back()">Cancel</button></td>
        </form>
        </table>
			</div>
		</div>
	</div>
</body>
</html>
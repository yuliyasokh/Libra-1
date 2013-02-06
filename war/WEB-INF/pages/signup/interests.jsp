<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Интересы</title>
</head>
<body>
	<h2>Интересы</h2>
 
	<form:form method="PUT" commandName="appForm" action="advantages.html">
		<table>

			<tr>
				<td>Что заинтересовало:</td>
				<td>
                	<form:checkbox path="internshipValue" value="1" />Стажировка
                	<form:checkbox path="workInCompanyValue" value="1" />Работа в компании
                	<form:checkbox path="studyCenterValue" value="1" />Учебный центр
               </td>
			</tr>
			
			<tr>
				<td>Интересующая область деятельности:</td>
				<td>
                	<form:checkbox path="softwareDevelopmentValue" value="1" />Разработка ПО
                	<form:checkbox path="otherOccupationValue" value="1" />Другое
               </td>
			</tr>
			
			<tr>
				<td>Тип работы: </td>
				<td>                	
					<form:checkbox path="deepSpec" value="1" />Глубокая специализация
                	<form:checkbox path="variousWork" value="1" />Разнообразная работа
                	<form:checkbox path="management" value="1" />Управление специалистами
                	<form:checkbox path="sales" value="1" />Продажи
                	<form:checkbox path="customWorkType" value="1" />Другое
				<td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
 
</body>
</html>
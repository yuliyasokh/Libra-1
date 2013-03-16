<%-- 
    Author     : Alexander Lebed

- radio buttons "role" for filtering by a job title
- check box "byWhat" for searching by a full name, first name, last name, email
- links like "sortEmployees.html?orderBy..." for sorting by a job title, ID, 
    first name, last name, email, password in ascending or descending order
- displaying the employees by searhing/filtering/sorting (HR, Tech.interviewer, Administrator)
    all employees by default
- editing employee
- remote employee
- change employee's password
- addition employee

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
	<title>Служащие</title>
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
                            
	<form class="form-inline" action="sortedEmployees.html" method="POST">   
        <tr>
             <!-- radio buttons "role" -->
            <td><label class="radio"><input type="radio" name="role" value="0" ${checkedAll}>ALL &nbsp;</label></td>
            <td><label class="radio"><input type="radio" name="role" value="2" ${checkedHR}>HR &nbsp;</label></td>
            <td><label class="radio"><input type="radio" name="role" value="3" ${checkedTech}>TECH &nbsp;</label></td>
            <td><label class="radio"><input type="radio" name="role" value="4" ${checkedAdmin}>ADMIN &nbsp;</label></td>
             <td>
                 <!-- check box "byWhat" -->
                <select name="byWhat">
                    <option ${selectedAll} value="ALL">Показать всех</option>
                    <option ${selectedFull} value="FULL_NAME">По имени и фамилии</option>
                    <option ${selectedFirst} value="FIRST_NAME">По имени</option>
                    <option ${selectedLast} value="LAST_NAME">По фимилии</option>
                    <option ${selectedEmail} value="EMAIL">По email</option>
                </select>
             </td>
             <td><input type="text" placeholder="Введите значение" name="textValue" value="${text}"></td>
             <td><button class="btn btn-primary"><i class="icon-white icon-search"></i> Поиск</button></td>
        </tr>
        <br><br>
        </form>
             
        <table class="table">
        <caption>Список служащих</caption>
        <tr>
            <th><a href="sortEmployees.html?orderBy=FIRST_NAME">Имя</a> и <a href="sortEmployees.html?orderBy=LAST_NAME">фамилия</a></th>
            <th><a href="sortEmployees.html?orderBy=ID">ID</a></th>
            <th><a href="sortEmployees.html?orderBy=ROLE">Должность</a></th>
            <th><a href="sortEmployees.html?orderBy=EMAIL">Email</a></th>
            <th>Пароль</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td>${emp.getFirstName()} ${emp.getLastName()}</td>
                <td>${emp.getUserId()}</td>
                <td>
                    <c:if test="${emp.getRoleId() == 2}"><b>HR</b></c:if>
                    <c:if test="${emp.getRoleId() == 3}"><b>TECH</b></c:if>
                    <c:if test="${emp.getRoleId() == 4}"><b>ADMIN</b></c:if>
                </td>
                <td>${emp.getEmail()}</td>
                <form action="changedEmployeePassword.html" method="POST">
                <c:choose>
                <c:when test="${id != emp.getUserId()}">
                    <td><a href="changeEmployeePassword.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\edit.png"  width="25" height="25" border="0" title="Сменить пароль"/></a></td>
                </c:when>
                <c:otherwise> 
                        <!--
                        <div class="form-actions"> 
                            <button type="submit" class="btn btn-primary">Save changes</button>
                            <button type="button" class="btn">Cancel</button>
                        </div>
                        
                        <div class="input-append">
                        <input class="span2" id="appendedInputButtons" type="text">
                        <button class="btn" type="button">Search</button>
                        <button class="btn" type="button">Options</button>
                        </div>
                        
                        <input type="text" placeholder="Введите значение" name="textValue" value="${text}">
                        <td><button class="btn btn-success"><i class="icon-white icon-search"></i> Поиск</button></td>
                        -->
                        
                        <td><div class="input-append"><input class="input-small" type="password" name="passwordValue"><button type="submit" class="btn btn-primary">Ok</button><button type=button class="btn" onCLick="history.back()">Cancel</button></div></td>
                    <input type="hidden" name="employeeId" value="${emp.getUserId()}">
                </c:otherwise>
                </c:choose>
                </form>
                <td><a href="editEmployee.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\edit.png"  width="25" height="25" border="0" title="Редактировать"/></a></td>
                <td><a href="deleteSure.html?employeeId=<c:out value='${emp.getUserId()}'/>"><img src="resources\images\del.jpg"  width="25" height="25" border="0" title="Удалить"/></a></td>
            </tr>
        </c:forEach>
        </table>
        <!-- displaying the message when no results -->
        <c:if test="${employees.isEmpty()}"> ${noResults} </c:if>
        
        <br><a href="addEmployee.html">Добавить служащего</a>
        
			</div>
		</div>
	</div>
</body>
</html>
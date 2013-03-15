<%-- 
    Document   : showStudentbyIdView
    Created on : 04.02.2013, 0:42:45
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
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
        <title>Поиск студентов</title>
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
      <center>
        <h1>Список студентов</h1>
        <h3>${msg}</h3>
       <TABLE border ="1">
        Фильтр  
        <form method="post" action="showStudentbyIdView.html">
        <select name="filter">
        <option value="1" ${filterInt == '1' ? 'selected' : ''}>Показать всех</option>
        <option value="2" ${filterInt == '2' ? 'selected' : ''}>Номер анкеты</option>
        <option value="3" ${filterInt == '3' ? 'selected' : ''}>Имя</option>
        <option value="4" ${filterInt == '4' ? 'selected' : ''}>Фамилия</option>
        <option value="5" ${filterInt == '5' ? 'selected' : ''}>Email</option>
        <option value="6" ${filterInt == '6' ? 'selected' : ''}>По всем полям</option>
</select>
   <form method="GET">
    <input type="text" name="textBox" value="${textBox}">
    <input type="submit" value="Поиск">
            </form>
    <br><br> 
    <form method="GET">
    <th>
        <a href="sortedBy.html?orderBy=appId&direction=asc&textBox=<c:out value='${textBox}'/>&filter=<c:out value='${filterInt}'/>">№ анкеты
        </a>
    </th>
    <th>
        <a href="sortedBy.html?orderBy=firstName&textBox=<c:out value='${textBox}'/>&filter=<c:out value='${filterInt}'/>">Имя
        </a>
    </th>
    <th><a href="sortedBy.html?orderBy=lastName&textBox=<c:out value='${textBox}'/>&filter=<c:out value='${filterInt}'/>">Фамилия
        </a>
    </th>
   <th><a href="sortedBy.html?orderBy=email&textBox=<c:out value='${textBox}'/>&filter=<c:out value='${filterInt}'/>">Email
       </a>
   </th>
            <th></th>
            <th></th>
            <th></th>
    </form>
    <c:forEach items="${Model}" var="s">
    <tr>
        <form action="showStudentInterview.html" method="POST">
            <td><input type="hidden" name="appId" value="<c:out value='${s.getAppId()}'/>"/>${s.getAppId()}</td>
            <td><input type="hidden" name="firstName" value="<c:out value='${s.getName()}'/>"/>${s.getName()}</td>
            <td><input type="hidden" name="lastName" value="<c:out value='${s.getLastName()}'/>"/>${s.getLastName()}</td>
            <td><input type="hidden" name="email" value="<c:out value='${s.getEmail()}'/>"/>${s.getEmail()}</td>
            <input type="hidden" name="view" value="0"/>
            <td> <input type="submit" value="Анкета"></td>
          
                <td> <input type="submit" value="Интервью"></td>
          </form>
      <td> <input type="submit" value="Удалить"></td>
  </tr>
    </c:forEach>
    </TABLE>
    <h3>${msg1}</h3>
             </center>    
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>
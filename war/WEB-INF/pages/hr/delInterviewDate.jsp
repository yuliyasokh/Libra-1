<%-- 
    Document   : delInterviewDate
    Created on : 07.02.2013, 15:22:35
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Удаление даты интервью</title>
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
        <h2>Вы действительно хотите удалить дату интервью? </h2>
        <br>
        <form method="post" action="deletedInterviewDate.html">
        <table border="1" cellspacing="0" cellpadding="4">
          <tr>
            <th>№ даты</th>
            <th>Тип</th>
            <th>Дата</th>
            <th>Время</th>
            <th>Продолжительность</th>
            <th>Интервьюеры</th>
            <th>Править</th>
          </tr>
        <c:forEach items="${Model}" var="d">
        <tr>
        
        <td>
            <c:out value="${d.interviewDateId}"/>
            <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}'/>" />
        </td>
        <td><c:out value="${d.typeInterview}"/></td>
        <td><c:out value="${d.dateInter}"/></td>
        <td><c:out value="${d.timeInter}"/></td>
        <td><c:out value="${d.interviewDuration}"/></td>
        <td><c:out value="${d.listInterviewers}"/></td>
        <td>
          <a href="editInterkviewDate.html?interviewDateId=<c:out value='${d.interviewDateId}'/>&type=<c:out value='${d.typeInterview}'/> ">
              править
          </a>
        </td>
        </tr> 
        </c:forEach>
        </table>
            <br>
            При удалении этой даты будут также удалены все связанные с ней данные: <br>
            Записи об интервью: ${delInterview}<br>
            Отзывы интервьеров: ${delInterviewResults} <br>
            <br>
            <input value="Назад" onclick="location.href='interviewDate.html'" type="button"/>
            <input type="submit" value="Удалить" name="delete">
          </form>
        
        </center>
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>

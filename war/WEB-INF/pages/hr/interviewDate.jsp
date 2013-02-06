<%-- 
    Document   : interviewDate
    Created on : 05.02.2013, 0:34:43
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interview Schedule</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="4">
          <caption>Информация о рассписании собеседований</caption>
            <th>Удалить</th>
            <th>Изменить</th>
            <th>№ даты</th>
            <th>Начало</th>
            <th>Конец</th>
            <th>Продолжительность</th>
            <th>Интервьюеры</th>
    <c:forEach items="${Model}" var="d">
    <tr>
     <td>
         <%---- <a href="deleteInterviewDate.html?date=<c:out value='${d.interviewDateId()} '/>"> --%>
          <img src="del.png"  width="25" height="25" border="0" title="delete"/>
      </td>
      <td></td>
      <td><c:out value="${d.interviewDateId}"/></td>
      <td><c:out value="${d.dateStart}"/></td>
      <td><c:out value="${d.dateFinish}"/></td>
      <td><c:out value="${d.interviewDuration}"/></td>
      <td><c:out value="${d.listInterviewers}"/></td>
  </tr>
    </c:forEach>
    </TABLE>
    </body>
</html>

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
            <th>№ даты</th>
            <th>Начало</th>
            <th>Конец</th>
            <th>Продолжительность</th>
    <c:forEach items="${Model}" var="d">
    <tr>
      <td><c:out value="${d.interviewDateId}"/></td>
      <td><c:out value="${d.dateStart}"/></td>
      <td><c:out value="${d.dateFinish}"/></td>
      <td><c:out value="${d.interviewDuration}"/></td>
  </tr>
    </c:forEach>
    </TABLE>
    </body>
</html>

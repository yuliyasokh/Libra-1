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
        <title>Управление датами интервью</title>
    </head>
    <body>
        <center>
            <a href="interviewDateAdd.html">Добавить новую дату интервью</a>
            <br>
            <br>
         <h2 align="center">Информация о рассписании собеседований</h2><br> 
          <form method="GET" action="delInterviewDate.html">
        <table border="1" cellspacing="0" cellpadding="4">
            <th>Удалить</th>
            <th>Править</th>
            <th>№ даты</th>
            <th>Дата</th>
            <th>Время</th>
            <th>Продолжительность</th>
            <th>Интервьюеры</th>
            <th>Уведомить</th>
    <c:forEach items="${Model}" var="d">
    <tr>
     <td>
         
       <a href="delInterviewDate.html?interviewDateId=<c:out value='${d.interviewDateId} '/>">
         удалить
         <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}  '/>"/></a>
        </td>
      <td><a href="editInterviewDate.html?interviewDateId=<c:out value='${d.interviewDateId}'/>">править</a></td>
      <td><c:out value="${d.interviewDateId}"/></td>
      <td><c:out value="${d.dateInter}"/></td>
      <td><c:out value="${d.timeInter}"/></td>
      <td><c:out value="${d.interviewDuration}"/></td>
      <td><c:out value="${d.listInterviewers}"/></td>
      <td>
      <input type="submit" name="sentEmails" value="Уведомить">
      <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}  '/>"/>
      </td>
  </tr>
    </c:forEach>
    </table>
          </form>
         </center>
    </body>
</html>

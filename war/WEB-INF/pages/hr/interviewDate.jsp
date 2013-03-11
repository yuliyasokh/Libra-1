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
            <h3>${msg}</h3>
            <form name="myForm" action="showInterviewDateSearch.html" method="get">
        <select name="interSearch">
            <option value="0">Все </option>
            <option value="1">№ даты</option>
            <option value="2">Дата</option>
            <option value="3">Интервьер</option>
        </select>
        <input type="text" name ="textBox">
        <input type="submit" value="Показать" name="search">
            </form>
            <br>
         <h2 align="center">Информация о рассписании собеседований</h2><br> 
          <form method="GET">
        <table border="1" cellspacing="0" cellpadding="4">
          <tr>
            <th>№ даты</th>
            <th>Тип</th>
            <th>Дата</th>
            <th>Время</th>
            <th>Продолжительность</th>
            <th>Интервьюеры</th>
            <th>Уведомить</th>
            <th>Править</th>
            <th>Удалить</th>
          </tr>
    <c:forEach items="${Model}" var="d">
    <tr>
      <td><c:out value="${d.interviewDateId}"/></td>
      <td><c:out value="${d.typeInterview}"/></td>
      <td><c:out value="${d.dateInter}"/></td>
      <td><c:out value="${d.timeInter}"/></td>
      <td><c:out value="${d.interviewDuration}"/></td>
      <td><c:out value="${d.listInterviewers}"/></td>
      <td>
      <input type="submit" name="sentEmails" value="Уведомить">
      <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}  '/>"/>
      </td>
      <td>
          <a href="editInterviewDate.html?interviewDateId=<c:out value='${d.interviewDateId}'/>&type=<c:out value='${d.typeInterview}'/> ">
              править
          </a>
      </td>
      <td>
         <a href="delInterviewDate.html?interviewDateId=<c:out value='${d.interviewDateId} '/>">
             удалить
            </a>
        </td>
  </tr>
    </c:forEach>
    </table>
          </form>
         </center>
    </body>
</html>

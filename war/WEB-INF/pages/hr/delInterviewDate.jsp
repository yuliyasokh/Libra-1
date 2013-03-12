<%-- 
    Document   : delInterviewDate
    Created on : 07.02.2013, 15:22:35
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удаление даты интервью</title>
    </head>
    <body>
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
    </body>
</html>

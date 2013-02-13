<%-- 
    Document   : editInterviewDate
    Created on : 12.02.2013, 1:09:51
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Edit Interview Date</title>
    </head>
    <body>
        <h2 align="center"> Правка даты интервью </h2>
        <form method="POST" action="doneDate.html">
         <table border="1" cellspacing="0" cellpadding="4">
             <tr>
                 <td>№ Даты</td>
                  <td>Дата</td>
                  <td>Время</td>
                  <td>Продолжительность</td>
                 </tr>
        <td><label for="interviewDateId">${d.interviewDateId}</label>
        <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}  '/>"/></td>
        <td><input type="text" name="dateInter" value="${d.dateInter}"/></td>
        <td><input type="text" name="timeInter" value="${d.timeInter}"/></td>
        <td><input type="text" name="interviewDuration" value="${d.interviewDuration}"/></td>
        </table>
        <br>
        Выберите интервьюеров:
        <br> 
        <c:forEach items="${checkedInters}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> checked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        <c:forEach items="${uncheckedInters}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> unchecked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        <input type="submit" name="submitDate" value="Изменить">
        </form>
    </body>
</html>

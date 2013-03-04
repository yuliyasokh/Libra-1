<%-- 
    Author     : Alexander Lebed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Интервью</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="4">
            <tr>
                <td>№ Анкеты</td>
                <td>Дата и время начала</th>
                <td>Дата и время окончания</td>
                <td>Имя интервьюера</td>
                <td>Фамилия интервьюера</td>
                <td>Должность</td>
            </tr>
            
            <c:forEach items="${employees}" var="item">
                <tr>
                    <td>${appId}</td>
                    <td>${timeService.toDateAndTime(interviewDate.dateStart)}</td> <!-- not working -->
                    <td>${timeService.toDateAndTime(interviewDate.dateFinish)}</td> <!-- not working -->
                    <td>${item.firstName}</td>
                    <td>${item.lastName}</td>
                    <td>${item.roleId==2 ? 'HR-менеджер' : item.roleId==3 ? 'Тех.интервьюер' : item.roleId==4 ? "Администратор" : "N/A"}</td>
                </tr>
            </c:forEach>
            
        </table>
                <br><a href="showStudentbyIdView.html">Назад</a>
    </body>
</html>

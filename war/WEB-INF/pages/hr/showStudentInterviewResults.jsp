<%-- 
    Author     : Alexander Lebed
                Interview's results of the student (date, interviewers, assessment interview)
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
            <caption>Информация о пройденном собеседовании студента</caption>
            <tr>
                <td>№ анкеты студента</td>
                <td>Дата</th>
                <td>Время</td>
                <td>Имя интервьюера</td>
                <td>Должность интервьюера</td>
                <td>Оценка интервьюера</td>
                <td>Комментарий интервьюера</td>
            </tr>
            
            <c:forEach items="${resultList}" var="result">
                <tr>
                    <td>${result.appId}</td>
                    <td>${result.interviewDate}</td>
                    <td>${result.interviewTime}</td>
                    <td>${result.interviewerName}</td>
                    <td>${result.interviewerRole==2 ? 'HR-менеджер' : result.interviewerRole==3 ? 'Тех.интервьюер' : result.interviewerRole==4 ? "Администратор" : "Интервьюер"}</td>
                    <td>${result.interviewerMark}</td>
                    <td>${result.interviewerComments}</td>
                </tr>
            </c:forEach>
        </table>
        
                    <br>${view == 0 ? '<a href="showStudentbyIdView.html">Назад</a>' : '<a href="showStudentByEducation.html">Назад</a>'}
    </body>
</html>
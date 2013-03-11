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
    <center>
        
        <% int i = 1; %>
        
        <c:if test='${notAssigned != ""}'>
            ● Собеседование №<%= i++ %>. ${notAssigned} <br>
        </c:if>
           
        <c:if test="${!dateAndInterviewerList.isEmpty()}">
            
            <table border="1" cellspacing="0" cellpadding="4">
            <caption> ● Собеседование №<%= i++ %>. Информация о предстоящем собеседовании</caption>
            <tr>
                <td>№ Анкеты</td>
                <td>Дата</th>
                <td>Время</td>
                <td>Имя интервьюера</td>
                <td>Должность интервьюера</td>
            </tr>
            <c:forEach items="${dateAndInterviewerList}" var="date">
                <tr>
                    <td>${date.appId}</td>
                    <td>${date.interviewDate}</td>
                    <td>${date.interviewTime}</td> 
                    <td>${date.interviewerName}</td>
                    <td>${date.interviewerRole==2 ? 'HR-менеджер' : date.interviewerRole==3 ? 'Тех.интервьюер' : date.interviewerRole==4 ? "Администратор" : "Интервьюер"}</td>
                </tr>
            </c:forEach>
            </table>
            <br>
        </c:if>
            
        <c:if test="${!dateAndInterviewerResultsList.isEmpty()}">
            <table border="1" cellspacing="0" cellpadding="4">
            <caption> ● Собеседование №<%= i++ %>. Информация о пройденном собеседовании</caption>
            <tr>
                <td>№ анкеты</td>
                <td>Дата</th>
                <td>Время</td>
                <td>Имя интервьюера</td>
                <td>Должность интервьюера</td>
                <td>Оценка интервьюера</td>
                <td>Комментарий интервьюера</td>
            </tr>
            
            <c:forEach items="${dateAndInterviewerResultsList}" var="result">
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
            <br>
        </c:if>
            
        <c:if test='${wasAbsent != ""}'>
           ● Собеседование №<%= i++ %>. ${wasAbsent} <br>
        </c:if>
            
            <br>${view == 0 ? '<a href="showStudentbyIdView.html">Назад</a>' : '<a href="showStudentByEducation.html">Назад</a>'}
      
    </center>
    </body>
</html>

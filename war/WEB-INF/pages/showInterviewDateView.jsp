<%-- 
    Document   : showInterviewDateView
    Created on : 02.02.2013, 12:57:40
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Записаться на собеседование</title>
    </head>
    <body>
        
        <c:out value="${requestDate}"></c:out>
        <c:if test="${interviewDate==-1}">
            <form method="post" action="chooseDate.html">
        </c:if>
        <c:if test="${interviewDate!=-1}">
            <form method="post" action="changeDate.html">
        </c:if>
        <table border="1" cellspacing="0" cellpadding="4">
            <tr>
                <th>Выбрать</th>
                <th>Дата</th>
                <th>Время</th>
                <th>Количестов свободных мест</th>
            </tr>            
            <c:forEach items="${interviewDates}" var="idate">  
                <tr>
                    <c:if test="${idate.getId()==interviewDate}">
                        <td><input checked name="selDate" type="radio" value="<c:out value='${idate.getId()}'/>"/></td>
                    </c:if> 
                   <c:if test="${idate.getId()!=interviewDate}">
                   	<!-- убрал лишние скобки в следующем условиях -->
                       <c:if test="${idate.getFreePlaces()<=0||idate.getCorrect()==-1}">
                       <td>
                           <input disabled name="selDate" type="radio" value="<c:out value='${idate.getId()}'/>"/></td>
                       </c:if>
                       <c:if test="${idate.getFreePlaces()>0&&idate.getCorrect()==1}">
                       <td><input  name="selDate" type="radio" value="<c:out value='${idate.getId()}'/>"/></td>
                       </c:if>
                   </c:if>
                <td>
                    ${idate.getDay()}
                </td>
                <td>
                    ${idate.gethTime()}
                </td>
                <td>${idate.getFreePlaces()}</td>
                </tr>
            </c:forEach>            
        </table>
        <c:if test="${interviewDate==-1}">
                    <input type="submit" value="Записаться на собеседование"/>
        </c:if>
        <c:if test="${interviewDate!=-1}">
                    <input type="submit" value="Перезаписаться на собеседование"/>
        </c:if>
        </form>
    </body>
</html>
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
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellspacing="0" cellpadding="4">
            <tr>
                <th>Выбрать</th>
                <th>Дата</th>
                <th>Время</th>
                <th>Количестов свободных мест</th>
            </tr>            
            <c:forEach items="${interviewDates}" var="idate">  
                <tr>
                <td><input name="selDate" type="radio" value=""/></td>
                <td>
                    ${idate.getDay()}
                </td>
                <td>
                    ${idate.gethStart()}-${idate.gethFinish()}
                </td>
                <td>${idate.getFreePlaces()}</td>
                </tr>
            </c:forEach>            
        </table>
    </body>
</html>

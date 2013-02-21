<%-- 
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
        <table>
            <thead>
                <tr>
                    <th>Номер</th>
                    <th>Номер анкеты</th>
                    <th>ФИО</th>
                    <th>Дата собеседования</th>
                    <th>Средний бал</th>
                    <th>Просмотреть комментарии</th>
                </tr>
            </thead>
            <% int i=1;%>
            <c:forEach items="${showStudents}" var="student">
            <tr>
                <td>
                    <%=i%>
                </td>
                <td>
                    ${student.getAppId()}
                </td>
                <td>
                    ${student.getFio()}
                </td>
                <td>
                    ${student.getiDate()}
                </td>
                <td>
                    ${student.getAvgMark()}
                </td>
                <td>
                    <a href="addResult.html?InterviewId=<c:out value='${student.getInterviewId()}'/>">Просмотреть комментарии</a>
                </td>
            </tr>
            <% i++;%>
            </c:forEach>
        </table>
    </body>
</html>

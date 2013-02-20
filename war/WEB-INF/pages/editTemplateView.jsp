<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование шаблона</title>
    </head>
    <body>
        <h1>Редактирование шаблона</h1>
        <table>
        <caption>Информация о шаблона</caption>
        <tr>
            <th>№</th>
            <th>Название</th>
            <th>Изменить</th>
            <th>Удалить</th>
        </tr>
        <% int i=1; %>
        <c:forEach items="${templates}" var="t">
        <tr>
            <td><%=i%></td>
            <%--<td>${t.getTemplateId()} </td>--%>
            <td>${t.getName()} </td>
            <td><a href="editTemplate.html?tamplate=${t.getTemplateId()}"></a></td>
            <td><a href="editTemplate.html?tamplate=${t.getTemplateId()}"></a></td>
        </tr>
        <% i++;%>
        </c:forEach>
        </TABLE>
    </body>
</html>

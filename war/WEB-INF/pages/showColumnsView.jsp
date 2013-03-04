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
 <form method="POST" action="SubmitColumn.html">
            Введите имя колонки <input type="text" name="name" /></br>
            Выберите тип колонки<select name="selType">
                <c:forEach items="${types}" var="t">
                    <option value="${t.getTypeId()}"><c:out value="${t.getDescription()}" /></option>
                </c:forEach>
            </select></br>
            <input type="hidden" name="column" value="${topic.getTemplate()}"/>
            <input type="submit" value="OK"/>
        </form>
    <table border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о колонках к вопросам</caption>
        <tr>
            <th>№</th>
            <th>Название</th>
            <th>Имя темы вопроса</th>
            <th>Тип</th>
            <th>Кто добавил</th>           
            <th>Изменить</th>
            <th>Удалить</th>
        </tr>
        <% int i=1;%>
        <c:forEach items="${columns}" var="c">
            <tr>
                <td><%=i%></td>
                <td>${c.getName()}</td>
                <td>${c.getTopicName()}</td>
                <td>${c.getTypeName()}</td>
                <c:if test="${c.getRequired() == 0}">
                    <td>
                    Добавил студент
                    </td>
                </c:if>   
                <c:if test="${c.getRequired() != 0}">
                    <td>
                    Добавил hr
                    </td>
                </c:if>   
                
            <td><a href="editColumn.html?column=<c:out value='${c.getColumnId()} '/>"><img src="resources\images\edit.png" width="30" height="30"/></a></td>
            <td><a href="delColumn.html?column=<c:out value='${c.getColumnId()} '/>"><img src="resources\images\del.jpg" width="30" height="30"/></a></td>
 
            </tr>
            <% i++;%>
        </c:forEach>
        
        </table>
    </body>
</html>

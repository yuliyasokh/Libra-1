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
    <table border="1" cellspacing="0" cellpadding="4">
        <caption>Добавление колонки</caption>
        <form action="addColumn.html" method="GET">
         <tr>
             <td></td>
            <td colspan=5>Добавить новую колонку к теме
                <select name="topic">
                <c:forEach items="${topics}" var="t">
                     <option value="${t.getTopicId()}"><c:out value="${t.getName()}" /></option>
                </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Добавить колонку"/>
            </td>
        </tr>
        </form>
    </table>
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
        <c:forEach items="${columns}" var="c">
            <tr>
                <td>${c.getColumnId()}</td>
                <td>${c.getName()}</td>
                <td>${c.getTopicName()}</td>
                <td>${c.getTypeName()}</td>
                <c:if test="${(c.getRequired() == 0)}">
                    <td>
                    Добавил студент
                    </td>
                </c:if>   
                <c:if test="${(c.getRequired() != 0)}">
                    <td>
                    Добавил hr
                    </td>
                </c:if>   
                
            <td><a href="editColumn.html?column=<c:out value='${c.getColumnId()} '/>"><img src="edit.png" width="30" height="30"/></a></td>
            <td><a href="delColumn.html?column=<c:out value='${c.getColumnId()} '/>"><img src="del.jpg" width="30" height="30"/></a></td>
 
            </tr>
        </c:forEach>
        
        </table>
    </body>
</html>

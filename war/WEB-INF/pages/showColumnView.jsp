<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование колонки</title>
    </head>
    <body>
        <h1>Добавить колонку </h1>
        <form method="POST" action="showColumns.html">
            Введите имя колонки <input type="text" name="name" value="<c:out value='${column.getName()}' />"/></br>
            Выберите тип колонки<select name="selType">
                <c:forEach items="${types}" var="t">
                    <option value="${t.getTypeId()}"><c:out value="${t.getDescription()}" /></option>
                </c:forEach>
            </select></br>
                    <input type="hidden"  name="column" value="<c:out value='${column.getColumnId()}'/>"/>
                    <input type="hidden"  name="topic" value="<c:out value='${topic.getTopicId()}'/>"/></br>       
            <input type="submit" value="OK"/>
        </form>
    </body>
</html>
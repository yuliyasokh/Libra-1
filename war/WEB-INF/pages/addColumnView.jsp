<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление колонки</title>
    </head>
    <body>
        <h1>Добавить колонку к</h1>
        <form method="POST" action="SubmitColumn.html">
            Введите имя колонки <input type="text" name="name" /></br>
            Выберите тип колонки<select name="selType">
                <c:forEach items="${types}" var="t">
                    <option value="${t.getTypeId()}"><c:out value="${t.getTypeName()}" /></option>
                </c:forEach>
            </select></br>
            <input type="hidden" name="column" value="${topic.getTemplate()}"/>
            <input type="submit" value="OK"/>
        </form>
    </body>
</html>

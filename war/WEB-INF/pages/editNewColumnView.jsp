<%-- 
    Author     : Sashenka
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Отредактировать колонку</title>
    </head>
    <body>
    <form method="POST" action="editSubmitColumn.html">
        <fieldset>
   <legend>Редактировать колонку</legend>
            Введите имя колонки <input type="text" name="name" value="${current.getName()}" /></br>
            Выберите тип колонки<select name="selType">
                <option value="0">Колонка для инфорации</option>
                <c:forEach items="${types}" var="t">              
                    <option <c:if test="${current.getTypeId()==t.getTypeId()}">selected</c:if> value="${t.getTypeId()}">
                        <c:out value="${t.getInfoDescription()}" />
                    </option>
                </c:forEach>
            </select></br>
            Выберите тип колонки<select name="parentColumn">
                <option value="0">Нету родителя</option>
                <c:forEach items="${columns}" var="c">
                    <c:if test="${current.getColumnId()!=c.getColumnId()}">
                    <option <c:if test="${current.getParentColumn()==c.getColumnId()}">selected</c:if> value="${c.getColumnId()}"><c:out value="${c.getName()}" /></option>
                    </c:if> 
                </c:forEach>
            </select></br>
            Поменять местами с <select name="parentColumn">
                <c:forEach items="${columns}" var="c">
                    <c:if test="${(current.getParentColumn()==c.getParentColumn()) &&(current.getColumnId()!=c.getColumnId())}">
                    <option  value="${c.getColumnId()}"><c:out value="${c.getName()}" /></option>
                    </c:if> 
                </c:forEach>
            </select></br>
            <input type="hidden" name="columnId" value="${columnId}"/>
            <input type="submit" value="OK"/>
        </fieldset>
    </form>
    </body>
</html>

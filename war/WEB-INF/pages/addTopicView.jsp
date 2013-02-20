<%-- 
    Author     : Sashenka
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавление темы вопроса</title>
    </head>
    <body>
        <h1>Добавить тему вопроса к </h1>
        <form method="POST" action="SubmitTopic.html">
            Введите имя темы <input type="text" name="name" /></br>
            Введите комментарий <input type="text" name="comments" /></br>
            Выберите родительскую тему<select name="selTopics">
                <option value="0">Нету родителя</option>
                <c:forEach items="${topics}" var="t">
                    <option value="${t.getTopicId()}"><c:out value="${t.getName()}" /></option>
                </c:forEach>
            </select></br>
            Разрешить добавлять свои ответы
            <input type="radio" name="require" value="0"> Нет
            <input type="radio" name="require" value="1" checked>Да </br>
            <input type="submit" value="OK"/>
            <input type="hidden" name="templateId" value="<c:out value='${id}'/>"/>
        </form>                
    </body>
</html>

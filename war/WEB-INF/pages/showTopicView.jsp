<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Редактирование темы</title>
    </head>
    <body>
        <h1>Редактирование темы</h1>
        <form action="editSubmitTopic.html" method="POST" >
            Введите имя темы <input type="text" name="name" value="${topic.getName()}"/></br>
            Введите комментарий <input type="text" name="comments" value="${topic.getComments()}"/></br>
            Разрешить добавлять свои ответы
            <c:if test="${topic.getRequierOther() == 1}">
                    <input type="radio" name="require" value="0"> Нет
            <input type="radio" name="require" value="1" checked>Да </br>
            </c:if>
            <c:if test="${topic.getRequierOther() == 0}">
                    <input type="radio" name="require" value="0" checked> Нет
            <input type="radio" name="require" value="1" >Да </br>
            </c:if>
            <input type="hidden" name="topic" value="<c:out value='${topic.getTopicId()}' />"/>
            
            Выберите родительскую тему
            <select name="selTopics">
                <option value="0">Нету родителя</option>             
                <c:forEach items="${topics}" var="t">
                    <c:if test="${parentTopic == t.getTopicId()}">
                        <option value="${t.getTopicId()}" selected><c:out value="${t.getName()}"/></option>
                    </c:if>
                    <c:if test="${parentTopic != t.getTopicId()}">
                    <option value="${t.getTopicId()}"><c:out value="${t.getName()}" /></option>
                    </c:if>
                </c:forEach>
            </select></br>
            
            <input type="submit" value="OK"/>
            
            <input type="hidden" name="template" value="<c:out value='${teplateId}' />"/>
        </form>
        
    </body>
</html>

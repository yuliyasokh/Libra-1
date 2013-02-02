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
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о темах к вопросам</caption>
        <tr>
            <th>№</th>
            <th>Название</th>
            <th>Комментарий</th>
            <th>Имя шаблона</th>
            <th>Родительский топик</th>
            <th>Можно ди добавить свой ответ</th>
            <th>Изменить</th>
            <th>Удалить</th>
        </tr>
        
         <tr>
             <form action="addTopic.html" method="GET">
             <td colspan=2></td>
            <td colspan=5>Добавить новую тему вопроса к шабдлону
                <select name="template">
                <c:forEach items="${templates}" var="t">
                     <option value="${t.getTemplateId()}"><c:out value="${t.getName()}" /></option>
                </c:forEach>
                </select>
            </td>
            <td>
                <input type="submit" value="Добавить топик"/>
            </td>
             </form>
        </tr>
       
        <%--<c:forEach items="${maps}" var="contactMap">
        <tr>
            <td>${contactMap.value.getTopicId()}</td>
            <td>${contactMap.value.getName()}</td>
            <td>${contactMap.value.getComments()}</td>
            <td>${contactMap.key}</td>
            <td>
                <c:if test="${(contactMap.value.getParentTopic() == 0)}">
                    <b>Родителя нету</b>
                </c:if>
                <c:if test="${(contactMap.value.getParentTopic() != 0)}">
                    <c:out value=' ${contactMap.value.getParentTopic()} '/>
                </c:if>             
            </td>
            <td>
                <c:if test="${(contactMap.value.getRequierOther() == 1)}">
                    <b>Можно добавить свой ответ</b>
                </c:if>
                <c:if test="${(contactMap.value.getRequierOther() == 0)}">
                    <b>Нельзя добавить свой ответ</b>
                </c:if>
            </td>
            <td><a href="showTopic.html?topic=<c:out value='${contactMap.value.getTopicId()} '/>"><img src="edit.png" width="30" height="30"/></a></td>
            <td><a href=""><img src="del.jpg" width="30" height="30"/></a></td>
        </tr>
        </c:forEach>--%>
        <c:forEach items="${topics}" var="t">
            <tr>
                <td>${t.getTopicId()}</td>
                <td>${t.getName()}</td>
                <td>${t.getComments()}</td>
                <td>${t.getTemplateName()}</td>
                <c:if test="${(t.getParentTopic() == 0)}">
                    <td>
                    <b>Родителя нету</b>
                    </td>
                </c:if>
                <c:if test="${(t.getParentTopic() != 0)}">
                    <td>
                    <c:out value=' ${t.getParentTopicName()} '/>
                    </td>
                </c:if>   
                    <td>
                <c:if test="${(t.getRequierOther() == 1)}">
                    <b>Можно добавить свой ответ</b>
                </c:if>
                <c:if test="${(t.getRequierOther() == 0)}">
                    <b>Нельзя добавить свой ответ</b>
                </c:if>
            </td>
            <form action="showSubmitTopic.html" method="post">
            <td>
                   <input type="image"  src="edit.png" width="25" height="25" title="внести изменения" OnClick="Forma1.submit()"/>
                    <input type="hidden" value="<c:out value='${t.getTopicId()}' />" name="selTopic"/>
            </td>
            </form>
            <td><a href="delTopic.html?topic=<c:out value='${t.getTopicId()}' />"><img src="del.jpg" width="30" height="30"/></a></td>
 
            </tr>
        </c:forEach>
        
        </table>
    </body>
</html>

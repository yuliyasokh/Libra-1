<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page (${userid})</title>
    </head>
    <body>
        <form action="addTopic.html" method="GET">
        <table>
        <tr>
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
        </tr>
        </table>
        </form>
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о темах к вопросам</caption>
        <form action="delTopic.html" method="POST">
        <tr>
            <th>
                <input type="image"  src="resources/images/del.jpg" width="25" height="25" title="Удалить" onclick="formSubmit()"/>
            </th>
            <th>№</th>
            <th>Название</th>
            <th>Комментарий</th>
            <th>Имя шаблона</th>
            <th>Родительский топик</th>
            <th>Можно ди добавить свой ответ</th>
            <th>Изменить</th>
            <th>Удалить</th>
        </tr>
        <% int i=1;%>
        <c:forEach items="${topics}" var="t">
            <tr>
                <td>
                    <input type="checkbox" name="topics[]" value="<c:out value='${t.getTopicId()}'/>"/>              
                </td>
                <td><%=i%></td>
                <%--<td>${t.getTopicId()}</td>--%>
                <td>${t.getName()}</td>
                <td>${t.getComments()}</td>
                <td>${t.getTemplateName()}</td>
                <c:if test="${t.getParentTopic() == 0}">
                    <td>
                    <b>Родителя нету</b>
                    </td>
                </c:if>
                <c:if test="${t.getParentTopic() != 0}">
                    <td>
                    <c:out value=' ${t.getParentTopicName()} '/>
                    </td>
                </c:if>   
                    <td>
                <c:if test="${t.getRequierOther() == 1}">
                    <b>Можно добавить свой ответ</b>
                </c:if>
                <c:if test="${t.getRequierOther() == 0}">
                    <b>Нельзя добавить свой ответ</b>
                </c:if>
            </td>
            <td><a href="showColumns.html?topic=<c:out value='${t.getTopicId()}' />">Просмотреть колонки</a></a>
            </td>  
            <td>
             <%--   <form action="showSubmitTopic.html" method="post"> --%>
             <%--      <input type="image"  src="resources\images\edit.png" width="25" height="25" title="внести изменения" onclick="location.href='showSubmitTopic.html'"/>
                   <input type="hidden" value="<c:out value='${t.getTopicId()}' />" name="selTopic"/>--%>
             <a href="showSubmitTopic.html?selTopic=<c:out value='${t.getTopicId()}'/>"><img src="../../resources/images/edit.png"/></a>
                <%-- </form>--%>
            </td>
            </tr>
            <% i++;%>
        </c:forEach>    
        </table>
        </form>
    </body>
</html>

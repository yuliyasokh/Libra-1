<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удаление темы</title>
    </head>
    <body>
        <h1>Вы действительно хотите удалить эту тему?</h1>
        <c:if test="${infoSize == 0  }">
            <p>Смело удаляйте эту тему! Ни одна анкета при этом не удалится.</p>
        </c:if>
        <c:if test="${infoSize > 0  }">
            <p>При это будут удалены анкеты ${infoSize} студентов</p>
            <table>
                <tr>
                    <th>номер анкеты</th>
                    <th>ФИО</th>
                    <th>фото</th>
                </tr>
            <c:forEach items="${info}" var="i">
            <tr>
                <td> <c:out value="${i.getAppId()}" /></td>
                <td> 
                    <c:out value="${i.getFirstname()} " />
                    <c:out value="${i.getPatronymic()} " />
                    <c:out value="${i.getLastname()}" />
                </td>
                <td> <c:out value="Пока номер ${i.getUserId()}" /></td>
            </tr>
           </c:forEach>
            </table>
        </c:if>
        <form action="delSubmitTopic.html" method="POST">
            <input type="hidden" name="topic" value="${topic}"/>
        <input type="submit" value="удалить"/>    
        <input value="НЕТ" onclick="location.href='showTopics.html'" type="button"/>
        </form>
        
    </body>
</html>

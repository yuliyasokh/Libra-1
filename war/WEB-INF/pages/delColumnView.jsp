<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удаление колонки</title>
    </head>
    <body>
        <h1>Вы действительно хотите удалить этот тип?</h1>
        <c:if test="${infoSize == 0  }">
            <p>Смело удаляйте эту колонку! Ни одна анкета при этом не удалится.</p>
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
        <form action="delSubmitColumn.html" method="POST">
            <input type="hidden" name="column" value="${column}"/>
        <input type="submit" value="удалить"/>    
        <input value="НЕТ" onclick="location.href='showColumns.html'" type="button"/>
        </form>
        
    </body>
</html>

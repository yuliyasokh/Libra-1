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
        <caption>Добавить новый тип</caption>
        <form action="SubmitType.html" method="POST">
        <tr>
                    <td COLSPAN=4>
                    <input type="text" name="name">
                    </td>
                    <td >
                <input type="submit" value="Добавить новый тип">
                </td>  
        </tr>
         </form>
        </table>
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о типах данных</caption>
        <tr>
            <th>Удалить</th>
            <th>№</th>
            <th>Название</th>
            <th>Изменить</th>
            <th>Новое имя</th>
        </tr>
        <c:forEach items="${types}" var="t">
            <form action="showTypes.html" method="POST">
        <tr>
            <td>
                <a href="delType.html?type=<c:out value='${t.getTypeId()} '/>"><img src="resources\images\del.jpg"  width="25" height="25" border="0" title="удалить"/></a>
            </td>
            <td>
                ${t.getTypeId()} 
                <input type="hidden" name="selType" value="<c:out value='${t.getTypeId()}  '/>"/>
            </td>
            <td>${t.getTypeName()} </td>
            <td>
                <input type="image"  src="resources\images\edit.png" width="25" height="25" title="внести изменения" OnClick="Forma1.submit()"/>
            </td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
            </form>
        </c:forEach>
        
        </table>
    </body>
</html>

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
        <h1>Добавить тип</h1>
        <form action="SubmitType.html" method="post">
            <table border="1" cellspacing="0" cellpadding="4">
                <tr>
                    <th>Выбрать</th>
                    <th>Тип колнки</th>
                    <th>Значение</th>
                </tr>
                <tr>
                    <td><input checked name="name" type="radio" value="string"/></td>
                    <td>Строка(введите максимальную длину)</td>
                    <td rowspan="3"><input name="description" type="text" /></td>
                </tr>

                <tr>
                    <td><input  name="name" type="radio" value="integer"/></td>
                    <td>Число(введите максимальное и минимальное значение через "-")</td>
                    
                </tr>
                <tr>
                    <td><input  name="name" type="radio" value="enum"/></td>
                    <td>Выбор из фиксированных значений(введите через зарятую)</td>
                    
                </tr>
            </table>
                Название             
                <input type="submit" value="OK">
        </form>
        <% int i=1; %>
        <form action="delType.html" method="POST">
        <table border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о типах данных</caption>
        <tr>
            <th>
                <input type="image"  src="resources/images/del.jpg" width="25" height="25" title="Удалить" onclick="formSubmit()"/>
            </th>
            <th>№</th>
            <th>Название</th>
            <th>Значение</th>
            <th>Изменить</th>
            <th>Новое значение</th>
        </tr>
        <c:forEach items="${types}" var="t">
            
            
        <tr>
            <td>
                <%--
                <a href="delType.html?type=<c:out value='${t.getTypeId()} '/>"><img src="resources\images\del.jpg"  width="25" height="25" border="0" title="удалить"/></a>
                --%>
                <input type="checkbox" name="types[]" value="<c:out value='${t.getTypeId()}'/>"/>        
            </td>
            <form action="showTypes.html" method="POST">
            <td>
                <%=i%>
                <%--${t.getTypeId()} --%>
                <input type="hidden" name="selType" value="<c:out value='${t.getTypeId()}  '/>"/>
            </td>
            <c:if test="${t.getTypeName()=='string'}">
            <td>Строка </td>
            </c:if>
            <c:if test="${t.getTypeName()=='integer'}">
            <td>Число </td>
            </c:if>
            <c:if test="${t.getTypeName()=='enum'||(t.getTypeName()=='multienum')}">
            <td>Перечислимый тип</td>            
            </c:if>
            <td>${t.getDescription()}</td>
            <c:if test="${t.getTypeName()!='enum'&&(t.getTypeName()!='multienum')&&(t.getTypeName()!='integer')&&(t.getTypeName()!='string')}">
            <td>${t.getTypeName()}</td>
            <td>${t.getDescription()}</td>
            </c:if>
            <td>
                <%-- <input type="image"  src="resources\images\edit.png" width="25" height="25" title="внести изменения" OnClick="Forma1.submit()"/>--%>
                
                <%--    <input type="image"  src="resources\images\edit.png" width="25" height="25" title="внести изменения" onclick="location.href='showTypes.html'"/>--%>
             <input type="image"  src="resources/images/edit.png" width="25" height="25" title="внести изменения" onclick="location.href='showTypes.html'"/>
             <%--  <a href="showTypes.html"><img src="../../resources/images/edit.png"/></a> --%>
            </td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
            </form>
            <% i++;%>
        </c:forEach>
        </table>
            </form>
    </body>
</html>

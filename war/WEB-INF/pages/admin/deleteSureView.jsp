<%-- 
    Author     : Alexander Lebed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Удалить?</title>
        <!-- Запрос об удалении -->
    </head>
    <body>

        <form action="deleteEmployee.html" method="GET">
            <table>
            <tr>
                <td><input type="hidden"/>Вы уверены что хотите удалить служащего с именем <c:out value='${emp.getFirstName()}'/> <c:out value='${emp.getLastName()}'/>?</td>
                <td><input type="hidden" name="employeeId" value="<c:out value='${emp.getUserId()}'/>"/></td>
            </tr>
            <td>
                <input type="submit" style="height: 25px; width: 100px" value="Да"/>
            </td>
            </table>
        </form>
        
        <form action="employees.html" method="POST">
            <table>
            <td>
                <input type="submit" style="height: 25px; width: 100px" value="Нет"/>
            </td>
            </table>
        </form>
        
    </body>
</html>

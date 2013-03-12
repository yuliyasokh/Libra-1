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
        <style type="text/css">
            body {text-align: center; padding-top:200px }
        </style>
    </head>
    <body>
        <!-- Removal request -->
        <form action="deleteEmployee.html" method="GET">
            <b>Вы уверены что хотите удалить служащего с именем <c:out value='${emp.getFirstName()}'/> <c:out value='${emp.getLastName()}'/>?</b>
                <input type="hidden" name="employeeId" value="<c:out value='${emp.getUserId()}'/>"/>
                <br><input type="submit" style="height: 25px; width: 100px" value="Да"/><input type=button style="height: 25px; width: 100px" value="Нет" onCLick="history.back()">
        </form>
</html>

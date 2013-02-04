<%-- 
    Document   : showStudentbyIdView
    Created on : 04.02.2013, 0:42:45
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Найти студента по № анкеты</title>
    </head>
    <body>
      
        <h1>Список студентов</h1>
       <TABLE>
        Фильтр  
        <form method="post" action="showStudentbyIdView.html">
        <select name="filter">
        <option value="1">Показать всех</option>
        <option value="2">Номер анкеты</option>
        <option value="3">Имя</option>
        <option value="4">Фамилия</option>
        <option value="5">Email</option>

</select>
    <input type="text" name="textBox">
    <input type="submit" value="Поиск">
</form>
            <th>№ анкеты</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Email</th>
    <c:forEach items="${Model}" var="s">
    <tr>
      <td><c:out value="${s.appId}"/></td>
      <td><c:out value="${s.name}"/></td>
      <td><c:out value="${s.lastName}"/></td>
      <td><c:out value="${s.email}"/></td>
  </tr>
    </c:forEach>
    </TABLE>
                      
    </body>
</html>

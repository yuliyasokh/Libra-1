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
        <title>Поиск студентов</title>
    </head>
    <body>
      
        <h1>Список студентов</h1>
        <h3>${msg}</h3>
       <TABLE>
        Фильтр  
        <form method="post" action="showStudentbyIdView.html">
        <select name="filter">
        <option value="1" ${filterInt == '1' ? 'selected' : ''}>Показать всех</option>
        <option value="2" ${filterInt == '2' ? 'selected' : ''}>Номер анкеты</option>
        <option value="3" ${filterInt == '3' ? 'selected' : ''}>Имя</option>
        <option value="4" ${filterInt == '4' ? 'selected' : ''}>Фамилия</option>
        <option value="5" ${filterInt == '5' ? 'selected' : ''}>Email</option>
</select>
    <input type="text" name="textBox" value="${textBox}">
    <input type="submit" value="Поиск">
</form>
            <th>№ анкеты</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Email</th>
            <th></th>
            <th></th>
            <th></th>
            
    <c:forEach items="${Model}" var="s">
    <tr>
      <td><c:out value="${s.appId}"/></td>
      <td><c:out value="${s.name}"/></td>
      <td><c:out value="${s.lastName}"/></td>
      <td><c:out value="${s.email}"/></td>
      <td> <input type="button" value="Анкета"><td>
      <td> <input type="button" value="Интервью"><td>
      <td> <input type="button" value="Удалить"><td>

  </tr>
    </c:forEach>
    </TABLE>
    <h3>${msg1}</h3>
                      
    </body>
</html>

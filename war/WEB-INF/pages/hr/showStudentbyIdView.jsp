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
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" charset="utf-8">   
        </script>
        <script type="text/javascript">
			$(function() {
				function sortTable($table, cellIndex, direction) {
					var $rows = $table.find('tbody tr');
					var data = [];
					$rows.each(function() {
						data.push({
							cellText: $(this).find('td').eq(cellIndex).text(),
							$row: $(this)
						});
					});

					data.sort(function(a, b) {
						if (a.cellText == b.cellText) {
							return 0;
						}
						var sign = direction == "ASC" ? 1 : -1;
						if(a.cellText == parseInt(a.cellText) && b.cellText == parseInt(b.cellText))
                                                    return sign * ((parseInt(a.cellText) < parseInt(b.cellText)) ? -1 : 1);
						return sign * ((a.cellText < b.cellText) ? -1 : 1);
					});
					
					
					$table.find('tbody').empty();
					$(data).each(function() {
						$table.find('tbody').append(this.$row);
					});
				}			
				var $interviews = $('.students');
				$interviews.find('thead th').each(function(cellIndex) {
					$(this).on('click', function() {
						var lastDirection = $(this).data('lastDirection') || "DESC";
						var direction = lastDirection == "DESC" ? "ASC" : "DESC";
						$(this).data('lastDirection', direction);
					
						sortTable($interviews, cellIndex, direction);
					});
				});
			});
                                </script>
    </head>
    <body>
      <center>
        <h1>Список студентов</h1>
        <h3>${msg}</h3>
        
        Фильтр  
        <form method="post" action="showStudentbyIdView.html">
        <select name="filter">
        <option value="1" ${filterInt == '1' ? 'selected' : ''}>Показать всех</option>
        <option value="2" ${filterInt == '2' ? 'selected' : ''}>Номер анкеты</option>
        <option value="3" ${filterInt == '3' ? 'selected' : ''}>Имя</option>
        <option value="4" ${filterInt == '4' ? 'selected' : ''}>Фамилия</option>
        <option value="5" ${filterInt == '5' ? 'selected' : ''}>Email</option>
        <option value="6" ${filterInt == '6' ? 'selected' : ''}>По всем полям</option>
</select>
   <form method="GET">
    <input type="text" name="textBox" value="${textBox}">
    <input type="submit" value="Поиск">
            </form>
    <br>
    <br> 
        <TABLE border ="1" class="students">
            <thead>
            <tr>
                <th>№ анкеты</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Email</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
    <c:forEach items="${Model}" var="s">
    <tr>
        <form action="showStudentInterview.html" method="POST">
            <td><input type="hidden" name="appId" value="<c:out value='${s.getAppId()}'/>"/>${s.getAppId()}</td>
            <td><input type="hidden" name="firstName" value="<c:out value='${s.getName()}'/>"/>${s.getName()}</td>
            <td><input type="hidden" name="lastName" value="<c:out value='${s.getLastName()}'/>"/>${s.getLastName()}</td>
            <td><input type="hidden" name="email" value="<c:out value='${s.getEmail()}'/>"/>${s.getEmail()}</td>
            <input type="hidden" name="view" value="0"/>
            <td> <input type="submit" value="Анкета"></td>
          
                <td> <input type="submit" value="Интервью"></td>
          </form>
      <td> <input type="submit" value="Удалить"></td>
        </tr>
    </tbody>
    </c:forEach>
    </TABLE>
    <h3>${msg1}</h3>
   </center>         
    </body>
</html>

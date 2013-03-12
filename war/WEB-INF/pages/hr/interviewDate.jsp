<%-- 
    Document   : interviewDate
    Created on : 05.02.2013, 0:34:43
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление датами интервью</title>
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
				
				var $interviews = $('.interviewDate');
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
            <a href="interviewDateAdd.html">Добавить новую дату интервью</a>
            <br>
            <br>
            <h3>${msg}</h3>
            <form name="myForm" action="showInterviewDateSearch.html" method="get">
        <select name="interSearch">
            <option value="0">Все </option>
            <option value="1">№ даты</option>
            <option value="2">Дата</option>
            <option value="3">Интервьер</option>
        </select>
        <input type="text" name ="textBox">
        <input type="submit" value="Показать" name="search">
            </form>
            <br>
         <h2 align="center">Информация о рассписании собеседований</h2><br> 
          <form method="GET">
              <table border="1" cellspacing="0" cellpadding="4" class="interviewDate">
                  <thead>
          <tr>
            <th>№ даты</th>
            <th>Тип</th>
            <th>Дата</th>
            <th>Время</th>
            <th>Продолжительность</th>
            <th>Интервьюеры</th>
            <th>Уведомить</th>
            <th>Править</th>
            <th>Удалить</th>
          </tr>
                  </thead>
                  <tbody>
    <c:forEach items="${Model}" var="d">
    <tr>
      <td><c:out value="${d.interviewDateId}"/></td>
      <td><c:out value="${d.typeInterview}"/></td>
      <td><c:out value="${d.dateInter}"/></td>
      <td><c:out value="${d.timeInter}"/></td>
      <td><c:out value="${d.interviewDuration}"/></td>
      <td><c:out value="${d.listInterviewers}"/></td>
      <td>
      <input type="submit" name="sentEmails" value="Уведомить">
      <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}  '/>"/>
      </td>
      <td>
          <a href="editInterviewDate.html?interviewDateId=<c:out value='${d.interviewDateId}'/>&type=<c:out value='${d.typeInterview}'/> ">
              править
          </a>
      </td>
      <td>
         <a href="delInterviewDate.html?interviewDateId=<c:out value='${d.interviewDateId} '/>">
             удалить
            </a>
        </td>
    </tr>
        </c:forEach>
                  </tbody>
            </table>
          </form>
         </center>
    </body>
</html>

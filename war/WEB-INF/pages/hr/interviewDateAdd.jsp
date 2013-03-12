<%-- 
    Document   : interviewDateAdd
    Created on : 26.02.2013, 14:12:36
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление датами интервью - добавление</title>
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
    $(document).ready(function() {
        $("#type").bind("change", function(){    
        if ($("#type").val()==1) {
            $("#hrDiv").css("display","block");
            $("#techDiv").css("display","none");
        }
        else {
            $("#hrDiv").css("display","none");
            $("#techDiv").css("display","block");
        }
    });
 });
</script>
    </head>
    <body>
        <center>
            <form method="POST" action="interviewDateAdd.html">
        <h2 align="center">Добавить новую дату интервью</h2>
        Выберите тип: 
        <select name="type" id="type" >
            <option value="1" > Hr </option>
            <option value="2"> Tech </option>
            </select>
        <br>
            Введите дату (20/05/2013): <input type="text" name="begin"><br>
            Введите время начала и конца: 
            <input type="text" name="timeStart" style="width: 50px" > 
            - 
            <input type="text" name="end" style="width: 50px" ><br>   
            Введите продолжительность: <input type="text" name="duration" >  
        <br> 
        Выберите интервьюеров:<br> 
        <div id="hrDiv">
        <c:forEach items="${Inters}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> unchecked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        </div>
        <div style="display: none;"  id="techDiv">
        <c:forEach items="${intersTech}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> unchecked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        </div>
            <br> 
        <input type="submit" name="submitDate" value="Добавить">
    </form>
         <h2 align="center">Информация о рассписании собеседований</h2><br> 
          <form method="GET" action="delInterviewDate.html">
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

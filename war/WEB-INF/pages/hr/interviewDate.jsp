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
        <link rel="stylesheet" href="/Libra/resources/css/main.css;jsessionid=FA938E18B7E9988F3F7B07F9C08278BD" />
<link rel="stylesheet" href="/Libra/resources/css/bootstrap-responsive.min.css;jsessionid=FA938E18B7E9988F3F7B07F9C08278BD" />
<link rel="stylesheet" href="/Libra/resources/css/bootstrap.min.css;jsessionid=FA938E18B7E9988F3F7B07F9C08278BD" />
<link rel="stylesheet" href="/Libra/resources/css/style.css;jsessionid=FA938E18B7E9988F3F7B07F9C08278BD" />
<script src="/Libra/resources/js/jquery-1.9.0.min.js;jsessionid=FA938E18B7E9988F3F7B07F9C08278BD"></script>
<script src="/Libra/resources/js/modernizr-2.6.2-respond-1.1.0.min.js;jsessionid=FA938E18B7E9988F3F7B07F9C08278BD"></script>

<script src="http://code.jquery.com/jquery-migrate-1.1.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript" charset="utf-8">   
            </script>
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
        <div class="navmenu">
		
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand">Libra</a>
			<div class="navbar-content">
				<ul class="nav">
					<li class="active"><a href="/Libra">Главная</a></li>
					<li><a href="#">Информация</a></li>
					<li><a href="#">Контакты</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
	</div>
        <div class="container-fluid">
		<div class="row-fluid">
		<div class="sidebar">
	<div class="span3 well">
	<ul class="nav  nav-pills nav-stacked">
		<li class="nav-header">Управление шаблонами</li>
		<li><a href="showTemplates.html">Шаблоны</a></li>
		<li><a href="showTopics.html">Топики</a></li>
		<li><a href="showTypes.html">Типы</a></li>
		<li class="nav-header">HR</li>
		<li><a href="hr/showStudentbyIdView.html">Поиск студентов</a></li>
		<li><a href="hr/showStudentByEducation.html">Поиск по
				университету</a></li>
		<li><a href="hr/showUniversities.html">Управление
				университетами</a></li>
		<li><a href="hr/showFaculties.html">Управление факультетами</a></li>
		<li><a href="hr/showDepartments.html">Управление кафедрами</a></li>
		<li><a href="hr/interviewDate.html">Расписание собеседований</a></li>

		<li class="nav-header">Отчеты</li>
		<li><a href="showStudentRecords.html">График записи студентов</a></li>
		<li><a href="showRegReport.html">Зарегистрировались/пришли</a></li>
		<li><a href="showAdvertise.html">Эффективность рекламы</a></li>
		<li><a href="showStudentActivity.html">Посещаемость
				собеседований</a></li>
	</ul>
	</div>
			</div>
			<div class="span9">
				<div class="hero-unit">

                                    <center>
            <br>
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
            <th><a href="#">№ даты</a></th>
            <th><a href="#">Тип</a></th>
            <th><a href="#">Дата</a></th>
            <th><a href="#">Время</a></th>
            <th><a href="#">Продолжительность</a></th>
            <th><a href="#">Интервьюеры</a></th>
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
         </div>
                        </div>
                </div>
        </div>
    </body>
</html>

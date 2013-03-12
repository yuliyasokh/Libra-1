<%-- 
    Document   : showStudentByEducation
    Created on : 16.02.2013, 21:30:18
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find students</title> 
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
                                    function getFact(){
                                        $.post("faculty.html",{"universityId":$("#univ").val() },
                                    function(data) {
                                        $("#fact").html(data);
                                        getDept();
                                        }   
                                        );
                                      }
                                    function getDept(){
                                        $.post("department.html",{"facultyId":$("#fact").val() },
                                    function(data) {
                                        $("#dept").html(data);
                                        }        
                                     );
                                     }  
</script>
</head>
   <body>
    <center>
       <h2>Список студентов</h2>   
        <form method="post" action="showStudentByEducation.html">
       Университет:
       <select onchange="getFact();" name="univ" id="univ">
          <option value="0"> Все </option> 
           <c:forEach items="${univers}" var="u">
            <option value="${u.universityId}"> ${u.universityName}  
                </option> 
           </c:forEach>  
       </select> 
       <br>
       Факультет:
        <select onchange="getDept();" name="fact" id="fact">
             <option value="0"> Выберите университет </option> 
        </select>
       <br>
       Кафедра: 
        <select name="dept" id="dept">
             <option value="0"> Выберите факультет </option> 
        </select>
       <br>
       <br>       
       <input type="submit" value="Поиск">
        </form>
          <form method="GET">
          <table border ="1" class="students"> 
              <thead>
                  <tr>
            <th>№ анкеты</th>
            <th>Имя </th>
            <th>Фамилия </th>
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
      <input type="hidden" name="view" value="1"/>
      <td> <input type="submit" value="Анкета"></td>
          
                <td> <input type="submit" value="Интервью"></td>
          </form>
      <td> <input type="submit" value="Удалить"></td>
  </tr>
    </c:forEach>
        </tbody>
    </table>
       </center>
    </body>
</html>
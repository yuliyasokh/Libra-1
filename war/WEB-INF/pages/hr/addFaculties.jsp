<%-- 
    Document   : addFaculties
    Created on : 22.02.2013, 16:36:15
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление факультетами - Добавление факультетов</title>
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
				
				var $interviews = $('.faculty');
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
            <form name="Form" action="addFacultiesAdded.html" method="get">
                Введите название факультета: 
                <input type="text" name ="facultyName">
                Выберите университет: 
                <select name="univ" id="univ">
                    <c:forEach items="${univers}" var="u">
                    <option value="${u.universityId}"> ${u.universityName}  </option> 
                    </c:forEach>  
                 </select> 
                <input type="submit" value="Добавить" name="add">
            </form>
            <br>     
            <form name="myForm" action="showFacultiesSearch.html" method="get">
        <select name="facultySearch">
            <option value="0" ${facultySearchInt == '0' ? 'selected' : ''}>Все </option>
            <option value="1" ${facultySearchInt == '1' ? 'selected' : ''}>№ факультета</option>
            <option value="2" ${facultySearchInt == '2' ? 'selected' : ''}>Факультет</option>
            <option value="3" ${facultySearchInt == '3' ? 'selected' : ''}>Университет</option>
        </select>
        <input type="text" name ="textBox" value="${textBox}">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <table border ="1" class="faculty">
            <thead>
                <tr>
                    <th>№ факультета </th>
                    <th>Факультет</th>
                    <th>Университет</th>
                    <th>Править</th>
                    <th>Удалить</th>
                </tr>
            </thead>
            <tbody>
           <c:forEach items="${facts}" var="f">
                <tr>
                   <td><c:out value="${f.facultyId}"/></td>
                    <td><c:out value="${f.facultyName}"/></td>
                    <td><c:out value="${f.universityName}"/></td>
                    <td>
                        <a href="editFaculty.html?facultyId=<c:out value='${u.facultyId}'/>">
                            править
                        </a>
                    </td>
                    <td>
                        <a href= "delFaculty.html?facultyId=<c:out value='${f.facultyId}'/> ">
                            удалить
                        </a> 
                    </td>
                </tr>
        </c:forEach>
            </tbody>
        </table>
      </center>
    </body>
</html>

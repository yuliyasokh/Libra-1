<%-- 
    Document   : addDepartments
    Created on : 22.02.2013, 17:09:44
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление кафедрами - Добавить кафедру</title>
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
				
				var $interviews = $('.department');
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
                }   
           );
    }

</script>
    </head>
    <body>
        <center>
        <form name="Form" action="addDepartmentAdded.html" method="get">
                Введите название кафедры: 
                <input type="text" name ="deptName">
                Выберите университет: 
                <select onchange="getFact();" name="univ" id="univ">
                    <option value="0"> - </option> 
                    <c:forEach items="${univers}" var="u">
                    <option value="${u.universityId}"> ${u.universityName}  
                    </option> 
                    </c:forEach>  
                </select> 
                <br>
                Факультет:
                <select name="fact" id="fact">
                    <option value="0"> Выберите университет </option> 
                </select>
                    <br>
                <input type="submit" value="Добавить" name="add">
            </form>
        <br>
        <br>
            <form name="myForm" action="showDepartmentsSearch.html" method="get">
        <select name="departmentSearch">
            <option value="0" ${departmentSearchInt == '0' ? 'selected' : ''}>Все </option>
            <option value="1" ${departmentSearchInt == '1' ? 'selected' : ''}>№ кафедры </option>
            <option value="2" ${departmentSearchInt == '2' ? 'selected' : ''}>Кафедра</option>
            <option value="3" ${departmentSearchInt == '3' ? 'selected' : ''}>Факультет</option>
            <option value="4" ${departmentSearchInt == '4' ? 'selected' : ''}>Университет</option>
        </select>
        <input type="text" name ="textBox" value="${textBox}">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <table border ="1" class="department">
            <thead>
            <tr>            
                <th><a href="#">№ кафедры </a></th>
                <th><a href="#">Кафедра</a></th>
                <th><a href="#">Факультет</a></th>
                <th><a href="#">Университет</a></th>
                <th>Править</th>
                <th>Удалить</th>
            </tr>
            </thead>
            <tbody>
           <c:forEach items="${depts}" var="d">
                <tr>
                   <td><c:out value="${d.departmentId}"/></td>
                    <td><c:out value="${d.departmentName}"/></td>
                    <td><c:out value="${d.facultyName}"/></td>
                    <td><c:out value="${d.universityName}"/></td>
                    <td>
                        <a href="editDepartment.html?departmentId=<c:out value='${d.departmentId}'/>">
                            править
                        </a>
                    </td>
                    <td>
                        <a href= "delDepartment.html?departmentId=<c:out value='${d.departmentId}'/> ">
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

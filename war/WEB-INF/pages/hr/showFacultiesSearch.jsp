<%-- 
    Document   : showFacultiesSearch
    Created on : 22.02.2013, 11:30:13
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
    <head>
        <jsp:include page="../resources.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Управление факультетами - Поиск </title>
        <link rel="stylesheet" type="text/css" href="../resources/css/table.css" />
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
				
				var $interviews = $('.bordered');
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
		<jsp:include page="../navbar.jsp" />
	</div>
	
	<div class="container-fluid">
		<div class="row-fluid">
		<div class="sidebar">
				<jsp:include page="../sidebar.jsp" />
			</div>
			<div class="span9">
				<div class="hero-unit">
        <center>
        <a href="addFaculties.html?textBox=<c:out value='${textBoxString}'/>&facultySearch=<c:out value='${facultySearchInt}'/>">
            Добавить новый факультет
        </a>
        <br>
        <br>
            <form name="myForm" action="showFacultiesSearch.html" method="get">
        <select name="facultySearch">
            <option value="0" ${facultySearchInt == '0' ? 'selected' : ''}>Все </option>
            <option value="1" ${facultySearchInt == '1' ? 'selected' : ''}>№ факультета </option>
            <option value="2" ${facultySearchInt == '2' ? 'selected' : ''}>Факультет </option>
            <option value="3" ${facultySearchInt == '3' ? 'selected' : ''}>Университет</option>
        </select>
                <input type="text" name ="textBox" value="${textBoxString}">
        <input type="submit" value="Показать" name="search">
            </form>
        <br><br>
        <table border ="1" class="bordered">
            <thead>
            <tr>
                <th><a href="#">№ факультета</a> </th>
                <th><a href="#">Факультет</a></th>
                <th><a href="#">Университет</a></th>
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
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>

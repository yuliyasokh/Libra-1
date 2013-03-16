<%-- 
    Document   : showUniversities
    Created on : 20.02.2013, 17:45:27
    Author     : Yuliya
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Управление университетами</title>
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
        <a href="addUniversities.html">Добавить новый университет</a>
        <br>
            <h3>${msg}</h3>
        <form name="myForm" action="showUniversitiesSearch.html" method="get">
        <select name="univerSearch">
            <option value="0">Все </option>
            <option value="1">№ университета </option>
            <option value="2">Университет</option>
        </select>
        <input type="text" name ="textBox">
        <input type="submit" value="Показать" name="search"> </form>
        <br><br>
        <table border ="1" class="bordered">
            <thead>
                <tr>
                    <th><a href="#"> Номер </a> </th>
                    <th><a href="#">Университет</a></th>
                    <th>Правка</th>
                    <th>Удалить</th>
                </tr>
            </thead>
            <tbody>
           <c:forEach items="${univers}" var="u">
                <tr> 
                    <td><c:out value="${u.universityId}"/></td>
                    <td><c:out value="${u.universityName}"/></td>
                    <td>
                        <a href="editUniversity.html?universityId=<c:out value='${u.universityId}'/>">
                            править
                        </a>
                    </td>
                    <td>
                        <a href= "delUniversity.html?universityId=<c:out value='${u.universityId}'/> ">
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

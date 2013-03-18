<%-- 
    Author     : Sashenka
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Типы ответов</title>  <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/docs.css" rel="stylesheet">
    <link href="resources/js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="resources/css/template.css" rel="stylesheet">		
        <jsp:include page="resources.jsp" />
        	<%--<link href="http://bootsnipp.com/bundles/bootstrapper/css/bootstrap.min.css" media="all" type="text/css" rel="stylesheet">
<link href="http://bootsnipp.com/bundles/bootstrapper/css/bootstrap-responsive.min.css" media="all" type="text/css" rel="stylesheet">
        --%><script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="navmenu">
		<jsp:include page="navbar.jsp" />
	</div>
	
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<jsp:include page="sidebar.jsp" />
			</div>
			<h3>Добавить тип</h3>
<hr>
        <form class="well-template span8" action="SubmitType.html" method="post">
            <table class="table table-striped table-condensed" border="1" cellspacing="0" cellpadding="4">
                <tr>
                    <th>Выбрать</th>
                    <th>Тип колнки</th>
                    <th>Значение</th>
                </tr>
                <tr>
                    <td><input checked name="name" type="radio" value="textstring"/></td>
                    <td>Однострочное текстовое поле(введите максимальную длину)</td>
                    <td rowspan="7">
                        <textarea rows="8" name="description"></textarea>
                    </td>
                </tr>
                <tr>
                    <td><input  name="name" type="radio" value="areastring"/></td>
                    <td>Многострочный текст(введите максимальную длину)</td>                    
                </tr>
                <tr>
                    <td><input  name="name" type="radio" value="integer"/></td>
                    <td>Поле для числа(введите максимальное и минимальное значение через ";")</td>                  
                </tr>
                <tr>
                    <td><input  name="name" type="radio" value="radioenum"/></td>
                    <td>Переключатели(введите через зарятую)</td>                    
                </tr>
                <tr>
                    <td><input  name="name" type="radio" value="checkboxenum"/></td>
                    <td>Флажки(введите через зарятую)</td>                    
                </tr>
                <tr>
                    <td><input  name="name" type="radio" value="selectenum"/></td>
                    <td>Выпадающий список(введите через зарятую)</td>                    
                </tr>
            </table>            
                <input class="btn btn-primary pull-right" type="submit" value="OK">
        </form>        
   
		</div>
	</div>
        
    </body>
</html>

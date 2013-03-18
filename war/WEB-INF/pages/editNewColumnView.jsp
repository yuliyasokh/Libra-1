<%-- 
    Author     : Sashenka
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="resources.jsp" />
                <link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="resources/css/docs.css" rel="stylesheet">
    <link href="resources/js/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="resources/css/template.css" rel="stylesheet">	
        <title>Отредактировать колонку</title>
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
                            
                         <form  class="well-template span8" method="POST" action="editSubmitColumn.html">
            
   <h4>Редактировать колонку </h4>
   <hr>
   <label>Имя колонки </label> 
   <input class="span-table" type="text" name="name" value="${current.getName()}" /></br>
           <label> Тип колонки</label>
           <select class="span-table" name="selType">
                <option value="0">Колонка для инфорации</option>
                <c:forEach items="${types}" var="t">              
                    <option <c:if test="${current.getTypeId()==t.getTypeId()}">selected</c:if> value="${t.getTypeId()}">
                        <c:out value="${t.getInfoDescription()}" />
                    </option>
                </c:forEach>
            </select></br>
            <label>Родитель</label>
            <select class="span-table" name="parentColumn">
                <option value="0">Нету родителя</option>
                <c:forEach items="${columns}" var="c">
                    <c:if test="${current.getColumnId()!=c.getColumnId()}">
                    <option <c:if test="${current.getParentColumn()==c.getColumnId()}">selected</c:if> value="${c.getColumnId()}"><c:out value="${c.getName()}" /></option>
                    </c:if> 
                </c:forEach>
            </select></br>
            <input type="hidden" name="columnId" value="${columnId}"/>
            <input class="btn btn-primary" type="submit" value="OK"/>
    </form>
			</div>
		</div>
	</div>
    
    </body>
</html>

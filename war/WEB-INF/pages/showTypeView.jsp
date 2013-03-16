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

        <% int i=1; %>
<script type="text/javascript">
function checkAll(obj) {
  'use strict';
  // Получаем NodeList дочерних элементов input формы: 
  var items = obj.form.getElementsByTagName("input"), 
      len, i;
  // Здесь, увы цикл по элементам формы:
  for (i = 0, len = items.length; i < len; i += 1) {
    // Если текущий элемент является чекбоксом...
    if (items.item(i).type && items.item(i).type === "checkbox") {
      // Дальше логика простая: если checkbox "Выбрать всё" - отмечен            
      if (obj.checked) {
        // Отмечаем все чекбоксы...
        items.item(i).checked = true;
      } else {
        // Иначе снимаем отметки со всех чекбоксов:
        items.item(i).checked = false;
      }       
    }
  }
}
</script>
        <form class="well-template span8" action="delType.html" method="POST">
        <table class="table-striped table-condensed" border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о типах данных</caption>
        <tr>
            <th class="checkbox-shift">
                <input type="image"  src="resources/images/del.png" width="25" height="25" title="Удалить" onclick="formSubmit()"/>
             </br><input id="one" type="checkbox" name="one" value="all" onclick="checkAll(this)" />
            </th>
            <th>№</th>
            <th>Название</th>
            <th>Значение</th>
            <th>Изменить</th>
        </tr>
        <c:forEach items="${types}" var="t">            
        <tr>
            <td class="checkbox-shift">
                <%--
                <a href="delType.html?type=<c:out value='${t.getTypeId()} '/>"><img src="resources\images\del.jpg"  width="25" height="25" border="0" title="удалить"/></a>
                --%>
                <input  type="checkbox" class="checkbox" name="types[]" value="<c:out value='${t.getTypeId()}'/>"/>        
            </td>
            <form action="showTypes.html" method="POST">
            <td>
                <%=i%>
                <%--${t.getTypeId()} --%>
                <input type="hidden" name="selType" value="<c:out value='${t.getTypeId()}  '/>"/>
            </td>
            <c:if test="${t.getTypeName()=='textstring'}">
            <td>Однострочное текстовое поле </td>
            </c:if>
            <c:if test="${t.getTypeName()=='areastring'}">
            <td>Многострочный текст </td>
            </c:if>
            <c:if test="${t.getTypeName()=='integer'}">
            <td>Поле для числа </td>
            </c:if>
            <c:if test="${(t.getTypeName()=='selectenum')}">
            <td>Выпадающий список</td>            
            </c:if>
            <c:if test="${(t.getTypeName()=='checkboxenum')}">
            <td>Флажки</td>            
            </c:if>
            <c:if test="${(t.getTypeName()=='radioenum')}">
            <td>Переключатели</td>            
            </c:if>
            <td>
                <form method="POST" action="showTypes">
                <div class="nya<c:out value='${t.getTypeId()}'/>">${t.getInfoDescription()}</div>
                <div class="nya<c:out value='${t.getTypeId()}'/>" style="display:none">
                        <input type="text" name="description" value="<c:out value='${t.getDescription()}'/>"/>
                        <input type="submit" value="OK" title="внести изменения" />           
                </form>
                </div>  
               <%-- ${t.getDescription()}--%>
            </td>
            
            <td class="checkbox-shift">
                <%-- <input type="image"  src="resources\images\edit.png" width="25" height="25" title="внести изменения" OnClick="Forma1.submit()"/>--%>
                
                <%--    <input type="image"  src="resources\images\edit.png" width="25" height="25" title="внести изменения" onclick="location.href='showTypes.html'"/>--%>
            <%-- <input type="image"  src="resources/images/edit.png" width="25" height="25" title="внести изменения" onclick="location.href='showTypes.html'"/>
--%>

<a href="javascript:$('.nya<c:out value='${t.getTypeId()}'/>').toggle()"><img src="resources/images/edit.png" width="25" height="25" title="внести изменения"/></a>                        
    
             <%--  <a href="showTypes.html"><img src="../../resources/images/edit.png"/></a> --%>
            </td>
            <%--<td>
                <input type="text" name="name"/>
            </td>--%>
        </tr>
            </form>
            <% i++;%>
        </c:forEach>
        </table>
            </form>
		</div>
	</div>
        
    </body>
</html>

<%-- 
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Колонки</title>
        <style type="text/css">
   SELECT {
    width: 300px; /* Ширина списка в пикселах */
   }
  </style>
    </head>
    <body>
    <form method="POST" action="SubmitColumn.html">
            Введите имя колонки <input type="text" name="name" /></br>
            Выберите тип колонки<select name="selType">
                <option value="0">Колонка для инфорации</option>
                <c:forEach items="${types}" var="t">
                    <option value="${t.getTypeId()}"><c:out value="${t.getInfoDescription()}" /></option>
                </c:forEach>
            </select></br>
            Выберите тип колонки<select name="parentColumn">
                <option value="0">Нету родителя</option>
                <c:forEach items="${columns}" var="c">
                    <option value="${c.getColumnId()}"><c:out value="${c.getName()}" /></option>
                </c:forEach>
            </select></br>
            <input type="hidden" name="templateId" value="${templateId}"/>
            <input type="submit" value="OK"/>
    </form>
            
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
           <%-- <form action="delColumns.html" method="POST">--%>
    <table border="1" cellspacing="0" cellpadding="4">
        <caption>Информация о колонках</caption>
        <thead>
        <tr>
            <th>
             <input type="image"  src="resources/images/del.jpg" width="25" height="25" title="Удалить" onclick="formSubmit()"/>
             </br><input id="one" type="checkbox" name="one" value="all" onclick="checkAll(this)" />
            </th>
            <th>Номер</th>
            <th>Название</th>
            <th>Поменять местами с</th>
            <th>Возможные варианты ответов</th>
            <th>Редактировать</th>
        </tr>
        </thead>
        <tbody>  
            <c:forEach items="${columns}" var="c">
            <tr>
                <td>
               <input  type="checkbox" class="checkbox" name="delete[]" value="<c:out value='${c.getColumnId()}'/>"/>        
                </td>
                <td>${c.getNumbers()}</td>
                <td>${c.getName()}</td>
                <td> 
                    <form action="changeColumn.html" method="POST">
                        <input name="column1" type="hidden" value="${c.getColumnId()}">
                <select name="column2" size="1">
                <c:forEach items="${columns}" var="list">  
                    <c:if test="${(list.getParentColumn()==c.getParentColumn())&&(list.getColumnId()!=c.getColumnId())}">
                        <option value="${list.getColumnId()}">${list.getName()}</option>
                </c:if>
                </c:forEach>
                </select>  
                    <input type="submit" value="OK"/>
                    </form>
                </td>
                <td>
                    <c:if test="${c.getTypeId()!=0}">
                        ${c.getTypeDescription()}
                    </c:if>
                    <c:if test="${c.getTypeId()==0}">
                        Нету значений
                    </c:if>
                </td>
                <td><a href="editColumn.html?columnId=<c:out value='${c.getColumnId()}'/>">Редактировать</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
               <%-- </form>--%>
    </body>
</html>

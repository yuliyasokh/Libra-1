<%-- 
    Document   : editInterviewDate
    Created on : 12.02.2013, 1:09:51
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
    <head>
        <jsp:include page="../resources.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Управление датами - правка</title>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript" charset="utf-8">   
</script>
<script>
    $(document).ready(function() {
        $("#type").bind("change", function(){    
        if ($("#type").val()==1) {
        $("#hrDiv").css("display","block");
        $("#techDiv").css("display","none");
        }
        else {
        $("#hrDiv").css("display","none");
        $("#techDiv").css("display","block");
        }
       
    });
    
    if ($("#type").val()==1) {
        $("#hrDiv").css("display","block");
        $("#techDiv").css("display","none");
        }
        else {
        $("#hrDiv").css("display","none");
        $("#techDiv").css("display","block");
        }
       
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
        <h2 align="center"> Правка даты интервью </h2>
        <form method="POST" action="doneDate.html">
         <table border="1" cellspacing="0" cellpadding="4">
             <tr>
                 <td>№ Даты</td>
                  <td>Тип</td>
                  <td>Дата</td>
                  <td>Время</td>
                  <td>Продолжительность</td>
                 </tr>
        <td>
            <label for="interviewDateId">${d.interviewDateId}</label>
        <input type="hidden" name="interviewDateId" value="<c:out value='${d.interviewDateId}  '/>"/>
        </td>
        <td>
            <select name="type" id="type" >
            <option value="1" ${typeInt == '1' ? 'selected' : ''}> Hr </option>
            <option value="2" ${typeInt == '2' ? 'selected' : ''}> Tech </option>
            </select>
        </td>
        <td><input type="text" name="dateInter" value="${d.dateInter}"/></td>
        <td><input type="text" name="timeInter" value="${d.timeInter}"/></td>
        <td><input type="text" name="interviewDuration" value="${d.interviewDuration}"/></td>
        </table>
        <br>
        Выберите интервьюеров:
        <br> 
        
        <div id="hrDiv">
        <c:forEach items="${checkedIntersHr}" var="i">
            <input type="checkbox" name="checkInterviewers[]" id="interviewers" value=<c:out value="${i.userid}"/> checked> 
           <label for="interviwers"> ${i.inters}</label> 
            <br>
        </c:forEach>
        <c:forEach items="${uncheckedIntersHr}" var="i">
            <input type="checkbox" name="checkInterviewers[]" id="interviewers" value=<c:out value="${i.userid}"/> >
            <label for="interviwers"> ${i.inters}</label>  
            <br>
        </c:forEach>
        </div>
        
        <div style="display: none;"  id="techDiv">
       <c:forEach items="${checkedIntersTech}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> checked>
            <label for="interviwers"> ${i.inters}</label> 
            <br>
        </c:forEach>
        <c:forEach items="${uncheckedIntersTech}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> > 
            <label for="interviwers"> ${i.inters}</label> 
            <br>
        </c:forEach>
        </div>
        <input value="Назад" onclick="location.href='interviewDate.html'" type="button"/>
        <input type="submit" name="submitDate" value="Изменить">
        </form>
        </center>
                                </div>
                        </div>
                </div>
        </div>
    </body>
</html>

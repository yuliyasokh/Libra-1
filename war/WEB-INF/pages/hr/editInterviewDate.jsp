<%-- 
    Document   : editInterviewDate
    Created on : 12.02.2013, 1:09:51
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
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
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> checked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        <c:forEach items="${uncheckedIntersHr}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> unchecked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        </div>
        
        <div style="display: none;"  id="techDiv">
       <c:forEach items="${checkedIntersTech}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> checked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        <c:forEach items="${uncheckedIntersTech}" var="i">
            <input type="checkbox" name="checkInterviewers[]" value=<c:out value="${i.userid}"/> unchecked> <c:out value="${i.inters}"/> <br>
        </c:forEach>
        </div>
        <input value="Назад" onclick="location.href='interviewDate.html'" type="button"/>
        <input type="submit" name="submitDate" value="Изменить">
        </form>
        </center>
    </body>
</html>

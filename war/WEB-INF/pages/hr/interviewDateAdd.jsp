<%-- 
    Document   : interviewDateAdd
    Created on : 26.02.2013, 14:12:36
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" >
    <head>
        <title>Управление датами интервью - добавление</title>
          <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.js">    
          </script>
         <style type="text/css" media="all">@import "../resources/css/timePicker.css";</style>
        <script type="text/javascript" src="../resources/js/jquery.timePicker.js"></script>
      <script type="text/javascript">
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
 });
  jQuery(function() {
    $("#time3, #time4").timePicker();
        
    // Store time used by duration.
    var oldTime = $.timePicker("#time3").getTime();
    
    // Keep the duration between the two inputs.
    $("#time3").change(function() {
      if ($("#time4").val()) { // Only update when second input has a value.
        // Calculate duration.
        var duration = ($.timePicker("#time4").getTime() - oldTime);
        var time = $.timePicker("#time3").getTime();
        // Calculate and update the time in the second input.
        $.timePicker("#time4").setTime(new Date(new Date(time.getTime() + duration)));
        oldTime = time;
      }
    });
    // Validate.
    $("#time4").change(function() {
      if($.timePicker("#time3").getTime() > $.timePicker(this).getTime()) {
        $(this).addClass("error");
      }
      else {
        $(this).removeClass("error");
      }
    });
    
  });
</script>
        <link rel="stylesheet" type="text/css" href="../resources/css/tcal.css" />
	<script type="text/javascript" src="../resources/js/tcal.js">   
        </script> 
    </head>
    <body>
                                    <center>
        
        <h2>Добавить новую дату интервью</h2>
         <form name="Form" action="interviewDateAdded.html" method="get">
       <br>
         Тип:
               <select name="type" id="type" style="width: 90px"  class="selectwidth">
            <option value="1" > Hr </option>
            <option value="2"> Tech </option>
            </select> 
         <br>
               
           <div>Дата:
               <input type="text" name="begin" class="tcal" value=""  style="width: 100px" />
           </div>
	
             <form name="Form" action="interviewDateAdded.html" method="get">
                 <input type="hidden" value='${type}' name="type"> 
                 <input type="hidden" value='${begin}' name="begin"> 
             Время начала и конца: 
            <div>
                <input name="timeStart" type="text" id="time3" size="10" value="08:00" style="width: 50px"/> 
            - 
            <input name="end" type="text" id="time4" size="10" value="09:00" style="width: 50px"/>
            </div>
               Продолжительность: 
               <input type="text" name="duration" style="width: 50px" >  
        <br> 
        Выберите интервьюеров:</br> 
        <div id="hrDiv">
        <c:forEach items="${Inters}" var="i">
            <input type="checkbox" name="checkInterviewers[]" id="<c:out value="${i.userid}"/>" value=<c:out value="${i.userid}"/> >
           <label for="<c:out value="${i.userid}"/>">${i.inters} </label><br>
        </c:forEach>
        </div>
        <div style="display: none;"  id="techDiv">
        <c:forEach items="${intersTech}" var="i">
            <input type="checkbox" name="checkInterviewers[]" id="<c:out value="${i.userid}"/>" value=<c:out value="${i.userid}"/> > 
           <label for="<c:out value="${i.userid}"/>">${i.inters}  </label> </br>
        </c:forEach>
        </div>
            </br> 
        <input type="submit" value="Добавить">
    </form>                      
      </center>
    </body>
</html>

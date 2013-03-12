<%-- 
    Document   : showStudentByEducation
    Created on : 16.02.2013, 21:30:18
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find students</title> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript" charset="utf-8">   
</script>
<script>
function getFact(){
 $.post("faculty.html",{"universityId":$("#univ").val() },
                function(data) {
                   $("#fact").html(data);
                      getDept();
                }   
           );
    }
  function getDept(){
 $.post("department.html",{"facultyId":$("#fact").val() },
                function(data) {
                   $("#dept").html(data);
                }        
           );
    }  
</script>
</head>
   <body>
    <center>
       <h2 align="center">Список студентов</h2>   
        <form method="post" action="showStudentByEducation.html">
       Университет:
       <select onchange="getFact();" name="univ" id="univ">
          <option value="0"> Все </option> 
           <c:forEach items="${univers}" var="u">
            <option value="${u.universityId}"> ${u.universityName}  
                </option> 
           </c:forEach>  
       </select> 
       <br>
       Факультет:
        <select onchange="getDept();" name="fact" id="fact">
             <option value="0"> Выберите университет </option> 
        </select>
       <br>
       Кафедра: 
        <select name="dept" id="dept">
             <option value="0"> Выберите факультет </option> 
        </select>
       <br>
       <br>       
       <input type="submit" value="Поиск">
        </form>
          <form method="GET">
          <table border ="1"> 
            <th>
                <a href="sortedByEducation.html?orderBy=appId&direction=asc&universityId=<c:out value='${univ}'/>&facultyId=<c:out value='${fact}'/>&departmentId=<c:out value='${dept}'/>">
                    № анкеты
                    </a>
            </th>
            <th>
              <a href="sortedByEducation.html?orderBy=firstName&direction=asc&universityId=<c:out value='${universityId}'/>&facultyId=<c:out value='${facultyId}'/>&departmentId=<c:out value='${departmentId}'/>">
                Имя
                </a>
            </th>
            <th>
              <a href="sortedByEducation.html?orderBy=lastName&direction=asc&universityId=<c:out value='${universityId}'/>&facultyId=<c:out value='${facultyId}'/>&departmentId=<c:out value='${departmentId}'/>">
                Фамилия
                </a>
            </th>
            <th>
              <a href="sortedByEducation.html?orderBy=email&direction=asc&universityId=<c:out value='${universityId}'/>&facultyId=<c:out value='${facultyId}'/>&departmentId=<c:out value='${departmentId}'/>">  
                Email
                </a>
            </th>
            <th></th>
            <th></th>
            <th></th>

  <c:forEach items="${Model}" var="s">
    <tr>
        <form action="showStudentInterview.html" method="POST">
      <td><input type="hidden" name="appId" value="<c:out value='${s.getAppId()}'/>"/>${s.getAppId()}</td>
      <td><input type="hidden" name="firstName" value="<c:out value='${s.getName()}'/>"/>${s.getName()}</td>
      <td><input type="hidden" name="lastName" value="<c:out value='${s.getLastName()}'/>"/>${s.getLastName()}</td>
      <td><input type="hidden" name="email" value="<c:out value='${s.getEmail()}'/>"/>${s.getEmail()}</td>
      <input type="hidden" name="view" value="1"/>
      <td> <input type="submit" value="Анкета"></td>
                <td> <input type="submit" value="Интервью"></td>
          </form>
      <td> <input type="submit" value="Удалить"></td>
  </tr>
    </c:forEach>
    </table>
       </center>
    </body>
</html>
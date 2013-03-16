<%-- 
    Document   : appFormView
    Created on : 22.02.2013, 23:34:05
    Author     : Sashenka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/Libra/resources/css/main.css"/>
<link rel="stylesheet" href="/Libra/resources/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/Libra/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="/Libra/resources/css/bootstrap-fileupload.min.css" />
<link rel="stylesheet" href="/Libra/resources/css/style.css" />
<script src="/Libra/resources/js/jquery-1.9.0.min.js"></script>
<script src="/Libra/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="/Libra/resources/js/bootstrap-fileupload.min.js"></script>
<title>заполнение анкеты</title>
    </head>
    <body>
        <div class="container">
            <div class="appform" >
                <form:form action="submitForm.html" method="POST" commandName="columnFields"> 
                    <c:forEach items="${columns}" var="c">
                         <c:if test="${c.getLevel()==1}">
                            <h1> ${c.getName()}</h1>
                        </c:if>
                        <c:if test="${c.getLevel()!=1}">
                             ${c.getName()}
                             <c:if test="${c.getTypeName()=='areastring'}">
                                 <textarea name="map[${c.getColumnId()}]" ></textarea>
                             </c:if>
                             <c:if test="${c.getTypeName()=='textstring'}">
                                 <input name="map[${c.getColumnId()}]"  type="text"/>
                             </c:if>
                             <c:if test="${c.getTypeName()=='selectenum'}">
                                 <form:select path="map[${c.getColumnId()}]">
                                     <c:forEach items="${c.getcT().getEmums()}" var="t">
                                         <form:option value="${t}">${t}</form:option>
                                    </c:forEach>
                                 </form:select>
                             </c:if>
                             <c:if test="${c.getTypeName()=='checkboxenum'}">
                                     <c:forEach items="${c.getcT().getEmums()}" var="t">
                                         <form:checkbox  path="map[${c.getColumnId()}]" value="${t}"/>${t}
                                    </c:forEach>
                             </c:if>
                             <c:if test="${c.getTypeName()=='radioenum'}">
                                     <c:forEach items="${c.getcT().getEmums()}" var="t">
                                         <form:radiobutton  path="map[${c.getColumnId()}]" value="${t}"/>${t}
                                    </c:forEach>
                             </c:if>
                                 
                             <c:if test="${c.getTypeName()=='integer'}">
                                 <input name="map[${c.getColumnId()}]"  type="number" size="30"  min="${c.getcT().getMin()}" max="${c.getcT().getMax()}" value="1"/>     
                             </c:if>
                                 </br>
                        </c:if>                          
                    </c:forEach>
                                 <input type="submit"  value="ОК"/>
                </form:form>
            </div>
      </div>
    </body>
</html>

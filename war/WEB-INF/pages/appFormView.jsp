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
<title>Регистрация</title>
    </head>
    <body>
        <div class="container">
            <div class="appform" >
                <form:form method="POST" commandName="columnFields"> 
                    <c:forEach items="${topics}" var="t">
                        <c:if test="${t.getLevel()==1}">
                            <h1> ${t.getTopicName()}</h1>
                        </c:if>
                        <c:if test="${t.getLevel()!=1}">
                            <h4> ${t.getTopicName()}</h4>
                        </c:if>   
                        <c:forEach items="${columns}" var="c">
                            <c:if test="${c.getTopicId()==t.getTopicId()}">
                              <label>${c.getName()}:</label>
                                <c:if test="${c.getTypeName()=='enum'}">
                                    <c:forEach items="${enums}" var="e">
                                        <c:if test="${e.key==c.getTypeId()}">
                                            <c:forEach items="${e.value}" var="ee">                                  
                                               <form:radiobutton path="map[${c.getColumnId()}]" value="${ee}"/>${ee}
                                            </c:forEach>
                                        </c:if>  
                                    </c:forEach>  
                                </c:if>  
                                <c:if test="${c.getTypeName()=='multienum'}">
                                    <c:forEach items="${enums}" var="e">
                                        <c:if test="${e.key==c.getTypeId()}">
                                            <c:forEach items="${e.value}" var="ee">                                  
                                                <form:checkbox path="map[${c.getColumnId()}]" value="${ee}"/>${ee}
                                            </c:forEach>
                                        </c:if>  
                                    </c:forEach>  
                                </c:if>  
                                <c:if test="${c.getTypeName()=='integer'}">
                                   <form:input path="map[${c.getColumnId()}]"  size="5" class="span3"/>
                                    </br>
                                </c:if>  
                                <c:if test="${c.getTypeName()=='string'}">
                                    <form:input path="map[${c.getColumnId()}]" class="span3" />
                                    </br>
                                </c:if>     
                            </c:if>          
                        </c:forEach>
                            <c:if test="${t.getRequireOther()==1}">
                                <form:input path="otherMap[${t.getTopicId()}].columnName" class="span3"/></br>
                                <form:textarea path="otherMap[${t.getTopicId()}].Value" /></br>
                            </c:if>     
                    </c:forEach>
                                <input type="submit" />
                </form:form>
            </div>
      </div>
    </body>
</html>

<%-- 
    Document   : faculty
    Created on : 18.02.2013, 4:40:04
    Author     : Yuliya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <option value="0"> Все </option>
        <c:forEach items="${fact}" var="f">
            <option value="${f.facultyId}"> ${f.facultyName} </option>
        </c:forEach>

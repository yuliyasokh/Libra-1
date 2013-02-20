<%-- 
    Author     : Sashenka
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить результаты</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    </head>
    <body>
        <c:if test="${existsComment==0}">
        <h1>Добавить результаты для анекты № ${appId} </h1>
        <form method="POST" action="addResultSubmit.html">
            <input type="text" name="mark"/>
            </br>
            <textarea name="comment"></textarea>
            </br>
            <input type="submit" value="Добавить"/>
        </form>   
        </c:if>

        <c:forEach items="${interviewResult}" var="ir">
            
            <h3>${ir.getFio()}</h3>
        <c:if test="${userId==ir.getUserId()}">
        <form method="POST" action="updateResultSubmit.html">
        </c:if>
            <p>Оценка: 
                <div class="nya<c:out value='${ir.getUserId()}'/>">${ir.getMark()}</div>
                <div class="nya<c:out value='${ir.getUserId()}'/>" style="display:none">
                    <c:if test="${userId==ir.getUserId()}">
                        <input type="text" name="mark" value="<c:out value='${ir.getMark()}'/>"/>
                    </c:if>
                </div>
            </p>
            <p>Комментарий: 
                <div class="nya<c:out value='${ir.getUserId()}'/>">${ir.getComments()}</div>
                <div class="nya<c:out value='${ir.getUserId()}'/>" style="display:none">
                    <c:if test="${userId==ir.getUserId()}">
                        <textarea name="comment">${ir.getComments()}</textarea>
                    </c:if>
                </div>
            </p>
            
        <c:if test="${userId==ir.getUserId()}">
            <div style="display:none" class="nya<c:out value='${ir.getUserId()}'/>">
                <input type="submit" value="Внести изменения"/>
            </div>
        </form>   
        </c:if>
            <c:if test="${userId==ir.getUserId()}">
                <a href="javascript:$('.nya<c:out value='${userId}'/>').toggle()">Редактировать</a> <a href="deleteResult.html?interviewId=<c:out value='${InterviewId}'/>">Удалить</a>              
            </c:if>
        </c:forEach>
    </body>
</html>

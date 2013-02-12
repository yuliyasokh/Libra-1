<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Регистрационные данные</title>
</head>
<body>

<c:forEach items="${appForm.personal}" var="p">
<c:out value="${p.key}"></c:out> 
<c:out value="${p.value}"></c:out>
<br> 
</c:forEach>

<c:forEach items="${appForm.programmingLanguagesMap}" var="m">
<c:out value="${m.key}"></c:out> 
<c:out value="${m.value}"></c:out>
<br>
</c:forEach>
<br>
<br>

<c:forEach items="${appForm.knowledgesMap}" var="m">
<c:out value="${m.key}"></c:out> 
<c:out value="${m.value}"></c:out>
<br> 
</c:forEach>
<br><br>
<c:forEach items="${appForm.textFieldsMap}" var="t">
<c:out value="${t.key}"></c:out> 
<c:out value="${t.value}"></c:out>
<br> 
</c:forEach>
<br><br>

</body>
</html>
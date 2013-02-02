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
Success
<p>${signupForm.name} ${signupForm.patronymic} ${signupForm.lastName}</p><br>
<p>${signupForm.email}</p><br>
<p>${signupForm.university} ${signupForm.faculty} ${signupForm.univerTerm} курс</p><br>

</body>
</html>
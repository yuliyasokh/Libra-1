<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Libra - Войти</title>
</head>

<body>

<h2>Введите данные для входа</h2>
<form:form method="POST" action="/Libra/loginProceed">
   <table>
   
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit" value="Войти"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>
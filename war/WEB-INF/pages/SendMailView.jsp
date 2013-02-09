<%-- 
    Document   : SendMailView
    Created on : 08.02.2013, 22:22:29
    Author     : MorrDeck
--%>

<%@page contentType="text/html" pageEncoding="windows-1251"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <form:form method="POST" action="/Libra/sendmailsubmit.html">
                <form:label path="adress">Email:</form:label>
                <form:input path="adress" />
                <br>
                <form:label path="user">User:</form:label>
                <form:input path="user" />
                <br>
                <form:label path="code">Code:</form:label>
                <form:input path="code" />
                <br>
                <input type="submit" value="Send"/>               
            </form:form>
            
            
        </h1>
    </body>
</html>

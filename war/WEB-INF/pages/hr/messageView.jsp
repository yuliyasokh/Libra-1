<%-- 
    Author     : Alexander Lebed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Об интервью</title>
    </head>
    <body>
        <!-- Отчет о произошедшем действии -->
        <h1>${message}</h1>
            <br>${view == 0 ? '<a href="showStudentbyIdView.html">Назад</a>' : '<a href="showStudentByEducation.html">Назад</a>'}
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="Libra">
<link rel="stylesheet" 
	href="<c:url value="/resources/css/main.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-responsive.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>" />
<link rel="stylesheet" 
	href="<c:url value="/resources/css/style.css"/>" />
<script src="<c:url value="/resources/js/jquery-1.9.0.min.js" />"></script>
<script
	src="<c:url value="/resources/js/modernizr-2.6.2-respond-1.1.0.min.js"/>"></script>
<title>Анкета</title>
</head>
<body>
    <div class="container-fluid">
      <h1 class="heading">Анкета</h1>
      <h3 class="heading">Персональные данные</h3>
      <div class="row-fluid row-fluid-2">
        <span class="span2"></span>
        <span class="span10">
          <div class="row-fluid">
            <span class="span4">
              <h5 class="heading">Контактная информация</h5>
              Имя:<c:out value="${form.personal['firstname']}"/><br>
              Отчество:<c:out value="${form.personal['patronymic']}"/><br>
              Фамилия:<c:out value="${form.personal['lastname']}"/><br>
              Email:<c:out value="${form.personal['email']}"/><br>
              Номер телефона:<c:out value="${form.personal['phonenumber']}"/>
            </span>
            <span class="span4">
              <h5 class="heading">Образование</h5>
              ВУЗ:<c:out value="${form.personal['university']}"/><br>
              Факультет:<c:out value="${form.personal['faculty']}"/><br>
              Кафедра:<c:out value="${form.personal['department']}"/><br>
              Курс:<c:out value="${form.personal['course']}"/>	Год выпуска:<c:out value="${form.personal['graduated']}"/>
            </span>
          </div>
        </span>
      </div>
      <div class="row-fluid row-fluid-1">
        <span class="span12">
          <h3 class="heading">Интересы</h3>
          <c:forEach items="${form.checkboxAnswersList}" var="t">
          	<h5>${t.header}</h5>
          		<c:forEach items="${t.cbAnswers}" var="a">
          			${a}
          		</c:forEach>
          </c:forEach>
        </span>
      </div>
      <div class="row-fluid row-fluid-1">
        <span class="span12">
          <h3 class="heading">Достоинства</h3>
          <c:forEach items="${form.gradeAnswersList}" var="t">
          	<span class="span4"><h5>${t.header}</h5>
          		<c:forEach items="${t.values}" var="a">
          			${a.key} ${a.value}<br>
          		</c:forEach>
          		</span>
          </c:forEach>
        </span>
      </div>
      <div class="row-fluid">
        <span class="span12">
          <h3 class="heading">Дополнительные сведения</h3>
          <c:forEach items="${form.textFieldsAnswersList}" var="t">
          			${t.key} ${t.value}
          </c:forEach>
        </span>
      </div>
    </div>
  </body>
</html>
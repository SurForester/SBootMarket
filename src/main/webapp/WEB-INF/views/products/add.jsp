<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <title>Добавить продукт</title>
  <h>Введите параметры продукта</h>
</head>
<body>
<form:form action="processForm" modelAttribute="product">
  Product id: <form:input path="id" readonly="true"/>
  <br>
  Product title: <form:input path="title"/>
  <br>
  Product cost: <form:input path="cost"/>
  <br>
  <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
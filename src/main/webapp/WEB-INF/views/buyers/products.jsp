<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список продуктов покупателя - ${name}</title>
</head>
<body>
<ul>
  <c:forEach var="item" items="${buyed_products}">
  <li>${item}</li>
  </c:forEach>
</body>
</html>

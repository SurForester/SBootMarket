<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список продуктов</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <a href="/products/add">Добавить продукт</a>
</head>

<body>
<ul>
    <c:forEach var="item" items="${products}">
    <li>ProductID=${item.id}; ProductTitle=${item.title}; ProductCost=${item.cost}
        <a href="${pageContext.request.contextPath}/products/delete/${item.id}">Удалить</a></li>
    </c:forEach>
</body>

<footer>
    <br/>
    <a href="${pageContext.request.contextPath}/">Главная страница</a>
</footer>
</html>

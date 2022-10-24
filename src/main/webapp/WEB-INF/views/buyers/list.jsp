<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Список покупателей</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
    <a href="${pageContext.request.contextPath}/">Главная страница</a>
</head>

<body>
<ul>
    <c:forEach var="item" items="${buyers}">
    <li>ProductID=${item.id}; ProductTitle=${item.name}
        <a href="${pageContext.request.contextPath}/buyers/products/${item.id}">Купленные продукты</a></li>
    </c:forEach>
</body>

<footer>

</footer>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<h1>Welcome</h1>
<h2>${message}</h2>

</body>
<footer>
    <a href="${pageContext.request.contextPath}/products/">К списку продуктов</a>
    <a href="${pageContext.request.contextPath}/buyers/">К списку покупателей</a>
</footer>
</html>
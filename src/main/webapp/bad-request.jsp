<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Не ломайте лабу</title>
    <link rel="stylesheet" type="text/css" href="styles/bad-request.css">
</head>
<body>
    <h1>Не ломайте лабу</h1>
    <h3><%= request.getAttribute("err-msg") %></h3>
</body>
</html>

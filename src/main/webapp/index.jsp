<%--
  Created by IntelliJ IDEA.
  User: rashid
  Date: 12.05.2018
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/styles.css"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <title>Авторизация пользователя</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <fieldset width="30%">
        <legend>Авторизация</legend>
        <input type="text" placeholder="Имя пользователя" name="userName"><BR>
        <input type="password" placeholder="Пароль" name="userPassword"><BR>
        <input type="submit" value="OK">
    </fieldset>
</form>
</body>
</html>

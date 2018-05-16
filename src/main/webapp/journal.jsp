<%@ page import="ru.innopolis.stc09.education.obj.Groupp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link href="styles.css" rel="stylesheet" type="text/css">
    <title>Журнал успеваемости</title>
</head>
<body>
<h1>Журнал успеваемости</h1>
<p>Список групп</p>
<% if (request.getAttribute("groupps") != null) {
    for (Groupp groupp : (ArrayList<Groupp>) request.getAttribute("groupps")) {
        response.getWriter().println("<p>" + groupp.getName() + "</p>");
    }
}
%>
</body>
</html>
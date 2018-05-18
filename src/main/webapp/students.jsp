<%@ page import="ru.innopolis.stc09.education.obj.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/styles.css"/>
    <title>Список студентов</title>
</head>
<body>
<h1>Список студентов групп</h1>
<table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td>ФИО студента</td>
    </tr>
    <% if (request.getAttribute("students") != null) {
        for (User student : (ArrayList<User>) request.getAttribute("students")) {%>
    <tr>
        <td>
            <a href="student.jsp?Id=<%=student.getId() %>" class="button"><%=student.getFullname() %>
            </a></td>
    </tr>
    <%
            }
        }%>
</table>
</body>
</html>

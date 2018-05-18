<%@ page import="ru.innopolis.stc09.education.obj.Groupp" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/styles.css"/>
    <title>Группы</title>
</head>
<body>
<h3>Список групп</h3>
<table border="1" cellpadding="0" cellspacing="0">
    <tr>
        <td>Группа</td>
        <td>Начало обучения</td>
        <td>Конец обучения</td>
    </tr>
    <% if (request.getAttribute("groupps") != null) {
        for (Groupp groupp : (ArrayList<Groupp>) request.getAttribute("groupps")) {%>
    <tr>
        <td>
            <a href="${pageContext.request.contextPath}/students?groupId=<%=groupp.getId() %>"
               class="button"><%=groupp.getName() %>

            </a></td>
        <td><%=groupp.getStartDate() %>
        </td>
        <td><%=groupp.getFinishDate() %>
        </td>
    </tr>
    <%
    }
        }%>
</table>
</body>
</html>
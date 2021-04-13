<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deconnexion</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("accueil.jsp");
%>
</body>
</html>
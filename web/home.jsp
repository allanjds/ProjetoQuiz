<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h2> Bem vindo <%=session.getAttribute("user.login")%> </h2>
        
        
        <h2>Clique <a href="quiz.jsp">aqui</a> para iniciar seu teste de conhecimento</h2>
    </body>
</html>


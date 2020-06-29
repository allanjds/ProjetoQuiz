<%-- 
    Document   : quiz
    Created on : 18/06/2020, 23:30:19
    Author     : Anna
--%>
<%@page import="db.Resultado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Resultado> list = new ArrayList<>();
    list = Resultado.listaResultados();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>

        <h2>Clique <a href="quiz.jsp">aqui</a> para iniciar seu teste de conhecimento</h2>

        <hr/>

        <table>
            <h3>Ultimos 10 realizados </h3>
            <% for (Resultado r : list) {%>
            <p><%=r.getUser()%></p>
            <p><%=r.getResult()%></p>
            <hr>
            <% }%>
        </table>

        <hr/>
        <table>
            <h3>Seus Ultimos Resultados</h3>
            <tbody>
            </tbody>
        </table>
    </body>
</html>


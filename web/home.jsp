<%-- 
    Document   : quiz
    Created on : 18/06/2020, 23:30:19
    Author     : Anna
--%>
<%@page import="model.Ranking"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h3>Ranking Geral</h3>
            <tbody><%
                for (Ranking r : Ranking.orderByResult(Ranking.getRanking())) {%>
                <tr>
                    <td><%= r.getUser()%></td>
                    <td><%= r.getResult()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>

        <hr/>
        <table>
            <h3>Seus Ultimos Resultados</h3>
            <tbody><%
                for (Ranking r : Ranking.orderById(Ranking.getRanking())) {%>
                <tr>
                    <td><%= r.getUser()%></td>
                    <td><%= r.getResult()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>


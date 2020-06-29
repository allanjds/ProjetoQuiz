<%-- 
    Document   : quiz
    Created on : 18/06/2020, 23:30:19
    Author     : Anna
--%>
<%@page import="db.Resultado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <title>Home</title>
    </head>
    <body>
        <div class="container">
            <%@include file="WEB-INF/jspf/menu.jspf" %>

            <br>
            <div class="row">
                <div class="col">
                    <h3 class="text-center">Ultimos 10 realizados </h3>

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Usuário</th>
                                <th scope="col">Pontuação</th>
                                <th scope="col">Data</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Resultado r : Resultado.listaResultados()) {%>
                            <tr>
                                <td><%= r.getUser()%></td>
                                <td><%= r.getResult()%></td>
                                <td><%= r.getDate()%></td>
                            </tr>
                            <% }%>

                        </tbody>
                    </table>
                </div>

                <div class="col">
                    <h3 class="text-center">Top 10</h3>

                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Usuário</th>
                                <th scope="col">Pontuação</th>
                                <th scope="col">Data</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Resultado r : Resultado.listaTop10()) {%>
                            <tr>
                                <td><%= r.getUser()%></td>
                                <td><%= r.getResult()%></td>
                                <td><%= r.getDate()%></td>
                            </tr>
                            <% }%>

                        </tbody>
                    </table>
                </div>

            </div>

        </div>
    </body>
</html>


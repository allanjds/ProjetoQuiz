<%-- 
    Document   : quiz
    Created on : 20/06/2020, 13:30:19
    Author     : Anna
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Questao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int pergunta = 1;
    int numero = 0;
    ArrayList<Questao> questoesList = new ArrayList<>();
    questoesList = Questao.listaQuestoes();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <title>Quiz - Teste seus conhecimentos</title>
    </head>
    <body>
        <div class="container">

            <%@include file="WEB-INF/jspf/menu.jspf" %>
            <h2 class="text-center">Teste seus conhecimentos</h2>

            <hr/>


            <%for (Questao q : questoesList) {%>
            <p><%= q.getEnunciated()%></p>
            <input name="pergunta_<%=pergunta%>" type="radio" value=<%=numero = q.geraNumeroRandom()%>>
            <label for="<%=numero%>"><%=numero%></label><br>

            <input name="pergunta_<%=pergunta%>" type="radio" value=<%=numero = q.geraNumeroRandom()%>>
            <label for="<%=numero%>"><%=numero%></label><br>

            <input name="pergunta_<%=pergunta%>" type="radio" value=<%=numero = q.geraNumeroRandom()%>>
            <label for="<%=numero%>"><%=numero%></label><br>

            <input name="pergunta_<%=pergunta%>" type="radio" value=<%=numero = q.geraNumeroRandom()%>>
            <label for="<%=numero%>"><%=numero%></label><br>

            <input name="pergunta_<%=pergunta%>" type="radio" value=<%= q.getAnswer()%>>
            <label for="<%= q.getAnswer()%>"><%= q.getAnswer()%></label><br>

            <br>  
            <hr/>
            <% pergunta = pergunta + 1;
                }%>

        </div>


        <a href="home.jsp">Voltar</a>
    </body>
</html>
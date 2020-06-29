<%-- 
    Document   : quiz
    Created on : 20/06/2020, 13:30:19
    Author     : Anna
--%>

<%@page import="db.Resultado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="db.Questao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int numero = 0;

    int pergunta = 0;
    int resultado = -1;

    ArrayList<Questao> questoesList = new ArrayList<>();
    questoesList = Questao.listaQuestoes();

    if (request.getParameter("salva_quiz") != null) {
        resultado = 0;

        String usuario = request.getParameter("usuario");

        for (int i = 0; i < questoesList.size(); i++) {
            String respostaCerta = questoesList.get(i).getAnswer();
            String respostaUsuario = request.getParameter("pergunta_" + i);

            if (respostaUsuario != null) {
                if (respostaUsuario.equals(respostaCerta)) {
                    resultado++;
                }
            }

            pergunta++;
        }

        try {
            Resultado.addResultado(usuario, resultado);
            pergunta = 0;
        } catch (Exception e) {
            DbConfig.exceptionMessage = e.getMessage();
        }
    }


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv = "Tipo de conteúdo" content = "text / html; charset = UTF-8">
        <%@include file = "WEB-INF/jspf/header.jspf"%>
        <title>Quiz - Teste seus conhecimentos</title>
    </head>
    <body>
        <div class="container">

            <%@include file="WEB-INF/jspf/menu.jspf" %>
            <h2 class="text-center">Teste seus conhecimentos</h2>

            <hr/>

            <% if (resultado > -1) {%>
            <h2> Resultado: <%=resultado%> </h2>
            <%}%>

            <form method = "post">
                <input class="d-none" name="usuario" value="<%=session.getAttribute("user.name")%>" />

                <% for (Questao q : questoesList) {%>
                <p><%=q.getEnunciated()%></p>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name= "pergunta_<%=pergunta%>"  value="<%=numero = q.geraNumeroRandom()%>" >
                    <label class="form-check-label" for="<%=numero%>">
                        <%=numero%>
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name= "pergunta_<%=pergunta%>"  value="<%=q.getAnswer()%>" >
                    <label class="form-check-label" for="<%=q.getAnswer()%>">
                        <%=q.getAnswer()%>
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name= "pergunta_<%=pergunta%>"  value="<%=numero = q.geraNumeroRandom()%>" >
                    <label class="form-check-label" for="<%=numero%>">
                        <%=numero%>
                    </label>
                </div>

                <br>

                <p class="d-none"><%=pergunta++%></p>

                <% }%>

                <button class= "btn btn-primary" name= "salva_quiz"> Enviar </button>
            </form>
        </div>

    </body>
</html>
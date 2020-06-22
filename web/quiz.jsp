<%-- 
    Document   : quiz
    Created on : 20/06/2020, 13:30:19
    Author     : Anna
--%>

<%@page import="model.Questao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz - Teste seus conhecimentos</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h2>Teste seus conhecimentos</h2>
        <hr/>
         <div class="col">
                    <form method="post">

                        <div class="form-group">
                            <label>1. </label>
                            <input type="text" class="form-control" name="answer1" >
                        </div>

                        <div class="form-group">
                            <label>2. </label>
                            <input type="text" class="form-control" name="answer2" >
                        </div>

                        <div class="form-group">
                            <label>3. </label>
                            <input type="text" class="form-control" name="answer3" >
                        </div>

                        <button type="submit" name="result" class="btn btn-primary">Enviar</button>
                    </form>
                </div>
        
        <a href="home.jsp">Voltar</a>

</body>
</html>
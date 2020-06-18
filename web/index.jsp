<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (request.getParameter("session.login") != null) {
        String login = request.getParameter("user.login");
        String password = request.getParameter("user.password");

        try {

        } catch (Exception e) {

        }
    }

    if (request.getParameter("session.cadastro") != null) {
        String name = request.getParameter("user.name");
        String login = request.getParameter("user.login");
        String password = request.getParameter("user.password");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <title>Index</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>


        <div class="container">
            <div class="row">
                <div class="col">
                    <form method="post">
                        <div class="form-group">
                            <label>Usuário:</label>
                            <input type="text" class="form-control" name="user.login" >
                        </div>

                        <div class="form-group">
                            <label>Senha</label>
                            <input type="password" class="form-control" name="user.password" >
                        </div>
                        <button type="submit" name="session.login" class="btn btn-primary">Entrar</button>

                    </form>
                </div>

                <div class="col">
                    <form action="cadastro">

                        <div class="form-group">
                            <label>Nome Completo</label>
                            <input type="text" class="form-control" name="user.name" >
                        </div>

                        <div class="form-group">
                            <label>Usuário</label>
                            <input type="text" class="form-control" name="user.login" >
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="user.password" >
                        </div>

                        <button type="submit" name="session.cadastro" class="btn btn-primary">Cadastrar</button>
                    </form>
                </div>
            </div>

        </div>



    </body>
</html>

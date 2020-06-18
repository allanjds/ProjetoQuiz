<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Exception requestException = null;

    if (request.getParameter("login") != null) {
        String login = request.getParameter("user.login");
        String password = request.getParameter("user.password");

        try {

        } catch (Exception e) {
            DbConfig.exceptionMessage = e.getMessage();
        }
    }

    if (request.getParameter("cadastro") != null) {
        String name = request.getParameter("cadastro.name");
        String login = request.getParameter("cadastro.login");
        String password = request.getParameter("cadastro.password");

        try {
            Usuario.addUsuario(name, login, password);
            response.sendRedirect(request.getRequestURI());
        } catch (Exception e) {
            DbConfig.exceptionMessage = e.getMessage();
        }
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
                        <button type="submit" name="login" class="btn btn-primary">Entrar</button>

                    </form>
                </div>

                <div class="col">
                    <form method="post">

                        <div class="form-group">
                            <label>Nome Completo</label>
                            <input type="text" class="form-control" name="cadastro.name" >
                        </div>

                        <div class="form-group">
                            <label>Usuário</label>
                            <input type="text" class="form-control" name="cadastro.login" >
                        </div>

                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" class="form-control" name="cadastro.password" >
                        </div>

                        <button type="submit" name="cadastro" class="btn btn-primary">Cadastrar</button>
                    </form>
                </div>
            </div>

        </div>



    </body>
</html>

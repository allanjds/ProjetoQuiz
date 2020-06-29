<%@page import="db.Usuario"%>
<%@page import="web.DbConfig"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    DbConfig.exceptionMessage = "";

    if (request.getParameter("login") != null) {
        String login = request.getParameter("user.login");
        String password = request.getParameter("user.password");

        try {
            Usuario user = Usuario.buscaUsuario(login, password);
            session.setAttribute("user.name", user.getName());
            session.setAttribute("user.login", user.getLogin());

            response.sendRedirect("home.jsp");
        } catch (Exception e) {
            DbConfig.exceptionMessage = e.getMessage();
        }
    }

    if (request.getParameter("login") != null) {
        String login = request.getParameter("login.user");
        String password = request.getParameter("login.password");
        try {
            Usuario user = Usuario.buscaUsuario(login, password);
            if (user == null) {
                DbConfig.exceptionMessage = "Usuário/Senha inválidos";
            } else {
                session.setAttribute("user.login", login);
                session.setAttribute("user.name", user.getName());
                response.sendRedirect("home.jsp");
            }
        } catch (Exception ex) {
            DbConfig.exceptionMessage = ex.getMessage();
        }
    }

    if (request.getParameter("notLogin") != null) {
        response.sendRedirect("home.jsp");
    }

    if (request.getParameter("cadastro") != null) {
        String name = request.getParameter("cadastro.name");
        String login = request.getParameter("cadastro.login");
        String password = request.getParameter("cadastro.password");

        try {
            Usuario.addUsuario(name, login, password);
            response.sendRedirect("home.jsp");

            session.setAttribute("user.name", name);
            session.setAttribute("user.login", login);
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
        <h2 class="text-center">Bem-Vindo</h2> 
        <br>

        <div class="container">
            <div class="row">

                <div class="col">
                    <form method="post">
                        <div class="form-group">
                            <label>Usuário</label>
                            <input type="text" class="form-control" name="login.user" >
                        </div>
                        <div class="form-group">
                            <label>Usuário</label>
                            <input type="text" class="form-control" name="login.password" >
                        </div>


                        <button type="submit" name="login" class="btn btn-primary">Entrar</button>
                        <button type="submit" name="notLogin" class="btn btn-info">Entrar sem login</button>
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


        <%@include file="WEB-INF/jspf/footer.jspf" %>

    </body>
</html>

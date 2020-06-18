<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Usuario> list = new ArrayList<>();

    try {
        list = Usuario.listaUsuarios();
    } catch (Exception ex) {
        DbConfig.exceptionMessage = ex.getMessage();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h2>Index</h2>
        <%@include file="WEB-INF/jspf/menu.jspf" %>

        <table border="1">
            <tr>
                <th>Nome do usuário</th>
                <th>Login</th>
            </tr>
            <%for (Usuario u : list) {%>
            <tr>
                <td><%= u.getName()%></td>
                <td><%= u.getLogin()%></td>
            </tr>
            <%}%>
        </table>


    </body>
</html>

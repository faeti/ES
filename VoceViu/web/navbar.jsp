
<%@page import="entidade.personagens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%

    boolean log = false;
    Usuario usu = (Usuario) session.getAttribute("usuario");
    if (usu != null) {
        log = true;
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/navbar.css"/>
    </head>
    <body>

        <% if (log) { %>
        <nav>
            <ul>
                <li><a href="ListaPontosServlet" id="current">Listar Pontos</a></li>
                <li><a href="suporteCadastraPonto.jsp">Cadastra Ponto</a></li>

            </ul>
        </nav>
        <% } else { %>
        <nav>
            <ul>
            </ul>
        </nav>
        <% }%>
    </body>
</html>

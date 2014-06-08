
<%@page import="entidade.personagens.*"%>
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

        <% if (log) {%>
        <nav>
            <ul>
                <% if (usu instanceof Suporte) {%>
                <li><a href="ListaPontosServlet" id="current">Suporte: <%=usu.getNome()%></a></li>
                    <% } else if (usu instanceof Administrador) {%>
                <li><a href="ListaPontosServlet" id="current">Admin: <%=usu.getNome()%></a></li>
                    <% } else { %>
                <li><a href="ListaPontosServlet" id="current">Outro usuario...</a></li>
                    <% } %>
                <li><a href="LogoutServlet">Sair</a></li>
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

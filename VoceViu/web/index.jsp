<%@page import="entidade.personagens.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    Usuario usuario = (Usuario) session.getAttribute("usuario");

    if (usuario != null) {
        response.sendRedirect("HomeServlet");
    }

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <div id="tudo">


            <%@ include file="/topo.jsp" %>
            <%@ include file="/navbar.jsp" %>

            <div id="conteudo">
                <center>
                    <h2>Acesso de Usuários</h2>

                    <form method="POST" name="submit" action="LoginServlet">

                        <table class="loginTable">
                            <tbody>
                                <tr>
                                    <td>Login</td>
                                </tr>
                                <tr>
                                    <td><input type="text" name="loginUsuario" value="" size="30" /></td>
                                </tr>
                                <tr>
                                    <td>Senha</td>
                                </tr>
                                <tr>
                                    <td><input type="password" name="senhaUsuario" value="" size="30" /></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" value="Conectar" name="botaoConectar" /></td>
                                </tr>
                            </tbody>
                        </table>


                    </form>
                    * links para testes: <br>
                    <a href="ListaPontosServlet">Listar Pontos</a><br>
                </center>
            </div>
        </div>
    </body>
</html>






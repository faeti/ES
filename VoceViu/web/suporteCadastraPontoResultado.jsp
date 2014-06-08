
<%@page import="entidade.dominio.Ponto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    boolean logado = false;
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null && usuario instanceof Suporte) {
        logado = true;
    }

    boolean cadastroComSucesso = (Boolean) session.getAttribute("cadastroComSucesso");
    int tipoDeCadastro = (Integer) session.getAttribute("tipoDeCadastro");
    Ponto ponto = (Ponto) session.getAttribute("pontoCadastrado");
    
    session.removeAttribute("resultadoCadastro");
    session.removeAttribute("tipoDeCadastro");
    session.removeAttribute("pontoCadastrado");
%>

<% if (logado) {%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <script language="javascript">
        </script>
    </head>
    <body>

        <div id="tudo">

            <%@ include file="/topo.jsp" %>
            <%@ include file="/navbar.jsp" %>

            <div id="conteudo">

                <center>

                    <br>
                    <% if (cadastroComSucesso && tipoDeCadastro == 1) { %>
                    <span class="cadastroPontoSucesso">Sucesso ao cadastrar novo ponto!</span>
                    <br><br>
                    <span class="cadastroPontoSucessoDetalhes">Novo ponto: <%=(ponto.getId() + " - " + ponto.getIP() + " - " + ponto.getMAC()) %></span>
                    <br>
                    <% } else if (cadastroComSucesso && tipoDeCadastro == 2) { %>
                    <span class="cadastroPontoSucesso">Sucesso ao atualizar novo ponto!</span>
                    <br><br>
                    <span class="cadastroPontoSucessoDetalhes">Ponto atualizado: <%=(ponto.getId() + " - " + ponto.getIP() + " - " + ponto.getMAC()) %></span>
                    <br>
                    <% } else if (cadastroComSucesso && tipoDeCadastro == 3) { %>
                    <span class="cadastroPontoSucesso">Ponto removido com sucesso!!</span>
                    <br><br>
                    <span class="cadastroPontoSucessoDetalhes">Ponto removido: <%=(ponto.getId() + " - " + ponto.getIP() + " - " + ponto.getMAC()) %></span>
                    <br>
                    <% } else { %>
                    <span class="cadastroPontoErro">Erro ao cadastrar/atualizar ponto!</span>
                    <br>
                    <% }%>
                    <br>
                    
                    <form method="POST" name="submit" action="ListaPontosServlet">
                        <input type="submit" value="   OK   " name="botaoOk" class="botao" />
                    </form>

                </center>

                <hr class="divisor-post">

            </div>
        </div>
    </body>
</html>

<% } else {
        response.sendRedirect("index.jsp");
    }%>
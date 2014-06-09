
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidade.dominio.Ponto"%>

<%
    boolean logado = false;
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null && usuario instanceof Suporte) {
        logado = true;
    }
%>

<% if (logado) {%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>

        <div id="tudo">

            <%@ include file="topo.jsp" %>
            <%@ include file="navbar.jsp" %>

            <div id="conteudo">

                <h2>Localidade:</h2>

                <% String localidadeSelecionada = (String) session.getAttribute("localidadeSelecionada"); %>

                <form method="POST" name="cb" action="ListaPontosServlet">
                    <select class="comboBoxLocalidade" name="comboLocalidades" onChange="cb.submit();">
                        <% ArrayList<String> localidades = (ArrayList<String>) session.getAttribute("listaDeLocalidades"); %>
                        <% int loc = 1; %>
                        <% for (String localidade : localidades) {%>
                            <% if (localidade.equals(localidadeSelecionada)) {%>
                            <option name="<%= ("combo" + (loc++))%>" value="<%= localidade%>" selected="selected"><%= localidade%></option>
                            <% } else {%>
                            <option name="<%= ("combo" + (loc++))%>" value="<%= localidade%>"><%= localidade%></option>
                            <% } %>
                        <% }%>
                    </select>
                    <% if (localidadeSelecionada != null) { %>
                    <input type="submit" value="Adicionar Ponto Nesta Localidade" name="botaoAdicionarPonto" />
                    <% } %>
                </form>

                <% ArrayList<Ponto> pontos = (ArrayList<Ponto>) session.getAttribute("listaDePontos"); %>
                <% if (pontos != null) {%>
                
                <h3 class="sub">Pontos:</h3>

                <table class="userTable" cellpadding="3" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>IP</th>
                            <th>MAC</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <% int i = 0; %>
                        <% for (Ponto p : pontos) {%>

                        <% if (i++ % 2 == 0) { %>
                            <tr bgcolor="#fff">
                        <% } else { %>
                            <tr bgcolor="#eee">
                        <% } %>
                            <td><%= p.getId()%></td>
                            <td><%= p.getIP()%></td>
                            <td><%= p.getMAC()%></td>
                            <td><span class="statusPontoDisponivel">disponível</span></td>
                            <td>
                                <form method="POST" name="submit" action="ListaPontosServlet">
                                    <input type="hidden" id="idPonto" name="idPonto" value="<%= p.getId()%>" />
                                    <input type="hidden" id="ipPonto" name="ipPonto" value="<%= p.getIP()%>" />
                                    <input type="hidden" id="macPonto" name="macPonto" value="<%= p.getMAC()%>" />
                                    <input type="submit" value="Alterar" name="botaoAlterar" class="botao" />
                                    <input type="submit" value="Excluir" name="botaoExcluir" class="botao" onclick="return confirmaExcluirPonto()" />
                                </form>
                            </td>
                        </tr>

                        <% }%>

                    </tbody>
                </table>

                <%}%>

                <hr class="divisor-rodape">

            </div>
        </div>
    </body>
</html>

<% } else {
        response.sendRedirect("index.jsp");
   }%>
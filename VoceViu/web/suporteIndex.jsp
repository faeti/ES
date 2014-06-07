
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidade.dominio.Ponto"%>

<%
    boolean logado = true;
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
                    <select name="comboLocalidades" onChange="cb.submit();">
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
                </form>

                <% ArrayList<Ponto> pontos = (ArrayList<Ponto>) session.getAttribute("listaDePontos"); %>
                <% if (pontos != null) {%>

                <h3 class="sub">Pontos:</h3>

                <table class="userTable">
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

                        <% for (Ponto p : pontos) {%>


                        <tr>
                            <td><%= p.getId()%></td>
                            <td><%= p.getIP()%></td>
                            <td><%= p.getMAC()%></td>
                            <td><span class="statusPontoDisponivel">disponível</span></td>
                            <td>
                                <form method="POST" name="submit" action="ListaPontosServlet">
                                    <input type="hidden" name="idPonto" value="<%= p.getId()%>" />
                                    <input type="submit" value="Alterar" name="botaoAlterar" class="botao" />
                                    <input type="submit" value="Excluir" name="botaoExcluir" class="botao" />
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
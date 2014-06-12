
<%@page import="entidade.dominio.Anuncio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidade.dominio.Ponto"%>

<%
    boolean logado = false;
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null && usuario instanceof Administrador) {
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

                <form method="POST" name="cb" action="ListaPagamentosServlet">
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
                </form>

                <% ArrayList<Anuncio> anuncios = (ArrayList<Anuncio>) session.getAttribute("listaDeAnuncios"); %>
                <% if (anuncios != null) {%>

                <h3 class="sub">Anúncios: </h3>

                <table class="userTable" cellpadding="3" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Cliente</th>
                            <th>Título</th>
                            <th>ID</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <% int i = 0; %>
                        <% for (Anuncio a : anuncios) {%>

                        <% if (i++ % 2 == 0) { %>
                        <tr bgcolor="#fff">
                            <% } else { %>
                        <tr bgcolor="#eee">
                            <% }%>
                            <td><%= a.getCliente().getNome() %></td>
                            <td><%= a.getTitulo() %></td>
                            <td><%= a.getId() %></td>
                            <td>
                                <form method="POST" name="submit" action="ListaPagamentosServlet">
                                    <input type="hidden" id="clienteAnuncio" name="clienteAnuncio" value="<%= a.getCliente().getNome()%>" />
                                    <input type="hidden" id="tituloAnuncio" name="tituloAnuncio" value="<%= a.getTitulo() %>" />
                                    <input type="hidden" id="idAnuncio" name="idAnuncio" value="<%= a.getId() %>" />
                                    <input type="submit" value="Aprovar Pagamento" name="botaoAprovarPagamento" class="botao" onclick="return confirmaAprovarPagamento()" />
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
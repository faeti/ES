
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

                <h1>Pontos de Localidade</h1>



                <h1 class="sub">Lista de pontos:</h1>

                <table class="userTable">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>IP</th>
                            <th>MAC</th>
                            <th>Status</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                
                <%  ArrayList<Ponto> pontos = (ArrayList<Ponto>) session.getAttribute("listaDePontos");
                    for (Ponto p : pontos) {%>

                
                        <tr>
                            <td><%= p.getId()%></td>
                            <td><%= p.getIP()%></td>
                            <td><%= p.getMAC()%></td>
                            <td><span class="statusPontoDisponivel">disponível</span></td>
                            <td><input type="submit" value="Alterar" name="botaoCadastrar" class="botao" /></td>
                            <td><input type="submit" value="Excluir" name="botaoCancelar" class="botao" /></td>
                        </tr>
                

                <% }%>

                    </tbody>
                </table>
                
                <hr class="divisor-rodape">

            </div>
        </div>
    </body>
</html>

<% } else {

        response.sendRedirect("index.jsp");

    }%>
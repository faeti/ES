
<%@page import="controle.ControleVeiculacao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidade.dominio.Ponto"%>
<%@page import="entidade.dominio.Anuncio"%>

<%
    boolean logado = false;
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if (usuario != null && usuario instanceof DiretorComercial) {
        logado = true;
    }
    
    //teste sem BD
    //logado = true;
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

                    <h2>Aprovar Anúncios</h2>                                   
                    <form method="POST" name="cb" action="ListaVeiculacoesServlet">                                                            
                    </form>                                                                   

                    <table class="userTable" cellpadding="3" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Clientes</th>
                                <th>Anúncios</th>                                
                                <th> </th>
                                <th> </th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <% ControleVeiculacao anuncios = new ControleVeiculacao();  %>                                                
                            <% int i = 0; %>
                            <% for (Anuncio a : anuncios.listarTodasVeiculacoes()) {%>

                            <% if (i++ % 2 == 0) { %>
                                <tr bgcolor="#fff">
                            <% } else { %>
                                <tr bgcolor="#eee">
                            <% } %>
                            
                                <td><%= a.getCliente().getId()%></td>
                                <td><%= a.getId()%></td>
                                                                                                
                                <td>
                                    <form method="POST" name="submit" action ="ListaAnunciosServlet">
                                        <input type="hidden" name="idCliente" value="<%= a.getCliente().getId()%>" />
                                        <input type="hidden" name="idAnuncio" value="<%= a.getId()%>" />
                                        
                                        <input type="submit" value="Download" name="botaoDownload" class="botao" />
                                        <input type="submit" value="Aprovar" name="botaoAprovar" class="botao" />
                                        <input type="submit" value="Reprovar" name="botaoReprovar" class="botao" />
                                    </form>
                                </td>
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

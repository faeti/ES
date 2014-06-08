
<%@page import="entidade.dominio.Ponto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <script language="javascript">

            function validaNull() {
                if (document.getElementById("idPonto").value === "" ||
                        document.getElementById("ipPonto").value === "" ||
                        document.getElementById("macPonto").value === "") {
                    alert("Título e Texto devem ser preenchidos");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>

        <div id="tudo">

            <%@ include file="/topo.jsp" %>
            <%@ include file="/navbar.jsp" %>

            <%  Ponto ponto = (Ponto) session.getAttribute("pontoEditado");
                String localidade = (String) session.getAttribute("localidadeSelecionada"); %>

            <div id="conteudo">

                <form method="POST" name="submit" action="CadastraPontoServlet">
                    Localidade: <br>
                    <% if (localidade != null) {%>
                    <input type="text" name="localidadeDoPonto" size="30" value="<%=localidade%>" readonly /> <br>
                    <% } else { %>
                    <input type="text" name="localidadeDoPonto" size="30" value="" /> <br>
                    <% }%>

                    Identificacao do Ponto: <br>
                    <% if (ponto != null) {%>
                    <input type="text" name="idPonto" size="30" value="<%=ponto.getId()%>" /> <br>
                    <% } else { %>
                    <input type="text" name="idPonto" size="30" value="" /> <br>
                    <% }%>

                    IP: <br>
                    <% if (ponto != null) {%>
                    <input type="text" name="ipPonto" size="30" value="<%=ponto.getIP()%>" /> <br>
                    <% } else { %>
                    <input type="text" name="ipPonto" size="30" value="" /> <br>
                    <% }%>

                    MAC: <br>
                    <% if (ponto != null) {%>
                    <input type="text" name="macPonto" size="30" value="<%=ponto.getMAC()%>" /> <br>
                    <% } else { %>
                    <input type="text" name="macPonto" size="30" value="" /> <br>
                    <% }%>

                    <br>
                    <% String botaoSalvar = (ponto == null ? "botaoSalvar" : "botaoAlterar");%>
                    <input type="submit" value="Salvar" name="<%=botaoSalvar%>" class="botao" onclick="return validaNull()" />
                    <input type="submit" value="Cancelar" name="botaoCancelar" class="botao" />
                </form>

                <hr class="divisor-post">


            </div>
        </div>
    </body>
</html>

<% } else {
        response.sendRedirect("index.jsp");
   }%>
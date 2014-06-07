
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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

                <form method="POST" name="submit" action="CadastraPontoServlet">
                    Localidade: <br>
                    <input type="text" name="localidadePonto" size="30" value="" /> <br>
                    Identificacao do Ponto: <br>
                    <input type="text" name="idPonto" size="30" /> <br>
                    IP: <br>
                    <input type="text" name="ipPonto" size="30" /> <br>
                    MAC: <br>
                    <input type="text" name="macPonto" size="30" /> <br>
                    <br>
                    <input type="submit" value="Cadastrar" name="botaoCadastrar" class="botao" />
                    <input type="submit" value="Cancelar" name="botaoCancelar" class="botao" />
                </form>

                <hr class="divisor-post">


            </div>
        </div>
    </body>
</html>


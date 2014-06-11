
<%@page import="entidade.dominio.Anuncio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    boolean logado = true;
%>

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

                          <%
                        Anuncio anuncio = (Anuncio) session.getAttribute("anuncioASerReprovado");
                    %>
                <Form method="POST" name="cb" action="ReprovarAnunciosServlet">                                                                                	
			<fieldset style="width: 30%;">
				Cliente	
                                <input type="text" name="idCliente" size="30" value= "<%=anuncio.getCliente().getId()%>" readonly="true"/> </br>                                
				Anuncio:</br>
                                <input type="text" name="idAnuncio" size="30" value="<%=anuncio.getId()%>" readonly="true"/> </br>
				Motivo: </br>
				<textarea type="text" name = "txtAreaMotivo" value="" cols="30" rows="6"> </textarea></br>
			</fieldset>
			</br>			
                        <input type="submit" name="botaoReprovar" value="Reprovar" />
			<input type="submit" name="botaoCancelar" value="Cancelar" /> <br>
		</Form>


                    <hr class="divisor-rodape">

                </div>
            </div>
        </body>
    </html>

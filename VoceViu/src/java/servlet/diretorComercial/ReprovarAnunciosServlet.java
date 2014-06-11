package servlet.diretorComercial;

import controle.ControleVeiculacao;
import entidade.dominio.Anuncio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicolas
 */

@WebServlet(name = "ReprovarAnunciosServlet", urlPatterns = {"/ReprovarAnunciosServlet"})
public class ReprovarAnunciosServlet extends HttpServlet {
    
    ControleVeiculacao controleVeiculacao = new ControleVeiculacao();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                                    
            
            if (request.getParameter("botaoReprovar") != null) {                

                String motivo = (String) request.getParameter("txtAreaMotivo");   
                
                if (motivo.length()>0){
                    int idAnuncio = Integer.valueOf((String) request.getParameter("idAnuncio"));                                                                  
                    Anuncio anuncio = this.controleVeiculacao.recuperarVeiculacao(idAnuncio);
                    anuncio.setAprovado(false);
                    anuncio.setDescricao(motivo);
                    this.controleVeiculacao.atualizarVeiculacao(anuncio);
                    response.sendRedirect("diretorComercialIndex.jsp");
                }                
                else{
                    PrintWriter out = response.getWriter();  
                    response.setContentType("text/html");  
                    out.println("<script type=\"text/javascript\">");  
                    out.println("alert('O campo motivo não pode ser vazio.');");  
                    out.println("</script>");
                }
            }else if (request.getParameter("botaoCancelar") != null) {                
                response.sendRedirect("diretorComercialIndex.jsp");
            }
                

            
            
            
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
 
   
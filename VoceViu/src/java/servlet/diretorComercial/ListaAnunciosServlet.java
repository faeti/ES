package servlet.diretorComercial;

import controle.ControleLocalidade;
import controle.ControleVeiculacao;
import entidade.dominio.Anuncio;
import entidade.dominio.Localidade;
import entidade.dominio.Ponto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author nicolas
 */

@WebServlet(name = "ListaAnunciosServlet", urlPatterns = {"/ListaAnunciosServlet"})
public class ListaAnunciosServlet extends HttpServlet {
    
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
            
            if (request.getParameter("botaoAprovar") != null) {                                
                HttpSession session = request.getSession();
                int idAnuncio = Integer.valueOf((String) request.getParameter("idAnuncio"));                                  
                Anuncio anuncio = this.controleVeiculacao.recuperarVeiculacao(idAnuncio);
                anuncio.setAprovado(true);
                this.controleVeiculacao.atualizarVeiculacao(anuncio);
                
                PrintWriter out = response.getWriter();  
                response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Anuncio foi aprovado com sucesso.');");  
                out.println("</script>");
                    
                response.sendRedirect("diretorComercialIndex.jsp");
                
            }else if (request.getParameter("botaoDownload") != null) {                
                HttpSession session = request.getSession();
                int idAnuncio = Integer.valueOf((String) request.getParameter("idAnuncio"));                                  
                Anuncio anuncio = this.controleVeiculacao.recuperarVeiculacao(idAnuncio);                                
                
                PrintWriter writer = new PrintWriter("/home/nataniel/Anuncio/"+ anuncio.getId()+".txt");
                writer.println(anuncio.toString());                
                writer.close();
                
                PrintWriter out = response.getWriter();  
                response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Download realizado com sucesso em /home/nataniel/Anuncio/');");  
                out.println("</script>");
                    
                //response.sendRedirect("diretorComercialIndex.jsp");
                
                
            }else if (request.getParameter("botaoReprovar") != null) {                
                HttpSession session = request.getSession();
                int idAnuncio = Integer.valueOf((String) request.getParameter("idAnuncio"));                                  
                Anuncio anuncio = this.controleVeiculacao.recuperarVeiculacao(idAnuncio);                                
                
                session.setAttribute("anuncioASerReprovado", anuncio);
                response.sendRedirect("diretorComercialReprovarPedido.jsp");
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
 
   
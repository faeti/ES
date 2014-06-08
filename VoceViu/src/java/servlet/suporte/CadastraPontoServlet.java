package servlet.suporte;

import controle.ControleLocalidade;
import entidade.dominio.Ponto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CadastraPontoServlet", urlPatterns = {"/CadastraPontoServlet"})
public class CadastraPontoServlet extends HttpServlet {

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

        ControleLocalidade controleLocalidade = ControleLocalidade.getInstance();
        
        if (request.getParameter("botaoSalvar") != null) {
            
            String localidadeDoPonto = (String) request.getParameter("localidadeDoPonto");
            String idPonto = (String) request.getParameter("idPonto");
            String ipPonto = (String) request.getParameter("ipPonto");
            String macPonto = (String) request.getParameter("macPonto");
            controleLocalidade.recuperarLocalidade(localidadeDoPonto).cadastraPontos(idPonto, ipPonto, macPonto);
            
            HttpSession session = request.getSession();
            session.setAttribute("cadastroComSucesso", true);
            session.setAttribute("tipoDeCadastro", 1);
            Ponto p = new Ponto(idPonto, ipPonto, macPonto);
            session.setAttribute("pontoCadastrado", p);
            
            response.sendRedirect("suporteCadastraPontoResultado.jsp");
            
        } else if (request.getParameter("botaoAlterar") != null) {
            
            String localidadeDoPonto = (String) request.getParameter("localidadeDoPonto");
            String idPonto = (String) request.getParameter("idPonto");
            String ipPonto = (String) request.getParameter("ipPonto");
            String macPonto = (String) request.getParameter("macPonto");
            controleLocalidade.recuperarLocalidade(localidadeDoPonto).atualizarPonto(new Ponto(idPonto, ipPonto, macPonto));
            
            HttpSession session = request.getSession();
            session.setAttribute("cadastroComSucesso", true);
            session.setAttribute("tipoDeCadastro", 2);
            Ponto p = new Ponto(idPonto, ipPonto, macPonto);
            session.setAttribute("pontoCadastrado", p);
            
            response.sendRedirect("suporteCadastraPontoResultado.jsp");
            
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

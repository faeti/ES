package servlet;

import entidade.personagens.Administrador;
import entidade.personagens.Cliente;
import entidade.personagens.DiretorComercial;
import entidade.personagens.Suporte;
import entidade.personagens.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) { // se usuario eh invalido, volta para tela de login

            response.sendRedirect("index.jsp");

        } else { // senao, redirecionar ele para sua pagina principal

            if (usuario instanceof Administrador) {
                response.sendRedirect("adminIndex.jsp"); // lembrar de direticonar para servlet
            } else if (usuario instanceof Cliente) {
                response.sendRedirect("clienteIndex.jsp"); // lembrar de direticonar para servlet
            } else if (usuario instanceof DiretorComercial) {
                response.sendRedirect("diretorComercialIndex.jsp"); // lembrar de direticonar para servlet
            } else if (usuario instanceof Suporte) {
                session.setAttribute("primeiroAcesso", true);
                response.sendRedirect("ListaPontosServlet");
            }

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

package servlet.suporte;

import entidade.dominio.Ponto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListaPontosServlet", urlPatterns = {"/ListaPontosServlet"})
public class ListaPontosServlet extends HttpServlet {

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

        /*
         // testa se usuario esta logado
         Usuario usuario = (Usuario) session.getAttribute("usuario");
        
         if (usuario == null) {
         response.sendRedirect("login.jsp");
        
         return;
         }
         */
        // mock para teste do servlet
        // futuramente vai pegar os dados do banco
        HttpSession session = request.getSession();

        ArrayList<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto("P1", "192.169.1.1", "e3:ff:68:ac"));
        pontos.add(new Ponto("P2", "192.169.1.1", "e3:ff:68:ac"));
        pontos.add(new Ponto("P3", "192.169.1.1", "e3:ff:68:ac"));
        pontos.add(new Ponto("P4", "192.169.1.1", "e3:ff:68:ac"));

        session.setAttribute("listaDePontos", pontos);
        response.sendRedirect("suporteIndex.jsp");
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

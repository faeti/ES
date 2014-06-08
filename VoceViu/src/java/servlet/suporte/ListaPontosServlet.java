package servlet.suporte;

import controle.ControleLocalidade;
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

        // mock para teste do servlet
        // futuramente vai pegar os dados do banco
        ControleLocalidade controleLocalidade = ControleLocalidade.getInstance();
        
        if (request.getParameter("botaoAdicionarPonto") != null) {
            
            HttpSession session = request.getSession();
            session.removeAttribute("pontoEditado");
            response.sendRedirect("suporteCadastraPonto.jsp");
            
        } else if (request.getParameter("botaoAlterar") != null) {

            HttpSession session = request.getSession();
            String localidadeSelecionada = (String) session.getAttribute("localidadeSelecionada");
            String ipPonto = (String) request.getParameter("ipPonto");
            String macPonto = (String) request.getParameter("macPonto");
            Localidade loc = controleLocalidade.recuperarLocalidade(localidadeSelecionada);
            Ponto ponto = loc.recuperarPonto(ipPonto, macPonto);
            session.setAttribute("pontoEditado", ponto);
            response.sendRedirect("suporteCadastraPonto.jsp");

        } else if (request.getParameter("comboLocalidades") != null) {

            HttpSession session = request.getSession();
            String localidadeSelecionada = request.getParameter("comboLocalidades");

            if (localidadeSelecionada.equals("Escolha uma localidade")) {
                return;
            } else {
                ArrayList<String> localidades = (ArrayList<String>) session.getAttribute("listaDeLocalidades");
                if (localidades.indexOf("Escolha uma localidade") != -1) {
                    localidades.remove("Escolha uma localidade");
                    session.setAttribute("listaDeLocalidades", localidades);
                }
            }

            Localidade loc = controleLocalidade.recuperarLocalidade(localidadeSelecionada);
            List<Ponto> pontos = loc.listarPontos();
            session.setAttribute("localidadeSelecionada", localidadeSelecionada);
            session.setAttribute("listaDePontos", pontos);
            response.sendRedirect("suporteIndex.jsp");

        } else {

            HttpSession session = request.getSession();
            List<Localidade> localidades = controleLocalidade.listarLocalidades();
            ArrayList<String> nomeLocalidades = new ArrayList<>();
            nomeLocalidades.add("Escolha uma localidade");

            for (Localidade loc : localidades) {
                nomeLocalidades.add(loc.getNome());
            }

            session.setAttribute("listaDeLocalidades", nomeLocalidades);
            response.sendRedirect("suporteIndex.jsp");
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

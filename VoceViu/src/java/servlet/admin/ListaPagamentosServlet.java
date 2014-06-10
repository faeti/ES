/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.admin;

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

/**
 *
 * @author Diogo
 */
@WebServlet(name = "ListaPagamentosServlet", urlPatterns = {"/ListaPagamentosServlet"})
public class ListaPagamentosServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        if (session.getAttribute("primeiroAcesso") == null) {
            session.setAttribute("primeiroAcesso", true);
        }
        
        if (request.getParameter("comboLocalidades") != null) {

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
            response.sendRedirect("adminAprovarPagamento.jsp");
        
        } else {

            List<Localidade> localidades = controleLocalidade.listarLocalidades();
            ArrayList<String> nomeLocalidades = new ArrayList<>();

            Boolean primeiroAcesso = (Boolean) session.getAttribute("primeiroAcesso");

            if (primeiroAcesso != null && primeiroAcesso) {
                nomeLocalidades.add("Escolha uma localidade");
                session.setAttribute("primeiroAcesso", false);
            }

            for (Localidade loc : localidades) {
                nomeLocalidades.add(loc.getNome());
            }

            session.setAttribute("listaDeLocalidades", nomeLocalidades);
            response.sendRedirect("adminAprovarPagamento.jsp");
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

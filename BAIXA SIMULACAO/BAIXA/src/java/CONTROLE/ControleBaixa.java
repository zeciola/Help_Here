/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLE;

import DAO.DAOBaixa;
import MODELO.Baixa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class ControleBaixa extends HttpServlet {

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
        /* TODO output your page here. You may use following sample code. */
        Double Saldo = 1000.00;
        Baixa b = new Baixa();
        String acao = request.getParameter("acao");
        HttpSession sessao = request.getSession();
        DAOBaixa daob = new DAOBaixa();

        if (acao.equals("Proximo")) {

            b.setNumeroBoleto(request.getParameter("numeroboleto"));
            b.setValor1(daob.BuscaValorAPagar(b));

            sessao.setAttribute("baixa", b);
            sessao.setAttribute("v", Saldo);

            response.sendRedirect("pagaboleto.jsp");

        } else {
            if (acao.equals("Pagar")) {
                 HttpSession sessaoUsuario = request.getSession();
                Baixa b2 = (Baixa) sessaoUsuario.getAttribute("baixa");
                double s = (double) sessaoUsuario.getAttribute("v");

                if (b.getValor1() > s) {
                    response.sendRedirect("Erro.jsp");
                } else {
                    b2.setUsuario(request.getParameter("cpf"));
                    b2.setSenha(request.getParameter("senha"));
                    daob.RealizarPagamento(b2);
                    response.sendRedirect("pagamentoOk.jsp");
                }
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

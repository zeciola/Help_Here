/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PerfilDeAcesso;
import Model.Login;
import DAO.DAOUsuario;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;


public class ControleAcesso extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Entrar")) {
                Login login = new Login();
                login.setNome(request.getParameter("txtLogin"));
                login.setSenha(request.getParameter("txtSenha"));
                
                DAOUsuario daousuario = new DAOUsuario();
                Login usuarioAutenticado = daousuario.autenticaUsuario(login);
            //se o usuario existe no banco de dados
            if (usuarioAutenticado != null) {

            
                //cria uma sessao para o usuario
               HttpSession sessaoUsuario = request.getSession();
               sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
               //redireciona para a pagina princiapal
               response.sendRedirect("acessologado/logado.jsp");
               } else {
               RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
               request.setAttribute("msg", "Login ou Senha Incorreto!");
               rd.forward(request, response);
               }
            }else
                if(acao.equals("Sair")){
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.removeAttribute("usuarioAutenticado");
                response.sendRedirect("index.html");

                }
            } catch (Exception erro) {
                RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                request.setAttribute("erro", erro);
                rd.forward(request, response);
            }
        }

            @Override
            protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            }
            
            @Override
            protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
            }
}
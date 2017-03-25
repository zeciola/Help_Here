/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author Lucas Puglia
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PerfilDeAcesso;
import Model.Login;
import DAO.DAOUsuario;




public class ControleUsuario extends HttpServlet {
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    try {
         String acao = request.getParameter("acao");
         
    if (acao.equals("Cadastrar")) {
        Login login = new Login();
        login.setNome(request.getParameter("txtLogin"));
        login.setSenha(request.getParameter("txtSenha"));
        String perfil = request.getParameter("optPerfil");
        
        
    if (perfil.equalsIgnoreCase("administrador")) {
        
        login.setPerfil(PerfilDeAcesso.administrador);
    } else {
        login.setPerfil(PerfilDeAcesso.comum);
    }
    
    
    DAOUsuario daousuario = new DAOUsuario();
    
    daousuario.cadastraNovoUsuario(login);
    
    request.setAttribute("msg", "cadastrado com sucesso");
    
    RequestDispatcher rd = request.getRequestDispatcher("/Cadastro_Usuario.jsp");
    
    rd.forward(request, response);
    
    }
    
    } catch (Exception erro) {
        RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
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

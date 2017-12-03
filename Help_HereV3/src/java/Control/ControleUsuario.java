package Control;

import Control.*;
import Model.*;
import DAO.*;
import Util.*;
import Command.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControleUsuario extends HttpServlet {
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    try {
         String acao = request.getParameter("acao");
         
         //Mostra a acao
         System.out.println("acao");
         
         String NomeClasse = "Command.UsuarioAction." + acao + "UsuarioAction";
         
         Class classeAction = Class.forName(NomeClasse);
         
         
         
    if (acao.equals("Cadastrar")) {
        
        Usuario login = new Usuario();
        login.setNome(request.getParameter("txtLogin"));
        login.setSenha(request.getParameter("txtSenha"));
        String perfil = request.getParameter("optPerfil");
        
        
    if (perfil.equalsIgnoreCase("administrador")) {
        
        login.setPerfil(PerfilDeAcesso.administrador);
    } else {
        login.setPerfil(PerfilDeAcesso.comum);
    }
    
    
    DAOUsuario daousuario = new DAOUsuario();
    
    daousuario.Inserir(login);
    
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

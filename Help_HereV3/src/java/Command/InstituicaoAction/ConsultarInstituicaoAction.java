/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.InstituicaoAction;

import Command.ICommand;
import DAO.DAOInstituicao;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author 11141100670

*/

public class ConsultarInstituicaoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Instituicao> institu = new ArrayList();
        DAOInstituicao idao = new DAOInstituicao();
        String CNP = null;
        
            String acao = request.getParameter("acao");
            if (acao.equals("Consultar")) {
                
                CNP=(request.getParameter("txtcnpj"));
 
            }else {
                return "erro.jsp";
            }
        
        institu = idao.Consultar(CNP);
         request.setAttribute("lista", institu);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/acessologado/listaInstituicao.jsp");
        rd.forward(request, response);
        return "acessologado/listaInstituicao.jsp";
    }
    
}

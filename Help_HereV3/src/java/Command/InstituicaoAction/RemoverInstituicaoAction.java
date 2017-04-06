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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 11141100670
 */
public class RemoverInstituicaoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        DAOInstituicao idao = new DAOInstituicao();
        String CNP = null;
        String Sen = null;
        
            String acao = request.getParameter("acao");
            if (acao.equals("Remover")) {
                
                CNP=(request.getParameter("txtcnpj"));
                Sen = (request.getParameter("txtSenha"));
 
            }else {
                return "erro.jsp";
            }
        
         idao.Deletar(CNP,Sen);
        return "/sucesso.jsp";
    }
     
}

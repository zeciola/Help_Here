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
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11141100670
 */
public class RemoverInstituicaoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        DAOInstituicao daoi = new DAOInstituicao();
        
        
         HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("InstAutenticado");
        
            
         
            
        
         daoi.Deletar(usuarioLogado);
         
        return "/sucesso.jsp";
    }
     
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.PessoaAction;

import Command.ICommand;
import DAO.DAOPessoa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class InteressePessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] interesses = request.getParameterValues("interesse");
        
        HttpSession sessao = request.getSession();
        int i = (int) sessao.getAttribute("pessoaident");
        
        DAOPessoa daop = new DAOPessoa();
        
        for(int j = 0; j <= interesses.length; j++){
            daop.InserirInteresse(i, interesses[j]);
        }
        
       return "login.jsp";
    }
    
}

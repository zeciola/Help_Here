/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.PessoaAction;

import Command.ICommand;
import DAO.DAOPessoa;
import Model.Login;
import Model.Pessoa;
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
        DAOPessoa daop = new DAOPessoa();
        String[] interesses = request.getParameterValues("interesse");
 
        HttpSession sessao = request.getSession();
        Login o = (Login) sessao.getAttribute("userid");
        
        for(int j = 0; j < interesses.length; j++){
            daop.InserirInteresse(o.getId(), interesses[j]);
        }
       return "login.jsp";
    }
    
}

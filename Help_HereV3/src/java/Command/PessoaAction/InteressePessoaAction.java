/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.PessoaAction;

import Command.ICommand;
import DAO.DAOPessoa;
import Model.Usuario;
import Model.Pessoa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego
 */
public class InteressePessoaAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] interesses = request.getParameterValues("interesse");

        HttpSession sessao = request.getSession();
        Usuario o = (Usuario) sessao.getAttribute("userid");

        for (int j = 0; j < interesses.length; j++) {
            DAOPessoa daop = new DAOPessoa();
            daop.InserirInteresse(o.getId(), interesses[j]);
        }
        return "login.jsp";
    }

}

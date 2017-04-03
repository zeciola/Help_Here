/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.PessoaAction;

import ControleCommand.ICommand;
import DAO.DAOPessoa;
import Modelo.Pessoa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class DeletarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pessoa p = new Pessoa();
        p.setId(Integer.parseInt(request.getParameter("id")));
        DAOPessoa pdao = new DAOPessoa();
        pdao.setPessoa(p);
        pdao.Deletar();
        return "index.jsp";
    }
    
}

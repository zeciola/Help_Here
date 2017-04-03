/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.PessoaAction;

import ControleCommand.ICommand;
import DAO.DAOPessoa;
import Modelo.Pessoa;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class ConsultarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Pessoa p = new Pessoa();
        p.setId(Integer.parseInt(request.getParameter("id")));
        DAOPessoa dao = new DAOPessoa();
        dao.setPessoa(p);
        ArrayList<Pessoa> plist = dao.Consultar();
        request.setAttribute("lista", plist);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaPessoa.jsp");
        rd.forward(request, response);
        return "listarPessoa.jsp";
    }
    
}

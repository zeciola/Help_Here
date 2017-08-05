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
public class ListarInstituicaoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Instituicao> i = new ArrayList();
        DAOInstituicao idao = new DAOInstituicao();
        i = idao.Listar();
        //add a lista de clientes o objeto request
        request.setAttribute("lista", i);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaInstituicao.jsp");
        rd.forward(request, response);
        return "listaInstituicao.jsp";
    }
    
}

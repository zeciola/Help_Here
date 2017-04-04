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
        ArrayList<Instituicao> I = new ArrayList();
        Instituicao ins = new Instituicao();
        String CNPJ_ant = null;
        request.getAttribute("CNPJ_antigo");
        DAOInstituicao idao = new DAOInstituicao();
        idao.Consultar();
         RequestDispatcher rd= request.getRequestDispatcher("/listaInstituicao.jsp");
        rd.forward(request, response);
        return "listaInstituicao.jsp";
    }
    
}

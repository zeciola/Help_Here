/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.EventoAction;

import ControleCommand.ICommand;
import DAO.DAOEvento;
import Modelo.Evento;
import Modelo.Pessoa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class AddRespEventoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Evento e = new Evento();
        e.setId(Integer.parseInt(request.getParameter("idevento")));
        Pessoa p = new Pessoa();
        p.setId(Integer.parseInt(request.getParameter("idpessoa")));
        DAOEvento edao = new DAOEvento();
        edao.InserirRP(p);
        return "index.jsp";
    }  
}

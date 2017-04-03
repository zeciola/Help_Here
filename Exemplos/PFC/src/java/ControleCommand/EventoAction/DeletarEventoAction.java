/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.EventoAction;

import ControleCommand.ICommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Endereco;
import DAO.DAOEvento;
import Modelo.Evento;
/**
 *
 * @author Diego
 */
public class DeletarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Evento e = new Evento();
        e.setId(Integer.parseInt(request.getParameter("id")));
        DAOEvento evdao = new DAOEvento();
        evdao.setEvento(e);
        evdao.Deletar();
        return "index.jsp";
    }
    
}

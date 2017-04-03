/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.EventoAction;

import ControleCommand.ICommand;
import DAO.DAOEvento;
import Modelo.Avaliar;
import Modelo.Evento;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diego
 */
public class ListarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Avaliar avalia = new Avaliar();
        avalia.atualizarDivul();
        ArrayList<Evento> e = new ArrayList();
        DAOEvento edao = new DAOEvento();
        e=edao.Listar();
        //add a lista de clientes o objeto request
        request.setAttribute("lista", e);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
        return "index.jsp";
    } 
}

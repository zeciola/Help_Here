/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleCommand.EventoAction;
import ControleCommand.ICommand;
import DAO.DAOEvento;
import Modelo.Evento;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Diego
 */
public class ConsultarEventoAction implements ICommand{
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Evento> e = new ArrayList();
        Evento ev = new Evento();
        ev.setId(Integer.parseInt(request.getParameter("id")));
        DAOEvento edao = new DAOEvento();
        edao.setEvento(ev);
        e=edao.Consultar();
        //add a lista de clientes o objeto request
        request.setAttribute("lista", e);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
        rd.forward(request, response);
        return "listaEvento.jsp";   
    }
}

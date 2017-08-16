/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import Model.Evento;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11141104689
 */
public class ListarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       ArrayList<Evento> i = new ArrayList();
        DAOEvento idao = new DAOEvento();
        String URL = request.getParameter("URL");
        String UR = request.getParameter("UR");
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("usuarioAutenticado");
        int ID = usuarioLogado.getIdInstituicao();
        
        
        
        
        if (URL!= null){
         i = idao.ListarPorID(ID);
        //add a lista de evento o objeto request
        request.setAttribute("listaEV", i);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
        rd.forward(request, response);
        return "listaEvento.jsp";   
            
            
        }
        
        else if(UR != null){
            
        i = idao.ListarPorData();
        //add a lista de evento o objeto request
        request.setAttribute("listaEVdata", i);
        RequestDispatcher rd= request.getRequestDispatcher("/Eventos.jsp");
        rd.forward(request, response); 
        return "Eventos.jsp";
        }else{
        
        i = idao.Listar();
        //add a lista de evento o objeto request
        request.setAttribute("listaEV", i);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
        rd.forward(request, response);
        return "listaEvento.jsp";
        }
        
        
    
    }
    
}

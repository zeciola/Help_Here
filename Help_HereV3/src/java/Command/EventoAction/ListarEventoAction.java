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
import Model.Pessoa;
import Model.Usuario;
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
       ArrayList<Pessoa> pe = new ArrayList();
       
       Pessoa p = new Pessoa();
        DAOEvento idao = new DAOEvento();
        String URLP = request.getParameter("URLP");
        String URL = request.getParameter("URL");
        String UR = request.getParameter("UR");
        String U = request.getParameter("U");
        String URP = request.getParameter("URP");
        
        
        
        
        
         if (URL!= null){
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("usuarioAutenticado");
        int ID = usuarioLogado.getIdInstituicao();
        
         i = idao.ListarPorID(ID);
          p.setId(ID);
          pe.add(p);
          request.setAttribute("confirma", pe);
        //add a lista de evento o objeto request
        request.setAttribute("listaEV", i);
        
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
        rd.forward(request, response);
        return "listaEvento.jsp";   
            
            
        }
         
        else if (URLP!= null){
            HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
            Usuario usuarioLogado =(Usuario)sessaoUsuario.getAttribute("usuarioAutenticado");
            int ID = usuarioLogado.getId();
             i = idao.ListarEvPessoaPorID(ID);
             p.setId(ID);
             pe.add(p);
             request.setAttribute("confirma", pe);
            //add a lista de evento o objeto request
            request.setAttribute("listaEV", i);
            
            //envia o request para o jsp
            RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
            rd.forward(request, response);
            return "listaEvento.jsp";            
        }
        
        else if(U != null){
            
        i = idao.ListarPorData();
        //add a lista de evento o objeto request
        request.setAttribute("listaEVdataP", i);
        RequestDispatcher rd= request.getRequestDispatcher("acessologado/EventoPessoa.jsp");
        rd.forward(request, response); 
        return "acessologado/EventoPessoa.jsp";
        }
        
        else if(UR != null){
            
        i = idao.ListarPorData();
        //add a lista de evento o objeto request
        request.setAttribute("listaEVdata", i);
        RequestDispatcher rd= request.getRequestDispatcher("acessologado/Evento.jsp");
        rd.forward(request, response); 
        return "acessologado/Evento.jsp";
        }
        else if(URP != null){
            
            
            request.setAttribute("confirma", pe);
            i = idao.Listar();
            //add a lista de evento o objeto request
            request.setAttribute("listaEV", i);
            //envia o request para o jsp
            RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
            rd.forward(request, response);
            return "listaEvento.jsp";  
        }
        
        else{
        
        i = idao.Listar();
        request.setAttribute("confirma", pe);
        //add a lista de evento o objeto request
        request.setAttribute("listaEV", i);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
        rd.forward(request, response);
        return "listaEvento.jsp";
        }
        
        
    
    }
    
}

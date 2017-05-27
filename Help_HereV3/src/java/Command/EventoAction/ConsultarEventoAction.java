/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import Model.Endereco;
import Model.Evento;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 11141104689
 */
public class ConsultarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Evento> eve = new ArrayList();
        ArrayList<Endereco> end = new ArrayList();
        ArrayList<Instituicao> inst = new ArrayList();
        DAOEvento idao = new DAOEvento();
        String N = null;
        
        
        
        String acao = request.getParameter("acao");
            if (acao.equals("Consultar")) {
                
                N=(request.getParameter("txtnome"));
 
            }else {
                return "erro.jsp";
            }
        eve = idao.Consultar(N);
         
        
        for(int j = 0; j < eve.size(); j++){
            
            
            end = idao.EventoEndereco(eve.get(j).getIdEvento());
            
            inst = idao.InstituicaoEvento(eve.get(j).getIdEvento());
            
        }   
            
        //despachar tudo 
         request.setAttribute("listaEV", eve);
         request.setAttribute("listaEnd", end);
         request.setAttribute("listaInst", inst);

        
        String url = request.getParameter("url");
        if(url!=null){
          RequestDispatcher rd= request.getRequestDispatcher("/listaEVCompleto.jsp");
        rd.forward(request, response);  
        }else{
            RequestDispatcher rd= request.getRequestDispatcher("/listaEvento.jsp");
        rd.forward(request, response);
        }
        
        return "listaEvento.jsp";
    }
    // falta os metodos da daoEvento  inst metodo errado
}

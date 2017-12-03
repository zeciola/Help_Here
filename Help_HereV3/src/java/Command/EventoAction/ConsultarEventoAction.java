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
import Model.Pessoa;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsultarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Evento> eve = new ArrayList();
        ArrayList<Endereco> end = new ArrayList();
        ArrayList<Instituicao> inst = new ArrayList();
        ArrayList<Pessoa> pe = new ArrayList();
        DAOEvento idao = new DAOEvento();
        Evento ev = new Evento();
        String N = null;
        String Nome;
        N=(request.getParameter("txtIDEV"));  
        Nome = (request.getParameter("txtnome"));
        
       /* String acao = request.getParameter("acao");
            if (acao.equals("Consultar")) {
                
                
 
            }else {
                return "erro.jsp";
            }*/
            
        if (Nome == null ){
        ev.setIdEvento(Integer.parseInt(N));
        eve = idao.Consultar(ev); 
         
        
        for(int j = 0; j < eve.size(); j++){
            
            ev.setIdEvento(eve.get(j).getIdEvento());
            end = idao.EventoEndereco(ev); 
            
            
            inst = idao.InstituicaoEvento(ev);
            
            pe = idao.PessoaEvento(ev); 
            
        }   
            
        //despachar tudo 
        
          request.setAttribute("listaEV", eve);
         request.setAttribute("listaEnd", end);
         request.setAttribute("listaInst", inst);
         request.setAttribute("listaPessoa", pe);
         
       // String urla = request.getParameter("urla");
        String url = request.getParameter("url");
        
       /* if(urla!=null){
            RequestDispatcher rd= request.getRequestDispatcher("/listaEVCompletoPessoa.jsp");
        rd.forward(request, response);  
        
        }*/
        
        if(url!=null){
         request.setAttribute("listaEV", eve);
         request.setAttribute("listaEnd", end);
         request.setAttribute("listaInst", inst);
         request.setAttribute("listaPessoa", pe);
          RequestDispatcher rd= request.getRequestDispatcher("/listaEVCompleto.jsp");
        rd.forward(request, response); 
        return "listaEVCompleto.jsp";
        }else{
            
        }
        }else {
            ev.setNome(Nome);
            eve = idao.ConsultarPorNome(ev);
            request.setAttribute("listaEV", eve);
            RequestDispatcher rd= request.getRequestDispatcher("/ConsultaEvento.jsp");
            rd.forward(request, response);
        }
        
        return "ConsultaEvento.jsp";
    }
    // falta os metodos da daoEvento  inst metodo errado
}

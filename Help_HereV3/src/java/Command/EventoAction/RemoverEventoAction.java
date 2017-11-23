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
import Model.Usuario;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11141104689
 */
public class RemoverEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOEvento daoi = new DAOEvento();
        
        DAOEvento idao = new DAOEvento();
        ArrayList<Evento> eve = new ArrayList();
        Evento ev = new Evento();
        Instituicao ins = new Instituicao();
        Endereco en = new Endereco();
        ArrayList<Endereco> end = new ArrayList();
        ArrayList<Instituicao> inst = new ArrayList();
        ArrayList<Pessoa> pe = new ArrayList();
        
        String urm = request.getParameter("urm");
        
      
            

                String NomeEV = request.getParameter("txtnomeEV");
                ev.setNome(NomeEV);
                
 
                
 

 
                if (urm == null)
 
                {
                        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
                        Usuario usuario =(Usuario)sessaoUsuario.getAttribute("usuarioAutenticado");
                        String SEN = usuario.getSenha();
                        eve = idao.ConsultarEVPessoa(ev,usuario);
                        
                         for(int j = 0; j < eve.size(); j++){

                            ev.setIdEvento(eve.get(j).getIdEvento()); 
                            ev.setDataInicio(eve.get(j).getDataInicio());
                            end = idao.EventoEndereco(ev); 

                            
                            pe = idao.PessoaEvento(ev);
                        }   
                      
                       Date datahoje = new Date(System.currentTimeMillis());
                       
                        /* Regra de negócio proibir edição de eventos que já iniciaram*/
                        
                        if (datahoje.after(ev.getDataInicio()) ){
                            return "/AlterareExcluirNegado.jsp"; 
                        }else{
                        
                        
                        daoi.DeletarEvPessoa(ev,usuario);
                    // if para remover evento pessoa, falta colocar um if na jsp lista evento, metodo na dao criado
                        return "/acessologado/EventoPessoa.jsp";
                        }
 
                }else {
                        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
                        Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("instAutenticado");
                        String SEN = usuarioLogado.getSenha();
                        
                        eve = idao.ConsultarEVinst(ev,usuarioLogado);
                        
                        for(int j = 0; j < eve.size(); j++){

                            ev.setIdEvento(eve.get(j).getIdEvento()); 
                            ev.setDataInicio(eve.get(j).getDataInicio());
                            end = idao.EventoEndereco(ev);  

                            inst = idao.InstituicaoEvento(ev); 
                            
                        }
                        
                         Date datahoje = new Date(System.currentTimeMillis());
                       
                        
                        /* Regra de negócio proibir edição de eventos que já iniciaram*/
                        
                        if (datahoje.after(ev.getDataInicio()) ){
                            return "/AlterareExcluirNegado.jsp"; 
                        }else{
                        
                        //eve = idao.ConsultarEVinst(NomeEV,SEN);
                        daoi.Deletar(ev,usuarioLogado); 
                        return "/acessologado/Evento.jsp";
                        }
                }
 
        
 
    }

    
}

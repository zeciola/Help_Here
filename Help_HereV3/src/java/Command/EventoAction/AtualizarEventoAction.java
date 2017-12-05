/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOEvento;
import Model.Endereco;
import Model.Evento;
import Model.Instituicao;
import Model.Pessoa;
import Model.Usuario;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 11141104689
 */
public class AtualizarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
    ArrayList<Evento> eve = new ArrayList();
        ArrayList<Endereco> end = new ArrayList();
        ArrayList<Instituicao> inst = new ArrayList();
        Endereco en = new Endereco();
        DAOEvento daoev = new DAOEvento();
        Evento ev = new Evento();
        ArrayList<Pessoa> pe = new ArrayList();
        
        
        
        String url = request.getParameter("url");
        String u = request.getParameter("u");
        
        
        if (url!= null){
                HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
                Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("instAutenticado");
                String senha = usuarioLogado.getSenha();
                int IdEV = (Integer.parseInt(request.getParameter("txtIDEV")));
                ev.setIdEvento(IdEV);
                usuarioLogado.setSenha(senha);
                eve = daoev.ConsultarEVinst(ev,usuarioLogado);
                
                if (eve.isEmpty())
                {
                    return "/EventoErrado.jsp"; 


                       
                }else
                    {
                      for(int j = 0; j < eve.size(); j++){

                            ev.setIdEvento(eve.get(j).getIdEvento()); 
                            ev.setDataInicio(eve.get(j).getDataInicio());
                            end = daoev.EventoEndereco(ev); 

                            inst = daoev.InstituicaoEvento(ev); 
                            
                        } 
                      
                        Date datahoje = new Date(System.currentTimeMillis());
                       
                       
                        
                        
                        /* Regra de negócio proibir edição de eventos que já iniciaram*/
                        
                        if (datahoje.after(ev.getDataInicio()) ){
                            return "/AlterareExcluirNegado.jsp"; 
                        }else{
                            
                        
                        //despachar tudo 
                         request.setAttribute("listaEV", eve);
                         request.setAttribute("listaEnd", end);
                         request.setAttribute("listaInst", inst);
                         

                        RequestDispatcher rd= request.getRequestDispatcher("/AlterarEvento.jsp");
                        rd.forward(request, response);  
                        }
                             
                    }
                
        }   
        else if (u!= null)  {
                HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
                Usuario user =(Usuario)sessaoUsuario.getAttribute("usuarioAutenticado");
                String sen = user.getSenha();
                int IdEV = (Integer.parseInt(request.getParameter("txtIDEV")));
                ev.setIdEvento(IdEV);
                user.setSenha(sen);
                eve = daoev.ConsultarEVPessoa(ev,user);  
                
                          

                if (eve.isEmpty())
                {
                    return "/EventoErrado.jsp"; 


                       
                }else
                    {
                      for(int j = 0; j < eve.size(); j++){

                            ev.setIdEvento(eve.get(j).getIdEvento()); 
                            ev.setDataInicio(eve.get(j).getDataInicio());
                            end = daoev.EventoEndereco(ev); 

                            
                            pe = daoev.PessoaEvento(ev);
                        }   
                      
                       Date datahoje = new Date(System.currentTimeMillis());
                       
                       
                        
                        
                        /* Regra de negócio proibir edição de eventos que já iniciaram*/
                        
                        if (datahoje.after(ev.getDataInicio()) ){
                            return "/AlterareExcluirNegado.jsp"; 
                        }else{

                        //despachar tudo 
                         request.setAttribute("listaEV", eve);
                         request.setAttribute("listaEnd", end);
                         
                         request.setAttribute("listaPe", pe);

                        RequestDispatcher rd= request.getRequestDispatcher("/AlterarEvento.jsp");
                        rd.forward(request, response);  

                             
                    }
               }
        }else if ((url == null) && (u == null ))
        {
                
                
            
                        // endereco do evento
                String[] idEnd = request.getParameterValues("idEnd");
                String[] cepend = request.getParameterValues("cep");
                String[] nomeend = request.getParameterValues("endereco");
                String[] numeroend = request.getParameterValues("numero");
                String[] bairro = request.getParameterValues("bairro");
                String[] cidade = request.getParameterValues("cidade");
                String[] estado = request.getParameterValues("estado");
                String[] pais = request.getParameterValues("pais");

                //instiruicao
                String[] idinst = request.getParameterValues("idInst");
                String[] nomeinst = request.getParameterValues("inst");
                String[] razaosocial = request.getParameterValues("razao");
                String[] tipoinst = request.getParameterValues("tipo");
                String[] cnpjinst = request.getParameterValues("cnpj");
                String[] modalidadeinst = request.getParameterValues("modalidade");
                String[] emailinst = request.getParameterValues("email");


                
                
                
                    if (idinst != null){
                        
                   for (int i=0; i < cepend.length; i++){
                            Endereco e = new Endereco(); 
                                
                                e.setIdEndereco(Integer.parseInt(idEnd[i]));
                                e.setCep(cepend[i]);
                                e.setNomelogradouro(nomeend[i]);
                                e.setNumeroen(Integer.parseInt(numeroend[i]));
                                e.setBairro(bairro[i]);
                                e.setMunicipio(cidade[i]);
                                e.setEstado(estado[i]);
                                e.setPais(pais[i]);
                                DAOEvento daoe = new DAOEvento();
                                
                                daoe.AtualizarEndEV(e);   //verificar se deu certo

                             end.add(e);

                         }     
                        
                    for (int i=0; i < idinst.length; i++){  //Ta dando erro aqui <<<<<<<<<<<<
                            Instituicao in = new Instituicao();

                            in.setIdInstituicao(Integer.parseInt(idinst[i]));
                            in.setNome(nomeinst[i]);
                            in.setRazao(razaosocial[i]);
                            in.setTipo(tipoinst[i]);
                            in.setCnpj(cnpjinst[i]);
                            in.setModalidade(modalidadeinst[i]);
                            in.setEmail(emailinst[i]);

                            inst.add(in);

                    }
                    
                    ev.setIdEvento(Integer.parseInt(request.getParameter("idEve")));
                    
                    

                            String data1 = request.getParameter("inicio");
                                 DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                                 java.sql.Date data = new java.sql.Date(fmt.parse(data1).getTime());
                            ev.setDataInicio(data);
                            
                            
                            String data2 = request.getParameter("fim");

                                 DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
                                 java.sql.Date dataf = new java.sql.Date(fmt2.parse(data2).getTime());
                            ev.setDataFim(dataf);


                    ev.setNome(request.getParameter("nome"));
                    ev.setTipoEvento(request.getParameter("tipoEven"));
                    ev.setDescricao(request.getParameter("descricao"));
                    
                    String valor = null;
        
                    valor = (request.getParameter("valordoar"));

                    if (valor.isEmpty()){
                        ev.setMetaVoluntario(Integer.parseInt(request.getParameter("volunquant")));
                        daoev.AtualizarEvVolunt(ev);
                    }else{
                        ev.setMetaValor(Double.parseDouble(request.getParameter("valordoar")));
                        daoev.AtualizarEvDoa(ev);
                    }
                    
                     
                    
                    
                    return "/acessologado/Evento.jsp"; 
                    
                    }else {
                        
                        
                        
                        for (int i=0; i < cepend.length; i++){
                            Endereco e = new Endereco(); 
                                
                                e.setIdEndereco(Integer.parseInt(idEnd[i]));
                                e.setCep(cepend[i]);
                                e.setNomelogradouro(nomeend[i]);
                                e.setNumeroen(Integer.parseInt(numeroend[i]));
                                e.setBairro(bairro[i]);
                                e.setMunicipio(cidade[i]);
                                e.setEstado(estado[i]);
                                e.setPais(pais[i]);
                                DAOEvento daoe = new DAOEvento();
                                
                                daoe.AtualizarEndEV(e);   //verificar se deu certo

                             end.add(e);

                         }
                                ev.setIdEvento(Integer.parseInt(request.getParameter("idEve")));
                    
                            Date datahoje = new Date(System.currentTimeMillis());

                            String data1 = request.getParameter("inicio");
                                 DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                                 java.sql.Date data = new java.sql.Date(fmt.parse(data1).getTime());
                            ev.setDataInicio(data);
                            
                            
                            String data2 = request.getParameter("fim");

                                 DateFormat fmt2 = new SimpleDateFormat("yyyy-MM-dd");
                                 java.sql.Date dataf = new java.sql.Date(fmt2.parse(data2).getTime());
                            ev.setDataFim(dataf);


                    ev.setNome(request.getParameter("nome"));
                    ev.setTipoEvento(request.getParameter("tipoEven"));
                    ev.setDescricao(request.getParameter("descricao"));
                    ev.setMetaValor(Double.parseDouble(request.getParameter("valordoar")));
                    daoev.AtualizarEvDoa(ev); 
                    
                    
                                return "/acessologado/EventoPessoa.jsp";
                                                                 
                                 }

                    
                   
                    
    }
            
        
        return "/sucesso.jsp";
        }
    
}

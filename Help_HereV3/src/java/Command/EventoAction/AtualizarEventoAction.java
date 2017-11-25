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
        DAOEvento idao = new DAOEvento();
        Evento even = new Evento();
        ArrayList<Pessoa> pe = new ArrayList();
        
        
        
        String url = request.getParameter("url");
        String u = request.getParameter("u");
        
        
        if (url!= null){
                HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
                Instituicao usuarioLogado =(Instituicao)sessaoUsuario.getAttribute("instAutenticado");
                String senha = usuarioLogado.getSenha();
                String NomeEV = request.getParameter("txtnomeEV");
                even.setNome(NomeEV);
                usuarioLogado.setSenha(senha);
                eve = idao.ConsultarEVinst(even,usuarioLogado);
                
                if (eve.isEmpty())
                {
                    return "/EventoErrado.jsp"; 


                       
                }else
                    {
                      for(int j = 0; j < eve.size(); j++){

                            even.setIdEvento(eve.get(j).getIdEvento()); 
                            even.setDataInicio(eve.get(j).getDataInicio());
                            end = idao.EventoEndereco(even); 

                            inst = idao.InstituicaoEvento(even); 
                            
                        } 
                      
                        Date datahoje = new Date(System.currentTimeMillis());
                       
                       
                        
                        
                        /* Regra de negócio proibir edição de eventos que já iniciaram*/
                        
                        if (datahoje.after(even.getDataInicio()) ){
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
                String NomeEV = request.getParameter("txtnomeEV");
                even.setNome(NomeEV);
                user.setSenha(sen);
                eve = idao.ConsultarEVPessoa(even,user);  
                
                          

                if (eve.isEmpty())
                {
                    return "/EventoErrado.jsp"; 


                       
                }else
                    {
                      for(int j = 0; j < eve.size(); j++){

                            even.setIdEvento(eve.get(j).getIdEvento()); 
                            even.setDataInicio(eve.get(j).getDataInicio());
                            end = idao.EventoEndereco(even); 

                            
                            pe = idao.PessoaEvento(even);
                        }   
                      
                       Date datahoje = new Date(System.currentTimeMillis());
                       
                       
                        
                        
                        /* Regra de negócio proibir edição de eventos que já iniciaram*/
                        
                        if (datahoje.after(even.getDataInicio()) ){
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
                Evento ev = new Evento();
                DAOEvento daoevento = new DAOEvento();
            
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

                    
                    daoevento.AtualizarEvento(ev); 
                    
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
                    return "/acessologado/Evento.jsp"; 
                    
                    }else {
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

                    
                    daoevento.AtualizarEvento(ev); 
                    
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
                                return "/acessologado/EventoPessoa.jsp";
                                                                 
                                 }

                    
                   
                    
    }
            
        
        return "/sucesso.jsp";
        }
    
}

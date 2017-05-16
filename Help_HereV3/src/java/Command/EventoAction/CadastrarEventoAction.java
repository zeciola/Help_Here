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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 11141104689
 */
public class CadastrarEventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ArrayList<Instituicao> inst = new ArrayList();
    ArrayList<Pessoa> pe = new ArrayList();
    ArrayList<Endereco> end = new ArrayList();
    Evento ev = new Evento();
    DAOEvento daoevento = new DAOEvento();
    
    // endereco do evento
    String[] cepend = request.getParameterValues("cep");
    String[] nomeend = request.getParameterValues("nomeendereco");
    String[] numeroend = request.getParameterValues("numeroendereco");
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
    
          
        for (int i=0; i < cepend.length; i++){
                Endereco e = new Endereco();
                
                    e.setCep(cepend[i]);
                    e.setNomelogradouro(nomeend[i]);
                    e.setNumeroen(Integer.parseInt(numeroend[i]));
                    e.setBairro(bairro[i]);
                    e.setMunicipio(cidade[i]);
                    e.setEstado(estado[i]);
                    e.setPais(pais[i]);
                    DAOEndereco daoe = new DAOEndereco();
                    daoe.setEndereco(e);
                    daoe.Inserir();
     
                 end.add(e);
                 
             }
       
        for (int i=0; i < idinst.length; i++){
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
    
    
        ev.setDataInicio(request.getParameter("inicio"));
        ev.setDataFim(request.getParameter("fim"));
        ev.setNome(request.getParameter("nome"));
        ev.setTipoEvento(request.getParameter("tipoEven"));
        ev.setDescricao(request.getParameter("descricao"));
                
        daoevento.setEvento(ev);
        daoevento.Inserir();
    
        for(int j = 0; j < inst.size(); j++){
            int idInst =inst.get(j).getIdInstituicao();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxInstituicaoEvento(idInst, ev.getIdEvento());
        }
        
        for(int j = 0; j < end.size(); j++){
            int idEnd =end.get(j).getIdEndereco();
            
            DAOEvento Ed = new DAOEvento();
            Ed.InserirAuxEnderecoEvento(idEnd, ev.getIdEvento());
        }
        
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "sucesso.jsp";
    }
    
}

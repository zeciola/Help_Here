/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.EventoAction;

import Command.ICommand;
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
   
    while (inst.isEmpty()){
                Instituicao in = new Instituicao();
                
                 in.setNome(request.getParameter("nome"));
                 in.setRazao(request.getParameter("razao"));
                 in.setTipo(request.getParameter("tipo"));
                 in.setCnpj(request.getParameter("cnpj"));
                 in.setModalidade(request.getParameter("modalidade"));
                 in.setEmail(request.getParameter("email"));
                 
     
                 inst.add(in);
                 
             }
          
        while (end.isEmpty()){
                Endereco en = new Endereco();
                
                    en.setCep(request.getParameter("cep"));
                    en.setNomelogradouro(request.getParameter("endereco"));
                    en.setNumeroen(Integer.parseInt(request.getParameter("numero")));
                    en.setBairro(request.getParameter("bairro"));
                    en.setMunicipio(request.getParameter("cidade"));
                    en.setEstado(request.getParameter("estado"));
                    en.setPais(request.getParameter("pais"));
                 
     
                 end.add(en);
                 
             }
    
    
        ev.setDataInicio(request.getParameter("inicio"));
        ev.setDataFim(request.getParameter("fim"));
        ev.setNome(request.getParameter("nome"));
        ev.setTipoEvento(request.getParameter("tipoEven"));
        ev.setDescricao(request.getParameter("descricao"));
        ev.setInstResponsavel(inst);
        ev.setEndereco(end);
        
        
        daoevento.Inserir();
    
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "sucesso.jsp";
    }
    
}

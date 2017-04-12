/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.InstituicaoAction;

import Command.ICommand;
import DAO.*;
import DAO.DAOInstituicao;
import DAO.DAOUsuario;
import Model.Endereco;
import Model.Login;
import Model.Instituicao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Puglia
 */
public class CadastrarInstituicaoAction implements ICommand {


    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
     
        
        //Instanciando Objetos
        Endereco en = new Endereco();
        Instituicao inst = new Instituicao();
        
        
        //DAOs
        
        DAOInstituicao daoi = new DAOInstituicao();
        
        
        
        
        
        
        //Instituicao
        inst.setNome(request.getParameter("nome"));
        inst.setRazao(request.getParameter("razao"));
        inst.setTipo(request.getParameter("tipo"));
        inst.setCnpj(request.getParameter("cnpj"));
        inst.setModalidade(request.getParameter("modalidade"));
        inst.setEmail(request.getParameter("email"));
        inst.setSenha(request.getParameter("senha"));
        
        
        //Endereco da Instituicao
        
        en.setCep(request.getParameter("cep"));
        en.setNomelogradouro(request.getParameter("endereco"));
        en.setNumeroen(Integer.parseInt(request.getParameter("numero")));
        en.setBairro(request.getParameter("bairro"));
        en.setMunicipio(request.getParameter("cidade"));
        en.setEstado(request.getParameter("estado"));
        en.setPais(request.getParameter("pais"));
        
        
        
        inst.setEndereco(en);
        daoi.setInstituicao(inst);
        daoi.Inserir();
        
        
        
        
        
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "sucesso.jsp";
        
    }
    
}

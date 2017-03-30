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
        
        DAOEndereco daoen = new DAOEndereco();
        
        
        
        
        //Instituicao
        inst.setNome(request.getParameter("Nome"));
        inst.setRazao(request.getParameter("razaoSocial"));
        inst.setTipo(request.getParameter("tipo"));
        inst.setCnpj(request.getParameter("CNPJ"));
        inst.setModalidade(request.getParameter("modalidade"));
        inst.setEmail(request.getParameter("email"));
        
        
        daoi.setInstituicao();
        daoi.Inserir();
        
        //Endereco da Instituicao
        
        en.setNomelogradouro("nomelogradouro");
        en.setNumeroen("numeroen");
        en.setMunicipio("municipio");
        en.setEstado("estado");
        en.setBairro("bairro");
        en.setCep("cep");
        en.setPais("pais");
        
        daoen.setEndereco(en);
        daoen.Inserir();
        //Usuário
        
        
        
        
        
        
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
        
    }
    
}

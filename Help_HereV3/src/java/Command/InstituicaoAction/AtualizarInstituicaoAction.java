/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command.InstituicaoAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOInstituicao;
import DAO.DAOUsuario;
import Model.Endereco;
import Model.Instituicao;
import Model.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Puglia
 */
public class AtualizarInstituicaoAction implements ICommand {



    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Date datanas = null;
        
        //Instanciando Objetos
        Endereco en = new Endereco();
        Instituicao inst = new Instituicao();
        Login lo = new Login();
        
        //DAOs
        DAOEndereco daoen = new DAOEndereco();
        DAOInstituicao daoi = new DAOInstituicao();
        DAOUsuario daou = new DAOUsuario();
        
        
        boolean defalt = false;
        
        //Instituicao
        inst.setNome(request.getParameter("nome"));
        inst.setRazao("razaoSocial");
        inst.setTipo("tipo");
        inst.setCnpj("CNPJ");
        inst.setModalidade("modalidade");
        
        
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
        
        //Email
        
        lo.setId(inst.getIdInstituicao());
        lo.setNome("email");
        lo.setSenha("senha");
        
        daou.setUsuario(lo);
        
        
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
        
    }
    
}

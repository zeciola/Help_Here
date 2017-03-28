package Command.PessoaAction;

import Command.*;
import DAO.*;
import Model.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Date datanas = null;
        
        //Instanciando Objetos
        Endereco en = new Endereco();
        Pessoa pe = new Pessoa();
        Login lo = new Login();
        
        //DAOs
        DAOEndereco daoen = new DAOEndereco();
        DAOPessoa daop = new DAOPessoa();
        DAOUsuario daou = new DAOUsuario();
        
        
        boolean defalt = false;
        
        //Pessoa
        pe.setNome(request.getParameter("nome"));
        pe.setSobrenome("sobrenome");
        pe.setCpf("cpf");
        pe.setRg("rg");
        pe.setPenalisado(defalt);
        pe.setDatanascimento("datanascimento");
        pe.setEmail("email");
        pe.setTelefone("telefone");
        pe.setCelular("celular");
        pe.setSexo("sexo");
        
        
        daop.setPessoa();
        daop.Inserir();
        
        //Endereco de pessoa
        
        en.setNomelogradouro("nomelogradouro");
        en.setNumeroen("numeroen");
        en.setMunicipio("municipio");
        en.setEstado("estado");
        en.setBairro("bairro");
        en.setCep("cep");
        en.setPais("pais");
        
        daoen.setEndereco(en);
        
        //Usuário
        
        //Email
        
        lo.setId(pe.getId());
        lo.setNome("email");
        lo.setSenha("senha");
        
        daou.setUsuario(lo);
        
        
        //Redirecionar para pagina de perfil de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
        
    }
    
}

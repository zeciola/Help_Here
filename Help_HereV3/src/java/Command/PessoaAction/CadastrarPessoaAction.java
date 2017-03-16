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
        
        Date datanas = null;
        
        Endereco en = new Endereco();
        Pessoa pe = new Pessoa();
        DAOEndereco daoen = new DAOEndereco();
        DAOPessoa daop = new DAOPessoa();
        
        //Pessoa
        pe.setNome("nome");
        pe.setEmail("email");
        pe.setDatanas(datanas);
        pe.setCelular("celular");
        pe.setTelefone("telefone");
        pe.setRg("rg");
        pe.setCpf("cpf");
        pe.setSexo("sexo");
        
        daop.setPessoa();
        
        //Endereco de pessoa
        en.setEndereco("endereco");
        en.setNumeroen("numeroen");
        en.setCidade("cidade");
        en.setEstado("estado");
        en.setCep("cep");
        
        daoen.setEndereco(en);
        return "/sucesso.jsp";
        
    }
    
}

package Command.PessoaAction;

import Command.*;
import DAO.*;
import Model.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Endereco en = new Endereco();
        DAOEndereco daoe = new DAOEndereco();
        
        en.setEndereco("endereco");
        en.setNumeroen("numeroen");
        en.setCidade("cidade");
        en.setEstado("estado");
        en.setCep("cep");
        
        daoe.setEndereco(en);
        return null;
        
    }
    
}

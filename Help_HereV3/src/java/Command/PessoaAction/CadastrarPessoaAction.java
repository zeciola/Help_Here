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
        pe.setSobrenome(request.getParameter("sobrenome"));
        pe.setCpf(request.getParameter("cpf"));
        pe.setRg(request.getParameter("rg"));
        //Variavel defalt
        pe.setPenalisado(defalt);
        pe.setDatanascimento(request.getParameter("datanascimento"));
        pe.setEmail(request.getParameter("email"));
        pe.setTelefone(request.getParameter("telefone"));
        pe.setCelular(request.getParameter("celular"));
        pe.setSexo(request.getParameter("sexo"));
        
        
        daop.setPessoa(pe);
        daop.Inserir();
        
        //Endereco de pessoa
        
        en.setNomelogradouro(request.getParameter("nomelogradouro"));
        en.setNumeroen(request.getParameter("numeroen"));
        en.setMunicipio(request.getParameter("municipio"));
        en.setEstado(request.getParameter("estado"));
        en.setBairro(request.getParameter("bairro"));
        en.setCep(request.getParameter("cep"));
        en.setPais(request.getParameter("pais"));
        
        daoen.setEndereco(en);
        daoen.Inserir();
        
        //Usuário

        //ID Pessoa
        lo.setId(pe.getId());
        
        //Email
        lo.setNome(request.getParameter("email"));
        lo.setSenha(request.getParameter("senha"));
        
        //Seta os valores
        daou.setUsuario(lo);
        
        //Executa o metodo Insert
        daou.Inserir();
        
        
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
        
    }
    
}

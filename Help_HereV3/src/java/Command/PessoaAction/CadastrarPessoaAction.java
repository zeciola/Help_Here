package Command.PessoaAction;

import Command.*;
import DAO.*;
import Model.*;
import Util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class CadastrarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Instanciando Objetos
        Endereco en = new Endereco();
        Pessoa pe = new Pessoa();
        Login lo = new Login();
        
        //DAOs

        boolean defalt = false;

        //Endereco de pessoa
        DAOEndereco daoen = new DAOEndereco();
        
        en.setNomelogradouro(request.getParameter("nomelogradouro"));
        en.setNumeroen(Integer.parseInt(request.getParameter("numeroen")));
        en.setMunicipio(request.getParameter("municipio"));
        en.setEstado(request.getParameter("estado"));
        en.setBairro(request.getParameter("bairro"));
        en.setCep(request.getParameter("cep"));
        en.setPais(request.getParameter("pais"));
        
        //Seta o endereco na pessoa 
        pe.setEn(en);
        daoen.setEndereco(en);
        daoen.Inserir();
        
        
        DAOPessoa daop = new DAOPessoa();
        //Pessoa
        pe.setNome(request.getParameter("nome"));
        pe.setSobrenome(request.getParameter("sobrenome"));
        pe.setCpf(request.getParameter("cpf"));
        pe.setRg(request.getParameter("rg"));
        //Variavel defalt
        pe.setPenalisado(defalt);
        
        //pe.setDatanascimento(ConvertData.converteStringParaDate(request.getParameter("datanascimento")));
        pe.setDatanascimento(request.getParameter("datanascimento"));
        
        
        pe.setEmail(request.getParameter("email"));
        //Id Endereço foreign key
        
        pe.setTelefone(request.getParameter("telefone"));
        pe.setCelular(request.getParameter("celular"));
        pe.setSexo(request.getParameter("sexo"));
        
        en.setPe(pe);
        daop.setEndereco(en);
        daop.setPessoa(pe);
        daop.Inserir();
        
        //Usuário
        DAOUsuario daou = new DAOUsuario();
        
        
        lo.setPerfil(PerfilDeAcesso.comum);
        //Email
        lo.setNome(request.getParameter("email"));
        lo.setSenha(request.getParameter("senha"));
        
        //Seta os valores
        lo.setPe(pe);
        daou.setUsuario(lo);
        
        //Executa o metodo Insert
        daou.setPessoa(pe);
        daou.setUsuario(lo);
        daou.Inserir();
        
        
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
        
    }
    
}

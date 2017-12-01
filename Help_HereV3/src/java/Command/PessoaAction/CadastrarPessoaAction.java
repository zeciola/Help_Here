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
import javax.servlet.http.HttpSession;

public class CadastrarPessoaAction implements ICommand {

    private Endereco en = new Endereco();
    private Pessoa pe = new Pessoa();
    private Usuario lo = new Usuario();
    //DAOs
    private DAOEndereco daoen = new DAOEndereco();
    private DAOPessoa daop = new DAOPessoa();
    private DAOUsuario daou = new DAOUsuario();

    private boolean defalt = false;
    private boolean status = true;
    
    //Email
    private email email = new email();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        
        
        
        
        //Endereco de pessoa
        en.setNomelogradouro(request.getParameter("nomelogradouro"));
        en.setNumeroen(Integer.parseInt(request.getParameter("numeroen")));
        en.setMunicipio(request.getParameter("municipio"));
        en.setEstado(request.getParameter("estado"));
        en.setBairro(request.getParameter("bairro"));
        en.setCep(request.getParameter("cep"));
        en.setPais(request.getParameter("pais"));
        //status
        en.setStatus(status);

        //Seta o endereco na pessoa 
        pe.setEn(en);
        daoen.Inserir(en);

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
        //status
        pe.setStatus(status);
        pe.setContador(0);

        en.setPe(pe);
        daop.Inserir(pe);

        //Usuário
        lo.setPerfil(PerfilDeAcesso.comum);
        //Email
        lo.setNome(request.getParameter("email"));
        
        String EmailTo = request.getParameter("email");
        
        lo.setSenha(request.getParameter("senha"));
        //status
        lo.setStatus(status);

        //Seta os valores
        lo.setPe(pe);
        daou.Inserir(lo);
        
        HttpSession sessaoUsuario = request.getSession();
        sessaoUsuario.setAttribute("userid", lo);
        
        String Subject = "Cadastro Realizado com sucesso";
        
        String Msg = "Obrigado por se cadastrar no HelpHere";

        email.sendEmail(EmailTo, Subject, Msg);
        
        
        
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/checkbox.html";

    }

}

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

public class CadastrarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Instanciando Objetos
            Endereco en = new Endereco();
        Pessoa pe = new Pessoa();
        Usuario lo = new Usuario();
        
        
        //DAOs

        boolean defalt = false;
        boolean status = true;

        //Endereco de pessoa
        DAOEndereco daoen = new DAOEndereco();
        
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
        //status
        pe.setStatus(status);
        
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
        //status
        lo.setStatus(status);
        
        //Seta os valores
        lo.setPe(pe);
        daou.setUsuario(lo);
        
        //Executa o metodo Insert
        daou.setPessoa(pe);
        daou.setUsuario(lo);
        daou.Inserir();
        
        //enviar e-mail
        EmailJava email = new EmailJava();
        String from = "HelpHereBr@gmail.com"; 
        String subject = "Bem Vindo ao HelpHere";
        String msg = "Seu cadastro foi efetuado com sucesso";
        String to = request.getParameter("email");
        email.enviarEmail(from, subject, msg, to);
        
        
        //adiciona id para cadastro de interesses
        HttpSession sessaousuario = request.getSession();
        sessaousuario.setAttribute("userid", lo);
        
        
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/checkbox.html";
        
    }
    
}

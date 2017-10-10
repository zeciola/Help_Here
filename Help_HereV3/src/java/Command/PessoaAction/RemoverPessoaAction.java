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

public class RemoverPessoaAction implements ICommand {

    private Endereco en = new Endereco();
    private Pessoa pe = new Pessoa();
    private Usuario lo = new Usuario();
    
    //DAOs
    private DAOUsuario daou = new DAOUsuario();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        String Email = request.getParameter("txtEmail");
        String Senha = request.getParameter("txtSenha");;

        HttpSession sessoaUsuario = ((HttpServletRequest) request).getSession();
        Usuario usuarioLogado = (Usuario) sessoaUsuario.getAttribute("usuarioAutenticado");

        String EmailU = usuarioLogado.getNome();

        if (Email.equals(EmailU)) {

            daou.Deletar(Email, Senha, lo);

            //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
            return "/sucesso.jsp";

        } else {
            return "/Erro.jsp";
        }

    }
}

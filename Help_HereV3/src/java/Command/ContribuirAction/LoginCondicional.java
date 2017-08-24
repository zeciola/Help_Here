package Command.ContribuirAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOPessoa;
import DAO.DAOUsuario;
import Model.Endereco;
import Model.Evento;
import Model.Instituicao;
import Model.Pessoa;
import Model.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCondicional implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // variaveis
        Evento eve = new Evento();
        ArrayList<Endereco> end = new ArrayList();
        ArrayList<Instituicao> inst = new ArrayList();
        DAOEvento idao = new DAOEvento();

        //pegar login e senha
        Usuario login = new Usuario();
        login.setNome(request.getParameter("txtLogin"));
        login.setSenha(request.getParameter("txtSenha"));

        // realizar login
        DAOUsuario daousuario = new DAOUsuario();
        Usuario usuarioAutenticado = daousuario.autenticaUsuario(login);

        //pegar id do evento
        int id = Integer.parseInt(request.getParameter("txtid"));

        //consultar evento
        eve = idao.Consultar1(id);
        end = idao.EventoEndereco(eve.getIdEvento());
        eve.setEnds(end);
        inst = idao.InstituicaoEvento(eve.getIdEvento());

        DAOPessoa pdao = new DAOPessoa();
        int id2 = usuarioAutenticado.getPe().getId();
        Pessoa p = pdao.ConsultarId(id2);
        usuarioAutenticado.setPe(p);

        //cria sessao do user e joga outros
        HttpSession sessaoUsuario = request.getSession();
        sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
        sessaoUsuario.setAttribute("evento", eve);
        sessaoUsuario.setAttribute("resp", inst);

        //response.sendRedirect("acessologado/ajudar.jsp");
        return "acessologado/ajudemais.jsp";

    }
}

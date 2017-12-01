package Command.PessoaAction;

import Command.ICommand;
import DAO.*;
import Model.*;
import Util.*;
//import com.oracle.jrockit.jfr.RequestDelegate;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class ConsultarEmailPessoaAction implements ICommand {

    private ArrayList<Endereco> en = new ArrayList();
    private ArrayList<Pessoa> pe = new ArrayList();
    private ArrayList<Usuario> lo = new ArrayList();

    private Usuario U = new Usuario();
    private Pessoa p = new Pessoa();
    private Endereco e = new Endereco();

    private DAOEndereco daoen = new DAOEndereco();
    private DAOUsuario daou = new DAOUsuario();
    private DAOPessoa daope = new DAOPessoa();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        //Acao
        String acao = request.getParameter("acao");

        HttpSession sessoaUsuario = ((HttpServletRequest) request).getSession();
        Usuario usuarioLogado = (Usuario) sessoaUsuario.getAttribute("usuarioAutenticado");

        String Email = usuarioLogado.getNome();

        en = daoen.Consultar(Email, e);

        request.setAttribute("ListarEN", en);

        pe = daope.Consultar(Email, p);

        request.setAttribute("ListarPE", pe);

        lo = daou.Consultar(Email, U);

        request.setAttribute("ListarUS", lo);

        RequestDispatcher rd = request.getRequestDispatcher("/AlterarPessoa.jsp");
        rd.forward(request, response);

        return "/AlterarPessoa.jsp";

    }

}

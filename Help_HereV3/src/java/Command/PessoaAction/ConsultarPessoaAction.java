package Command.PessoaAction;

import Command.*;
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

public class ConsultarPessoaAction implements ICommand {

    private ArrayList<Endereco> en = new ArrayList();
    private ArrayList<Pessoa> pe = new ArrayList();
    private ArrayList<Usuario> lo = new ArrayList();

    private Usuario U = new Usuario();
    private Pessoa p = new Pessoa();
    private Endereco e = new Endereco();

    private DAOEndereco daoen = new DAOEndereco();
    private DAOUsuario daou = new DAOUsuario();
    private DAOUsuario idao = new DAOUsuario();
    private DAOPessoa daope = new DAOPessoa();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String URL = request.getParameter("URL");
        //Variaveis
        String email = null;
     
        //Acao
        String acao = request.getParameter("acao");

        if (URL != null) {
            HttpSession sessaoUsuario = ((HttpServletRequest) request).getSession();
            Usuario usuarioLogado = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");
                       
            //parei aqui 
            U = idao.ConsultarId(usuarioLogado); 
            //add a lista de evento o objeto request
            request.setAttribute("pessoa", U);
            //envia o request para o jsp
            RequestDispatcher rd = request.getRequestDispatcher("/acessologado/CriarEventosPessoa.jsp");
            rd.forward(request, response);
            return "acessologado/CriarEventosPessoa.jsp";

        } else if (acao.equals("Consultar")) {
            email = (request.getParameter("txtemail"));
        } else {
            return "erro.jsp";
        }
        p.setEmail(email);
        e.setPe(p);
        en = daoen.Consultar(e); 
        //en = daoen.Listar();

        request.setAttribute("ListaEn", en);
        p.setEmail(email);
        
        pe = daope.Consultar(p);
        //pe = daope.Listar();

        request.setAttribute("ListaPe", pe);
        
        U.setPe(p);
        
        lo = daou.Consultar(U);
        //lo = daou.Listar();

        request.setAttribute("ListaUs", lo);

        RequestDispatcher rd = request.getRequestDispatcher("/ListarPessoa.jsp");
        rd.forward(request, response);
        return "ListarPessoa.jsp";
    }

}

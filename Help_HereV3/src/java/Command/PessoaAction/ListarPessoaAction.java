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

public class ListarPessoaAction implements ICommand {

    private ArrayList<Endereco> en = new ArrayList();
    private ArrayList<Pessoa> pe = new ArrayList();
    private ArrayList<Usuario> lo = new ArrayList();

    private Usuario U = new Usuario();
    private Pessoa p = new Pessoa();
    private Endereco e = new Endereco();

    //DAOs
    private DAOEndereco daoen = new DAOEndereco();
    private DAOPessoa daope = new DAOPessoa();
    private DAOUsuario daou = new DAOUsuario();

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        en = daoen.Listar(en,e);

        request.setAttribute("ListaEn", en);

        pe = daope.Listar(pe,p);

        request.setAttribute("ListaPe", pe);

        lo = daou.Listar(lo,U);

        request.setAttribute("ListaUs", lo);

        RequestDispatcher rd = request.getRequestDispatcher("/ListarPessoa.jsp");
        rd.forward(request, response);
        return "ListarPessoa.jsp";

    }

}

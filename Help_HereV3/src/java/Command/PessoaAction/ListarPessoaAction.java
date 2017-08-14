package Command.PessoaAction;

import Command.*;
import DAO.*;
import Model.*;
import Util.*;
import com.oracle.jrockit.jfr.RequestDelegate;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class ListarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Endereco> en = new ArrayList();
        ArrayList<Pessoa> pe = new ArrayList();
        ArrayList<Usuario> lo = new ArrayList();
        
        DAOEndereco daoen = new DAOEndereco();
        en = daoen.Listar();
        
        request.setAttribute("ListaEn", en);
        
        DAOPessoa daope = new DAOPessoa();
        pe = daope.Listar();
        
        request.setAttribute("ListaPe", pe);
        
        DAOUsuario daou = new DAOUsuario();
        lo = daou.Listar();
        
        request.setAttribute("ListaUs", lo);
        
        RequestDispatcher rd = request.getRequestDispatcher("/ListarPessoa.jsp");
        rd.forward(request, response);
        return "ListarPessoa.jsp";
        
    }
    
}

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

public class ConsultarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Endereco> en = new ArrayList();
        ArrayList<Pessoa> pe = new ArrayList();
        ArrayList<Login> lo = new ArrayList();
        
        
        //Variaveis
        String email = null;
        
        //Acao
        String acao = request.getParameter("acao");
        
        if(acao.equals("Consultar")){
            email = (request.getParameter("txtemail"));
        }else{
            return "erro.jsp";
        }
        
        
        
        DAOEndereco daoen = new DAOEndereco();
        en = daoen.Consultar(email);
        //en = daoen.Listar();
        
        request.setAttribute("ListaEn", en);
        
        DAOPessoa daope = new DAOPessoa();
        pe = daope.Consultar(email);
        //pe = daope.Listar();
        
        request.setAttribute("ListaPe", pe);
        
        DAOUsuario daou = new DAOUsuario();
        lo = daou.Consultar(email);
        //lo = daou.Listar();
        
        request.setAttribute("ListaUs", lo);
        
        RequestDispatcher rd = request.getRequestDispatcher("/ListarPessoa.jsp");
        rd.forward(request, response);
        return "ListarPessoa.jsp";
    }
    
}

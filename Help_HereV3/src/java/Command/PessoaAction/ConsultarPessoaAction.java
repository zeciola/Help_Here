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
import javax.servlet.http.HttpSession;

public class ConsultarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Endereco> en = new ArrayList();
        ArrayList<Pessoa> pe = new ArrayList();
        Usuario U = new Usuario();
        ArrayList<Usuario> lo = new ArrayList();
        DAOUsuario idao = new DAOUsuario();
        
        String URL = request.getParameter("URL");
        //Variaveis
        String email = null;
        
        //Acao
        String acao = request.getParameter("acao");
        
        if (URL!= null){
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Usuario usuarioLogado =(Usuario)sessaoUsuario.getAttribute("usuarioAutenticado");
        int ID = usuarioLogado.getPe().getId();
        //parei aqui 
         U = idao.ConsultarId(ID); 
        //add a lista de evento o objeto request
        request.setAttribute("pessoa", U);
        //envia o request para o jsp
        RequestDispatcher rd= request.getRequestDispatcher("/CriarEventoPessoa.jsp");
        rd.forward(request, response);
        return "CriarEventoPessoa.jsp";   
            
            
        }
        
        else if(acao.equals("Consultar")){
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

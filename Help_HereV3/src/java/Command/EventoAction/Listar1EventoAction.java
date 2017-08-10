package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import Model.Evento;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listar1EventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
       ArrayList<Evento> i = new ArrayList();
        DAOEvento idao = new DAOEvento();
        String UR = request.getParameter("UR");
            
        if(UR != null){
            i = idao.ListarPorData();
            //add a lista de evento o objeto request
            request.setAttribute("evento", i);
            RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response); 
            return "index.jsp";
        }
        else{
            i = idao.Listar();
            //add a lista de evento o objeto request
            request.setAttribute("evento", i);
            //envia o request para o jsp
            RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return "index.jsp";
        }
    }   
}
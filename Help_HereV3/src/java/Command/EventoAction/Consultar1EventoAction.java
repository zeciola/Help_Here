package Command.EventoAction;

import Command.ICommand;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import Model.Endereco;
import Model.Evento;
import Model.Instituicao;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Consultar1EventoAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Evento eve = new Evento();
        ArrayList<Endereco> end = new ArrayList();
        ArrayList<Instituicao> inst = new ArrayList();
        DAOEvento idao = new DAOEvento();
        Integer id = null;    
        
        id = (Integer.parseInt(request.getParameter("ID")));
        eve = idao.Consultar1(id);        
                
        end = idao.EventoEndereco(eve.getIdEvento());
        eve.setEnds(end);
        
        inst = idao.InstituicaoEvento(eve.getIdEvento());
        
        //despachar tudo 
        request.setAttribute("evento", eve);
        request.setAttribute("resp", inst);

        return "evento.jsp";
    }
}

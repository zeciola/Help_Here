package Command.Feed;

import Command.ICommand;
import DAO.DAOFeeds;
import Model.Evento;
import Model.Pessoa;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirFeedAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        DAOFeeds daof = new DAOFeeds();
        
        String tipo = request.getParameter("tipo");
        //String tipo = "Doação";
        //int idev = 6;
        int idev = Integer.parseInt(request.getParameter("idev"));
        
        Evento ev = new Evento();
        ev.setIdEvento(idev);
                
       ArrayList<Pessoa> ps = daof.Interessados(tipo);
        
       //ArrayList<Integer> ids = daof.Interessados(tipo);
        
        for(int i=0; i< ps.size(); i++){
            daof.adicionarFeed(ps.get(i), ev);
        }
        
        return "/acessologado/logado.jsp";
    } 
}

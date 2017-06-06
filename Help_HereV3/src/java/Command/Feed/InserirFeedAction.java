package Command.Feed;

import Command.ICommand;
import DAO.DAOFeeds;
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
        
        ArrayList<Integer> ids = daof.Interessados(tipo);
        
        for(int i=0; i< ids.size(); i++){
            daof.adicionarFeed(ids.get(i), idev);
        }
        
        return "/acessologado/logado.jsp";
    } 
}

package Command.Feed;

import Command.ICommand;
import DAO.DAOFeeds;
import Model.Evento;
import Model.Feeds;
import Model.Pessoa;
import Model.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserirFeedAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        DAOFeeds daof = new DAOFeeds();
        
        String tipo = request.getParameter("tipo");
        int idev = Integer.parseInt(request.getParameter("idev"));
        
        Evento ev = new Evento();
        ev.setIdEvento(idev);
        ev.setTipoEvento(tipo);

        Feeds f = new Feeds();
        f.setE(ev);
        
       ArrayList<Pessoa> ps = daof.Interessados(f);
        
       //ArrayList<Integer> ids = daof.Interessados(tipo);
        
        for(int i=0; i< ps.size(); i++){
            Usuario u = new Usuario();
            u.setPe(ps.get(i));
            f.setU(u);
            daof.adicionarFeed(f);
        } 
        return "/acessologado/logado.jsp";
    } 
}

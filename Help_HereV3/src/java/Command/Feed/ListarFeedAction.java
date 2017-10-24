package Command.Feed;

import Command.ICommand;
import DAO.DAOFeeds;
import Model.Evento;
import Model.Feeds;
import Model.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarFeedAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession sessaoUsuario = request.getSession();
        Usuario l = (Usuario) sessaoUsuario.getAttribute("usuarioAutenticado");      

        Feeds f2 = new Feeds();        
        f2.setU(l);
        f2.getU().setId(Integer.parseInt(request.getParameter("iduser")));
        
        DAOFeeds daofeed = new DAOFeeds();
        ArrayList<Feeds> lista = daofeed.Listar(f2);
        if(lista.isEmpty()){
            Feeds f = new Feeds();
            Evento e = new Evento();
            e.setNome("Não tem");
            f.setE(e);
            lista.add(f);
        }
        sessaoUsuario.setAttribute("feed", lista);
        
        return "/acessologado/logado.jsp";
        
    }
    
}

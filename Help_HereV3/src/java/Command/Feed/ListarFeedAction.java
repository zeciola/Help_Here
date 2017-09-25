package Command.Feed;

import Command.ICommand;
import DAO.DAOFeeds;
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
        
        int i = Integer.parseInt(request.getParameter("iduser"));
        DAOFeeds daofeed = new DAOFeeds();
        ArrayList<Feeds> lista = daofeed.Listar(l);
        if(lista.isEmpty()){
            Feeds f = new Feeds();
            f.setNomeEvento("Não tem");
            lista.add(f);
        }
        request.setAttribute("feed", lista);
        
        return "/acessologado/logado.jsp";
        
    }
    
}

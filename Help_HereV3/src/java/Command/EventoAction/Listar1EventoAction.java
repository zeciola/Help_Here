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
import javax.servlet.http.HttpSession;

public class Listar1EventoAction implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ArrayList<Evento> i = new ArrayList();
        DAOEvento idao = new DAOEvento();
        String UR = request.getParameter("UR");
        HttpSession sessaoUsuario = request.getSession();
        if (UR != null) {
            i = idao.ListarPorData();
            //add a lista de evento o objeto request
            sessaoUsuario.setAttribute("evento", i);

            return "index.jsp";
        } else {
            i = idao.Listar();
            //add a lista de evento o objeto request
            sessaoUsuario.setAttribute("evento", i);
            //envia o request para o jsp
            String var = request.getParameter("url");
            if (var.equals("1")) {
                return "index.jsp";
            }else{
                return "logado.jsp";
            }
        }
    }
}

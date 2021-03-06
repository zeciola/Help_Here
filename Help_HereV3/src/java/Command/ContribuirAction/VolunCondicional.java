package Command.ContribuirAction;

import Command.ICommand;
import DAO.DAOContribuir;
import Model.Contribuicao;
import Model.Evento;
import Model.Usuario;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VolunCondicional implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sessaoUsuario =((HttpServletRequest)request).getSession();
        Evento e = (Evento) sessaoUsuario.getAttribute("evento");
        Usuario u =(Usuario)sessaoUsuario.getAttribute("usuarioAutenticado");
        
        Contribuicao c = new Contribuicao();
        c.setEv(e);
        c.setUser(u);
        
        DAOContribuir cdao = new DAOContribuir();
        ArrayList<Contribuicao> retorno = cdao.ListarVoluntarios(c);
        if(retorno.size() == 0){
            cdao.Voluntariar(c);
            return "acessologado/logado.jsp";
            
        }else{
            return "errovolun.jsp";
        }
        
    }
    
}

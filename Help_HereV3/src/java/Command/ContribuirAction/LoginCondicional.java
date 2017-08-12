package Command.ContribuirAction;

import Command.ICommand;
import DAO.DAOUsuario;
import Model.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCondicional implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {   
        Login login = new Login();
        login.setNome(request.getParameter("txtLogin"));
        login.setSenha(request.getParameter("txtSenha"));
        DAOUsuario daousuario = new DAOUsuario();
        Login usuarioAutenticado = daousuario.autenticaUsuario(login);

        if (usuarioAutenticado != null) {
            HttpSession sessaoUsuario = request.getSession();
            sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);           
            return"acessologado/ajudar.jsp";           
        }else {
            return"Erro.jsp";
        }
    }
}

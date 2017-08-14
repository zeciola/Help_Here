package Command.UsuarioAction;

import Command.*;
import DAO.*;
import Model.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarUsuarioAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //Instanciando Objetos
        Usuario lo = new Usuario();
        
        //DAOs
        DAOUsuario daou = new DAOUsuario();
        
        //Email
        lo.setNome(request.getParameter("email"));
        lo.setSenha(request.getParameter("senha"));
        
        //Seta os valores
        daou.setUsuario(lo);
        
        //Executa o metodo Insert
        daou.Inserir();
        
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
    }
    
    
    
}

package Command.AdminAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOInstituicao;
import DAO.DAOPessoa;
import DAO.DAOUsuario;
import Model.Endereco;
import Model.Instituicao;
import Model.Usuario;
import Model.Pessoa;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListartableAdminAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        DAOPessoa daop = new DAOPessoa();
        DAOInstituicao daoi = new DAOInstituicao();
        DAOEndereco daoe = new DAOEndereco();
        DAOUsuario daou = new DAOUsuario();
        
        ArrayList<Pessoa> p = daop.Listar();
        request.setAttribute("pessoa", p);
        
        ArrayList<Instituicao> i = daoi.Listar();
        request.setAttribute("instituicao", i);
        String url = request.getParameter("url");
        
        ArrayList<Endereco> e = daoe.Listar();
        request.setAttribute("endereco", e);
        
        ArrayList<Usuario> u = daou.Listar();
        request.setAttribute("usuario", u);
       
                
     //return "admin3/production/tables_dynamic.jsp";
       return "admin2/"+url+".jsp";
    }
    
}

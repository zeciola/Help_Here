package Command.AdminAction;

import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOInstituicao;
import DAO.DAOPessoa;
import Model.Endereco;
import Model.Instituicao;
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
        
        ArrayList<Pessoa> p = daop.Listar();
        request.setAttribute("pessoa", p);
        
        ArrayList<Instituicao> i = daoi.Listar2();
        request.setAttribute("instituicao", i);
        String url = request.getParameter("url");
        
        ArrayList<Endereco> e = daoe.Listar();
        request.setAttribute("endereco", e);
                
     //return "admin3/production/tables_dynamic.jsp";
       return "admin2/"+url+".jsp";
    }
    
}

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

public class ListartableAdminAction implements ICommand {

    private DAOPessoa daop = new DAOPessoa();
    private DAOInstituicao daoi = new DAOInstituicao();
    private DAOEndereco daoe = new DAOEndereco();
    private DAOUsuario daou = new DAOUsuario();

    private ArrayList<Pessoa> p = new ArrayList();
    private ArrayList<Endereco> e = new ArrayList();
    private ArrayList<Usuario> u = new ArrayList();

    private Pessoa pe = new Pessoa();
    private Endereco en = new Endereco();
    private Usuario lo = new Usuario(); 

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        daop.Listar();
        request.setAttribute("pessoa", p);

        //Arrumar tbm!!
        ArrayList<Instituicao> i = daoi.Listar();
        request.setAttribute("instituicao", i);
        String url = request.getParameter("url");

        daoe.Listar();
        request.setAttribute("endereco", e);

        daou.Listar();
        request.setAttribute("usuario", u);

        //return "admin3/production/tables_dynamic.jsp";
        return "admin2/" + url + ".jsp";
    }

}

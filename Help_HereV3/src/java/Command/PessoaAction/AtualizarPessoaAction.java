package Command.PessoaAction;
import Command.ICommand;
import DAO.DAOEndereco;
import DAO.DAOPessoa;
import DAO.DAOUsuario;
import Model.Endereco;
import Model.Login;
import Model.PerfilDeAcesso;
import Model.Pessoa;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public  class AtualizarPessoaAction implements ICommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Instanciando Objetos
        Endereco en = new Endereco();
        Pessoa pe = new Pessoa();
        Login lo = new Login();
        
        //DAOs

        String Email = null;
        String Senha = null;
        
        //Resgatar sessão
        
        HttpSession sessoaUsuario =((HttpServletRequest)request).getSession();
        Login usuarioLogado = (Login)sessoaUsuario.getAttribute("usuarioAutenticado");
        
        Email = usuarioLogado.getNome();
        Senha = usuarioLogado.getSenha();
        
        //Usuário
        DAOUsuario daou = new DAOUsuario();
        
        //Endereco de pessoa
        
        en.setNomelogradouro(request.getParameter("nomelogradouro"));
        en.setNumeroen(Integer.parseInt(request.getParameter("numeroen")));
        en.setMunicipio(request.getParameter("municipio"));
        en.setEstado(request.getParameter("estado"));
        en.setBairro(request.getParameter("bairro"));
        en.setCep(request.getParameter("cep"));
        en.setPais(request.getParameter("pais"));
        

        pe.setNome(request.getParameter("nome"));
        pe.setSobrenome(request.getParameter("sobrenome"));
        pe.setCpf(request.getParameter("cpf"));
        pe.setRg(request.getParameter("rg"));

        //pe.setDatanascimento(ConvertData.converteStringParaDate(request.getParameter("datanascimento")));
        pe.setDatanascimento("datanascimento");
        
        
        pe.setEmail(request.getParameter("email"));
        //Id Endereço foreign key
        
        pe.setTelefone(request.getParameter("telefone"));
        pe.setCelular(request.getParameter("celular"));
        pe.setSexo(request.getParameter("sexo"));
        
        lo.setPe(pe);
        lo.setEn(en);
        daou.setUsuario(lo);
        daou.setPessoa(pe);
        daou.setEndereco(en);
        
        daou.Atualizar(Email, Senha);
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
    }
    
}

package Command.PessoaAction;
import Command.ICommand;
import DAO.*;
import Model.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public  class AtualizarPessoaAction implements ICommand{
    
    private final Endereco en = new Endereco();
    private final Pessoa pe = new Pessoa();
    private final Usuario lo = new Usuario();
    //DAOs
    private final DAOUsuario daou = new DAOUsuario();
    private final DAOEndereco daoen = new DAOEndereco();
    private final DAOPessoa daope = new DAOPessoa();
    
    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Instanciando Objetos
        
        String Email = null;
        String Senha = null;
        
        //Resgatar sessão
        
        HttpSession sessoaUsuario =((HttpServletRequest)request).getSession();
        Usuario usuarioLogado = (Usuario)sessoaUsuario.getAttribute("usuarioAutenticado");
        
        Email = usuarioLogado.getNome();
        Senha = usuarioLogado.getSenha();
        
        //Usuario
        lo.setNome(request.getParameter("email"));
        lo.setSenha(request.getParameter("senha"));
        
        lo.setPe(pe);
        lo.setEn(en);
        
        daou.Atualizar(Email, Senha, lo);
        
        
        
        //Endereco de pessoa
        
        en.setNomelogradouro(request.getParameter("nomelogradouro"));
        en.setNumeroen(Integer.parseInt(request.getParameter("numeroen")));
        en.setMunicipio(request.getParameter("municipio"));
        en.setEstado(request.getParameter("estado"));
        en.setBairro(request.getParameter("bairro"));
        en.setCep(request.getParameter("cep"));
        en.setPais(request.getParameter("pais"));
        
        pe.setEn(en);
        
        daoen.Atualizar(Email, Senha, en);
        
        
        pe.setNome(request.getParameter("nome"));
        pe.setSobrenome(request.getParameter("sobrenome"));
        pe.setCpf(request.getParameter("cpf"));
        pe.setRg(request.getParameter("rg"));

        //pe.setDatanascimento(ConvertData.converteStringParaDate(request.getParameter("datanascimento")));
        pe.setDatanascimento(request.getParameter("datanascimento"));
        
        
        pe.setEmail(request.getParameter("email"));
        //Id Endereço foreign key
        
        pe.setTelefone(request.getParameter("telefone"));
        pe.setCelular(request.getParameter("celular"));
        pe.setSexo(request.getParameter("sexo"));
        
        en.setPe(pe);
        
        daope.Atualizar(pe);
        
        //Redirecionar para pagina de !!!perfil!!! de usuário com o listar dos valores colocados acima
        return "/sucesso.jsp";
    }
    
}

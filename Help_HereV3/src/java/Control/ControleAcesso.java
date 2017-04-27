package Control;


import DAO.DAOInstituicao;
import DAO.DAOPessoa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PerfilDeAcesso;
import Model.Login;
import DAO.DAOUsuario;
import Model.Instituicao;
import Model.Pessoa;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class ControleAcesso extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Entrar")) {
                Login login = new Login();
                login.setNome(request.getParameter("txtLogin"));
                login.setSenha(request.getParameter("txtSenha"));

                DAOUsuario daousuario = new DAOUsuario();
                Login usuarioAutenticado = daousuario.autenticaUsuario(login);

                if (usuarioAutenticado != null) {

                    //cria uma sessao para o usuario
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    //redireciona para a pagina princiapal
                    response.sendRedirect("acessologado/logado.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }

            } else //se o usuario existe no banco de dados
            if (acao.equals("AlteraPe")) {
                Login lo = new Login();
                lo.setNome(request.getParameter("txtLogin"));
                lo.setSenha(request.getParameter("txtSenha"));

                DAOUsuario daous = new DAOUsuario();

                //Login loginAutenticadoPe = new Login();
                Login loginAutenticado = daous.autenticaPessoa(lo);
                if (loginAutenticado != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("usuarioAutenticado", loginAutenticado);
                    //redireciona para o Alterar Pessoa
                    response.sendRedirect("AlterarPessoa.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("RemovePe")) {
                Login lo = new Login();
                lo.setNome(request.getParameter("txtLogin"));
                lo.setSenha(request.getParameter("txtSenha"));

                DAOUsuario daous = new DAOUsuario();

                //Login loginAutenticadoPe = new Login();
                Login loginAutenticado = daous.autenticaUsuario(lo);
                if (loginAutenticado != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("usuarioAutenticado", loginAutenticado);
                    //redireciona para o Alterar Pessoa
                    response.sendRedirect("AlterarPessoa.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            }

            if (acao.equals("Altera")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("InstAutenticado", InstituicaoAutenticada);
                    
                   response.sendRedirect("AlterarInstituicao.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("Remove")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("usuarioAutenticado", InstituicaoAutenticada);
                    //redireciona para a pagina princiapal
                    response.sendRedirect("ConfirmarExclusao.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            }else if (acao.equals("CriarEvento")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("EventoAutorizado", InstituicaoAutenticada);
                    
                   response.sendRedirect("CriarEventoInst.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            }
            if (acao.equals("Sair")) {
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.removeAttribute("usuarioAutenticado");
                response.sendRedirect("index.html");

            }
        } catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

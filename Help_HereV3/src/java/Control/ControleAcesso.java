package Control;

import DAO.DAOEndereco;
import DAO.DAOEvento;
import DAO.DAOInstituicao;
import DAO.DAOPessoa;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.PerfilDeAcesso;
import Model.Usuario;
import DAO.DAOUsuario;
import Model.Endereco;
import Model.Evento;
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
                Usuario login = new Usuario();
                login.setNome(request.getParameter("txtLogin"));
                login.setSenha(request.getParameter("txtSenha"));
                
                DAOUsuario daousuario = new DAOUsuario();
                Usuario usuarioAutenticado = daousuario.autenticaUsuario(login);

                DAOPessoa pdao = new DAOPessoa();
                int id = usuarioAutenticado.getPe().getId();
                Pessoa p = pdao.ConsultarId(usuarioAutenticado);
                                
                p.setEn(pdao.ConsultarEndPessoa(p));
                
                usuarioAutenticado.setPe(p);

                if (usuarioAutenticado != null) {
                    //cria uma sessao para o usuario
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    //redireciona para a pagina princiapal
                    if (usuarioAutenticado != null && usuarioAutenticado.getPerfil().equals(PerfilDeAcesso.administrador)) {
                        response.sendRedirect("admin2/index.html");
                    } else {
                        String recuperado = request.getParameter("txtid");
                        if (recuperado == null) {
                            response.sendRedirect("acessologado/logado.jsp");
                        } else {
                            Evento eve = new Evento();
                            Evento ev = new Evento();
                            ArrayList<Endereco> end = new ArrayList();
                            ArrayList<Instituicao> inst = new ArrayList();
                            DAOEvento idao = new DAOEvento();

                            Integer idev = Integer.parseInt(request.getParameter("txtid"));
                            ev.setIdEvento(idev);
                            //CONSULTAR EVENTO
                            eve = idao.Consultar1(ev);
                            end = idao.EventoEndereco(ev);
                            eve.setEnds(end);
                            inst = idao.InstituicaoEvento(ev);
                            
                            sessaoUsuario.setAttribute("evento", eve);
                            sessaoUsuario.setAttribute("resp", inst);
                            
                            response.sendRedirect("acessologado/ajudemais.jsp");
                        }
                    }
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/Erro.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }

            } 
            
            
            else //se o usuario existe no banco de dados
            if (acao.equals("Altera")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("InstAutenticado", InstituicaoAutenticada);

                    response.sendRedirect("acessologado/AlterarInstituicao.jsp");
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
                    sessaoInst.setAttribute("InstAutenticado", InstituicaoAutenticada);
                    //redireciona para a pagina princiapal
                    response.sendRedirect("acessologado/ExcluirInstituicao.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("EntrarEVPessoa")) {
                Usuario login = new Usuario();
                login.setNome(request.getParameter("txtLogin"));
                login.setSenha(request.getParameter("txtSenha"));

                DAOUsuario daousuario = new DAOUsuario();
                Usuario usuarioAutenticado = daousuario.autenticaUsuario(login);

                if (usuarioAutenticado != null) {
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    //redireciona para a pagina princiapal
                    response.sendRedirect("acessologado/EventoPessoa.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }

            } else if (acao.equals("EntrarEV")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("instAutenticado", InstituicaoAutenticada);
                    //redireciona para a pagina princiapal
                    String var = request.getParameter("var");
                    if(var == null){
                        response.sendRedirect("acessologado/Evento.jsp");    
                    }else{
                        response.sendRedirect("acessologado/PerfilEmpresa.jsp");
                    }
                    
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }

            } else if (acao.equals("ExcluirEV")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("usuarioAutenticado", InstituicaoAutenticada);
                    //redireciona para a pagina princiapal
                    response.sendRedirect("ConfirmarExclusaoEV.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            } else if (acao.equals("AlterarEV")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();

                    sessaoInst.setAttribute("AlterarEVautorizado", InstituicaoAutenticada);
                    //redireciona para a pagina princiapal
                    response.sendRedirect("ConfirmarAlteracaoEV.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            }
            
             else if (acao.equals("CriarEvento")) {
                Instituicao inst = new Instituicao();
                inst.setCnpj(request.getParameter("txtcnpj"));
                inst.setSenha(request.getParameter("txtSenha"));

                DAOInstituicao daoinst = new DAOInstituicao();
                Instituicao InstituicaoAutenticada = daoinst.autenticaInstituicao(inst);

                if (InstituicaoAutenticada != null) {
                    HttpSession sessaoInst = request.getSession();
                    sessaoInst.setAttribute("EventoAutorizado", InstituicaoAutenticada);

                    response.sendRedirect("acessologado/CriarEventoInstituicao.jsp");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            }
            
             else if (acao.equals("CriarEvPessoa")) {
                Usuario login = new Usuario();
                login.setId(Integer.parseInt(request.getParameter("txtID")));
                

                DAOUsuario daousuario = new DAOUsuario();
                Usuario usuarioAutenticado = daousuario.autenticaID(login);

                if (usuarioAutenticado != null) {
                    HttpSession sessaoUsuario = request.getSession();
                    sessaoUsuario.setAttribute("usuarioAutenticado", usuarioAutenticado);
                    //redireciona para a pagina princiapal
                    request.getRequestDispatcher("/ControlePessoa?acao=Consultar&URL=ok").forward(request, response);
                   //response.sendRedirect("/ControlePessoa?acao=Consultar&URL=ok");
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/cnpjInvalido.jsp");
                    request.setAttribute("msg", "Login ou Senha Incorreto!");
                    rd.forward(request, response);
                }
            }
            if (acao.equals("Sair")) {
                HttpSession sessaoUsuario = request.getSession();
                sessaoUsuario.removeAttribute("usuarioAutenticado");
                response.sendRedirect("index.jsp");

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

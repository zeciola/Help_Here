package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Cadastro_005fUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Area Restrita</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Acesso Restrito aos Administradores</h1>\r\n");
      out.write("         <h2>Cadastrar novo usuário</h2>\r\n");
      out.write("        \r\n");
      out.write("         ");

             String msg = (String) request.getAttribute("msg");
             if (msg != null) {
         
      out.write("\r\n");
      out.write("         <font color=\"blue\">");
      out.print(msg );
      out.write("</font>\r\n");
      out.write("         ");
}
      out.write("\r\n");
      out.write("         <form action=\"ControleUsuario\" method=\"POST\"></form>\r\n");
      out.write("                Login: <input type=\"text\" name=\"txtLogin\"><br/>\r\n");
      out.write("                Senha: <input type=\"password\" name=\"txtSenha\"><br/>\r\n");
      out.write("                Perfil: <select name=\"optPerfil\"> \r\n");
      out.write("                    <option>COMUM</option>\r\n");
      out.write("                    <option>ADMINISTRADOR</option> \r\n");
      out.write("                </select><br/>\r\n");
      out.write("                <input type=\"submit\" value=\"Cadastrar\" name=\"acao\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <a href=\"../Principal.jsp\"> Pagina Principal</a> \r\n");
      out.write("             \r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

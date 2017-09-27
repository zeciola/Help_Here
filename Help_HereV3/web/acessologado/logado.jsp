<%@page import="Model.Usuario"%>
<%@page import="Model.Feeds"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- CSS Style Table-->
        <link href="${pageContext.request.contextPath}/css/logado.css" rel="stylesheet">

        <!-- JavaStript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <header>
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Help Here</a>
                    </div>

                    <ul class="nav navbar-nav navbar-left">
                        <!-- Dropdown submenu -->
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pessoa
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/email.jsp">Consultar Pessoa</a></li>
                                <li><a href="${pageContext.request.contextPath}/AlterarPessoa.jsp">Alterar Pessoa</a></li>
                                <li><a href="${pageContext.request.contextPath}/emailSenha.jsp">Deletar Pessoa</a></li>
                            </ul>
                        </li>

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Instituição
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/CadastroInstituicao.jsp">Cadastrar Instituição</a></li>
                                <li><a href="ConsultarInstituicao.jsp">Consultar Instituição</a></li>
                                <li><a href="${pageContext.request.contextPath}/CNPJsenha.jsp">Alterar Instituição</a></li>
                                <li><a href="${pageContext.request.contextPath}/CNPJsenha.jsp?url=ok">Deletar Instituição</a></li>
                            </ul>
                        </li>

                        <li><a href="${pageContext.request.contextPath}/tipoAcesso.jsp">Eventos</a></li>
                        <li><a href="${pageContext.request.contextPath}/acessologado/perfil.jsp">Meu Perfil</a></li>                    
                    </ul>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="index.jsp">Home</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/ControleAcesso?acao=Sair">Sair</a>
                            </li>
                        </ul>
                    </div>

                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>
        </header>    

        <figure class="figure">
            <img src="holder.js/400x300" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
            <figcaption class="figure-caption">A caption for the above image.</figcaption>
        </figure>
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");
            if (usuario != null) {
        %>
        <h1>Bem vindo 
            <%= usuario.getNome()%>! </h1>
        <h2>Nome<%= usuario.getPe().getNome()%> </h2>
        <h2><%= usuario.getPe().getSobrenome()%> </h2>
        <%}%>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/email.jsp">Consultar Pessoa</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/AlterarPessoa.jsp">Alterar Pessoa Esse!</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/emailSenha.jsp">Deletar Pessoa</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/ControlePessoa?acao=Listar">Listar Pessoa</a>
            </li>
        </ul>
        <h1> Aqui vai o feeds </h1>

        <% ArrayList<Feeds> Lista = (ArrayList<Feeds>) request.getAttribute("feed");
            if (Lista == null) {
                request.getRequestDispatcher("/ControleFeed?acao=Listar&iduser=" + usuario.getId()).forward(request, response);
            }%>
        <%for (Feeds e : Lista) {%>
        <div id="feed">
            Conheça o Evento
            <br><br>
<<<<<<< Updated upstream
            <%=e.getE().getNome()%><br> A partir do dia:
            <%=e.getE().getDataInicio()%> ate:<br>
            <%=e.getE().getDataFim() %><br>
            <b>link para consultar o evento diretamente</b>
=======
            <%=e.getNomeEvento()%><br> A partir do dia:
            <%=e.getDatainiev()%> ate:<br>
            <%=e.getDatafimev()%><br>
             <a href="../ControleEvento?acao=Consultar&url=1&txtnome=<%=e.getNomeEvento()%>">Informações Completas</a>
>>>>>>> Stashed changes
        </div>
        <%}%>
    </body>
</html>
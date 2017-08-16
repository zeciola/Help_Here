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
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- CSS Style Table-->
        <link href="../css/logado.css" rel="stylesheet">

        <!-- JavaStript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>

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
                    <a class="navbar-brand" href="../index.jsp">Help Here</a>
                </div>

                <ul class="nav navbar-nav navbar-left">

                    <!-- Dropdown submenu -->

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pessoa
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="../email.jsp">Consultar Pessoa</a></li>
                            <li><a href="../AlterarPessoa.jsp">Alterar Pessoa</a></li>
                            <li><a href="../emailSenha.jsp">Deletar Pessoa</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Instituição
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="../CadastroInstituicao.jsp">Cadastrar Instituição</a></li>
                            <li><a href="ConsultarInstituicao.jsp">Consultar Instituição</a></li>
                            <li><a href="../CNPJsenha.jsp">Alterar Instituição</a></li>
                            <li><a href="../CNPJsenha.jsp">Deletar Instituição</a></li>
                        </ul>
                    </li>


                    <li><a href="../tipoAcesso.jsp">Eventos</a></li>

                    <li><a href="../admin/indexLogado.jsp">Admin</a></li>

                </ul>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="index.jsp">Home</a>
                        </li>
                        <li>
                            <a href="../ControleAcesso?acao=Sair">Sair</a>
                        </li>

                    </ul>
                </div>


                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

    </header>

    <body>

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
                <a href="../email.jsp">Consultar Pessoa</a>
            </li>
            <li>
                <a href="../AlterarPessoa.jsp">Alterar Pessoa Esse!</a>
            </li>
            <li>
                <a href="../emailSenha.jsp">Deletar Pessoa</a>
            </li>
            <li>
                <a href="../ControlePessoa?acao=Listar">Listar Pessoa</a>
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
            <%=e.getNomeEvento()%><br> A partir do dia:
            <%=e.getDatainiev()%> ate:
            <%=e.getDatafimev()%>
            <b>aqui poderia ser um link para consultar o evento diretamente</b>
        </div>
        <%}%>
    </body>

</html>
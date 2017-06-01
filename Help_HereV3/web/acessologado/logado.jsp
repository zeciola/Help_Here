<%@page import="Model.Feeds"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Login"%>
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
                    <a class="navbar-brand" href="index.html">Help Here</a>
                </div>

                <ul class="nav navbar-nav navbar-left">

                    <!-- Dropdown submenu -->

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Pessoa
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Page 1-1</a></li>
                            <li><a href="#">Page 1-2</a></li>
                            <li><a href="#">Page 1-3</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Instituição
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Page 1-1</a></li>
                            <li><a href="#">Page 1-2</a></li>
                            <li><a href="#">Page 1-3</a></li>
                        </ul>
                    </li>


                    <li><a href="../Eventos.jsp">Eventos</a></li>

                    <li><a href="../admin/indexLogado.jsp">Admin</a></li>

                </ul>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="index.html">Home</a>
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
        <h1>Bem Vindo</h1>

        <a href="../ControleAcesso?acao=Sair">Logoff</a>
        <a href="../admin/indexLogado.jsp">admin</a>
        <a href="../Eventos.jsp">Eventos</a>
        <h2>Cadastrar</h2>
        <ul>
            <li>
                <a href="../CadastroInstituicao.jsp">Cadastrar Instituição</a>
            </li>
            <li><h2>Consultar</h2></li>
            <li>
                <a href="../CNPJ.jsp">Consultar Instituição</a>
            </li>

            <li>
                <a href="../email.jsp">Consultar Pessoa</a>
            </li>
        </ul>
        <h2>Alterar</h2>
        <ul>
            <li>
                <a href="../CNPJsenha.jsp">Alterar Instituição</a>
            </li>
            <li>
                <a href="../emailSenha.jsp">Alterar Pessoa</a>
            </li>

            <li>
                <a href="../AlterarPessoa.jsp">Alterar Pessoa Esse!</a>
            </li>
            <li><h2>Deletar</h2></li>
            <li>
                <a href="../CNPJsenha.jsp">Deletar Instituição</a>
                <br/>
                <a href="../emailSenha.jsp">Deletar Pessoa</a>
            </li>


            <li>
        </ul>

        <h2>Listar Instituição</h2>
        <form action="../ControleInstituicao" method="post">
            <input type="submit" name="acao" value="Listar"><br>
        </form>
        <h2>Listar Pessoa</h2>
        <form action="../ControlePessoa" method="post">
            <input type="submit" name="acao" value="Listar"><br>
        </form>



        
        <%
            Login usuario = (Login) session.getAttribute("usuarioAutenticado");
            if (usuario != null) {
        %> 
        <h1>Bem vindo Usuario, <%= usuario.getNome()%>! </h1>
        <h2><%= usuario.getId()%></h2>
        <%}%>
    
    
        <h1> Aqui vai o feeds </h1>
        
        <% ArrayList<Feeds> Lista = (ArrayList<Feeds>) request.getAttribute("feed");
            if (Lista == null) {
                request.getRequestDispatcher("/ControleFeed?acao=Listar&iduser=" + usuario.getId()).forward(request, response);
    }%>
        <%for (Feeds e : Lista) {%>  
        <div id="feed">
            Conheça o Evento <%=e.getNomeEvento()%><br>
            A partir do dia: <%=e.getDatainiev()%> ate: <%=e.getDatafimev()%>
            <b>aqui poderia ser um link para consultar o evento diretamente</b>
            
        </div><%}%>
            
        
        


    </body>
</html>

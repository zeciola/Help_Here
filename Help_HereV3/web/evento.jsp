<%@page import="Model.Usuario"%>
<%@page import="Model.Evento"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- CSS Style Table-->
        <link href="css/logado.css" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css2/ocultar.css">

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
                        <a class="navbar-brand" href="index.jsp">Help Here</a>
                    </div>

                    <ul class="nav navbar-nav navbar-left">
                        <!-- Dropdown submenu -->
                    </ul>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="index.jsp">Home</a>
                            </li>
                            <li>
                                <a href="../ControleAcesso?acao=Sair" style="display : none">Sair</a>
                                <a href="login.jsp">Login</a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>
        </header>

        <%
            Evento Lista = (Evento) request.getAttribute("evento");
        %>

        <figure class="figure">
            <h2>Evento <%= Lista.getNome()%></h2>    
            <figcaption class="figure-caption"><img src="img/defaut.jpg"></figcaption>
        </figure>

        <p>Descrição do evento</p>
        <p>Tipo:
            <span id="tipo">
                <%= Lista.getTipoEvento()%>
            </span>
        </p>

        <p>Contéudo <%= Lista.getDescricao()%></p>

        <div id="doar" class= "paraExibicao">
            Contador da campanha
        </div>

        <div id="volun" class="paraExibicao">
            Contador voluntarios 
        </div>

        <canvas class="loader2"></canvas>

        <button type="button" onclick="Mudarestado('minhaDiv')">Click Para Ajudar</button>
        <br>
        
        <div id="minhaDiv" style="display: none">
            <form class="form" method="post" action="ControleAcesso">
                <input type="text" name="txtid" value="<%=Lista.getIdEvento()%>" style="display: none">
                <input type="text" name="txtLogin" placeholder="Usuario">
                <input type="password" name="txtSenha" placeholder="Senha">
                <button type="submit" name="acao" value="Entrar">Entrar</button>
                <div>
                    <ul>
                        <li><a href="CadastroPessoaForm.jsp" class="senha-link">Cadastrar-se</a></li>
                        <li><a href="#" class="senha-link">Esqueceu a senha?</a></li>
                    </ul>
                </div>
            </form>
        </div>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>    
        <script src="js2/jquery.classyloader.min.js"></script>
        <script src="js2/loader.js"></script>   
        <script src="js2/contribuicao.js"></script>
    </body>   
</html>
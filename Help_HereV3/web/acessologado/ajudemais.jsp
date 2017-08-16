<%@page import="Model.Instituicao"%>
<%@page import="Model.Evento"%>
<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina ajude mais</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/logado.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css2/ocultar.css">

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
                        <a class="navbar-brand" href="../acessologado/logado.jsp">Seu Pérfil</a>
                    </div>
                    <ul class="nav navbar-nav navbar-left">
                        <!-- Dropdown submenu -->
                    </ul>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="ControleAcesso?acao=Sair">Sair</a>   
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>
        </header>
        <%
            Usuario user = (Usuario) request.getAttribute("usuarioAutenticado");
            Evento ev = (Evento) request.getAttribute("evento");
            //Instituicao inst = (Instituicao) request.getAttribute("resp");
        %>
        <h3>Confime seus dados senhor <%=user.getNome()%> no evento<%=ev.getNome()%></h3>
        <h2></h2>
        <% if (ev.getTipoEvento() == "Voluntariado") {%>
        <h1>Voluntariado</h1>
        <form method="post" action=""> 
            Nome Completo: <input type="Text" value=""><br>
            Quantidade voluntarios:
            <select>
                <option></option>
            </select>
            <button type="submit" name="acao" value="Login">Entrar</button>
        </form>

        <%} else {%>
        <h1>Doação</h1>
        <form method="post" action=""> 
            Nome Completo: <input type="Text" value=""><br>
            RG:
            CPF:
            Data Nascimento:
            Valor:
            <select>
                <option></option>
            </select>
            <button type="submit" name="acao" value="Login">Entrar</button>
        </form>
        <%}%>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

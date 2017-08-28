
<%@page import="Model.Evento"%>
<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina ajude mais</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/logado.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css2/ocultar.css">
    </head>

    <body>
        <%
            Usuario user = (Usuario) session.getAttribute("usuarioAutenticado");
            Evento ev = (Evento) session.getAttribute("evento");
            
        //Instituicao inst = (Instituicao) request.getAttribute("resp");
        %>
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
                        <a class="navbar-brand" href="logado.jsp">Seu Pérfil</a>
                    </div>
                    <ul class="nav navbar-nav navbar-left">
                        <!-- Dropdown submenu -->
                    </ul>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
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

        <h3>Confirme seus dados senhor</h3>
        <% if (ev.getTipoEvento().equals("Voluntariado")) {%>
        <h1>Voluntariado</h1>
        <p>Confirme seu dados para se voluntariar no Evento: <%=ev.getNome()%></p>
        <form method="post" action="${pageContext.request.contextPath}/ControleContribuir"> 
            Nome: <input type="Text" value="<%=user.getPe().getNome()%>"><br>
            Sobrenome: <input type="Text" value="<%=user.getPe().getSexo()%>"><br>
            CPF: <input type="Text" value="<%=user.getPe().getCpf()%>"><br>
            RG: <input type="Text" value="<%=user.getPe().getRg()%>"><br>
            Data Nascimento: <input type="Text" value="<%=user.getPe().getDatanascimento()%>"><br>
            Sexo: <input type="Text" value="<%=user.getPe().getSexo()%>"><br>
            Telefone: <input type="Text" value="<%=user.getPe().getTelefone()%>"><br>
            Celular: <input type="Text" value="<%=user.getPe().getCelular()%>"><br>
            E-mail: <input type="Text" value="<%=user.getPe().getEmail()%>"><br>
            
            <button type="submit" name="acao" value="Volun">Participar</button>
        </form>

        <%} else {%>
        <h1>Doação</h1>
        <form method="post" action="${pageContext.request.contextPath}/ControleContribuir"> 
            Nome: <input type="Text" value="<%=user.getPe().getNome()%>"><br>
            Sobrenome: <input type="Text" value="<%=user.getPe().getSexo()%>"><br>
            CPF: <input type="Text" value="<%=user.getPe().getCpf()%>"><br>
            RG: <input type="Text" value="<%=user.getPe().getRg()%>"><br>
            Data Nascimento: <input type="Text" value="<%=user.getPe().getDatanascimento()%>"><br>
            Sexo: <input type="Text" value="<%=user.getPe().getSexo()%>"><br>
            Telefone: <input type="Text" value="<%=user.getPe().getTelefone()%>"><br>
            Celular: <input type="Text" value="<%=user.getPe().getCelular()%>"><br>
            E-mail: <input type="Text" value="<%=user.getPe().getEmail()%>"><br>
            Valor:
            <select name="valor">
                <option value="5">R$ 5.00</option>
                <option value="10">R$ 10.00</option>
                <option value="15">R$ 15.00</option>
                <option value="30">R$ 30.00</option>
                <option value="45">R$ 45.00</option>
                <option value="60">R$ 60.00</option>
                <option value="75">R$ 75.00</option>
                <option value="100">R$ 100.00</option>
            </select>
            <button type="submit" name="acao" value="Doar">Ajudar</button>
        </form>
        <%}%>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

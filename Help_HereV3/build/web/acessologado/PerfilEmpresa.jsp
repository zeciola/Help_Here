<%@page import="Model.Evento"%>
<%@page import="Model.Certificado"%>
<%@page import="Model.Instituicao"%>
<%@page import="Model.Usuario"%>
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
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/acessologado/logado.jsp">Help Here</a>
                    </div>

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

        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");
            Instituicao ints = (Instituicao) session.getAttribute("instAutenticado");
            if (usuario != null) {
        %>
        <h1>Bem vindo 
            <%= ints.getNome()%>! </h1>
        <h2>Nome: <%= ints.getRazao()%> </h2>
        <h2><%= ints.getCnpj()%> </h2>
        <%}%>
        <br>

        <h1>Veja abaixos certificados que você precisa Liberar</h1>

        <%Certificado Lista = (Certificado) session.getAttribute("itensvalidar");
            if (Lista == null) {
                request.getRequestDispatcher("/ControleCertificado?acao=Busca").forward(request, response);
            }%>
        <%for (Evento e : Lista.getPendentes()) {%>
        <div id="feed">
            <br>
            <h3>Valide os vuntarios dos seu eventos <%=e.getNome()%>?</h3>
            <a href="../ControleCertificado?acao=BuscarP&idEvento=<%=e.getIdEvento()%>" >Validar Certificados</a>    
        </div>
        <%}%>
        <br>
    </body>
</html>
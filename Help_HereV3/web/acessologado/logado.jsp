<%@page import="Model.Evento"%>
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
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/acessologado/logado.jsp">Help Here</a>
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
                        <li><a href="${pageContext.request.contextPath}/acessologado/LoginEmpresa.jsp">Perfil Empresa</a></li>
                        <li><a href="${pageContext.request.contextPath}/acessologado/Certificados.jsp">Meus Certificados</a></li>
                    </ul>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="../index.jsp">Home</a>
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
        <!-- 
                <figure class="figure">
                    <img src="holder.js/400x300" class="figure-img img-fluid rounded" alt="A generic square placeholder image with rounded corners in a figure.">
                    <figcaption class="figure-caption">A caption for the above image.</figcaption>
                </figure>    -->
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");
            if (usuario != null) {
        %>
        <h6 ALIGN="right"> 
            Conta: <%= usuario.getNome()%>
        </h6>

        <h1>Bem vindo, <%= usuario.getPe().getNome()%> !</h1>

        <%}%>

        <%if (usuario.getPe().isPenalisado() == true) {%>
            <h1><font color="red">Ha pendencias de cadastro</font></h1>
            <p>Caso você tenha faltado em um voluntariado ao qual
                você se candidatou envie um e-mail um scan da justificativa 
                para helphere@gmail.com ou use o formulário abaixo</p>
            <form method="post" action="">
                </form>
            
        <%}%>

        <br> <br> 
        <h3 ALIGN="center">Feeds de eventos do seu interesse:</h3> 
        <br> 
        <!-- <div class="row">
        <% /*ArrayList<Evento> ListaEv = (ArrayList<Evento>) session.getAttribute("evento");
            if (ListaEv == null) {
                request.getRequestDispatcher("/ControleEvento?acao=Listar1&url=2").forward(request, response);
                } */%>
        <%/*for (Evento e : ListaEv) {*/%>
        <div class="col-sm-4">
            <img class="img-circle img-responsive img-center" src="img/<%/*=e.getImg()*/%>" alt="">
            <h2><%/*=e.getNome()*/%></h2>
            <p><%/*=e.getDescricao()*/%></p>
            <p><%/*=e.getDataInicio()*?%></p>
            <p><%/*=e.getDataFim()*/%></p>
            <a href="ControleEvento?acao=Consultar1&ID=<%/*=e.getIdEvento()*/%>">Ajude</a>
        </div>
        <%/*}*/%>
    </div>
        -->
        <!-- <h1> Aqui vai o feeds </h1>-->

        <% ArrayList<Feeds> Lista = (ArrayList<Feeds>) session.getAttribute("feed");
            if (Lista == null) {
                request.getRequestDispatcher("/ControleFeed?acao=Listar&iduser=" + usuario.getId()).forward(request, response);
            }%>
        <%for (Feeds e : Lista) {%>
        <div id="feed" class="col-sm-4">
            <br> <br> <br>
            <b>Conheça o Evento</b>
            <br>
            <%=e.getE().getNome()%><br> A partir do dia:
            <%=e.getE().getDataInicio()%> até:<br>
            <%=e.getE().getDataFim()%><br>
            ID: <%=e.getE().getIdEvento()%><br>
            <a href="../ControleEvento?acao=Consultar&url=1&txtIDEV=<%=e.getE().getIdEvento()%>">Informações Completas</a> 
        </div>
        <%}%>
    </body>
</html>
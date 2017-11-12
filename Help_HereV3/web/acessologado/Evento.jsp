<%-- 
    Document   : Evento
    Created on : 27/09/2017, 19:59:38
    Author     : Lucas Puglia
--%>

<%@page import="Model.Instituicao"%>
<%@page import="Model.Evento"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>  
<html>
    <head><link href="${pageContext.request.contextPath}/estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos</title>

        <!-- Bootstrap Core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

        <!-- CSS Style Table-->
        <link href="${pageContext.request.contextPath}/css/styletable.css" rel="stylesheet">
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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html">Help Here</a>
                </div>
                
        <%
            Instituicao instituicao = (Instituicao) session.getAttribute("instAutenticado");
            if (instituicao != null) {
        %>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    
                   
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="${pageContext.request.contextPath}/ControleAcesso?acao=CriarEvento&txtcnpj=<%=instituicao.getCnpj()%>&txtSenha=<%=instituicao.getSenha()%>">Criar</a> </li>
                        <li><a href="${pageContext.request.contextPath}/ConsultaNomeEvento.jsp">Consultar</a></li>
                        <!--<li><a href="ControleAcesso?acao=ExcluirEV&txtcnpj=<%=instituicao.getCnpj()%>&txtSenha=<%=instituicao.getSenha()%>">Excluir</a></li>-->
                        <li><a href="${pageContext.request.contextPath}/ControleEvento?acao=Listar">Listar</a></li>
                        <li><a href="${pageContext.request.contextPath}/ControleEvento?acao=Listar&URL=ok">Meus Eventos</a></li>
                        <li><a href="javascript:window.history.go(-3)">Feeds</a></li>
                        <li><a href="${pageContext.request.contextPath}/ControleAcesso?acao=Sair">Sair</a></li>

                    </ul>
            
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

    </header>
    <body>

        
        <br></br>
        
        <h1 ALIGN="center">Eventos</h1><br></br>

                <div class="row">
                <%
                    //Recupera eventos
                    ArrayList<Evento> listaEvento = (ArrayList<Evento>) request.getAttribute("listaEVdata");
                    if (listaEvento == null) {
                        request.getRequestDispatcher("../ControleEvento?acao=Listar&UR=ok").forward(request, response);
                    }
                %>
                <%
                    for (Evento e : listaEvento) {%>  
                <div class="col-sm-4">
                    <b><h1><%=e.getNome()%></h1></b><br>
                    <b>Descrição:</b><%=e.getDescricao()%><br>
                    <b>Tipo de Evento:</b> <%=e.getTipoEvento()%><br>
                    <b>Dia de Inicio:</b> <%=e.getDataInicio()%><br>
                    <b>Dia de Encerramento:</b> <%=e.getDataFim()%><br>
                    <a href="${pageContext.request.contextPath}/ControleEvento?acao=Consultar&url=1&txtnome=<%=e.getNome()%>">Abrir</a>
                   <!-- <a href="ControleEvento?acao=Remover&url=ok3&txtnomeEV=<%=e.getNome()%>">Excluir</a>
                    <a href="ControleEvento?acao=Atualizar&url=ok2&txtnomeEV=<%=e.getNome()%>">Alterar</a>-->
                 </div>  
                <%}%>
                <%}%>
        </div>
    </body>
</html>

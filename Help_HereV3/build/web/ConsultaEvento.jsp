<%-- 
    Document   : listaEvento
    Created on : 19/05/2017, 20:00:24
    Author     : Lucas Puglia
--%>

<%@page import="Model.Instituicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Model.Evento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOEvento"%>
<html>
    <head><link href="estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar</title>

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- CSS Style Table-->
        <link href="css/styletable.css" rel="stylesheet">
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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/ControleAcesso?acao=Sair">Help Here</a>
                    
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        
                                <li>
                                    <a href="javascript:window.history.go(-2)">Eventos</a>
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
    <body>
        <div class="row-fluid">
            <br></br>
       
            <h1>Resultado da Pesquisa</h1>  <br></br>
        <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >
            <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
            <tr align="center">
                    <td>ID</td>
                    <td>Data Inicio</td>
                    <td>Data Fim</td> 
                    <td>Nome</td>
                    <td>Tipo Evento</td>
                    <td>Descricao </td>
                    <td>Abrir</td>
                  
                </tr>
                <% //recupera a lista do request
                ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("listaEV");
                for(Evento e: listaEvento){  %>  
                <tbody style="background-color: #e6e6e6">
                <tr align="center">
                    <td><%=e.getIdEvento()%></td>
                    <td><%=e.getDataInicio()%></td>
                    <td><%=e.getDataFim()%></td>
                    <td><%=e.getNome()%></td>
                   <td><%=e.getTipoEvento()%></td>
                   <td><%=e.getDescricao()%></td>
                  
                      
                      
                       
                       <td>
                        <a href="ControleEvento?acao=Consultar&url=1&txtIDEV=<%=e.getIdEvento()%>">Informações Completas</a>
                       </td>
                        
                        
                   
                                      
                   
                </tr>
                <%}%>
           
           </table>
                
               
    </body>
</html>

<%-- 
    Document   : listaEventoPessoa
    Created on : 01/09/2017, 22:20:24
    Author     : Lucas Puglia
--%>

<%@page import="Model.Pessoa"%>
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
                    <a class="navbar-brand" href="index.html">Help Here</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        
                                <li>
                                    <a href="javascript:window.history.go(-1)">Voltar</a>
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
            <% //recupera a lista do request
                ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("listaEV");
                ArrayList<Pessoa> p = (ArrayList<Pessoa>)request.getAttribute("confirma");
                            if (p.size() != 0 ) {%>
        <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >
            <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
            <tr align="center">
                    <td>Data Inicio</td>
                    <td>Data Fim</td> 
                    <td>Nome</td>
                    <td>Tipo Evento</td>
                    <td>Descricao </td>
                    <td>Abrir </td>
                    <td> &nbsp Responsavel </td>
                    
                        
            </tr>
                <% //recupera a lista do request
                for(Evento e: listaEvento){  %>  
                <tbody style="background-color: #e6e6e6">
                <tr align="center">
                    <td><%=e.getDataInicio()%></td>
                    <td><%=e.getDataFim()%></td>
                    <td><%=e.getNome()%></td>
                   <td><%=e.getTipoEvento()%></td>
                   <td><%=e.getDescricao()%></td>
                  
                      
                      

                   <td>
                       <a href="ControleEvento?acao=Consultar&url=1&txtnome=<%=e.getNome()%>">Informações Completas</a>
                   </td>
                   <td>
                       <a href="ControleEvento?acao=Remover&url=ok3&txtnomeEV=<%=e.getNome()%>">Excluir</a> &nbsp &nbsp
                       <a href="ControleEvento?acao=Atualizar&url=ok2&txtnomeEV=<%=e.getNome()%>">Alterar</a> <!--Falta ver onde vai chamar o cnpjsenhaevento-->
                   </td>
                   
                       
                        




            </tr>
                <%}%>
                <br/>
           </table>
                 
                  
                  <%}  else if (p.size() == 0 ) {%>
                    </table><br/><br/>
        <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >
            <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
            <tr align="center">
                    <td>Data Inicio</td>
                    <td>Data Fim</td> 
                    <td>Nome</td>
                    <td>Tipo Evento</td>
                    <td>Descricao </td>
                    <td>Abrir</td>
                  
                </tr>
               <% for(Evento e: listaEvento){  %>  
                <tbody style="background-color: #e6e6e6">
                <tr align="center">
                    <td><%=e.getDataInicio()%></td>
                    <td><%=e.getDataFim()%></td>
                    <td><%=e.getNome()%></td>
                   <td><%=e.getTipoEvento()%></td>
                   <td><%=e.getDescricao()%></td>
                  
                      
                      
                       
                       <td>
                        <a href="ControleEvento?acao=Consultar&url=1&txtnome=<%=e.getNome()%>">Informações Completas</a>
                       </td>
                   
                </tr>
                <% } %>
                <br/>
            </table>
               
               <% } %>
           
                
               
    </body>
</html>

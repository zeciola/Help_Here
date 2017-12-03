<%-- 
    Document   : listaEVCompleto
    Created on : 20/05/2017, 14:09:21
    Author     : Lucas Puglia
--%>

<%@page import="Model.Usuario"%>
<%@page import="Model.Pessoa"%>
<%@page import="Model.Endereco"%>
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
        
        <h1>Resultado da Pesquisa</h1> <br /> <br />
        <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >
        <h2>Evento</h2><br /> 
        <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
            <tr align="center">
                    <td>Data Inicio</td>
                    <td>Data Fim</td> 
                    <td>Nome</td>
                    <td>Tipo Evento</td>
                    <td>Descricao </td>
                  
            </tr>
                <% //recupera a lista do request
                ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("listaEV");
                for(Evento e: listaEvento){  %> 
                 <tbody style="background-color: #e6e6e6">
                <tr align="center">
                    <td><%=e.getDataInicio()%></td>
                    <td><%=e.getDataFim()%></td>
                    <td><%=e.getNome()%></td>
                   <td><%=e.getTipoEvento()%></td>
                   <td><%=e.getDescricao()%></td>
                                      
                   
                </tr>
                <%}%>
                <br />
           
        </table><br /><br />
           
        <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >       
        <h2>Endereço</h2><br /> 
        <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
            <tr align="center">
                        <td>Endereco</td>
                        <td>Número</td> 
                        <td>Municipio</td>
                        <td>Estado</td>
                        <td>Bairro</td>
                        <td>CEP</td>
                        <td>Pais</td>
                        
            </tr>
                <% //recupera a lista do request
                ArrayList<Endereco> EnderecoEvento = (ArrayList<Endereco>)request.getAttribute("listaEnd");
                for(Endereco en: EnderecoEvento){  %>  
                <tbody style="background-color: #e6e6e6">
                <tr align="center">
                        <td><%=en.getNomelogradouro()%></td>
                        <td><%=en.getNumeroen()%></td>
                        <td><%=en.getMunicipio()%></td>
                        <td><%=en.getEstado()%></td>
                        <td><%=en.getBairro()%></td>
                        <td><%=en.getCep()%></td>
                        <td><%=en.getPais()%></td>
                        
                        

                    </tr>
                    <%}%>
                    <br/>
                
                <%    
                ArrayList<Instituicao> listaInstituicao = (ArrayList<Instituicao>)request.getAttribute("listaInst");
                ArrayList<Pessoa> listasPessoa = (ArrayList<Pessoa>)request.getAttribute("listaPessoa");
                if (listasPessoa.size() == 0 ) { %>
                </table><br/><br/>
                 <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >                  
                <h2>Instituição Responsavel</h2>
                <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
                <tr align="center">
                    <td>Nome</td>
                    <td>Razao Social</td> 
                    <td>Tipo</td>
                    <td>CNPJ</td>
                    <td>Modalidade </td>
                    <td>E-mail</td>
                    
                </tr>
                <%for(Instituicao e: listaInstituicao){  %>  
                <tbody style="background-color: #e6e6e6">
                <tr align="center">
                    <td><%=e.getNome()%></td>
                    <td><%=e.getRazao()%></td>
                    <td><%=e.getTipo()%></td>
                   <td><%=e.getCnpj()%></td>
                   <td><%=e.getModalidade()%></td>
                   <td><%=e.getEmail()%></td>
                                   
                   
                </tr>
                <%}%>
                <br/>
           </table>
                <% } else { %>
                </table><br/><br/>
                 <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >                  
                <h2>Pessoa Responsavel</h2>
                <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
        
            <tr align="center">
                    <td>Nome</td>
                    <td>Sobrenome</td> 
                    <td>E-mail</td>
                    <td>CPF</td>
                    
                </tr>
                <% //recupera a lista do request
                //ArrayList<Pessoa> listPessoa = (ArrayList<Pessoa>)request.getAttribute("listaPessoa");
                for(Pessoa e: listasPessoa){  %>  
                <tbody style="background-color: #e6e6e6">
                <tr align="center">
                    <td><%=e.getNome()%></td>
                    <td><%=e.getSobrenome()%></td>
                    <td><%=e.getEmail()%></td>
                   <td><%=e.getCpf()%></td>
                                   
                   
                </tr>
                <%}%>
                <br/>
           </table>
                <%}%>
            
               
                
    </body>
</html>
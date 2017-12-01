<%-- 
    Document   : listaInstituicao
    Created on : 03/04/2017, 19:14:15
    Author     : Lucas Puglia
--%>
<%@page import="Model.Instituicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Instituicao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOInstituicao"%>
<!DOCTYPE HTML>
<html>
    <head><link href="estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Instituição</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- CSS Style Table-->
        <link href="css/styletable.css" rel="stylesheet">
    </head>
    
    <body>

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
                        <a href="index.html">Home</a>
                    </li>
                    <li>
                        <a href="logado.jsp">Perfil</a>
                    </li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="row-fluid">

        <h1>Resultado da Pesquisa</h1>  
        <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%" cellpadding="2" >
            <h2>Instituição:</h2>
            <thead class="thead-inverse">
                <tr align="center">
                    <td>Nome</td>
                    <td>Razao Social</td> 
                    <td>Tipo</td>
                    <td>CNPJ</td>
                    <td>Modalidade </td>
                    <td>E-mail</td>
                    <td>CEP</td>
                    <td>Endereco</td> 
                    <td>Numero</td>
                    <td>Bairro</td>
                    <td>Cidade </td>
                    <td>Estado</td>
                    <td>Pais</td>
                    <td>Opções</td>
                </tr>
            </thead>
            <% //recupera a lista do request
                ArrayList<Instituicao> listaInstituicao = (ArrayList<Instituicao>) request.getAttribute("lista");
                for (Instituicao e : listaInstituicao) {%>
            <tbody>
                <tr align="center">
                    <td><%=e.getNome()%></td>
                    <td><%=e.getRazao()%></td>
                    <td><%=e.getTipo()%></td>
                    <td><%=e.getCnpj()%></td>
                    <td><%=e.getModalidade()%></td>
                    <td><%=e.getEmail()%></td>
                    <td><%=e.getEndereco().getCep()%></td>
                    <td><%=e.getEndereco().getNomelogradouro()%></td>
                    <td><%=e.getEndereco().getNumeroen()%></td>
                    <td><%=e.getEndereco().getBairro()%></td>
                    <td><%=e.getEndereco().getMunicipio()%></td>
                    <td><%=e.getEndereco().getEstado()%></td>
                    <td><%=e.getEndereco().getPais()%></td>
                    <td>
                        <a href="CNPJsenha.jsp">Alterar</a>
                        <a href="CNPJsenha.jsp">Excluir</a>
                    </td>                  

                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
</body>
</html>


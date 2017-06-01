<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="DAO.*"%>
<!DOCTYPE html>
<html>
    <head><link href="estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Pessoa</title>

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
                            <a href="index.html">Home</a>
                        </li>
                        <li>
                            <a href="../logado.jsp">Perfil</a>
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

            <h1>Resultado da Pesquisa</h1>

            <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%"  cellpadding="2" >
                <h2>Endereço:</h2>
                <thead style="background-color: rgba(0, 199, 149, 0.73);" class="thead-inverse">
                    <tr align="center">
                        <td>Endereco</td>
                        <td>Número</td> 
                        <td>Municipio</td>
                        <td>Estado</td>
                        <td>Bairro</td>
                        <td>CEP</td>
                        <td>Pais</td>
                        <td>Status</td> 
                        <td>Opções</td>
                    </tr>
                </thead>
                <% //recupera a lista do request
                    ArrayList<Endereco> listaEndereco = (ArrayList<Endereco>) request.getAttribute("ListaEn");
                    for (Endereco en : listaEndereco) {%>  
                <tbody style="background-color: #e6e6e6">
                    <tr align="center">
                        <td><%=en.getNomelogradouro()%></td>
                        <td><%=en.getNumeroen()%></td>
                        <td><%=en.getMunicipio()%></td>
                        <td><%=en.getEstado()%></td>
                        <td><%=en.getBairro()%></td>
                        <td><%=en.getCep()%></td>
                        <td><%=en.getPais()%></td>
                        <td><%=en.isStatus()%></td>
                        <td>
                            <a href="ControlePessoa?acao=Atualizar&iden=<%=en.getIdEndereco()%>">Alterar</a>
                            <a href="ControlePessoa?acao=Deletar&id=<%=en.getIdEndereco()%>">Excluir</a>
                        </td>

                    </tr>
                    <%}%>
                </tbody>

            </table>
            <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%" cellpadding="2" >
                <h2>Pessoa:</h2>
                <thead class="thead-inverse">
                    <tr align="center">
                        <td>Nome</td>
                        <td>Sobrenome</td> 
                        <td>Cpf</td>
                        <td>Rg</td>
                        <td>Penalisado</td>
                        <td>Data de nascimento</td>
                        <td>Email</td>
                        <td>Telefone</td>
                        <td>Celular</td>
                        <td>Sexo</td>
                        <td>Status</td> 
                        <td>Opções</td>
                    </tr>
                </thead>
                <% //recupera a lista do request
                    ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) request.getAttribute("ListaPe");
                    for (Pessoa pe : listaPessoa) {%>  
                <tbody>
                    <tr align="center">
                        <td><%=pe.getNome()%></td>
                        <td><%=pe.getSobrenome()%></td>
                        <td><%=pe.getCpf()%></td>
                        <td><%=pe.getRg()%></td>
                        <td><%=pe.isPenalisado()%></td>
                        <td><%=pe.getDatanascimento()%></td>
                        <td><%=pe.getEmail()%></td>
                        <td><%=pe.getTelefone()%></td>
                        <td><%=pe.getCelular()%></td>
                        <td><%=pe.getSexo()%></td>
                        <td><%=pe.isStatus()%></td>
                        <td>
                            <a href="ControlePessoa?acao=Atualizar&idpe=<%=pe.getId()%>">Alterar</a>
                            <a href="ControlePessoa?acao=Deletar&id=<%=pe.getId()%>">Excluir</a>
                        </td>

                    </tr>
                    <%}%>
                </tbody>

            </table>
            <table class="table table-bordered table-hover table-condensed table-responsive" border="1" width="20%" cellpadding="2" >
                <h2>Usuário:</h2>
                <thead class="thead-inverse">
                    <tr align="center">
                        <td>Nome</td>
                        <td>Status</td> 
                        <td>Opções</td>
                    </tr>
                </thead>
                <% //recupera a lista do request
                    ArrayList<Login> listaLogin = (ArrayList<Login>) request.getAttribute("ListaUs");
                    for (Login lo : listaLogin) {%>
                <tbody>
                    <tr align="center">
                        <td><%=lo.getNome()%></td>
                        <td><%=lo.isStatus()%></td>
                        <td>
                            <a href="ControlePessoa?acao=Atualizar&idlo=<%=lo.getId()%>">Alterar</a>
                            <a href="ControlePessoa?acao=Deletar&id=<%=lo.getId()%>">Excluir</a>
                        </td>

                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
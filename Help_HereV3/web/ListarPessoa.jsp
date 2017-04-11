<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*"%>
<%@page import="java.util.ArrayList" %>
<%@page import="DAO.*"%>

<!DOCTYPE html>
<html>
    <head><link href="estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="corpo">
            <header id="cabecalhop">  <!-- CABEÇALHO DA PAGINA-->
                <header>
                    <a href="index.html"></a>
                </header>
                <nav id="menu">
                    <h1>Menu Principal</h1>
                    <ul>
                        <li><a href="index.html">Home</a></li>
                        <li><a href="CadastroPessoaFrom.jsp">Cadastrar Pessoa</a></li>
                    </ul>
                </nav>
                <h1>Resultado da Pesquisa</h1>
                <br/>
                <h1>Endereço:</h1>
                <table border="1" width="20%" cellpadding="2" >
                    <tr align="center">
                        <td>Endereco</td>
                        <td>Número</td> 
                        <td>Municipio</td>
                        <td>Estado</td>
                        <td>Bairro</td>
                        <td>CEP</td>
                        <td>Estado</td>
                        <td>Pais</td>
                    </tr>
                    <% //recupera a lista do request
                    ArrayList<Endereco> listaEndereco = (ArrayList<Endereco>) request.getAttribute("ListaEn");
                    for (Endereco en : listaEndereco) {%>  
                    <tr align="center">
                        <td><%=en.getNomelogradouro()%></td>
                        <td><%=en.getNumeroen()%></td>
                        <td><%=en.getMunicipio()%></td>
                        <td><%=en.getEstado()%></td>
                        <td><%=en.getBairro()%></td>
                        <td><%=en.getCep()%></td>
                        <td>
                            <a href="ControlePessoa?acao=Atualizar&id=<%=en.getIdEndereco()%>">Alterar</a>
                            <a href="ControlePessoa?acao=Deletar&id=<%=en.getIdEndereco()%>">Excluir</a>
                        </td>

                    </tr>
                    <%}%>

                </table>
                    <br/>
                    <table border="1" width="20%" cellpadding="2" >
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
                    </tr>
                    <% //recupera a lista do request
                    ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) request.getAttribute("ListaPe");
                    for (Pessoa pe : listaPessoa) {%>  
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
                        <td>
                            <a href="ControlePessoa?acao=Atualizar&id=<%=pe.getId()%>">Alterar</a>
                            <a href="ControlePessoa?acao=Deletar&id=<%=pe.getId()%>">Excluir</a>
                        </td>

                    </tr>
                    <%}%>

                </table>
                    <br/>
                    <table border="1" width="20%" cellpadding="2" >
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
                    </tr>
                    <% //recupera a lista do request
                    ArrayList<Login> listaLogin = (ArrayList<Login>) request.getAttribute("ListaUs");
                    for (Login lo : listaLogin) {%>  
                    <tr align="center">
                        <td><%=lo.getNome()%></td>
                        <td><%=lo.getSenha()%></td>
                        <td><%=lo.getPerfil()%></td>
                        <td>
                            <a href="ControlePessoa?acao=Atualizar&id=<%=lo.getId()%>">Alterar</a>
                            <a href="ControlePessoa?acao=Deletar&id=<%=lo.getId()%>">Excluir</a>
                        </td>

                    </tr>
                    <%}%>

                </table>
                </body>
                </html>
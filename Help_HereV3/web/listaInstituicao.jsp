<%-- 
    Document   : listaInstituicao
    Created on : 03/04/2017, 19:14:15
    Author     : Lucas Puglia
--%>
<%@page import="Model.Instituicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Model.Pessoa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOPessoa"%>
<html>
    <head><link href="estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="corpo">
        <header id="cabecalhop">  <!-- CABEÇALHO DA PAGINA-->
			<header>
				<a href="index.jsp"></a>
			</header>
			<nav id="menu">
				<h1>Menu Principal</h1>
				<ul>
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="index.jsp">cadastrar Instituição</a></li>
				</ul>
                        </nav>
        <h1>Lista de Instituições</h1>  
        <table border="1" width="20%" cellpadding="2" >
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
                </tr>
                <% //recupera a lista do request
                ArrayList<Instituicao> listaInstituicao = (ArrayList<Instituicao>)request.getAttribute("lista");
                for(Instituicao e: listaInstituicao){  %>  
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
                   
                </tr>
                <%}%>
           
           </table>
    </body>
</html>


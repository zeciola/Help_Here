<%-- 
    Document   : listaCliente
    Created on : 07/09/2011, 12:30:05
    Author     : Wolley
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Modelo.Pessoa"%>
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
			<div id="login">
				<a href="#" onclick="abrefecha('divum');"></a> 
				<a href="Cadastre-se.html"></a>
					<div id="divum" style="display:none;">
						<form>
							Login:<input type="text" /><br>
							Senha:<input type="password" /><br>
							<input type="submit" value="Login" />
							<input type="reset" value="cancelar" onclick="abrefecha('divum');"/>
						</form>
					</div>
			</div>
			</header>
			<nav id="menu">
				<h1>Menu Principal</h1>
				<ul>
                                <li><a href="formularioEvento.jsp">Evento</a></li>
                                <li><a href="formularioPessoa.jsp">Pessoa</a></li>
                                <li><a href="formularioJuridico.jsp">Juridco</a></li>
				</ul>
                        </nav>
        <h1>Gestão de Clientes</h1>  
        <table border="1" width="20%" cellpadding="2" >
            <tr align="center">
                    <td>Nome</td>
                    <td>CPF</td> 
                    <td>RG</td>
                    <td>Nascimento</td>
                    <td>E-mail</td>
                    <td>Ações</td>
                </tr>
                <% //recupera a lista do request
                ArrayList<Pessoa> listaCliente = (ArrayList<Pessoa>)request.getAttribute("lista");
                for(Pessoa p: listaCliente){  %>  
                <tr align="center">
                    <td><%=p.getNome()%></td>
                    <td><%=p.getCpf()%></td>
                    <td><%=p.getRg()%></td>
                   <td><%=p.getDatanasci()%></td>
                   <td><%=p.getEmail()%></td>
                    <td>
                        <a href="ControlePessoa?acao=Consultar&id=<%=p.getId()%>">Abrir</a>
                        <a href="ControlePessoa?acao=Deletar&id=<%=p.getId()%>">Excluir</a>
                    </td>
                </tr>
                <%}%>
           
           </table>
    </body>
</html>


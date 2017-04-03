<%-- 
    Document   : listaCliente
    Created on : 07/09/2011, 12:30:05
    Author     : Wolley
--%>


<%@page import="Modelo.Evento"%>
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
                    <td>Decrição</td> 
                    <td>Data de Cadastro</td>
                    <td>Data de Inicio</td>
                    <td>Data de Fim </td>
                    <td>Ações</td>
                </tr>
                <% //recupera a lista do request
                ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("lista");
                for(Evento e: listaEvento){  %>  
                <tr align="center">
                    <td><%=e.getNome()%></td>
                    <td><%=e.getDescricao()%></td>
                    <td><%=e.getDataCad()%></td>
                   <td><%=e.getInicio()%></td>
                   <td><%=e.getDataFim()%></td>
                   <td>
                        <a href="ControleEvento?acao=Consultar&id=<%=e.getId()%>">Abrir</a>
                        <a href="ControleEvento?acao=Deletar&id=<%=e.getId()%>">Excluir</a>
                    </td>
                </tr>
                <%}%>
           
           </table>
    </body>
</html>


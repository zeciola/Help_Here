<%-- 
    Document   : INDEX
    Created on : 19/11/2016, 17:23:23
    Author     : Diego
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="formularioEvento.jsp">Evento</a></li>
                                <li><a href="formularioPessoa.jsp">Pessoa</a></li>
                                <li><a href="formularioJuridico.jsp">Juridco</a></li>
				</ul>
                        </nav>
         <%
            //Recupera veiculos
             ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("lista");
            if(listaEvento == null) {
                request.getRequestDispatcher("/ControleEvento?acao=Listar").forward(request, response);
            }
        %>
        <%          
        for(Evento e: listaEvento){  %>  
        <article id="materias">
            <h1><%=e.getNome()%></h1><br>
            <%=e.getDescricao()%><br>
           <b>Dia de Cadastro:</b> <%=e.getDataCad()%><br>
           <b>Dia de Inicio:</b> <%=e.getInicio()%><br>
           <b>Dia de Encerramento:</b> <%=e.getDataFim()%><br>
            <a href="ControleEvento?acao=Consultar&id=<%=e.getId()%>">Abrir</a>
            <a href="ControleEvento?acao=Deletar&id=<%=e.getId()%>">Excluir</a>
        </article>
         <%}%>
        </div>
    </body>
</html>

<%-- 
    Document   : Eventos
    Created on : 24/04/2017, 15:01:06
    Author     : Lucas Puglia
--%>

<%@page import="Model.Evento"%>
<%@page import="java.util.ArrayList"%>
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
            <h1>Eventos</h1>
			<nav id="menu">
				
				<ul>
                                <li><a href="CNPJsenhaEvento.jsp">Criar</a></li>
                                <li><a href="ConsultaNomeEvento.jsp">Consultar</a></li>
                                <li><a href="CNPJsenhaEvento.jsp">Excluir</a></li>
                                <li><a href="ControleEvento?acao=Listar">Listar</a></li>
                                <li><a href="ControleEvento?acao=Listar">Alterar</a></li>
                                <li><a href="ControleAcesso?acao=Sair">Sair</a></li>
           
				</ul>
                        </nav>
         <%
            //Recupera eventos
             ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("listaEVdata");
            if(listaEvento == null) {
                request.getRequestDispatcher("/ControleEvento?acao=Listar&UR=ok").forward(request, response);
            }
        %>
        <%          
        for(Evento e: listaEvento){  %>  
        <article id="materias">
            <b><h1><%=e.getNome()%></h1></b><br>
           <b>Descrição:</b><%=e.getDescricao()%><br>
           <b>Tipo de Evento:</b> <%=e.getTipoEvento()%><br>
           <b>Dia de Inicio:</b> <%=e.getDataInicio()%><br>
           <b>Dia de Encerramento:</b> <%=e.getDataFim()%><br>
            <a href="ControleEvento?acao=Consultar&url=1&txtnome=<%=e.getNome()%>">Abrir</a>
            <a href="ControleEvento?acao=Remover&url=ok3&txtnomeEV=<%=e.getNome()%>">Excluir</a>
            <a href="ControleEvento?acao=Atualizar&url=ok2&txtnomeEV=<%=e.getNome()%>">Alterar</a>
        </article>
         <%}%>
        </div>
    </body>
</html>

<%-- 
    Document   : sucesso
    Created on : 08/11/2016, 10:30:02
    Author     : Diego
--%>

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
                                <li><a href="formularioEvento.jsp">Evento</a></li>
                                <li><a href="formularioPessoa.jsp">Pessoa</a></li>
                                <li><a href="formularioJuridico.jsp">Juridco</a></li>
				</ul>
                        </nav>
        <h1>Cadastro esta ok </h1>
    </body>
</html>

<%-- 
    Document   : formularioEvento
    Created on : 05/11/2016, 15:33:55
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
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="formularioEvento.jsp">Evento</a></li>
                                <li><a href="formularioPessoa.jsp">Pessoa</a></li>
                                <li><a href="formularioJuridico.jsp">Juridco</a></li>
				</ul>
                        </nav>
        <h1>Cadastro</h1>
        <form action="ControleEvento" method="post" id="cadastro">
            Nome:               <input type="text" name="nome"><br>
            Descrição:          <input type="text" name="descricao"><br>
            Data Inicio:        <input type="text" name="dataini"><br>
            Data Fim:           <input type="text" name="datafim"><br>
            TIPO DE Evento:     <input type="text" name="tipo"><br>
            CEP:                <input type="text" name="cep"><br>
            Logradouro:         <input type="text" name="logradouro"><br>
            Nome Logradouro:    <input type="text" name="nlogradouro"><br>
            Numero:             <input type="text" name="numero"><br>
            Bairro:             <input type="text" name="bairro"><br>
            Municipio:          <input type="text" name="municipio"><br>
            UF:                 <input type="text" name="uf"><br>
            <input type="submit" name="acao" value="Cadastrar"><br>
        
        </form>
        <form action="ControleEvento" method="post" id="cadastro">
           <input type="submit" name="acao" value="Listar"><br> 
        </form>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 02/11/2016, 11:47:38
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
        <form action="Servlet" method="post" id="cadastro">
            Nome:               <input type="text" name="nome"><br>
            CPF:                <input type="text" name="cpf"><br>
            RG:                 <input type="text" name="rg"><br>
            Data Nascimento:    <input type="text" name="datanasc"><br>
            Email:              <input type="text" name="email"><br>
            CEP:                <input type="text" name="cep"><br>
            Logradouro:         <input type="text" name="logradouro"><br>
            Nome Logradouro:    <input type="text" name="nlogradouro"><br>
            Numero:             <input type="text" name="numero"><br>
            Bairro:             <input type="text" name="bairro"><br>
            Municipio:          <input type="text" name="municipio"><br>
            UF:                 <input type="text" name="uf"><br>
            <input type="submit" name="acao" value="Cadastrar"><br>
            <input type="reset">
        </form>

        <h1>Atualizar</h1>
        <form action="ControlePessoa" method="post" id="cadastro">
            Nome:               <input type="text" name="nome"><br>
            CPF:                <input type="text" name="cpf"><br>
            RG:                 <input type="text" name="rg"><br>
            Data Nascimento:    <input type="text" name="datanasc"><br>
            CEP:                <input type="text" name="cep"><br>
            Logradouro:         <input type="text" name="logradouro"><br>
            Nome Logradouro:    <input type="text" name="nlogradouro"><br>
            Numero:             <input type="text" name="numero"><br>
            Bairro:             <input type="text" name="bairro"><br>
            Municipio:          <input type="text" name="municipio"><br>
            UF:                 <input type="text" name="uf"><br>
            <input type="submit" name="acao" value="Update"><br>
            <input type="reset">
        </form>
        <h1>Listar</h1>
        <form action="ControlePessoa" method="post">
            <input type="submit" name="acao" value="Listar"><br>
            <input type="reset">
        </form>
    </body>
</html>

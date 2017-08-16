<%-- 
    Document   : Confirmar Alteracao
    Created on : 24/05/2017, 18:07:05
    Author     : Lucas Puglia
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>tipo de acesso</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <% 
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado"); 
            if (usuario != null) { 
        %> 
        <div class="wrapper">
            <div class="container">
                <h1>Selecione seu tipo de acesso</h1> <br /> <br />
                <form class="form" method="post" action="ControleEvento">
                    
                    

                    <!-- BOTTON Funcionando -->
                  <!--  <button type="submit" name="acao" value="Atualizar&url=ok">Confirmar</button>-->
                 
                  <!--<a href="ControleEvento?acao=Atualizar&url=ok2&txtnomeEV">Pessoa Fisica</a> <br /> <br />-->
                  <a href="SENHAentrarEventos.jsp">Pessoa Juridica</a>

                  <a href="ControleAcesso?acao=EntrarEVPessoa&txtLogin=<%=usuario.getNome()%>&txtSenha=<%=usuario.getSenha()%>">Pessoa Fisica</a> 
                   
                    
                    <!--<button type="submit" id="singin-button">Sing in</button>-->
                </form>
            </div>
            <ul class="bg-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
            <script src='https://code.jquery.com/jquery-3.1.1.min.js'></script>
            <script src="js/login.js"></script>
        </div>
    </body>
</html>

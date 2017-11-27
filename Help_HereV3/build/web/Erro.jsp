<%-- 
    Document   : Erro
    Created on : 12/03/2017, 15:21:56
    Author     : Lucas Puglia
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Senha Incorreta</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        
        
        <div class="wrapper">
            <div class="container">
                <h1>Senha ou Usuário incorreto</h1> <br /> <br />
                <h3> Por favor tente novamente</h3>
                <form class="form" method="post" action="ControleEvento">
        
        
                
                <input style="background-color: white;color: #00c795;" type="button" onclick="location.href='login.jsp';" value="Login" />
                
                <br ><br >
                <input style="background-color: white;color: #00c795;" type="button" onclick="location.href='index.jsp';" value="Página Inicial" />
                                                                                    
                
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

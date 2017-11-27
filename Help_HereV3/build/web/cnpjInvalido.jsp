<%-- 
    Document   : cnpjInvalido
    Created on : 08/04/2017, 14:38:14
    Author     : Lucas Puglia
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Limite Atingido</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        
        <div class="wrapper">
            <div class="container">
                <h1>CNPJ ou Senha errado</h1> <br /> <br /> 
                <h2> Por favor tente novamente</h2>
                <form class="form" method="post" action="ControleEvento">
                    <br /> <br /> <br /> 
                <input style="background-color: white;color: #00c795;" type="button" onclick="location.href='javascript:window.history.go(-1)';" value="Voltar" />
                
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

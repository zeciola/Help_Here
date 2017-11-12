<%-- 
    Document   : AlterareExcluirNegado
    Created on : 12/11/2017, 16:38:35
    Author     : Lucas Puglia
--%>


<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Evento já Iniciado</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        
        <div class="wrapper">
            <div class="container">
                <h1>O Evento esta em andamento</h1> <br /> <br />
                <h3> Alterações e cancelamentos são permitidos somente a eventos não inicializados</h3> <br ><br >
                
                <form class="form" method="post" action="ControleEvento">
                    
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

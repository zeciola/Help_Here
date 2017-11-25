<%-- 
    Document   : naoautenticado
    Created on : 21/03/2017, 17:41:15
    Author     : Diego
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
        
        
        <div class="wrapper">
            <div class="container">
                <h1>Faça login para ter acesso</h1> <br /> <br />
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

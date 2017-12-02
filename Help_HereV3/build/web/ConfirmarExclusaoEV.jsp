<%-- 
    Document   : ConfirmarExclusaoEV
    Created on : 21/05/2017, 23:14:37
    Author     : Lucas Puglia
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Confirmar Exclusão do Evento</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="container">
                <h1>Digite o Nome do Evento a ser Excluído?</h1>
                <form class="form" method="post" action="ControleEvento">
                    
                    <input type="text" name="txtnomeEV" placeholder="nome">

                    <!-- BOTTON Funcionando -->
                    <button type="submit" name="acao" value="Remover">Confirmar</button>
                    
                    
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

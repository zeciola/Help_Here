<%-- 
    Document   : CNPJ
    Created on : 03/04/2017, 09:14:21
    Author     : Lucas Puglia
--%>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>Atualização da dados da Instituição</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="wrapper">
            <div class="container">
                <h1>Digite o CNPJ da Instituiçaõ</h1>
                <form class="form" method="post" action="ControleInstituicao">
                    <input type="text" name="txtcnpj" placeholder="CNPJ">
                    

                    <!-- BOTTON Funcionando -->
                    <button type="submit" name="acao" value="Consultar">Confirmar</button>
                    
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
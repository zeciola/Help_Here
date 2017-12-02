<%-- 
    Document   : email
    Created on : 11/04/2017, 16:22:18
    Author     : jrciola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Digite seu email para consulta:</h1>
                <form class="form" method="post" action="ControlePessoa">
                    <input type="text" name="txtemail" placeholder="Email">
                    

                    <!-- BOTTON Funcionando -->
                    <button type="submit" name="acao" value="Consultar">Confirmar</button>
                    
                    <div>
                        <ul>
                            <!-- Link Esquecu Senha-->
                            <li><a href="CadastroPessoaForm.jsp" class="senha-link">Cadastrar-se</a></li>
                            <li><a href="#" class="senha-link">Esqueceu a senha?</a></li>
                        </ul>
                    </div>
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

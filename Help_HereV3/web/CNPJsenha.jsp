<%-- 
    Document   : CNPJsenha
    Created on : 05/04/2017, 10:28:15
    Author     : Lucas Puglia
--%>

<%@page import="DAO.DAOInstituicao"%>
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
                <h1>Digite o CNPJ da Instituição</h1>
                <form class="form" method="post" action="ControleAcesso">
                    <input type="text" name="txtcnpj" placeholder="CNPJ">
                    <input type="password" name="txtSenha" placeholder="Senha">
                    

                    <!-- BOTTON Funcionando -->
                    <button type="submit" name="acao" value="Remove">Excluir</button><br /> <br />
                    <button type="submit" name="acao" value="Altera">Alterar</button>
                    
                    
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
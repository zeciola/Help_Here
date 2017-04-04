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
                    <input type="text" name="CNPJ_antigo" placeholder="CNPJ">
                    

                    <!-- BOTTON Funcionando -->
                    <button type="submit" name="acao" value="Consultar">Confirmar</button>
                    <%
                        String CNPJ_ant = null;
                        
                        
                        request.setAttribute("CNPJ_antigo", CNPJ_ant);
                    
                    
                    %> 
                    <div>
                        <ul>
                            <!-- Link Esquecu Senha-->
                            <li><a href="CadastroInstituicao.jsp" class="senha-link">Cadastrar-se</a></li>
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
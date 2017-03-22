    <!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Bem vindo ao site!</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="wrapper">
        <div class="container">
            <h1>Help Here!</h1>
            <form class="form" method="post" action="ControleAcesso">
                <input type="login" name="txtLogin" placeholder="Usuario">
                <input type="password" name="txtSenha" placeholder="Senha">
                <!-- BOTTON não Funcionou comigo usei input -->   
                <input type="submit" name="acao" value="Entrar">  
                <!-- BOTTON Funcionando -->
                <button type="submit" name="acao" value="Entrar" id="login-button">Entrar</button>
                <ul>
                <li><a href="#" class="senha-link" id="login-button">Esqueceu a senha?</a></li>
                </ul>
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
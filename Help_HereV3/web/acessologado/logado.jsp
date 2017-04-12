<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem Vindo</h1>
        <a href="../ControleAcesso?acao=Sair">Logoff</a>
        <a href="../admin/indexLogado.jsp">admin</a>
        <h2>Cadastrar</h2>
    <li>
        <a href="../CadastroInstituicao.jsp">Cadastrar Instituição</a>
    </li>
    <h2>Consultar</h2>
    <li>
        <a href="../CNPJ.jsp">Consultar Instituição</a>
    </li>

    <li>
        <a href="../email.jsp">Consultar Pessoa</a>
    </li>
</li>
<h2>Alterar</h2>
<li>
    <a href="../CNPJ.jsp">Alterar Instituição</a>
</li>
<li>
    <a href="../emailSenha.jsp">Alterar Pessoa</a>
</li>
<h2>Deletar</h2>
<li>
    <a href="../CNPJsenha.jsp">Deletar Instituição</a>
</li>

<h2>Listar Instituição</h2>
<li>
    <form action="../ControleInstituicao" method="post">
        <input type="submit" name="acao" value="Listar"><br>

    </form>
    
    <h2>Listar Pessoa</h2>
    <form action="../ControlePessoa" method="post">
        <input type="submit" name="acao" value="Listar"><br>

    </form>

</li>
</body>
</html>

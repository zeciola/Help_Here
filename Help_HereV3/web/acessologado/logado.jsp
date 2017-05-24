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
        <a href="../Eventos.jsp">Eventos</a>
        <h2>Cadastrar</h2>
        <ul>
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
        </ul>
        <h2>Alterar</h2>
    <li>
        <a href="../CNPJ.jsp">Alterar Instituição</a>
    </li>

    <li>
        <a href="../AlterarPessoa.jsp">Alterar Pessoa</a>
    </li>
    <h2>Deletar</h2>
    <li>
        <a href="../CNPJsenha.jsp">Deletar Instituição</a>
        <br/>
        <a href="../emailSenha.jsp">Deletar Pessoa</a>
    </li>

    <h2>Listar Instituição</h2>
    <li>
        <form action="../ControleInstituicao" method="post">
            <input type="submit" name="acao" value="Listar"><br>

        </form>

        <h2>Listar Pessoa</h2>
        
        <a href="../ControlePessoa?acao=Listar" methods="post">Listar Pessoa Test</a>
        <form action="../ControlePessoa" method="post">
            <input type="submit" name="acao" value="Listar"><br>

        </form>

    </li>
</body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina a ser criada quando o usuario esta logado no sitema o mesmo deve ter opções da sua conta!</h1>
        <a href="../ControleAcesso?acao=Sair">Logoff</a>
        <a href="../admin/indexLogado.jsp">admin</a>
        
                    <li>
                        <a href="../CadastroInstituicao.jsp">Cadastrar Instituição</a>
                    </li>
                    <li>
                        <a href="../CNPJ.jsp">Alterar Instituição</a>
                    </li>
                
                        <h1>Listar</h1>
        <form action="../ControleInstituicao" method="post">
            <input type="submit" name="acao" value="Listar"><br>
            
        </form>

                   
    </body>
</html>

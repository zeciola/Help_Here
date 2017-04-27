<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Autenticação de Usuário </div>
        
        <%
            String msg=(String)request.getAttribute("msg");
            if(msg!=null){
        %> 
        <font color="blue"><%=msg %></font>
            <%}%>
            <form action="ControleAcesso" method="post">
                Login:<input type="text" name="txtLogin"><br>
                senha:<input type="password" name="txtSenha"><br>
                <input type="submit" value="Entrar" name="acao">
            </form>
    </body>
</html>

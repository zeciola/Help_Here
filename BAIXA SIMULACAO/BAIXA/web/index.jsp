<%-- 
    Document   : index
    Created on : 02/12/2017, 22:31:16
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Informe o seu boleto para pagar</h1>
        <form action="ControleBaixa" method="post">
            <input type="text" name="numeroboleto">
            <input type="submit" name="acao" value="Proximo">
        </form>
    </body>
</html>

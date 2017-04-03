<%-- 
    Document   : erro
    Created on : 08/11/2016, 09:06:51
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
        <strong><font color="blue">Houve um erro durante o cadastro do Usuario!<br />
                Contate o administrador do sistema e informe a seguinte mensagem de erro:<br />
                <%= ((Exception)request.getAttribute("erro")).getMessage() %></font></strong>
    </body>
</html>

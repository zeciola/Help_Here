<%-- 
    Document   : Erro
    Created on : 12/03/2017, 15:21:56
    Author     : Lucas Puglia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DEU RUIM</title>
    </head>
    <body>
        <h1>ERRO</h1>
        <%=((Exception)request.getAttribute("erro")).getMessage()%> 
                
    </body>
</html>

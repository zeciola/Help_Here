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
        <%
            Double valor = (Double) session.getAttribute("valor");
            
            if(valor == 0 || valor == null){
                valor = 1000.00;
            }
        %>
        
        SALDO EM CONTA:
    </body>
</html>

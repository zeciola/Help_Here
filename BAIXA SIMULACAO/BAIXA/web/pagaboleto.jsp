<%-- 
    Document   : index
    Created on : 02/12/2017, 22:31:16
    Author     : Diego
--%>

<%@page import="MODELO.Baixa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            double valor  =(double) session.getAttribute("v");
            Baixa b = (Baixa) session.getAttribute("baixa");
        %>
        
        SALDO EM CONTA:<%=valor%>
        <form action="ControleBaixa" method="post">
            <input type="text" name="numeroboleto" value="<%=b.getNumeroBoleto() %>">
            <input type="text" name="valor" value="<%=b.getValor1() %>">
            <input type="text" name="usuario">
            <input type="password" name="senha">
            <input type="text" name="token">
            <input type="submit" value="consultar">
        </form>
    </body>
</html>

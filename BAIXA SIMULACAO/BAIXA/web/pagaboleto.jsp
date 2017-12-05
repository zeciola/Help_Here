
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
            Double valor  =(Double) session.getAttribute("v");
            Baixa b = (Baixa) session.getAttribute("baixa");
        %>
        
        SALDO EM CONTA:<%=valor%>
         <form action="ControleBaixa" method="post">
            <input type="text" name="numeroboleto" value="<%=b.getNumeroBoleto()%>"><br>
            <input type="text" name="valor" value="<%=b.getValor1()%>"><br>
            Cpf: <input type="text" name="cpf"><br>
            Senha: <input type="password" name="senha"><br>
            
            <input type="submit" name="acao" value="Pagar">
            
        </form>
    </body>
</html>

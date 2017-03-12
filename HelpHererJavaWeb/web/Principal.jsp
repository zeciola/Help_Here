<%-- 
    Document   : Principal
    Created on : 12/03/2017, 16:22:22
    Author     : Lucas Puglia
--%>

<%@page import="Model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        
        <% 
            // recupera usuario da sessao
            Login login = (Login)session.getAttribute("usuarioAutenticado");
            
            if (login != null){
                %>
                <h1> Bem-Vindo, <%=login.getNome() %> ! </h1>
                <%}%>
                <a href="Cadastro_Usuario.jsp"> Area restrita</a><br/>
                <a href="ControleAcesso?acao=Sair">Logout</a>
                
            }
    </body>
</html>

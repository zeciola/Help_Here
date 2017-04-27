<%-- 
    Document   : principal
    Created on : 22/02/2017, 09:34:55
    Author     : 11141104689
--%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        <%
            //recupera o usuario da sessao
            Usuario usuario = (Usuario) session.getAttribute("usuarioAutenticado");
            if (usuario != null) {
        %> 
        <h1>Bem vindo, <%= usuario.getLogin()%>! </h1>
        <%}%>
        <a href="admin/cadastro_usuario.jsp">Areá Restrita</a><br>
        <a href="ControleAcesso?acao=Sair">logout</a>


    </body>
</html>

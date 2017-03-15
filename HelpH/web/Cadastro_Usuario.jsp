<%-- 
    Document   : Cadastro_Usuario
    Created on : 12/03/2017, 14:31:48
    Author     : Lucas Puglia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area Restrita</title>
    </head>
    <body>
        <h1>Acesso Restrito aos Administradores</h1>
         <h2>Cadastrar novo usuário</h2>
        
         <%
             String msg = (String) request.getAttribute("msg");
             if (msg != null) {
         %>
         <font color="blue"><%=msg %></font>
         <%}%>
         <form action="ControleUsuario" method="POST"></form>
                Login: <input type="text" name="txtLogin"><br/>
                Senha: <input type="password" name="txtSenha"><br/>
                Perfil: <select name="optPerfil"> 
                    <option>COMUM</option>
                    <option>ADMINISTRADOR</option> 
                </select><br/>
                <input type="submit" value="Cadastrar" name="acao">
        </form>
        <a href="../Principal.jsp"> Pagina Principal</a> 
             
        
    </body>
</html>

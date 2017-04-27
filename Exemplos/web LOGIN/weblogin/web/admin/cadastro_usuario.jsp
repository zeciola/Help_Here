<%-- 
    Document   : cadastro_usuario
    Created on : 22/02/2017, 09:30:59
    Author     : 11141104689
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área restrita</title>
    </head>
    
        <h1>Area de acesso restrito aos administradores</h1>
        <h2>Cadastro novo usuário</h2>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
        %>
        <font color="blue"><%=msg%></font>
        <%}%>
        <form action =" /weblogin/ControleUsuario" method="post">
            Login:<input type="text" name="txtLogin"><br>
            senha:<input type="password" name="txtSenha"><br>
            Perfil:<select name="optPerfil">
                        <option>comum</option>
                        <option>administrador</option>
                    </select>
            <input type="submit" value="Cadastrar" name="acao">
        </form>
        <a href="../principal.jsp">Página Principal</a>
    
</html>

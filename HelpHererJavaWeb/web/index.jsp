<%-- 
    Document   : index
<<<<<<< HEAD
    Created on : 08/02/2017, 09:27:09
    Author     : 11141100883
--%>

=======
    Created on : 08/02/2017, 10:10:05
    Author     : 11141100670
--%>


>>>>>>> origin/master
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação</title>
    </head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <body>
        <h1>Autenticação de usuário</h1>
        <%
            String msg = (String) request.getAttribute("msg");
            if(msg!=null){
                
         %>
         <font color="red"> <%=msg%></font>
         <%}%>
         <form action="ControleAcesso" method="POST">
             Login: <input type="text" name="txtLogin"><br/>
             Senha: <input type="submit" value="Entrar" name="acao">
         </form> 
    </body>
</html>

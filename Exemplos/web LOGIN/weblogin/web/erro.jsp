<%-- 
    Document   : erro
    Created on : 22/02/2017, 09:31:40
    Author     : 11141104689
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR PAGE</title>
    </head>
    <body>
        <h1>ERROR!</h1>
        <%=((Exception)request.getAttribute("erro")).getMessage()%>
    </body>
</html>

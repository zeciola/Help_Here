<%-- 
    Document   : teste
    Created on : 20/08/2017, 17:27:11
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
        <%String nome = (String) session.getAttribute("nomepdf");%>
        <h1>Hello World! teste pdf</h1>
        <iframe src="pdf/<%=nome%>" width="600" height="780" style="border: none;"></iframe>
    </body>
</html>

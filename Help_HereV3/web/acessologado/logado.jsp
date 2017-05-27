<%@page import="Model.Feeds"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bem Vindo</h1>
        <a href="../ControleAcesso?acao=Sair">Logoff</a>
        <a href="../admin/indexLogado.jsp">admin</a>
        <a href="../Eventos.jsp">Eventos</a>
        <h2>Cadastrar</h2>
        <ul>
            <li>
                <a href="../CadastroInstituicao.jsp">Cadastrar Instituição</a>
            </li>
            <li><h2>Consultar</h2></li>
            <li>
                <a href="../CNPJ.jsp">Consultar Instituição</a>
            </li>

            <li>
                <a href="../email.jsp">Consultar Pessoa</a>
            </li>
        </ul>
        <h2>Alterar</h2>
    <ul>
    <li>
        <a href="../CNPJ.jsp">Alterar Instituição</a>
    </li>
    <li>
        <a href="../emailSenha.jsp">Alterar Pessoa</a>
    </li>

    <li>
        <a href="../AlterarPessoa.jsp">Alterar Pessoa Esse!</a>
    </li>
    <li><h2>Deletar</h2></li>
    <li>
        <a href="../CNPJsenha.jsp">Deletar Instituição</a>
        <br/>
        <a href="../emailSenha.jsp">Deletar Pessoa</a>
    </li>

    
    <li>
   </ul>
        <h2>Listar Instituição</h2>
        <form action="../ControleInstituicao" method="post">
            <input type="submit" name="acao" value="Listar"><br>
        </form>
        <h2>Listar Pessoa</h2>
        <form action="../ControlePessoa" method="post">
            <input type="submit" name="acao" value="Listar"><br>
        </form>
    

    <%
        Login usuario = (Login) session.getAttribute("usuarioAutenticado");
        if (usuario != null) {
    %> 
    <h1>Bem vindo Usuario, <%= usuario.getNome()%>! </h1>
    <h2><%= usuario.getId() %></h2>
    <%}%>


    <h1> Aqui vai o feeds </h1>
    
<% ArrayList<Feeds> Lista = (ArrayList<Feeds>) request.getAttribute("feed");
        if (Lista == null) {
            request.getRequestDispatcher("/ControleFeed?acao=Listar&iduser="+usuario.getId()).forward(request, response);
        }%>
    <%for (Feeds e : Lista) {%>  
    <div id="feed">
        Conheça o Evento <%=e.getNomeEvento()%><br>
        A partir do dia: <%=e.getDatainiev()%> ate: <%=e.getDatafimev()%>
        <b>aqui poderia ser um link para consultar o evento diretamente</b>
        
    </div><%}%>
        <a href="../ControleFeed?acao=Inserir">salva feed</a>
    
</body>
</html>

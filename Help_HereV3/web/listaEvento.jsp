<%-- 
    Document   : listaEvento
    Created on : 19/05/2017, 20:00:24
    Author     : Lucas Puglia
--%>

<%@page import="Model.Instituicao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Model.Evento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAOEvento"%>
<html>
    <head><link href="estilo.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="corpo">
        <header id="cabecalhop">  <!-- CABEÇALHO DA PAGINA-->
			<header>
				<a href="index.jsp"></a>
			</header>
			<nav id="menu">
				<h1>Menu Principal</h1>
				<ul>
                                <li><a href="Eventos.jsp">Eventos</a></li>
                                <li><a href="CNPJsenhaEvento.jsp">cadastrar Evento</a></li>
				</ul>
                        </nav>
        <h1>Resultado da Pesquisa</h1>  
        <table border="1" width="20%" cellpadding="2" >
            <tr align="center">
                    <td>Data Inicio</td>
                    <td>Data Fim</td> 
                    <td>Nome</td>
                    <td>Tipo Evento</td>
                    <td>Descricao </td>
                    <td>Opção1 </td>
                    <td>Opção2 </td>
                    <td>Opção3 </td>
                  
                </tr>
                <% //recupera a lista do request
                ArrayList<Evento> listaEvento = (ArrayList<Evento>)request.getAttribute("listaEV");
                for(Evento e: listaEvento){  %>  
                <tr align="center">
                    <td><%=e.getDataInicio()%></td>
                    <td><%=e.getDataFim()%></td>
                    <td><%=e.getNome()%></td>
                   <td><%=e.getTipoEvento()%></td>
                   <td><%=e.getDescricao()%></td>
                  
                      
                      
                       
                       <td>
                        <a href="ControleEvento?acao=Consultar&url=1&txtnome=<%=e.getNome()%>">Informações Completas</a>
                       </td>
                        <td>
                        <a href="CNPJsenhaEvento.jsp">Excluir</a>
                        </td>
                        <td>
                        <a href="ControleEvento?acao=Atualizar&url=ok2&txtnomeEV=<%=e.getNome()%>">Alterar</a> <!--Falta ver onde vai chamar o cnpjsenhaevento-->
                        </td>
                        
                   
                                      
                   
                </tr>
                <%}%>
           
           </table>
                
               
    </body>
</html>

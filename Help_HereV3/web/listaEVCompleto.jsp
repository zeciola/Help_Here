<%-- 
    Document   : listaEVCompleto
    Created on : 20/05/2017, 14:09:21
    Author     : Lucas Puglia
--%>

<%@page import="Model.Endereco"%>
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
                                <li><a href="CriarEventoInst.jsp">cadastrar Evento</a></li>
				</ul>
                        </nav>
        <h1>Resultado da Pesquisa</h1> <br /> <br />
        
        <h2>Evento</h2><br /> 
        <table border="1" width="20%" cellpadding="2" >
            <tr align="center">
                    <td>Data Inicio</td>
                    <td>Data Fim</td> 
                    <td>Nome</td>
                    <td>Tipo Evento</td>
                    <td>Descricao </td>
                  
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
                                      
                   
                </tr>
                <%}%>
                <br />
           
        </table><br /><br />
           
               
        <h2>Endereço</h2><br /> 
        <table border="1" width="20%" cellpadding="2" >
            <tr align="center">
                        <td>Endereco</td>
                        <td>Número</td> 
                        <td>Municipio</td>
                        <td>Estado</td>
                        <td>Bairro</td>
                        <td>CEP</td>
                        <td>Pais</td>
                        
            </tr>
                <% //recupera a lista do request
                ArrayList<Endereco> EnderecoEvento = (ArrayList<Endereco>)request.getAttribute("listaEnd");
                for(Endereco en: EnderecoEvento){  %>  
                <tr align="center">
                        <td><%=en.getNomelogradouro()%></td>
                        <td><%=en.getNumeroen()%></td>
                        <td><%=en.getMunicipio()%></td>
                        <td><%=en.getEstado()%></td>
                        <td><%=en.getBairro()%></td>
                        <td><%=en.getCep()%></td>
                        <td><%=en.getPais()%></td>
                        
                        

                    </tr>
                    <%}%>
                    <br/>

                </table><br/><br/>
                                   
                <h2>Instituição Responsavel</h2>  
        <table border="1" width="20%" cellpadding="2" >
            <tr align="center">
                    <td>Nome</td>
                    <td>Razao Social</td> 
                    <td>Tipo</td>
                    <td>CNPJ</td>
                    <td>Modalidade </td>
                    <td>E-mail</td>
                    
                </tr>
                <% //recupera a lista do request
                ArrayList<Instituicao> listaInstituicao = (ArrayList<Instituicao>)request.getAttribute("listaInst");
                for(Instituicao e: listaInstituicao){  %>  
                <tr align="center">
                    <td><%=e.getNome()%></td>
                    <td><%=e.getRazao()%></td>
                    <td><%=e.getTipo()%></td>
                   <td><%=e.getCnpj()%></td>
                   <td><%=e.getModalidade()%></td>
                   <td><%=e.getEmail()%></td>
                                   
                   
                </tr>
                <%}%>
                <br/>
           </table>
               
                
    </body>
</html>
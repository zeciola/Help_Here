
<%@page import="Model.Evento"%>
<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina ajude mais</title>

        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/logado.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css2/ocultar.css">
    </head>

    <body>
        <%
            Usuario user = (Usuario) session.getAttribute("usuarioAutenticado");
            Evento ev = (Evento) session.getAttribute("evento");
            
        //Instituicao inst = (Instituicao) request.getAttribute("resp");
        %>
        <header>
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="logado.jsp">Seu Perfil</a>
                    </div>
                    <ul class="nav navbar-nav navbar-left">
                        <!-- Dropdown submenu -->
                    </ul>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="${pageContext.request.contextPath}/ControleAcesso?acao=Sair">Sair</a>   
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container -->
            </nav>
        </header>

        
        <% if (ev.getTipoEvento().equals("Doacao")) {%>
        <h1>Doação</h1>
        <h3>Bem vindo</h3>
        <p>Confirme seus dados para doar no Evento: <%=ev.getNome()%></p>
        <form class="well form-horizontal" action="../GeraBoleto2" method="post" id="contact_form">
            <fieldset>

                <div class="form-group">

                    <label class="col-md-4 control-label">Nome</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getNome()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">Sobrenome</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getSobrenome()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">CPF</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getCpf()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">RG</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getRg()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">Data Nascimento</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getDatanascimento()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">sexo</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getSexo()%>">
                        </div>
                    </div>
                </div>



                <div class="form-group">

                    <label class="col-md-4 control-label">Telefone</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getTelefone()%>">
                        </div>
                    </div>
                </div> 

                <div class="form-group">

                    <label class="col-md-4 control-label">Celular</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getCelular()%>">
                        </div>
                    </div>
                </div>          


                <div class="form-group">

                    <label class="col-md-4 control-label">E-mail</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getEmail()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">valor</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="valor" class="form-control selectpicker" > 
                                <option value="5">R$ 5.00</option>
                                <option value="10">R$ 10.00</option>
                                <option value="15">R$ 15.00</option>
                                <option value="30">R$ 30.00</option>
                                <option value="45">R$ 45.00</option>
                                <option value="60">R$ 60.00</option>
                                <option value="75">R$ 75.00</option>
                                <option value="100">R$ 100.00</option>
                            </select>

                        </div>
                    </div>
                </div>



                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">


                        <button type="submit" name="acao" value="Doar">Ajudar<span class="glyphicon glyphicon-send"></span></button>
                    </div>
                </div>



            </fieldset>

        </form>
       

        <%} else {%>
        <h1>Voluntariado</h1>
        <h3>Bem vindo!</h3>
        <p>Confirme seus dados para se voluntariar no Evento: <%=ev.getNome()%><p>
        <form class="well form-horizontal" action="../ControleInstituicao" method="post" id="contact_form">
            <fieldset>

                <div class="form-group">

                    <label class="col-md-4 control-label">Nome</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getNome()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">Sobrenome</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getSobrenome()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">CPF</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getCpf()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">RG</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getRg()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">Data Nascimento</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getDatanascimento()%>">
                        </div>
                    </div>
                </div>

                <div class="form-group">

                    <label class="col-md-4 control-label">sexo</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getSexo()%>">
                        </div>
                    </div>
                </div>



                <div class="form-group">

                    <label class="col-md-4 control-label">Telefone</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getTelefone()%>">
                        </div>
                    </div>
                </div> 

                <div class="form-group">

                    <label class="col-md-4 control-label">Celular</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getCelular()%>">
                        </div>
                    </div>
                </div>          


                <div class="form-group">

                    <label class="col-md-4 control-label">E-mail</label>

                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Instituição" class="form-control" type="text" value="<%=user.getPe().getEmail()%>">
                        </div>
                    </div>
                </div>



                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">


                        <button type="submit" name="acao" value="Volun">Participar</button> 
                    </div>
                </div>



            </fieldset>

        </form>             
           
                        
              
        <%}%>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>

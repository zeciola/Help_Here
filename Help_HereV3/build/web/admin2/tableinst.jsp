<%@page import="Model.Instituicao"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Admin Theme v3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- jQuery UI -->
        <link href="https://code.jquery.com/ui/1.10.3/themes/redmond/jquery-ui.css" rel="stylesheet" media="screen">
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- styles -->
        <link href="css/styles.css" rel="stylesheet">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-5">
                        <!-- Logo -->
                        <div class="logo">
                            <h1><a href="index.html">Help Here Admin</a></h1>
                        </div>
                    </div>

                    <div class="col-md-5">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="input-group form">
                                    <input type="text" class="form-control" placeholder="Search...">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">Search</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="navbar navbar-inverse" role="banner">
                            <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account <b class="caret"></b></a>
                                        <ul class="dropdown-menu animated fadeInUp">
                                            <li><a href="profile.html">Profile</a></li>
                                            <li><a href="login.html">Logout</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="page-content">
            <div class="row">
                <div class="col-md-2">
                    <div class="sidebar content-box" style="display: block;">
                        <ul class="nav">
                            <!-- Main menu -->
                            <li class="current"><a href="index.html"><i class="glyphicon glyphicon-home"></i> Dashboard</a></li>
                            <li><a href="calendar.html"><i class="glyphicon glyphicon-calendar"></i> Calendar</a></li>
                            <li><a href="stats.html"><i class="glyphicon glyphicon-stats"></i> Statistics (Charts)</a></li>

                            <li class="submenu">
                                <a href="#">
                                    <i class="glyphicon glyphicon-list"></i> Tabelas
                                    <span class="caret pull-right"></span>
                                </a>
                                <!-- Sub menu -->
                                <ul>
                                    <li><a href="tablepessoa.jsp"><i class="glyphicon glyphicon-list"></i> Pessoa</a></li>
                                    <li><a href="tableinst.jsp"><i class="glyphicon glyphicon-list"></i> Empresas</a></li>
                                    <li><a href="tablend.jsp"><i class="glyphicon glyphicon-list"></i> Endereco</a></li>
                                    <li><a href="tableUser.jsp"><i class="glyphicon glyphicon-list"></i> Usu�rios</a></li>
                                </ul>
                            </li>
                            <li><a href="buttons.html"><i class="glyphicon glyphicon-record"></i> Buttons</a></li>
                            <li><a href="editors.html"><i class="glyphicon glyphicon-pencil"></i> Editors</a></li>
                            <li><a href="forms.html"><i class="glyphicon glyphicon-tasks"></i> Forms</a></li>
                            <li class="submenu">
                                <a href="#">
                                    <i class="glyphicon glyphicon-list"></i> Pages
                                    <span class="caret pull-right"></span>
                                </a>
                                <!-- Sub menu -->
                                <ul>
                                    <li><a href="login.html">Login</a></li>
                                    <li><a href="signup.html">Signup</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="row">
                        <div class="content-box-large">
                            <div class="panel-heading">
                                <div class="panel-options">
                                    <a href="#" data-rel="collapse"><i class="glyphicon glyphicon-refresh"></i></a>
                                    <a href="#" data-rel="reload"><i class="glyphicon glyphicon-cog"></i></a>
                                </div>
                            </div>
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">Institui��o</div>
                                </div>
                                <div class="panel-body">
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Nome</th>
                                                <th>Cnpj</th>
                                                <th>Razao</th>
                                                <th>Modalidade</th>
                                                <th>Tipo</th>
                                                <th>E-mail</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% ArrayList<Instituicao> ListaInst = (ArrayList<Instituicao>) request.getAttribute("instituicao");
                                                if (ListaInst == null) {
                                                    request.getRequestDispatcher("/ControleAdmin?acao=Listartable&url=tableinst").forward(request, response);
                                                }%>
                                            <%for (Instituicao i : ListaInst) {%>  
                                            <tr class="odd gradeX">
                                                <td><%=i.getIdInstituicao()%></td>
                                                <td><%=i.getNome()%></td>
                                                <td><%=i.getCnpj()%></td>
                                                <td><%=i.getRazao()%></td>
                                                <td><%=i.getModalidade()%></td>
                                                <td><%=i.getTipo()%></td>
                                                <td><%=i.getEmail()%></td>

                                            </tr><%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container">

                <div class="copy text-center">
                    Copyright 2014 <a href='#'>Website</a>
                </div>

            </div>
        </footer>

        <link href="vendors/datatables/dataTables.bootstrap.css" rel="stylesheet" media="screen">

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://code.jquery.com/jquery.js"></script>
        <!-- jQuery UI -->
        <script src="https://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="bootstrap/js/bootstrap.min.js"></script>

        <script src="vendors/datatables/js/jquery.dataTables.min.js"></script>

        <script src="vendors/datatables/dataTables.bootstrap.js"></script>

        <script src="js/custom.js"></script>
        <script src="js/tables.js"></script>
    </body>
</html>
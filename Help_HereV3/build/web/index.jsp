<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Evento"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="HelpHere" content="">
        <title>Help Here</title>
        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <link href="css/index.css" rel="stylesheet">
        <!-- JQuery -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Custom JavaScript -->
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
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
                    <a class="navbar-brand" href="index.html">Help Here</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="Sobre.html">Sobre</a>
                        </li>
                        <li>
                            <a href="CadastroPessoaForm.jsp">Cadastro</a>
                        </li>
                        <li>
                            <a href="login.jsp">Login</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
        <!-- Image Background Page Header -->
        <!-- Note: The background image is set within the business-casual.css file. -->
        <header class="business-header">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <a href="index.jsp">
                            <h1 class="tagline">Help Here - Ajude quem mais precisa!</h1>
                        </a>
                    </div>
                </div>
            </div>
        </header>
        <!-- Page Content -->
        <div class="container">
            <hr>
            <div class="business-lucas">
                <div class="col-sm-8">
                    <!--<h2>What We </h2>
                    <p>Introduce the visitor to the business using clear, informative text. Use well-targeted keywords within your sentences to make sure search engines can find the business.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et molestiae similique eligendi reiciendis sunt distinctio odit? Quia, neque, ipsa, adipisci quisquam ullam deserunt accusantium illo iste exercitationem nemo voluptates asperiores.</p>
                    <p>
                        <a class="btn btn-default btn-lg" href="#">Call to Action &raquo;</a>
                    </p>-->
                </div>
                <div class="col-sm-4">
                    <!--<h2>Contact Us</h2>
                    <address>
                        <strong>Start Bootstrap</strong>
                        <br>3481 Melrose Place
                        <br>Beverly Hills, CA 90210
                        <br>
                    </address>
                    <address>
                        <abbr title="Phone">P:</abbr>(123) 456-7890
                        <br>
                        <abbr title="Email">E:</abbr> <a href="mailto:#">name@example.com</a>
                    </address>-->
                </div>
            </div>
            <!-- /.row -->
            <hr>
            <br>
            <h1 ALIGN="center">Confira os Eventos mais recentes</h1>
            <div class="row">
                <% ArrayList<Evento> Lista = (ArrayList<Evento>) session.getAttribute("evento");
                    if (Lista == null) {
                        request.getRequestDispatcher("/ControleEvento?acao=Listar1&url=1").forward(request, response);
                    }%>
                <%for (Evento e : Lista) {%>

                <div class="col-sm-4">
                    <br> <br> <br>
                    <img class="img-circle img-responsive img-center" src="img/<%=e.getImg()%>" alt="">
                    <h2><%=e.getNome()%></h2>
                    <p><%=e.getDescricao()%></p>
                    <p><%=e.getDataInicio()%></p>
                    <p><%=e.getDataFim()%></p>
                    <a href="ControleEvento?acao=Consultar1&ID=<%=e.getIdEvento()%>">Ajude</a>
                </div>

                <%}%>

            </div>         
            <!-- /.row -->
            <hr>
            <!-- Footer -->
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright &copy; Your Website 2014</p>
                    </div>
                </div>
                <!-- /.row -->
            </footer>
        </div>
        <!-- /.container -->
        <!-- jQuery -->
        <script src="js/jquery.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
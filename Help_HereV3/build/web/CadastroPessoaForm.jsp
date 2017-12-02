<%-- 
    Document   : CastroFrom
    Created on : 08/02/2017, 10:26:34
    Author     : 11141100670
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <title>Cadastro - Help Here</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

        <link rel="stylesheet" type="text/css" href="css/style.css">

        <!-- barra de superior -->

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a class="navbar-brand" href="#"><strong>Help Here</strong></a></div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"> </li>
                    <li> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="Sobre.html">Sobre</a></li>
                    <li><a href="#">Cadastrar-se</a> </li>
                    <li><a href="login.jsp">Entrar</a> </li>
                </ul>

            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

</head>

<body>

    <script src="js/jquery.mim.js"></script>
    <script src="js/bootstrap.mim.js"></script>
    <script src="js/cadform.js"></script>

    <div class="container">

        <form class="well form-horizontal" action="ControlePessoa" method="post" id="contact_form">
            <fieldset>


                <!-- Form Name -->

                <legend class="titulo"><b>Cadastro</b></legend>


                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Nome</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="nome" placeholder="Primeiro Nome" class="form-control" type="text">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Sobrenome</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="sobrenome" placeholder="Sobrenome" class="form-control" type="text">
                        </div>
                    </div>
                </div>
                
                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label">Data de nascimento</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="datanascimento" placeholder="dd/mm/aa" class="form-control" type="date">
                        </div>
                    </div>
                </div>
                
                <!-- Sexo -->
                <div class="form-group">
                    <label class="col-md-4 control-label">Sexo</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <select name="sexo" class="form-control selectpicker">
                                <option value="" >Escolha o seu sexo</option>
                                <option value="Masculino">Masculino</option>
                                <option value="Feminino">Feminino</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                <!-- RG -->
                <div class="form-group">
                    <label class="col-md-4 control-label">RG</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="rg" placeholder="RG" class="form-control" type="number">
                        </div>
                    </div>
                </div>

                <!-- CPF -->
                <div class="form-group">
                    <label class="col-md-4 control-label">CPF</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input name="cpf" placeholder="CPF" class="form-control" type="number">
                        </div>
                    </div>
                </div>

                
                

                <!-- Email -->
                <div class="form-group">
                    <label class="col-md-4 control-label">E-Mail</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                            <input name="email" placeholder="exemplo@exemplo.com" class="form-control" type="email">
                        </div>
                    </div>
                </div>
                
                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Senha</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input name="password" placeholder="Senha" class="form-control" type="password">
                            <input name="senha" placeholder="Confirmar Senha" class="form-control" type="password">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Celular</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input name="celular" placeholder="(DD)95555-5555" class="form-control" type="number">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Telefone</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                            <input name="telefone" placeholder="(DD)95555-5555" class="form-control" type="number">
                        </div>
                    </div>
                </div>

                <!-- Text input-->

                <div class="form-group">
                    <label class="col-md-4 control-label">Endere�o</label>
                    <div class="col-md-4 inputGroupContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input name="nomelogradouro" placeholder="Endere�o" class="form-control" type="text">
                            <input name="bairro" placeholder="Bairro" class="form-control" type="text">
                            <input name="numeroen" placeholder="N�mero" class="form-control" type="number">
                            <input name="municipio" placeholder="Cidade" class="form-control" type="text">
                            <input name="cep" placeholder="CEP" class="form-control" type="number">
                        </div>
                    </div>
                </div>

                <!-- Select Basic -->

                <div class="form-group">
                    <label class="col-md-4 control-label">Pais</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="pais" class="form-control selectpicker">
                                <option value=" " >Escolha o seu pais</option>
                                <option value="�frica do Sul">�frica do Sul</option>
                                <option value="Alb�nia">Alb�nia</option>
                                <option value="Alemanha">Alemanha</option>
                                <option value="Andorra">Andorra</option>
                                <option value="Angola">Angola</option>
                                <option value="Anguilla">Anguilla</option>
                                <option value="Antigua">Antigua</option>
                                <option value="Ar�bia Saudita">Ar�bia Saudita</option>
                                <option value="Argentina">Argentina</option>
                                <option value="Arm�nia">Arm�nia</option>
                                <option value="Aruba">Aruba</option>
                                <option value="Austr�lia">Austr�lia</option>
                                <option value="�ustria">�ustria</option>
                                <option value="Azerbaij�o">Azerbaij�o</option>
                                <option value="Bahamas">Bahamas</option>
                                <option value="Bahrein">Bahrein</option>
                                <option value="Bangladesh">Bangladesh</option>
                                <option value="Barbados">Barbados</option>
                                <option value="B�lgica">B�lgica</option>
                                <option value="Benin">Benin</option>
                                <option value="Bermudas">Bermudas</option>
                                <option value="Botsuana">Botsuana</option>
                                <option value="Brasil" selected>Brasil</option>
                                <option value="Brunei">Brunei</option>
                                <option value="Bulg�ria">Bulg�ria</option>
                                <option value="Burkina Fasso">Burkina Fasso</option>
                                <option value="bot�o">bot�o</option>
                                <option value="Cabo Verde">Cabo Verde</option>
                                <option value="Camar�es">Camar�es</option>
                                <option value="Camboja">Camboja</option>
                                <option value="Canad�">Canad�</option>
                                <option value="Cazaquist�o">Cazaquist�o</option>
                                <option value="Chade">Chade</option>
                                <option value="Chile">Chile</option>
                                <option value="China">China</option>
                                <option value="Cidade do Vaticano">Cidade do Vaticano</option>
                                <option value="Col�mbia">Col�mbia</option>
                                <option value="Congo">Congo</option>
                                <option value="Cor�ia do Sul">Cor�ia do Sul</option>
                                <option value="Costa do Marfim">Costa do Marfim</option>
                                <option value="Costa Rica">Costa Rica</option>
                                <option value="Cro�cia">Cro�cia</option>
                                <option value="Dinamarca">Dinamarca</option>
                                <option value="Djibuti">Djibuti</option>
                                <option value="Dominica">Dominica</option>
                                <option value="EUA">EUA</option>
                                <option value="Egito">Egito</option>
                                <option value="El Salvador">El Salvador</option>
                                <option value="Emirados �rabes">Emirados �rabes</option>
                                <option value="Equador">Equador</option>
                                <option value="Eritr�ia">Eritr�ia</option>
                                <option value="Esc�cia">Esc�cia</option>
                                <option value="Eslov�quia">Eslov�quia</option>
                                <option value="Eslov�nia">Eslov�nia</option>
                                <option value="Espanha">Espanha</option>
                                <option value="Est�nia">Est�nia</option>
                                <option value="Eti�pia">Eti�pia</option>
                                <option value="Fiji">Fiji</option>
                                <option value="Filipinas">Filipinas</option>
                                <option value="Finl�ndia">Finl�ndia</option>
                                <option value="Fran�a">Fran�a</option>
                                <option value="Gab�o">Gab�o</option>
                                <option value="G�mbia">G�mbia</option>
                                <option value="Gana">Gana</option>
                                <option value="Ge�rgia">Ge�rgia</option>
                                <option value="Gibraltar">Gibraltar</option>
                                <option value="Granada">Granada</option>
                                <option value="Gr�cia">Gr�cia</option>
                                <option value="Guadalupe">Guadalupe</option>
                                <option value="Guam">Guam</option>
                                <option value="Guatemala">Guatemala</option>
                                <option value="Guiana">Guiana</option>
                                <option value="Guiana Francesa">Guiana Francesa</option>
                                <option value="Guin�-bissau">Guin�-bissau</option>
                                <option value="Haiti">Haiti</option>
                                <option value="Holanda">Holanda</option>
                                <option value="Honduras">Honduras</option>
                                <option value="Hong Kong">Hong Kong</option>
                                <option value="Hungria">Hungria</option>
                                <option value="I�men">I�men</option>
                                <option value="Ilhas Cayman">Ilhas Cayman</option>
                                <option value="Ilhas Cook">Ilhas Cook</option>
                                <option value="Ilhas Cura�ao">Ilhas Cura�ao</option>
                                <option value="Ilhas Marshall">Ilhas Marshall</option>
                                <option value="Ilhas Turks & Caicos">Ilhas Turks & Caicos</option>
                                <option value="Ilhas Virgens (brit.)">Ilhas Virgens (brit.)</option>
                                <option value="Ilhas Virgens(amer.)">Ilhas Virgens(amer.)</option>
                                <option value="Ilhas Wallis e Futuna">Ilhas Wallis e Futuna</option>
                                <option value="�ndia">�ndia</option>
                                <option value="Indon�sia">Indon�sia</option>
                                <option value="Inglaterra">Inglaterra</option>
                                <option value="Irlanda">Irlanda</option>
                                <option value="Isl�ndia">Isl�ndia</option>
                                <option value="Israel">Israel</option>
                                <option value="It�lia">It�lia</option>
                                <option value="Jamaica">Jamaica</option>
                                <option value="Jap�o">Jap�o</option>
                                <option value="Jord�nia">Jord�nia</option>
                                <option value="Kuwait">Kuwait</option>
                                <option value="Latvia">Latvia</option>
                                <option value="L�bano">L�bano</option>
                                <option value="Liechtenstein">Liechtenstein</option>
                                <option value="Litu�nia">Litu�nia</option>
                                <option value="Luxemburgo">Luxemburgo</option>
                                <option value="Macau">Macau</option>
                                <option value="Maced�nia">Maced�nia</option>
                                <option value="Madagascar">Madagascar</option>
                                <option value="Mal�sia">Mal�sia</option>
                                <option value="Malaui">Malaui</option>
                                <option value="Mali">Mali</option>
                                <option value="Malta">Malta</option>
                                <option value="Marrocos">Marrocos</option>
                                <option value="Martinica">Martinica</option>
                                <option value="Maurit�nia">Maurit�nia</option>
                                <option value="Mauritius">Mauritius</option>
                                <option value="M�xico">M�xico</option>
                                <option value="Moldova">Moldova</option>
                                <option value="M�naco">M�naco</option>
                                <option value="Montserrat">Montserrat</option>
                                <option value="Nepal">Nepal</option>
                                <option value="Nicar�gua">Nicar�gua</option>
                                <option value="Niger">Niger</option>
                                <option value="Nig�ria">Nig�ria</option>
                                <option value="Noruega">Noruega</option>
                                <option value="Nova Caled�nia">Nova Caled�nia</option>
                                <option value="Nova Zel�ndia">Nova Zel�ndia</option>
                                <option value="Om�">Om�</option>
                                <option value="Palau">Palau</option>
                                <option value="Panam�">Panam�</option>
                                <option value="Papua-nova Guin�">Papua-nova Guin�</option>
                                <option value="Paquist�o">Paquist�o</option>
                                <option value="Peru">Peru</option>
                                <option value="Polin�sia Francesa">Polin�sia Francesa</option>
                                <option value="Pol�nia">Pol�nia</option>
                                <option value="Porto Rico">Porto Rico</option>
                                <option value="Portugal">Portugal</option>
                                <option value="Qatar">Qatar</option>
                                <option value="Qu�nia">Qu�nia</option>
                                <option value="Rep. Dominicana">Rep. Dominicana</option>
                                <option value="Rep. Tcheca">Rep. Tcheca</option>
                                <option value="Reunion">Reunion</option>
                                <option value="Rom�nia">Rom�nia</option>
                                <option value="Ruanda">Ruanda</option>
                                <option value="R�ssia">R�ssia</option>
                                <option value="Saipan">Saipan</option>
                                <option value="Samoa Americana">Samoa Americana</option>
                                <option value="Senegal">Senegal</option>
                                <option value="Serra Leone">Serra Leone</option>
                                <option value="Seychelles">Seychelles</option>
                                <option value="Singapura">Singapura</option>
                                <option value="S�ria">S�ria</option>
                                <option value="Sri Lanka">Sri Lanka</option>
                                <option value="St. Kitts & Nevis">St. Kitts & Nevis</option>
                                <option value="St. L�cia">St. L�cia</option>
                                <option value="St. Vincent">St. Vincent</option>
                                <option value="Sud�o">Sud�o</option>
                                <option value="Su�cia">Su�cia</option>
                                <option value="Sui�a">Sui�a</option>
                                <option value="Suriname">Suriname</option>
                                <option value="Tail�ndia">Tail�ndia</option>
                                <option value="Taiwan">Taiwan</option>
                                <option value="Tanz�nia">Tanz�nia</option>
                                <option value="Togo">Togo</option>
                                <option value="Trinidad & Tobago">Trinidad & Tobago</option>
                                <option value="Tun�sia">Tun�sia</option>
                                <option value="Turquia">Turquia</option>
                                <option value="Ucr�nia">Ucr�nia</option>
                                <option value="Uganda">Uganda</option>
                                <option value="Uruguai">Uruguai</option>
                                <option value="Venezuela">Venezuela</option>
                                <option value="Vietn�">Vietn�</option>
                                <option value="Zaire">Zaire</option>
                                <option value="Z�mbia">Z�mbia</option>
                                <option value="Zimb�bue">Zimb�bue</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-4 control-label">Estado</label>
                    <div class="col-md-4 selectContainer">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                            <select name="estado" class="form-control selectpicker">
                                <option value="" >Escolha o seu estado</option>
                                <option value="AC">Acre</option>
                                <option value="AL">Alagoas</option>
                                <option value="AP">Amap�</option>
                                <option value="AM">Amazonas</option>
                                <option value="BA">Bahia</option>
                                <option value="CE">Cear�</option>
                                <option value="DF">Distrito Federal</option>
                                <option value="ES">Espirito Santo</option>
                                <option value="GO">Goi�s</option>
                                <option value="MA">Maranh�o</option>
                                <option value="MS">Mato Grosso do Sul</option>
                                <option value="MT">Mato Grosso</option>
                                <option value="MG">Minas Gerais</option>
                                <option value="PA">Par�</option>
                                <option value="PB">Para�ba</option>
                                <option value="PR">Paran�</option>
                                <option value="PE">Pernambuco</option>
                                <option value="PI">Piau�</option>
                                <option value="RJ">Rio de Janeiro</option>
                                <option value="RN">Rio Grande do Norte</option>
                                <option value="RS">Rio Grande do Sul</option>
                                <option value="RO">Rond�nia</option>
                                <option value="RR">Roraima</option>
                                <option value="SC">Santa Catarina</option>
                                <option value="SP">S�o Paulo</option>
                                <option value="SE">Sergipe</option>
                                <option value="TO">Tocantins</option>
                            </select>
                        </div>
                    </div>
                </div>
                
                
                <!-- Success message -->
                <div class="alert alert-success" role="alert" id="success_message">Sucesso! <i class="glyphicon glyphicon-thumbs-up"></i>Cadastro realizado com sucesso. <i style="font-size: 25px;">&#9786;</i></div>

                 <!-- Error message -->
                 <div style="background-color: firebrick" class="alert alert-success" role="alert" id="success_message">Erro <i class="glyphicon glyphicon-thumbs-down"></i>Ops! Algum erro foi encontrado <font style="font-size: 20px">&#9785;</font></div>
                
                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label"></label>
                    <div class="col-md-4">
                        <button type="submit" name="acao" value="Cadastrar" >Cadastrar <span class="glyphicon glyphicon-send"></span></button>
                    </div>
                </div>

            </fieldset>
        </form>
    </div>
<!-- /.container -->
</body>

</html>
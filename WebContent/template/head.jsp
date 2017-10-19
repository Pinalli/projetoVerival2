<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.PerfilAcesso"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
    		<!-- faviicons --> 
		<link rel="apple-touch-icon" sizes="57x57" href="/img/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="/img/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="/img/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="/img/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="/img/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="/img/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="/img/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="/img/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="/img/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="/img/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="/img/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="/img/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="/img/favicon-16x16.png">
		<link rel="manifest" href="/img/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/img/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
       
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <title>NutriÁ„o - Ficha TÈcnica a</title>
        <link rel="icon" href="img/iconutri.ico">
        
		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="./css/bootstrap.min.css">
	 	<link rel="stylesheet" href="./css/bootstrap-theme.min.css">
	 	
	 	<!-- SELECT2 -->
		<link rel="stylesheet" href="./css/select2.min.css">
		<link rel="stylesheet" href="./css/select2-bootstrap.css">
		
		<!-- Include the plugin's CSS and JS: Cassio DataTable -->
	<!-- 	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"> -->
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

		<!-- STYLE -->
		<link rel="stylesheet" href="./css/style.css">

        <!-- JQUERY -->
        <script src="http://code.jquery.com/jquery-1.12.0.min.js"></script>

		<!-- BOOTSTRAP -->
		<script src="./js/bootstrap.min.js"></script>
		
		<!-- BOOTSTRAP -->		
		<script src="./js/select2.min.js"></script>

		<!-- Include the plugin's CSS and JS: Cassio DataTable -->
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
 		<script type="text/javascript" src="https://cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>

		
		<!-- Include the plugin's CSS and JS: Cassio Dual ListBox -->
		<script src="./js/jquery.bootstrap-duallistbox.min.js"></script>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap-duallistbox.min.css">
		
		<!-- Include the plugin's CSS and JS: Cassio DateTime Picker -->
		<script type="text/javascript" src="./js/moment.js"></script>
		<script type="text/javascript" src="./js/pt-br.js"></script>
		<script type="text/javascript" src="./js/transition.js"></script>
		<script type="text/javascript" src="./js/collapse.js"></script>
		<script type="text/javascript" src="./js/bootstrap-datetimepicker.min.js"></script>
		<link rel="stylesheet" type="text/css" href="./css/bootstrap-datetimepicker.min.css">
		
	</head>
    
    <body>
    
    <% Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioSessao"); %>
    
      <nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp"><img class="logoNavBar" src="./img/logo-ftp.png" alt=""></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      <ul class="nav navbar-nav"> 
      	<% if(usuarioSessao.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR)) { %>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usurio <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="main?acao=listUser">Listar</a></li>
            <li><a href="main?acao=telaUser">Cadastrar</a></li>            
          </ul>
        </li>
                 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Empresa<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="main?acao=listEmpresa">Listar</a></li>
            <li><a href="main?acao=telaEmpresa">Cadastrar</a></li>            
          </ul>
        </li>
      	<% } %>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ingredientes <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="main?acao=listIngrediente">Listar</a></li>
            <li><a href="main?acao=telaIngredientes">Cadastrar</a></li>            
          </ul>
        </li>
        
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Medidas Caseiras<span class="caret"></span></a>
          <ul class="dropdown-menu">
			<li><a href="main?acao=listUnidadeMedidaCaseira">Listar Medidas Caseiras</a></li>
            <li><a href="main?acao=telaUnidadeMedidaCaseira">Cadastrar Medida Caseira</a></li>			
          </ul>
        </li>
       
          <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Fichas tcnicas<span class="caret"></span></a>
              <ul class="dropdown-menu">
                  <li><a  href="main?acao=telaFichaCompleta">Cadastrar Ficha TÈcnica Completa</a></li>
				  <li><a  href="main?acao=listFichaCompleta">Listar Fichas TÈcnicas Completas</a></li>
              </ul>
          </li>

        <!--li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Preview FTs<span class="caret"></span></a>
          <ul class="dropdown-menu">
	        <li><a  href="main?acao=telaFichaCompleta">Completa</a></li>
			<li><a  href="main?acao=telaFichaSimplificada">Simplificada</a></li>            
          </ul>
        </li-->
        
        <li class="dropdown">
        					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
        						<span class="glyphicon glyphicon-user"></span>
        						Ol, <%=usuarioSessao.getNome()%>!
        						<span class="caret"></span>
        					</a>
                           
        					<ul class="dropdown-menu dropdown-menu-right">
        						<li><a href="main?acao=logout">Logout</a></li>
        						<li><a href="main?acao=about">Sobre</a></li>
        					</ul>
        				</li>
        
      </ul>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
   
    	<div class="container">    	
    		

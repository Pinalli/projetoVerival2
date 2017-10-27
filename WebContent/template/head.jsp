<%@page import="br.ages.crud.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
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
		<link rel="icon" href="img/iconutri.ico">
		
		<link rel="manifest" href="/img/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/img/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
		     
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		  	
		<title>Nutrição - Ficha Técnica a</title>
		      
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
    
		<nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
			<div class="container">
				<a class="navbar-brand" href="#">
					<img src="img/32x32.png" alt="">
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
		    	<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<div class="dropdown show">
								<a class="nav-link dropdown-toggle" href="#" role="button" id="dpdUsuarios" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="icon-usuario"></span> Usuários
								</a>
								
								<div class="dropdown-menu" aria-labelledby="dpdUsuarios">
									<a class="dropdown-item" href="main?acao=listUser"><span class="icon-lista"></span> Listar</a>
									<a class="dropdown-item" href="main?acao=telaUser"><span class="icon-adicionar"></span> Cadastrar</a>
								</div>
							</div>
						</li>
						<li class="nav-item">
							<div class="dropdown show">
								<a class="nav-link dropdown-toggle" href="#" role="button" id="dpdEmpresas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="icon-empresas"></span> Empresas
								</a>
								
								<div class="dropdown-menu" aria-labelledby="dpdEmpresas">
									<a class="dropdown-item" href="main?acao=listEmpresa"><span class="icon-lista"></span> Listar</a>
									<a class="dropdown-item" href="main?acao=telaEmpresa"><span class="icon-adicionar"></span> Cadastrar</a>
								</div>
							</div>
						</li>
						<li class="nav-item">
							<div class="dropdown show">
								<a class="nav-link dropdown-toggle" href="#" role="button" id="dpdIngredientes" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="icon-ingredientes"></span> Ingredientes
								</a>
								
								<div class="dropdown-menu" aria-labelledby="dpdIngredientes">
									<a class="dropdown-item" href="main?acao=listIngrediente"><span class="icon-lista"></span> Listar</a>
									<a class="dropdown-item" href="main?acao=telaIngredientes"><span class="icon-adicionar"></span> Cadastrar</a>
								</div>
							</div>
						</li>
						<li class="nav-item">
							<div class="dropdown show">
								<a class="nav-link dropdown-toggle" href="#" role="button" id="dpdUnidadesMedida" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="icon-medida-caseira"></span> Unidades de Medida
								</a>
								
								<div class="dropdown-menu" aria-labelledby="dpdUnidadesMedida">
									<a class="dropdown-item" href="main?acao=listUnidadeMedidaCaseira"><span class="icon-lista"></span> Listar</a>
									<a class="dropdown-item" href="main?acao=telaUnidadeMedidaCaseira"><span class="icon-adicionar"></span> Cadastrar</a>
								</div>
							</div>
						</li>
						<li class="nav-item">
							<div class="dropdown show">
								<a class="nav-link dropdown-toggle" href="#" role="button" id="dpdFichasTecnicas" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<span class="icon-fichas"></span> Fichas Técnicas
								</a>
								
								<div class="dropdown-menu" aria-labelledby="dpdFichaTecnicas">
									<a class="dropdown-item" href="main?acao=listFichaCompleta"><span class="icon-lista"></span> Listar</a>
									<a class="dropdown-item" href="main?acao=telaFichaCompleta"><span class="icon-adicionar"></span> Cadastrar</a>
								</div>
							</div>
						</li>
					</ul>
					<div class="dropdown">
						<button class="btn btn-secondary btn-sm dropdown-toggle" type="button" id="dpdUsuario" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<span class="icon-usuario"></span> Olá, <strong><%=usuarioSessao.getNome()%></strong>
						</button>
						<div class="dropdown-menu" aria-labelledby="dpdUsuario">
							<a class="dropdown-item" href="main?acao=about"><span class="icon-sobre"></span> Sobre</a>
							<a class="dropdown-item" href="main?acao=logout"><span class="icon-sair"></span> Sair</a>
						</div>
					</div>
				</div>
			</div>
		</nav>
   
    	<div class="container">    	
 
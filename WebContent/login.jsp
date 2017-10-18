<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <title>Ficha Técnica - Login</title>
	    
	    <link rel="icon" href="img/iconutri.ico">
	
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/login.css">
	</head>

    <body>
    	<jsp:include page="template/modalSenha.jsp"></jsp:include>
    	
    	<div class="login-form">
    		<div class="login-form-header">
				<h1 class="title">Sistema de Ficha Técnica de Preparo</h1>
				<img src="img/logo-ftp.png" />
			</div>
			<div class="login-form-body">
				<form class="form-horizontal" method="post" action="main?acao=login">
					<div class="form-group">
						<div class="col-sm-12">
							<input type="text" class="form-control input-lg" placeholder="Usuário" id="login" name="login" value="${param.login}" maxlength="120" required />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-12">
							<input type="password" class="form-control input-lg" placeholder="Senha" id="senha" name="senha" value="${param.senha}" maxlength="15" required />
						</div>
					</div>
					<button class="btn btn-primary btn-lg btn-block" type="submit" style="margin-bottom: 12px">Entrar</button>
					<div class="col-sm-6"><a href="" style="color:#fff;text-decoration:underline" data-toggle="modal" data-id="login"  data-usuario="#login" data-target="#modalSenha">Esqueceu sua senha?</a></div>
					<div class="col-sm-6 text-right"><a href="#" style="color:#fff;text-decoration:underline">Cadastrar-se</a></div>
 				</form>
			</div>
    	</div>
    	
		<!-- <div class="container">
    	
    		<div class="panel panel-success panel-login">
    		
    			<div class="panel-heading text-center">
    				Sistema de Ficha Técnica de Preparo
    			</div>
                <div class="panel-body">                
    
    				<h1 class="welcome">Bem <span class="ages">V</span>indo!</h1>
    				<img src="img/logo-ftp.png" alt="Nutri" width="100%" height="70%">
    				<jsp:include page="/template/msg.jsp"></jsp:include>
 			         <form method="post" action="main?acao=login">
			         	<div class="form-group">
			            	<label class="form-label ages">Usuário:</label>
			            	<input class="form-control" id="login" name="login" value="${param.login}" type="text" maxlength="120" required>
		             	</div>
		             	<div class="form-group">
			            	<label class="form-label ages">Senha:</label>
			            	<input class="form-control" id="senha" name="senha" value="${param.senha}" type="password" maxlength="15" required>
		            	</div>
		            	<i class="glyphicon glyphicon-lock"></i>
		            	<a href="" data-toggle="modal" data-id="login"  data-usuario="#login" data-target="#modalSenha" title="Click para recuperar a senha senha"> Recuperar Senha</a>
		             	<hr>
			            <div class="text-center">
			             	<input class="btn btn-success login pull-center" type="submit" value="Entrar">
			         	</div>
			         </form>
			         
		         </div>
		         
	         </div>
        </div> -->
    </body>
    
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
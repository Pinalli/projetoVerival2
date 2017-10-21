<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Ficha T�cnica - Login</title><!-- T�tulo da p�gina -->
        <link rel="icon" href="img/iconutri.ico">

        <!-- JQUERY -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		
		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/bootstrap-theme.min.css">
		<script src="./js/bootstrap.min.js"></script>
		
		<!-- STYLE -->
		<link rel="stylesheet" href="./css/style.css">
		

    </head>
    
    
    <body>
		<div class="container">
    		
    		
   		
   		<!-- MODAL / POPUP -->
   		<jsp:include page="./template/modalSenha.jsp"></jsp:include>
    	
    		<div class="panel panel-success panel-login">
    		
    			<div class="panel-heading text-center">
    				Sistema de Ficha T�cnica de Preparo
    			</div>
                <div class="panel-body">                
    
    				<h1 class="welcome">Bem <span class="ages">V</span>indo!</h1>
    				<img src="img/logo-ftp.png" alt="Nutri" width="100%" height="70%">
    				<jsp:include page="/template/msg.jsp"></jsp:include>
 			         <form method="post" action="main?acao=login">
			         	<div class="form-group">
			            	<label class="form-label ages">Usu�rio:</label>
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
			         <br>
			         <form method="post" action="main?acao=newUser">
			         	<div class="text-center">
			             	<input class="btn btn-success login pull-center" type="submit" value="Cadastrar">
			         	</div>
			         </form>
		         </div>
		         
	         </div>
        </div>
    </body>
</html>
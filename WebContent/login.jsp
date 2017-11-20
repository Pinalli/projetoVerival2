<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ficha Técnica - Login</title>

    <link rel="icon" href="img/iconutri.ico">

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="">


    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>

<body>
<jsp:include page="template/modalSenha.jsp"></jsp:include>

<div class="login-form">
    <div class="login-form-header">
        <h1 class="title">Sistema de Ficha Técnica de Preparo</h1>
        <img src="img/sabor-e-preparo-logo-1.png" />
    </div>
    <div class="login-form-body">
    	<jsp:include page="template/msg.jsp"></jsp:include>
        <form class="form-horizontal" method="post" action="main?acao=login">
            <div class="form-group">
                <div class="input-group input-group-lg">
                    <input type="text" class="form-control" placeholder="Usuário" id="login" name="login" value="${param.login}" maxlength="120" required />
                </div>
            </div>
            <div class="form-group">
                <div class="input-group input-group-lg">
                    <input type="password" class="form-control" placeholder="Senha" id="senha" name="senha" value="${param.senha}" maxlength="15" required />
                </div>
            </div>
            <button class="btn btn-primary btn-lg btn-block" type="submit" style="margin-bottom: 12px">Entrar</button>
            <div class="row">
                <div class="col-6 col-md-6 col-sm-12">
                    <a href="newUser.jsp" class="text-light" id="novoCadastro" title="Clique para cadastrar uma nova conta">Novo cadastro</a>
                </div>
                <div class="col-6 col-md-6 col-sm-12 text-right">
                    <a class="text-light" href="#" data-toggle="modal" data-id="login" data-usuario="#login" data-target="#modalSenha" title="Clique para recuperar a sua senha">Recuperar senha</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
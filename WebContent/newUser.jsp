<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.bo.UsuarioBO"%>
<%@page import="br.ages.crud.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<head>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./css/style.css">
<script src="./js/bootstrap.min.js"></script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="js/mostrarsenha.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
</head>
<div class="container">    	
	<div class="panel panel-success panel-addUser">
	
		<div class="panel-heading text-center" id="cadastro-head">
			Cadastro de Usu�rio
		</div>
	
	
		<div class="panel-body">
	
			<jsp:include page="/template/msg.jsp"></jsp:include>
	
	
				<form method="post" action="main?acao=addUser">
	
					<div class="form-group">
					
						<label class="form-label ages">Nome: <span class="red">*</span></label> 
						<input class="form-control" id="nome" name="nome" value="${param.nome}" type="text" maxlength="120" required>
						
					    <label class="form-label ages">Usu�rio: <span class="red">*</span></label> 
						<input class="form-control" id="usuario" name="usuario" value="${param.usuario}" type="text" maxlength="120" required>
							
						<div class="row">
							<div class="col-sm-6">
							    <label class="form-label ages">Senha: <span class="red">*</span></label> 
								<input class="form-control" id="senha" name="senha" value="${param.senha}" type="password" maxlength="120" required>
							</div>
							<div class="col-sm-6">
								<label class="form-label ages">Confirmar senha: <span class="red">*</span></label> 
								<input class="form-control" id="confirmarSenha" name="confirmarSenha" value="${param.confirmarSenha}" type="password" maxlength="8" required> 
							</div>
							
							<div class="col-sm-12">
								<input type="checkbox" id="mostrar" alt="mostrar" style="margin-top: 10px; margin-left: 350px;"> Mostrar senha
							</div>
						</div>
						
						<label class="form-label ages">CPF: <span class="red">*</span></label> 
						<input class="form-control" id="cpf" name="cpf" value="${param.cpf}" type="text" placeholder="Ex: 000.000.000-00" required>
						
						<label class="form-label ages">E-mail: <span class="red">*</span></label> 
						<input class="form-control" id="email" name="email" value="${param.email}" type="text" maxlength="120" required>
						
						<label class="form-label ages">Endere�o: <span class="red">*</span></label> 
						<input class="form-control" id="endereco" name="endereco" value="${param.endereco}" type="text" maxlength="120" required>
							
							<div class="row">
							<div class="col-sm-6">
								<label class="form-label ages">Telefone: <span class="red">*</span></label> 
								<input class="form-control" id="telefone" name="telefone" value="${param.telefone}" type="text" required=""> 
							</div>
							
						</div>
						<label class="form-label ages">Tipo de Usu�rio: <span class="red">*</span></label> <select class="form-control" id="tipoUsuario" name="tipoUsuario" required>
							<%
								UsuarioBO usuarioBO = new UsuarioBO();
								List<TipoUsuario> listaTipoUsuarios = usuarioBO.listaTipoUsuarios();
								for (TipoUsuario tipoUsuario : listaTipoUsuarios) {
							%>
							<option value="<%=tipoUsuario.getIdTipoUsuario()%>"><%=tipoUsuario.getNome()%></option>
							<%
								}
							%>
						</select>
						
						
					</div>
					<p>
						Campos que cont�m <span class="red">*</span> s�o obrigat�rios
					</p>
					<div class="text-center">
						<input class="btn btn-warning limparUser pull-left" type="reset" value="Limpar"> 
						<input class="btn btn-success addUser pull-right" type="submit" value="Cadastrar">
					</div>
				</form>
		</div>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>
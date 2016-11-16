<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<%Usuario usuario = (Usuario) request.getAttribute("usuario"); %>

<jsp:include page="../template/head.jsp"></jsp:include>

<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="js/mostrarsenha.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
</head>

	
	<div class="panel panel-success panel-addUser">
    		
		<div class="panel-heading text-center">
			Editar Usuário
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
                
                <form method="post" action="main?acao=editUser">
                	<input class="form-control" type="hidden" id="idUsuario" name="idUsuario" value="<%=usuario.getIdUsuario()%>">
               		
               		<label class="form-label ages">Nome: <span class="red">*</span></label> 
					<input class="form-control" id="nome" name="nome" value="<%=usuario.getNome() %>" type="text" maxlength="120" required>
					
				    <label class="form-label ages">Usuário: <span class="red">*</span></label> 
					<input class="form-control" id="usuario" name="usuario" value="<%=usuario.getUsuario() %>"" type="text" maxlength="120" required>
						
					<div class="row">
						<div class="col-sm-6">
						    <label class="form-label ages">Senha: <span class="red">*</span></label> 
							<input class="form-control" id="senha" name="senha" value="<%=usuario.getSenha() %>"" type="password" maxlength="120" required>
						</div>
						<div class="col-sm-6">
							<label class="form-label ages">Confirmar senha: <span class="red">*</span></label> 
							<input class="form-control" id="confirmarSenha" name="confirmarSenha" value="<%=usuario.getSenha() %>"" type="password" maxlength="8" required> 
						</div>
						
						<div class="col-sm-12">
							<input type="checkbox" id="mostrar" alt="mostrar" style="margin-top: 10px; margin-left: 350px;"> Mostrar senha
						</div>
					</div>
					
					<label class="form-label ages">CPF: <span class="red">*</span></label> 
					<input class="form-control" id="cpf" name="cpf" value="<%=usuario.getCpf() %>"" type="text" placeholder="Ex: 000.000.000-20" required readonly="readonly">
					
					<label class="form-label ages">E-mail: <span class="red">*</span></label> 
					<input class="form-control" id="email" name="email" value="<%=usuario.getEmail() %>"" type="text" maxlength="120" required>
					
					<label class="form-label ages">Endereço: <span class="red">*</span></label> 
					<input class="form-control" id="endereco" name="endereco" value="<%=usuario.getEndereco() %>"" type="text" maxlength="120" required>
						
						<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages">Telefone: <span class="red">*</span></label> 
							<input class="form-control" id="telefone" name="telefone" value="<%=usuario.getTelefone() %>"" type="text" placeholder="Ex: (99) 9999-9999" required>
						</div>
						
					</div>
                    
			           	<label class="form-label ages">Perfil de Acesso: <span class="red">*</span></label>
			           	<select class="form-control" id="perfilAcesso" name="perfilAcesso" required>
                            <option value="NAVEGADOR" <%= "NAVEGADOR".equals(usuario.getPerfilAcesso().toString()) ? "selected" : "" %>>Navegador</option>
			           		<option value="ADMINISTRADOR" <%= "ADMINISTRADOR".equals(usuario.getPerfilAcesso().toString()) ? "selected" : "" %>>Administrador</option>
		           		</select>
		            
			           	<label class="form-label ages">Status: <span class="red">*</span></label>
			           	<select class="form-control" id="statusUsuario" name="statusUsuario" required>
			           		<option value="ATIVO" <%= "ATIVO".equals(usuario.getStatusUsuario().toString()) ? "selected" : "" %>>Ativo</option>
                            <option value="INATIVO" <%= "INATIVO".equals(usuario.getStatusUsuario().toString()) ? "selected" : "" %>>Inativo</option>
		           		</select>
		            
			           	<label class="form-label ages">Tipo de Usuário: <span class="red">*</span></label>
			           	<select class="form-control" id="tipoUsuario" name="tipoUsuario" required>
						<%
							List<TipoUsuario> listaTipoUsuarios = (List<TipoUsuario>) request.getAttribute("tipoUsuarios");
							for (TipoUsuario tipoUsuario : listaTipoUsuarios) {
						%>
						<option value="<%=tipoUsuario.getIdTipoUsuario()%>"<%=tipoUsuario.getIdTipoUsuario() == usuario.getTipoUsuario().getIdTipoUsuario() ? "selected" : "" %>><%=tipoUsuario.getNome()%></option>
						<%
							}
						%>           	
			           	</select>
                    
                    <hr>
                    
                    <p>Campos que contém <span class="red">*</span> são obrigatórios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-warning limparUser pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-success addUser pull-right" type="submit" value="Salvar">
			        </div>
              </form>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>

<div class="panel panel-success panel-addIngrediente">

	<div class="panel-heading text-center">Cadastro de Ingredientes</div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


			<form method="post" action="main?acao=addUser">

				<div class="form-group">
					<div class="row">
						<div class="col-sm-4">
							<label class="form-label ages"> Código: </span></label> 
							<input class="form-control" id="codigo" name="codigo"	value="${param.codigo}" type="text" maxlength="9" required> 
						</div>
						<div class="col-sm-8">
							<label class="form-label ages"> Descrição: </span></label> 
							<input class="form-control" id="descricao" name="descricao" value="${param.descricao}" type="text" maxlength="120" required>
						</div>
					</div>				
					
					<div class="row">						
						<div class="col-sm-4">
						    <label class="form-label ages">Carboidratos gramas </span></label> 
							<input class="form-control" id="usuario" name="usuario" value="${param.usuario}" type="text" maxlength="120" required>
						</div>
						<div class="col-sm-4">
							<label class="form-label ages">Proteinas gramas </span></label> 
							<input class="form-control" id="senha" name="senha" value="${param.senha}" type="text" maxlength="8" required> 
						</div>
						<div class="col-sm-4">
						    <label class="form-label ages">Lipidios gramas </span></label> 
							<input class="form-control" id="usuario" name="usuario" value="${param.usuario}" type="text" maxlength="120" required>
						</div>						
					</div>
					
					<div class="row">						
						<div class="col-sm-4">
						    <label class="form-label ages">Carboidratos Kcal </span></label> 
							<input class="form-control" id="usuario" name="usuario" value="${param.usuario}" type="text" maxlength="120" required>
						</div>
						<div class="col-sm-4">
							<label class="form-label ages">Proteinas Kcal </span></label> 
							<input class="form-control" id="senha" name="senha" value="${param.senha}" type="text" maxlength="8" required> 
						</div>
						<div class="col-sm-4">
						    <label class="form-label ages">Lipidios Kcal </span></label> 
							<input class="form-control" id="usuario" name="usuario" value="${param.usuario}" type="text" maxlength="120" required>
						</div>						
					</div>
					
					
					
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages"> Fator de Correção </span></label> 
							<input class="form-control" id="codigo" name="codigo"	value="${param.codigo}" type="text" maxlength="9" required> 
						</div>
						<div class="col-sm-6">
							<label class="form-label ages"> Índice de Cocção </span></label> 
							<input class="form-control" id="descricao" name="descricao" value="${param.descricao}" type="text" maxlength="120" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages"> Valor de Custo   </span></label> 
							<input class="form-control" id="descricao" name="descricao" value="${param.descricao}" type="text" maxlength="120" required>
						</div>
						<div class="col-sm-6">
							<label class="form-label ages"> Unidade de Medida</span></label> 
							<select class="form-control input-sm" id="descricao" name="descricao">
								<option value="Xc"> xícara</option>
								<option value="Xc"> colher de sopa</option>
								<option value="Xc"> colhar chá</option>
							</select>
						</div>
					</div>					
				</div>
				
				<div class="text-center">
					<input class="btn btn-default limpaIngrediente" type="reset" value="Limpar"> 
					<input class="btn btn-success addIngrediente" type="submit" value="Cadastrar">
				</div>
								
			</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

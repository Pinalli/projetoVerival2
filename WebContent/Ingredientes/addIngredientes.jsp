<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!--onkidonki-->
<jsp:include page="../template/head.jsp"></jsp:include>

<div class="panel panel-success panel-addUser">

	<div class="panel-heading text-center">Cadastro de Ingredientes</div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


			<form method="post" action="main?acao=addUser">

				<div class="form-group">
					<div class="row">
						<div class="col-sm-4">
							<label class="form-label ages"> Código: </span></label> 
							<input class="form-control" id="cod" name="cod"	value="${param.cod}" type="value" maxlength="5" required> 
						</div>
						<div class="col-sm-8">
							<label class="form-label ages"> Descrição: </span></label> 
							<input class="form-control" disabled = "true" id="descricao" name="descricao" value="${param.descricao}" type="text" maxlength="120" required>
						</div>
					</div>				
					
					<div class="row">						
						<div class="col-sm-4">
						    <label class="form-label ages">Carboidratos</span></label> 
							<input class="form-control" id="carboidratos" name="carboidratos" value="${param.carboidratos}" type="value" maxlength="5" required>
						</div>
						<div class="col-sm-8">
						    <label class="form-label ages">Carboidratos Kcal </span></label> 
							<input class="form-control" disabled = "true" id="kcalcarboidratos" name="kcalcarboidratos" value="teste" type="value" maxlength="120" required>
						</div>
					</div>
					
					<div class="row">					
						<div class="col-sm-4">
							<label class="form-label ages">Proteinas</span></label> 
							<input class="form-control"  id="proteinas" name="proteinas" value="${param.proteinas}" type="value" maxlength="5" required> 
						</div>
						<div class="col-sm-8">
							<label class="form-label ages">Proteinas Kcal </span></label> 
							<input class="form-control" disabled = "true" id="kcalproteinas" name="kcalproteinas" value="${param.kcalproteinas}" type="value" maxlength="5" required> 
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Lipidios</span></label> 
							<input class="form-control" id="lipidios" name="lipidios" value="${param.lipidios}" type="value" maxlength="5" required>
						</div>

						<div class="col-sm-8">
						    <label class="form-label ages">Lipidios Kcal </span></label> 
							<input class="form-control" disabled = "true" id="kcallipidios" name="kcallipidios" value="${param.kcallipidios}" type="valuet" maxlength="5" required>
						</div>					
					</div>
					
					
					
					
					
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages"> Fator de Correção </span></label> 
							<input class="form-control" id="fatorcorrecao" name="fatorcorrecao"	value="${param.fatorcorrecao}" type="value" maxlength="5" required> 
						</div>
						<div class="col-sm-6">
							<label class="form-label ages"> Índice de Cocção </span></label> 
							<input class="form-control" id="indicecoccao" name="indicecoccao" value="${param.descricao}" type="value" maxlength="5" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages"> Valor de Custo   </span></label> 
							<input class="form-control" id="custo" name="custo" value="${param.custo}" type="value" maxlength="5" required>
						</div>
						<div class="col-sm-6">
							<label class="form-label ages"> Unidade de Medida</span></label> 
							<select class="form-control input-sm" id="descricao" name="descricao">
								<option value="Xc"> Kg</option>
								<option value="Xc"> grama</option>
								<option value="Xc"> litro</option>
							</select>
						</div>
					</div>					
				</div>
				
				<div class="text-center">
					<input class="btn btn-default limpaIngrediente" type="reset" value="Limpar"> 
					<input class="btn btn-success addIngrediente pull-right" type="submit" value="Cadastrar">
				</div>
								
			</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

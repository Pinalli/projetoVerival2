<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.UnidadeMedida"%>
<%@page import="br.ages.crud.model.Ingrediente"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!--onkidonki-->
<jsp:include page="../template/head.jsp"></jsp:include>
<head>
	<script type="text/javascript" src="js/ingrediente.js"></script>
</head>

<div class="jumbotron mb-5">
	<h1 style="color: #787a89;"><span class="icon-adicionar text-info"></span> Cadastro de Ingredientes</h1>
	<hr />

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


			<form method="post" action="main?acao=addIngrediente">

				<div class="form-group">
					<div class="row">
						<div class="col-sm-4">
							<label class="form-label ages"> Código: </span></label> 
							<input class="form-control" id="cod" name="cod"	value="${param.cod}" type="value" maxlength="5" required> 
						</div>
						<div class="col-sm-8">
							<label class="form-label ages"> Descrição: </span></label> 
							<input class="form-control" id="descricao" name="descricao" value="${param.descricao}" type="text" maxlength="120" required>
						</div>
					</div>				
					
					<div class="row">						
						<div class="col-sm-4">
						    <label class="form-label ages">Carboidratos</span></label> 
							<input class="form-control" id="carboidratos" name="carboidratos" value="${param.carboidratos}" type="number" min="0" step="any" onInput="multiplica('Carboidrato')" maxlength="5" required>
						</div>
						<div class="col-sm-8">
						    <label class="form-label ages">Carboidratos Kcal </span></label> 
							<input class="form-control"  readonly="readonly" id="kcalcarboidratos" name="kcalcarboidratos" value="${param.kcalproteinas}" type="text" maxlength="120" required>
						</div>
					</div>
					
					<div class="row">					
						<div class="col-sm-4">
							<label class="form-label ages">Proteinas</span></label> 
							<input class="form-control"  id="proteinas" name="proteinas" value="${param.proteinas}" type="number" min="0" step="any" onInput="multiplica('Proteinas')" maxlength="5" required>
						</div>
						<div class="col-sm-8">
							<label class="form-label ages">Proteinas Kcal </span></label> 
							<input class="form-control"  readonly="readonly" id="kcalproteinas" name="kcalproteinas" value="${param.kcalproteinas}" type="text" maxlength="5" required> 
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Lipidios</span></label> 
							<input class="form-control" id="lipidios" name="lipidios" value="${param.lipidios}" type="number" min="0" step="any"  onInput="multiplica('Lipidios')" maxlength="5" required>
						</div>

						<div class="col-sm-8">
						    <label class="form-label ages">Lipidios Kcal </span></label> 
							<input class="form-control" readonly="readonly" id="kcallipidios" name="kcallipidios" value="${param.kcallipidios}" type="text" maxlength="5" required>
						</div>					
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Gordura Saturada</span></label> 
							<input class="form-control" id="godurasaturada" name="gordurasaturada" value="${param.gordurasaturada}" type="number"min="0" step="any"  maxlength="5" required>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Fibras Alimentares</span></label> 
							<input class="form-control" id="fibrasalimentares" name="fibrasalimentares" value="${param.fibrasalimentares}" type="number" step="any"  maxlength="5" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Sódio</span></label>
							<input class="form-control" id="sodio" name="sodio" value="${param.sodio}" type="number" min="0" step="any"  maxlength="5" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages"> Unidade de Medida</span></label> 
							<select class="form-control input-sm" id="unidadeMedida" name="unidadeMedida">
								<%
									List<UnidadeMedida> listaUnidadesMedida = (List<UnidadeMedida>) request.getAttribute("listaUnidadesMedida");
									for (UnidadeMedida unidadeMedida : listaUnidadesMedida) {
								%>
									<option value="<%=unidadeMedida.getUnidadeMedida()%>"><%=unidadeMedida.getUnidadeMedida()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
				</div>
				
				<div class="text-center">
					<input class="btn btn-warning limpaIngrediente" type="reset" value="Limpar"> 
					<input class="btn btn-success addIngrediente pull-right" type="submit" value="Cadastrar">
				</div>
								
			</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

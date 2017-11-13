<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.UnidadeMedida"%>
<%@page import="br.ages.crud.model.Ingrediente"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="../template/head.jsp"></jsp:include>
<head>
	<script type="text/javascript" src="js/ingrediente.js"></script>
</head>
<%Ingrediente ingrediente = (Ingrediente) request.getAttribute("ingrediente"); %>
<div class="panel panel-success panel-addUser">

	<div class="panel-heading text-center">Editar Ingrediente <b><%=ingrediente.getDescricao()%></b></div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


			<form method="post" action="main?acao=editIngrediente">
				<input class="form-control" type="hidden" id="idIngrediente" name="idIngrediente" value="<%=ingrediente.getId()%>">
				<div class="form-group">
					<div class="row">
						<div class="col-sm-4">
							<label class="form-label ages"> Código: </span></label> 
							<input class="form-control" id="cod" name="cod"	value="<%=ingrediente.getCodigo()%>" type="value" maxlength="5" required> 
						</div>
						<div class="col-sm-8">
							<label class="form-label ages"> Descrição: </span></label> 
							<input class="form-control" id="descricao" name="descricao" value="<%=ingrediente.getDescricao()%>" type="text" maxlength="120" required>
						</div>
					</div>				
					
					<div class="row">						
						<div class="col-sm-4">
						    <label class="form-label ages">Carboidratos</span></label> 
							<input class="form-control" id="carboidratos" name="carboidratos" value="<%=ingrediente.getCarboidratos() %>" type="number" step="any" onInput="multiplica('Carboidrato')" maxlength="5" required>
						</div>
						<div class="col-sm-8">
						    <label class="form-label ages">Carboidratos Kcal </span></label> 
							<input class="form-control"  readonly="readonly" id="kcalcarboidratos" name="kcalcarboidratos" value="<%=ingrediente.getKcalCarboidratos() %>" type="text" maxlength="120" required>
						</div>
					</div>
					
					<div class="row">					
						<div class="col-sm-4">
							<label class="form-label ages">Proteinas</span></label> 
							<input class="form-control"  id="proteinas" name="proteinas" value="<%=ingrediente.getProteinas() %>" type="number" step="any" onInput="multiplica('Proteinas')" maxlength="5" required> 
						</div>
						<div class="col-sm-8">
							<label class="form-label ages">Proteínas Kcal </span></label> 
							<input class="form-control"  readonly="readonly" id="kcalproteinas" name="kcalproteinas" value="<%=ingrediente.getKcalProteinas() %>" type="text" maxlength="5" required> 
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Lipídios</span></label> 
							<input class="form-control" id="lipidios" name="lipidios" value="<%=ingrediente.getLipidios() %>" type="number" step="any" onInput="multiplica('Lipidios')" maxlength="5" required>
						</div>

						<div class="col-sm-8">
						    <label class="form-label ages">Lipídios Kcal </span></label> 
							<input class="form-control" readonly="readonly" id="kcallipidios" name="kcallipidios" value="<%=ingrediente.getKcalLipidios()%>" type="text" maxlength="5" required>
						</div>					
					</div>
					
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Gordura Saturada</span></label> 
							<input class="form-control" id="godurasaturada" name="gordurasaturada" value="<%=ingrediente.getGorduraSaturada()%>" type="number" step="any"  maxlength="5" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Gordura Trans</span></label> 
							<input class="form-control" id="goduratrans" name="gorduratrans" value="<%=ingrediente.getGorduraTrans()%>" type="number" step="any"  maxlength="5" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Fibras Alimentares</span></label> 
							<input class="form-control" id="fibrasalimentares" name="fibrasalimentares" value="<%=ingrediente.getFibrasAlimentares()%>" type="number" step="any"  maxlength="5" required>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-4">
						    <label class="form-label ages">Sódio</span></label> 
							<input class="form-control" id="sodio" name="sodio" value="<%=ingrediente.getSodio()%>" type="number" step="any"  maxlength="5" required>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<label class="form-label ages"> Valor de Custo   </span></label> 
							<input class="form-control" id="custo" name="custo" value="<%=ingrediente.getCusto()%>" type="value" maxlength="5" required>
						</div>
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
					<input class="btn btn-success addIngrediente pull-right" type="submit" value="Salvar">
				</div>
								
			</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

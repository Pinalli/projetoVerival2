<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="br.ages.crud.model.Ficha"%>	
<%@page import="br.ages.crud.model.FichaItem"%>	
<%Ficha ficha = (Ficha) request.getAttribute("ficha"); %>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<jsp:include page="../template/modalFichaCompleta.jsp"></jsp:include>

<head>
<!--link rel="stylesheet" href="./css/ficha.css"-->
<script type="text/javascript" src="js/fichaCompletaCalculos.js"></script>
<script type="text/javascript">	window.onload = multiplica('cho'), multiplica('ptn'), multiplica('lip'), multiplica('kcal')	</script>
</head>
<body>
	<article>
		<form name="editFichaTecnicaCompleta" id="editFichaTecnicaCompletaForm" method="post" action="ajax?acao=editFichaCompletaAjaxCommand">
			<input type="hidden" name="idFicha" id="idFicha" value="<%=ficha.getIdFicha()%>"/>
			<div class="form-group col-md-4 col-md-offset-4">
				<input type="text" name="nome" id="nome"
					class="form-control text-center box-transparent"
					placeholder="Digite o nome da receita" 
					value="<%=ficha.getNome()%>"/>
			</div>

			<!-- File Button -->
				<div class="form-group col-md-12">
					<!--label class="col-md-3 control-label ages" for="Foto"></label-->
					<div class="col-md-6 col-md-offset-4 col-xs-offset-3">
						<input id="imgFile" name="imgFile" class="input-file" type="file" value="<%= ficha.getFoto() %>">
					</div>
				</div>
				<div class="form-group col-md-12">
					<div id="image_preview">
						<img id="previewing" style="width: 150px; height: 150px;" src="upload/fichas/ficha-<%= ficha.getIdFicha() %>/<%= ficha.getFoto()%>"
							class="img-responsive img-thumbnail center-block" />
					</div>
				</div>
				<h4 id='loading'></h4>
				<div id="message"></div>


				<div class="col-md-4 col-md-offset-4">
					<label for="rendimento"
						class="col-xs-12 col-sm-12 form-control-static text-center">Rendimento</label>
					<input type="text" name="rendimento" id="rendimento"
						class="form-control text-center box-transparent"
						placeholder="Rendimento" value="<%=ficha.getRendimento()%>"/>
				</div>

				<div class="col-md-4 col-md-offset-4">
   					<label for="tempoPreparo"
   						class="col-xs-12 col-sm-12 form-control-static text-center">Tempo de preparo</label>

   					<input type="text" name="tempoPreparo" id="tempoPreparo"
   						class="form-control text-center box-transparent"
   						placeholder="Tempo de Preparo" value="<%=ficha.getTempoPreparo()%>" />
   				</div>


			<div class="row">
				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
			</div>

			<div class="row" id="table-rows">
					
					<%
						if(ficha.getItens().size() > 0){
							for(int i = 0; i < ficha.getItens().size(); i++) {
							FichaItem item = ficha.getItens().get(i);
					%>
				<div class="table-row" style="width: 100%; float: left; margin-bottom: 5px;">
					<input type="hidden" name="idFichaItem" id="idFichaItem" value="<%= item.getIdFichaItem() %>"/>
					<input type="hidden" name="idFicha" id="idFicha" value="<%= item.getIdFicha() %>"/>
					<input type="hidden" name="operacao" id="operacao" value="u"/>
					<div class="panel panel-info" style="margin-top:20px">
						<div class="panel-heading show-item-btn" id="ingrediente-1">Ingrediente</div>
					</div>

					<div class="col-md-12 item-wrapper">
						<div
							class="form-group col-md-2 col-sm-12 col-xs-12 col-md-offset-1">
							<label for="select-ingredientes" class="">Ingrediente</label> <select
								id="select-ingredientes" name="select-ingredientes"
								data-live-search="true" class="form-control selectBatata"
								data-selected-id="<%= item.getIdIngrediente() %>" 
								data-selected-text="<%= item.getIngrediente() %>">
							</select>
						</div>

						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-unidade-medida" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-unidade-medida"
								placeholder="Qnt" min="0" max="9999" step="any" 
								name="qnt-unidade-medida"
								value="<%= item.getQuantidadeUnidadeMedida()%>">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-unidade-medida" class="">Unidade de
								medida</label> <select id="select-unidade-medida"
								name="select-unidade-medida" data-native-menu="false"
								class="form-control selectBatata"
								data-selected-id="<%= item.getIdUnidadeMedida() %>"
								data-selected-text="<%= item.getUnidadeMedida() %>">
							</select>
						</div>
						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-medida-caseira" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-medida-caseira"
								placeholder="Qnt" min="0" max="9999" step="any"
								name="qnt-medida-caseira"
								value="<%= item.getQuantidadeMedidaCaseira()%>">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-medida-caseira" class="">Medida
								caseira</label> <select id="select-medida-caseira"
								name="select-medida-caseira" data-native-menu="false"
								class="form-control selectBatata"
								data-selected-id="<%= item.getIdMedidaCaseira()%>" 
								data-selected-text="<%= item.getUnidadeMedidaCaseira() %>">
							</select>
						</div>
						<!--div class="form-group col-md-12"-->
							<div class="form-group col-md-2 col-xs-4">
								<label for="cho" class="">CHO</label> 
								<input type="hidden" class="form-control" id="cho" placeholder="CHO" readonly>
								<input type="number" class="form-control" id="choShow" placeholder="CHO" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="ptn" class="">PTN</label> 
								<input type="hidden" class="form-control" id="ptn"	placeholder="PTN" readonly>
								<input type="number" class="form-control" id="ptnShow" placeholder="PTN" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="lip" class="">LIP</label> 
								<input type="hidden" class="form-control" id="lip" placeholder="LIP"  readonly>
								<input type="number" class="form-control" id="lipShow" placeholder="LIP"  readonly>								
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="kcal" class="">Kcal</label> 
								<input type="hidden" class="form-control" id="kcal" placeholder="Kcal"  readonly>
								<input type="number" class="form-control" id="kcalShow" placeholder="Kcal"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="valor-unitario" class="">Valor unit�rio</label> 
								<input	type="hidden" class="form-control"	id="valor-unitario" placeholder="Valor unit�rio"  readonly>
								<input	type="number" class="form-control"	id="valor-unitarioShow" placeholder="Valor unit�rio"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo real</label>
								<input type="hidden" class="form-control" id="custo-real" placeholder="Custo real" readonly>
								<input type="number" class="form-control" id="custo-realShow" placeholder="Custo real" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de corre��o</label>
								<input type="hidden" class="form-control" id="fator-de-correcao" placeholder="Fator de corre��o" readonly>
								<input type="number" class="form-control" id="fator-de-correcaoShow" placeholder="Fator de corre��o" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">�ndice de coc��o</label>
								<input type="hidden" class="form-control" id="indice-de-coccao" placeholder="�ndice de Coc��o"  readonly>
								<input type="number" class="form-control" id="indice-de-coccaoShow" placeholder="�ndice de Coc��o"  readonly>
							</div>
						<!--/div-->
						<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="btn-excluir-wrapper">
							<button class="btn btn-danger delete-row pull-right" style="padding-left:22px;padding-right:23px;">Excluir</button>
						</div>
						</div>
					</div>

				</div>
				<% }
							}else{ %>
				<div class="table-row" style="width: 100%; float: left; margin-bottom: 5px;">
					<input type="hidden" name="idFichaItem" id="idFichaItem" value="0"/>
					<input type="hidden" name="idFicha" id="idFicha" value="<%= ficha.getIdFicha() %>"/>
					<input type="hidden" name="operacao" id="operacao" value="c"/>
					<div class="panel panel-info">
						<div class="panel-heading show-item-btn" id="ingrediente-1">Ingrediente</div>
					</div>

					<div class="col-md-12 item-wrapper">
						<div
							class="form-group col-md-2 col-sm-12 col-xs-12 col-md-offset-1">
							<label for="select-ingredientes" class="">Ingrediente</label> <select
								id="select-ingredientes" name="select-ingredientes"
								data-live-search="true" class="form-control selectBatata" data-selected-id=""  data-selected-text="">
							</select>
						</div>

						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-unidade-medida" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-unidade-medida"
								onInput="multiplica('cho'), multiplica('ptn'), multiplica('lip'), multiplica('kcal')"
								placeholder="Qnt" min="0.001" max="9999" name="qnt-unidade-medida"
								value="">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-unidade-medida" class="">Unidade de
								medida</label> <select id="select-unidade-medida"
								name="select-unidade-medida" data-native-menu="false"
								class="form-control selectBatata"
								data-selected-id=""
								data-selected-text="">
							</select>
						</div>
						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-medida-caseira" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-medida-caseira"
								placeholder="Qnt" min="0.001" max="9999" step="0.001"
								name="qnt-medida-caseira"
								value="">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-medida-caseira" class="">Medida
								caseira</label> <select id="select-medida-caseira"
								name="select-medida-caseira" data-native-menu="false"
								class="form-control selectBatata"
								data-selected-id="" 
								data-selected-text="">
							</select>
						</div>
						<!--div class="form-group col-md-12"-->
							<div class="form-group col-md-2 col-xs-4">
								<label for="cho" class="">CHO</label> 
								<input type="hidden" class="form-control" id="cho" placeholder="CHO" readonly>
								<input type="number" class="form-control" id="choShow" placeholder="CHO" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="ptn" class="">PTN</label> 
								<input type="hidden" class="form-control" id="ptn"	placeholder="PTN" readonly>
								<input type="number" class="form-control" id="ptnShow" placeholder="PTN" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="lip" class="">LIP</label> 
								<input type="hidden" class="form-control" id="lip" placeholder="LIP"  readonly>
								<input type="number" class="form-control" id="lipShow" placeholder="LIP"  readonly>								
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="kcal" class="">Kcal</label> 
								<input type="hidden" class="form-control" id="kcal" placeholder="Kcal"  readonly>
								<input type="number" class="form-control" id="kcalShow" placeholder="Kcal"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="valor-unitario" class="">Valor unit�rio</label> 
								<input	type="hidden" class="form-control"	id="valor-unitario" placeholder="Valor unit�rio"  readonly>
								<input	type="number" class="form-control"	id="valor-unitarioShow" placeholder="Valor unit�rio"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo real</label>
								<input type="hidden" class="form-control" id="custo-real" placeholder="Custo real" readonly>
								<input type="number" class="form-control" id="custo-realShow" placeholder="Custo real" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de corre��o</label>
								<input type="hidden" class="form-control" id="fator-de-correcao" placeholder="Fator de corre��o" readonly>
								<input type="number" class="form-control" id="fator-de-correcaoShow" placeholder="Fator de corre��o" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">�ndice de coc��o</label>
								<input type="hidden" class="form-control" id="indice-de-coccao" placeholder="�ndice de Coc��o"  readonly>
								<input type="number" class="form-control" id="indice-de-coccaoShow" placeholder="�ndice de Coc��o"  readonly>
							</div>
						<!--/div-->
						<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="btn-excluir-wrapper">
							<button class="btn btn-danger delete-row pull-right" style="padding-left:22px;padding-right:23px;">Excluir</button>
						</div>
						</div>
					</div>

				</div>
				<% } %>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="col-md-2 col-md-offset-8">
						<a class="btn btn-success pull-right" id="add-row-btn">Novo item</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading row text-center trigger-display" data-target="informacoes-content">
					Informa��es de prepara��o
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group hide" id="informacoes-content">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="utensilios-equipamentos-content">Utens�lios e equipamentos</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="utensilios-equipamentos-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control" name="utensiliosEquipamentos"><%=ficha.getUtensilios()%></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="modo-preparo-content">Modo de preparo</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modo-preparo-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12">	</label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"><%=ficha.getModoPreparo()%></textarea><br>
							</div>
						</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="montagem-content">Montagem</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="montagem-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="montagem"><%=ficha.getMontagem()%></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="orientacoes-armazenamento-content">Orienta��es de
								armazenamento</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="orientacoes-armazenamento-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="orientacaoArmazenamento"><%=ficha.getOrientacoesArmazenamento()%></textarea>
							</div>
						</div>
					</div>
				</div>
			<div class="row"></div>

			<div class="panel panel-info">
				<div class="panel-heading row text-center trigger-display" data-target="avaliacao-sensorial-content">Avalia��o sensorial</div>
			</div>
			<div class="col-md-12">
				<div class="form-group hide" id="avaliacao-sensorial-content">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="textura-content">Textura</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="textura-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="textura"><%=ficha.getTextura()%></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="sabor-content">Sabor</div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="sabor-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="sabor"><%=ficha.getSabor()%></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="apresentacao-content">Apresenta��o</div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="apresentacao-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="apresentacao"><%=ficha.getApresentacao()%></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="temperatura-content">Temperatura</div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="temperatura-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control" name="temperatura"><%=ficha.getTemperatura()%></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
			</div>
			<div class="row">
				<div class="col-md-9 col-md-offset-1">
					<div class="form-group">
						<input type="reset" value="Limpar"
							class="btn btn-warning pull-left col-md-2 col-sm-2 col-xs-5" />
						<input type="submit" value="Salvar"
							class="btn btn-success pull-right col-md-9 col-sm-9 col-xs-5" />
					</div>
				</div>
			</div>
		</form>

	</article>

	<!--footer>Ficha T�cnica Completa</footer-->

</body>
<script src="./js/fichaCompleta/telaEditFichaCompleta.js"></script>
<script src="./js/fichaCompleta/editFichaCompleta.js"></script>



<jsp:include page="/template/foot.jsp"></jsp:include>
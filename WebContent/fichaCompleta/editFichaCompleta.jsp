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

			<div class="row">
				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
			</div>

			<div class="row" style="text-align: center;">
				<div class="container" style="width: 640px;">
					<h2>Informa��o Nutricional</h2>
						<div class="row">
							<div class="col-sm-2">
								<label for="qnt-unidade-medida-rotulo" class="">Por��o</label> 
								<input type="number" class="form-control" id="qnt-unidade-medida-rotulo"
									placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida-rotulo"
									onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
							</div>
							<div class="col-sm-4">
								<label for="select-unidade-medida" class="">Unidadede medida</label> 
								<select id="select-unidade-medida-rotulo"
									name="select-unidade-medida-rotulo" data-native-menu="false"
									class="form-control selectBatata">
								</select>
							</div>
							<div class="col-sm-2">
								<label for="qnt-unidade-medida-caseira-rotulo" class="">Por��o</label>
								<input type="number" class="form-control" id="qnt-unidade-medida-caseira-rotulo"
									placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida-caseira-rotulo"
									onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
							</div>
							<div class="col-sm-4">
								<label for="select-medida-caseira-rotulo" class="">Medida Caseira</label> 
								<select id="select-medida-caseira-rotulo"
									name="select-medida-caseira-rotulo" data-native-menu="false"
									class="form-control selectBatata">
								</select>
							</div>
						</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th colspan="2" style="text-align: center;">Quantidade por por��o</th>
								<th style="text-align: center;">%VD (*)</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Valor Energ�tico</td>
								<td id="valorEnergeticoQP" style="min-width: 150px;"></td>
								<td id="valorEnergeticoVD" style="min-width: 150px;"></td>
							</tr>
							<tr>
								<td>Carboidratos</td>
								<td id="carboidratosQP"></td>
								<td id="carboidratosVD"></td>
							</tr>
							<tr>
								<td>Proteinas</td>
								<td id="proteinasQP"></td>
								<td id="proteinasVD"></td>
							</tr>
							<tr>
								<td>Gorduras totais</td>
								<td id="gordTotalQP"></td>
								<td id="gordTotalVD"></td>
							</tr>
							<tr>
								<td>Gorduras saturadas</td>
								<td id="gordSaturadaQP"></td>
								<td id="gordSaturadaVD"></td>
							</tr>
							<tr>
								<td>Gorduras trans</td>
								<td id="gordTransQP"></td>
								<td id="gordTransVD">-</td>
							</tr>
							<tr>
								<td>Fibra alimentar</td>
								<td id="fibraAlimQP"></td>
								<td id="fibraAlimVD"></td>
							</tr>
							<tr>
								<td>S�dio</td>
								<td id="sodioQP"></td>
								<td id="sodioVD"></td>
							</tr>
						</tbody>
						<tfoot>
							<tr style="background-color: #f9f9f9;">
								<td colspan="3">(*) % Valores Di�rios com base em uma dieta
									de 2.000 kcal ou 8400 KJ. Seus valores di�rios podem ser
									maiores ou menores dependendo de suas necessidades energ�ticas.</td>
							</tr>
						</tfoot>
					</table>
				</div>
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
					<div class="panel panel-info">
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
								placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida"
								onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);"
								value="<%= item.getQuantidadeUnidadeMedida()%>">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-unidade-medida" class="">Unidadede
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
								placeholder="Qnt" min="0.1" max="100" step="0.1"
								name="qnt-medida-caseira" onKeyDown="limitText(this,4);"
								onKeyUp="limitText(this,4);"
								value="<%= item.getQuantidadeMedidaCaseira()%>">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-medida-caseira" class="">Medida
								Caseira</label> <select id="select-medida-caseira"
								name="select-medida-caseira" data-native-menu="false"
								class="form-control selectBatata"
								data-selected-id="<%= item.getIdMedidaCaseira()%>" 
								data-selected-text="<%= item.getUnidadeMedidaCaseira() %>">
							</select>
						</div>
						<!--div class="form-group col-md-12"-->
							<div class="form-group col-md-1 col-xs-4">
								<label for="cho" class="">CHO</label> 
								<input type="number" class="form-control" id="cho" placeholder="CHO" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="ptn" class="">PTN</label> <input type="number"
									class="form-control" id="ptn"
									placeholder="PTN" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="lip" class="">LIP</label> <input type="number"
									 class="form-control" id="lip"
									placeholder="LIP"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="kcal" class="">Kcal</label> <input type="number"
									class="form-control" id="kcal"
									placeholder="Kcal"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="valor-unitario" class="">Valor Unit�rio</label> <input
									type="number" class="form-control"
									id="valor-unitario" placeholder="Valor unit�rio"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo Real</label> <input
									type="number" class="form-control"
									id="custo-real" placeholder="Custo real" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de
									Corre��o</label> <input type="number"
									class="form-control" id="fator-de-correcao"
									placeholder="Fator de corre��o" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">�ndice de Coc��o</label>
								<input type="number" class="form-control"
									id="indice-de-coccao" placeholder="�ndice de Coc��o"  readonly>
							</div>
							<input type="number" class="hidden" id="gordura-trans">
							<input type="number" class="hidden" id="gordura-saturada">
							<input type="number" class="hidden" id="fibra-alimentar">
							<input type="number" class="hidden" id="sodio">
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
								placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida"
								onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);"
								value="">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-unidade-medida" class="">Unidadede
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
								placeholder="Qnt" min="0.1" max="100" step="0.1"
								name="qnt-medida-caseira" onKeyDown="limitText(this,4);"
								onKeyUp="limitText(this,4);"
								value="">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-medida-caseira" class="">Medida
								Caseira</label> <select id="select-medida-caseira"
								name="select-medida-caseira" data-native-menu="false"
								class="form-control selectBatata"
								data-selected-id="" 
								data-selected-text="">
							</select>
						</div>
						<!--div class="form-group col-md-12"-->
							<div class="form-group col-md-1 col-xs-4">
								<label for="cho" class="">CHO</label> 
								<input type="number" class="form-control" id="cho" placeholder="CHO" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="ptn" class="">PTN</label> <input type="number"
									class="form-control" id="ptn"
									placeholder="PTN" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="lip" class="">LIP</label> <input type="number"
									 class="form-control" id="lip"
									placeholder="LIP"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="kcal" class="">Kcal</label> <input type="number"
									class="form-control" id="kcal"
									placeholder="Kcal"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="valor-unitario" class="">Valor Unit�rio</label> <input
									type="number" class="form-control"
									id="valor-unitario" placeholder="Valor unit�rio"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo Real</label> <input
									type="number" class="form-control"
									id="custo-real" placeholder="Custo real" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de
									Corre��o</label> <input type="number"
									class="form-control" id="fator-de-correcao"
									placeholder="Fator de corre��o" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">�ndice de Coc��o</label>
								<input type="number" class="form-control"
									id="indice-de-coccao" placeholder="�ndice de Coc��o"  readonly>
							</div>
							<input type="number" class="hidden" id="gordura-trans">
							<input type="number" class="hidden" id="gordura-saturada">
							<input type="number" class="hidden" id="fibra-alimentar">
							<input type="number" class="hidden" id="sodio">
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
								<textarea rows="10" cols="" class="form-control"
								name="utensiliosEquipamentos"></textarea>
							</div>
						</div>
					</div>
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="modo-preparo-content">Modo de Preparo</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modo-preparo-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"><%=ficha.getModoPreparo()%></textarea><br>
									<label class="text-center">Tempo de Preparo
									<input class="form-control text-left col-md-12 col-sm-12 col-xs-12" vertical-align="right" id="tempoPreparo" 
									name="tempoPreparo" value="" type="text" maxlength="15">
								</label>
							</div>
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
							<div class="panel-heading trigger-display" data-target="orientacoes-armazenamento-content">Orienta��es e
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
									name="apresentacao"><%=ficha.getApresentacao()%></textarea><br><label class="text-center">Temperatura
									<input class="text-center col-md-12 col-sm-12 col-xs-12" vertical-align="right" id="temperatura" name="temperatura" 
									value="" type="text" maxlength="15">
								</label>
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
		</form>

	</article>

	<!--footer>Ficha T�cnica Completa</footer-->

</body>
<script src="./js/fichaCompleta/telaEditFichaCompleta.js"></script>
<script src="./js/fichaCompleta/editFichaCompleta.js"></script>
<script src="./js/fichaCompleta/rotulo.js"></script>

<script type="text/javascript">
	function limitText(limitField, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		}
	}
</script>

<jsp:include page="/template/foot.jsp"></jsp:include>
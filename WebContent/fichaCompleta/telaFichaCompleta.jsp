<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<head>
<!--link rel="stylesheet" href="./css/ficha.css"-->
</head>
<body>
	<article>
		<form name="addFichaTecnicaSimples" method="post"
			action="main?acao=addFichaSimplificada">
			<div class="form-group col-md-4 col-md-offset-4">
				<input type="text" name="nome" id="nome"
					class="form-control text-center box-transparent"
					placeholder="Digite o nome da receita" />
			</div>

			<!-- File Button -->
			<div class="form-group col-md-12 col-md-offset-2	">
				<label class="col-md-3 control-label ages" for="Foto"></label>
				<div class="col-md-6">
					<input id="imgFile" name="imgFile" class="input-file" type="file">
				</div>
			</div>
			<div class="form-group col-md-12">
				<div id="image_preview">
					<img id="previewing" src=""
						class="img-responsive img-thumbnail center-block" />
				</div>
			</div>
			<h4 id='loading'></h4>
			<div id="message"></div>


			<div class="col-xs-6 col-sm-4">
				<label for="rendimento"
					class="col-md-12 col-md-offset-9 form-control-static">Rendimento</label>
			</div>
			<div class="col-xs-6 col-sm-4">
				<input type="text" name="rendimento" id="rendimento"
					class="form-control text-center box-transparent"
					placeholder="Rendimento" />
			</div>
			<div class="col-xs-6 col-sm-4">
				<label for="tempoPreparo" class="col-md-12 col-md-offset-9 form-control-static">Tempo de Preparo</label>
			</div>
			<div class="col-xs-6 col-md-4">
				<input type="text" name="tempoPreparo" id="tempoPreparo" class="form-control text-center box-transparent"
				placeholder="Tempo de Preparo"/>
			</div>

			<div class="row">
				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
			</div>


			<div class="row" id="table-rows">
				<div class="table-row"
					style="width: 100%; float: left; margin-bottom: 5px;">

					<div class="panel panel-info">
						<div class="panel-heading show-item-btn" id="ingrediente-1">Ingrediente</div>
					</div>

					<div class="col-md-12 item-wrapper">
						<div
							class="form-group col-md-2 col-sm-12 col-xs-12 col-md-offset-1">
							<label for="select-ingredientes" class="">Ingrediente</label> <select
								id="select-ingredientes" name="select-ingredientes"
								data-live-search="true" class="form-control selectBatata">
							</select>
						</div>

						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-unidade-medida" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-unidade-medida"
								placeholder="Qnt" min="0" max="9999" step="any" name="qnt-unidade-medida">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-unidade-medida" class="">Unidade de
								medida</label> <select id="select-unidade-medida"
								name="select-unidade-medida" data-native-menu="false"
								class="form-control selectBatata">
							</select>
						</div>
						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-medida-caseira" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-medida-caseira"
								placeholder="Qnt" min="0" max="9999" step="any"
								name="qnt-medida-caseira">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-medida-caseira" class="">Medida
								Caseira</label> <select id="select-medida-caseira"
								name="select-medida-caseira" data-native-menu="false"
								class="form-control selectBatata">
							</select>
						</div>
						<div class="form-group col-md-12">
							<div class="form-group col-md-2 col-xs-4">
								<label for="cho" class="">CHO</label> <input type="number"
									readonly="readonly" class="form-control" id="cho"
									placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="ptn" class="">PTN</label> <input type="number"
									readonly="readonly" class="form-control" id="ptn"
									placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="lip" class="">LIP</label> <input type="number"
									readonly="readonly" class="form-control" id="lip"
									placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="kcal" class="">Kcal</label> <input type="number"
									readonly="readonly" class="form-control" id="kcal"
									placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="valor-unitario" class="">Valor Unitário</label> <input
									type="number" readonly="readonly" class="form-control"
									id="valor-unitario" placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo Real</label> <input
									type="number" readonly="readonly" class="form-control"
									id="custo-real" placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de
									Correção</label> <input type="number" 
									class="form-control" id="fator-de-correcao"
									placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">Índice de Cocção</label>
								<input type="number" class="form-control"
									id="indice-de-coccao" placeholder="Import">
							</div>
						</div>
						<div class="form-group col-md-1 btn-excluir-wrapper"></div>
					</div>

				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="col-md-2 col-md-offset-8">
						<a class="btn btn-success pull-right" id="add-row-btn">Adicionar</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading row text-center" id="mdpreparo7">Informações
					de preparação</div>
			</div>
			<div class="col-md-12">
				<div class="form-group hide" id="modoprep7">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="tempoPreparo">Tempo de Preparo</div>
						</div>
					<div class="col-md-9 col-md-offset-1">
						<div class="form-group hide" id="tempoPreparo">
							<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
							<textarea rows="10" cols="" class="form-control" name="tempPreparo"></textarea>
						</div>
					</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="mdpreparo">Modo de Preparo</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modoprep">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="mdpreparo1">Montagem</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modoprep1">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="mdpreparo2">Orientações e
								armazenamento</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modoprep2">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row"></div>

			<div class="panel panel-info">
				<div class="panel-heading row text-center" id="mdpreparo6">Avaliação
					sensorial</div>
			</div>
			<div class="col-md-12">
				<div class="form-group hide" id="modoprep6">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="mdpreparo3">Textura</div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modoprep3">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="mdpreparo4">Sabor</div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="modoprep4">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading" id="mdpreparo5">Apresentação</div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="modoprep5">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
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

	<!--footer>Ficha Técnica Completa</footer-->

</body>
<script src="./js/fichaCompleta/telaFichaCompleta.js"></script>


<jsp:include page="/template/foot.jsp"></jsp:include>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<head>
<!--link rel="stylesheet" href="./css/ficha.css"-->
<style>
.horizontal-divider {
	height: 1px;
	float: left;
	width: 100%;
	margin: 25px 0;
	background: #CCC;
}

.horizontal-divider-sm {
	height: 1px;
	float: left;
	width: 100%;
	margin: 5px 0;
	background: #CCC;
}

.select2-selection--single {
	display: block !important;
	width: 100% !important;
	height: 34px !important;
	padding: 6px 12px !important;
	font-size: 14px !important;
	line-height: 20px !important;
	color: #555 !important;
	background-color: #fbfbfb !important;
	background-image: none !important;
	border: 1px solid #ccc !important;
	border-radius: 4px !important;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075) !important;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075) !important;
	-webkit-transition: border-color ease-in-out .15s, -webkit-box-shadow
		ease-in-out .15s !important;
	-o-transition: border-color ease-in-out .15s, box-shadow ease-in-out
		.15s !important;
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s
		!important;
}

.butaozao-div {
	border-color: #3c763d;
	background-image: linear-gradient(to bottom, #2e6da4 0, #2e6da4 100%);
	padding: 10px 15px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 3px;
	border-top-right-radius: 3px;
	box-sizing: border-box;
}

.box-transparent {<!--link rel="stylesheet" href="./css/ficha.css"-->
	<style> .box-transparent { background-color:transparent;
	color: black;
	border: none;
	outline: none;
	height: 30px;
	font-weight: bold;
	transition: height 1s;
	-webkit-transition: height 1s;
}

.select2-container--default .select2-selection--single .select2-selection__rendered
	{
	line-height: 20px !important;
}
</style>
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
								placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida"
								onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
						</div>
						<div class="form-group col-md-2 col-xs-8">
							<label for="select-unidade-medida" class="">Unidadede
								medida</label> <select id="select-unidade-medida"
								name="select-unidade-medida" data-native-menu="false"
								class="form-control selectBatata">
							</select>
						</div>
						<div class="form-group col-md-2 col-xs-4">
							<label for="qnt-medida-caseira" class="">Qtd</label> <input
								type="number" class="form-control" id="qnt-medida-caseira"
								placeholder="Qnt" min="0.1" max="100" step="0.1"
								name="qnt-medida-caseira" onKeyDown="limitText(this,4);"
								onKeyUp="limitText(this,4);">
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
									id="valorUnitario" placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo Real</label> <input
									type="number" readonly="readonly" class="form-control"
									id="custoReal" placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de
									Correção</label> <input type="number" readonly="readonly"
									class="form-control" id="fator-de-correcao"
									placeholder="Import">
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">Índice de Cocção</label>
								<input type="number" readonly="readonly" class="form-control"
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
			<div class="col-md-4 col-md-offset-4">
					<label for="valorTotal" id="preco"
						class="col-xs-12 col-sm-12 form-control-static text-center">Valor Total</label>
					<input type="number" name="custoTotal" id="custoTotal"
						class="form-control text-center box-transparent"
						placeholder="Valor Total" />
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
		</form>

	</article>

	<!--footer>Ficha Técnica Completa</footer-->

</body>
<script src="./js/fichaCompleta/telaFichaCompleta.js"></script>

<!-- isso ainda não tem 
<script src="./js/fichaSimplificada/addFichaSimplificada.js"></script>
-->

<script type="text/javascript">
	function limitText(limitField, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		}
	}
</script>

<jsp:include page="/template/foot.jsp"></jsp:include>

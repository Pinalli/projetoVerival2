
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<jsp:include page="../template/modalFichaSimplificada.jsp"></jsp:include>
<head>
<!--link rel="stylesheet" href="./css/ficha.css"-->
</head>
<body>

	<div class="container">
		<article>
			<form name="addFichaTecnicaSimples" id="addFichaTecnicaSimplesForm" method="post" action="ajax?acao=addFichaSimplificadaAjaxCommand">
				<div class="form-group col-md-4 col-md-offset-4">
					<input type="text" name="nome" id="nome"
						class="form-control text-center box-transparent"
						placeholder="Digite o nome da receita" />
				</div>

				<!-- File Button -->
				<div class="form-group col-md-12">
					<!--label class="col-md-3 control-label ages" for="Foto"></label-->
					<div class="col-md-6 col-md-offset-4 col-xs-offset-3">
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


				<div class="col-md-4 col-md-offset-4">
					<label for="rendimento"
						class="col-xs-12 col-sm-12 form-control-static text-center">Rendimento</label>
					<input type="text" name="rendimento" id="rendimento"
						class="form-control text-center box-transparent"
						placeholder="Rendimento" />
				</div>


				<div class="row">
					<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
				</div>
				<div class="row">
					<div class="col-md-12 col-md-offset-1 hidden-sm hidden-xs">
						<div class="col-md-2">
							<p class="text-center">
								<b>Ingrediente</b>
							</p>
						</div>
						<div class="col-md-2">
							<p class="text-center">
								<b>Qtd</b>
							</p>
						</div>
						<div class="col-md-2">
							<p class="text-center">
								<b>Unidade de Medida</b>
							</p>
						</div>
						<div class="col-md-2">
							<p class="text-center">
								<b>Qtd</b>
							</p>
						</div>
						<div class="col-md-2">
							<p class="text-center">
								<b>Medida Caseira</b>
							</p>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>

				<div class="row" id="table-rows">
					<div class="table-row"
						style="width: 100%; float: left; margin-bottom: 5px;">

						<div class="panel panel-info hidden-md hidden-lg">
							<div class="panel-heading show-item-btn" id="ingrediente-1">Ingrediente</div>
						</div>

						<div class="col-md-12 item-wrapper">
							<div
								class="form-group col-md-2 col-sm-12 col-xs-12 col-md-offset-1">
								<label for="select-ingredientes" class="hidden-md hidden-lg">Ingrediente</label>
								<select id="select-ingredientes" name="select-ingredientes"
									data-live-search="true" class="form-control selectBatata">
								</select>
							</div>

							<div class="form-group col-md-2 col-xs-4">
								<label for="qnt-unidade-medida" class="hidden-md hidden-lg">Quantidade</label>
								<input type="number" class="form-control"
									id="qnt-unidade-medida" placeholder="Qnt" min="1" max="9999"
									name="qnt-unidade-medida" onKeyDown="limitText(this,4);"
									onKeyUp="limitText(this,4);">
							</div>
							<div class="form-group col-md-2 col-xs-8">
								<label for="select-unidade-medida" class="hidden-md hidden-lg">Unidadede
									medida</label> <select id="select-unidade-medida"
									name="select-unidade-medida" data-native-menu="false"
									class="form-control selectBatata">
								</select>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="qnt-medida-caseira" class="hidden-md hidden-lg">Quantidade</label>
								<input type="number" class="form-control"
									id="qnt-medida-caseira" placeholder="Qnt" min="0.1" max="100"
									step="0.1" name="qnt-medida-caseira"
									onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
							</div>
							<div class="form-group col-md-2 col-xs-8">
								<label for="select-medida-caseira" class="hidden-md hidden-lg">Medida
									Caseira</label> <select id="select-medida-caseira"
									name="select-medida-caseira" data-native-menu="false"
									class="form-control selectBatata">
								</select>
							</div>
							<div class="form-group col-md-1 btn-excluir-wrapper"></div>
						</div>

					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<div class="col-md-2 col-md-offset-8">
							<a class="btn btn-success pull-right" id="add-row-btn">Novo Item</a>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
				</div>
				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<div class="form-group">
							<label class="text-center col-md-12 col-sm-12 col-xs-12">Modo
								de Preparo</label>
							<textarea rows="10" cols="" class="form-control"
								name="modoPreparo"></textarea>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<div class="form-group">
							<label class="text-center col-md-12 col-sm-12 col-xs-12">Montagem</label>
							<textarea rows="10" cols="" class="form-control" name="montagem"></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<div class="form-group">
							<label class="text-center col-md-12 col-sm-12 col-xs-12">Orienta��es
								e armazenamento</label>
							<textarea rows="10" cols="" class="form-control"
								name="orientacaoArmazenamento"></textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-9 col-md-offset-1 horizontal-divider"></div>
				</div>
				<div class="row">
					<div class="col-md-9 col-md-offset-1">
						<div class="form-group">
							<input type="reset" value="Limpar" id="limparForm"
								class="btn btn-warning pull-left col-md-2 col-sm-2 col-xs-5" />
							<input type="submit" value="Salvar"
								class="btn btn-success pull-right col-md-9 col-sm-9 col-xs-5" />
						</div>
					</div>
			</form>

		</article>

		<!--footer>Ficha T�cnica Simplificada</footer-->
	</div>
</body>
<script src="./js/fichaSimplificada/telaFichaSimplificada.js"></script>
<script src="./js/fichaSimplificada/addFichaSimplificada.js"></script>

<script type="text/javascript">
	function limitText(limitField, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		}
	}
</script>


<jsp:include page="/template/foot.jsp"></jsp:include>

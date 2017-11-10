<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<jsp:include page="../template/modalFichaCompleta.jsp"></jsp:include>
<script type="text/javascript" src="js/fichaCompletaCalculos.js"></script>

	<div class="jumbotron mb-5">
		<h1><span class="icon-adicionar text-info"></span> Cadastro de Ficha Técnica de Preparo</h1>
		<hr />
		
		<form name="addFichaTecnicaCompleta" id="addFichaTecnicaCompletaForm" method="post" action="ajax?acao=addFichaCompletaAjaxCommand">
			<div class="row">
				<div class="col-md-8 col-sm-12">
					<div class="row">
						<div class="form-group col-12">
							<label for="nome">Nome da Receita</label>
							<input type="text" class="form-control" id="nome" name="nome" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-4 col-sm-12">
							<label for="nome">Categoria</label>
							<select class="custom-select" id="categoria" nome="categoria" required>
								<option selected disabled>Selecione uma categoria</option>
								<option value="1">Prato Principal</option>
								<option value="2">Salada</option>
								<option value="3">Sobremesa</option>
								<option value="4">Guarnição</option>
								<option value="5">Prato Base</option>
								<option value="6">Acompanhamento</option>
								<option value="7">Bebida</option>
								<option value="8">Lanche</option>
								<option value="9">Outros</option>
							</select>
						</div>
						<div class="form-group col-md-4 col-sm-12">
							<label for="nome">Rendimento</label>
							<input type="text" class="form-control" id="nome" name="nome" />
						</div>
						<div class="form-group col-md-4 col-sm-12">
							<label for="nome">Tempo de Preparo</label>
							<input type="text" class="form-control" id="nome" name="nome" />
						</div>
					</div>
					<div class="row">
						<div class="form-group col-12">
							<input id="imgFile" name="imgFile" class="input-file" type="file">
						</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-12">
					<div class="form-group col-md-12">
						<label>Pré-Visualização</label>
						<div id="image_preview">
							<img id="previewing" src="" class="img-responsive img-thumbnail center-block" />
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="card mb-3">
              <div class="card-header">
                Ingredientes
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="card bg-secondary mb-3 show-item-btn" id="ingrediente-1" style="margin:0 auto">
                    <div class="card-body">
                      <div class="row">
                  <div class="form-group col-12">
                    <label for="exampleInputEmail1">Ingrediente</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                </div>
                <div class="row">
                  <div class="form-group col-4">
                    <label for="exampleInputEmail1">Unidade de Medida</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-2">
                    <label for="exampleInputEmail1">Quantidade</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-4">
                    <label for="exampleInputEmail1">Unidade de Medida Caseira</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-2">
                    <label for="exampleInputEmail1">Quantidade</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                </div>
                <div class="row">
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">CHO</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">PTN</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">LIP</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">Kcal</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                </div>
                <div class="row">
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">Valor Unitário</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">Custo Real

                    </label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">Fator de Correção</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                  <div class="form-group col-3">
                    <label for="exampleInputEmail1">Índice de Cocção</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                  </div>
                </div>
                <div class="text-right">
                  <button type="submit" class="btn btn-primary" id="add-row-btn"><span class="icon-adicionar"></span> Novo Item</button>
                <button type="submit" class="btn btn-danger"><span class="icon-cancelar"></span> Excluir</button>
                    
                </div>
                </div>
                  </div>
                </div>
              </div>
            </div>
			
			
			
		</form>
	</div>
	<article>
<!--		<form name="addFichaTecnicaCompleta" id="addFichaTecnicaCompletaForm"
			method="post" action="ajax?acao=addFichaCompletaAjaxCommand">

 
			<div class="row" style="text-align: center;">
				<div class="container" style="width: 640px;">
					<h2>Informao Nutricional</h2>
						<div class="row">
							<div class="col-sm-2">
								<label for="qnt-unidade-medida-rotulo" class="">Poro</label> 
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
								<label for="qnt-unidade-medida-caseira-rotulo" class="">Poro</label>
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
								<th colspan="2" style="text-align: center;">Quantidade por poro</th>
								<th style="text-align: center;">%VD (*)</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Valor Energtico</td>
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
								<td>Sdio</td>
								<td id="sodioQP"></td>
								<td id="sodioVD"></td>
							</tr>
						</tbody>
						<tfoot>
							<tr style="background-color: #f9f9f9;">
								<td colspan="3">(*) % Valores Dirios com base em uma dieta
									de 2.000 kcal ou 8400 KJ. Seus valores dirios podem ser
									maiores ou menores dependendo de suas necessidades energticas.</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
			
 -->
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
								onInput="alert02()"							
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
								caseira</label> <select id="select-medida-caseira"
								name="select-medida-caseira" data-native-menu="false"
								class="form-control selectBatata">
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
								<label for="valor-unitario" class="">Valor unitrio</label> 
								<input	type="hidden" class="form-control"	id="valor-unitario" placeholder="Valor unitrio"  readonly>
								<input	type="number" class="form-control"	id="valor-unitarioShow" placeholder="Valor unitrio"  readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="custo-real" class="">Custo real</label>
								<input type="hidden" class="form-control" id="custo-real" placeholder="Custo real" readonly>
								<input type="number" class="form-control" id="custo-realShow" placeholder="Custo real" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="fator-de-correcao" class="">Fator de correo</label>
								<input type="hidden" class="form-control" id="fator-de-correcao" placeholder="Fator de correo" readonly>
								<input type="number" class="form-control" id="fator-de-correcaoShow" placeholder="Fator de correo" readonly>
							</div>
							<div class="form-group col-md-2 col-xs-4">
								<label for="indice-de-coccao" class="">ndice de coco</label>
								<input type="hidden" class="form-control" id="indice-de-coccao" placeholder="ndice de Coco"  readonly>
								<input type="number" class="form-control" id="indice-de-coccaoShow" placeholder="ndice de Coco"  readonly>
							</div>
							<input type="text" class="hidden" id="gordura-trans" name="gordura-trans">
							<input type="text" class="hidden" id="gordura-saturada" name="gordura-saturada">
							<input type="text" class="hidden" id="fibra-alimentar" name="fibra-alimentar">
							<input type="text" class="hidden" id="sodio" name="sodio">
						<!--/div-->
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="btn-excluir-wrapper"></div>
						</div>
					</div>

				</div>
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
					Informaes de preparao
				</div>
			</div>
			<div class="col-md-12">
				<div class="form-group hide" id="informacoes-content">
                    <div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="utensilios-equipamentos-content">
                                Utenslios e equipamentos
                            </div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="utensilios-equipamentos-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="utensiliosEquipamentos"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="modo-preparo-content">
                                Modo de preparo
                            </div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="modo-preparo-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="modoPreparo"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="montagem-content">
                                Montagem
                            </div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="montagem-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control" name="montagem"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="orientacoes-armazenamento-content">
                                Orientaes de armazenamento
                            </div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="orientacoes-armazenamento-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="orientacaoArmazenamento"></textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row"></div>

			<div class="panel panel-info">
				<div class="panel-heading row text-center trigger-display" data-target="avaliacao-sensorial-content">
                    Avaliao sensorial
                </div>
			</div>
			<div class="col-md-12">
				<div class="form-group hide" id="avaliacao-sensorial-content">
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="textura-content">
                                Textura
                            </div>
						</div>
						<div class="col-md-9 col-md-offset-1">
							<div class="form-group hide" id="textura-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control" name="textura"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="sabor-content">
                                Sabor
                            </div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="sabor-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control" name="sabor"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="apresentacao-content">
                                Apresentao
                            </div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="apresentacao-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control"
									name="apresentacao"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="panel panel-info">
							<div class="panel-heading trigger-display" data-target="temperatura-content">
                                Temperatura
                            </div>
						</div>
						<div class="col-md-12">
							<div class="form-group hide" id="temperatura-content">
								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label>
								<textarea rows="10" cols="" class="form-control" name="temperatura"></textarea>
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

	<!--footer>Ficha Tcnica Completa</footer-->

</body>
<script src="./js/fichaCompleta/telaFichaCompleta.js"></script>
<script src="./js/fichaCompleta/addFichaCompleta.js"></script>
<script src="./js/fichaCompleta/rotulo.js"></script>

<script type="text/javascript">
	function limitText(limitField, limitNum) {
		if (limitField.value.length > limitNum) {
			limitField.value = limitField.value.substring(0, limitNum);
		}
	}
</script>

<jsp:include page="/template/foot.jsp"></jsp:include>
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
				<div class="card-header">Ingredientes</div>
				<div class="card-body">
					<div id="elemento-ingrediente" class="row">
						<div class="card bg-secondary mb-3 show-item-btn" id="ingrediente-1" style="margin:0 auto">
						    <div class="card-body">
								<div class="row">
									<div class="form-group col-12">
										<label for="exampleInputEmail1">Ingrediente</label>
										<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
									</div>
								</div>
								<div class="row">
									<div class="form-group col-md-4 col-sm-6">
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
										<label for="exampleInputEmail1">Custo Real</label>
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
								<div class="text-right btn-excluir-wrapper"></div>
							</div>
						</div>
					</div>
					
				</div>
				<button type="submit" class="btn btn-primary" id="add-row-btn">
					<span class="icon-adicionar"></span> Novo Item
				</button>   
            </div>
            
            <div class="card mb-3">
				<div class="card-header">Informações de Preparo</div>
				<div class="card-body">
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Utensílios & Equipamentos</label>
						<textarea class="form-control" name="utensiliosEquipamentos" rows="4"></textarea>
					</div>
					
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Modo de Preparo</label>
						<textarea class="form-control" name="modoPreparo" rows="4"></textarea>
					</div>
					
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Montagem</label>
						<textarea class="form-control" name="montagem" rows="4"></textarea>
					</div>
					
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Orientações de Armazenamento</label>
						<textarea class="form-control" name="orientacaoArmazenamento" rows="4"></textarea>
					</div>
				</div>
			</div>
              
			<div class="card mb-3">
				<div class="card-header">Avaliação Sensorial</div>
				<div class="card-body">
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Textura</label>
						<textarea class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
					</div>
					
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Sabor</label>
						<textarea class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
					</div>
					
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Apresentação</label>
						<textarea class="form-control" id="exampleFormControlTextarea1" rows="4"></textarea>
					</div>
				</div>
			</div>
			
			<div class="text-right">
				<button type="submit" class="btn btn-primary"><span class="icon-ok"></span> Salvar</button>
				<button type="submit" class="btn btn-warning"><span class="icon-cancelar"></span> Limpar</button>
			</div>
		</form>
	</div>

<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div> -->
<!-- 			</div> -->
<!-- 			<div class="panel panel-info"> -->
<!-- 				<div class="panel-heading row text-center trigger-display" data-target="informacoes-content"> -->
<!-- 					Informaes de preparao -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="col-md-12"> -->
<!-- 				<div class="form-group hide" id="informacoes-content"> -->
<!--                     <div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="utensilios-equipamentos-content"> -->
<!--                                 Utenslios e equipamentos -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-9 col-md-offset-1"> -->
<!-- 							<div class="form-group hide" id="utensilios-equipamentos-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" -->
<!-- 									name="utensiliosEquipamentos"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="modo-preparo-content"> -->
<!--                                 Modo de preparo -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-9 col-md-offset-1"> -->
<!-- 							<div class="form-group hide" id="modo-preparo-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" -->
<!-- 									name="modoPreparo"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="montagem-content"> -->
<!--                                 Montagem -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-9 col-md-offset-1"> -->
<!-- 							<div class="form-group hide" id="montagem-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" name="montagem"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="orientacoes-armazenamento-content"> -->
<!--                                 Orientaes de armazenamento -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-9 col-md-offset-1"> -->
<!-- 							<div class="form-group hide" id="orientacoes-armazenamento-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" -->
<!-- 									name="orientacaoArmazenamento"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="row"></div> -->

<!-- 			<div class="panel panel-info"> -->
<!-- 				<div class="panel-heading row text-center trigger-display" data-target="avaliacao-sensorial-content"> -->
<!--                     Avaliao sensorial -->
<!--                 </div> -->
<!-- 			</div> -->
<!-- 			<div class="col-md-12"> -->
<!-- 				<div class="form-group hide" id="avaliacao-sensorial-content"> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="textura-content"> -->
<!--                                 Textura -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-9 col-md-offset-1"> -->
<!-- 							<div class="form-group hide" id="textura-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" name="textura"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="sabor-content"> -->
<!--                                 Sabor -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<div class="form-group hide" id="sabor-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" name="sabor"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="apresentacao-content"> -->
<!--                                 Apresentao -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<div class="form-group hide" id="apresentacao-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" -->
<!-- 									name="apresentacao"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="panel panel-info"> -->
<!-- 							<div class="panel-heading trigger-display" data-target="temperatura-content"> -->
<!--                                 Temperatura -->
<!--                             </div> -->
<!-- 						</div> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<div class="form-group hide" id="temperatura-content"> -->
<!-- 								<label class="text-center col-md-12 col-sm-12 col-xs-12"></label> -->
<!-- 								<textarea rows="10" cols="" class="form-control" name="temperatura"></textarea> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-9 col-md-offset-1 horizontal-divider"></div> -->
<!-- 			</div> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-9 col-md-offset-1"> -->
<!-- 					<div class="form-group"> -->
<!-- 						<input type="reset" value="Limpar" -->
<!-- 							class="btn btn-warning pull-left col-md-2 col-sm-2 col-xs-5" /> -->
<!-- 						<input type="submit" value="Salvar" -->
<!-- 							class="btn btn-success pull-right col-md-9 col-sm-9 col-xs-5" /> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</form> -->

<!-- 	</article> -->

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
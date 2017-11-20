<div class="modal fade" id="modalExcluir" role="dialog" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header modal-exclude">
        		<h5 class="modal-title"></h5>
        		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          			<span aria-hidden="true">&times;</span>
        		</button>
      		</div>
			<div class="modal-body">
				<p id="modal-descricao"></p>
			</div>
			<div class="modal-footer">
				<form action="" method="post" id="formExcluir">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					<button type="submit" class="btn btn-danger">Excluir</button>
				</form>
			</div>
		</div>
	</div>
</div>
	
<div class="modal fade" id="modalVisualizar" role="dialog">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header modal-ages">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body">
				<ul class="nav nav-tabs nav-justified" role="tablist">
					<li role="presentation" class="active"><a href="#ftp" aria-controls="ftp" role="tab" data-toggle="tab">Ficha Técnica de Preparo</a></li>

					<li role="presentation"><a href="#ftpSimplificada" aria-controls="ftpSimplificada" role="tab" data-toggle="tab">Ficha Técnica Simplificada</a></li>

					<li role="presentation"><a href="#rtl" aria-controls="rtl" role="tab" data-toggle="tab">Rótulo Nutricional</a></li>
				</ul>

				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="ftp" style="width: 85%; margin: 0 auto; margin-top: 30px">
						<div class="container-fluid active" id="renderPDF_completa">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="vertical-align:middle" width="28%">NOME DA PREPRAÇÃO:</th>
										<td id="nome-receita-ftc" colspan="3" style="vertical-align:middle"></td>
										<td id="foto-ftc" rowspan="5" colspan="3" class="text-center">FOTO DA PREPARAÇÃO</td>
									</tr>
									<tr>
										<tr>
										<th style="vertical-align:middle">RENDIMENTO:</th>
										<td id="rendimento-ftc" colspan="3" style="vertical-align:middle"></td>
									</tr>
										<tr>
										<th style="vertical-align:middle">CATEGORIA:</th>
										<td id="categoria-ftc" colspan="3" style="vertical-align:middle"></td>
									</tr>
										<tr>
										<th style="vertical-align:middle">TEMPO DE PREPARO:</th>
										<td id="tempo-preparo-ftc" colspan="3" style="vertical-align:middle"></td>
									</tr>
								</thead>
								<thead>
									<tr>
										<th class="text-center" style="vertical-align:middle">Ingredientes</th>
										<th class="text-center" style="vertical-align:middle">Medida</th>
										<th class="text-center" style="vertical-align:middle">Medida Caseira</th>
										<th class="text-center" style="vertical-align:middle">FC</th>
										<th class="text-center" style="vertical-align:middle">Quant. Compra</th>
										<th class="text-center" style="vertical-align:middle">R$ Unitário</th>
										<th class="text-center" style="vertical-align:middle">R$ Parcial</th>
									</tr>

								</thead>
								<tbody id="ingredientes-ftc"></tbody>
								<tbody>
									<tr>
										<td class="text-right" colspan="1"><strong>Custo Total (R$):</strong></td>
										<td id="custo-total-ftc" colspan="6"></td>
									</tr>
									<tr>
										<td class="text-right" colspan="1"><strong>Custo Porção (R$):</strong></td>
										<td id="custo-porcao-ftc" colspan="6"></td>
									</tr>
									<tr>
										<td class="text-center" colspan="7"><strong>UTENSÍLIOS E EQUIPAMENTOS</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="utensilios-equipamentos-ftc"></td>
									</tr>
									<tr>
										<td class="text-center" colspan="7"><strong>MODO DE PREPARO</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="modo-preparo-ftc"></td>
									</tr>
										<tr>
										<td class="text-center" colspan="7"><strong>MONTAGEM</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="montagem-ftc"></td>
									</tr>
										<tr>
										<td class="text-center" colspan="7"><strong>ORIENTAÇÕES DE ARMAZENAMENTO</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="orientacoes-armazenamento-ftc"></td>
									</tr>
									<tr>
											<td class="text-center" colspan="7"><strong>TEXTURA</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="textura-ftc"></td>
									</tr>
									<tr>
											<td class="text-center" colspan="7"><strong>SABOR</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="sabor-ftc"></td>
									</tr>
									<tr>
											<td class="text-center" colspan="7"><strong>APRESENTAÇÃO</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="apresentacao-ftc"></td>
									</tr>
										<tr>
											<td class="text-center" colspan="7"><strong>TEMPERATURA</strong></td>
									</tr>
									<tr>
										<td colspan="7" id="temperatura-ftc"></td>
									</tr>

								</tbody>
							</table>
						</div>
						<div class="container-fluid">
							<form action="" method="post" id="formVisualizar" class="row">
<!-- 								<div class="col-md-8">Tamanho para impressÃ£o customizada (entre 14.5cm e 19.5cm): -->
<!-- 									<input type="text" id="size" value="" placeholder="Insira o valor" /> -->
<!-- 								</div> -->
								<div class="col-md-4 text-left">
									<button type="button" id="gerarPDFRotulo" onclick="gerarPDF('renderPDF_completa')" class="btn btn-success">Gerar PDF</button>
								</div>
							</form>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane fade" id="ftpSimplificada" style="width:85%;margin:0 auto;margin-top:30px">
						<div class="container-fluid" id="renderPDF_simples">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th style="vertical-align:middle" width="28%">NOME DA PREPARAÇÃO:</th>
										<td id="nome-receita-fts" style="vertical-align:middle"></td>
										<td id="foto-fts" rowspan="5" class="text-center">FOTO DA PREPARAÇÃO</td>
									</tr>
									<tr>
										<tr>
										<th style="vertical-align:middle">RENDIMENTO:</th>
										<td id="rendimento-fts" style="vertical-align:middle"></td>
									</tr>
										<tr>
										<th style="vertical-align:middle">CATEGORIA:</th>
										<td id="categoria-fts" style="vertical-align:middle"></td>
									</tr>
										<tr>
										<th style="vertical-align:middle">TEMPO DE PREPARO:</th>
										<td id="tempo-preparo-fts" style="vertical-align:middle"></td>
									</tr>
									<tr>
										<th class="text-center" style="vertical-align:middle">Ingredientes</th>
										<th class="text-center" style="vertical-align:middle">Medida</th>
										<th class="text-center" style="vertical-align:middle">Medida Caseira</th>
									</tr>
								</thead>
								<tbody id="ingredientes-fts"></tbody>
								<tbody>
									<tr>
										<td class="text-center" colspan="7"><strong>UTENSÍLIOS E EQUIPAMENTOS</strong></td>
									</tr>
									<tr>
										<td colspan="3" id="utensilios-equipamentos-fts"></td>
									</tr>
									<tr>
										<td class="text-center" colspan="3"><strong>MODO DE PREPARO</strong></td>
									</tr>
									<tr>
										<td colspan="3" id="modo-preparo-fts"></td>
									</tr>
									<tr>
										<td class="text-center" colspan="3"><strong>MONTAGEM</strong></td>
									</tr>
									<tr>
										<td colspan="3" id="montagem-fts"></td>
									</tr>
									<tr>
										<td class="text-center" colspan="3"><strong>ORIENTAÇÕES DE ARMAZEMENTO</strong></td>
									</tr>
									<tr>
										<td colspan="3" id="orientacoes-armazenamento-fts"></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="container-fluid">
							<form action="" method="post" id="formVisualizar" class="row">
<!-- 								<div class="col-md-8">Tamanho para impressÃ£o customizada (entre 14.5cm e 19.5cm): -->
<!-- 									<input type="text" id="size" value="" placeholder="Insira o valor" /> -->
<!-- 								</div> -->
								<div class="col-md-4 text-left">
									<button type="button" id="gerarPDFRotulo" onclick="gerarPDF('renderPDF_simples')" class="btn btn-success">Gerar PDF</button>
								</div>
							</form>
						</div>
					</div>

					<div role="tabpanel" class="tab-pane fade" id="rtl" style="width: 85%; margin: 0 auto; margin-top: 30px">
						<div class="container-fluid" id="renderPDF">
							<table class="table table-striped table-bordered">
								<thead>
									<tr>
										<th colspan="2" class="text-center" style="background: #f9f9f9"><h3 id="nome-receita" style="margin: 0"></h3></th>
										<th rowspan="2"><img src="./img/faenfi.png" width="100%"></th>
									</tr>
									<tr>
										<th colspan="2" class="text-center">INFORMAÇÃO NUTRICIONAL<br />
											<h5 style="margin: 0; margin-top: 3px; padding: 0;">Porção de <span id="modalMedida"></span> (<span id="modalMedidaCaseira"></span>)</h5>
										</th>
									</tr>
									<tr>
										<th colspan="2" class="text-center">Quantidade por porção</th>
										<th class="text-center">%VD (*)</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td width="40%">Valor Energético</td>
										<td width="40%" id="modalValorEnergeticoQP"></td>
										<td width="20%" id="modalValorEnergeticoVD"></td>
									</tr>
									<tr>
										<td>Carboidratos</td>
										<td id="modalCarboidratosQP"></td>
										<td id="modalCarboidratosVD"></td>
									</tr>
									<tr>
										<td>Proteinas</td>
										<td id="modalProteinasQP"></td>
										<td id="modalProteinasVD"></td>
									</tr>
									<tr>
										<td>Gorduras totais</td>
										<td id="modalGordTotalQP"></td>
										<td id="modalGordTotalVD"></td>
									</tr>
									<tr>
										<td>Gorduras saturadas</td>
										<td id="modalGordSaturadaQP"></td>
										<td id="modalGordSaturadaVD"></td>
									</tr>
									<tr>
										<td>Gorduras trans</td>
										<td id="modalGordTransQP"></td>
										<td id="modalGordTransVD">-</td>
									</tr>
									<tr>
										<td>Fibra alimentar</td>
										<td id="modalFibraAlimQP"></td>
										<td id="modalFibraAlimVD"></td>
									</tr>
									<tr>
										<td>SÃ³dio</td>
										<td id="modalSodioQP"></td>
										<td id="modalSodioVD"></td>
									</tr>
								</tbody>
								<tfoot>
									<tr style="background-color: #f9f9f9;">
										<td colspan="3">(*) % Valores Diários com base em uma
											dieta de 2.000 kcal ou 8400 KJ. Seus valores diários podem ser
											maiores ou menores dependendo de suas necessidades
											energéticas.</td>
									</tr>
								</tfoot>
							</table>
						</div>

						<div class="container-fluid">
							<form action="" method="post" id="formVisualizar" class="row">
<!-- 								<div class="col-md-8">Tamanho para impressÃ£o customizada (entre 14.5cm e 19.5cm): -->
<!-- 									<input type="text" id="size" value="" placeholder="Insira o valor" /> -->
<!-- 								</div> -->
								<div class="col-md-4 text-left">
									<button type="button" id="gerarPDFRotulo" onclick="gerarPDF('renderPDF')" class="btn btn-success">Gerar PDF</button>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>
</div>

<div class="modal fade" id="modalEditar" role="dialog">
 		<div class="modal-dialog">
  		<div class="modal-content">
  		
      		<div class="modal-header modal-ages">
	        	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        	<h4 class="modal-title"></h4>
      		</div>
      		
	      	<div class="modal-body">
	      	
        		<p id="modal-descricao"></p>
	      	</div>
	      	
	      	<div class="modal-footer">
	      		<form action="" method="post" id="formEditar">
	      			<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
	      			<button type="submit" class="btn btn-success">Editar</button>
	      		</form>
	      	</div>
	      	
	    </div>
  	</div>
</div>

<div class="modal fade" id="modalErro" role="dialog">
 		<div class="modal-dialog">
  		<div class="modal-content">
  		
      		<div class="modal-header modal-exclude">
	        	<button type="button" class="close" data-dismiss="modal">&times;</button>
	        	<h4 class="modal-title"></h4>
      		</div>
      		
	      	<div class="modal-body">
	      		
        		<p id="modal-descricao"></p>
	      	</div>
	      	
	      	<div class="modal-footer">
	      		<button class="btn btn-default" data-dismiss="modal">Fechar</button>
		      	</div>
		      	
		    </div>
	  	</div>
	</div>
	
<script>
$(document).on('show.bs.modal','#modalExcluir', function (event) {
  	var botao = $(event.relatedTarget);
  	var fichaS = botao.data('fichas');
	var id = botao.data('id');

  	$(this).find('.modal-title').text('Excluir Ficha Completa');
  	$(this).find('#modal-descricao').text('Realmente deseja excluir a ficha Completa(' + fichaS + ')?');

  	$('#formExcluir').attr('action', "main?acao=removerFichaCompleta&id_ficha_Completa=" + id);
});

$(document).on('show.bs.modal','#modalEditar', function (event) {
  	var botao = $(event.relatedTarget);
  	var fichaS = botao.data('fichas');
  	var id = botao.data('id');

  	$(this).find('.modal-title').text('Editar Ficha Completa');
  	$(this).find('#modal-descricao').text('Realmente deseja editar a ficha Completa (' + fichaS + ') ?');

  	$('#formEditar').attr('action', "main?acao=telaFichaCompleta&id_ficha_Completa=" + id + "&isEdit=true");
});

function pad(num, size) {
	var s = num+"";
	while (s.length < size) s = "0" + s;
	return s;
}

$('#modalVisualizar').on('show.bs.modal', function (event) {
	var botao = $(event.relatedTarget);
	var fichaS = botao.data('fichas');
	var id = botao.data('id');

	carregaRotuloPDF(id);
	carragarDadosFicha(id);
	  	
	$(this).find('.modal-title').text('Exportar para PDF');
	$(this).find('#modal-descricao').text('');
	$(this).find('#nome-receita').text(fichaS);
});

$(document).on('show.bs.modal','#modalErro', function (event) {
	var botao = $(event.relatedTarget);
  	var fichaS = botao.data('fichaS');
  	var id = botao.data('id');
});
</script>
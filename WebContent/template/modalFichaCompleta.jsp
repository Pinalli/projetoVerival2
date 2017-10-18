<div class="modal fade" id="modalExcluir" role="dialog">
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
				<form action="" method="post" id="formExcluir">
					<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
					<button type="submit" class="btn btn-exclude">Excluir</button>
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
					<li role="presentation" class="active"><a href="#ftp"
						aria-controls="ftp" role="tab" data-toggle="tab">Ficha Técnica
							de Preparo</a></li>
					<li role="presentation"><a href="#rtl" aria-controls="rtl"
						role="tab" data-toggle="tab">Rótulo Nutricional</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade active" id="ftp"></div>
					<div role="tabpanel" class="tab-pane fade" id="rtl">



						<table class="table table-striped table-bordered" id="renderPDF">
							<thead>

								<tr>
									<th colspan="2" class="text-center" style="background: #f9f9f9"><h3
											id="nome-receita" style="margin: 0"></h3></th>
									<th rowspan="3"><img src="./img/faenfi.png" width="100%">
									</th>
								</tr>

								<tr>
									<th colspan="2" class="text-center">INFORMAÇÃO NUTRICIONAL<br />
										<h5 style="margin: 0; margin-top: 3px; padding: 0;">Porção
											de 100 g ou mL (1 unidade)</h5>
									</th>

								</tr>
								<tr>
									<th id="date" colspan="2" class="text-center"></th>
								</tr>
								<tr>
									<th colspan="2" class="text-center">Quantidade por porção</th>
									<th class="text-center">%VD (*)</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td width="40%">Valor Energético</td>
									<td width="40%" id="valorEnergeticoQP"></td>
									<td width="20%" id="valorEnergeticoVD"></td>
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
									<td>Sódio</td>
									<td id="sodioQP"></td>
									<td id="sodioVD"></td>
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
					
					<form action="" method="post" id="formVisualizar">

						<div class="container-fluid">
							<input type="text" id="height" value=""placeholder="Altura do rótulo" />
							<input type="text" id="width" value="" placeholder="Largura do rótulo" />
						</div>
				</div>
				</div>
			</div>
			<div class="modal-footer">

				<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
				<button onclick="gerarPDF()" class="btn btn-success">Gerar
					PDF</button>
				</form>
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
	      		<button onclick="gerarPDF()" class="btn btn-default" data-dismiss="modal">Fechar</button>
		      	</div>
		      	
		    </div>
	  	</div>
	</div>
	   
	
<script>
$(document).on('show.bs.modal','#modalExcluir', function (event) {
  	var botao = $(event.relatedTarget);
  	var fichaS = botao.data('fichaS');
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

$('#modalVisualizar').on('show.bs.modal', function (event) {
	  	var botao = $(event.relatedTarget);
	  	var fichaS = botao.data('fichas');
	  	var id = botao.data('id');
	  	var d = new Date();
	  	
	  	preencheDados();
	  	
	  	var d = new Date();
	  	var month= d.getUTCMonth() + 1;
	var dataBrasil = d.getDate() + "/" + month +  "/" + d.getFullYear()+" "+(d.getUTCHours()-3)+":"+d.getUTCMinutes();
	document.getElementById("date").innerHTML = dataBrasil;
	
	
  	
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
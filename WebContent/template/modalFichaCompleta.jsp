   
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
	
	
	
  		<div class="modal-dialog">
	  		<div class="modal-content">
	  		
	      		<div class="modal-header modal-ages">
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
		        	<h4 class="modal-title"></h4>
	      		</div>
				<div class="container" style="text-align: center;width:550px;">

       
        
        
           <div class="container" style="text-align: center;width:500px;">
       		<div class="row">
            <div class="col-sm-2">Porção g ou ml</div>
            <div class="col-sm-2">
                <input type="number" class="form-control" id="qnt-unidade-medida-rotulo" placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida-rotulo"
                    onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
            </div>
            <div class="col-sm-2">
                <label for="select-unidade-medida" class="">Unidadede medida</label>
                
            </div>
            <div class="col-sm-2">
                <input type="number" class="form-control" id="qnt-unidade-medida-caseira-rotulo" placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida-caseira-rotulo"
                    onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
            </div>
            <div class="col-sm-2">
                  <button onclick="preencheDados();">Gerar Rótulo</button> 
            </div>
        </div>
                <div id="renderPDF">
            <h3>Rótulo Nutricional</h3>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th colspan="2" style="text-align: center;">Quantidade por porção</th>
                        <th style="text-align: center;">%VD (*)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Valor Energético</td>
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
                        <td>Sódio</td>
                        <td id="sodioQP"></td>
                        <td id="sodioVD"></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr style="background-color: #f9f9f9;">
                        <td colspan="3">(*) % Valores Diários com base em uma dieta de 2.000 kcal ou 8400 KJ. Seus valores diários podem
                            ser maiores ou menores dependendo de suas necessidades energéticas.</td>
                    </tr>
                </tfoot>
        </div>

        </table>
        
       
    </div>
    </div>
    
		      	<div class="modal-body">
		      		
		      		
	        		<p id="modal-descricao"></p>
	        			
		      	</div>
		      	
		      	<div class="modal-footer">
		      		<form action="" method="post" id="formVisualizar">
		      			<button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
		      			
		      		
		      		<button onclick="gerarPDF()" class="btn btn-success">Gerar PDF</button>
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
		      		<button onclick="gerarPDF()" class="btn btn-default" data-dismiss="modal">Fechar</button>
		      	</div>
		      	
		    </div>
	  	</div>
	</div>
	
<script>
$( document ).ready(function() {
	$('#modalExcluir').on('show.bs.modal', function (event) {
	  	var botao = $(event.relatedTarget);
	  	var fichaS = botao.data('fichaS');
		var id = botao.data('id');
		
	  	$(this).find('.modal-title').text('Excluir Ficha Completa');
	  	$(this).find('#modal-descricao').text('Realmente deseja excluir a ficha Completa(' + fichaS + ')?');
	  	
	  	$('#formExcluir').attr('action', "main?acao=removerFichaCompleta&id_ficha_Completa=" + id);
	});
	
	$('#modalEditar').on('show.bs.modal', function (event) {
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
	  
	  	
	  	$(this).find('.modal-title').text('Rótulo ' + fichaS);
	 	$(this).find('#modal-descricao').text('');

	 	       
	 	 
	 	
	  		
	  	
	});
	

		
	$('#modalErro').on('show.bs.modal', function (event) {
	  	var botao = $(event.relatedTarget);
	  	var fichaS = botao.data('fichaS');
	  	var id = botao.data('id');
	});
});
</script>
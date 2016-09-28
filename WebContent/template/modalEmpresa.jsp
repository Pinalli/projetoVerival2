
<script>
$( document ).ready(function() {
	$('#modalExcluir').on('show.bs.modal', function (event) {
	  	var botao = $(event.relatedTarget);
	  	var empresa = botao.data('empresa');
		var id = botao.data('id');
	  	
	  	$(this).find('.modal-title').text('Excluir empresa');
	  	$(this).find('#modal-descricao').text('Realmente deseja excluir a empresa (' + empresa + ')?');
	  	
	  	$('#formExcluir').attr('action', "main?acao=removerEmpresa&id_empresa=" + id);
	});
	
	
	$('#modalEditar').on('show.bs.modal', function (event) {
	  	var botao = $(event.relatedTarget);
	  	var empresa = botao.data('empresa');
		var id = botao.data('id');
	  	
	  	$(this).find('.modal-title').text('Editar empresa');
	  	$(this).find('#modal-descricao').text('Realmente deseja editar a empresa (' + empresa + ')?');
	  	
	  	$('#formEditar').attr('action', "main?acao=telaEmpresa&id_empresa=" + id + "&isEdit=true");
	});
});
</script>

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
	
	
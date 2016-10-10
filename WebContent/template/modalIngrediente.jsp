<script>
	$(document).ready(
			function() {
				$('#modalExcluir').on(
						'show.bs.modal',
						function(event) {
							var botao = $(event.relatedTarget);
							var ingrediente = botao.data('ingrediente');
							var idIngrediente = botao.data('id');

							$(this).find('.modal-title').text(
									'Excluir Ingrediente');
							$(this).find('#modal-descricao').text(
									'Realmente deseja excluir o ingrediente ('
											+ ingrediente + ')?');

							$('#formExcluir').attr(
									'action',
									"main?acao=removerIngrediente&idIngrediente="
											+ idIngrediente);
						});

				$('#modalEditar').on(
						'show.bs.modal',
						function(event) {
							var botao = $(event.relatedTarget);
							var ingrediente = botao.data('ingrediente');
							var id = botao.data('id');

							$(this).find('.modal-title').text(
									'Editar ingrediente');
							$(this).find('#modal-descricao').text(
									'Realmente deseja editar o ingrediente ('
											+ ingrediente + ')?');

							$('#formEditar').attr(
									'action',
									"main?acao=telaIngredientes&idIngrediente="
											+ id + "&isEdit=true");
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
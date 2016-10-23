$(document).ready(function() {
	$('form[name="addFichaTecnicaSimples"]').submit(function(event){
		event.preventDefault();
		add($(this));
	});
	
	function add(form){
		var nome = $('input[name="nome"]', form).val();
		var rendimento = $('input[name="rendimento"]', form).val();
		var foto = $('input[name="imgFile"]', form).val();
		var modoPreparo = $('textarea[name="modoPreparo"]', form).val();
		var montagem = $('textarea[name="montagem"]', form).val();;
		var orientecoesArmazenamento = $('textarea[name="orientacaoArmazenamento"]', form).val();;
		var itens = [];
		
		$(".table-row").each(function(){
			var item = {
					idFichaItem : null,
					idFicha : null,
					idIngrediente : $('select[name="select-ingredientes"]').val(),
					quantidadeUnidadeMedida : $('input[name="qnt-unidade-medida"]').val(),
					idUnidadeMedida : $('select[name="select-unidade-medida"]').val(),
					qntMedidaCaseira : $('input[name="qnt-medida-caseira"]').val(),
					idMedidaCaseira : $('select[name="select-medida-caseira"]').val(),
			};
			itens.push(item);
		});
		
		var data = {
			nome:nome,
			rendimento:rendimento,
			foto:foto,
			modoPreparo:modoPreparo,
			montagem:montagem,
			orientacoesArmazenamento:orientecoesArmazenamento,
			itens:JSON.stringify(itens)
			//itens:itens
		};
		
		$.post( "/FichaTP/ajax?acao=addFichaTecnicaSimplificadaAjax", data, function() {
			console.log( "success" );
			window.location.href = "/FichaTP/main?acao=listFichaSimplificada";
		}).done(function() {
			console.log( "done" );
			
		}).fail(function() {
			console.log( "fail" );
		})
	}
});
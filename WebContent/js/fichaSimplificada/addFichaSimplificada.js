$(document).ready(function() {
	$('form[name="addFichaTecnicaSimples"]').submit(function(event){
		event.preventDefault();
		add($(this));
	});
	
	function add(form){
		var nome = $('input[name="nome"]').val();
		var rendimento = $('input[name="rendimento"]').val();
		var foto = $('input[name="imgFile"]').val();
		var modoPreparo = $('textarea[name="modoPreparo"]').val();
		var montagem = $('textarea[name="montagem"]').val();
		var orientecoesArmazenamento = $('textarea[name="orientacaoArmazenamento"]').val();
		var itens = [];
		
		$(".table-row").each(function(){
			var item = {
					idFichaItem : null,
					idFicha : null,
					idIngrediente : $(this).find('select[name="select-ingredientes"]').val(),
					quantidadeUnidadeMedida : $(this).find('input[name="qnt-unidade-medida"]').val(),
					idUnidadeMedida : $(this).find('select[name="select-unidade-medida"]').val(),
					quantidadeMedidaCaseira : $(this).find('input[name="qnt-medida-caseira"]').val(),
					idMedidaCaseira : $(this).find('select[name="select-medida-caseira"]').val(),
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
		};
		
		
		var action = $("#addFichaTecnicaSimplesForm").attr('action');
		$.post(action, data, function(data) {
		//$.post( "ajax?acao=addFichaSimplificadaAjaxCommand", data, function(data) {
			var json = jQuery.parseJSON(data);
			if(json.erro){
				showModalErro("Erro ao salvar ficha simplificada", json.mensagem);			
			}else{
				window.location.href = json.proxima;
			}
		}).fail(function() {
			showModalErro("Erro ao salvar ficha simplificada", "N\u00e3o foi possivel salvar a ficha t\u00e9cnica, tente novamente por favor.");
		});
	}

	function showModalErro(title, text){
		$("#modalErro").modal('show');
		$("#modalErro").find('.modal-title').text(title);
	  	$("#modalErro").find('#modal-descricao').text(text);
	}
	//limpar preview da imagem
	$("#limparForm").click(function(){
		$("#image_preview").css("display","none");
		$("#errorMessage").css("display","none");
	});
	
});
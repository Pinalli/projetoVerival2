$(document).ready(function() {
	$('form[name="editFichaTecnicaCompleta"]').submit(function(event){
		event.preventDefault();
		add($(this));
	});
	
	[{"idFichaItem":"1>","idUnidadeMedida":"1","idMedidaCaseira":"1","idIngrediente":"1","quantidadeUnidadeMedida":"1.0","quantidadeMedidaCaseira":"1.0","ingrediente":"","unidadeMedida":"","unidadeMedidaCaseira":"","idFicha":"1","perCapita":"2.21","valorUnit":"2.21","operacao":"u"},{"idFichaItem":"2>","idUnidadeMedida":"1","idMedidaCaseira":"1","idIngrediente":"2","quantidadeUnidadeMedida":"1.0","quantidadeMedidaCaseira":"1.0","ingrediente":"","unidadeMedida":"","unidadeMedidaCaseira":"","idFicha":"1","perCapita":"3.55","valorUnit":"3.55","operacao":"u"}]
	
	function add(form){
		var idFicha = $("#idFicha").val();
		var nome = $('input[name="nome"]').val();
		var rendimento = $('input[name="rendimento"]').val();
		var foto = $('input[name="imgFile"]').val();
		var modoPreparo = $('textarea[name="modoPreparo"]').val();
		var montagem = $('textarea[name="montagem"]').val();
		var orientecoesArmazenamento = $('textarea[name="orientacaoArmazenamento"]').val();
		var textura = $('textarea[name="textura"]').val();
		var sabor = $('textarea[name="sabor"]').val();;
		var apresentacao = $('textarea[name="apresentacao"]').val();
		var itens = [];
		
		$(".table-row").each(function(){
			var item = {
					idFichaItem : $(this).find("#idFichaItem").val(),
					idUnidadeMedida : $(this).find('select[name="select-unidade-medida"]').val(),
					idMedidaCaseira : $(this).find('select[name="select-medida-caseira"]').val(),
					idIngrediente : $(this).find('select[name="select-ingredientes"]').val(),
					quantidadeUnidadeMedida : $(this).find('input[name="qnt-unidade-medida"]').val(),
					quantidadeMedidaCaseira : $(this).find('input[name="qnt-medida-caseira"]').val(),					
					idFicha : idFicha,					
					perCapita: $(this).find('#custo-real').val(),
					valorUnit: $(this).find('#valor-unitario').val(),
					operacao: $(this).find('#operacao').val(),
			};
			itens.push(item);
		});
		
		var data = {
			id:idFicha,
			nome:nome,
			rendimento:rendimento,
			foto:foto,
			modoPreparo:modoPreparo,
			montagem:montagem,
			orientacoesArmazenamento:orientecoesArmazenamento,
			textura: textura,
			sabor:sabor,
			apresentacao:apresentacao,
			itens:JSON.stringify(itens)
		};
		
		var action = form.attr("action");
		$.post(action, data, function(data) {			
			var json = jQuery.parseJSON(data);
			console.log(json);
			if(json.erro){
				showModalErro("Erro ao salvar ficha completa", json.mensagem);			
			}else{
				window.location.href = json.proxima;
			}
		}).fail(function() {
			showModalErro("Erro ao salvar ficha completa", "N\u00e3o foi possivel salvar a ficha t\u00e9cnica, tente novamente por favor.");
		});
	}

	function showModalErro(title, text){
		$("#modalErro").modal('show');
		$("#modalErro").find('.modal-title').text(title);
	  	$("#modalErro").find('#modal-descricao').text(text);
	}
	
});
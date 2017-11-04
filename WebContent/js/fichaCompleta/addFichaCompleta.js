$(document).ready(function() {
	$('form[name="addFichaTecnicaCompleta"]').submit(function(event){
		event.preventDefault();
		add($(this));
	});
	
	function add(form){
		var nome = $('input[name="nome"]').val();
		var rendimento = $('input[name="rendimento"]').val();
		var foto = $('input[name="imgFile"]').val();
		var utensiliosEquipamentos = $('textarea[name="utensiliosEquipamentos"]').val();
		var modoPreparo = $('textarea[name="modoPreparo"]').val();
		var tempoPreparo = $('input[name="tempoDePreparo"]').val();
		var montagem = $('textarea[name="montagem"]').val();
		var orientecoesArmazenamento = $('textarea[name="orientacaoArmazenamento"]').val();
		var textura = $('textarea[name="textura"]').val();
		var sabor = $('textarea[name="sabor"]').val();;
		var apresentacao = $('textarea[name="apresentacao"]').val();
		var temperatura = $('textarea[name="temperatura"]').val();
		var qntUnidadeMedida = $('#qnt-unidade-medida-rotulo').val();
		var unidadeMedidaId = $('#select-unidade-medida-rotulo').val();
		var qntUnidadeMedidaCaseira = $('#qnt-unidade-medida-caseira-rotulo').val();
		var unidadeMedidaCaseiraId = $('#select-medida-caseira-rotulo').val();
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
					perCapita: $(this).find('#custo-real').val(),
					valorUnit: $(this).find('#valor-unitario').val(),
			};
			itens.push(item);
		});
		
		console.log(itens);
		
		var data = {
			nome:nome,
			rendimento:rendimento,
			foto:foto,
			utensiliosEquipamentos:utensiliosEquipamentos,
			modoPreparo:modoPreparo,
			tempoPreparo:tempoPreparo,
			montagem:montagem,
			orientacoesArmazenamento:orientecoesArmazenamento,
			textura:textura,
			sabor:sabor,
			apresentacao:apresentacao,
			temperatura:temperatura,
			itens:JSON.stringify(itens),
			qntUnidadeMedida:qntUnidadeMedida,
			unidadeMedidaId:unidadeMedidaId,
			qntUnidadeMedidaCaseira:qntUnidadeMedidaCaseira,
			unidadeMedidaCaseiraId:unidadeMedidaCaseiraId
		};
		
		var action = form.attr("action");
		$.post(action, data, function(data) {			
			var json = jQuery.parseJSON(data);
			console.log(json);
			if(json.erro){
				showModalErro("Erro ao salvar ficha completa", json.msgErro);			
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
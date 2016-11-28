$(document).ready(function() {
	$('form[name="editFichaTecnicaSimples"]').submit(function(event){
		event.preventDefault();
		add($(this));
	});
	
	function add(form){
		var id = $('#idFicha').val();
		var nome = $('input[name="nome"]').val();
		var rendimento = $('input[name="rendimento"]').val();
		var foto = $('input[name="imgFile"]').attr('value');
		var modoPreparo = $('textarea[name="modoPreparo"]').val();
		var montagem = $('textarea[name="montagem"]').val();
		var orientecoesArmazenamento = $('textarea[name="orientacaoArmazenamento"]').val();
		var itens = [];
		
		$(".table-row").each(function(){
			var item = {
					idFichaItem : $(this).find("#idFichaItem").val(),
					idFicha : id,
					idIngrediente : $(this).find('select[name="select-ingredientes"]').val(),
					quantidadeUnidadeMedida : $(this).find('input[name="qnt-unidade-medida"]').val(),
					idUnidadeMedida : $(this).find('select[name="select-unidade-medida"]').val(),
					quantidadeMedidaCaseira : $(this).find('input[name="qnt-medida-caseira"]').val(),
					idMedidaCaseira : $(this).find('select[name="select-medida-caseira"]').val(),
					operacao : $(this).find("#operacao").val(),
			};
			itens.push(item);
		});
		
		itens = removeIncompleteItens(itens);
		
		var data = {
			id:id,
			nome:nome,
			rendimento:rendimento,
			foto:foto,
			modoPreparo:modoPreparo,
			montagem:montagem,
			orientacoesArmazenamento:orientecoesArmazenamento,
			itens:JSON.stringify(itens)
		};
		
		//Valida
		if(validateFicha(data) && validateItens(itens)){
			//save
			var action = $("#editFichaTecnicaSimplesForm").attr('action');
			$.post(action, data, function(data) {			
				var json = jQuery.parseJSON(data);
				if(json.erro){
					showModalErro("Erro ao salvar ficha simplificada", json.msgErro);			
				}else{
					window.location.href = json.proxima;
				}
			}).fail(function() {
				showModalErro("Erro ao salvar ficha simplificada", "N\u00e3o foi possivel salvar a ficha t\u00e9cnica, tente novamente por favor.");
			});
		}
	}
	
	/**
	 * Remove itens incompletos
	 * @param itens
	 * @returns
	 */
	function removeIncompleteItens(itens){
		for(var i=0; i<itens.length; i++){
			if(itens[i].idIngrediente === '' &&
				itens[i].idUnidadeMedida  === '' &&
				itens[i].idMedidaCaseira === ''){
				itens.splice(i,1);
			}
		}
		return itens;
	}
	
	/**
	 * Valida dados da ficha
	 * @param data
	 * @returns
	 */
	function validateFicha(data){
		if(data.nome == '' || data.nome === null){
			showModalErro("Dados da ficha incompletos", "Informe o nome");
			return false;
		}else if(data.rendimento == '' || data.rendimento === null){
			showModalErro("Dados da ficha incompletos", "Informe o rendimento");
			return false;
		}else if(data.foto == '' || data.foto === null){
			showModalErro("Dados da ficha incompletos", "Informe a foto");
			return false;
		}else if(data.modoPreparo == '' || data.modoPreparo === null){
			showModalErro("Dados da ficha incompletos", "Informe o modo de preparo");
			return false;
		}else if(data.montagem == '' || data.montagem === null){
			showModalErro("Dados da ficha incompletos", "Informe a montagem");
			return false;
		}else if(data.orientacoesArmazenamento == '' || data.orientacoesArmazenamento === null){
			showModalErro("Dados da ficha incompletos", "Informe as orientacoes de armazenamento");
			return false;
		}
		return true;
	}
	
	/**
	 * Valida itens
	 * @param itens
	 * @returns
	 */
	function validateItens(itens){
		for(var i=0; i<itens.length; i++){
			item = itens[i];
			if(item.idIngrediente == '' || item.idIngrediente === null){
				showModalErro("Dados dos itens incompletos", "Infome o ingrediente");
				return false;
			}else if(item.quantidadeUnidadeMedida == '' || item.quantidadeUnidadeMedida === null){
				showModalErro("Dados dos itens incompletos", "Infome a quantidade da unidade de medida");
				return false;
			}else if(item.idUnidadeMedida == '' || item.idUnidadeMedida === null){
				showModalErro("Dados dos itens incompletos", "Infome a unidade de medida");
				return false;
			}else if(item.quantidadeMedidaCaseira == '' || item.quantidadeMedidaCaseira === null){
				showModalErro("Dados dos itens incompletos", "Infome a quantidade de medida caseira");
				return false;
			}else if(item.idMedidaCaseira == '' || item.idMedidaCaseira === null){
				showModalErro("Dados dos itens incompletos", "Infome a medida caseira");
				return false;
			}			
		}
		return true;
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
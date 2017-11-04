$(document).ready(function() {
	$('form[name="editFichaTecnicaCompleta"]').submit(function(event){
		event.preventDefault();
		add($(this));
	});

	function add(form){
		var idFicha = $("#idFicha").val();
		var nome = $('input[name="nome"]').val();
		var rendimento = $('input[name="rendimento"]').val();
		var foto = $('input[name="imgFile"]').attr('value');
		var utensiliosEquipamentos = $('textarea[name="utensiliosEquipamentos"]').val();
		var modoPreparo = $('textarea[name="modoPreparo"]').val();
		var tempoPreparo = $('input[name="tempoPreparo"]').val();
		var montagem = $('textarea[name="montagem"]').val();
		var orientecoesArmazenamento = $('textarea[name="orientacaoArmazenamento"]').val();
		var textura = $('textarea[name="textura"]').val();
		var sabor = $('textarea[name="sabor"]').val();;
		var apresentacao = $('textarea[name="apresentacao"]').val();
		var temperatura = $('textarea[name="temperatura"]').val();
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

		itens = removeIncompleteItens(itens);

		var data = {
			id:idFicha,
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
			itens:JSON.stringify(itens)
		};

		//Valida
		if(validateFicha(data) && validateItens(itens)){
			//save
			var action = form.attr("action");
			$.post(action, data, function(data) {			
				var json = jQuery.parseJSON(data);
				if(json.erro){
					showModalErro("Erro ao salvar ficha completa", json.msgErro);			
				}else{
					window.location.href = json.proxima;
				}
			}).fail(function() {
				showModalErro("Erro ao salvar ficha completa", "N\u00e3o foi possivel salvar a ficha t\u00e9cnica, tente novamente por favor.");
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
		}else if(data.tempoPreparo == '' || data.tempoPreparo === null || data.tempoPreparo < 0) {
			showModalErro("Dados da ficha impletos", "Informe o tempo de preparo");
			return false;
		}else if(data.foto == '' || data.foto === null){
			showModalErro("Dados da ficha incompletos", "Informe a foto");
			return false;
		}else if(data.utensiliosEquipamentos == '' || data.utensiliosEquipamentos === null) {
			showModalErro("Dados da ficha incompletos", "Informe os utensilios e equipamentos utilizados");
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
		}else if(data.textura == '' || data.textura === null){
			showModalErro("Dados da ficha incompletos", "Informe a textura");
			return false;
		}else if(data.sabor == '' || data.sabor === null){
			showModalErro("Dados da ficha incompletos", "Informe o sabor");
			return false;
		}else if(data.apresentacao == '' || data.apresentacao === null){
			showModalErro("Dados da ficha incompletos", "Informe a apresentacao");
			return false;
		}else if(data.temperatura == '' || data.temperatura === null || data.temperatura < 0){
			showModalErro("Dados da ficha incompletos", "Informe a temperatura");
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
});
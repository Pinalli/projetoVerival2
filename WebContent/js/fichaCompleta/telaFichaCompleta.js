$(document).ready(function() {
	var RESOLUCAO_MINIMA = 990;
	var RESOLUCAO_MAX = 99000;
	var qntIngredientes = 2;
	
	var valorEnergetico = 0;
	var carboidratos = 0;
	var proteinas = 0;
	var gordTotal = 0;
	var gordSaturada = 0;
	var gordTrans = 0;
	var fibraAlim = 0;
	var sodio = 0;
		
	setSelect2();

	/**
	 * Hide/display divs
	 */
	$(".trigger-display").click(function(){
		var id = $(this).attr("data-target");
		$("#"+id).toggleClass("hide");
	});

	/**
	 * Aplica o Select2 nos selects
	 */
	function setSelect2() {
		$('.selectBatata').each(function(i, obj) {
			if(!$(this).closest('.table-row').hasClass('configurado')){
				if (obj.id == 'select-ingredientes') {
					var data = [];
					//Usado em views de edição, verifica se contem os atributos com os dados cadastrados
					if(obj.hasAttribute('data-selected-id') && obj.hasAttribute('data-selected-text')){
						data = [{'id':$(this).attr('data-selected-id'), 'text':$(this).attr('data-selected-text')}];
					}
					$(this).select2({
						data: data,
						 ajax: {							 
							    url: "ajax?acao=buscaIngredienteDescricaoAjax",
							    method: "GET",
							    data: function (params) {	
							        return {'descricao':params.term, 'limit':10};
							    },
							    processResults: function (data, params) {
							    	var select2Data = [];
							    	var json = jQuery.parseJSON(data);
							    	for(var i=0; i<json.length; i++){
										var obj = {'id':json[i].id, 'text':json[i].descricao}
										select2Data.push(obj);				
									}
							        return {							          
						                results: select2Data
						            };
							      },
							      cache: true
							  },
					      
					});
				} else if (obj.id == 'select-unidade-medida' || obj.id == 'select-unidade-medida-rotulo') {
					var data = [];
					//Usado em views de edição, verifica se contem os atributos com os dados cadastrados
					if(obj.hasAttribute('data-selected-id') && obj.hasAttribute('data-selected-text')){
						data = [{'id':$(this).attr('data-selected-id'), 'text':$(this).attr('data-selected-text')}];
					}
					$(this).select2({
						data : data, 
						 ajax: {							 
							    url: "ajax?acao=buscaUnidadeMedidaUnidadeAjax",
							    method: "GET",
							    data: function (params) {	
							        return {'unidade':params.term, 'limit':10};
							    },
							    processResults: function (data, params) {
							    	var select2Data = [];
							    	var json = jQuery.parseJSON(data);
							    	for(var i=0; i<json.length; i++){
										var obj = {'id':json[i].idUnidadeMedida, 'text':json[i].unidadeMedida}
										select2Data.push(obj);				
									}
							        return {							          
						                results: select2Data
						            };
							      },
							      cache: true
							  },
					      
					});
				} else if (obj.id == 'select-medida-caseira' || obj.id == 'select-medida-caseira-rotulo') {
					var data = [];
					//Usado em views de edição, verifica se contem os atributos com os dados cadastrados
					if(obj.hasAttribute('data-selected-id') && obj.hasAttribute('data-selected-text')){
						data = [{'id':$(this).attr('data-selected-id'), 'text':$(this).attr('data-selected-text')}];
					}
					$(this).select2({
						data:data,
						 ajax: {							 
							    url: "ajax?acao=buscaUnidadeMedidaCaseiraNomeAjax",
							    method: "GET",
							    data: function (params) {
							        return {'nome':params.term, 'limit':10};
							    },
							    
							    processResults: function (data, params) {
							    	var select2Data = [];
							    	var json = jQuery.parseJSON(data);
							    	for(var i=0; i<json.length; i++){
										var obj = {'id':json[i].idUnidadeMedidaCaseira, 'text':json[i].nome}
										select2Data.push(obj);				
									}
							        return {							          
						                results: select2Data
						            };
							      },
							      cache: true
							  },
					      
					});
				}
			}else{
				console.log('1');
			}
		});
	}

	/**
	 * Adiciona linha
	 */
	$('#add-row-btn').click(function(e) {
		e.preventDefault();
		add();
		//addRemoveListener();
		setSelect2();
		showItemListener();
		updateIngredienteListener();
		updateQuantidades();
		addRotuloListener();
		qntIngredientes++;
		/**
		 * Adiciona class 'configurado' a linha para que 
		 * não seja feita outras alteracoes na mesma. Como por exemplo,
		 * aplicar o select2 novamente.
		 */
		$('.table-row:last').addClass('configurado');
	});

	/**
	 * Remove linha
	 */
//	function addRemoveListener() {
//		$('.delete-row').each(function() {
//			$(this).click(function(e) {
//				e.preventDefault();
//
//				var target = $(this).closest('.table-row');
//
//				var $kcalElem = target.find("#kcal");
//				var $choElem = target.find("#cho");
//				var $ptnElem = target.find("#ptn");
//				var $gordSaturada = target.find("#gordura-saturada");
//				var $fibraAlim = target.find("#fibra-alimentar");
//				var $sodio = target.find("#sodio");
//
//				valorEnergetico -= $kcalElem.val();
//				carboidratos -= $choElem.val();
//				proteinas -= $ptnElem.val();
//				gordSaturada -= $gordSaturada.val();
//				fibraAlim -= $fibraAlim.val();
//				sodio -= $sodio.val();
//
//				updateRotulo();
//
//				target.fadeOut(300, function(){
//					target.remove();
//					if($(window).width() <= RESOLUCAO_MINIMA){
//						scroll($('.table-row:last'));
//					}
//				});
//				qntIngredientes--;
//			});
//		});
//	}

	/**
	 * Clona ulltima linha
	 */
//	function add() {
//		//Clona a ultima linha
//		var row = $('.card').last().clone();
//		row.removeClass('configurado');
//		row.find('.item-wrapper').removeClass('hide');
//		var id = 'ingrediente-'+qntIngredientes;
//		$('.show-item-btn', row).attr('id',id);
//
//		row.find('input[type="number"]').each(function(){
//			$(this).val('')
//		});
//		row.find('.select2').remove();
//		row.find('select').removeClass('select2-hidden-accessible');
//		row.hide().appendTo($('#table-rows')).fadeIn(300);
//		//Adiciona botão de excluir na linha clonada se ela não contém um
//		var btn = $.parseHTML('<button type="submit" class="btn btn-danger delete-row pull-right"><span class="icon-cancelar"></span> Excluir</button>');
//		var len = $('.btn-excluir-wrapper button', $('.table-row').last()).length;
//		if (len == 0) {
//			$('.btn-excluir-wrapper').last().append(btn);
//		}
//		//Scroll
//		if($(window).width() <= RESOLUCAO_MINIMA){
//			scroll($('#'+id));
//		}
//	}

	function add() {
		console.log("Qualquer coisa");
		var d = new Date();
		var n = d.getTime();
		
		var div = document.getElementById('elemento-ingrediente'),
		clone = div.cloneNode(true); // true means clone all childNodes and all event handlers
		clone.id = "elemento-ingrediente-"+n;

		var btn = $.parseHTML('<button type="submit" class="btn btn-danger delete-row pull-right" onClick="excluirIngrediente('+n+')"><span class="icon-cancelar"></span> Excluir</button>');
		$(clone).find(".btn-excluir-wrapper").append(btn);

		$('#elemento-ingrediente').parent().append(clone);
	}
	
	function scroll(target){
		if(typeof target.offset() !== 'undefined'){
			$('html, body').animate({
			    scrollTop: target.offset().top
			}, 1000);
		}
	}
	
	/**
	 * Adiciona listenner 'click' para os botoes exibirem os forms de itens
	 */				
	function showItemListener() {
		$('.show-item-btn').each(function() {
		       
			if(!$(this).closest('.table-row').hasClass('configurado')){
				//Add listener
				$(this).click(function(e) {
					e.preventDefault();
					$('.item-wrapper', $(this).closest('.table-row')).each(
						function() {	
							$(this).toggleClass("hide");
						});
				});				

				//obtem inputs
				var selectIngredientes = $('#select-ingredientes', $(this).closest('.table-row'));
				var selectUnidadeMedida = $('#select-unidade-medida', $(this).closest('.table-row'));
				var inputQntUnidadeMedida = $('#qnt-unidade-medida', $(this).closest('.table-row'));

				//Define texto do botao
				var nome = $('option:selected', selectIngredientes).text();
				if(nome.length > 0 && typeof nome !== 'undefined'){
					$(this).html(nome);
				}
				
				//Atualiza texto do botao
				selectIngredientes.on('change', function(){
					updateSumaryText(inputQntUnidadeMedida, selectUnidadeMedida, selectIngredientes);
				});
				selectUnidadeMedida.on('change', function(){
					updateSumaryText(inputQntUnidadeMedida, selectUnidadeMedida, selectIngredientes);
				});
				inputQntUnidadeMedida.on('keyup', function(){
					updateSumaryText(inputQntUnidadeMedida, selectUnidadeMedida, selectIngredientes);
				});
			}
		});
	}
	
	/**
	 * Atualiza texto do botao de resumo
	 */
	function updateSumaryText(inputQntUnidadeMedida, selectUnidadeMedida, selectIngredientes){
		var qntUnidadeMedidaVal = inputQntUnidadeMedida.val();										
		var selectUnidadeMedidaVal = $('option:selected', selectUnidadeMedida).text();
		var selectIngredientesText = $('option:selected', selectIngredientes).text();
			
		var nome = qntUnidadeMedidaVal + ' ' + selectUnidadeMedidaVal + ' de ' + selectIngredientesText;
		$('.show-item-btn', inputQntUnidadeMedida.closest('.table-row')).html(nome);
	}

	/**
	 * Altera o layout em resoluções com larguras menores que 990px 
	 */
	if($(window).width() <= RESOLUCAO_MAX){
		document.onreadystatechange = function () {
			if (document.readyState == "complete") {						
				showItemListener();
				$('.item-wrapper').each(function(){
					$(this).toggleClass("hide");
				});
				/**
				 * Adiciona class 'configurado' a linha para que 
				 * não seja feita outras alteracoes na mesma. Como por exemplo,
				 * aplicar o select2 novamente.
				 */
				$('.table-row:last').addClass('configurado');
			}
		}
	}
	
	/**
	 * Atualiza campos referntes ao ingrediente
	 */
	function updateIngredienteListener(){
		$(".table-row").not(".configurado").each(function(){
			var row = $(this);
			var select = row.find("#select-ingredientes");
			if(select.val()){
				getIngredienteById(row, select.val());
			}
			select.change(function(){
				var id = $(this).val();
				getIngredienteById(row, id);
			});
		});		
	}
	updateIngredienteListener();
	
	/**
	 * Atualiza campos referentes ao ingrediente
	 * @param ingrediente
	 * @returns
	 */
	function updateIngrediente(row, ingrediente){
		var kcal = ingrediente.kcalCarboidratos + ingrediente.kcalLipidios + ingrediente.kcalProteinas;
		
		var $kcalElem = row.find("#kcal");
		var $choElem = row.find("#cho");
		var $ptnElem = row.find("#ptn");
		var $gordSaturada = row.find("#gordura-saturada");
		var $fibraAlim = row.find("#fibra-alimentar");
		var $sodio = row.find("#sodio");

		$kcalElem.val(kcal);
		$choElem.val(ingrediente.carboidratos);
		$ptnElem.val(ingrediente.proteinas);
		row.find("#lip").val(ingrediente.lipidios);
		row.find("#valor-unitario").val(ingrediente.custo);
		row.find("#custo-real").val(ingrediente.custo);
		row.find("#fator-de-correcao").val(ingrediente.fatorCorrecao);
		row.find("#indice-de-coccao").val(ingrediente.indiceCoccao);
		$gordSaturada.val(ingrediente.gorduraSaturada);
		$fibraAlim.val(ingrediente.fibrasAlimentares);
		$sodio.val(ingrediente.sodio);
		
		createRotulo();

	}
	
 	function createRotulo() {
 		var idUMRotulo = $('#select-unidade-medida-rotulo').val();
 		var qntUMRotulo = $('#qnt-unidade-medida-rotulo').val();

 		if(idUMRotulo != null && qntUMRotulo != null) {
 			console.log("COMECOU");
	 		var $ingredientes = $('#table-rows').find('.table-row');

	 		var fichaIngredientes = null;

	 		$ingredientes.each(function(index) {
	 			var ingrediente = {
		 			'kcal': $(this).find("#kcal").val(),
		 			'carboidratos': $(this).find("#cho").val(),
		 			'proteinas': $(this).find("#ptn").val(),
		 			'lipidios': $(this).find("#lip").val(),
		 			'gorduraSaturada': $(this).find("#gordura-saturada").val(),
		 			'gorduraTrans': 0,
		 			'fibrasAlimentares': $(this).find("#fibra-alimentar").val(),
		 			'sodio': $(this).find("#sodio").val()
	 			};
	 			var unidadeMedida = retornaSiglaUnidadeMedidaPorId($(this).find('#select-unidade-medida').val());

	 			var fichaIngrediente = {
 					'gorduraTrans': $(this).find("#gorduraTrans").val(),
	 				'ingrediente': ingrediente,
	 				'quantidadeMedida': $(this).find('#qnt-unidade-medida').val(),
	 				'unidadeMedida': unidadeMedida
	 			};

	 			if(fichaIngredientes == null) {
	 				fichaIngredientes = [fichaIngrediente];
	 			} else {
	 				fichaIngredientes.push(fichaIngrediente);
	 			}
	 		});

	 		var unidadeMedida = retornaSiglaUnidadeMedidaPorId($('#select-unidade-medida-rotulo').val());

	 		var dadosFicha = {
	 			'fichaIngredientes': fichaIngredientes,
	 			'qntMedida': qntUMRotulo,
	 			'unidadeMedida': unidadeMedida
	 		};

			var infoRotulo = calculoRotulo(dadosFicha);

			valorEnergetico = infoRotulo.valorEnergeticoOri;
			carboidratos = infoRotulo.carboidratosOri;
			proteinas = infoRotulo.proteinasOri;
			gordTotal = infoRotulo.gorduraTotalOri;
			gordSaturada = infoRotulo.gorduraSaturadaOri;
			gordTrans = infoRotulo.gorduraTransOri;
			fibraAlim = infoRotulo.fibraAlimentarOri;
			sodio = infoRotulo.sodioOri;

			updateRotulo();
 		}

 	}

	function updateRotulo() {
		
//		Necessidades diárias: 2.000 kcalorias
		var veKj = valorEnergetico * 4.1868;
		$('#valorEnergeticoQP').html(parseFloat(valorEnergetico.toFixed(3)) + ' kcal = ' + parseFloat(veKj.toFixed(3)) + ' kj');
		var valorEnergeticoVD = (valorEnergetico*100)/2000;
		$('#valorEnergeticoVD').html(parseFloat(valorEnergeticoVD.toFixed(3)) + '%');

//		Necessidades diárias: 300g
		$('#carboidratosQP').html(parseFloat(carboidratos.toFixed(3)) + ' g');
		var carboidratosVD = (carboidratos*100)/300;
		$('#carboidratosVD').html(parseFloat(carboidratosVD.toFixed(3)) + '%');
		
//		Necessidades diárias: 75g
		$('#proteinasQP').html(parseFloat(proteinas.toFixed(3)) + ' g');
		var proteinasVD = (proteinas*100)/75;
		$('#proteinasVD').html(parseFloat(proteinasVD.toFixed(3)) + '%');
		
//		Gorduras totais - Necessidades diárias: 55g
		$('#gordTotalQP').html(parseFloat(gordTotal.toFixed(3)) + ' g');
		var gordTotalVD = (gordTotal*100)/55;
		$('#gordTotalVD').html(parseFloat(gordTotalVD.toFixed(3)) + '%');

//		Necessidades diárias: 22g
		$('#gordSaturadaQP').html(parseFloat(gordSaturada.toFixed(3)) + ' g');
		var gordSaturadaVD = (gordSaturada*100)/22;
		$('#gordSaturadaVD').html(parseFloat(gordSaturadaVD.toFixed(3)) + '%');
		
//		Gordura Trans
		$('#gordTransQP').html(parseFloat(gordTrans.toFixed(3)) + ' g');

//		Necessidades diárias: 25g
		$('#fibraAlimQP').html(parseFloat(fibraAlim.toFixed(3)) + ' g');
		var fibraAlimVD = (fibraAlim*100)/25;
		$('#fibraAlimVD').html(parseFloat(fibraAlimVD.toFixed(3)) + '%');
		
//		Necessidades diárias: 2.400mg
		$('#sodioQP').html(parseFloat(sodio.toFixed(3)) + ' mg');
		var sodioVD = (sodio*100)/2400
		$('#sodioVD').html(parseFloat(sodioVD.toFixed(3)) + '%');
	}
	
	/**
	 * Busca ingrediente pelo ID
	 * @param id
	 * @returns json
	 */
	function getIngredienteById(row, id) {
		$.ajax({
			type: 'GET',
			url: 'ajax?acao=buscaIngredienteIdAjax',
			data: {id: id},
			error: function() {
				console.log('Error on getIngredienteById.');
			},
			success: function(data) {
				json = jQuery.parseJSON(data);
			    updateIngrediente(row, json);
			}
		});
	}

	function updateQuantidades(){
		$(".table-row").not(".configurado").each(function(){
			var row = $(this);
			var select = row.find("#select-ingredientes");
			if(select.val()){
				multiplica(row, select.val());
			}
			select.change(function(){
				var id = $(this).val();
				multiplica(row, id);
			});
		});
	}
	updateQuantidades();

	function multiplica(row, id){
		row.find("#qnt-unidade-medida").change(function() {
			var x, y;
			x = row.find("#cho").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#choShow").val(y);
			x = row.find("#ptn").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#ptnShow").val(y);
			x = row.find("#lip").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#lipShow").val(y);
			x = row.find("#kcal").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#kcalShow").val(y);
			row.find("#valor-unitarioShow").val(row.find("#valor-unitario").val());
			if (row.find("#valor-unitarioShow").val().length > 5){
				row.find("#valor-unitarioShow").val(row.find("#valor-unitarioShow").val().substr(0, 7));
			    }
			x = row.find("#custo-real").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#custo-realShow").val(y);
			x = row.find("#fator-de-correcao").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#fator-de-correcaoShow").val(y);
			x = row.find("#indice-de-coccao").val()*row.find("#qnt-unidade-medida").val();
			if (x % 1 != 0 && !isNaN(x % 1)) y = x.toFixed(2);
			else y =x;
			row.find("#indice-de-coccaoShow").val(y);

			createRotulo();
		});
	}

	$(function() {
		$("#imgFile").change(function() {
			var file = this.files[0];
			var imagefile = file.type;
			var match = [ "image/jpeg","image/png", "image/jpg" ];
			if (!((imagefile == match[0])
				|| (imagefile == match[1]) || (imagefile == match[2]))) {
				$("#errorMessage").css("display","block");
				return false;
			} else {
				$("#errorMessage").css("display","none");
				var idFicha = $('#idFicha').val();
				if(idFicha == null){
					idFicha = 0;
				}
				form = new FormData()
				form.append('file',file);
				form.append('fichaSimplificada', true);
				form.append('idFicha', idFicha);
				console.log(form.toString());
				var reader = new FileReader();
				reader.onload = imageIsLoaded;
				reader.readAsDataURL(this.files[0]);
		            $.ajax({
		                url: "upload",
		                cache: false,
		                contentType: false,
		                processData: false,
		                async: false,
		                data: form,
		                type: 'POST',
		                success: function(data) {
		                    
		                }
		            });
			}
		});
	});
	function imageIsLoaded(e) {
		$("#imgFile").css("color", "green");
		$('#image_preview').css("display", "block");
		$('#previewing').attr('src', e.target.result);
		$('#previewing').attr('width', '300px');
		$('#previewing').attr('height', '300px');
	};
	
	function addRotuloListener() {
		$('#table-rows').find('.table-row').each(function() {
			$(this).find('#select-unidade-medida').on('change', function() {
				createRotulo();
			});

			$(this).find('#gorduraTrans').on('change', function() {
				createRotulo();
			});

			$('#qnt-unidade-medida-rotulo').on('change', function() {
				createRotulo();
			});

			$('#select-unidade-medida-rotulo').on('change', function() {
				createRotulo();
			});


		});
	}
	addRotuloListener();
});

function check_multifile_logo(file) {
    var extension = file.substr((file.lastIndexOf('.') + 1))
    if (extension === 'jpg' || extension === 'jpeg' || extension === 'png') {
        return true;
    } else {
        return false;
    }
}

function excluirIngrediente(id) {
	console.log(id);
	$('#elemento-ingrediente-'+id).remove();
}

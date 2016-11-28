$(document).ready(function() {
	var RESOLUCAO_MINIMA = 990;
	var qntIngredientes = 2;
		
	setSelect2();
	
	/**
	 * Magic. Do not touch.
	 */

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
							    	//select2Data.push({'id':00, 'text':'batata'});
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
				} else if (obj.id == 'select-unidade-medida') {
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
				} else if (obj.id == 'select-medida-caseira') {
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
		addRemoveListener();
		setSelect2();
		showItemListener();
		updateIngredienteListener();
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
	function addRemoveListener() {
		$('.delete-row').each(function() {
			$(this).click(function(e) {
				e.preventDefault();				
				var target = $(this).closest('.table-row'); 			
				target.fadeOut(300, function(){
					var operacao = $("#operacao",target);
					if(!operacao.val() || operacao.val() == "u"){
						operacao.val("d");
					}else if(operacao.val() == "c"){
						if($(".table-row").length > 1){
							target.remove();
						}
					}else{
						target.remove();
					}
					if($(window).width() <= RESOLUCAO_MINIMA){
						scroll($('.table-row:last'));
					}
				});				
				qntIngredientes--;			
			});
		});
	}
	addRemoveListener();

	/**
	 * Clona ulltima linha
	 */
	function add() {		
		//Clona a ultima linha
		var row = $('.table-row').last().clone();
		row.removeClass('configurado');
		row.find('.item-wrapper').removeClass('hide');
		row.find('#operacao').val("c");
		var id = 'ingrediente-'+qntIngredientes;
		$('.show-item-btn', row).attr('id',id);
		
		row.find('input[type="number"]').each(function(){
			$(this).val('')
		});
		row.find('.select2').remove();
		row.find('select').removeClass('select2-hidden-accessible');
		row.hide().appendTo($('#table-rows')).fadeIn(300);
		row.find('.select2').unbind('change');
		
		//Adiciona botão de excluir na linha clonada se ela não contém um
		var btn = $.parseHTML('<button class="btn btn-danger delete-row pull-right" style="padding-left:22px;padding-right:23px;">Excluir</button>');
		var len = $('.btn-excluir-wrapper button', $('.table-row').last()).length;
		if (len == 0) {
			$('.btn-excluir-wrapper').last().append(btn);
		}
		//Scroll
		if($(window).width() <= RESOLUCAO_MINIMA){
			scroll($('#'+id));
		}
	}
	
	/**
	 * Update operacao
	 */
	function addUpdateListener(row){
		$("select", row).each(function(){
			$(this).change(function(){
				if(!row.find("#operacao").val()){
					row.find("#operacao").val("u");
				}
			});
		});
		$("input", row).each(function(){
			$(this).bind("change keyup", function(){
				if(!row.find("#operacao").val()){
					row.find("#operacao").val("u");
				}
			});
		});
	}
	
	$(".table-row").each(function(){
		addUpdateListener($(this));
	});
	
	/**
	 * Scroll
	 */
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
	if($(window).width() <= RESOLUCAO_MINIMA){
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
 	 * Atualiza campos referntes ao ingrediente
 	 * @param ingrediente
 	 * @returns
 	 */
 	function updateIngrediente(row, ingrediente){
 		var kcal = ingrediente.kcalCarboidratos + ingrediente.kcalLipidios + ingrediente.kcalProteinas;  
 		row.find("#cho").val(ingrediente.carboidratos);
 		row.find("#ptn").val(ingrediente.proteinas);
 		row.find("#lip").val(ingrediente.lipidios);
 		row.find("#kcal").val(kcal);
 		row.find("#valor-unitario").val(ingrediente.custo);
 		row.find("#custo-real").val(ingrediente.custo);
 		row.find("#fator-de-correcao").val(ingrediente.fatorCorrecao);
 		row.find("#indice-de-coccao").val(ingrediente.indiceCoccao);
 	}
 	
 	/**
 	 * Busca ingrediente pelo ID
 	 * @param id
	
 	 * @returns json
 	 */
 	function getIngredienteById(row, id){
 		$.ajax({
 			   url: 'ajax?acao=buscaIngredienteIdAjax',
 			   data: {id: id},
 			   error: function() {
 			      console.log('Error on getIngredienteById.');
 			   },
 			   success: function(data) {
 			      json = jQuery.parseJSON(data);
 			      updateIngrediente(row, json)
 			   },
 			   type: 'GET'
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
	
	 function check_multifile_logo(file) {
	     var extension = file.substr((file.lastIndexOf('.') + 1))
	     if (extension === 'jpg' || extension === 'jpeg' || extension === 'png') {
	         return true;
	     } else {
	         return false;
	     }
	 }
	
	/**
	 * Did you touched?
	 */
});
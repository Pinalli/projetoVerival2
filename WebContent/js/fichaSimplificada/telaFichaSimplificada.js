$(document).ready(function() {
	var RESOLUCAO_MINIMA = 990;
	var qntIngredientes = 2;
		
	setSelect2();

	/**
	 * Aplica o Select2 nos selects
	 */
	function setSelect2() {
		$('.selectBatata').each(function(i, obj) {
			if(!$(this).closest('.table-row').hasClass('configurado')){
				if (obj.id == 'select-ingredientes') {
					$(this).select2({
						 ajax: {							 
							    url: "/FichaTP/ajax?acao=buscaIngredienteDescricaoAjax",
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
				} else if (obj.id == 'select-unidade-medida') {
					$(this).select2({
						 ajax: {							 
							    url: "/FichaTP/ajax?acao=buscaUnidadeMedidaUnidadeAjax",
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
					$(this).select2({
						 ajax: {							 
							    url: "/FichaTP/ajax?acao=buscaUnidadeMedidaCaseiraNomeAjax",
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
					target.remove();
					if($(window).width() <= RESOLUCAO_MINIMA){
						scroll($('.table-row:last'));
					}
				});				
				qntIngredientes--;			
			});
		});
	}

	/**
	 * Clona ulltima linha
	 */
	function add() {		
		//Clona a ultima linha
		var row = $('.table-row').last().clone();
		row.removeClass('configurado');
		row.find('.item-wrapper').removeClass('hide');
		var id = 'ingrediente-'+qntIngredientes;
		$('.show-item-btn', row).attr('id',id);
		
		row.find('input[type="number"]').each(function(){
			$(this).val('')
		});
		row.find('.select2').remove();
		row.find('select').removeClass('select2-hidden-accessible');
		row.hide().appendTo($('#table-rows')).fadeIn(300);
		
		//Adiciona botão de excluir na linha clonada se ela não contém um
		var btn = $.parseHTML('<button class="btn btn-danger delete-row pull-right" style="padding-left:20px;padding-right:20px;">Excluir</button>');
		var len = $('.btn-excluir-wrapper button', $('.table-row').last()).length;
		if (len == 0) {
			$('.btn-excluir-wrapper').last().append(btn);
		}
		//Scroll
		if($(window).width() <= RESOLUCAO_MINIMA){
			scroll($('#'+id));
		}
	}
	
	function scroll(target){
		$('html, body').animate({
		    scrollTop: target.offset().top
		}, 1000);
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
		
				//Define texto do botao
				var select = $('#select-ingredientes', $(this).closest('.table-row')); 
				var nome = $('option:selected', select).text();
				if(nome.length > 0 && typeof nome !== 'undefined'){
					$(this).html(nome);
				}
				var selectUni = $('#select-unidade-medida', $(this).closest('.table-row')); 
				var selectQtn = $('#qnt-unidade-medida', $(this).closest('.table-row').val());
				
				
				//Atualiza texto do botao
				select.on('change', function(){
					//var select = $('#select-ingredientes', $(this).closest('.table-row')); 
					var nome = $('#qnt-unidade-medida', $(this).closest('.table-row')).val() + ' ' + 
					$('option:selected', $('#select-unidade-medida')).text() + ' ' + 'de ' + $('option:selected', $(this)).text();
					$('.show-item-btn', $(this).closest('.table-row')).html(nome);
				});
				selectUni.on('change', function(){
					//var selectUni = $('#select-unidade-medida', $(this).closest('.table-row')); 
					var nome = $('#qnt-unidade-medida', $(this).closest('.table-row')).val() + ' ' + 
					$('option:selected', $('#select-unidade-medida')).text() + ' ' + 'de ' + $('option:selected', $('#select-ingredientes')).text();
					$('.show-item-btn', $(this).closest('.table-row')).html(nome);
				});
				selectQtn.on('change', function(){
					//var selectQtn = $('#select-qnt-unidade-medida', $(this).closest('.table-row')); 
					var nome = $('#qnt-unidade-medida', $(this).closest('.table-row')).val() + ' ' + 
					$('option:selected', $('#select-unidade-medida')).text() + ' ' + 'de ' + $('option:selected', $('#select-ingredientes')).text();
					$('.show-item-btn', $(this).closest('.table-row')).html(nome);
				});
			}
		});
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
	
});
$(document).ready(function() {
	var RESOLUCAO_MINIMA = 990;
	var qntIngredientes = 2;
	var ingredientes  = [{id : '1',text : 'batata'}, {id : '2',text : 'batata frita'}, {id : '3',text : 'batata doce'}, {id : '4',text : 'batata chips'} ];
	var unidadeMedida = [{id : '1',text : 'grama(s)'}, {id : '2',text : 'quilo(s)'} ];
	var medidaCaseira = [{id : '1',text : 'Unidade(s)'}, {id : '2',text : 'Colher de sopa'} ];
		
	setSelect2();

	/**
	 * Aplica o Select2 nos selects
	 */
	function setSelect2() {
		$('.selectBatata').each(function(i, obj) {
			if(!$(this).closest('.table-row').hasClass('configurado')){
				if (obj.id == 'select-ingredientes') {
					$(this).select2({data : ingredientes});
				} else if (obj.id == 'select-unidade-medida') {
					$(this).select2({data : unidadeMedida});
				} else if (obj.id == 'select-medida-caseira') {
					$(this).select2({data : medidaCaseira});
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
				$(this).html(nome);
				
				//Atualiza texto do botao
				select.on('change', function(){
					var select = $('#select-ingredientes', $(this).closest('.table-row')); 
					var nome = $('option:selected', select).text();
					$('.show-item-btn', $(this).closest('.table-row')).html(nome);
				});
			}
		});
	}	

	/**
	 * Altera o layou em resoluções com larguras menores que 990px 
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
	
});
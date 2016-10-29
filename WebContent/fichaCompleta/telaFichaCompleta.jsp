
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<head>
		<!--link rel="stylesheet" href="./css/ficha.css"-->
		<style>
		.box-transparent {
		    background-color:transparent;
		    color:black;
		    border: none;
		    outline:none;
		    height:30px;
		    font-weight:bold;
		    transition:height 1s;
		    -webkit-transition:height 1s;
		}
		</style>
</head>
<body>

<div class="container">
	    
<article>
	<form>
		<div class="form-group col-md-4 col-md-offset-4">
			<input type="text" name="nome" id="nome" class="form-control text-center box-transparent" placeholder="Digite o nome da receita"/>
		</div>
		
		<div class="form-group col-md-12 col-md-offset-2	">
			<label class="col-md-3 control-label ages" for="Foto"></label>
			<div class="col-md-6">
				<input id="imgFile" name="imgFile" class="input-file" type="file">
			</div>
	
	<div class="form-group  col-md-4 col-md-offset-4">
		<label for="select-rendimento" class=" hidden-sm col-md-12 text-center">Rendimento</label> 
		<input type="text" name="rendimento" id="rendimento" class="form-control text-center" placeholder="Ex: 10 pratos"/>
	</div>
	<div class="row">
		<div class="col-md-12 col-md-offset-1 hidden-sm hidden-xs">
			<div class="col-md-2"><p class="text-center"><b>Ingrediente</b></p></div>
			<div class="col-md-1"><p class="text-center"><b>Qtd</b></p></div>
			<div class="col-md-2"><p class="text-center"><b>Unidade de Medida</b></p></div>
			<div class="col-md-1"><p class="text-center"><b>Qtd</b></p></div>
			<div class="col-md-2"><p class="text-center"><b>Medida Caseira</b></p></div>
			<div class="col-md-1"></div>
		</div>
	</div>
	
	<div class="row" id="table-rows">
	<div class="table-row" style="padding:5px 0;margin-bottom:5px;width:100%;float:left;">
		<div class="col-md-12">
			<div class="form-group col-md-2 col-md-offset-1">
				<label for="select-ingredientes" class="hidden-md hidden-lg">Ingrediente</label> 
			    <select id="select-ingredientes" data-live-search="true" class="form-control selectIng">
			    </select>
			</div>
			<div class="form-group col-md-1">
				<label for="qnt-unidade-medida" class="hidden-md hidden-lg">Quantidade</label>
			    <input type="number" class="form-control" id="qnt-unidade-medida" placeholder="Qnt" min="1">
			</div>
			<div class="form-group col-md-2">
				<label for="select-unidade-medida" class="hidden-md hidden-lg">Unidade de medida</label>
			    <select id="select-unidade-medida" data-native-menu="false" class="form-control selectIng">
			    </select>
			</div>
			<div class="form-group col-md-1">
				<label for="qnt-medida-caseira" class="hidden-md hidden-lg">Quantidade</label>
			    <input type="number" class="form-control" id="qnt-medida-caseira" placeholder="Qnt" min="0.1" step="0.1">
			</div>
			<div class="form-group col-md-2">
				<label for="select-medida-caseira" class="hidden-md hidden-lg">Medida Caseira</label>
			    <select id="select-medida-caseira" data-native-menu="false" class="form-control selectIng">
			    </select>
			</div>
			<div class="form-group col-md-2 btn-excluir-wrapper">
				
			</div>
			</div>
	</div>	
	</div>
	<div class="row">
		<div class="col-md-10">
			<a class="btn btn-success pull-right" id="add-row-btn">Adicionar</a>
		</div>
	</div>		
		<div class="row">
			<div class="col-md-12">
			<div class="form-group col-md-12">
			 	<h3 class="text-center">Modo de Preparo</h3>
					<textarea rows="10" cols="" class="form-control"
					placeholder="Oi gente. Como cada ingrediente tem mttts itens na ficha completa, acho melhor pensar num jeito de fazer um 'hide & show' do menu editável, pra cada ingrediente. "></textarea>	
				</div>
			</div>
		</div>
		
			<div class="row">
			<div class="col-md-12">
			<div class="form-group col-md-12">
			 	<h3 class="text-center">Montagem</h3>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		<div class="row">	
			<div class="col-md-12">
			<div class="form-group col-md-12">
			 	<h3 class="text-center">Orientações e armazenamento</h3>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<div class="form-group col-md-12">
			 	<h3 class="text-center">Textura</h3>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<div class="form-group col-md-12">
			 	<h3 class="text-center">Sabor</h3>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<div class="form-group col-md-12">
			 	<h3 class="text-center">Apresentação</h3>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
	</form>

</article>

<!--footer>Ficha Técnica Simplificada</footer-->
</div>
</body>
<script>
	$(document).ready(function(){
		var ingredientes  = [{id:'1',text:''}, {id:'2',text:'Ovo'}, {id:'3',text:'Pimenta'}, {id:'4',text:'Sal'}];
		var unidadeMedida = [{id:'1',text:'grama(s)'}, {id:'2',text:'kilo(s)'}];
		var medidaCaseira = [{id:'1',text:'Unidade(s)'}, {id:'2',text:'Colher de sopa'}, {id:'3',text:'Xícara'}];
		//Select2
		//$('.selectBatata').select2();
		setSelect2();
		
		function setSelect2(){
			//$('.selectIng').select2();
			$('.selectIng').each(function(i,obj){
				if(obj.id == 'select-ingredientes'){
					$(this).select2({data:ingredientes});
				}else if(obj.id == 'select-unidade-medida'){
					$(this).select2({data:unidadeMedida});					
				}else if(obj.id == 'select-medida-caseira'){
					$(this).select2({data:medidaCaseira});
				}
			});
		}
		
		//Add row
		$('#add-row-btn').click(function(e){
			e.preventDefault();
			add();
			addRemoveListener();
			setSelect2();
		});
		
		//Delete row				
		function addRemoveListener(){
			$('.delete-row').each(function(){
				$(this).click(function(e){
					e.preventDefault();
					$(this).closest('.table-row').remove();
				});
			});	
		}
		
		//Add row
		function add(){
			//Clona a ultima linha
			var row = $('.table-row').last().clone(); 			
			row.find('.select2').remove();
			row.find('select').removeClass('select2-hidden-accessible');
			row.appendTo($('#table-rows'));
			//Adiciona botão de excluir na linha clonada se ela não contém um
			var btn = $.parseHTML('<button class="btn btn-danger delete-row ">Excluir</button>');
			var len = $('.btn-excluir-wrapper button', $('.table-row').last()).length;
			if(len == 0){
				$('.btn-excluir-wrapper').last().append(btn);			
			}
		}
	});
</script>
<jsp:include page="/template/foot.jsp"></jsp:include>

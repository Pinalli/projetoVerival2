
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<head>
		<!--link rel="stylesheet" href="./css/ficha.css"-->
</head>
<body>

<div class="container">
	    
<article>
	<form>
		<div class="form-group col-md-4 col-md-offset-4">
			<input type="text" name="nome" id="nome" class="form-control text-center" placeholder="Nome"/>
		</div>
	<div class="form-group col-md-12 text-center">
		<img class="img-responsive img-thumbnail" src="http://beeblob.blob.core.windows.net/pecadodevinhocom/2013/06/molho-pesto.jpg" width="305" align="middle" >
	</div>
	<div class="form-group col-md-4 col-md-offset-4">
		<input type="text" name="rendimento" id="rendimento" class="form-control text-center" placeholder="Rendimento"/>
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
	<div class="row table-row" style="border-bottom:1px solid #CCC;padding:5px 0;margin-bottom:5px;">
			<div class="form-group col-md-2 col-md-offset-1">
				<label for="select-ingredientes" class="hidden-md hidden-lg">Ingrediente</label> 
			    <select id="select-ingredientes" data-live-search="true" class="form-control select2">
			        <option value="1">Dente de alho</option>
			        <option value="2">Azeite de oliva extra virgem</option>
			        <option value="3">Parmesão ralado</option>
			        <option value="4">Pecorino ralado</option>
			        <option value="5">Pinoli</option>
			    </select>
			</div>
			<div class="form-group col-md-1">
				<label for="qnt-unidade-medida" class="hidden-md hidden-lg">Quantidade</label>
			    <input type="number" class="form-control" id="qnt-unidade-medida" placeholder="Qnt">
			</div>
			<div class="form-group col-md-2">
				<label for="select-unidade-medida" class="hidden-md hidden-lg">Unidade de medida</label>
			    <select id="select-unidade-medida" data-native-menu="false" class="form-control select2">
			        <option value="1">grama(s)</option>
			        <option value="2">mililitros(s)</option>
			        <option value="3">kilo(s)</option>
			        <option value="4">litro(s)</option>
			    </select>
			</div>
			<div class="form-group col-md-1">
				<label for="qnt-medida-caseira" class="hidden-md hidden-lg">Quantidade</label>
			    <input type="number" class="form-control" id="qnt-medida-caseira" placeholder="Qnt">
			</div>
			<div class="form-group col-md-2">
				<label for="select-medida-caseira" class="hidden-md hidden-lg">Medida Caseira</label>
			    <select id="select-medida-caseira" data-native-menu="false" class="form-control select2">
			        <option value="1">Unidade(s)</option>
			        <option value="2">Colher de sopa</option>
			    </select>
			</div>
			<div class="form-group col-md-2 btn-excluir-wrapper">
				
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
		//Select2
		$('.select2').select2();
		
		//Add row
		$('#add-row-btn').click(function(e){
			e.preventDefault();
			add();
			addRemoveListener();
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
			$('.table-row').last().clone().appendTo($('#table-rows'));
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


<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<head>
		<!--link rel="stylesheet" href="./css/ficha.css"-->
		<style>
		.horizontal-divider{
			height: 1px;
		    float: left;
		    width: 100%;
		    margin: 25px 0;
	    	background: #CCC;
		}
		.select2-selection--single{
			display: block !important;
		    width: 100% !important;
		    height: 34px !important;
		    padding: 6px 12px !important;
		    font-size: 14px !important;
		    line-height: 20px !important;
		    color: #555 !important;
		    background-color: #fbfbfb !important;
		    background-image: none !important;
		    border: 1px solid #ccc !important;
		    border-radius: 4px !important;
		    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075) !important;
		    box-shadow: inset 0 1px 1px rgba(0,0,0,.075) !important;
		    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s !important;
		    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s !important;
		    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s !important;
		}
		.select2-container--default .select2-selection--single .select2-selection__rendered{
			line-height: 20px !important;
		}
		</style>
</head>
<body>

<div class="container">
	    
<article>
	<form>
		<div class="form-group col-md-4 col-md-offset-4">
			<label for="nome" class="hidden-sm col-md-12 col-sm-12 col-xs-12 text-center">Nome</label>
			<input type="text" name="nome" id="nome" class="form-control text-center" placeholder="Nome"/>
		</div>
	<div class="form-group col-md-12 text-center" >
		<img class="img-responsive img-thumbnail" src="http://beeblob.blob.core.windows.net/pecadodevinhocom/2013/06/molho-pesto.jpg" width="305" align="middle"> 
		
		<center><input id="imgFile" name="fotoDaReceita" class="input-file" type="file" accept="image/*"></center>
		
	</div>
	
	<div class="col-xs-6 col-sm-4">
		<label for="rendimento" class="col-md-12 col-md-offset-9 form-control-static">Rendimento</label> 
	</div>
	<div class="col-xs-6 col-sm-4"> 
		<input type="text" name="rendimento" id="rendimento" class="form-control text-center box-transparent" placeholder="Rendimento"/>
	</div>
	
	<div class="row"><div class="col-md-9 col-md-offset-1 horizontal-divider"></div></div>
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
	<div class="table-row" style="padding:5px 0;margin-bottom:15px;width:100%;float:left;border-bottom:1px solid #D9D9D9;">
		<div class="col-md-12">
			<div class="form-group col-md-2 col-md-offset-1">
				<label for="select-ingredientes" class="hidden-md hidden-lg">Ingrediente</label> 
			    <select id="select-ingredientes" data-live-search="true" class="form-control selectBatata">
			    </select>
			</div>
			<div class="form-group col-md-1 col-xs-4">
				<label for="qnt-unidade-medida" class="hidden-md hidden-lg">Quantidade</label>
			    <input 
			    type="number" 
			    class="form-control" 
			    id="qnt-unidade-medida" 
			    placeholder="Qnt" 
			    min="1"
			    max ="9999"
			    NAME="qnt-unidade-medida" 
				onKeyDown="limitText(this,4);" 
				onKeyUp="limitText(this,4);"
				>
			</div>
			<div class="form-group col-md-2 col-xs-8">
				<label for="select-unidade-medida" class="hidden-md hidden-lg">Unidade de medida</label>
			    <select id="select-unidade-medida" data-native-menu="false" class="form-control selectBatata">
			    </select>
			</div>
			<div class="form-group col-md-1 col-xs-4">
				<label for="qnt-medida-caseira" class="hidden-md hidden-lg">Quantidade</label>
			    <input 
			    type="number" 
			    class="form-control" 
			    id="qnt-medida-caseira" 
			    placeholder="Qnt" 
			    min="0.1" 
			    max ="100"
			    step="0.1"
			    NAME="qnt-unidade-medida" 
				onKeyDown="limitText(this,4);" 
				onKeyUp="limitText(this,4);"
			    >
			</div>
			<div class="form-group col-md-2 col-xs-8">
				<label for="select-medida-caseira" class="hidden-md hidden-lg">Medida Caseira</label>
			    <select id="select-medida-caseira" data-native-menu="false" class="form-control selectBatata">
			    </select>
			</div>
			<div class="form-group col-md-1 btn-excluir-wrapper">
				
			</div>
			</div>
	</div>	
	</div>
	<div class="row">
		<div class="col-md-12">
		<div class="col-md-2 col-md-offset-8">
			<a class="btn btn-success pull-right" id="add-row-btn">Adicionar</a>
			</div>
		</div>
	</div>
	<div class="row"><div class="col-md-9 col-md-offset-1 horizontal-divider"></div></div>		
		<div class="row">
			<div class="col-md-9 col-md-offset-1">
			<div class="form-group">
			 	<label class="text-center col-md-12 col-sm-12 col-xs-12">Modo de Preparo</label>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		
			<div class="row">
			<div class="col-md-9 col-md-offset-1">
			<div class="form-group">
			 	<label class="text-center col-md-12 col-sm-12 col-xs-12">Montagem</label>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		<div class="row">	
			<div class="col-md-9 col-md-offset-1">
			<div class="form-group">
			 	<label class="text-center col-md-12 col-sm-12 col-xs-12">Orientações e armazenamento</label>
					<textarea rows="10" cols="" class="form-control"></textarea>	
				</div>
			</div>
		</div>
		<div class="row"><div class="col-md-9 col-md-offset-1 horizontal-divider"></div></div>
		<div class="row">	
			<div class="col-md-9 col-md-offset-1">
			<div class="form-group">
			 	<input type="reset" value="Limpar" class="btn btn-warning pull-left col-md-2 col-sm-2 col-xs-5"/>
			 	<input type="submit" value="Salvar" class="btn btn-success pull-right col-md-9 col-sm-9 col-xs-5"/>
			</div>
		</div>
	</form>

</article>

<!--footer>Ficha Técnica Simplificada</footer-->
</div>
</body>
<script>
	$(document).ready(function(){
		var ingredientes  = [{id:'1',text:'batata'}, {id:'2',text:'batata frita'}, {id:'3',text:'batata doce'}, {id:'4',text:'batata chips'}];
		var unidadeMedida = [{id:'1',text:'grama(s)'}, {id:'2',text:'quilo(s)'}];
		var medidaCaseira = [{id:'1',text:'Unidade(s)'}, {id:'2',text:'Colher de sopa'}];
		//Select2
		//$('.selectBatata').select2();
		setSelect2();
		
		function setSelect2(){
			//$('.selectBatata').select2();
			$('.selectBatata').each(function(i,obj){
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
			var btn = $.parseHTML('<button class="btn btn-danger delete-row pull-right" style="padding-left:20px;padding-right:20px;">Excluir</button>');
			var len = $('.btn-excluir-wrapper button', $('.table-row').last()).length;
			if(len == 0){
				$('.btn-excluir-wrapper').last().append(btn);			
			}
		}
	});
</script>
<script type="text/javascript">
	function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    }
}
</script>


<jsp:include page="/template/foot.jsp"></jsp:include>

function gerarPDF(elem) {
    var mywindow = window.open('', 'PRINT', 'height=800,width=1000');

    mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/bootstrap.min.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/bootstrap-theme.min.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/select2.min.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/select2-bootstrap.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/style.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/bootstrap-duallistbox.min.css'>" );
	mywindow.document.write( "<link rel='stylesheet' type='text/css' media='print' href='./css/bootstrap-datetimepicker.min.css'>" );
	
    mywindow.document.write('<html><head><title>' + document.title  + '</title>');
    mywindow.document.write('</head><body >');
    mywindow.document.write('<h1>' + document.title  + '</h1>');
    mywindow.document.write(document.getElementById(elem).innerHTML);
    mywindow.document.write('</body></html>');

    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10*/
    setTimeout(function(){
    	mywindow.print();
    	mywindow.close();
    },500);

    return true;
}

function preencheDados(infoRotulo, dadosFicha){
    $('#modalValorEnergeticoQP').html(infoRotulo.valorEnergeticoQP);
    $('#modalValorEnergeticoVD').html(infoRotulo.valorEnergeticoVD);
    $('#modalCarboidratosQP').html(infoRotulo.carboidratosQP);
    $('#modalCarboidratosVD').html(infoRotulo.carboidratosVD);
    $('#modalProteinasQP').html(infoRotulo.proteinasQP);
    $('#modalProteinasVD').html(infoRotulo.proteinasVD);
    $('#modalGordTotalQP').html(infoRotulo.gorduraTotalQP);
    $('#modalGordTotalVD').html(infoRotulo.gorduraTotalVD);
    $('#modalGordSaturadaQP').html(infoRotulo.gorduraSaturadaQP);
    $('#modalGordSaturadaVD').html(infoRotulo.gorduraSaturadaVD)
    $('#modalGordTransQP').html(infoRotulo.gorduraTransQP);
    $('#modalFibraAlimQP').html(infoRotulo.fibraAlimentarQP);
    $('#modalFibraAlimVD').html(infoRotulo.fibraAlimentarVD);
    $('#modalSodioQP').html(infoRotulo.sodioQP);
    $('#modalSodioVD').html(infoRotulo.sodioVD);
    
    $('#modalMedida').html(dadosFicha.qntMedida + " " + dadosFicha.unidadeMedida.siglaUnidadeMedida);
    $('#modalMedidaCaseira').html(dadosFicha.qntMedidaCaseira + " " + dadosFicha.unidadeMedidaCaseira.nome);
}

function carregaRotuloPDF(id) {

	gerarRotulo(id).done(function(result) {
		var resultAsJson = $.parseJSON(result);
		var infoRotulo = calculoRotulo(resultAsJson);
		preencheDados(infoRotulo, resultAsJson);
	});
}

function carragarDadosFicha(id) {
	buscaDadosFichaCompleta(id).done(function(result) {
		var dadosFicha = $.parseJSON(result);
		preencheDadosFichaCompleta(dadosFicha);
		preencheDadosFichaSimplificada(dadosFicha);
	});
}

function buscaDadosFichaCompleta(id) {
	return $.ajax({
		type: 'GET',
		url: 'ajax?acao=buscaDadosFichaCompletaAjaxCommand',
		data: {id: id},
		error: function() {
			console.log('Error on buscaDadosFichaCompletaAjaxCommand.');
		}
	});
}

function preencheDadosFichaCompleta(dadosFicha) {
	$('#nome-receita-ftc').html(dadosFicha.nome);
	$('#rendimento-ftc').html(dadosFicha.rendimento);
	$('#categoria-ftc').html(dadosFicha.categoria);
	$('#tempo-preparo-ftc').html(dadosFicha.tempoPreparo);
	$('#custo-total-ftc').html(dadosFicha.custoTotal);
	$('#custo-porcao-ftc').html(dadosFicha.custoPorcao);
	$('#utensilios-equipamentos-ftc').html(dadosFicha.utensilios);
	$('#modo-preparo-ftc').html(dadosFicha.modoPreparo);
	$('#montagem-ftc').html(dadosFicha.montagem);
	$('#orientacoes-armazenamento-ftc').html(dadosFicha.orientacoesArmazenamento);
	$('#textura-ftc').html(dadosFicha.textura);
	$('#sabor-ftc').html(dadosFicha.sabor);
	$('#apresentacao-ftc').html(dadosFicha.apresentacao);
	$('#temperatura-ftc').html(dadosFicha.temperatura);
	
	for(var i=0; i < dadosFicha.ingredientes.length; i++) {
		$('#ingredientes-ftc').append(
			'<tr>' +
				'<td>' + dadosFicha.ingredientes[i].ingrediente.descricao + '</td>' +
				'<td>' + dadosFicha.ingredientes[i].quantidadeMedida + ' ' + dadosFicha.ingredientes[i].unidadeMedida.siglaUnidadeMedida + '</td>' +
				'<td>' + dadosFicha.ingredientes[i].quantidadeMedidaCaseira + ' ' + dadosFicha.ingredientes[i].unidadeMedidaCaseira.nome + '</td>' +
				'<td>' + ' ' + '</td>' +
				'<td>' + ' ' + '</td>' +
				'<td>' + ' ' + '</td>' +
				'<td>' + ' ' + '</td>' +
			'</tr>'
		);
	}
}

function preencheDadosFichaSimplificada(dadosFicha) {
	$('#nome-receita-fts').html(dadosFicha.nome);
	$('#rendimento-fts').html(dadosFicha.rendimento);
	$('#categoria-fts').html(dadosFicha.categoria);
	$('#tempo-preparo-fts').html(dadosFicha.tempoPreparo);
	$('#utensilios-equipamentos-fts').html(dadosFicha.utensilios);
	$('#modo-preparo-fts').html(dadosFicha.modoPreparo);
	$('#montagem-fts').html(dadosFicha.montagem);
	$('#orientacoes-armazenamento-fts').html(dadosFicha.orientacoesArmazenamento);

	for(var i=0; i < dadosFicha.ingredientes.length; i++) {
		$('#ingredientes-fts').append(
			'<tr>' +
				'<td>' + dadosFicha.ingredientes[i].ingrediente.descricao + '</td>' +
				'<td>' + dadosFicha.ingredientes[i].quantidadeMedida + ' ' + dadosFicha.ingredientes[i].unidadeMedida.siglaUnidadeMedida + '</td>' +
				'<td>' + dadosFicha.ingredientes[i].quantidadeMedidaCaseira + ' ' + dadosFicha.ingredientes[i].unidadeMedidaCaseira.nome + '</td>' +
			'</tr>'
		);
	}
}
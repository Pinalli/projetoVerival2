function gerarRotulo(id) {
	return $.ajax({
		type: 'GET',
		url: 'ajax?acao=buscaDadosRotulo',
		data: {id: id},
		error: function() {
			console.log('Error on buscaDadosRotulo.');
		},
		success: function(data) {
			
		}
	});
		
}

function calculoRotulo(ingredientes) {
	
	var valorEnergetico = 0;
	var carboidratos = 0;
	var proteinas = 0;
	var gordTotal = 0;
	var gordSaturada = 0;
	var gordTrans = 0;
	var fibraAlim = 0;
	var sodio = 0;
	
	for (i = 0; i < ingredientes.length; i++) { 
		var kcal = ingredientes[i].kcalCarboidratos + ingredientes[i].kcalLipidios + ingredientes[i].kcalProteinas;

		valorEnergetico += kcal;
		carboidratos += ingredientes[i].carboidratos;
		proteinas += ingredientes[i].proteinas;
		gordTotal += ingredientes[i].lipidios;
		gordSaturada += ingredientes[i].gorduraSaturada;
		gordTrans += ingredientes[i].gorduraTrans;
		fibraAlim += ingredientes[i].fibrasAlimentares;
		sodio += ingredientes[i].sodio;
	}
	
//	Valor Energético - Necessidades diárias: 2.000 kcalorias
	var veKj = valorEnergetico * 4.1868;
	var veQP = parseFloat(valorEnergetico.toFixed(3)) + ' kcal = ' + parseFloat(veKj.toFixed(3)) + ' kj';
	var valorEnergeticoVD = (valorEnergetico*100)/2000;
	var veVD = parseFloat(valorEnergeticoVD.toFixed(3)) + '%'
	
//	Carboidratos - Necessidades diárias: 300g
	var carbQP = parseFloat(carboidratos.toFixed(3)) + ' g';
	var carboidratosVD = (carboidratos*100)/300;
	var carbVD = parseFloat(carboidratosVD.toFixed(3)) + '%';
	
//	Proteinas - Necessidades diárias: 75g
	var protQP = parseFloat(proteinas.toFixed(3)) + ' g';
	var proteinasVD = (proteinas*100)/75;
	var protVD = parseFloat(proteinasVD.toFixed(3)) + '%';
	
//	Gorduras totais - Necessidades diárias: 55g
	var gtotalQP = parseFloat(gordTotal.toFixed(3)) + ' g';
	var gordTotalVD = (gordTotal*100)/55;
	var gtotalVD = parseFloat(gordTotalVD.toFixed(3)) + '%';
	
//	Gorduras Saturadas - Necessidades diárias: 22g
	var gsQP = parseFloat(gordSaturada.toFixed(3)) + ' g';
	var gordSaturadaVD = (gordSaturada*100)/22;
	var gsVD = parseFloat(gordSaturadaVD.toFixed(3)) + '%';
	
//	Gorduras trans - Necessidades diárias: N/A
	var gtransQP = parseFloat(gordTrans.toFixed(3)) + ' g';
	var gordTransVD = (gordTrans*100)/22;
	var gtransVD = parseFloat(gordTransVD.toFixed(3)) + '%';
	
//	Fibra Alimentar - Necessidades diárias: 25g
	var faQP = parseFloat(fibraAlim.toFixed(3)) + ' g';
	var fibraAlimVD = (fibraAlim*100)/25;
	var faVD = parseFloat(fibraAlimVD.toFixed(3)) + '%';
	
//	Sodio - Necessidades diárias: 2.400mg
	var sQP = parseFloat(sodio.toFixed(3)) + ' mg';
	var sodioVD = (sodio*100)/2400;
	var sVD = parseFloat(sodioVD.toFixed(3)) + '%';

	var infoRotulo = {
			'valorEnergeticoOri' : valorEnergetico,
			'valorEnergeticoQP': veQP,
			'valorEnergeticoVD': veVD,
			'carboidratosOri' : carboidratos,
			'carboidratosQP' : carbQP,
			'carboidratosVD' : carbVD,
			'proteinasOri' : proteinas,
			'proteinasQP' : protQP,
			'proteinasVD' : protVD,
			'gorduraTotalOri' : gordTotal,
			'gorduraTotalQP' : gtotalQP,
			'gorduraTotalVD' : gtotalVD,
			'gorduraSaturadaOri' : gordSaturada,
			'gorduraSaturadaQP' : gsQP,
			'gorduraSaturadaVD' : gsVD,
			'gorduraTransOri' : gordTrans,
			'gorduraTransQP' : gtransQP,
			'gorduraTransVD' : gtransVD,
			'fibraAlimentarOri' : fibraAlim,
			'fibraAlimentarQP' : faQP,
			'fibraAlimentarVD' : faVD,
			'sodioOri' : sodio,
			'sodioQP' : sQP,
			'sodioVD' : sVD
	};
	
	return infoRotulo;
}
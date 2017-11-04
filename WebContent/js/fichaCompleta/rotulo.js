function gerarRotulo(id) {
	return $.ajax({
		type: 'GET',
		url: 'ajax?acao=buscaDadosRotulo',
		data: {id: id},
		error: function() {
			console.log('Error on buscaDadosRotulo.');
		}
	});
}

function getUnidadeMedida(id) {
	return $.ajax({
		url: "ajax?acao=buscaUnidadeMedidaPorIdAjax",
	    method: "GET",
	    data: {id: id},
		error: function() {
			console.log('Error on getUnidadeMedida.');
		}
	});
}

function calculoRotulo(fichaIngredientes) {

	var listFI = fichaIngredientes.fichaIngredientes;
	
	//em gramas
	var qntRotulo = calculaQntRotulo(fichaIngredientes); 
	
	var qntMedidaTotal = 0
	
	var valorEnergetico = 0;
	var carboidratos = 0;
	var proteinas = 0;
	var gordTotal = 0;
	var gordSaturada = 0;
	var gordTrans = 0;
	var fibraAlim = 0;
	var sodio = 0;

	for (i = 0; i < listFI.length; i++) {
		var unidadeMedida = conversaoDeMedida(listFI[i]);
		// Em gramas
		qntMedidaTotal += unidadeMedida.fatorConversao * listFI[i].quantidadeMedida;
	}
	
	for (i = 0; i < listFI.length; i++) {
		var unidadeMedida = conversaoDeMedida(listFI[i]);
		var taxaConversao = unidadeMedida.qntMedida * unidadeMedida.fatorConversao;
		
		/*// Em gramas
		qntMedidaTotal += unidadeMedida.fatorConversao * listFI[i].quantidadeMedida; 
		*/
		
		var kcal;
		if (listFI[i].ingrediente.kcal != null) {
			kcal = listFI[i].ingrediente.kcal;
		} else {
			kcal = listFI[i].ingrediente.kcalCarboidratos + listFI[i].ingrediente.kcalLipidios + listFI[i].ingrediente.kcalProteinas;
		}

		valorEnergetico += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * kcal));
		carboidratos += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.carboidratos));
		proteinas += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.proteinas));
		gordTotal += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.lipidios));
		gordSaturada += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.gorduraSaturada));
		gordTrans += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.gorduraTrans));
		fibraAlim += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.fibrasAlimentares));
		sodio += calculaProporcoes(qntRotulo, qntMedidaTotal, (taxaConversao * listFI[i].ingrediente.sodio));
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

function conversaoDeMedida(fichaIngrediente) {
	var um = fichaIngrediente.unidadeMedida;

	var conversaoDeMedida = {
			'unidadeMedida' : 'Grama',
			'siglaUnidadeMedida' : 'G',
			'fatorConversao' : conversorUnidadeMedida(um.siglaUnidadeMedida, "G"),
			'qntMedida' : fichaIngrediente.quantidadeMedida
	};
	
	return conversaoDeMedida;
}

function conversorUnidadeMedida(from, to) {
	switch(from.toUpperCase() + "_TO_" + to.toUpperCase()) {
		case "G_TO_MG":
			return 1000;
		case "G_TO_G":
			return 1;
		case "G_TO_KG":
			return 0.001;
		case "G_TO_ML":
			return 1;
		case "G_TO_L":
			return 0.001;
		case "MG_TO_G":
			return 0.001;
		case "KG_TO_G":
			return 1000;
		case "ML_TO_G":
			return 1;
		case "L_TO_G":
			return 1000;
	}
}

function retornaSiglaUnidadeMedidaPorNome(um) {
	var sigla;
	switch(um.toUpperCase()) {
		case "KILOGRAMA":
			sigla = "KG";
			break;
		case "GRAMA":
			sigla = "G";
			break;
		case "LITRO":
			sigla = "L";
			break;
		case "MILILITRO":
			sigla = "ML";
			break;
	}
	
	var unidadeMedida = {
		'unidadeMedida': um,
		'siglaUnidadeMedida': sigla
	};
	
	return unidadeMedida;
}

function retornaSiglaUnidadeMedidaPorId(umId) {
	var sigla;
	var um;
	switch(umId) {
		case '1':
			um: "KILOGRAMA"
			sigla = "KG";
			break;
		case '2':
			um: "GRAMA"
			sigla = "G";
			break;
		case '3':
			um: "LITRO"
			sigla = "L";
			break;
		case '4':
			um: "MILILITRO"
			sigla = "ML";
			break;
	}
	
	var unidadeMedida = {
		'idUnidadeMedida': umId,
		'unidadeMedida': um,
		'siglaUnidadeMedida': sigla
	};
	
	return unidadeMedida;
}

function calculaProporcoes(qntRotulo, qntTotal, valor) {
	// Regra de 3 para calcular propocao entre quantidade total de ingredientes e quantidade do rotulo
	var x = (valor*qntRotulo)/qntTotal;
	return x;
}

function calculaQntRotulo(fichaIngredientes) {
	var fatorConv = conversorUnidadeMedida(fichaIngredientes.unidadeMedida.siglaUnidadeMedida, "G");
	var result = fichaIngredientes.qntMedida * fatorConv;
	return result;
}
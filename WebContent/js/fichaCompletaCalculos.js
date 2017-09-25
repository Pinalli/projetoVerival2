function multiplica(tipo){
	switch (tipo) {
	case "cho":
		$("#cho").val($("#choHidden").val()*$("#qnt-unidade-medida").val());
		if ($('#cho').val().length > 5){
		       $('#cho').val($('#cho').val().substr(0, 5));       
		    }
		break;
	case "Carboidrato":
		$("#kcalcarboidratos").val($("#carboidratos").val()*4);
		if ($('#kcalcarboidratos').val().length > 5){
		       $('#kcalcarboidratos').val($('#kcalcarboidratos').val().substr(0, 5));       
		    }
		break;
	case "Lipidios":
		$("#kcallipidios").val($("#lipidios").val()*9);
		if ($('#kcallipidios').val().length > 5){
		       $('#kcallipidios').val($('#kcallipidios').val().substr(0, 5));       
		    }
		break;
	default:
		break;
	}
}

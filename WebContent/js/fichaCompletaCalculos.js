function multiplica(tipo){
	switch (tipo) {
	case "cho":
		if($("#qnt-unidade-medida").val()!=0){
			$("#choShow").val($("#cho").val()*$("#qnt-unidade-medida").val());
		}
		if ($('#choShow').val().length > 5){
		       $('#choShow').val($('#choShow').val().substr(0, 5));       
		    }
		break;
	case "ptn":
		if($("#qnt-unidade-medida").val()!=0){
			$("#ptnShow").val($("#ptn").val()*$("#qnt-unidade-medida").val());
		}
		if ($('#ptnShow').val().length > 5){
		       $('#ptnShow').val($('#ptnShow').val().substr(0, 5));       
		    }
		break;
	case "lip":
		if($("#qnt-unidade-medida").val()!=0){
			$("#lipShow").val($("#lip").val()*$("#qnt-unidade-medida").val());
		}
		if ($('#lipShow').val().length > 5){
		       $('#lipShow').val($('#lipShow').val().substr(0, 5));       
		    }
		break;
	case "kcal":
		if($("#qnt-unidade-medida").val()!=0){
			$("#kcalShow").val($("#kcal").val()*$("#qnt-unidade-medida").val());
		}
		if ($('#kcalShow').val().length > 5){
		       $('#kcalShow').val($('#kcalShow').val().substr(0, 5));       
		    }
		break;
	default:
		break;
	}
}

function multiplica(tipo){
	switch (tipo) {
	case "Proteinas":
		$("#kcalproteinas").val($("#proteinas").val()*4);
		break;
	case "Carboidrato":
		$("#kcalcarboidratos").val($("#carboidratos").val()*4);
		break;
	case "Lipidios":
		$("#kcallipidios").val($("#lipidios").val()*9);
		break;
	default:
		break;
	}
}

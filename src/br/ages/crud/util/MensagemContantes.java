package br.ages.crud.util;

public class MensagemContantes {
	//gerais: cadastro, login, logout
	public static final String MSG_ERR_CNPJ_INVALIDA = " campo cnpj invalido";
	public static final String MSG_ERR_CAMPO_CNPJ_MENOR_RECOMENDADO = "Campo ? com menos de 11 caracteres!";
	public static final String MSG_ERR_CAMPO_CNPJ_MAIOR_RECOMENDADO = "Campo ? com mais de 11 caracteres!";
	public static final String MSG_ERRO_CAMPO_SENHA_E_CONFIRMARRSENHA_DIFERENTES = "Campos Senha e Confirmar senha diferentes";
	public static final String MSG_ERR_CAMPO_OBRIGATORIO = "Campo ? obrigat�rio!";
	public static final String MSG_ERR_CAMPO_NOME_OBRIGATORIO = "Campo Nome obrigat�rio!";
	public static final String MSG_ERR_CAMPO_SEXO_OBRIGATORIO = "Campo Sexo obrigat�rio!";
	public static final String MSG_ERR_CAMPO_CIDADE_OBRIGATORIO = "Campo Cidade obrigat�rio!";
	public static final String MSG_ERR_CAMPO_ESTADO_OBRIGATORIO = "Campo Estado obrigat�rio!";
	public static final String MSG_ERR_CAMPO_LOGRADOURO_OBRIGATORIO = "Campo Logradouro obrigat�rio!";
	public static final String MSG_ERR_CAMPO_INVALIDO = "Campo ? inv�lido!";
	public static final String MSG_ERR_USUARIO_SENHA_INVALIDOS = "Usu�rio/Senha inv�lidos!";
	public static final String MSG_ERR_PESSOA_DADOS_INVALIDOS = "Dados da pessoa inv�lidos ou inconsistentes!";
	public static final String MSG_ERR_USUARIO_DADOS_INVALIDOS = "Dados do Usu�rio inv�lidos ou inconsistentes!";
	public static final String MSG_ERR_CAMPO_CPF_MAIOR_RECOMENDADO = "Campo ? com mais de 11 caracteres!";
	public static final String MSG_ERR_CAMPO_CPF_MENOR_RECOMENDADO = "Campo ? com menos de 11 caracteres!";
	public static final String MSG_ERR_CAMPO_DATA_MAIOR_RECOMENDADO = "Campo ? com mais de 10 caracteres!";
	public static final String MSG_ERR_CAMPO_DATA_MENOR_RECOMENDADO = "Campo ? com menos de 10 caracteres!";
	public static final String MSG_ERR_CAMPO_DATA_INVALIDO = "Ocorreu algum problema no envio da data";	
	public static final String MSG_ERR_SENHA_INVALIDA = "A senha do usuario � inv�lida: Deve ter no m�nimo 3 e no m�ximo 8 caracteres, apenas n�meros e letras!";
	public static final String MSG_ERR_CPF_INVALIDA = "CPF invalido!";
	public static final String MSG_ERR_CAMPO_ENDERECO_OBRIGATORIO = "Campo Endere�o obrigatorio!";
	public static final String MSG_ERR_CAMPO_TELEFONE_OBRIGATORIO = "Campo Telefone obrigatorio!";
	public static final String MSG_ERR_CAMPO_UF_OBRIGATORIO = "Campo UF obrigatorio!";
	public static final String MSG_ERR_EMAIL_INVALIDO = "E-mail com formato inv�lido.<br>n�o use acentua��o e caracteres especiais!<br>Exemplo correto: ages_user@acad.pucrs.br";
	public static final String MSG_ERR_NOME_INVALIDO = "Nome com formato inv�lido.<br>Exemplo correto: Jo�o Cardoso";
	public static final String MSG_ERR_USUARIO_JA_EXISTENTE = "Usu�rio ou matr�culaj� cadastrados!";
	public static final String MSG_ERR_REMOVE_USUARIO_EM_PROJETO = "Este Usu�rioj� est� em algum projeto e n�o pode ser removido!";
	public static final String MSG_SUC_CADASTRO_PESSOA = "Cadastro de Pessoa efetuado com sucesso!";
	public static final String MSG_SUC_CADASTRO_USUARIO = "Usu�rio ? cadastrado com sucesso!";
	public static final String MSG_SUC_EDICAO_USUARIO = "Usu�rio ? editado com sucesso!";
	public static final String MSG_SUC_REMOVE_USUARIO= "Usu�rio ? removido com sucesso!";
	public static final String MSG_SUC_ATUALIZADA_PESSOA = "Atualiza��o de Pessoa efetuada com sucesso!";
	public static final String MSG_INF_LOGOUT = "Logout do Usu�rio efetuado com sucesso!";
	public static final String MSG_INF_DENY = "Acesso negado! Voc� precisa logar primeiro.";
	public static final String MSG_INF_DENY_SELF = "Voc� n�o pode remover a si mesmo.";
	public static final String MSG_INF_SEM_PERISSAO = "Acesso negado! Voc� N�O tem permiss�o para acessar essa funcionalidade.";
	public static final String MSG_INF_PROBLEMA_ROTUDO = "N�o foi poss�vel gerar o R�tulo.";
	

	//msgs de unidades de medidas
	public static final String MSG_SUC_EDICAO_UNIDADE_MEDIDA = "Unidade ? editada com sucesso!";
	public static final String MSG_ERR_EDICAO_UNIDADE_MEDIDA = "Ocorreu um erro na edi��o da unidade de medida.";
	public static final String MSG_SUC_REMOVE_UNIDADE_MEDIDA = "Unidade de medida ? removida com sucesso!";
	public static final String MSG_SUC_CADASTRO_UNIDADE_MEDIDA = "Unidade de Medida ? cadastrada com sucesso!";
	public static final String MSG_ERR_UNIDADE_MEDIDA_JA_EXISTENTE = " Unidade de Medida j� cadastrada";
	public static final String MSG_ERR_UNIDADE_MEDIDA_DADOS_INVALIDOS = "Dados da Unidade de Medida inv�lidos ou inconsistentes!";
	public static final String MSG_ERR_UNIDADE_MEDIDA_DESCRICAO_ORIGEM_INVALIDA = "A descri��o da origem da unidade de medida deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_DESCRICAO_CONVERSAO_INVALIDA = "A descri��o da convers�o da unidade de medida deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_SINGLA_INVALIDA = "A sigla da unidade de medida deve ter de 1 a 10 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CONVERSAO_INVALIDA = "A medida de convers�o deve ser um n�mero.";
	public static final String MSG_ERR_REMOVE_UNIDADE_MEDIDA_EM_PROJETO = "Esta Unidade de Medida est� em algum projeto e n�o pode ser removido!";	
	
	//msgs das Unidades de Medida Caseira
	
	public static final String MSG_SUC_REMOVE_UNIDADE_MEDIDA_CASEIRA = "Unidade de medida caseira ? removida com sucesso";
	public static final String MSG_SUC_EDICAO_UNIDADE_MEDIDA_CASEIRA = " Unidade de Medida Caseira ? altera com sucesso!";
	public static final String MSG_SUC_CADASTRO_UNIDADE_MEDIDA_CASEIRA = "Unidade de Medida Caseira ? cadastrada com sucesso!";	
	public static final String MSG_ERR_EDICAO_UNIDADE_MEDIDA_CASEIRA = " Unidade de Medida Caseira ? n�o pode ser editada";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_JA_EXISTENTE = " Unidade de Medida Caseira ? j� cadastrada";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_DADOS_INVALIDOS = "Dados da Unidade de Medida Caseira inv�lidos ou inconsistentes!";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_NOME_INVALIDO = "A descri��o da origem da unidade de medida Caseira deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_SINGLA_INVALIDA = "A sigla da unidade de medida Caseira deve ter de 1 a 10 caracteres";
	public static final String MSG_ERR_REMOVE_UNIDADE_MEDIDA_CASEIRA_EM_PROJETO = "Esta Unidade de Medida Caseira est� em algum projeto e n�o pode ser removido!";
	
	//msgs das Ingredientes
	public static final String MSG_SUC_REMOVE_INGREDIENTE = " Ingrediente ? removida com sucesso";
	public static final String MSG_SUC_EDICAO_INGREDIENTE = " Ingrediente ? altera com sucesso!";
	public static final String MSG_SUC_CADASTRO_INGREDIENTE = " Ingrediente ? cadastrada com sucesso!";	
	public static final String MSG_ERR_EDICAO_INGREDIENTE = " Ingrediente ? n�o pode ser editada";
	public static final String MSG_ERR_INGREDIENTE_JA_EXISTENTE = " Ingrediente ? j� cadastrada";
	public static final String MSG_ERR_CODIGO_JA_USADO = "C�digo j� usado";
	public static final String MSG_ERR_INGREDIENTE_DADOS_INVALIDOS = "Dados da Ingrediente inv�lidos ou inconsistentes!";
	public static final String MSG_ERR_INGREDIENTE_NOME_INVALIDO = "A descri��o da origem da Ingrediente deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_INGREDIENTE_CODIGO_INVALID0 = "O c�digo do ingrediente deve ser somente n�meros";
	public static final String MSG_ERR_REMOVE_INGREDIENTE_EM_PROJETO = "Este Ingrediente est� em algum projeto e n�o pode ser removido!";
	
	//msgs de Empresa
	public static final String MSG_SUC_REMOVE_EMPRESA = " Empresa ? removida com sucesso";
	public static final String MSG_SUC_EDICAO_EMPRESA = " Empresa ? altera com sucesso!";
	public static final String MSG_SUC_CADASTRO_EMPRESA = " Empresa ? cadastrada com sucesso!";	
	public static final String MSG_ERR_EDICAO_EMPRESA = " Empresa ? n�o pode ser editada";
	public static final String MSG_ERR_EMPRESA_JA_EXISTENTE = " Empresa ? j� cadastrada";
	public static final String MSG_ERR_EMPRESA_DADOS_INVALIDOS = "Dados da Empresa inv�lidos ou inconsistentes!";
	public static final String MSG_ERR_EMPRESA_NOME_INVALIDO = "A descri��o da origem da Empresa deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_REMOVE_EMPRESA_EM_PROJETO = "Esta Empresa est� em algum projeto e n�o pode ser removido!";
	
	//msgs da ficha tecnica simplificada
	public static final String MSG_SUC_CADASTRO_FICHA_SIMPLIFICADA = " Ficha t�cnica simplificada ? cadastrada com sucesso!";
	public static final String MSG_SUC_REMOVE_FICHA_SIMPLIFICADA = "Ficha t�cnica simplificada ? removida com sucesso!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE = "Ficha t�cnica simplificada j� existente";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_DADOS_INVALIDOS = "Dados da ficha t�cnica inv�lido ou inconsistentes";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_NOME_FICHA_OBRIGATORIO = "Campo nome obrigat�rio!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO = "Campo rendimento obrigat�rio!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO = "Campo modo preparo obrigat�rio!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_MONTAGEM_FICHA_OBRIGATORIO = "Campo montagem obrigat�rio!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_ORIENTACAO_ARMAZENAMENTO_FICHA_OBRIGATORIO = "Campo orienta��o e armazenamento obrigat�rio!";
	public static final String MSG_ERR_REMOVE_FICHA_SIMPLIFICADA_EM_PROJETO = "Esta Ficha j� est� em algum projeto e n�o pode ser removido!";
	
	//msgs da ficha t�cnica completa
	public static final String MSG_SUC_CADASTRO_FICHA_COMPLETA = " Ficha t�cnica completa ? cadastrada com sucesso!";
	public static final String MSG_SUC_REMOVE_FICHA_COMPLETA = "Ficha t�cnica completa ? removida com sucesso!";
	public static final String MSG_ERR_FICHA_COMPLETA_JA_EXISTENTE = "Ficha t�cnica completa j� existente";
	public static final String MSG_ERR_FICHA_COMPLETA_DADOS_INVALIDOS = "Dados da ficha t�cnica inv�lido ou inconsistentes";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_NOME_FICHA_OBRIGATORIO = "Campo nome obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO = "Campo rendimento obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO = "Campo modo preparo obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_MONTAGEM_FICHA_OBRIGATORIO = "Campo montagem obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_ORIENTACAO_ARMAZENAMENTO = "Campo orienta��o e armazenamento obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_TEXTURA = "Campo textura obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_SABOR = "Campo sabor obrigat�rio!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_APRESENTACAO = "Campo apresenta��o obrigat�rio!";
	public static final String MSG_ERR_REMOVE_FICHA_COMPLETA_EM_PROJETO = "Esta Ficha j� est� em algum projeto e n�o pode ser removido!";
	
}
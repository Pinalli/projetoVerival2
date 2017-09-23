package br.ages.crud.util;

public class MensagemContantes {
	//gerais: cadastro, login, logout
	public static final String MSG_ERR_CNPJ_INVALIDA = " campo cnpj invalido";
	public static final String MSG_ERR_CAMPO_CNPJ_MENOR_RECOMENDADO = "Campo ? com menos de 11 caracteres!";
	public static final String MSG_ERR_CAMPO_CNPJ_MAIOR_RECOMENDADO = "Campo ? com mais de 11 caracteres!";
	public static final String MSG_ERRO_CAMPO_SENHA_E_CONFIRMARRSENHA_DIFERENTES = "Campos Senha e Confirmar senha diferentes";
	public static final String MSG_ERR_CAMPO_OBRIGATORIO = "Campo ? obrigatório!";
	public static final String MSG_ERR_CAMPO_NOME_OBRIGATORIO = "Campo Nome obrigatório!";
	public static final String MSG_ERR_CAMPO_SEXO_OBRIGATORIO = "Campo Sexo obrigatório!";
	public static final String MSG_ERR_CAMPO_CIDADE_OBRIGATORIO = "Campo Cidade obrigatório!";
	public static final String MSG_ERR_CAMPO_ESTADO_OBRIGATORIO = "Campo Estado obrigatório!";
	public static final String MSG_ERR_CAMPO_LOGRADOURO_OBRIGATORIO = "Campo Logradouro obrigatório!";
	public static final String MSG_ERR_CAMPO_INVALIDO = "Campo ? inválido!";
	public static final String MSG_ERR_USUARIO_SENHA_INVALIDOS = "Usuário/Senha inválidos!";
	public static final String MSG_ERR_PESSOA_DADOS_INVALIDOS = "Dados da pessoa inválidos ou inconsistentes!";
	public static final String MSG_ERR_USUARIO_DADOS_INVALIDOS = "Dados do Usuário inválidos ou inconsistentes!";
	public static final String MSG_ERR_CAMPO_CPF_MAIOR_RECOMENDADO = "Campo ? com mais de 11 caracteres!";
	public static final String MSG_ERR_CAMPO_CPF_MENOR_RECOMENDADO = "Campo ? com menos de 11 caracteres!";
	public static final String MSG_ERR_CAMPO_DATA_MAIOR_RECOMENDADO = "Campo ? com mais de 10 caracteres!";
	public static final String MSG_ERR_CAMPO_DATA_MENOR_RECOMENDADO = "Campo ? com menos de 10 caracteres!";
	public static final String MSG_ERR_CAMPO_DATA_INVALIDO = "Ocorreu algum problema no envio da data";	
	public static final String MSG_ERR_SENHA_INVALIDA = "A senha do usuario ï¿½ invï¿½lida: Deve ter no mï¿½nimo 3 e no mï¿½ximo 8 caracteres, apenas nï¿½meros e letras!";
	public static final String MSG_ERR_CPF_INVALIDA = "CPF invalido!";
	public static final String MSG_ERR_CAMPO_ENDERECO_OBRIGATORIO = "Campo Endereço obrigatorio!";
	public static final String MSG_ERR_CAMPO_TELEFONE_OBRIGATORIO = "Campo Telefone obrigatorio!";
	public static final String MSG_ERR_CAMPO_UF_OBRIGATORIO = "Campo UF obrigatorio!";
	public static final String MSG_ERR_EMAIL_INVALIDO = "E-mail com formato inválido.<br>não use acentuaï¿½ï¿½o e caracteres especiais!<br>Exemplo correto: ages_user@acad.pucrs.br";
	public static final String MSG_ERR_NOME_INVALIDO = "Nome com formato inválido.<br>Exemplo correto: Joï¿½o Cardoso";
	public static final String MSG_ERR_USUARIO_JA_EXISTENTE = "Usuário ou matrï¿½culajá cadastrados!";
	public static final String MSG_ERR_REMOVE_USUARIO_EM_PROJETO = "Este Usuáriojá está em algum projeto e não pode ser removido!";
	public static final String MSG_SUC_CADASTRO_PESSOA = "Cadastro de Pessoa efetuado com sucesso!";
	public static final String MSG_SUC_CADASTRO_USUARIO = "Usuário ? cadastrado com sucesso!";
	public static final String MSG_SUC_EDICAO_USUARIO = "Usuário ? editado com sucesso!";
	public static final String MSG_SUC_REMOVE_USUARIO= "Usuário ? removido com sucesso!";
	public static final String MSG_SUC_ATUALIZADA_PESSOA = "Atualização de Pessoa efetuada com sucesso!";
	public static final String MSG_INF_LOGOUT = "Logout do Usuário efetuado com sucesso!";
	public static final String MSG_INF_DENY = "Acesso negado! Você precisa logar primeiro.";
	public static final String MSG_INF_DENY_SELF = "Você não pode remover a si mesmo.";
	public static final String MSG_INF_SEM_PERISSAO = "Acesso negado! Você NÃO tem permissão para acessar essa funcionalidade.";
	public static final String MSG_INF_PROBLEMA_ROTUDO = "Não foi possível gerar o Rótulo.";
	

	//msgs de unidades de medidas
	public static final String MSG_SUC_EDICAO_UNIDADE_MEDIDA = "Unidade ? editada com sucesso!";
	public static final String MSG_ERR_EDICAO_UNIDADE_MEDIDA = "Ocorreu um erro na edição da unidade de medida.";
	public static final String MSG_SUC_REMOVE_UNIDADE_MEDIDA = "Unidade de medida ? removida com sucesso!";
	public static final String MSG_SUC_CADASTRO_UNIDADE_MEDIDA = "Unidade de Medida ? cadastrada com sucesso!";
	public static final String MSG_ERR_UNIDADE_MEDIDA_JA_EXISTENTE = " Unidade de Medida já cadastrada";
	public static final String MSG_ERR_UNIDADE_MEDIDA_DADOS_INVALIDOS = "Dados da Unidade de Medida inválidos ou inconsistentes!";
	public static final String MSG_ERR_UNIDADE_MEDIDA_DESCRICAO_ORIGEM_INVALIDA = "A descrição da origem da unidade de medida deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_DESCRICAO_CONVERSAO_INVALIDA = "A descrição da conversão da unidade de medida deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_SINGLA_INVALIDA = "A sigla da unidade de medida deve ter de 1 a 10 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CONVERSAO_INVALIDA = "A medida de conversão deve ser um número.";
	public static final String MSG_ERR_REMOVE_UNIDADE_MEDIDA_EM_PROJETO = "Esta Unidade de Medida está em algum projeto e não pode ser removido!";	
	
	//msgs das Unidades de Medida Caseira
	
	public static final String MSG_SUC_REMOVE_UNIDADE_MEDIDA_CASEIRA = "Unidade de medida caseira ? removida com sucesso";
	public static final String MSG_SUC_EDICAO_UNIDADE_MEDIDA_CASEIRA = " Unidade de Medida Caseira ? altera com sucesso!";
	public static final String MSG_SUC_CADASTRO_UNIDADE_MEDIDA_CASEIRA = "Unidade de Medida Caseira ? cadastrada com sucesso!";	
	public static final String MSG_ERR_EDICAO_UNIDADE_MEDIDA_CASEIRA = " Unidade de Medida Caseira ? não pode ser editada";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_JA_EXISTENTE = " Unidade de Medida Caseira ? já cadastrada";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_DADOS_INVALIDOS = "Dados da Unidade de Medida Caseira inválidos ou inconsistentes!";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_NOME_INVALIDO = "A descrição da origem da unidade de medida Caseira deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_UNIDADE_MEDIDA_CASEIRA_SINGLA_INVALIDA = "A sigla da unidade de medida Caseira deve ter de 1 a 10 caracteres";
	public static final String MSG_ERR_REMOVE_UNIDADE_MEDIDA_CASEIRA_EM_PROJETO = "Esta Unidade de Medida Caseira está em algum projeto e não pode ser removido!";
	
	//msgs das Ingredientes
	public static final String MSG_SUC_REMOVE_INGREDIENTE = " Ingrediente ? removida com sucesso";
	public static final String MSG_SUC_EDICAO_INGREDIENTE = " Ingrediente ? altera com sucesso!";
	public static final String MSG_SUC_CADASTRO_INGREDIENTE = " Ingrediente ? cadastrada com sucesso!";	
	public static final String MSG_ERR_EDICAO_INGREDIENTE = " Ingrediente ? não pode ser editada";
	public static final String MSG_ERR_INGREDIENTE_JA_EXISTENTE = " Ingrediente ? já cadastrada";
	public static final String MSG_ERR_CODIGO_JA_USADO = "Código já usado";
	public static final String MSG_ERR_INGREDIENTE_DADOS_INVALIDOS = "Dados da Ingrediente inválidos ou inconsistentes!";
	public static final String MSG_ERR_INGREDIENTE_NOME_INVALIDO = "A descrição da origem da Ingrediente deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_INGREDIENTE_CODIGO_INVALID0 = "O código do ingrediente deve ser somente números";
	public static final String MSG_ERR_REMOVE_INGREDIENTE_EM_PROJETO = "Este Ingrediente está em algum projeto e não pode ser removido!";
	
	//msgs de Empresa
	public static final String MSG_SUC_REMOVE_EMPRESA = " Empresa ? removida com sucesso";
	public static final String MSG_SUC_EDICAO_EMPRESA = " Empresa ? altera com sucesso!";
	public static final String MSG_SUC_CADASTRO_EMPRESA = " Empresa ? cadastrada com sucesso!";	
	public static final String MSG_ERR_EDICAO_EMPRESA = " Empresa ? não pode ser editada";
	public static final String MSG_ERR_EMPRESA_JA_EXISTENTE = " Empresa ? já cadastrada";
	public static final String MSG_ERR_EMPRESA_DADOS_INVALIDOS = "Dados da Empresa inválidos ou inconsistentes!";
	public static final String MSG_ERR_EMPRESA_NOME_INVALIDO = "A descrição da origem da Empresa deve ter de 1 a 60 caracteres";
	public static final String MSG_ERR_REMOVE_EMPRESA_EM_PROJETO = "Esta Empresa está em algum projeto e não pode ser removido!";
	
	//msgs da ficha tecnica simplificada
	public static final String MSG_SUC_CADASTRO_FICHA_SIMPLIFICADA = " Ficha técnica simplificada ? cadastrada com sucesso!";
	public static final String MSG_SUC_REMOVE_FICHA_SIMPLIFICADA = "Ficha técnica simplificada ? removida com sucesso!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE = "Ficha técnica simplificada já existente";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_DADOS_INVALIDOS = "Dados da ficha técnica inválido ou inconsistentes";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_NOME_FICHA_OBRIGATORIO = "Campo nome obrigatório!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO = "Campo rendimento obrigatório!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO = "Campo modo preparo obrigatório!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_MONTAGEM_FICHA_OBRIGATORIO = "Campo montagem obrigatório!";
	public static final String MSG_ERR_FICHA_SIMPLIFICADA_CAMPO_ORIENTACAO_ARMAZENAMENTO_FICHA_OBRIGATORIO = "Campo orientação e armazenamento obrigatório!";
	public static final String MSG_ERR_REMOVE_FICHA_SIMPLIFICADA_EM_PROJETO = "Esta Ficha já está em algum projeto e não pode ser removido!";
	
	//msgs da ficha técnica completa
	public static final String MSG_SUC_CADASTRO_FICHA_COMPLETA = " Ficha técnica completa ? cadastrada com sucesso!";
	public static final String MSG_SUC_REMOVE_FICHA_COMPLETA = "Ficha técnica completa ? removida com sucesso!";
	public static final String MSG_ERR_FICHA_COMPLETA_JA_EXISTENTE = "Ficha técnica completa já existente";
	public static final String MSG_ERR_FICHA_COMPLETA_DADOS_INVALIDOS = "Dados da ficha técnica inválido ou inconsistentes";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_NOME_FICHA_OBRIGATORIO = "Campo nome obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO = "Campo rendimento obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO = "Campo modo preparo obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_MONTAGEM_FICHA_OBRIGATORIO = "Campo montagem obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_ORIENTACAO_ARMAZENAMENTO = "Campo orientação e armazenamento obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_TEXTURA = "Campo textura obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_SABOR = "Campo sabor obrigatório!";
	public static final String MSG_ERR_FICHA_COMPLETA_CAMPO_APRESENTACAO = "Campo apresentação obrigatório!";
	public static final String MSG_ERR_REMOVE_FICHA_COMPLETA_EM_PROJETO = "Esta Ficha já está em algum projeto e não pode ser removido!";
	
}
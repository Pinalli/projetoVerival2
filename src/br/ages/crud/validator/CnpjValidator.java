package br.ages.crud.validator;

import java.util.Map;

import br.ages.crud.exception.ValidationException;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.util.Util;

public class CnpjValidator implements Validator {

	@Override
	public boolean validar(Map<String, Object> valores) throws ValidationException {
		String msgErro = "";
		for (String key : valores.keySet()) {
			String cnpj = (String) valores.get(key);

			if (!"".equals(cnpj)) {
				if (!Util.isCNPJ(cnpj)) {
					msgErro += MensagemContantes.MSG_ERR_CAMPO_INVALIDO.replace("?", key).concat("<br/>");
				}
				if (cnpj.length() < 11) {
					msgErro += MensagemContantes.MSG_ERR_CAMPO_CNPJ_MENOR_RECOMENDADO.replace("?", key).concat("<br/>");
				}
				if (cnpj.length() > 11) {				
					msgErro += MensagemContantes.MSG_ERR_CAMPO_CNPJ_MAIOR_RECOMENDADO.replace("?", key).concat("<br/>");
				}
			} else {
				msgErro += MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", key).concat("<br/>");
			}
		}
		if (!"".equals(msgErro)) {
			throw new ValidationException(msgErro);
		}

		return true;
	}

}

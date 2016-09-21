
package br.ages.crud.command;


import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.util.MensagemContantes;

public class AddUnidadeMedidaCommand implements Command {
	private String proxima;
	private UnidadeMedidaBO unidadeMedidaBO;
    @Override
    public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		unidadeMedidaBO = new UnidadeMedidaBO();
		proxima = "main?acao=telaUnidadeMedida";

		String descricaoUnidadeMedida = request.getParameter("unidadeMedida");
		String siglaUnidadeMedida = request.getParameter("siglaUnidadeMedida");
		String medidaConversao = request.getParameter("medidaConversao");
		double fatorConversao = Double.valueOf(request.getParameter("fatorConversao"));
		
		try {
			UnidadeMedida unidadeMedida = new UnidadeMedida();
			unidadeMedida.setUnidadeMedida(descricaoUnidadeMedida);
			unidadeMedida.setMedidaConversao(medidaConversao);
			unidadeMedida.setSiglaUnidadeMedida(siglaUnidadeMedida);
			unidadeMedida.setFatorConversao(fatorConversao);
			
			boolean isValido = unidadeMedidaBO.validaUnidadeMedida(unidadeMedida);
			if (isValido == false) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso
				unidadeMedidaBO.cadastrarUnidadeMedida(unidadeMedida);
				proxima = "main?acao=listUnidadeMedida";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_UNIDADE_MEDIDA.replace("?", unidadeMedida.getSiglaUnidadeMedida()));

			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}

		return proxima;
    }
}


package br.ages.crud.command;


import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.StatusUsuario;
import br.ages.crud.model.TipoUsuario;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class AddUnidadeMedidaCommand implements Command {
	private String proxima;
	private UnidadeMedidaBO unidadeMedidaBO;
    @Override
    public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		unidadeMedidaBO = new UnidadeMedidaBO();
		proxima = "main?acao=telaUnidadeMedida";

		String descricaoOrigem = request.getParameter("descricaoOrigem");
		String descricaoConversao = request.getParameter("descricaoConversao");
		String sigla = request.getParameter("sigla");
		int medidaConversao = Integer.valueOf(request.getParameter("medidaConversao"));
		
		try {
			UnidadeMedida unidadeMedida = new UnidadeMedida();
			unidadeMedida.setDescricaoOrigem(descricaoOrigem);
			unidadeMedida.setDescricaoConversao(descricaoConversao);
			unidadeMedida.setSigla(sigla);
			unidadeMedida.setMedidaConversao(medidaConversao);
			
			boolean isValido = unidadeMedidaBO.validaUnidadeMedida(unidadeMedida);
			if (isValido == false) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso
				unidadeMedidaBO.cadastrarUnidadeMedida(unidadeMedida);
				proxima = "main?acao=listUnidadeMedida";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_UNIDADE_MEDIDA.replace("?", unidadeMedida.getSigla()));

			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}

		return proxima;
    }
}

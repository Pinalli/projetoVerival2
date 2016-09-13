package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class RemoveUnidadeMedidaCommand implements Command {

	private String proximo;

	private UnidadeMedidaBO unidadeMedidaBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listUnidadeMedida";
		this.unidadeMedidaBO = new UnidadeMedidaBO();		
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioSessao");
		
		try {
			if( !usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_DENY);
			
			Integer idUnidadeMedida = Integer.parseInt(request.getParameter("id_unidadeMedida"));
			unidadeMedidaBO.removerUnidadeMedida(idUnidadeMedida);
			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_UNIDADE_MEDIDA.replace("?", idUnidadeMedida.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}

}


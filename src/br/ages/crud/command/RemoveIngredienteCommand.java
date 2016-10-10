package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.model.PerfilAcesso;


public class RemoveIngredienteCommand implements Command {

	private String proximo;

	private IngredienteBO ingredienteBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listIngrediente";
		this.ingredienteBO = new IngredienteBO();		
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioSessao");
		
		try {
			if( !usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERISSAO);
			
			Integer idIngrediente = Integer.parseInt(request.getParameter("idIngrediente"));
			ingredienteBO.removerIngrediente(idIngrediente);
			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_INGREDIENTE.replace("?", idIngrediente.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}

}


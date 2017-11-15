package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.FichaCompletaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class RemoveFichaCompletaCommand implements Command{
	
	private String proximo;

	private FichaCompletaBO fichaCompletaBO;
	
	
	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listFichaCompleta";
		
		this.fichaCompletaBO = new FichaCompletaBO();
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioSessao");
		
		try{
			if( !usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERISSAO);
			
			Integer idFicha = Integer.parseInt(request.getParameter("id_ficha_Completa"));
			Ficha ficha = fichaCompletaBO.buscaIdFicha(idFicha);
			fichaCompletaBO.removerFichaCompleta(idFicha);
			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_FICHA_COMPLETA.replace("?", ficha.getNome().toString()).concat("<br/>"));
		}catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
		
	}

}

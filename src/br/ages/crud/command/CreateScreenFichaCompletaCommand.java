package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.FichaCompletaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class CreateScreenFichaCompletaCommand implements Command {


	private String proxima;

	public String execute(HttpServletRequest request) throws SQLException {		
		proxima = "main?acao=listFichaCompleta";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");

		try {			
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERISSAO);
			
			String isEdit = request.getParameter("isEdit");
			
			if (isEdit != null && !"".equals(isEdit)) {
				
				FichaCompletaBO fichaCompletaBO = new FichaCompletaBO();
				
				int id = Integer.parseInt(request.getParameter("id_ficha_Completa"));
				Ficha ficha= fichaCompletaBO.buscaIdFicha(id);
				
				
				request.setAttribute("ficha", ficha);
				proxima = "fichaCompleta/editFichaCompleta.jsp";
				
			} else {
				proxima = "fichaCompleta/addFichaCompleta.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}

package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class CreateScreenFichaSimplificadaCommand implements Command {

	private String proxima;


	public String execute(HttpServletRequest request) throws SQLException {		
		proxima = "main?acao=listFichaSimplificada";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");

		try {			
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERISSAO);
			
			String isEdit = request.getParameter("isEdit");
			
			if (isEdit != null && !"".equals(isEdit)) {
				
				FichaSimplificadaBO fichaSimplificadaBO = new FichaSimplificadaBO();
				
				int id = Integer.parseInt(request.getParameter("id_ficha_simplificada"));
				Ficha ficha= fichaSimplificadaBO.buscaIdFicha(id);
				
				
				request.setAttribute("ficha", ficha);
				proxima = "fichaSimplificada/editFichaSimplificada.jsp";
				
			} else {
				proxima = "fichaSimplificada/addFichaSimplificada.jsp";
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}

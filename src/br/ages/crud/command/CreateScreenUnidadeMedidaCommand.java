package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.util.MensagemContantes;
/**
 * 
 * @author iann muller
 *
 */
public class CreateScreenUnidadeMedidaCommand implements Command {

	private String proxima;

	private UnidadeMedidaBO unidadeMedidaBO;
		
	//private StakeholderBO stakeholderBO;

	public String execute(HttpServletRequest request) throws SQLException {
		proxima = "main?acao=listUnidadeMedida";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");

		try {			
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERISSAO);
			// Verifica se abre tela edição de pessoa ou de adição de pessoa.
			
			String isEdit = request.getParameter("isEdit");
			
			if (isEdit != null && !"".equals(isEdit)) {
				
				unidadeMedidaBO = new UnidadeMedidaBO();
				
				int id = Integer.parseInt(request.getParameter("id_unidadeMedida"));
				UnidadeMedida unidadeMedida = unidadeMedidaBO.buscaUnidadeMedidaId(id);
				
				
				request.setAttribute("unidadeMedida", unidadeMedida);
				proxima = "unidadeMedida/editUnidadeMedida.jsp";
				
			} else { // Adiciona um novo usuário
				proxima = "unidadeMedida/addUnidadeMedida.jsp";		
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}

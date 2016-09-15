package br.ages.crud.command;

import java.sql.SQLException;

//comentario nada a ver para o lucas poder pegar a classe :)
import javax.servlet.http.HttpServletRequest;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.MensagemContantes;

public class CreateScreenUnidadeMedidaCaseiraCommand implements Command {

	private String proxima;

	private UnidadeMedidaCaseiraBO unidadeMedidaCaseiraBO;
		
	//private StakeholderBO stakeholderBO;

	public String execute(HttpServletRequest request) throws SQLException {
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");

		try {			
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_DENY);
			// Verifica se abre tela edi��o de pessoa ou de adi��o de pessoa.
			
			String isEdit = request.getParameter("isEdit");
			
			if (isEdit != null && !"".equals(isEdit)) {
				
				unidadeMedidaCaseiraBO = new UnidadeMedidaCaseiraBO();
				
				int id = Integer.parseInt(request.getParameter("id_unidade_medida_caseira"));
				UnidadeMedidaCaseira unidadeMedidaCaseira = unidadeMedidaCaseiraBO.buscaUnidadeMedidaCaseiraId(id);
				
				
				request.setAttribute("unidadeMedidaCaseira", unidadeMedidaCaseira);
				proxima = "unidadeMedidaCaseira/editUnidadeMedidaCaseira.jsp";
				
			} else { 
				proxima = "unidadeMedidaCaseira/addUnidadeMedidaCaseira.jsp";
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}
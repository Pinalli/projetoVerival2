package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.Usuario;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.util.MensagemContantes;
/**
 * 
 * @author iann muller
 *
 */
public class CreateScreenIngredientesCommand implements Command {

	private String proxima;

	private UnidadeMedidaBO unidadeMedidaBO;
	private IngredienteBO ingredienteBO;
	
	//private StakeholderBO stakeholderBO;

	public String execute(HttpServletRequest request) throws SQLException {
		proxima = "main?acao=listIngrediente";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");

		try {
			this.unidadeMedidaBO = new UnidadeMedidaBO();
			List<UnidadeMedida> listaUnidadesMedida = unidadeMedidaBO.listarUnidadesMedida();
			request.setAttribute("listaUnidadesMedida", listaUnidadesMedida);
			
			String isEdit = request.getParameter("isEdit");
			
			if (isEdit != null && !"".equals(isEdit)) {
				
				ingredienteBO = new IngredienteBO();
				
				int id = Integer.parseInt(request.getParameter("idIngrediente"));
				Ingrediente ingrediente = ingredienteBO.buscaIngredienteId(id);
				
				
				request.setAttribute("ingrediente", ingrediente);
				proxima = "Ingredientes/editIngredientes.jsp";
				
			} else { // Vai pra tela de ingredientes
				
				
				
				proxima = "Ingredientes/addIngredientes.jsp";	
				
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}

package br.ages.crud.command;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ingrediente;

public class ListIngredienteCommand implements Command {

	private String proxima;
	private IngredienteBO ingredienteBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.ingredienteBO = new IngredienteBO();
		proxima = "Ingredientes/listIngredientes.jsp";

		try {
			List<Ingrediente> listaIngredientes = ingredienteBO.listarIngrediente();
			request.setAttribute("listaIngredientes", listaIngredientes);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}

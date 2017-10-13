package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.model.UnidadeMedida;

public class BuscaUnidadeMedidaPorIdAjaxCommand implements Command {

	private String proxima;
	private UnidadeMedidaBO unidadeMedidaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.unidadeMedidaBO = new UnidadeMedidaBO();
		String json = "";
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			UnidadeMedida um = unidadeMedidaBO.buscaUnidadeMedidaId(id);
			Gson gson = new Gson();
			json = gson.toJson(um);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}

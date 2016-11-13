package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class BuscaIngredienteIdAjaxCommand implements Command {

	private String proxima;
	private IngredienteBO ingredienteBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.ingredienteBO = new IngredienteBO();
		String json = "";
		int id = Integer.parseInt(request.getParameter("id"));
		try {			
			Ingrediente ingrediente = ingredienteBO.buscaIngredienteId(id);			
			Gson gson = new Gson();
			json = gson.toJson(ingrediente);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}

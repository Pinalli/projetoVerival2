package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.Ingrediente;

import java.util.ArrayList;
import java.util.List;

public class BuscaIngredienteDescricaoAjaxCommand implements Command {

	private String proxima;
	private IngredienteBO ingredienteBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.ingredienteBO = new IngredienteBO();
		String json = "";
		String descricao = request.getParameter("descricao");
		int limit = Integer.parseInt(request.getParameter("limit"));
		try {
			ArrayList<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>(); 
			if(descricao == null){
				listaIngredientes = ingredienteBO.buscaIngredientes(0, 10);				
			}else{
				listaIngredientes = ingredienteBO.buscaIngredienteDescricao(descricao, limit);
			}
			Gson gson = new Gson();
			json = gson.toJson(listaIngredientes);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}

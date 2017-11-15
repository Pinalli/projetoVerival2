package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.FichaCompletaBO;
import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.model.Ingrediente;

public class BuscaInformacoesRotuloAjaxCommand implements Command {

	private String proxima;
	private FichaCompletaBO fichaCompletaBO;
	private IngredienteBO ingredienteBO;
	
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.fichaCompletaBO = new FichaCompletaBO();
		this.ingredienteBO = new IngredienteBO();
		String json = "";
		int id = Integer.parseInt(request.getParameter("id"));
		try {			
			Ficha ficha = fichaCompletaBO.buscaIdFicha(id);
			for(FichaItem fi:ficha.getItens()) {
				ingredienteBO.buscaIngredienteId(fi.getIdIngrediente());
			}
			
			
			
			
			
			
			
			//Ingrediente ingrediente = fichaCompletaBO.buscaIngredienteId(id);			
			Gson gson = new Gson();
			//json = gson.toJson(ingrediente);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}

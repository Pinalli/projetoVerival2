package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.FichaCompletaBO;
import br.ages.crud.model.Ficha;

public class BuscaDadosFichaCompletaAjaxCommand implements Command {

	private String proxima;
	private FichaCompletaBO fichaCompletaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.fichaCompletaBO = new FichaCompletaBO();
		String json = "";
		int id = Integer.parseInt(request.getParameter("id"));
		try {			
			Ficha dadosRotulo = fichaCompletaBO.buscarDadosFichaCompleta(id);			
			Gson gson = new Gson();
			json = gson.toJson(dadosRotulo);
			request.setAttribute("json", json);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}
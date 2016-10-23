package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.model.UnidadeMedidaCaseira;

public class BuscaUnidadeMedidaCaseiraNomeAjaxCommand implements Command {

	private String proxima;
	private UnidadeMedidaCaseiraBO unidadeMedidaCaseiraBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.unidadeMedidaCaseiraBO = new UnidadeMedidaCaseiraBO();
		String json = "";
		String nome = request.getParameter("nome");
		int limit = Integer.parseInt(request.getParameter("limit"));
		
		try {
			ArrayList<UnidadeMedidaCaseira> listaUnidadeMedidaCaseira = new ArrayList<UnidadeMedidaCaseira>(); 
			if(nome == null){
				listaUnidadeMedidaCaseira = unidadeMedidaCaseiraBO.buscaUnidadesMedidaCaseira(0, 10);				
			}else{
				listaUnidadeMedidaCaseira = unidadeMedidaCaseiraBO.buscaUnidadeMedidaCaseiraNome(nome, limit);
			}
			Gson gson = new Gson();
			json = gson.toJson(listaUnidadeMedidaCaseira);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}

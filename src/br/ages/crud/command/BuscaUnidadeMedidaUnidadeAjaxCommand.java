package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.model.UnidadeMedida;

public class BuscaUnidadeMedidaUnidadeAjaxCommand implements Command {

	private String proxima;
	private UnidadeMedidaBO unidadeMedidaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.unidadeMedidaBO = new UnidadeMedidaBO();
		String json = "";
		String unidade = request.getParameter("unidade");
		int limit = Integer.parseInt(request.getParameter("limit"));
		
		try {
			ArrayList<UnidadeMedida> listaUnidadeMedida = new ArrayList<UnidadeMedida>(); 
			if(unidade == null){
				listaUnidadeMedida = unidadeMedidaBO.buscaUnidadesMedida(0, 10);				
			}else{
				listaUnidadeMedida = unidadeMedidaBO.buscaUnidadesMedidaUnidade(unidade, limit);
			}
			Gson gson = new Gson();
			json = gson.toJson(listaUnidadeMedida);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}

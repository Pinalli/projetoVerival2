//package br.ages.crud.command;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.google.gson.Gson;
//
//import br.ages.crud.bo.FichaCompletaBO;
//import br.ages.crud.model.FichaIngrediente;
//
//public class BuscaDadosRotuloAjaxCommand implements Command {
//
//	private String proxima;
//	private FichaCompletaBO fichaCompletaBO;
//	
//	@Override
//	public String execute(HttpServletRequest request) throws SQLException {
//		this.fichaCompletaBO = new FichaCompletaBO();
//		String json = "";
//		int id = Integer.parseInt(request.getParameter("id"));
//		try {			
//			List<FichaIngrediente> ingredientes = fichaCompletaBO.buscarDadosRotulo(id);			
//			Gson gson = new Gson();
//			json = gson.toJson(ingredientes);
//			request.setAttribute("json", json);			
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("msgErro", e.getMessage());
//		}
//		return json.toString();
//	}
//}

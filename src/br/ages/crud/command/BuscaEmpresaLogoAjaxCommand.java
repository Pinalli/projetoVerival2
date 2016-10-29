package br.ages.crud.command;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.EmpresaBO;

public class BuscaEmpresaLogoAjaxCommand implements Command {

	private String proxima;
	private EmpresaBO empresaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		this.empresaBO = new EmpresaBO();
		String json = "";
		String logo = "";
		int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
		try {
			logo = this.empresaBO.buscaLogoEmpresaId(idEmpresa);
			Gson gson = new Gson();
			json = gson.toJson(logo);
			request.setAttribute("json", json);			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}
		return json.toString();
	}
}
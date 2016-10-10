package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Empresa;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.Usuario;

/**
 * @author 11100102
 *
 */
public class ListEmpresaCommand implements Command {
	
	private String proxima;
	private EmpresaBO empresaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		this.empresaBO = new EmpresaBO();
		proxima = "empresa/listEmpresa.jsp";
		try {
			List<Empresa> listaEmpresa = empresaBO.listarEmpresa();
			request.setAttribute("listaEmpresa", listaEmpresa);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}


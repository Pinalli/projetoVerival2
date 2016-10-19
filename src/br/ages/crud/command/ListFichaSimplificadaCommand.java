package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.Usuario;

/**
 * @author 11100102
 *
 */
public class ListFichaSimplificadaCommand implements Command {
	
	private String proxima;
	private FichaSimplificadaBO fichaSimplificadaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		this.fichaSimplificadaBO = new FichaSimplificadaBO();
		proxima = "fichaSimplificada/listFichaSimplificada.jsp";
		try {
			List<Ficha> listaFichaSimplificada = fichaSimplificadaBO.listarFichaSimplificada();
			request.setAttribute("listaFichaSimplificada", listaFichaSimplificada);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}


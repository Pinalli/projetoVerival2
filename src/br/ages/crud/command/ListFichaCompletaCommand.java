package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.FichaCompletaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;

public class ListFichaCompletaCommand implements Command {
	
	private String proxima;
	private FichaCompletaBO fichaCompletaBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		this.fichaCompletaBO = new FichaCompletaBO();
		proxima = "fichaCompleta/listFichaCompleta.jsp";
		try {
			List<Ficha> listaFichaCompleta = fichaCompletaBO.listarFichaCompleta();
			request.setAttribute("listaFichaCompleta", listaFichaCompleta);
		} catch (NegocioException e) {
			e.printStackTrace();
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}

}


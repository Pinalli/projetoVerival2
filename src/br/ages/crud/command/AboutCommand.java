package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.Util;

public class AboutCommand implements Command {
	private String proxima;
	@Override
	public String execute(HttpServletRequest request)
			throws SQLException, NegocioException, ParseException, PersistenciaException {
		proxima = "about.jsp";
		return proxima;

	}

}

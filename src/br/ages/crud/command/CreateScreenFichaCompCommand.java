package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Empresa;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class CreateScreenFichaCompCommand implements Command {


	private String proxima;

	
	public String execute(HttpServletRequest request) throws SQLException {
		proxima = "fichaCompleta/telaFichaCompleta.jsp";
		
		return proxima;
	}

}

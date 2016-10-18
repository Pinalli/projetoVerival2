package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;

import br.ages.crud.dao.FichaSimplificadaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;

/**
 * @author Alessandro
 */

public class FichaSimplificadaBO {
	
	private FichaSimplificadaDAO fichaSimplificadaDAO = null;
	
	public FichaSimplificadaBO(){
		fichaSimplificadaDAO = new FichaSimplificadaDAO();
	}
	
	public void cadastrarFichaSimplificada(Ficha fichaSimplificada)throws NegocioException, SQLException, ParseException {
		
		try{
			fichaSimplificadaDAO.cadastrarFichaSimplificada(fichaSimplificada);
		} catch(PersistenciaException e){
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

}

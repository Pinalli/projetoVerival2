package br.ages.crud.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.crud.dao.FichaSimplificadaItemDAO;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.FichaItem;

public class FichaSimplificadaItemBO {

	private FichaSimplificadaItemDAO itemDAO;

	public FichaSimplificadaItemBO() {
		super();
		itemDAO = new FichaSimplificadaItemDAO();
	}

	public List<FichaItem> listaFichaSimplificadaItem(int idFichaSimplificada)
			throws PersistenciaException, SQLException {
		return itemDAO.listaFichaSimplificadaItem(idFichaSimplificada);
	}

	public int cadastrarFichaSimplificada(FichaItem item) throws PersistenciaException, SQLException {
		return itemDAO.cadastrarFichaSimplificadaDAO(item);
	}

	public boolean editarFichaSimplificadaItem(FichaItem item) throws PersistenciaException, SQLException {
		return itemDAO.editarFichaSimplificadaItem(item);
	}

	public boolean removerFichaTecnicaItem(Integer idFichaItem) throws PersistenciaException {
		return itemDAO.removerFichaTecnicaItem(idFichaItem);
	}

	public boolean removerTodosFichaTecnicaItem(Integer idFicha) throws PersistenciaException {
		return itemDAO.removerTodosFichaTecnicaItem(idFicha);
	}
	
	
	
	
	
}

package br.ages.crud.bo;

import java.sql.SQLException;
import java.util.List;

import br.ages.crud.dao.FichaCompletaItemDAO;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.FichaItem;

public class FichaCompletaItemBO {

	private FichaCompletaItemDAO itemDAO;

	public FichaCompletaItemBO() {
		super();
		itemDAO = new FichaCompletaItemDAO();
	}

	public List<FichaItem> listaFichaCompletaItem(int idFichaCompleta)
			throws PersistenciaException, SQLException {
		return itemDAO.listaFichaCompletaItem(idFichaCompleta);
	}

	public int cadastrarFichaCompleta(FichaItem item) throws PersistenciaException, SQLException {
		return itemDAO.cadastrarFichaCompletaDAO(item);
	}

	public boolean editarFichaCompletaItem(FichaItem item) throws PersistenciaException, SQLException {
		return itemDAO.editarFichaCompletaItem(item);
	}

	public boolean removerFichaTecnicaItem(Integer idFichaItem) throws PersistenciaException {
		return itemDAO.removerFichaTecnicaItem(idFichaItem);
	}

	public boolean removerTodosFichaTecnicaItem(Integer idFicha) throws PersistenciaException {
		return itemDAO.removerTodosFichaTecnicaItem(idFicha);
	}
	
	
	
	
	
}

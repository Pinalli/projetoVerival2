package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ages.crud.dao.IngredienteDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.validator.SenhaValidator;

/**
 * Gerencia os comportamentos de negocio do Ingrediente Associa os parametros da
 * tela as propriedades da classe
 * 
 * @author Santana
 * 
 */
public class IngredienteBO {
	
	private IngredienteDAO ingredienteDAO = null;

	public IngredienteBO() {
		ingredienteDAO = new IngredienteDAO();
	}

	
	public void cadastraIngrediente(Ingrediente ingrediente) throws NegocioException, SQLException, ParseException {

		try {
			ingredienteDAO.cadastrarIngrediente(ingrediente);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	public void editaIngrediente(Ingrediente ingrediente) throws NegocioException, SQLException, ParseException {

		try {
			ingredienteDAO.editaIngrediente(ingrediente);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}
	
	/**
	 * Lista as pessoas a partir das classes de DAO
	 * 
	 * @return
	 * @throws NegocioException
	 */
	public List<Ingrediente> listarIngrediente() throws NegocioException {

		List<Ingrediente> listIngrediente = null;

		try {
			listIngrediente = ingredienteDAO.listarIngredientes();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listIngrediente;

	}

	public Ingrediente buscaIngredienteId(int codigo) throws NegocioException {
		try {
			Ingrediente ingrediente = ingredienteDAO.buscaIngredienteCodigo(codigo);

			return ingrediente;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public Ingrediente buscaIngredienteDescricao(String descricao) throws NegocioException {
		try {
			Ingrediente ingrediente = ingredienteDAO.buscaIngredienteDescricao(descricao);

			return ingrediente;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public void setIngredienteDAO(IngredienteDAO ingredienteDAO) {
		this.ingredienteDAO = ingredienteDAO;
	}
}

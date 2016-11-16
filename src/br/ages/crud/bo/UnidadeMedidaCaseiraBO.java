package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.dao.UnidadeMedidaCaseiraDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.MensagemContantes;

/**
 * Gerencia os comportamentos de negocio da Unidade de Medida Caseira Associa os parametros da
 * tela as propriedades da classe
 * 
 * @author Cassio Trindade
 * @author Ricardo Borges
 *  
 */
public class UnidadeMedidaCaseiraBO {
	
	private UnidadeMedidaCaseiraDAO unidadeMedidaCaseiraDAO = null;

	public UnidadeMedidaCaseiraBO() {
		unidadeMedidaCaseiraDAO = new UnidadeMedidaCaseiraDAO();
	}

	/**
	 * Valida os dados da unidade de medida caseira na tela de cadastro com erros aglutinados
	 * 
	 * @param unidadeMedidaCaseira
	 * @return
	 * @throws NegocioException
	 */
	public boolean validaUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira) throws NegocioException {
		boolean isValido = true;		
		
		StringBuilder msg = new StringBuilder();
		msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_CASEIRA_DADOS_INVALIDOS.concat("<br/>"));
		
		try{			
			if (unidadeMedidaCaseira.getNome().length() < 1 || unidadeMedidaCaseira.getNome().length() > 120) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_CASEIRA_NOME_INVALIDO.concat("<br/>"));
			}
			if (unidadeMedidaCaseira.getSigla().length() < 1 || unidadeMedidaCaseira.getSigla().length() > 10) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_CASEIRA_SINGLA_INVALIDA.concat("<br/>"));
			}
			
			if (!isValido) {
				throw new NegocioException(msg.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		  
		return isValido;
	}

	/**
	 * Cadastra Unidade de Medida Caseira em nivel de negocio, chamando o DAO
	 * 
	 * @param unidadeMedida
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void cadastrarUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira) throws NegocioException, SQLException, ParseException {
		try {
			unidadeMedidaCaseiraDAO.cadastrarUnidadeMedidaCaseira(unidadeMedidaCaseira);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	/**
	 * Lista as Unidades de Medida Caseira a partir da classe de DAO
	 * 
	 * @return List<UnidadeMedidaCaseira>
	 * @throws NegocioException
	 */	
	public List<UnidadeMedidaCaseira> listarUnidadesMedidaCaseira() throws NegocioException {
		List<UnidadeMedidaCaseira> listUnidadeMedidaCaseira = null;
		try {
			listUnidadeMedidaCaseira = unidadeMedidaCaseiraDAO.listarUnidadesMedidaCaseira();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listUnidadeMedidaCaseira;
	}

	/**
	 * Remove Unidade de Medida Caseira da base
	 * 
	 * @param idUnidadeMedidaCaseira
	 * @throws NegocioException
	 * @throws SQLException
	 */
	public void removerUnidadeMedidaCaseira(Integer idUnidadeMedidaCaseira) throws NegocioException, SQLException {
		try {
				unidadeMedidaCaseiraDAO.removerUnidadeMedidaCaseira(idUnidadeMedidaCaseira);
				
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(MensagemContantes.MSG_ERR_REMOVE_UNIDADE_MEDIDA_CASEIRA_EM_PROJETO);
		}
	}
	
	/**
	 * Busca as Unidades de Medida Caseira a partir da classe de DAO
	 * 
	 * @return ArrayList<UnidadeMedidaCaseira>
	 * @throws NegocioException
	 */	
	public ArrayList<UnidadeMedidaCaseira> buscaUnidadesMedidaCaseira(int offset, int limit) throws NegocioException {
		ArrayList<UnidadeMedidaCaseira> listUnidadeMedidaCaseira = null;
		try {
			listUnidadeMedidaCaseira = unidadeMedidaCaseiraDAO.buscaUnidadesMedidaCaseira(offset, limit);
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listUnidadeMedidaCaseira;
	}

	/**
	 * Busca unidade de medida caseira a partir da classe de DAO
	 * @param idUnidadeMedidaCaseira
	 * @return UnidadeDeMedidaCaseira
	 * @throws NegocioException
	 */
	public UnidadeMedidaCaseira buscaUnidadeMedidaCaseiraId(int idUnidadeMedidaCaseira) throws NegocioException {
		try {
			UnidadeMedidaCaseira unidadeMedidaCaseira = unidadeMedidaCaseiraDAO.buscaUnidadeMedidaCaseiraId(idUnidadeMedidaCaseira);
			return unidadeMedidaCaseira;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	/**
	 * Busca unidade de medida caseira pelo nome a partir da classe de DAO
	 * @param idUnidadeMedidaCaseira
	 * @return UnidadeDeMedidaCaseira
	 * @throws NegocioException
	 */
	public ArrayList<UnidadeMedidaCaseira> buscaUnidadeMedidaCaseiraNome(String nome, int limit) throws NegocioException {
		try {
			ArrayList<UnidadeMedidaCaseira> unidadeMedidaCaseira = unidadeMedidaCaseiraDAO.buscaUnidadesMedidaCaseiraNome(nome, limit);
			return unidadeMedidaCaseira;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	/**
	 * Edita unidade de medida caseira a partir da classe de DAO
	 * @param unidadeMedidaCaseira
	 * @throws NegocioException
	 */
	public void editaUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira) throws NegocioException {
		try {
			unidadeMedidaCaseiraDAO.editaUnidadeMedidaCaseira(unidadeMedidaCaseira);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	public void setUnidadeMedidaCaseiraDAO(UnidadeMedidaCaseiraDAO unidadeMedidaCaseiraDAO) {
		this.unidadeMedidaCaseiraDAO = unidadeMedidaCaseiraDAO;
	}
}

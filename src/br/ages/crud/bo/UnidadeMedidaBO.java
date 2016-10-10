package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.UnidadeMedidaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.util.MensagemContantes;

/**
 * Gerencia os comportamentos de negocio da Unidade de Medida Associa os parametros da
 * tela as propriedades da classe
 * 
 * @author Cassio Trindade
 * @author Ricardo Borges
 *  
 */
public class UnidadeMedidaBO {
	
	private UnidadeMedidaDAO unidadeMedidaDAO = null;

	public UnidadeMedidaBO() {
		unidadeMedidaDAO = new UnidadeMedidaDAO();
	}

	/**
	 * Valida os dados da unidade de medida na tela de cadastro com erros aglutinados
	 * 
	 * @param unidadeMedida
	 * @return
	 * @throws NegocioException
	 */
	public boolean validaUnidadeMedida(UnidadeMedida unidadeMedida) throws NegocioException {
		boolean isValido = true;		
		
		StringBuilder msg = new StringBuilder();
		msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_DADOS_INVALIDOS.concat("<br/>"));
		
		try{
			
			if(this.existeUnidadeMedida(unidadeMedida)){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_JA_EXISTENTE.concat("<br/>"));
			}			
			if (unidadeMedida.getUnidadeMedida().length() < 1 || unidadeMedida.getUnidadeMedida().length() > 60) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_DESCRICAO_ORIGEM_INVALIDA.concat("<br/>"));
			}
			if (unidadeMedida.getMedidaConversao().length() < 1 || unidadeMedida.getMedidaConversao().length() > 60) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_DESCRICAO_CONVERSAO_INVALIDA.concat("<br/>"));
			}
			if (unidadeMedida.getSiglaUnidadeMedida().length() < 1 || unidadeMedida.getSiglaUnidadeMedida().length() > 10) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_SINGLA_INVALIDA.concat("<br/>"));
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
	 * Cadastra Unidade de Medida em nivel de negocio, chamando o DAO
	 * 
	 * @param unidadeMedida
	 * @throws NegocioException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public void cadastrarUnidadeMedida(UnidadeMedida unidadeMedida) throws NegocioException, SQLException, ParseException {
		try {
			unidadeMedidaDAO.cadastrarUnidadeMedida(unidadeMedida);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	/**
	 * Lista as Unidades de Medida a partir da classe de DAO
	 * 
	 * @return List<UnidadeMedida>
	 * @throws NegocioException
	 */	
	public List<UnidadeMedida> listarUnidadesMedida() throws NegocioException {
		List<UnidadeMedida> listUnidadeMedida = null;
		try {
			listUnidadeMedida = unidadeMedidaDAO.listarUnidadesMedida();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listUnidadeMedida;
	}

	/**
	 * Remove Unidade de Medida da base
	 * 
	 * @param idUnidadeMedida
	 * @throws NegocioException
	 * @throws SQLException
	 */
	public void removerUnidadeMedida(Integer idUnidadeMedida) throws NegocioException, SQLException {
		try {
				unidadeMedidaDAO.removerUnidadeMedida(idUnidadeMedida);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(MensagemContantes.MSG_ERR_REMOVE_UNIDADE_MEDIDA_EM_PROJETO);
		}
	}

	/**
	 * Busca unidade de medida a partir da classe de DAO
	 * @param idUnidadeMedida
	 * @return
	 * @throws NegocioException
	 */
	public UnidadeMedida buscaUnidadeMedidaId(int idUnidadeMedida) throws NegocioException {
		try {
			UnidadeMedida unidadeMedida = unidadeMedidaDAO.buscaUnidadeMedidaId(idUnidadeMedida);

			return unidadeMedida;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	/**
	 * Edita unidade de medida a partir da classe de DAO
	 * @param unidadeMedida
	 * @throws NegocioException
	 */
	public void editaUnidadeMedida(UnidadeMedida unidadeMedida) throws NegocioException {
		try {
			unidadeMedidaDAO.editaUnidadeMedida(unidadeMedida);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}
	
	/**
	 * Verifica se unidade de medida existe
	 * @param unidadeMedida
	 * @throws NegocioException
	 */
	public boolean existeUnidadeMedida(UnidadeMedida unidadeMedida) throws NegocioException {
		try {
			return unidadeMedidaDAO.existeUnidadeMedida(unidadeMedida);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}

	public void setUnidadeMedidaDAO(UnidadeMedidaDAO unidadeMedidaDAO) {
		this.unidadeMedidaDAO = unidadeMedidaDAO;
	}
}

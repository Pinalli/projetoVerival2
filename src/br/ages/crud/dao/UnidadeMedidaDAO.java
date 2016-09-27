package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

/**
 * 
 * @author Ricardo Borges
 *
 */
public class UnidadeMedidaDAO {

	private ArrayList<UnidadeMedida> listarUnidadeMedida;

	public UnidadeMedidaDAO() {
		listarUnidadeMedida = new ArrayList<>();
	}

	/**
	 * Lista unidades de medidas
	 * 
	 * @return List<UnidadeMedida>
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<UnidadeMedida> listarUnidadesMedida() throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("u.`ID_UNIDADE_MEDIDA`,");
			sql.append("u.`UNIDADE_MEDIDA`,");
			sql.append("u.`MEDIDA_CONVERSAO`,");
			sql.append("u.`SIGLA_UNIDADE_MEDIDA`,");
			sql.append("u.`FATOR_CONVERSAO`");
			sql.append("FROM TB_UNIDADE_MEDIDA u"); 
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				UnidadeMedida dto = new UnidadeMedida();
				dto.setIdUnidadeMedida(resultset.getInt("ID_UNIDADE_MEDIDA"));
				dto.setUnidadeMedida(resultset.getString("UNIDADE_MEDIDA"));
				dto.setMedidaConversao(resultset.getString("MEDIDA_CONVERSAO"));
				dto.setSiglaUnidadeMedida(resultset.getString("SIGLA_UNIDADE_MEDIDA"));
				dto.setFatorConversao(resultset.getDouble("FATOR_CONVERSAO"));
				listarUnidadeMedida.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarUnidadeMedida;
	}

	/**
	 * Cadastra unidade de medida
	 * 
	 * @param unidadeMedida
	 * @return int
	 * @throws PersistenciaException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public int cadastrarUnidadeMedida(UnidadeMedida unidadeMedida) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			Integer idUnidadeMedida = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_UNIDADE_MEDIDA (UNIDADE_MEDIDA, MEDIDA_CONVERSAO, SIGLA_UNIDADE_MEDIDA, FATOR_CONVERSAO)");
			sql.append("VALUES (?, ?, ?, ? )");

			// Cadastra a medida e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, unidadeMedida.getUnidadeMedida());
			statement.setString(2, unidadeMedida.getMedidaConversao());
			statement.setString(3, unidadeMedida.getSiglaUnidadeMedida());
			statement.setString(4, String.valueOf(unidadeMedida.getFatorConversao()));

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idUnidadeMedida = resultset.getInt(1);

			}
			return idUnidadeMedida;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_JA_EXISTENTE.replace("?", unidadeMedida.getSiglaUnidadeMedida()));
		} finally {
			conexao.close();
		}
	}

	/**
	 * Metodo de remocao de uma unidade de medida a partir do seu id.
	 * 
	 * @param idUnidadeMedida
	 * @return boolean
	 * @throws PersistenciaException
	 */
	public boolean removerUnidadeMedida(Integer idUnidadeMedida) throws PersistenciaException {
		boolean removidoOK = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			//sql.append("SELECT ID_TIPO_USUARIO FROM TB_USUARIO WHERE ID_USUARIO = ?")
			//sql.append("update TB_USUARIO set STATUS_USUARIO='INATIVO'  where id_usuario= ? ");
			
			sql.append("DELETE FROM TB_UNIDADE_MEDIDA WHERE ID_UNIDADE_MEDIDA = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUnidadeMedida);

			removidoOK = statement.execute();

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return removidoOK;
	}

	/**
	 * Busca unidade de medida por ID_UNIDADE_MEDIDA
	 * 
	 * @param idUnidadeMedida
	 * @return UnidadeMedida object
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public UnidadeMedida buscaUnidadeMedidaId(int idUnidadeMedida) throws PersistenciaException, SQLException {
		UnidadeMedida unidadeMedida = new UnidadeMedida();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("u.`ID_UNIDADE_MEDIDA`,");
			sql.append("u.`UNIDADE_MEDIDA`,");
			sql.append("u.`MEDIDA_CONVERSAO`,");
			sql.append("u.`SIGLA_UNIDADE_MEDIDA`,");
			sql.append("u.`FATOR_CONVERSAO`");
			sql.append(" FROM TB_UNIDADE_MEDIDA u "); 
			sql.append("WHERE ID_UNIDADE_MEDIDA = ?;");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUnidadeMedida);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				unidadeMedida.setIdUnidadeMedida(resultset.getInt("ID_UNIDADE_MEDIDA"));
				unidadeMedida.setUnidadeMedida(resultset.getString("UNIDADE_MEDIDA"));
				unidadeMedida.setMedidaConversao(resultset.getString("MEDIDA_CONVERSAO"));
				unidadeMedida.setSiglaUnidadeMedida(resultset.getString("SIGLA_UNIDADE_MEDIDA"));
				unidadeMedida.setFatorConversao(resultset.getDouble("FATOR_CONVERSAO"));
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return unidadeMedida;
	}
	
	/**
	 * Verifica se unidade de medida existe usando unidade de medida e sigla
	 * 
	 * @param idUnidadeMedida
	 * @return UnidadeMedida object
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public boolean existeUnidadeMedida(UnidadeMedida unidadeMedida) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT u.`ID_UNIDADE_MEDIDA` ");
			sql.append("FROM TB_UNIDADE_MEDIDA u "); 
			sql.append("WHERE SIGLA_UNIDADE_MEDIDA = ? ");
			sql.append("AND MEDIDA_CONVERSAO = ?;");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, unidadeMedida.getSiglaUnidadeMedida());
			statement.setString(2, unidadeMedida.getMedidaConversao());
			ResultSet resultset = statement.executeQuery();

			return resultset.isBeforeFirst();

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Edita unidade de medida
	 * 
	 * @param usuario
	 * @return boolean
	 * @throws PersistenciaException
	 */
	public boolean editaUnidadeMedida(UnidadeMedida unidadeMedida) throws PersistenciaException {
		boolean ok = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = unidadeMedida.getIdUnidadeMedida();

			sql.append("UPDATE TB_UNIDADE_MEDIDA set UNIDADE_MEDIDA = ?," + "MEDIDA_CONVERSAO = ?, SIGLA_UNIDADE_MEDIDA = ?, FATOR_CONVERSAO = ?" + " WHERE ID_UNIDADE_MEDIDA = " + id + ";");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, unidadeMedida.getUnidadeMedida());
			statement.setString(2, unidadeMedida.getMedidaConversao());
			statement.setString(3, unidadeMedida.getSiglaUnidadeMedida());
			statement.setDouble(4, unidadeMedida.getFatorConversao());

			ok = statement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ok;
	}
	
}

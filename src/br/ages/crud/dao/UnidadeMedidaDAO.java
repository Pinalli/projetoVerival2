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
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.StatusUsuario;
import br.ages.crud.model.TipoUsuario;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.Usuario;
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
			sql.append("u.`DESCRICAO_ORIGEM`,");
			sql.append("u.`DESCRICAO_CONVERSAO`,");
			sql.append("u.`SIGLA`,");
			sql.append("u.`MEDIDA_CONVERSAO`");			
			sql.append("from TB_UNIDADE_MEDIDA u"); 
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				UnidadeMedida dto = new UnidadeMedida();
				dto.setIdUnidadeMedida(resultset.getInt("ID_UNIDADE_MEDIDA"));
				dto.setDescricaoOrigem(resultset.getString("DESCRICAO_ORIGEM"));
				dto.setDescricaoConversao(resultset.getString("DESCRICAO_CONVERSAO"));
				dto.setSigla(resultset.getString("SIGLA"));
				dto.setMedidaConversao(resultset.getInt("MEDIDA_CONVERSAO"));
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
			sql.append("insert into TB_UNIDADE_MEDIDA (DESCRICAO_ORIGEM, DESCRICAO_CONVERSAO, SIGLA, MEDIDA_CONVERSAO)");
			sql.append("values (?, ?, ?, ? )");

			// Cadastra a medida e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, unidadeMedida.getDescricaoOrigem());
			statement.setString(2, unidadeMedida.getDescricaoConversao());
			statement.setString(3, unidadeMedida.getSigla());
			statement.setString(4, String.valueOf(unidadeMedida.getMedidaConversao()));

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idUnidadeMedida = resultset.getInt(1);

			}
			return idUnidadeMedida;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_JA_EXISTENTE.replace("?", unidadeMedida.getSigla()));
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
			sql.append("u.`DESCRICAO_ORIGEM`,");
			sql.append("u.`DESCRICAO_CONVERSAO`,");
			sql.append("u.`SIGLA`,");
			sql.append("u.`MEDIDA_CONVERSAO`");			
			sql.append(" from TB_UNIDADE_MEDIDA u "); 
			sql.append("where ID_UNIDADE_MEDIDA = ?;");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUnidadeMedida);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				unidadeMedida.setIdUnidadeMedida(resultset.getInt("ID_UNIDADE_MEDIDA"));
				unidadeMedida.setDescricaoOrigem(resultset.getString("DESCRICAO_ORIGEM"));
				unidadeMedida.setDescricaoConversao(resultset.getString("DESCRICAO_CONVERSAO"));
				unidadeMedida.setSigla(resultset.getString("SIGLA"));
				unidadeMedida.setMedidaConversao(resultset.getInt("MEDIDA_CONVERSAO"));
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

			sql.append("update TB_UNIDADE_MEDIDA set DESCRICAO_ORIGEM = ?," + "DESCRICAO_CONVERSAO = ?, SIGLA = ?, MEDIDA_CONVERSAO = ?" + " where ID_UNIDADE_MEDIDA = " + id + ";");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, unidadeMedida.getDescricaoOrigem());
			statement.setString(2, unidadeMedida.getDescricaoConversao());
			statement.setString(3, unidadeMedida.getSigla());
			statement.setInt(4, unidadeMedida.getMedidaConversao());

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

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
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;
/**
 * 
 * @author iann muller
 *
 */
public class UnidadeMedidaCaseiraDAO {
	private ArrayList<UnidadeMedidaCaseira> listarUnidadeMedidaCaseira;
	public UnidadeMedidaCaseiraDAO() {
		listarUnidadeMedidaCaseira = new ArrayList<>();
	}
	/**
	 * Lista unidades de medidas
	 * 
	 * @return List<UnidadeMedida>
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<UnidadeMedidaCaseira> listarUnidadesMedidaCaseira() throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("U.`ID_UNIDADE_MEDIDA_CASEIRA`,");
			sql.append("U.`NOME`,");
			sql.append("U.`SIGLA`");
			sql.append("FROM TB_UNIDADE_MEDIDA_CASEIRA U"); 
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				UnidadeMedidaCaseira dto = new UnidadeMedidaCaseira();
				dto.setIdUnidadeMedidaCaseira(resultset.getInt("ID_UNIDADE_MEDIDA_CASEIRA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setSigla(resultset.getString("SIGLA"));
				listarUnidadeMedidaCaseira.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarUnidadeMedidaCaseira;
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
	public int cadastrarUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;
		try {
			Integer idUnidadeMedidaCaseira = null;
			
			conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_UNIDADE_MEDIDA_CASEIRA (NOME, SIGLA)");
			sql.append("VALUES (?, ?)");
			
			// Cadastra a medida e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, unidadeMedidaCaseira.getNome());
			statement.setString(2, unidadeMedidaCaseira.getSigla());
			statement.executeUpdate();
			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idUnidadeMedidaCaseira = resultset.getInt(1);
			}
			return idUnidadeMedidaCaseira;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_CASEIRA_JA_EXISTENTE.replace("?", unidadeMedidaCaseira.getSigla()));
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
	public boolean removerUnidadeMedidaCaseira(Integer idUnidadeMedidaCaseira) throws PersistenciaException {
		boolean removidoOK = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			//sql.append("SELECT ID_TIPO_USUARIO FROM TB_USUARIO WHERE ID_USUARIO = ?")
			//sql.append("update TB_USUARIO set STATUS_USUARIO='INATIVO'  where id_usuario= ? ");
			
			sql.append("DELETE FROM TB_UNIDADE_MEDIDA_CASEIRA WHERE ID_UNIDADE_MEDIDA_CASEIRA = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUnidadeMedidaCaseira);
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
	 * Busca unidades de medida caseiras
	 * 
	 * @return ArrayList<UnidadeMedida>
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public ArrayList<UnidadeMedidaCaseira> buscaUnidadesMedidaCaseira(int offset, int limit) throws PersistenciaException, SQLException {
		Connection conexao = null;
		ArrayList<UnidadeMedidaCaseira> listaUnidadeMedidaCaseira = new ArrayList<UnidadeMedidaCaseira>(); 
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("U.`ID_UNIDADE_MEDIDA_CASEIRA`,");
			sql.append("U.`NOME`,");
			sql.append("U.`SIGLA`");
			sql.append(" FROM TB_UNIDADE_MEDIDA_CASEIRA U");
			sql.append(" LIMIT "+offset+", "+limit);
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				UnidadeMedidaCaseira dto = new UnidadeMedidaCaseira();
				dto.setIdUnidadeMedidaCaseira(resultset.getInt("ID_UNIDADE_MEDIDA_CASEIRA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setSigla(resultset.getString("SIGLA"));
				listaUnidadeMedidaCaseira.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listaUnidadeMedidaCaseira;
	}
	
	/**
	 * Busca unidades de medida caseiras pelo nome
	 * 
	 * @return ArrayList<UnidadeMedida>
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public ArrayList<UnidadeMedidaCaseira> buscaUnidadesMedidaCaseiraNome(String nome, int limit) throws PersistenciaException, SQLException {
		Connection conexao = null;
		ArrayList<UnidadeMedidaCaseira> listaUnidadeMedidaCaseira = new ArrayList<UnidadeMedidaCaseira>(); 
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			if(limit == 0){
				sql.append("SELECT * FROM TB_UNIDADE_MEDIDA_CASEIRA WHERE NOME LIKE '%"+nome+"%' ");
			}else{
				sql.append("SELECT * FROM TB_UNIDADE_MEDIDA_CASEIRA WHERE NOME LIKE '%"+nome+"%' LIMIT "+limit);
			}
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				UnidadeMedidaCaseira dto = new UnidadeMedidaCaseira();
				dto.setIdUnidadeMedidaCaseira(resultset.getInt("ID_UNIDADE_MEDIDA_CASEIRA"));
				dto.setNome(resultset.getString("NOME"));
				dto.setSigla(resultset.getString("SIGLA"));
				listaUnidadeMedidaCaseira.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listaUnidadeMedidaCaseira;
	}
	
	/**
	 * Busca unidade de medida por ID_UNIDADE_MEDIDA
	 * 
	 * @param idUnidadeMedida
	 * @return UnidadeMedida object
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public UnidadeMedidaCaseira buscaUnidadeMedidaCaseiraId(int idUnidadeMedidaCaseira) throws PersistenciaException, SQLException {
		UnidadeMedidaCaseira unidadeMedidaCaseira = new UnidadeMedidaCaseira();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("U.`ID_UNIDADE_MEDIDA_CASEIRA`,");
			sql.append("U.`NOME`,");
			sql.append("U.`SIGLA`");
			sql.append(" FROM TB_UNIDADE_MEDIDA_CASEIRA U "); 
			sql.append("WHERE ID_UNIDADE_MEDIDA_CASEIRA = ?;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUnidadeMedidaCaseira);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				unidadeMedidaCaseira.setIdUnidadeMedidaCaseira(resultset.getInt("ID_UNIDADE_MEDIDA_CASEIRA"));
				unidadeMedidaCaseira.setNome(resultset.getString("NOME"));
				unidadeMedidaCaseira.setSigla(resultset.getString("SIGLA"));
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
		return unidadeMedidaCaseira;
	}
		/**
	 * Edita unidade de medida
	 * 
	 * @param usuario
	 * @return boolean
	 * @throws PersistenciaException
	 */
	public boolean editaUnidadeMedidaCaseira(UnidadeMedidaCaseira unidadeMedidaCaseira) throws PersistenciaException {
		boolean ok = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = unidadeMedidaCaseira.getIdUnidadeMedidaCaseira();

			sql.append("UPDATE TB_UNIDADE_MEDIDA_CASEIRA SET NOME = ?," + " SIGLA = ?" + " WHERE ID_UNIDADE_MEDIDA_CASEIRA = " + id + ";");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, unidadeMedidaCaseira.getNome());
			statement.setString(2, unidadeMedidaCaseira.getSigla());
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
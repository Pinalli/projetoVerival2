package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

/**
 * 
 * @author Luis Santana
 *
 */
public class IngredienteDAO {

	private ArrayList<Ingrediente> listarIngredientes;
	private String table;
	public IngredienteDAO() {
		listarIngredientes = new ArrayList<>();
		this.table = "TB_INGREDIENTES";
	}

	/**
	 * Lista os Ingredientes da basee
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Ingrediente> listarIngredientes() throws PersistenciaException, SQLException {
		Connection conexao = null;
		// tentativa de readaptação do listarIngredientes()
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append("FROM "+ this.table +" I");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Ingrediente dto = new Ingrediente();
				dto.setId(resultset.getInt("I.ID"));
				dto.setCodigo(resultset.getInt("I.COD"));
				dto.setDescricao(resultset.getString("I.DESCRICAO"));
				dto.setCarboidratos(resultset.getDouble("I.CARBOIDRATOS"));
				dto.setKcalCarboidratos(resultset.getDouble("I.KCAL_CARBOIDRATOS"));
				dto.setProteinas(resultset.getDouble("I.PROTEINAS"));
				dto.setKcalProteinas(resultset.getDouble("I.KCAL_PROTEINAS"));
				dto.setLipidios(resultset.getDouble("I.LIPIDIOS"));
				dto.setKcalLipidios(resultset.getDouble("I.KCAL_LIPIDIOS"));
				dto.setFatorCorrecao(resultset.getDouble("I.FATOR_CORRECAO"));
				dto.setIndiceCoccao(resultset.getDouble("I.INDICE_COCCAO"));
				dto.setCusto(resultset.getDouble("I.CUSTO"));
				dto.setUnidadeMedida(resultset.getString("I.UNIDADE_MEDIDA"));
				dto.setDataAlteracao(resultset.getDate("I.DATA_INSERCAO"));
				listarIngredientes.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarIngredientes;
	}

	public int cadastrarIngrediente(Ingrediente ingrediente)
			throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;

		try {
			Integer idIngrediente = null;

			conexao = ConexaoUtil.getConexao();
			
			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO "+ this.table +" ("
					+ "`ID`, "
					+ "`COD`, "
					+ "`DESCRICAO`, "
					+ "`CARBOIDRATOS`, "
					+ "`KCAL_CARBOIDRATOS`, "
					+ "`PROTEINAS`, "
					+ "`KCAL_PROTEINAS`, "
					+ "`LIPIDIOS`, "
					+ "`KCAL_LIPIDIOS`, "
					+ "`FATOR_CORRECAO`, "
					+ "`INDICE_COCCAO`, "
					+ "`CUSTO`, "
					+ "`UNIDADE_MEDIDA`, "
					+ "`DATA_INSERCAO`)"
					);
			sql.append("VALUE (NULL ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW() )");
			// converte a data para data Juliana, data que o banco reconhece;
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataInclusao = new java.sql.Date(utilDate.getTime());
			// Cadastra o ingrediente e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, ingrediente.getCodigo());
			statement.setString(2, ingrediente.getDescricao());
			statement.setDouble(3, ingrediente.getCarboidratos());
			statement.setDouble(4, ingrediente.getKcalCarboidratos());
			statement.setDouble(5, ingrediente.getProteinas());
			statement.setDouble(6, ingrediente.getKcalProteinas());
			statement.setDouble(7, ingrediente.getLipidios());
			statement.setDouble(8, ingrediente.getKcalLipidios());
			statement.setDouble(9, ingrediente.getFatorCorrecao());
			statement.setDouble(10, ingrediente.getIndiceCoccao());
			statement.setDouble(11, ingrediente.getCusto());
			statement.setString(12, ingrediente.getUnidadeMedida());
			
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idIngrediente = resultset.getInt(1);

			}
			return idIngrediente;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(
					MensagemContantes.MSG_ERR_CODIGO_JA_USADO);

		} finally {
			conexao.close();
		}
	}

	public ArrayList<Ingrediente> buscaIngredientes(int offset, int limit) throws PersistenciaException {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_INGREDIENTES LIMIT "+offset+", "+limit+" ");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setId(resultset.getInt("ID"));
				ingrediente.setCodigo(resultset.getInt("COD"));
				ingrediente.setDescricao(resultset.getString("DESCRICAO"));
				ingrediente.setCarboidratos(resultset.getDouble("CARBOIDRATOS"));
				ingrediente.setKcalCarboidratos(resultset.getDouble("KCAL_CARBOIDRATOS"));
				ingrediente.setProteinas(resultset.getDouble("PROTEINAS"));
				ingrediente.setKcalProteinas(resultset.getDouble("KCAL_PROTEINAS"));
				ingrediente.setLipidios(resultset.getDouble("LIPIDIOS"));
				ingrediente.setKcalLipidios(resultset.getDouble("KCAL_LIPIDIOS"));
				ingrediente.setFatorCorrecao(resultset.getDouble("FATOR_CORRECAO"));
				ingrediente.setIndiceCoccao(resultset.getDouble("INDICE_COCCAO"));
				ingrediente.setCusto(resultset.getDouble("CUSTO"));
				ingrediente.setUnidadeMedida(resultset.getString("UNIDADE_MEDIDA"));
				ingrediente.setDataAlteracao(resultset.getDate("DATA_INSERCAO"));	
				ingredientes.add(ingrediente);
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

		return ingredientes;
	}
	
	public ArrayList<Ingrediente> buscaIngredienteDescricao(String descricao, int limit) throws PersistenciaException {
		ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_INGREDIENTES WHERE DESCRICAO LIKE '%"+descricao+"%' LIMIT "+limit);
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				Ingrediente ingrediente = new Ingrediente();
				ingrediente.setId(resultset.getInt("ID"));
				ingrediente.setCodigo(resultset.getInt("COD"));
				ingrediente.setDescricao(resultset.getString("DESCRICAO"));
				ingrediente.setCarboidratos(resultset.getDouble("CARBOIDRATOS"));
				ingrediente.setKcalCarboidratos(resultset.getDouble("KCAL_CARBOIDRATOS"));
				ingrediente.setProteinas(resultset.getDouble("PROTEINAS"));
				ingrediente.setKcalProteinas(resultset.getDouble("KCAL_PROTEINAS"));
				ingrediente.setLipidios(resultset.getDouble("LIPIDIOS"));
				ingrediente.setKcalLipidios(resultset.getDouble("KCAL_LIPIDIOS"));
				ingrediente.setGorduraSaturada(resultset.getDouble("GORDURA_SATURADA"));
				ingrediente.setKcalGorduraSaturada(resultset.getDouble("KCAL_GORDURA_SATURADA"));
				ingrediente.setGorduraTrans(resultset.getDouble("GORDURA_TRANS"));
				ingrediente.setKcalGorduraTrans(resultset.getDouble("KCAL_GORDURA_TRANS"));
				ingrediente.setFibrasAlimentares(resultset.getDouble("FIBRAS_ALIMENTARES"));
				ingrediente.setKcalFibrasAlimentares(resultset.getDouble("KCAL_FIBRAS_ALIMENTARES"));
				ingrediente.setSodio(resultset.getDouble("SODIO"));
				ingrediente.setKcalSodio(resultset.getDouble("KCAL_SODIO"));
				ingrediente.setFatorCorrecao(resultset.getDouble("FATOR_CORRECAO"));
				ingrediente.setIndiceCoccao(resultset.getDouble("INDICE_COCCAO"));
				ingrediente.setCusto(resultset.getDouble("CUSTO"));
				ingrediente.setUnidadeMedida(resultset.getString("UNIDADE_MEDIDA"));
				ingrediente.setDataAlteracao(resultset.getDate("DATA_INSERCAO"));	
				ingredientes.add(ingrediente);
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

		return ingredientes;
	}

	public Ingrediente buscaIngredienteId(int idIngrediente) throws PersistenciaException, SQLException {
		// adicionar informações de tipo de ingrediente?
		Ingrediente ingrediente = new Ingrediente();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM AGES_E.TB_INGREDIENTE WHERE CODIGO =
			// ?;");
			//
			sql.append("SELECT *");
			sql.append(" FROM "+ this.table);
			sql.append(" WHERE ID = ?;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idIngrediente);
			
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				ingrediente.setId(resultset.getInt("ID"));
				ingrediente.setCodigo(resultset.getInt("COD"));
				ingrediente.setDescricao(resultset.getString("DESCRICAO"));
				ingrediente.setCarboidratos(resultset.getDouble("CARBOIDRATOS"));
				ingrediente.setKcalCarboidratos(resultset.getDouble("KCAL_CARBOIDRATOS"));
				ingrediente.setProteinas(resultset.getDouble("PROTEINAS"));
				ingrediente.setKcalProteinas(resultset.getDouble("KCAL_PROTEINAS"));
				ingrediente.setLipidios(resultset.getDouble("LIPIDIOS"));
				ingrediente.setKcalLipidios(resultset.getDouble("KCAL_LIPIDIOS"));
				ingrediente.setGorduraSaturada(resultset.getDouble("GORDURA_SATURADA"));
				ingrediente.setKcalGorduraSaturada(resultset.getDouble("KCAL_GORDURA_SATURADA"));
				ingrediente.setGorduraTrans(resultset.getDouble("GORDURA_TRANS"));
				ingrediente.setKcalGorduraTrans(resultset.getDouble("KCAL_GORDURA_TRANS"));
				ingrediente.setFibrasAlimentares(resultset.getDouble("FIBRAS_ALIMENTARES"));
				ingrediente.setKcalFibrasAlimentares(resultset.getDouble("KCAL_FIBRAS_ALIMENTARES"));
				ingrediente.setSodio(resultset.getDouble("SODIO"));
				ingrediente.setKcalSodio(resultset.getDouble("KCAL_SODIO"));
				ingrediente.setFatorCorrecao(resultset.getDouble("FATOR_CORRECAO"));
				ingrediente.setIndiceCoccao(resultset.getDouble("INDICE_COCCAO"));
				ingrediente.setCusto(resultset.getDouble("CUSTO"));
				ingrediente.setUnidadeMedida(resultset.getString("UNIDADE_MEDIDA"));
				ingrediente.setDataAlteracao(resultset.getDate("DATA_INSERCAO"));		
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

		return ingrediente;

	}

	public boolean editaIngrediente(Ingrediente ingrediente) throws PersistenciaException {
		boolean okei = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = ingrediente.getId();
			int cod = ingrediente.getCodigo();
			sql.append("UPDATE "+ this.table);
            sql.append(" SET COD = ? , DESCRICAO = ?,");
            sql.append(" CARBOIDRATOS = ?,");
            sql.append(" KCAL_CARBOIDRATOS = ?,");
            sql.append(" PROTEINAS = ?,");
            sql.append(" KCAL_PROTEINAS = ?,");
            sql.append(" LIPIDIOS = ?,");
            sql.append(" KCAL_LIPIDIOS = ?,");
            sql.append(" GORDURA_SATURADAS = ?,");
            sql.append(" KCAL_GORDURA_SATURADAS = ?,");
            sql.append(" GORDURA_TRANS = ?,");
            sql.append(" KCAL_GORDURA_TRANS = ?,");
            sql.append(" FIBRAS_ALIMENTARES = ?,");
            sql.append(" KCAL_FIBRAS_ALIMENTARES = ?,");
            sql.append(" SODIO = ?,");
            sql.append(" KCAL_SODIO = ?,");
            sql.append(" FATOR_CORRECAO = ?,");
            sql.append(" INDICE_COCCAO = ?,");
            sql.append(" CUSTO = ?,");
            sql.append(" UNIDADE_MEDIDA = ?");
            sql.append(" WHERE");
            sql.append(" ID =" + id + " LIMIT 1");
            System.out.println(sql);
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			
			statement.setInt(1, ingrediente.getCodigo());
			statement.setString(2, ingrediente.getDescricao());
			statement.setDouble(3, ingrediente.getCarboidratos());
			statement.setDouble(4, ingrediente.getKcalCarboidratos());
			statement.setDouble(5, ingrediente.getProteinas());
			statement.setDouble(6, ingrediente.getKcalProteinas());
			statement.setDouble(7, ingrediente.getLipidios());
			statement.setDouble(8, ingrediente.getKcalLipidios());
			statement.setDouble(9, ingrediente.getGorduraSaturadas());
			statement.setDouble(10, ingrediente.getKcalGorduraSaturadas());
			statement.setDouble(11, ingrediente.getGorduraTrans());
			statement.setDouble(12, ingrediente.getKcalGorduraTrans());
			statement.setDouble(13, ingrediente.getFibrasAlimentares());
			statement.setDouble(14, ingrediente.getKcalFibrasAliementares());
			statement.setDouble(15, ingrediente.getSodio());
			statement.setDouble(16, ingrediente.getKcalSodio());
			statement.setDouble(17, ingrediente.getFatorCorrecao());
			statement.setDouble(18, ingrediente.getIndiceCoccao());
			statement.setDouble(19, ingrediente.getCusto());
			statement.setString(20, ingrediente.getUnidadeMedida());
			
			okei = statement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return okei;
	}
	public boolean removeIngrediente(Integer idIngrediente) throws PersistenciaException {
		boolean removidoOK = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT ID_TIPO_USUARIO FROM TB_USUARIO WHERE ID_USUARIO = ?
			// ")
			sql.append("DELETE FROM "+ this.table +" WHERE ID = ? ");
//			System.out.println(sql);
			// sql.append("DELETE FROM TB_TIPO_USUARIO WHERE
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idIngrediente);

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
}
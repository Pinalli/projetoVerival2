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

	public IngredienteDAO() {
		listarIngredientes = new ArrayList<>();
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
			sql.append("from TB_INGREDIENTES i");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Ingrediente dto = new Ingrediente();
				dto.setId(resultset.getInt("i.ID"));
				dto.setCodigo(resultset.getInt("i.COD"));
				dto.setDescricao(resultset.getString("i.DESCRICAO"));
				dto.setCarboidratos(resultset.getDouble("i.CARBOIDRATOS"));
				dto.setKcalCarboidratos(resultset.getDouble("i.KCAL_CARBOIDRATOS"));
				dto.setProteinas(resultset.getDouble("i.PROTEINAS"));
				dto.setKcalProteinas(resultset.getDouble("i.KCAL_PROTEINAS"));
				dto.setLipidios(resultset.getDouble("i.LIPIDIOS"));
				dto.setKcalLipidios(resultset.getDouble("i.KCAL_LIPIDIOS"));
				dto.setFatorCorrecao(resultset.getDouble("i.FATOR_CORRECAO"));
				dto.setIndiceCoccao(resultset.getDouble("i.INDICE_COCCAO"));
				dto.setCusto(resultset.getDouble("i.CUSTO"));
				dto.setUnidadeMedida(resultset.getString("i.UNIDADE_MEDIDA"));
				dto.setDataAlteracao(resultset.getDate("i.DATA_INSERCAO"));
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
					"insert into TB_INGREDIENTE (`ID`, `COD`, "
					+ "`DESCRICAO`, "
					+ "`CARBOIDRATOS`, "
					+ "`KCAL_CARBOIDRATOS`, "
					+ "`PROTEINAS`, "
					+ "`KCAL_PROTEINAS`, "
					+ "`LIPIDIOS`, "
					+ "`KCAL_LIPIDIOS`, "
					+ "`FATORCORRECAO`, "
					+ "`INDICECOCCAO`, "
					+ "`CUSTO`, "
					+ "`UNIDADE_MEDIDA`, "
					+ "`DATA_INSERCAO`)"
					);
			sql.append("VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW() )");
			// converte a data para data Juliana, data que o banco reconhece;
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataInclusao = new java.sql.Date(utilDate.getTime());

			// Cadastra o ingrediente e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, idIngrediente);
			statement.setInt(2, ingrediente.getCodigo());
			statement.setString(3, ingrediente.getDescricao());
			statement.setDouble(4, ingrediente.getCarboidratos());
			statement.setDouble(5, ingrediente.getKcalCarboidratos());
			statement.setDouble(6, ingrediente.getProteinas());
			statement.setDouble(7, ingrediente.getKcalProteinas());
			statement.setDouble(8, ingrediente.getLipidios());
			statement.setDouble(9, ingrediente.getKcalLipidios());
			statement.setDouble(10, ingrediente.getFatorCorrecao());
			statement.setDouble(11, ingrediente.getIndiceCoccao());
			statement.setDouble(12, ingrediente.getCusto());
			statement.setString(13, ingrediente.getUnidadeMedida());
			
			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idIngrediente = resultset.getInt(1);

			}
			return idIngrediente;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(
					MensagemContantes.MSG_ERR_INGREDIENTE_JA_EXISTENTE.replace("?", ingrediente.getDescricao()));

		} finally {
			conexao.close();
		}
	}

	public Ingrediente buscaIngredienteDescricao(String descricao) throws PersistenciaException {

		Ingrediente ingrediente = new Ingrediente();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM TB_INGREDIENTE WHERE DESCRICAO = ?");
			sql.append("select ");
			sql.append("i.*");
			sql.append("FROM TB_INGREDIENTE i");
			sql.append("where i.descricao = ?;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, descricao);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				ingrediente.setCodigo(resultset.getInt("codigo"));
				ingrediente.setDescricao(resultset.getString("descricao"));
				ingrediente.setCarboidratos(resultset.getDouble("carboidrato"));
				ingrediente.setProteinas(resultset.getDouble("proteinas"));
				ingrediente.setLipidios(resultset.getDouble("lipidios"));
				ingrediente.setFatorCorrecao(resultset.getDouble("fatorCorrecao"));
				ingrediente.setIndiceCoccao(resultset.getDouble("indiceCoccao"));
				ingrediente.setCusto(resultset.getDouble("custo"));
				ingrediente.setUnidadeMedida(resultset.getString("unidadeMedida"));				
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

	public Ingrediente buscaIngredienteCodigo(int codigo) throws PersistenciaException, SQLException {
		// adicionar informações de tipo de ingrediente?
		Ingrediente ingrediente = new Ingrediente();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM AGES_E.TB_INGREDIENTE WHERE CODIGO =
			// ?;");
			//
			sql.append("select ");
			sql.append("i.*");
			sql.append("FROM TB_INGREDIENTE i");
			sql.append("where i.codigo = ?;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, codigo);
			
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				ingrediente.setCodigo(resultset.getInt("codigo"));
				ingrediente.setDescricao(resultset.getString("descricao"));
				ingrediente.setCarboidratos(resultset.getDouble("carboidrato"));
				ingrediente.setProteinas(resultset.getDouble("proteinas"));
				ingrediente.setLipidios(resultset.getDouble("lipidios"));
				ingrediente.setFatorCorrecao(resultset.getDouble("fatorCorrecao"));
				ingrediente.setIndiceCoccao(resultset.getDouble("indiceCoccao"));
				ingrediente.setCusto(resultset.getDouble("custo"));
				ingrediente.setUnidadeMedida(resultset.getString("unidadeMedida"));
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
			int codigo = ingrediente.getCodigo();

			sql.append("update TB_INGREDIENTE");
			sql.append("SET descricao = ?");
			sql.append("carboidratos = ?");
			sql.append("proteinas = ?");
			sql.append("lidipios = ?");
			sql.append("fatorCorrecao = ?");
			sql.append("indiceCoccao = ?");
			sql.append("custo = ? ");
			sql.append("unidadeMedida = ? ");
			sql.append("WHERE");
			sql.append("codigo = " + codigo + " LIMIT 1");
		
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, ingrediente.getDescricao());
			statement.setDouble(2, ingrediente.getCarboidratos());
			statement.setDouble(3, ingrediente.getProteinas());
			statement.setDouble(4, ingrediente.getLipidios());
			statement.setDouble(5, ingrediente.getFatorCorrecao());
			statement.setDouble(6, ingrediente.getIndiceCoccao());
			statement.setDouble(7, ingrediente.getCusto());
			statement.setString(8, ingrediente.getUnidadeMedida());
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
}
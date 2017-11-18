package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.ConexaoUtil;

public class FichaCompletaItemDAO {

	public List<FichaItem> listaFichaCompletaItem(int idFichaCompleta) throws PersistenciaException, SQLException {
		Connection conexao = null;
		List<FichaItem> itens = new ArrayList<>();
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			/*
			sql.append("SELECT ID_FICHA_ITEM, "
					+ "ID_UNIDADE_MEDIDA, "
					+ "ID_MEDIDA_CASEIRA, "
					+ "ID_INGREDIENTE, "
					+ "QUANTIDADE_UNIDADE_MEDIDA, "
					+ "QUANTIDADE_MEDIDA_CASEIRA, "
					+ "ID_FICHA "
					+ "FROM TB_FICHA_ITEM WHERE ID_FICHA = " + idFichaSimplificada);
			*/
			System.out.println("as");
			sql.append("SELECT "
					+ "TFI.ID_FICHA_ITEM, "
					+ "TFI.ID_UNIDADE_MEDIDA, "
					+ "TFI.ID_MEDIDA_CASEIRA, "
					+ "TFI.ID_INGREDIENTE, "
					+ "TFI.GORDURA_TRANS, "
					+ "TFI.QUANTIDADE_UNIDADE_MEDIDA, "
					+ "TFI.QUANTIDADE_MEDIDA_CASEIRA, "
					+ "TFI.ID_FICHA, "
					
					+ "TFI.FATOR_CORRECAO, "
					+ "TFI.INDICE_COCCAO, "
					
					+ "TI.DESCRICAO AS INGREDIENTE, "
					+ "TUN.UNIDADE_MEDIDA, "
					+ "TUNC.NOME AS UNIDADE_MEDIDA_CASEIRA "
					+ "FROM TB_FICHA_ITEM TFI "
					+ "JOIN TB_INGREDIENTES TI "
					+ "JOIN TB_UNIDADE_MEDIDA TUN "
					+ "JOIN TB_UNIDADE_MEDIDA_CASEIRA TUNC "
					+ "WHERE ID_FICHA = "+idFichaCompleta
					+ " AND TI.ID = TFI.ID_INGREDIENTE "
					+ "AND TUN.ID_UNIDADE_MEDIDA = TFI.ID_UNIDADE_MEDIDA "
					+ "AND TUNC.ID_UNIDADE_MEDIDA_CASEIRA = TFI.ID_MEDIDA_CASEIRA");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				
				FichaItem item = new FichaItem();
				item.setIdFichaItem(resultSet.getInt("ID_FICHA_ITEM"));
				item.setIdIngrediente(resultSet.getInt("ID_INGREDIENTE"));
				item.setIdMedidaCaseira(resultSet.getInt("ID_MEDIDA_CASEIRA"));
				item.setIdUnidadeMedida(resultSet.getInt("ID_UNIDADE_MEDIDA"));
				item.setQuantidadeMedidaCaseira(resultSet.getDouble("QUANTIDADE_MEDIDA_CASEIRA"));
				item.setQuantidadeUnidadeMedida(resultSet.getDouble("QUANTIDADE_UNIDADE_MEDIDA"));
				item.setFatorCorrecao(resultSet.getDouble("FATOR_CORRECAO"));
				item.setIndiceCoccao(resultSet.getDouble("INDICE_COCCAO"));
				item.setIdFicha(idFichaCompleta);
				item.setIngrediente(resultSet.getString("INGREDIENTE"));
				item.setUnidadeMedida(resultSet.getString("UNIDADE_MEDIDA"));
				item.setUnidadeMedidaCaseira(resultSet.getString("UNIDADE_MEDIDA_CASEIRA"));
				item.setGorduraTrans(resultSet.getDouble("GORDURA_TRANS"));
				itens.add(item);
			}
			return itens;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
			// throw new
			// PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?",
			// fichaSimplificada.getNome()));
		} finally {
			conexao.close();
		}

	}

	public int cadastrarFichaCompletaDAO(FichaItem item) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO TB_FICHA_ITEM (" + " ID_UNIDADE_MEDIDA," + " ID_MEDIDA_CASEIRA," + " ID_INGREDIENTE,"
							+ " ID_FICHA," + " QUANTIDADE_UNIDADE_MEDIDA," + " QUANTIDADE_MEDIDA_CASEIRA, " +"FATOR_CORRECAO, " + "INDICE_COCCAO, " + " GORDURA_TRANS)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, item.getIdUnidadeMedida());
			statement.setInt(2, item.getIdMedidaCaseira());
			statement.setInt(3, item.getIdIngrediente());
			statement.setInt(4, item.getIdFicha());
			statement.setDouble(5, item.getQuantidadeUnidadeMedida());
			statement.setDouble(6, item.getQuantidadeMedidaCaseira());
			statement.setDouble(7, item.getFatorCorrecao());
			statement.setDouble(8, item.getIndiceCoccao());
			statement.setDouble(9, item.getGorduraTrans());

			statement.executeUpdate();

			ResultSet resultset2 = statement.getGeneratedKeys();
			int idFichaItem = 0;
			if (resultset2.first()) {
				idFichaItem = resultset2.getInt(1);
			}
			return idFichaItem;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
			// throw new
			// PersistenciaException(MensagemContantes.MSG_ERR_FICHA_Completa_JA_EXISTENTE.replace("?",
			// fichaCompleta.getNome()));
		} finally {
			conexao.close();
		}

	}

	public boolean editarFichaCompletaItem(FichaItem item) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_FICHA_ITEM SET " + " ID_UNIDADE_MEDIDA = ?," + " ID_MEDIDA_CASEIRA = ?,"
					+ " ID_INGREDIENTE = ?," + " QUANTIDADE_UNIDADE_MEDIDA = ?," + " QUANTIDADE_MEDIDA_CASEIRA = ?,"
					+ " FATOR_CORRECAO = ?,"
					+ "INDICE_COCCAO = ?,"
					+ " GORDURA_TRANS = ?"
					+ " WHERE ID_FICHA_ITEM = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, item.getIdUnidadeMedida());
			statement.setInt(2, item.getIdMedidaCaseira());
			statement.setInt(3, item.getIdIngrediente());
			statement.setDouble(4, item.getQuantidadeUnidadeMedida());
			statement.setDouble(5, item.getQuantidadeMedidaCaseira());
			statement.setDouble(6, item.getFatorCorrecao());
			statement.setDouble(7, item.getIndiceCoccao());
			statement.setDouble(8, item.getGorduraTrans());
			statement.setInt(9, item.getIdFichaItem());

			return statement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
			// throw new
			// PersistenciaException(MensagemContantes.MSG_ERR_FICHA_Completa_JA_EXISTENTE.replace("?",
			// fichaCompleta.getNome()));
		} finally {
			conexao.close();
		}

	}
	
	public boolean removerFichaTecnicaItem(Integer idFichaItem) throws PersistenciaException{
		boolean removidoOK = false;
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			// delete TB_FICHA_ITEM
			sql.append("DELETE FROM TB_FICHA_ITEM WHERE ID_FICHA_ITEM = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, idFichaItem);
			statement.execute();


			removidoOK = true;

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
	
	
	public boolean removerTodosFichaTecnicaItem(Integer idFicha) throws PersistenciaException{
		boolean removidoOK = false;
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			// delete TB_FICHA_ITEM
			sql.append("DELETE FROM TB_FICHA_ITEM WHERE ID_FICHA = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, idFicha);
			statement.execute();

			removidoOK = true;

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

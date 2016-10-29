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

public class FichaSimplificadaItemDAO {

	public List<FichaItem> listaFichaSimplificadaItem(int idFichaSimplificada) throws PersistenciaException, SQLException {
		Connection conexao = null;
		List<FichaItem> itens = new ArrayList<>();
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID_FICHA_ITEM," + " ID_UNIDADE_MEDIDA," + " ID_MEDIDA_CASEIRA," + " ID_INGREDIENTE,"
					+ " QUANTIDADE_UNIDADE_MEDIDA," + " QUANTIDADE_MEDIDA_CASEIRA," + " ID_FICHA ");
			sql.append("WHERE ID_FICHA = " + idFichaSimplificada);

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				FichaItem item = new FichaItem();
				item.setIdFichaItem(resultSet.getInt("ID_FICHA_ITEM"));
				item.setIdIngrediente(resultSet.getInt("ID_INGREDIENTE"));
				item.setIdMedidaCaseira(resultSet.getInt("ID_MEDIDA_CASEIRA"));
				item.setIdUnidadeMedida(resultSet.getInt("ID_UNIDADE_MEDIDA"));
				item.setQuantidadeMedidaCaseira(resultSet.getInt("QUANTIDADE_MEDIDA_CASEIRA"));
				item.setQuantidadeUnidadeMedida(resultSet.getInt("QUANTIDADE_UNIDADE_MEDIDA"));
				item.setIdFicha(idFichaSimplificada);
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

	public int cadastrarFichaSimplificadaDAO(FichaItem item) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO TB_FICHA_ITEM (" + " ID_UNIDADE_MEDIDA," + " ID_MEDIDA_CASEIRA," + " ID_INGREDIENTE,"
							+ " ID_FICHA," + " QUANTIDADE_UNIDADE_MEDIDA," + " QUANTIDADE_MEDIDA_CASEIRA )");
			sql.append("VALUES (?, ?, ?, ?, ?, ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, item.getIdUnidadeMedida());
			statement.setInt(2, item.getIdMedidaCaseira());
			statement.setInt(3, item.getIdIngrediente());
			statement.setInt(4, item.getIdFicha());
			statement.setInt(5, item.getQuantidadeUnidadeMedida());
			statement.setInt(6, item.getQuantidadeMedidaCaseira());

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
			// PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?",
			// fichaSimplificada.getNome()));
		} finally {
			conexao.close();
		}

	}

	public boolean editarFichaSimplificadaItem(FichaItem item) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE TB_FICHA_ITEM SET " + " ID_UNIDADE_MEDIDA = ?," + " ID_MEDIDA_CASEIRA = ?,"
					+ " ID_INGREDIENTE = ?," + " QUANTIDADE_UNIDADE_MEDIDA = ?," + " QUANTIDADE_MEDIDA_CASEIRA = ?"
					+ " WHERE ID_FICHA_ITEM = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, item.getIdUnidadeMedida());
			statement.setInt(2, item.getIdMedidaCaseira());
			statement.setInt(3, item.getIdIngrediente());
			statement.setInt(4, item.getQuantidadeUnidadeMedida());
			statement.setInt(5, item.getQuantidadeMedidaCaseira());
			statement.setInt(6, item.getIdFichaItem());

			return statement.execute();
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
			// throw new
			// PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?",
			// fichaSimplificada.getNome()));
		} finally {
			conexao.close();
		}

	}

}

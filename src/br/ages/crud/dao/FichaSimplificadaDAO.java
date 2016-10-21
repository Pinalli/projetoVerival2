package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

/**
 * @author Alessandro
 */

public class FichaSimplificadaDAO {

	private ArrayList<Ficha> listarFichasSimplificada;

	public int cadastrarFichaSimplificada(Ficha fichaSimplificada) throws SQLException, PersistenciaException {
		Connection conexao = null;

		try {
			Integer idFichaSimplificada = null;

			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_FICHA_SIMPLIFICADA (nome, rendimento, foto, modo_preparo, montagem, orientacoes_armazenamento, tipo_ficha)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, fichaSimplificada.getNome());
			statement.setString(2, fichaSimplificada.getRendimento());
			statement.setString(3, fichaSimplificada.getFoto());
			statement.setString(4, fichaSimplificada.getModoPreparo());
			statement.setString(5, fichaSimplificada.getMontagem());
			statement.setString(6, fichaSimplificada.getOrientacoesArmazenamento());
			statement.setString(7, fichaSimplificada.getTipoFicha());

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idFichaSimplificada = resultset.getInt(1);
			}
			
			fichaSimplificada.setIdFicha(idFichaSimplificada);

			StringBuilder sql2 = new StringBuilder();
			for (FichaItem fichaItem : fichaSimplificada.getItens()) {
				sql2.append("INSERT INTO TB_FICHA_ITEM (ID_UNIDADE_MEDIDA, ID_MEDIDA_CASEIRA, ID_INGREDIENTE, ID_FICHA, QUANTIDADE_UNIDADE_MEDIDA,QUANTIDADE_MEDIDA_CASEIRA )");
				sql.append("VALUES (?, ?, ?, ?, ?, ?)");
				
				PreparedStatement statement2 = conexao.prepareStatement(sql2.toString(), Statement.RETURN_GENERATED_KEYS);
				
				statement2.setInt(1, fichaItem.getIdUnidadeMedida());
				statement2.setInt(2, fichaItem.getIdMedidaCaseira());
				statement2.setInt(3, fichaItem.getIdIngrediente());
				statement2.setInt(4, idFichaSimplificada);
				statement2.setInt(5, fichaItem.getQuantidadeUnidadeMedida());
				statement2.setInt(6, fichaItem.getQuantidadeMedidaCaseira());
				
				statement2.executeUpdate();
				
				ResultSet resultset2 = statement.getGeneratedKeys();
				int idFichaItem = 0;
				if (resultset.first()) {
					idFichaItem = resultset2.getInt(1);
				}
				fichaItem.setIdFicha(idFichaItem);
			}
			

			return idFichaSimplificada;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?",fichaSimplificada.getNome()));

		} finally {
			conexao.close();
		}
	}

	public List<Ficha> listarFichasSimplificada() throws PersistenciaException, SQLException {
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_FICHA WHERE ID_FICHA = ? ");
			// A IMPLEMENTAR...

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Ficha dto = new Ficha();
				dto.setNome(resultset.getString("nome"));
				dto.setRendimento("rendimento");
				dto.setFoto("foto");
				dto.setModoPreparo("modo_preparo");
				dto.setModoPreparo("montagem");
				dto.setOrientacoesArmazenamento("orientacoes_armazanamento");
				dto.setTipoFicha("tipo_ficha");
				dto.setTextura("textura");
				dto.setSabor("sabor");
				dto.setApresentacao("apresentacao");

				listarFichasSimplificada.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);

		} finally {
			conexao.close();
		}
		return listarFichasSimplificada;
	}

	public boolean editarFichaSimplificada(Ficha fichaSimplificada) throws PersistenciaException {
		boolean okei = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = fichaSimplificada.getIdFicha();

			sql.append(
					"UPDATE TB_FICHA_SIMPLIFICADA set nome = ?, rendimento = ?, foto = ?, modo_preparo = ?, montagem = ?, orientacaoes_armazenamento = ?, tipo_ficha = ?, textura = ?, sabor = ?, apresentacao = ?  WHERE id_usuario = "
							+ id + ";");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
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

	public boolean removerFichaSimplificada(Integer idFicha) throws PersistenciaException {
		boolean removidoOK = false;
		Connection conexao = null;

		try {

			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("DELETE FROM TB_FICHA WHERE ID_FICHA = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setInt(1, idFicha);
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
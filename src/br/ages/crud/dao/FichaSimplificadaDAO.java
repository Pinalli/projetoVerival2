package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
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
			sql.append(
					"INSERT INTO TB_FICHA_SIMPLIFICADA (nome, rendimento, modo_preparo, montagem, orientacoes_armazenamento, data_inclusao)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?)");

			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());

			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, fichaSimplificada.getNome());
			statement.setString(2, fichaSimplificada.getRendimento());
			statement.setString(3, fichaSimplificada.getModoPreparo());
			statement.setString(4, fichaSimplificada.getMontagem());
			statement.setString(5, fichaSimplificada.getOrientacoesArmazenamento());
			statement.setDate(6, dataCadastro);

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idFichaSimplificada = resultset.getInt(1);
			}

			return idFichaSimplificada;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?",
					fichaSimplificada.getNome()));

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

	public boolean editarFichaSimplificada(Ficha fichaSimplificada) {
		boolean okei = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = fichaSimplificada.getIdFicha();

			sql.append("UPDATE TB_FICHA_SIMPLIFICADA set nome = ?, rendimento = ?, foto = ?, modo_preparo = ?, montagem = ?, orientacaoes_armazenamento = ?, tipo_ficha = ?, textura = ?, sabor = ?, apresentacao = ?  WHERE id_usuario = "+ id + ";");

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

	public boolean removerFichaSimplificada(Integer idFicha) {
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
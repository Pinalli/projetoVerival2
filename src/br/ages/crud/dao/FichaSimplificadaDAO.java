package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

/**
 * @author Alessandro
 */

public class FichaSimplificadaDAO {
	
	public int cadastrarFichaSimplificada(Ficha fichaSimplificada) throws SQLException, PersistenciaException{
		Connection conexao = null;
		
		try{
			Integer idFichaSimplificada = null;
			
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_FICHA_SIMPLIFICADA (nome, rendimento, modo_preparo, montagem, orientacoes_armazenamento, data_inclusao)");
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
			
		}catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?", fichaSimplificada.getNome()));

		} finally {
			conexao.close();
		}
	}

}

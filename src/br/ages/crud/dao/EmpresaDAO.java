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
import br.ages.crud.model.Empresa;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

/**
 * 
 * @author iann muller
 *
 */
public class EmpresaDAO {

	private ArrayList<Empresa> listarEmpresa;

	public EmpresaDAO() {
		listarEmpresa = new ArrayList<>();
	}

	/**
	 * Autentica o usu?rio
	 * 
	 * @author cassio trindade
	 * @param usuarioDTO
	 * @return
	 * @throws PersistenciaException
	 */

	public Empresa validarEmpresa(Empresa empresaDTO) throws PersistenciaException {
		Empresa empresa = new Empresa();
		try {

			Connection conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_EMPRESA ");
			sql.append("WHERE empresa = ? AND cnpj = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, empresaDTO.getNome());
			statement.setString(2, empresaDTO.getCnpj());

			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				empresa.setIdEmpresa(resultset.getInt("ID_EMPRESA"));
				empresa.setCnpj(resultset.getString("CNPJ"));
				empresa.setNome(resultset.getString("NOME"));
				empresa.setRazaoSocial(resultset.getString("RAZAO_SOCIAL"));
				empresa.setCidade(resultset.getString("CIDADE"));
				empresa.setEndereco(resultset.getString("ENDERECO"));
				empresa.setTelefone(resultset.getString("TELEFONE"));
				empresa.setResponsavel(resultset.getString("RESPONSAVEL"));
				empresa.setResponsavel(resultset.getString("LOGO"));
			} else
				empresa = null;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		}

		return empresa;
	}

	/**
	 * Lista os Usuarios da basee
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Empresa> listarEmpresa() throws PersistenciaException, SQLException {
		Connection conexao = null;
		// tentativa de readaptação do listarUsuarios()
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT e.* ");
			sql.append("FROM TB_EMPRESA e");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Empresa dto = new Empresa();
				dto.setIdEmpresa(resultset.getInt("ID_EMPRESA"));
				dto.setCnpj(resultset.getString("CNPJ"));
				dto.setNome(resultset.getString("NOME"));
				dto.setTelefone(resultset.getString("TELEFONE"));
				dto.setEndereco(resultset.getString("ENDERECO"));
				dto.setCidade(resultset.getString("CIDADE"));
				dto.setRazaoSocial(resultset.getString("RAZAO_SOCIAL"));
				dto.setResponsavel(resultset.getString("RESPONSAVEL"));
				dto.setResponsavel(resultset.getString("LOGO"));
				
				listarEmpresa.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarEmpresa;
	}

	public int cadastrarEmpresa(Empresa empresa) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;

		try {
			Integer idEmpresa = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append(
					"INSERT INTO TB_EMPRESA (CNPJ, NOME, TELEFONE, ENDERECO, CIDADE, RAZAO_SOCIAL, RESPONSAVEL, LOGO, DATA_INCLUSAO)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())");

			// Cadastra a pessoa e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, empresa.getCnpj());
			statement.setString(2, empresa.getNome());
			statement.setString(3, empresa.getTelefone());
			statement.setString(4, empresa.getEndereco());
			statement.setString(5, empresa.getCidade());
			statement.setString(6, empresa.getRazaoSocial());
			statement.setString(7, empresa.getResponsavel());
			statement.setString(8, empresa.getLogo());


			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idEmpresa = resultset.getInt(1);

			}
			return idEmpresa;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(
					MensagemContantes.MSG_ERR_EMPRESA_JA_EXISTENTE.replace("?", empresa.getNome()));

		} finally {
			conexao.close();
		}
	}

	/**
	 * M?todo de remo??o de um usu?rio a partir do seu id.
	 * 
	 * @param idPessoa
	 * @throws PersistenciaException
	 */
	public boolean removerEmpresa(Integer idEmpresa) throws PersistenciaException {
		boolean removidoOK = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();

			sql.append("DELETE FROM TB_EMPRESA WHERE ID_EMPRESA = ?");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idEmpresa);
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

	public Empresa buscaEmpresaNome(String nome) throws PersistenciaException {

		Empresa empresa = new Empresa();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM TB_USUARIO WHERE NOME = ?");
			sql.append("SELECT e.* FROM TB_EMPRESA e");
			sql.append("WHERE e.nome = ?;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, nome);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				empresa.setIdEmpresa(resultset.getInt("ID_EMPRESA"));
				empresa.setCnpj(resultset.getString("CNPJ"));
				empresa.setNome(resultset.getString("NOME"));
				empresa.setTelefone(resultset.getString("TELEFONE"));
				empresa.setEndereco(resultset.getString("ENDERECO"));
				empresa.setCidade(resultset.getString("CIDADE"));
				empresa.setRazaoSocial(resultset.getString("RAZAO_SOCIAL"));
				empresa.setResponsavel(resultset.getString("RESPOSAVEL"));
				empresa.setLogo(resultset.getString("LOGO"));
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

		return empresa;
	}

	public Empresa buscaEmpresaId(int idEmpresa) throws PersistenciaException, SQLException {
		// adicionar informações de tipo de usuario?
		Empresa empresa = new Empresa();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM AGES_E.TB_USUARIO WHERE ID_USUARIO =
			// ?;");
			//
			sql.append("SELECT e.*");
			sql.append("FROM TB_EMPRESA e ");
			sql.append("WHERE e.ID_EMPRESA = ?;");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idEmpresa);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				empresa.setIdEmpresa(resultset.getInt("ID_EMPRESA"));
				empresa.setCnpj(resultset.getString("CNPJ"));
				empresa.setNome(resultset.getString("NOME"));
				empresa.setTelefone(resultset.getString("TELEFONE"));
				empresa.setEndereco(resultset.getString("ENDERECO"));
				empresa.setCidade(resultset.getString("CIDADE"));
				empresa.setRazaoSocial(resultset.getString("RAZAO_SOCIAL"));
				empresa.setResponsavel(resultset.getString("RESPONSAVEL"));
				empresa.setLogo(resultset.getString("LOGO"));
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

		return empresa;

	}

	public boolean editaEmpresa(Empresa empresa) throws PersistenciaException {
		boolean okei = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = empresa.getIdEmpresa();

			sql.append("UPDATE TB_EMPRESA SET CNPJ = ?, NOME = ?,"
					+ "TELEFONE = ?, ENDERECO = ?, CIDADE = ?, RAZAO_SOCIAL = ?, RESPONSAVEL = ?, LOGO = ? "
					+ "  WHERE ID_EMPRESA = " + id + ";");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, empresa.getCnpj());
			statement.setString(2, empresa.getNome());
			statement.setString(3, empresa.getTelefone());
			statement.setString(4, empresa.getEndereco());
			statement.setString(5, empresa.getCidade());
			statement.setString(6, empresa.getRazaoSocial());
			statement.setString(7, empresa.getResponsavel());
			statement.setString(8, empresa.getLogo());
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
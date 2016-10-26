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
import br.ages.crud.model.Usuario;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;

public class UsuarioDAO {

	private ArrayList<Usuario> listarUsuarios;

	public UsuarioDAO() {
		listarUsuarios = new ArrayList<>();
	}

	/**
	 * Autentica o usu?rio
	 * 
	 * @author cassio trindade
	 * @param usuarioDTO
	 * @return
	 * @throws PersistenciaException
	 */

	public Usuario validarUsuario(Usuario usuarioDTO) throws PersistenciaException {
		Usuario usuario = new Usuario();
		try {

			Connection conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_USUARIO ");
			sql.append("WHERE USUARIO = ? AND SENHA = ?");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, usuarioDTO.getUsuario());
			statement.setString(2, usuarioDTO.getSenha());

			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setCpf(resultset.getString("CPF"));
				usuario.setNome(resultset.getString("NOME"));
				usuario.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				usuario.setEmail(resultset.getString("EMAIL"));
				usuario.setUsuario(resultset.getString("USUARIO"));
				usuario.setSenha(resultset.getString("SENHA"));
				usuario.setEndereco(resultset.getString("ENDERECO"));
				usuario.setTelefone(resultset.getString("TELEFONE"));
			} else
				usuario = null;
		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		}

		return usuario;
	}

	/**
	 * Lista os Usuarios da basee
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Usuario> listarUsuarios() throws PersistenciaException, SQLException {
		Connection conexao = null;
		// tentativa de readaptação do listarUsuarios()
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("U.`ID_USUARIO`,");
			sql.append("U.`USUARIO`,");
			sql.append("U.`SENHA`,");
			sql.append("U.`CONFIRMAR_SENHA`,");
			sql.append("U.`PERFIL_ACESSO`,");
			sql.append("U.`STATUS_USUARIO`,");
			sql.append("U.`ID_TIPO_USUARIO`,");
			sql.append("U.`CPF`,");
			sql.append("U.`ENDERECO`,");
			sql.append("U.`TELEFONE`,");
			sql.append("U.`NOME` unome,");
			sql.append("U.`EMAIL`,");
			sql.append("T.`ID_TIPO_USUARIO`,");
			sql.append("T.`NOME` tnome,");
			sql.append("T.`DESCRICAO`,");
			sql.append("T.`DATA_INCLUSAO`");
			
			sql.append("FROM TB_USUARIO U INNER JOIN TB_TIPO_USUARIO T "); 
			sql.append("ON T.ID_TIPO_USUARIO = U.ID_TIPO_USUARIO ");
			
			//funciona no workbench mas aqui n䯍
			sql.append("WHERE STATUS_USUARIO='ATIVO'");
			

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Usuario dto = new Usuario();
				TipoUsuario tipoUsuario = new TipoUsuario();
				dto.setIdUsuario(resultset.getInt("ID_USUARIO"));
				dto.setCpf(resultset.getString("CPF"));
				dto.setNome(resultset.getString("unome"));
				dto.setEmail(resultset.getString("EMAIL"));
				dto.setUsuario(resultset.getString("USUARIO"));
				dto.setSenha(resultset.getString("SENHA"));
				dto.setConfirmarSenha(resultset.getString("CONFIRMAR_SENHA"));
				dto.setEndereco(resultset.getString("ENDERECO"));
				dto.setTelefone(resultset.getString("TELEFONE"));
				dto.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				dto.setStatusUsuario(StatusUsuario.valueOf(resultset.getString("STATUS_USUARIO")));
				tipoUsuario.setIdTipoUsuario(resultset.getInt("ID_TIPO_USUARIO"));
				tipoUsuario.setNome(resultset.getString("tnome"));
				tipoUsuario.setDescricao(resultset.getString("DESCRICAO"));
				dto.setTipoUsuario(tipoUsuario);

				listarUsuarios.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarUsuarios;
	}

	public int cadastrarUsuario(Usuario usuario) throws PersistenciaException, SQLException, ParseException {
		Connection conexao = null;

		try {
			Integer idUsuario = null;

			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO TB_USUARIO (USUARIO, SENHA, CONFIRMAR_SENHA, PERFIL_ACESSO, STATUS_USUARIO, ID_TIPO_USUARIO, CPF, ENDERECO, TELEFONE, NOME, EMAIL, DATA_INCLUSAO)");
			sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			// converte a data para data Juliana, data que o banco reconhece;
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date dataCadastro = new java.sql.Date(utilDate.getTime());

			// Cadastra a pessoa e gera e busca id gerado
			PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getConfirmarSenha());
			statement.setString(4, String.valueOf(usuario.getPerfilAcesso()));
			statement.setString(5, String.valueOf(usuario.getStatusUsuario()));
			statement.setInt(6, usuario.getTipoUsuario().getIdTipoUsuario());
			statement.setString(7, usuario.getCpf());
			statement.setString(8, usuario.getEndereco());
			statement.setString(9, usuario.getTelefone());
			statement.setString(10, usuario.getNome());
			statement.setString(11, usuario.getEmail());
			statement.setDate(12, dataCadastro);

			statement.executeUpdate();

			ResultSet resultset = statement.getGeneratedKeys();
			if (resultset.first()) {
				idUsuario = resultset.getInt(1);

			}
			return idUsuario;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(MensagemContantes.MSG_ERR_USUARIO_JA_EXISTENTE.replace("?", usuario.getUsuario()));

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
	public boolean removerUsuario(Integer idUsuario) throws PersistenciaException {
		boolean removidoOK = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT ID_TIPO_USUARIO FROM TB_USUARIO WHERE ID_USUARIO = ?
			// ")
			sql.append("UPDATE TB_USUARIO SET STATUS_USUARIO='INATIVO'  WHERE ID_USUARIO= ? ");
			
			// sql.append("DELETE FROM TB_TIPO_USUARIO WHERE
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUsuario);

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

	public Usuario buscaUsuarioNome(String nomeUsuario) throws PersistenciaException {

		Usuario usuario = new Usuario();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM TB_USUARIO WHERE NOME = ?");
			sql.append("SELECT ");
			sql.append("U.`ID_USUARIO`,");
			sql.append("U.`USUARIO`,");
			sql.append("U.`SENHA`,");
			sql.append("U.`CONFIRMAR_SENHA`,");
			sql.append("U.`PERFIL_ACESSO`,");
			sql.append("U.`STATUS_USUARIO`,");
			sql.append("U.`ID_TIPO_USUARIO`,");
			sql.append("U.`CPF`,");
			sql.append("U.`ENDERECO`,");
			sql.append("U.`TELEFONE`,");
			sql.append("U.`NOME` UNOME,");
			sql.append("U.`EMAIL`,");
			sql.append("T.`ID_TIPO_USUARIO`,");
			sql.append("T.`NOME` TNOME,");
			sql.append("T.`DESCRICAO`,");
			sql.append("T.`DATA_INCLUSAO`");
			sql.append("FROM TB_USUARIO U INNER JOIN TB_TIPO_USUARIO T ");
			sql.append("ON T.ID_TIPO_USUARIO = U.ID_TIPO_USUARIO ");
			sql.append("WHERE U.NOME = ?;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, nomeUsuario);

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setCpf(resultset.getString("CPF"));
				usuario.setNome(resultset.getString("unome"));
				usuario.setEmail(resultset.getString("EMAIL"));
				usuario.setUsuario(resultset.getString("USUARIO"));
				usuario.setSenha(resultset.getString("SENHA"));
				usuario.setConfirmarSenha(resultset.getString("CONFIRMAR_SENHA"));
				usuario.setEndereco(resultset.getString("ENDERECO"));
				usuario.setTelefone(resultset.getString("TELEFONE"));
				usuario.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				usuario.setStatusUsuario(StatusUsuario.valueOf(resultset.getString("STATUS_USUARIO")));
				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setIdTipoUsuario(resultset.getInt("ID_TIPO_USUARIO"));
				tipoUsuario.setNome(resultset.getString("TNOME"));
				tipoUsuario.setDescricao(resultset.getString("DESCRICAO"));
				usuario.setTipoUsuario(tipoUsuario);
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

		return usuario;
	}

	public Usuario buscaUsuarioId(int idUsuario) throws PersistenciaException, SQLException {
		// adicionar informações de tipo de usuario?
		Usuario usuario = new Usuario();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM AGES_E.TB_USUARIO WHERE ID_USUARIO = ?;");
			//
			sql.append("SELECT ");
			sql.append("U.`ID_USUARIO`,");
			sql.append("U.`USUARIO`,");
			sql.append("U.`SEHHA`,");
			sql.append("U.`CONFIRMAR_SENHA`,");
			sql.append("U.`PERFIL_ACESSO`,");
			sql.append("U.`STATUS_USUARIO`,");
			sql.append("U.`ID_TIPO_USUARIO`,");
			sql.append("U.`CPF`,");
			sql.append("U.`TELEFONE`,");
			sql.append("U.`ENDERECO`,");
			sql.append("U.`NOME` UNOME,");
			sql.append("U.`EMAIL`,");
			sql.append("T.`ID_TIPO_USUARIO`,");
			sql.append("T.`NOME` TNOME,");
			sql.append("T.`DESCRICAO`,");
			sql.append("T.`DATA_INCLUSAO`");
			sql.append("FROM TB_USUARIO U INNER JOIN TB_TIPO_USUARIO T ");
			sql.append("ON T.ID_TIPO_USUARIO = U.ID_TIPO_USUARIO ");
			sql.append("WHERE ID_USUARIO = ?;");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setInt(1, idUsuario);
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setCpf(resultset.getString("CPF"));
				usuario.setEndereco(resultset.getString("endereco"));
				usuario.setTelefone(resultset.getString("telefone"));
				usuario.setNome(resultset.getString("UNOME"));
				usuario.setEmail(resultset.getString("EMAIL"));
				usuario.setUsuario(resultset.getString("USUARIO"));
				usuario.setSenha(resultset.getString("SENHA"));
				usuario.setConfirmarSenha(resultset.getString("CONFIRMAR_SENHA"));
				usuario.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				usuario.setStatusUsuario(StatusUsuario.valueOf(resultset.getString("STATUS_USUARIO")));
				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setIdTipoUsuario(resultset.getInt("ID_TIPO_USUARIO"));
				tipoUsuario.setNome(resultset.getString("TNOME"));
				tipoUsuario.setDescricao(resultset.getString("DESCRICAO"));
				usuario.setTipoUsuario(tipoUsuario);
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

		return usuario;

	}

	

	public TipoUsuario consultaTipoUsuario(String idTipoUsuario) throws PersistenciaException {
		Connection conexao = null;
		TipoUsuario tipoUsuario = new TipoUsuario();
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * FROM TB_TIPO_USUARIO WHERE ID_TIPO_USUARIO = ?;");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, idTipoUsuario);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				tipoUsuario.setIdTipoUsuario(resultset.getInt("ID_TIPO_USUARIO"));
				tipoUsuario.setNome(resultset.getString("NOME"));
				tipoUsuario.setDescricao(resultset.getString("DESCRICAO"));
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
		return tipoUsuario;
	}

	public boolean editaUsuario(Usuario usuario) throws PersistenciaException {
		boolean okei = false;
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			StringBuilder sql = new StringBuilder();
			int id = usuario.getIdUsuario();

			sql.append("UPDATE TB_USUARIO SET SENHA = ?, PERFIL_ACESSO = ?," + "STATUS_USUARIO = ?, ID_TIPO_USUARIO = ?, NOME = ?, EMAIL = ?, CPF = ?, ENDERECO = ?, TELEFONE = ?, CONFIRMAR_SENHA = ? " + "  WHERE ID_USUARIO = " + id + ";");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());

			statement.setString(1, usuario.getSenha());
			statement.setString(2, usuario.getPerfilAcesso().name());
			statement.setString(3, usuario.getStatusUsuario().name());
			statement.setInt(4, usuario.getTipoUsuario().getIdTipoUsuario());
			statement.setString(5, usuario.getNome());
			statement.setString(6, usuario.getEmail());
			statement.setString(7, usuario.getCpf());
			statement.setString(8, usuario.getEndereco());
			statement.setString(9, usuario.getTelefone());
			statement.setString(10, usuario.getConfirmarSenha());
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

	/**
	 * <<<<<<< HEAD Lista os tipos de usu�rios ======= Lista os tipos de
	 * usu�rios >>>>>>> branch 'dev' of
	 * https://github.com/agespucrs/fluxoAges.git
	 * 
	 * @return
	 * @throws PersistenciaException
	 */
	public List<TipoUsuario> listaTipoUsuarios() throws PersistenciaException {
		Usuario usuario = new Usuario();

		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			List<TipoUsuario> tipoUsuarios = new ArrayList<>();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM AGES_E.TB_USUARIO WHERE ID_USUARIO = ?;");
			//
			sql.append("SELECT ");
			sql.append("`ID_TIPO_USUARIO`,");
			sql.append("`NOME` ,");
			sql.append("`DESCRICAO`,");
			sql.append("`DATA_INCLUSAO` ");
			sql.append("FROM TB_TIPO_USUARIO; ");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {
				TipoUsuario tipoUsuario = new TipoUsuario();

				tipoUsuario.setIdTipoUsuario(resultset.getInt("ID_TIPO_USUARIO"));
				tipoUsuario.setNome(resultset.getString("NOME"));
				tipoUsuario.setDescricao(resultset.getString("DESCRICAO"));
				usuario.setTipoUsuario(tipoUsuario);

				tipoUsuarios.add(tipoUsuario);

			}

			return tipoUsuarios;

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			try {
				conexao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Busca nos banco os usu⳩os responsⷥis
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Usuario> listarUsuariosReponsaveis() throws PersistenciaException, SQLException {
		Connection conexao = null;
		// tentativa de readaptação do listarUsuarios()
		try {
			conexao = ConexaoUtil.getConexao();
			listarUsuarios = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("U.`ID_USUARIO`,");
			sql.append("U.`USUARIO`,");
			sql.append("U.`SENHA`,");
			sql.append("U.`CONFIRMAR_SENHA`,");
			sql.append("U.`PERFIL_ACESSO`,");
			sql.append("U.`STATUS_USUARIO`,");
			sql.append("U.`ID_TIPO_USUARIO`,");
			sql.append("U.`CPF`,");
			sql.append("U.`ENDERECO`,");
			sql.append("U.`TELEFONE`,");
			sql.append("U.`NOME`,");
			sql.append("U.`EMAIL` ");

			sql.append("FROM TB_USUARIO U INNER JOIN TB_TIPO_USUARIO T ");
			sql.append(" ON T.ID_TIPO_USUARIO = U.ID_TIPO_USUARIO");
			sql.append(" WHERE T.FLAG_RESPONSAVEL = 1;");
			
					
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Usuario dto = new Usuario();
				dto.setIdUsuario(resultset.getInt("ID_USUARIO"));
				dto.setCpf(resultset.getString("CPF"));
				dto.setEndereco(resultset.getString("ENDERECO"));
				dto.setTelefone(resultset.getString("TELEFONE"));
				dto.setNome(resultset.getString("NOME"));
				dto.setEmail(resultset.getString("EMAIL"));
				dto.setUsuario(resultset.getString("USUARIO"));
				dto.setSenha(resultset.getString("SENHA"));
				dto.setSenha(resultset.getString("CONFIRMAR_SENHA"));
				dto.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				dto.setStatusUsuario(StatusUsuario.valueOf(resultset.getString("STATUS_USUARIO")));

				listarUsuarios.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarUsuarios;
	}
	/**
	 * Lista os Usuarios da basee
	 * 
	 * @return
	 * @throws PersistenciaException
	 * @throws SQLException
	 */
	public List<Usuario> listarUsuariosAlunos() throws PersistenciaException, SQLException {
		Connection conexao = null;
		// tentativa de readaptação do listarUsuarios()
		try {
			conexao = ConexaoUtil.getConexao();
			listarUsuarios = new ArrayList<>();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append("U.`ID_USUARIO`,");
			sql.append("U.`USUARIO`,");
			sql.append("U.`SENHA`,");
			sql.append("U.`CONFIRMAR_SENHA`,");
			sql.append("U.`PERFIL_ACESSO`,");
			sql.append("U.`STATUS_USUARIO`,");
			sql.append("U.`ID_TIPO_USUARIO`,");
			sql.append("U.`CPF`,");
			sql.append("U.`ENDERECO`,");
			sql.append("U.`TELEFONE`,");
			sql.append("U.`NOME`,");
			sql.append("U.`EMAIL` ");

			sql.append("FROM TB_USUARIO U INNER JOIN TB_TIPO_USUARIO T ");
			sql.append(" ON T.ID_TIPO_USUARIO = U.ID_TIPO_USUARIO");
			sql.append(" WHERE T.NOME = 'ALUNO';");

			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Usuario dto = new Usuario();
				dto.setIdUsuario(resultset.getInt("ID_USUARIO"));
				dto.setCpf(resultset.getString("CPF"));
				dto.setEndereco(resultset.getString("endereco"));
				dto.setTelefone(resultset.getString("telefone"));
				dto.setNome(resultset.getString("NOME"));
				dto.setEmail(resultset.getString("EMAIL"));
				dto.setUsuario(resultset.getString("USUARIO"));
				dto.setSenha(resultset.getString("SENHA"));
				dto.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				dto.setStatusUsuario(StatusUsuario.valueOf(resultset.getString("STATUS_USUARIO")));

				listarUsuarios.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new PersistenciaException(e);
		} finally {
			conexao.close();
		}
		return listarUsuarios;
	}

	public Usuario buscaUsuarioPorSenha(Usuario usuarioDto) throws PersistenciaException {
		Usuario usuario = new Usuario();
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();

			StringBuilder sql = new StringBuilder();
			// sql.append("SELECT * FROM TB_USUARIO WHERE NOME = ?");
			sql.append(" SELECT ");
			sql.append(" ID_USUARIO,");
			sql.append(" USUARIO,");
			sql.append(" SENHA,");
			sql.append(" CONFIRMAR_SENHA,");
			sql.append(" PERFIL_ACESSO,");
			sql.append(" STATUS_USUARIO,");
			sql.append(" ID_TIPO_USUARIO,");
			sql.append(" CPF,");
			sql.append(" ENDERECO,");
			sql.append(" TELEFONE,");
			sql.append(" NOME,");
			sql.append(" EMAIL");
			sql.append(" FROM TB_USUARIO ");
			sql.append(" WHERE USUARIO = ? AND EMAIL = ? ;");
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			statement.setString(1, usuarioDto.getUsuario());
			statement.setString(2, usuarioDto.getEmail());

			ResultSet resultset = statement.executeQuery();

			while (resultset.next()) {

				usuario.setIdUsuario(resultset.getInt("ID_USUARIO"));
				usuario.setCpf(resultset.getString("CPF"));
				usuario.setEndereco(resultset.getString("ENDERECO"));
				usuario.setTelefone(resultset.getString("TELEFONE"));
				usuario.setNome(resultset.getString("NOME"));
				usuario.setEmail(resultset.getString("EMAIL"));
				usuario.setUsuario(resultset.getString("USUARIO"));
				usuario.setSenha(resultset.getString("SENHA"));
				usuario.setConfirmarSenha(resultset.getString("CONFIRMAR_SENHA"));
				usuario.setPerfilAcesso(PerfilAcesso.valueOf(resultset.getString("PERFIL_ACESSO")));
				usuario.setStatusUsuario(StatusUsuario.valueOf(resultset.getString("STATUS_USUARIO")));
					
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

		return usuario;
	}
}

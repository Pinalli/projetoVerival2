package br.ages.crud.command;

import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.StatusUsuario;
import br.ages.crud.model.TipoUsuario;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class NewUserCommand implements Command {

	private UsuarioBO usuarioBO;
	private String proxima;
	
	private final StatusUsuario DEFAULT_STATUS = StatusUsuario.ATIVO;
	private final PerfilAcesso DEFAULT_PROFILE = PerfilAcesso.ADMINISTRADOR;
	
	/**
	 * Comando de criação de usuário padrão do sistema.
	 * A ser chamado quando um usuário não-cadastrado tenta criar uma conta no sistema.
	 * 
	 * @param request
	 * @throws SQLException, NegocioException, ParseException, PersistenciaException
	 */
	@Override
	public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		usuarioBO = new UsuarioBO();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String telefone = request.getParameter("telefone");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String confirmarSenha = request.getParameter("confirmarSenha");
		String tipoUsuario = request.getParameter("tipoUsuario");
				
//		String nome = "mock";
//		String email = "mock@mock.com";
//		String cpf = "84613491053";
//		String endereco = "mock";
//		String telefone = "mock";
//		String usuario = "mock";
//		String senha = "mock";
//		String confirmarSenha = "mock";
//		String tipoUsuario = "Nutricionista";
		
		try {
			Usuario user = new Usuario();
			cpf = cpf.replace(".", "").replace("-", "");
			user.setNome(nome);
			user.setEmail(email);
			user.setCpf(cpf);
			user.setEndereco(endereco);
			user.setTelefone(telefone);
			user.setUsuario(usuario);
			user.setSenha(senha);
			user.setConfirmarSenha(confirmarSenha);
			user.setStatusUsuario(DEFAULT_STATUS);
			user.setPerfilAcesso(DEFAULT_PROFILE);
			
			TipoUsuario tUser = new TipoUsuario();
			tUser = usuarioBO.consultaTipoUsuario(tipoUsuario);
			user.setTipoUsuario(tUser);
			
			boolean isValido = usuarioBO.validaUsuario(user);
			
			if (isValido) {
				usuarioBO.cadastraUsuario(user);
				//TODO check if the "user already exists" exception is being thrown
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_USUARIO.replace("?", user.getNome()));
				proxima = "login.jsp";
			} else {
				throw new NegocioException(MensagemContantes.MSG_ERR_USUARIO_DADOS_INVALIDOS);
			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			proxima = "newUser.jsp";
		}

		return proxima;
	}
}

package br.ages.crud.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ages.crud.command.*;
import org.apache.log4j.Logger;

//import br.ages.crud.command.AddEmpresaCommand;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.LogParametrosSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	Logger logger = Logger.getLogger("servlet.MainServlet");
	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();

	@Override
	public void init() throws ServletException {

		comandos.put("login", new LoginCommand());
		comandos.put("logout", new LogoutCommand());
		comandos.put("recuperarSenha", new SenhaCommand());
		comandos.put("about", new AboutCommand());

		// COMANDOS DE USUARIO

		comandos.put("telaUser", new CreateScreenUserCommand());
		comandos.put("listUser", new ListUserCommand());
		comandos.put("addUser", new AddUserCommand());
		comandos.put("editUser", new EditUserCommand());
		comandos.put("removerUsuario", new RemoveUserCommand());
		comandos.put("newUser", new NewUserCommand());

		// COMANDOS DE UNIDADE MEDIDA
		//DELETADO

		// COMANDOS DE UNIDADE DE MEDIDA CASEIRA
		comandos.put("listUnidadeMedidaCaseira", new ListUnidadeMedidaCaseiraCommand());
		comandos.put("addUnidadeMedidaCaseira", new AddUnidadeMedidaCaseiraCommand());
		comandos.put("editUnidadeMedidaCaseira", new EditUnidadeMedidaCaseiraCommand());
		comandos.put("removerUnidadeMedidaCaseira", new RemoveUnidadeMedidaCaseiraCommand());
		comandos.put("telaUnidadeMedidaCaseira", new CreateScreenUnidadeMedidaCaseiraCommand());

		// COMANDO DE INGREDIENTE
		comandos.put("telaIngredientes", new CreateScreenIngredientesCommand());
		comandos.put("listIngrediente", new ListIngredienteCommand());
		comandos.put("addIngrediente", new AddIngredienteCommand());
		comandos.put("editIngrediente", new EditIngredienteCommand());
		comandos.put("removerIngrediente", new RemoveIngredienteCommand());
		
		// COMANDOS DE EMPRESA
		comandos.put("listEmpresa", new ListEmpresaCommand());
		comandos.put("telaEmpresa", new CreateScreenEmpresaCommand());
		comandos.put("addEmpresa", new AddEmpresaCommand());
		comandos.put("editEmpresa", new EditEmpresaCommand());
		comandos.put("removerEmpresa", new RemoveEmpresaCommand());

		// COMANDOS DA FICHA TECNICA COMPLETA
		comandos.put("telaFichaCompleta", new CreateScreenFichaCompletaCommand());
		comandos.put("listFichaCompleta", new ListFichaCompletaCommand());
		comandos.put("removerFichaCompleta", new RemoveFichaCompletaCommand());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String proxima = null;

		try {
			Command comando = verificarComando(acao);
			proxima = comando.execute(request);
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSessao");
			if (usuario != null)
				logger.debug("User: " + usuario.getUsuario() + " - comando " + comando.toString() + " acao: " + acao);
		} catch (NegocioException | SQLException | ParseException | PersistenciaException e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		LogParametrosSession.logParametros(request);

		request.getRequestDispatcher(proxima).forward(request, reponse);

	}

	private Command verificarComando(String acao) {
		Command comando = null;
		for (String key : comandos.keySet()) {
			if (key.equalsIgnoreCase(acao)) {
				comando = comandos.get(key);
			}
		}
		return comando;
	}
}

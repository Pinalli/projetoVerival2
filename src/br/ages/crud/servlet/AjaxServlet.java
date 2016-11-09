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

import org.apache.log4j.Logger;

import br.ages.crud.command.AddFichaCompletaAjaxCommand;
import br.ages.crud.command.AddFichaSimplificadaAjaxCommand;
import br.ages.crud.command.BuscaEmpresaLogoAjaxCommand;
import br.ages.crud.command.BuscaIngredienteDescricaoAjaxCommand;
import br.ages.crud.command.BuscaUnidadeMedidaCaseiraNomeAjaxCommand;
import br.ages.crud.command.BuscaUnidadeMedidaUnidadeAjaxCommand;
import br.ages.crud.command.Command;
import br.ages.crud.command.EditFichaSimplificadaAjaxCommand;
//import br.ages.crud.command.AddEmpresaCommand;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Usuario;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {

	Logger logger = Logger.getLogger("servlet.MainServlet");
	private static final long serialVersionUID = 1L;
	private Map<String, Command> comandos = new HashMap<String, Command>();

	@Override
	public void init() throws ServletException {
		// COMANDOS DE INGREDIENTE
		comandos.put("buscaIngredienteDescricaoAjax", new BuscaIngredienteDescricaoAjaxCommand());

		// COMANDOS DE UNIDADE DE MEDIDA
		comandos.put("buscaUnidadeMedidaUnidadeAjax", new BuscaUnidadeMedidaUnidadeAjaxCommand());

		// COMANDOS DE UNIDADE DE MEDIDA CASEIRA
		comandos.put("buscaUnidadeMedidaCaseiraNomeAjax", new BuscaUnidadeMedidaCaseiraNomeAjaxCommand());

		// COMANDOS DE EMPRESA

		comandos.put("buscaEmpresaLogoAjax", new BuscaEmpresaLogoAjaxCommand());
		
		// COMANDOS DE FICHA TÉCNICA SIMPLIFICADA
		comandos.put("addFichaSimplificadaAjaxCommand", new AddFichaSimplificadaAjaxCommand());
		comandos.put("editFichaSimplificadaAjaxCommand", new EditFichaSimplificadaAjaxCommand());
		
		//COMANDOS DE FICHA TÉCNICA COMPLETA
		comandos.put("addFichaCompletaAjaxCommand", new AddFichaCompletaAjaxCommand());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String json = "";

		try {
			logger.debug("acao: "+acao);
			Command comando = verificarComando(acao);
			json = comando.execute(request);
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSessao");
			if (usuario != null)
				logger.debug("User: " + usuario.getUsuario() + " - comando " + comando.toString() + " acao: " + acao);
		} catch (NegocioException | SQLException | ParseException | PersistenciaException e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		//LogParametrosSession.logParametros(request);
		reponse.setContentType("text/plain; charset=utf-8");
		reponse.setCharacterEncoding("UTF-8");
		reponse.getWriter().write(json);
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
package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.model.Empresa;
import br.ages.crud.util.MensagemContantes;

public class CreateScreenEmpresaCommand implements Command {

	private String proxima;

	private EmpresaBO empresaBO;
	
	//private StakeholderBO stakeholderBO;

	public String execute(HttpServletRequest request) throws SQLException {
		proxima = "main?acao=listEmpresa";
		Usuario currentUser = (Usuario)request.getSession().getAttribute("usuarioSessao");

		try {			
			if( !currentUser.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_DENY);
			// Verifica se abre tela edição de empresa ou de adição de empresa.
			
			String isEdit = request.getParameter("isEdit");
			
			if (isEdit != null && !"".equals(isEdit)) {
				
				empresaBO = new EmpresaBO();
				
				int id = Integer.parseInt(request.getParameter("idEmpresa"));
				Empresa empresa = empresaBO.buscaEmpresaId(id);
				
				
				request.setAttribute("empresa", empresa);
				proxima = "empresa/editEmpresa.jsp";
				
			} else { // Vai pra tela de empresa
				proxima = "empresa/addEmpresa.jsp";		
			}

		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}

		return proxima;
	}
}

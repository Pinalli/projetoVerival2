package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Empresa;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

public class RemoveEmpresaCommand implements Command {

	private String proximo;

	private EmpresaBO empresaBO;

	@Override
	public String execute(HttpServletRequest request) {
		proximo = "main?acao=listEmpresa";
		this.empresaBO = new EmpresaBO();		
		
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioSessao");
		
		try {
			if( !usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR) ) throw new NegocioException(MensagemContantes.MSG_INF_DENY);
			
			Integer idEmpresa = Integer.parseInt(request.getParameter("id_empresa"));
			empresaBO.removerEmpresa(idEmpresa);
			
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_EMPRESA.replace("?", idEmpresa.toString()).concat("<br/>"));
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		
		return proximo;
	}

}


package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.util.MensagemContantes;

public class EditUnidadeMedidaCommand implements Command{
	

	private String proxima;
	
	private UnidadeMedidaBO unidadeMedidaBO;
	


	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		unidadeMedidaBO =  new UnidadeMedidaBO();
		UnidadeMedida unidadeMedida;
		proxima = "unidadeMedida/editUnidadeMedida.jsp";
		
		int idUnidadeMedida = Integer.valueOf(request.getParameter("idUnidadeMedida"));
		String descricaoOrigem = request.getParameter("descricaoOrigem");
		String descricaoConversao = request.getParameter("descricaoConversao");
		String sigla = request.getParameter("sigla");
		int medidaConversao = Integer.valueOf(request.getParameter("medidaConversao"));
				
		try{			
		    unidadeMedida = new UnidadeMedida();
			unidadeMedida.setDescricaoOrigem(descricaoOrigem);
			unidadeMedida.setDescricaoConversao(descricaoConversao);
			unidadeMedida.setSigla(sigla);
			unidadeMedida.setMedidaConversao(medidaConversao);
			unidadeMedida.setIdUnidadeMedida(idUnidadeMedida);
			
			boolean isValido = unidadeMedidaBO.validaUnidadeMedida(unidadeMedida);
			
			if(isValido){
				unidadeMedidaBO.editaUnidadeMedida(unidadeMedida);
				proxima = "main?acao=listUnidadeMedida";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_EDICAO_UNIDADE_MEDIDA.replace("?", sigla));
			} else {				
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_EDICAO_UNIDADE_MEDIDA);
			}				
		} catch(Exception e){		
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	}

}


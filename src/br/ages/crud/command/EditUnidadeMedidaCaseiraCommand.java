
package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.MensagemContantes;

public class EditUnidadeMedidaCaseiraCommand implements Command{
	

	private String proxima;
	private UnidadeMedidaCaseiraBO unidadeMedidaCaseiraBO;
	
	/**
	 * 
	 * @author Iann Muller
	 *
	 */

	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		unidadeMedidaCaseiraBO =  new UnidadeMedidaCaseiraBO();
		UnidadeMedidaCaseira unidadeMedidaCaseira;
		proxima = "unidadeMedidaCaseira/editUnidadeMedidaCaseira.jsp";
		
		int idUnidadeMedidaCaseira = Integer.valueOf(request.getParameter("idUnidadeMedidaCaseira"));
		String nome = request.getParameter("nome");
		String sigla = request.getParameter("sigla");
						
		try{			
		    unidadeMedidaCaseira = new UnidadeMedidaCaseira();
			unidadeMedidaCaseira.setNome(nome);
			unidadeMedidaCaseira.setSigla(sigla);
			unidadeMedidaCaseira.setIdUnidadeMedidaCaseira(idUnidadeMedidaCaseira);
			
			
			boolean isValido = unidadeMedidaCaseiraBO.validaUnidadeMedidaCaseira(unidadeMedidaCaseira);
			
			if(isValido){
				unidadeMedidaCaseiraBO.editaUnidadeMedidaCaseira(unidadeMedidaCaseira);
				proxima = "main?acao=listUnidadeMedidaCaseira";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_EDICAO_UNIDADE_MEDIDA_CASEIRA.replace("?", sigla));
			} else {				
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_EDICAO_UNIDADE_MEDIDA_CASEIRA);
			}				
		} catch(Exception e){		
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	}

}


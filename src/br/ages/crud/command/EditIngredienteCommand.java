package br.ages.crud.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.dao.IngredienteDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.util.MensagemContantes;


public class EditIngredienteCommand implements Command{
	
	private String proxima;
	
	private IngredienteBO ingredienteBO;
	
	@Override
	public String execute(HttpServletRequest request) throws SQLException {
		ingredienteBO =  new IngredienteBO();
		Ingrediente ingrediente;
		proxima = "ingrediente/editaIngrediente.jsp";
		
		String codigo = request.getParameter("codigo");
		String descricao = request.getParameter("descricao");
		String carboidrato = request.getParameter("carboidrato");
		String proteinas = request.getParameter("proteinas");
		String lipidios = request.getParameter("lipidios");
		String fatorCorrecao = request.getParameter("fatorCorrecao"); 
		String indiceCoccao = request.getParameter("indiceCoccao");
		String custo = request.getParameter("custo");
		String unidadeMedida = request.getParameter("unidadeMedida");
		
		
		try{				
			
			ingrediente = new Ingrediente();
			ingrediente.setCodigo(Integer.valueOf(codigo));
			ingrediente.setDescricao(descricao);
			ingrediente.setCarboidratos(Double.valueOf(carboidrato));
			ingrediente.setProteinas(Double.valueOf(proteinas));
			ingrediente.setLipidios(Double.valueOf(lipidios));
			ingrediente.setFatorCorrecao(Double.valueOf(fatorCorrecao));
			ingrediente.setIndiceCoccao(Double.valueOf(indiceCoccao));
			ingrediente.setCusto(Double.valueOf(custo));
			ingrediente.setUnidadeMedida(unidadeMedida);		
			
			request.setAttribute("ingrediente", ingrediente);
			
		
				ingredienteBO.editaIngrediente(ingrediente);
				proxima = "main?acao=listIngrediente";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_EDICAO_USUARIO.replace("?", ingrediente.getDescricao()));				
		} catch(Exception e){		
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	}

}
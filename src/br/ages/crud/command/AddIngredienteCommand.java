package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.IngredienteBO;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.util.MensagemContantes;
import org.apache.log4j.Logger;
public class AddIngredienteCommand implements Command {
	private String proxima;
	private IngredienteBO ingredienteBO;
	@Override
	public String execute(HttpServletRequest request) {
		ingredienteBO = new IngredienteBO();
		proxima = "main?acao=telaIngredientes";
		String codigo = request.getParameter("cod");
		String descricao = request.getParameter("descricao");
		String carboidrato = request.getParameter("carboidratos");
		String kcalCarboidrato = request.getParameter("kcalcarboidratos");
		String proteinas = request.getParameter("proteinas");
		String kcalProteinas = request.getParameter("kcalproteinas");
		String lipidios = request.getParameter("lipidios");
		String kcalLipidios = request.getParameter("kcallipidios");
		String gorduraSaturada = request.getParameter("gordurasaturada");
		String fibrasAlimentares = request.getParameter("fibrasalimentares");
		String sodio = request.getParameter("sodio");
		/*String fatorCorrecao = request.getParameter("fatorcorrecao").replace(",", ".");
		String indiceCoccao = request.getParameter("indicecoccao").replace(",", ".");*/
		//não há custo no cadastro de ingrediente
		String custo = request.getParameter("custo").replace(",", ".");
		String unidadeMedida = request.getParameter("unidadeMedida");
		try {
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setCodigo(Integer.valueOf(codigo));
			ingrediente.setDescricao(descricao);
			ingrediente.setCarboidratos(Double.valueOf(carboidrato));
			ingrediente.setKcalCarboidratos(Double.valueOf(kcalCarboidrato));
			ingrediente.setProteinas(Double.valueOf(proteinas));
			ingrediente.setKcalProteinas(Double.valueOf(kcalProteinas));
			ingrediente.setLipidios(Double.valueOf(lipidios));
			ingrediente.setKcalLipidios(Double.valueOf(kcalLipidios));
			ingrediente.setGorduraSaturada(Double.valueOf(gorduraSaturada));
			ingrediente.setFibrasAlimentares(Double.valueOf(fibrasAlimentares));
			ingrediente.setSodio(Double.valueOf(sodio));
			/*ingrediente.setFatorCorrecao(Double.valueOf(fatorCorrecao));
			ingrediente.setIndiceCoccao(Double.valueOf(indiceCoccao));*/
			ingrediente.setCusto(Double.valueOf(custo));
			ingrediente.setUnidadeMedida(unidadeMedida);	
			ingredienteBO.cadastraIngrediente(ingrediente);
			proxima = "main?acao=listIngrediente";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_INGREDIENTE.replace("?", ingrediente.getDescricao()));
				
		} catch (NumberFormatException e) {
			request.setAttribute("msgErro", "Múltiplos separadores decimais! Verifique!");
		}catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
		}
		return proxima;
	}
}

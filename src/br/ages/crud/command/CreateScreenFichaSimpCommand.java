package br.ages.crud.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.MensagemContantes;

public class CreateScreenFichaSimpCommand implements Command {


	private String proxima;
	
	private FichaSimplificadaBO fichaSimplificadaBO;

	@Override
	public String execute(HttpServletRequest request)  {
		fichaSimplificadaBO = new FichaSimplificadaBO();
		proxima =  "main?acao=telaFichaSimplificada";
		
		String nome = request.getParameter("nome");
		String rendimento = request.getParameter("rendimento");
		String modoPreparo = request.getParameter("modoPreparo");
		String montagem = request.getParameter("montagem");
		String orientacoesArmazenamento = request.getParameter("orientacoesArmazenamento");
	List<FichaItem> itensTela =  new ArrayList<>();
		
		
		try{
			Ficha fichaSimplificada = new Ficha();
			fichaSimplificada.setNome(nome);
			fichaSimplificada.setRendimento(rendimento);
			fichaSimplificada.setModoPreparo(modoPreparo);
			fichaSimplificada.setOrientacoesArmazenamento(orientacoesArmazenamento);
			fichaSimplificada.setMontagem(montagem);
			
				
			for (FichaItem fichaItemTela : itensTela) {
			
				FichaItem item = new FichaItem();
				
				item.setIdFichaItem(fichaItemTela.getIdFichaItem());
				item.setIdUnidadeMedida(fichaItemTela.getIdUnidadeMedida());
				item.setIdMedidaCaseira(fichaItemTela.getIdMedidaCaseira());
				item.setIdFicha(fichaItemTela.getIdFicha());
				item.setQuantidadeUnidadeMedida(fichaItemTela.getQuantidadeUnidadeMedida());
				item.setQuantidadeMedidaCaseira(fichaItemTela.getQuantidadeMedidaCaseira());
				
			}
			
			
			  boolean isValido = fichaSimplificadaBO.validarFichaSimplificada(fichaSimplificada);
			  if(isValido == false){
			  	request.setAttribute("msgErro", MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_DADOS_INVALIDOS);
			  }else{ // cadastro ficha tecnica simplificada
			  	fichaSimplificadaBO.cadastrarFichaSimplificada(fichaSimplificada);
			  	proxima = "main?acao=listFichaSimplificada";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_FICHA_SIMPLIFICADA.replace("?", fichaSimplificada.getNome()));
			  }
			
			fichaSimplificadaBO.cadastrarFichaSimplificada(fichaSimplificada);
			proxima = "main?acao=listFichaSimplificada";
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_FICHA_SIMPLIFICADA.replace("?", fichaSimplificada.getNome()));

		}catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			proxima = "main?acao=telaFichaTecnicaSimplificada";
		}
		
		return proxima;
	}

}

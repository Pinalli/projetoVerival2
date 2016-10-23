package br.ages.crud.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.MensagemContantes;

public class AddFichaSimplificadaAjaxCommand implements Command {


	private String proxima;

	private FichaSimplificadaBO fichaSimplificadaBO;

	@Override
	public String execute(HttpServletRequest request) {
		fichaSimplificadaBO = new FichaSimplificadaBO();
		String json = "";

		try {
			String jsonItens = request.getParameter("itens");
			//return jsonItens;
			
			Gson gson = new Gson();
			FichaItem[] itens = gson.fromJson(jsonItens, FichaItem[].class);
			List<FichaItem> listaFichaItens = new ArrayList<FichaItem>();
			for(int i=0; i<itens.length; i++){
				listaFichaItens.add(itens[i]);
			}
			
			Ficha ficha = new Ficha();
			ficha.setNome(request.getParameter("nome"));
			ficha.setRendimento(request.getParameter("rendimento"));
			ficha.setFoto(request.getParameter("foto"));
			ficha.setModoPreparo(request.getParameter("modoPreparo"));
			ficha.setMontagem(request.getParameter("montagem"));
			ficha.setOrientacoesArmazenamento(request.getParameter("orientacoesArmazenamento"));
			ficha.setIdEmpresa(1);
			ficha.setTipoFicha("s");
			ficha.setItens(listaFichaItens);
			
			fichaSimplificadaBO.cadastrarFichaSimplificada(ficha);
			request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_FICHA_SIMPLIFICADA.replace("?", ficha.getNome()));
			json = ficha.getOrientacoesArmazenamento();
			
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			proxima = "main?acao=telaFichaSimplificada";
		}

		return json;
	}
}
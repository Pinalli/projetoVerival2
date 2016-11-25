package br.ages.crud.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.bo.FichaSimplificadaItemBO;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.MensagemContantes;

public class EditFichaSimplificadaAjaxCommand implements Command {

	Logger logger = Logger.getLogger("EditFichaSimplificadaAjaxCommand");
	Gson gson = new Gson();	
	private String proxima;

	private FichaSimplificadaBO fichaSimplificadaBO;
	private FichaSimplificadaItemBO itemBO;


	@Override
	public String execute(HttpServletRequest request) {
		fichaSimplificadaBO = new FichaSimplificadaBO();
		itemBO = new FichaSimplificadaItemBO();
		String json = "";
		Map<String,String> msg = new HashMap<String, String>();

		try {
			String jsonItens = request.getParameter("itens");

			FichaItem[] itens = gson.fromJson(jsonItens, FichaItem[].class);
			
			List<FichaItem> listaFichaItens = new ArrayList<FichaItem>();
			for(int i=0; i<itens.length; i++){
				listaFichaItens.add(itens[i]);
			}
			
			Ficha ficha = new Ficha();
			int id = Integer.parseInt(request.getParameter("id"));
			ficha.setIdFicha(id);
			ficha.setNome(request.getParameter("nome"));
			ficha.setRendimento(request.getParameter("rendimento"));
			ficha.setFoto(request.getParameter("foto"));
			ficha.setModoPreparo(request.getParameter("modoPreparo"));
			ficha.setMontagem(request.getParameter("montagem"));
			ficha.setOrientacoesArmazenamento(request.getParameter("orientacoesArmazenamento"));
			ficha.setIdEmpresa(1);
			ficha.setTipoFicha("s");
			ficha.setItens(listaFichaItens);
			
			if(fichaSimplificadaBO.validarFichaSimplificada(ficha)){
				fichaSimplificadaBO.editarFichaSimplificada(ficha);
				for(FichaItem item: listaFichaItens ){
					if(item.getOperacao().equals("c")){
						itemBO.cadastrarFichaSimplificada(item);
					}else if (item.getOperacao().equals("u")){
						itemBO.editarFichaSimplificadaItem(item);
					}else if(item.getOperacao().equals("d")){
						itemBO.removerFichaTecnicaItem(item.getIdFichaItem());
					}
				}
				msg.put("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_FICHA_SIMPLIFICADA.replace("?", ficha.getNome()));
			    msg.put("dados", "");
			    msg.put("proxima", "main?acao=listFichaSimplificada");
			    json = gson.toJson(msg);
			}else{
				msg.put("msgErro", MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_DADOS_INVALIDOS);
			    msg.put("erro", MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_DADOS_INVALIDOS);
			    msg.put("proxima", "main?acao=telaFichaSimplificada");
			    json = gson.toJson(msg);
			}
			return json;
		} catch (Exception e) {
		    msg.put("msgErro", MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_DADOS_INVALIDOS);
		    msg.put("erro", e.getMessage());
		    msg.put("proxima", "main?acao=telaFichaSimplificada");
			json = gson.toJson(msg);
			return json;
		}
	}
}
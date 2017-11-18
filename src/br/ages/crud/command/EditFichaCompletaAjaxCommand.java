package br.ages.crud.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import br.ages.crud.bo.FichaCompletaBO;
import br.ages.crud.bo.FichaCompletaItemBO;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.MensagemContantes;

public class EditFichaCompletaAjaxCommand implements Command {

	Logger logger = Logger.getLogger("EditFichaCompletaAjaxCommand");
	Gson gson = new Gson();	
	private String proxima;

	private FichaCompletaBO fichaCompletaBO;
	private FichaCompletaItemBO itemBO;
	private UnidadeMedidaCaseiraBO medidaCaseiraBO;
	private UnidadeMedidaBO unidadeMedidaBO;


	@Override
	public String execute(HttpServletRequest request) {
		fichaCompletaBO = new FichaCompletaBO();
		itemBO = new FichaCompletaItemBO();
		unidadeMedidaBO = new UnidadeMedidaBO();
		medidaCaseiraBO = new UnidadeMedidaCaseiraBO();
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
			ficha.setTextura(request.getParameter("textura"));
			ficha.setSabor(request.getParameter("sabor"));
			ficha.setApresentacao(request.getParameter("apresentacao"));
			ficha.setTempoPreparo(request.getParameter("tempoPreparo"));
			ficha.setUtensilios(request.getParameter("utensiliosEquipamentos"));
			ficha.setTemperatura(Double.parseDouble(request.getParameter("temperatura")));
			ficha.setIdEmpresa(1);
			ficha.setTipoFicha("c");
			ficha.setItens(listaFichaItens);
			ficha.setMedida(unidadeMedidaBO.buscaUnidadeMedidaId(Integer.parseInt(request.getParameter("unidadeMedidaId"))));
			ficha.setMedidaCaseira(medidaCaseiraBO.buscaUnidadeMedidaCaseiraId(Integer.parseInt(request.getParameter("unidadeMedidaCaseiraId"))));
			
			if(fichaCompletaBO.validarFichaCompleta(ficha)){
				fichaCompletaBO.editarFichaCompleta(ficha);
				for(FichaItem item: listaFichaItens ){
					if(item.getOperacao().equals("c")){
						itemBO.cadastrarFichaCompleta(item);
					}else if (item.getOperacao().equals("u")){
						itemBO.editarFichaCompletaItem(item);
					}else if(item.getOperacao().equals("d")){
						itemBO.removerFichaTecnicaItem(item.getIdFichaItem());
					}
				}
				msg.put("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_FICHA_COMPLETA.replace("?", ficha.getNome()));
			    msg.put("dados", "");
			    msg.put("proxima", "main?acao=listFichaCompleta");
			    json = gson.toJson(msg);
			}else{
				msg.put("msgErro", MensagemContantes.MSG_ERR_FICHA_COMPLETA_DADOS_INVALIDOS);
			    msg.put("erro", MensagemContantes.MSG_ERR_FICHA_COMPLETA_DADOS_INVALIDOS);
			    msg.put("proxima", "main?acao=telaFichaCompleta");
			    json = gson.toJson(msg);
			}
			return json;
		} catch (Exception e) {
		    msg.put("msgErro", MensagemContantes.MSG_ERR_FICHA_COMPLETA_DADOS_INVALIDOS);
		    msg.put("erro", e.getMessage());
		    msg.put("proxima", "main?acao=telaFichaCompleta");
			json = gson.toJson(msg);
			return json;
		}
	}
}
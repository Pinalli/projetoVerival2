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
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.MensagemContantes;

public class AddFichaCompletaAjaxCommand implements Command {

	Logger logger = Logger.getLogger("AddFichaCompletaAjaxCommand");
	Gson gson = new Gson();	
	private String proxima;

	private FichaCompletaBO fichaCompletaBO;
	private FichaCompletaItemBO itemBO;

	@Override
	public String execute(HttpServletRequest request) {
		fichaCompletaBO = new FichaCompletaBO();
		itemBO = new FichaCompletaItemBO();
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
			ficha.setNome(request.getParameter("nome"));
			ficha.setRendimento(request.getParameter("rendimento"));
			ficha.setFoto(request.getParameter("foto"));
			ficha.setModoPreparo(request.getParameter("modoPreparo"));
			ficha.setMontagem(request.getParameter("montagem"));
			ficha.setOrientacoesArmazenamento(request.getParameter("orientacoesArmazenamento"));
			ficha.setTextura(request.getParameter("textura"));
			ficha.setSabor(request.getParameter("sabor"));
			ficha.setApresentacao(request.getParameter("apresentacao"));
			ficha.setCategoria(Ficha.Categoria.valueOf(request.getParameter("categoria")));
			
			ficha.setTempoPreparo(request.getParameter("tempoPreparo"));
			ficha.setUtensilios(request.getParameter("utensiliosEquipamentos"));
			ficha.setTemperatura(Double.parseDouble(request.getParameter("temperatura")));
			
			ficha.setIdEmpresa(1);
			ficha.setTipoFicha("c");
			ficha.setItens(listaFichaItens);
			
			String qntUMRaw = request.getParameter("qntUnidadeMedida");
			if(qntUMRaw != null) {
				ficha.setQntMedida(Double.valueOf(qntUMRaw));
			}
			
			UnidadeMedida um = new UnidadeMedida();
			String idUMRaw = request.getParameter("unidadeMedidaId");
			if(idUMRaw != null) {
				um.setIdUnidadeMedida(Integer.valueOf(idUMRaw));
			}
			
			String qntUMCRaw = request.getParameter("qntUnidadeMedidaCaseira");
			if(qntUMCRaw != null) {
				ficha.setQntMedidaCaseira(Double.valueOf(qntUMCRaw));
			}
			
			UnidadeMedidaCaseira umc = new UnidadeMedidaCaseira();
			String idUMCRaw = request.getParameter("unidadeMedidaCaseiraId");
			if(idUMCRaw != null) {
				umc.setIdUnidadeMedidaCaseira(Integer.valueOf(idUMCRaw));
			}
			
			ficha.setMedida(um);
			ficha.setMedidaCaseira(umc);
			
			if(fichaCompletaBO.validarFichaCompleta(ficha)){
				int id = fichaCompletaBO.cadastrarFichaCompleta(ficha);				
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_FICHA_COMPLETA.replace("?", ficha.getNome()));
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
			e.printStackTrace();
		    msg.put("msgErro", MensagemContantes.MSG_ERR_FICHA_COMPLETA_DADOS_INVALIDOS);
		    msg.put("erro", e.getMessage());
		    msg.put("proxima", "main?acao=telaFichaCompleta");
			json = gson.toJson(msg);
			return json;
		}
	}
}
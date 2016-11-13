package br.ages.crud.command;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.FichaSimplificadaBO;
import br.ages.crud.model.Ficha;
import br.ages.crud.util.MensagemContantes;

public class AddFichaSimplificadaCommand implements Command {


	private String proxima;

	private FichaSimplificadaBO fichaSimplificadaBO;

	@Override
	public String execute(HttpServletRequest request) {
		fichaSimplificadaBO = new FichaSimplificadaBO();
		proxima = "main?acao=telaFichaSimplificada";
		
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName);
            
            String[] paramValues = request.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                System.out.println(paramValue);        	
            }
        }

		try {
			Ficha fichaSimplificada = new Ficha(); 
			
			boolean isValido = true;//usuarioBO.validaUsuario(user);
			if (isValido == false) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_USUARIO_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso
				//fichaSimplificadaBO.cadastrarFichaSimplificada(fichaSimplificada);
				proxima = "main?acao=listFichaSimplificada";
				//request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_USUARIO.replace("?", user.getNome()));
			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			proxima = "main?acao=telaFichaSimplificada";
		}

		return proxima;
	}
}

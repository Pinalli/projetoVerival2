package br.ages.crud.command;
import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.MensagemContantes;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class AddUnidadeMedidaCaseiraCommand implements Command {
	private String proxima;
	private UnidadeMedidaCaseiraBO unidadeMedidaCaseiraBO;
    @Override
    public String execute(HttpServletRequest request) throws SQLException, NegocioException, ParseException, PersistenciaException {
		unidadeMedidaCaseiraBO = new UnidadeMedidaCaseiraBO();
		proxima = "main?acao=telaUnidadeMedidaCaseira";
		String nome = request.getParameter("nome");
		String sigla = request.getParameter("sigla");
		
		try {
			UnidadeMedidaCaseira unidadeMedidaCaseira = new UnidadeMedidaCaseira();
			unidadeMedidaCaseira.setNome(nome);
			unidadeMedidaCaseira.setSigla(sigla);
			
			boolean isValido = unidadeMedidaCaseiraBO.validaUnidadeMedidaCaseira(unidadeMedidaCaseira);
			if (isValido == false) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_UNIDADE_MEDIDA_CASEIRA_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso
				unidadeMedidaCaseiraBO.cadastrarUnidadeMedidaCaseira(unidadeMedidaCaseira);
				proxima = "main?acao=listUnidadeMedidaCaseira";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_UNIDADE_MEDIDA_CASEIRA.replace("?", unidadeMedidaCaseira.getSigla()));
			}
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=addUser";
		}
		return proxima;
    }
}

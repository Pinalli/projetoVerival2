package br.ages.crud.command;

import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.bo.UnidadeMedidaBO;
import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.bo.UsuarioBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;

import javax.servlet.http.HttpServletRequest;

/**
 * <<<<<<< HEAD
 *
 * @author Homero Oliveira
 */


public class RemoveUnidadeMedidaCaseiraCommand implements Command {

    private String proximo;

    private UnidadeMedidaCaseiraBO unidadeMedidaCaseiraBO;

    @Override
    public String execute(HttpServletRequest request) {
        proximo = "main?acao=listUnidadeMedidaCaseira";
        this.unidadeMedidaCaseiraBO = new UnidadeMedidaCaseiraBO();

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSessao");

        try {
            if (!usuario.getPerfilAcesso().equals(PerfilAcesso.ADMINISTRADOR))
                throw new NegocioException(MensagemContantes.MSG_INF_SEM_PERISSAO);


            Integer idUnidadeMedidaCaseira = Integer.parseInt(request.getParameter("id_unidade_medida_caseira"));
            UnidadeMedidaCaseira unidadeExcluir = unidadeMedidaCaseiraBO.buscaUnidadeMedidaCaseiraId(idUnidadeMedidaCaseira);
            unidadeMedidaCaseiraBO.removerUnidadeMedidaCaseira(idUnidadeMedidaCaseira);

            request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_REMOVE_UNIDADE_MEDIDA_CASEIRA.replace("?", unidadeExcluir.getNome().toString()).concat("<br/>"));


        } catch (Exception e) {
            request.setAttribute("msgErro", e.getMessage());
        }

        return proximo;
    }


}

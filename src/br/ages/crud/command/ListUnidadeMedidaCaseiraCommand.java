package br.ages.crud.command;

import br.ages.crud.bo.UnidadeMedidaCaseiraBO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.UnidadeMedidaCaseira;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author Homero Oliveira
 */
public class ListUnidadeMedidaCaseiraCommand implements Command{

    private String proxima;
    private UnidadeMedidaCaseiraBO unidadeMedidaCaseiraBO;

    @Override
    public String execute(HttpServletRequest request)
            throws SQLException, NegocioException, ParseException, PersistenciaException {
        this.unidadeMedidaCaseiraBO = new UnidadeMedidaCaseiraBO();
        proxima = "unidadeMedidaCaseira/listUnidadeMedidaCaseira.jsp";

        try {
            List<UnidadeMedidaCaseira> listaUsuarios = unidadeMedidaCaseiraBO.listarUnidadesMedidaCaseira();
            request.setAttribute("listaUnidadeMedidaCaseira", listaUsuarios);
        } catch (NegocioException e) {
            e.printStackTrace();
            request.setAttribute("msgErro", e.getMessage());
        }

        return proxima;
    }
}

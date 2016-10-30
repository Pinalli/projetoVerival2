package br.ages.crud.bo;

import br.ages.crud.dao.FichaSimplificadaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.util.MensagemContantes;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * @author Alessandro
 */

public class FichaSimplificadaBO {

    private FichaSimplificadaDAO fichaSimplificadaDAO = null;

    public FichaSimplificadaBO() {
        fichaSimplificadaDAO = new FichaSimplificadaDAO();
    }

    public void cadastrarFichaSimplificada(Ficha fichaSimplificada) throws NegocioException, SQLException, ParseException {

        try {
            fichaSimplificadaDAO.cadastrarFichaSimplificada(fichaSimplificada);
        } catch (PersistenciaException e) {
            e.printStackTrace();
            throw new NegocioException(e);
        }
    }

    public boolean validarFichaSimplificada(Ficha fichaSimplificada) throws NegocioException {
        boolean isValido = true;
        StringBuilder msg = new StringBuilder();
        try {

            //Nome
            if (fichaSimplificada.getNome() == null || fichaSimplificada.getNome().equals("")) {
                isValido = false;
                msg.append(MensagemContantes.MSG_ERR_CAMPO_NOME_FICHA_OBRIGATORIO + "<br/>");
            }

            //Rendimento
            if (fichaSimplificada.getRendimento() == null || fichaSimplificada.getRendimento().equals("")) {
                isValido = false;
                msg.append(MensagemContantes.MSG_ERR_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO + "<br/>");
            }

            //Modo Preparo
            if (fichaSimplificada.getModoPreparo() == null || fichaSimplificada.getModoPreparo().equals("")) {
                isValido = false;
                msg.append(MensagemContantes.MSG_ERR_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO + "<br/>");
            }

            //Montagem
            if (fichaSimplificada.getMontagem() == null || fichaSimplificada.getMontagem().equals("")) {
                isValido = false;
                msg.append(MensagemContantes.MSG_ERR_CAMPO_MONTAGEM_FICHA_OBRIGATORIO + "<br/>");
            }

            //Orientação e armazenamento
            if (fichaSimplificada.getOrientacoesArmazenamento() == null || fichaSimplificada.getOrientacoesArmazenamento().equals("")) {
                isValido = false;
                msg.append(MensagemContantes.MSG_ERR_CAMPO_ORIENTACAO_ARMAZENAMENTO_FICHA_OBRIGATORIO + "<br/>");
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new NegocioException(e);

        }
        return isValido;
    }

    public List<Ficha> listarFichaSimplificada() throws NegocioException, PersistenciaException, SQLException {

        List<Ficha> listFichaSimplificada = null;

        try {
            listFichaSimplificada = fichaSimplificadaDAO.listarFichasSimplificada();
        } catch (PersistenciaException | SQLException e) {
            e.printStackTrace();
            throw new NegocioException(e);
        }
        return listFichaSimplificada;
    }


    //Editar
    public void editarFichaSimplificada(Ficha fichaSimplificada) throws NegocioException {

        try {
            fichaSimplificadaDAO.editarFichaSimplificada(fichaSimplificada);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NegocioException(e);
        }
    }

    //Remover
    public void removerFichaSimplificada(Integer idFicha) throws NegocioException, SQLException, PersistenciaException {
        try {
            fichaSimplificadaDAO.removerFichaSimplificada(idFicha);
        } catch (PersistenciaException e) {
            e.printStackTrace();
            throw new NegocioException(MensagemContantes.MSG_ERR_REMOVE_FICHA_EM_PROJETO);
        }
    }

    public Ficha buscaIdFicha(int id) throws PersistenciaException, SQLException {
        return fichaSimplificadaDAO.buscarIdFicha(id);
    }


    public int getProximoIdFicha() throws NegocioException, SQLException, PersistenciaException {
        try {
            return fichaSimplificadaDAO.getProximoIdFicha();
        } catch (PersistenciaException | SQLException e) {
            throw new NegocioException(e);
        }
    }
}

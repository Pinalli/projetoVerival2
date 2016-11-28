package br.ages.crud.dao;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.util.ConexaoUtil;
import com.mysql.jdbc.Statement;
import org.apache.commons.io.FilenameUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alessandro
 */

public class FichaSimplificadaDAO {

    private List<Ficha> listarFichasSimplificada;


    public int cadastrarFichaSimplificada(Ficha fichaSimplificada) throws SQLException, PersistenciaException {
        Connection conexao = null;

        try {
            Integer idFichaSimplificada = null;

            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_FICHA ("
                    + " NOME,"
                    + " RENDIMENTO,"
                    + " FOTO,"
                    + " MODO_PREPARO,"
                    + " MONTAGEM,"
                    + " ORIENTACOES_ARMAZENAMENTO,"
                    + " ID_EMPRESA,"
                    + " TIPO_FICHA)");
            sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, fichaSimplificada.getNome());
            statement.setString(2, fichaSimplificada.getRendimento());
            String logo = fichaSimplificada.getFoto();
            logo = "foto-ficha-" + this.getProximoIdFicha() + "." + FilenameUtils.getExtension(logo);
            statement.setString(3, logo);
            statement.setString(4, fichaSimplificada.getModoPreparo());
            statement.setString(5, fichaSimplificada.getMontagem());
            statement.setString(6, fichaSimplificada.getOrientacoesArmazenamento());
            statement.setInt(7, fichaSimplificada.getIdEmpresa());
            statement.setString(8, fichaSimplificada.getTipoFicha());

            statement.executeUpdate();

            ResultSet resultset = statement.getGeneratedKeys();
            if (resultset.first()) {
                idFichaSimplificada = resultset.getInt(1);
            }

            fichaSimplificada.setIdFicha(idFichaSimplificada);


            return idFichaSimplificada;

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e.getMessage());
            // throw new
            // PersistenciaException(MensagemContantes.MSG_ERR_FICHA_SIMPLIFICADA_JA_EXISTENTE.replace("?",
            // fichaSimplificada.getNome()));

        } finally {
            conexao.close();
        }
    }

    public List<Ficha> listarFichasSimplificada() throws PersistenciaException, SQLException {
        Connection conexao = null;
        listarFichasSimplificada = new ArrayList<>();
        try {

            conexao = ConexaoUtil.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append(
                    "SELECT ID_FICHA,"
                            + " NOME,"
                            + " RENDIMENTO,"
                            + " FOTO,"
                            + " MODO_PREPARO,"
                            + " MONTAGEM,"
                            + " ORIENTACOES_ARMAZENAMENTO,"
                            + " ID_EMPRESA,"
                            + "TIPO_FICHA FROM TB_FICHA WHERE TIPO_FICHA = 's' ");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                Ficha dto = new Ficha();
                dto.setIdFicha(resultset.getInt("ID_FICHA"));
                dto.setIdEmpresa(resultset.getInt("ID_EMPRESA"));
                dto.setNome(resultset.getString("NOME"));
                dto.setRendimento(resultset.getString("RENDIMENTO"));
                dto.setFoto(resultset.getString("FOTO"));
                dto.setModoPreparo(resultset.getString("MODO_PREPARO"));
                dto.setMontagem(resultset.getString("MONTAGEM"));
                dto.setOrientacoesArmazenamento(resultset.getString("ORIENTACOES_ARMAZENAMENTO"));
                dto.setTipoFicha(resultset.getString("TIPO_FICHA"));

                listarFichasSimplificada.add(dto);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);

        } finally {
            conexao.close();
        }
        return listarFichasSimplificada;
    }

    public boolean editarFichaSimplificada(Ficha fichaSimplificada) throws PersistenciaException, SQLException {
        boolean okei = false;
        Connection conexao = null;
        try {
            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            int idFichaSimplificada = fichaSimplificada.getIdFicha();

            sql.append(
                    "UPDATE TB_FICHA SET"
                            + " NOME = ?,"
                            + " RENDIMENTO = ?,"
                            + " FOTO = ?,"
                            + " MODO_PREPARO = ?,"
                            + " MONTAGEM = ?,"
                            + " ORIENTACOES_ARMAZENAMENTO = ?"
                            + " WHERE ID_FICHA = " + idFichaSimplificada
                            + " AND TIPO_FICHA = 's'");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setString(1, fichaSimplificada.getNome());
            statement.setString(2, fichaSimplificada.getRendimento());
            String logo = fichaSimplificada.getFoto();
            logo = "foto-ficha-" + idFichaSimplificada + "." + FilenameUtils.getExtension(logo);
            statement.setString(3, logo);
            statement.setString(4, fichaSimplificada.getModoPreparo());
            statement.setString(5, fichaSimplificada.getMontagem());
            statement.setString(6, fichaSimplificada.getOrientacoesArmazenamento());


            okei = statement.execute();

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);
        } finally {
            conexao.close();
        }
        return okei;
    }

    public boolean removerFichaSimplificada(Integer idFicha) throws PersistenciaException {
        boolean removidoOK = false;
        Connection conexao = null;

        try {

            conexao = ConexaoUtil.getConexao();

            // delete TB_FICHA
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM TB_FICHA WHERE ID_FICHA = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            statement.setInt(1, idFicha);
            statement.execute();

            removidoOK = true;

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);
        } finally {
            try {
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return removidoOK;
    }

    public Ficha buscarIdFicha(int id) throws PersistenciaException, SQLException {
        Connection conexao = null;
        try {
            conexao = ConexaoUtil.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ID_FICHA,"
                    + " NOME,"
                    + " RENDIMENTO,"
                    + " FOTO, MODO_PREPARO,"
                    + " MONTAGEM,"
                    + " ORIENTACOES_ARMAZENAMENTO,"
                    + " ID_EMPRESA,"
                    + " TIPO_FICHA FROM TB_FICHA WHERE TIPO_FICHA = 's' AND ID_FICHA = " + id);

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            ResultSet resultset = statement.executeQuery();
            Ficha dto = null;
            if (resultset.next()) {
                dto = new Ficha();
                dto.setIdFicha(resultset.getInt("ID_FICHA"));
                dto.setIdEmpresa(resultset.getInt("ID_EMPRESA"));
                dto.setNome(resultset.getString("NOME"));
                dto.setRendimento(resultset.getString("RENDIMENTO"));
                dto.setFoto(resultset.getString("FOTO"));
                dto.setModoPreparo(resultset.getString("MODO_PREPARO"));
                dto.setMontagem(resultset.getString("MONTAGEM"));
                dto.setOrientacoesArmazenamento(resultset.getString("ORIENTACOES_ARMAZENAMENTO"));
                //dto.setTipoFicha(resultset.getString("TIPO_FICHA"));
            }

            return dto;

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);

        } finally {
            conexao.close();
        }

    }

    public int getProximoIdFicha() throws PersistenciaException, SQLException {

        int idRetorno = 0;
        Connection conexao = null;
        try {
            conexao = ConexaoUtil.getConexao();
            String table = "TB_FICHA";
            StringBuilder sql = new StringBuilder();
            sql.append("SHOW TABLE STATUS LIKE '" + table + "'");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                idRetorno = Integer.valueOf(resultset.getString("AUTO_INCREMENT"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);
        } finally {
            try {
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return idRetorno;
    }

}
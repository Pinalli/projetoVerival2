package br.ages.crud.dao;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.util.ConexaoUtil;
import br.ages.crud.util.MensagemContantes;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alessandro
 */

public class FichaCompletaDAO {

    private List<Ficha> listarFichasCompleta;


    public int cadastrarFichaCompleta(Ficha fichaCompleta) throws SQLException, PersistenciaException {
        Connection conexao = null;

        try {
            Integer idFichaCompleta = null;

            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_FICHA (NOME, RENDIMENTO, FOTO, MODO_PREPARO, MONTAGEM, ORIENTACOES_ARMAZENAMENTO, ID_EMPRESA,TIPO_FICHA)");
            sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, fichaCompleta.getNome());
            statement.setString(2, fichaCompleta.getRendimento());
            statement.setString(3, fichaCompleta.getFoto());
            statement.setString(4, fichaCompleta.getModoPreparo());
            statement.setString(5, fichaCompleta.getMontagem());
            statement.setString(6, fichaCompleta.getOrientacoesArmazenamento());
            statement.setInt(7, fichaCompleta.getIdEmpresa());
            statement.setString(8, fichaCompleta.getTipoFicha());

            statement.executeUpdate();

            ResultSet resultset = statement.getGeneratedKeys();
            if (resultset.first()) {
                idFichaCompleta = resultset.getInt(1);
            }

            fichaCompleta.setIdFicha(idFichaCompleta);

            StringBuilder sql2 = new StringBuilder();
            for (FichaItem fichaItem : fichaCompleta.getItens()) {
                sql2.append("INSERT INTO TB_FICHA_ITEM (ID_UNIDADE_MEDIDA, ID_MEDIDA_CASEIRA, ID_INGREDIENTE, ID_FICHA, QUANTIDADE_UNIDADE_MEDIDA,QUANTIDADE_MEDIDA_CASEIRA )");
                sql2.append("VALUES (?, ?, ?, ?, ?, ?)");

                PreparedStatement statement2 = conexao.prepareStatement(sql2.toString(), Statement.RETURN_GENERATED_KEYS);

                statement2.setInt(1, fichaItem.getIdUnidadeMedida());
                statement2.setInt(2, fichaItem.getIdMedidaCaseira());
                statement2.setInt(3, fichaItem.getIdIngrediente());
                statement2.setInt(4, idFichaCompleta);
                statement2.setInt(5, fichaItem.getQuantidadeUnidadeMedida());
                statement2.setInt(6, fichaItem.getQuantidadeMedidaCaseira());

                statement2.executeUpdate();

                ResultSet resultset2 = statement2.getGeneratedKeys();
                int idFichaItem = 0;
                if (resultset2.first()) {
                    idFichaItem = resultset2.getInt(1);
                }
                fichaItem.setIdFicha(idFichaItem);
            }
            return idFichaCompleta;

        } catch (ClassNotFoundException | SQLException e) {
        	throw new PersistenciaException(e.getMessage());
            //throw new PersistenciaException(MensagemContantes.MSG_ERR_FICHA_Completa_JA_EXISTENTE.replace("?", fichaCompleta.getNome()));

        } finally {
            conexao.close();
        }
    }

    public List<Ficha> listarFichasCompleta() throws PersistenciaException, SQLException {
        Connection conexao = null;
        listarFichasCompleta = new ArrayList<>();
        try {

            conexao = ConexaoUtil.getConexao();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ID_FICHA, NOME, RENDIMENTO, FOTO, MODO_PREPARO, MONTAGEM, ORIENTACOES_ARMAZENAMENTO, ID_EMPRESA,TIPO_FICHA FROM TB_FICHA WHERE TIPO_FICHA = 's' ");

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

                listarFichasCompleta.add(dto);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);

        } finally {
            conexao.close();
        }
        return listarFichasCompleta;
    }

    public boolean editarFichaCompleta(Ficha fichaCompleta) throws PersistenciaException {
        boolean okei = false;
        Connection conexao = null;
        try {
            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            int id = fichaCompleta.getIdFicha();

            sql.append(
                    "UPDATE TB_FICHA_Completa SET NOME = ?, RENDIMENTO = ?, FOTO = ?, MODO_PREPARO = ?, MONTAGEM = ?, ORIENTACOES_ARMAZENAMENTO = ?, TIPO_FICHA = ? WHERE ID_USUARIO = "
                            + id + ";");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);
        } finally {
            try {
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return okei;
    }

    public boolean removerFichaCompleta(Integer idFicha) throws PersistenciaException {
        boolean removidoOK = false;
        Connection conexao = null;

        try {

            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();

            //delete TB_FICHA_ITEM
            sql.append("DELETE FROM TB_FICHA_ITEM WHERE ID_FICHA = ?");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            statement.setInt(1, idFicha);
            statement.execute();
            
            //delete TB_FICHA
            StringBuilder sql2 = new StringBuilder();
            sql2.append("DELETE FROM TB_FICHA WHERE ID_FICHA = ? AND  TIPO_FICHA = 's' ");
            PreparedStatement statement2 = conexao.prepareStatement(sql2.toString());

            statement2.setInt(1, idFicha);
            statement2.execute();
            
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
}
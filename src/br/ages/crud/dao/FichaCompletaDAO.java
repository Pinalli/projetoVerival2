package br.ages.crud.dao;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaItem;
import br.ages.crud.model.Ingrediente;
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

public class FichaCompletaDAO {

    private List<Ficha> listarFichasCompleta;
    private List<Ingrediente> dadosRotulo;
    private FichaCompletaItemDAO itemDAO;


    public int cadastrarFichaCompleta(Ficha fichaCompleta) throws SQLException, PersistenciaException {
        Connection conexao = null;

        try {
            Integer idFichaCompleta = null;

            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO TB_FICHA ("
            		+ "ID_EMPRESA,"
            		+ "NOME, "
            		+ "RENDIMENTO, "
            		+ "FOTO, "
            		+ "MODO_PREPARO, "
            		+ "MONTAGEM, "
            		+ "ORIENTACOES_ARMAZENAMENTO, "
            		+ "TIPO_FICHA,"
            		+ "TEXTURA,"
            		+ "SABOR,"
            		+ "APRESENTACAO )");
            sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            PreparedStatement statement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, fichaCompleta.getIdEmpresa());
            statement.setString(2, fichaCompleta.getNome());
            statement.setString(3, fichaCompleta.getRendimento());
            String logo = fichaCompleta.getFoto();
            logo = "foto-ficha-" + this.getProximoIdFicha() + "." + FilenameUtils.getExtension(logo);
            statement.setString(4, logo);
            statement.setString(5, fichaCompleta.getModoPreparo());
            statement.setString(6, fichaCompleta.getMontagem());
            statement.setString(7, fichaCompleta.getOrientacoesArmazenamento());
            statement.setString(8, fichaCompleta.getTipoFicha());
            statement.setString(9, fichaCompleta.getTextura());
    		statement.setString(10,fichaCompleta.getSabor());
			statement.setString(11,fichaCompleta.getApresentacao());

            statement.executeUpdate();

            ResultSet resultset = statement.getGeneratedKeys();
            if (resultset.first()) {
                idFichaCompleta = resultset.getInt(1);
            }

            fichaCompleta.setIdFicha(idFichaCompleta);
			List<FichaItem> itens = fichaCompleta.getItens();
			
			itemDAO = new FichaCompletaItemDAO();
			for (int i = 0; i < itens.size(); i++) {
				FichaItem item = itens.get(i);
				item.setIdFicha(idFichaCompleta);
				itemDAO.cadastrarFichaCompletaDAO(item);
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
            sql.append("SELECT ID_FICHA, "
            		+ "NOME, "
            		+ "RENDIMENTO, "
            		+ "FOTO, "
            		+ "MODO_PREPARO, "
            		+ "MONTAGEM, "
            		+ "ORIENTACOES_ARMAZENAMENTO, "
            		+ "ID_EMPRESA, "
            		+ "TIPO_FICHA, "
            		+ "TEXTURA, "
            		+ "SABOR, "
            		+ "APRESENTACAO FROM TB_FICHA WHERE TIPO_FICHA = 'c' ");

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
                dto.setTextura(resultset.getString("TEXTURA"));
                dto.setSabor(resultset.getString("SABOR"));
                dto.setApresentacao(resultset.getString("APRESENTACAO"));

                listarFichasCompleta.add(dto);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new PersistenciaException(e);

        } finally {
            conexao.close();
        }
        return listarFichasCompleta;
    }

    public List<Ingrediente> buscarDadosRotulo(int id) throws PersistenciaException, SQLException, ClassNotFoundException {
        Connection conn = null;
        dadosRotulo = new ArrayList<>();
        try {

            conn = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append("select descricao, carboidratos, kcal_carboidratos, proteinas, kcal_proteinas, " +
                    "lipidios, kcal_lipidios, gordura_saturada, gordura_trans, fibras_alimentares, sodio " +
                    "from ((tb_ficha inner join tb_ficha_item on tb_ficha_item.id_ficha = tb_ficha.id_ficha) " +
                    "inner join tb_ingredientes on tb_ingredientes.id = tb_ficha_item.id_ingrediente) " +
                    "where tb_ficha.id_ficha=" + id
            );
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                Ingrediente e = new Ingrediente();
                e.setDescricao(resultset.getString("descricao"));
                e.setCarboidratos(resultset.getDouble("carboidratos"));
                e.setKcalCarboidratos(resultset.getDouble("kcal_carboidratos"));
                e.setProteinas(resultset.getDouble("proteinas"));

                dadosRotulo.add(e);
            }

        } catch (ClassCastException | SQLException e){
            throw new PersistenciaException(e);
        } finally {
            conn.close();
        }
        return dadosRotulo;
    }

    public boolean editarFichaCompleta(Ficha fichaCompleta) throws PersistenciaException {
        boolean okei = false;
        Connection conexao = null;
        try {
            conexao = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            int idFichaCompleta = fichaCompleta.getIdFicha();

            sql.append(
                    "UPDATE TB_FICHA SET "
                    + "NOME = ?, "
                    + "RENDIMENTO = ?, "
                    + "FOTO = ?, "
                    + "MODO_PREPARO = ?, "
                    + "MONTAGEM = ?, "
                    + "ORIENTACOES_ARMAZENAMENTO = ?, "
                    + "TEXTURA = ?,"
                    + "SABOR = ?,"
                    + "APRESENTACAO = ?"
                    + " WHERE ID_FICHA = "+ idFichaCompleta 
                    + " AND TIPO_FICHA = 'c'");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setString(1, fichaCompleta.getNome());
            statement.setString(2, fichaCompleta.getRendimento());
            String logo = fichaCompleta.getFoto();
            logo = "foto-ficha-" + idFichaCompleta + "." + FilenameUtils.getExtension(logo);
            statement.setString(3, logo);
            statement.setString(4, fichaCompleta.getModoPreparo());
            statement.setString(5, fichaCompleta.getMontagem());
            statement.setString(6, fichaCompleta.getOrientacoesArmazenamento());
            statement.setString(7, fichaCompleta.getTextura());
            statement.setString(8, fichaCompleta.getSabor());
            statement.setString(9, fichaCompleta.getApresentacao());
            
			List<FichaItem> itens = fichaCompleta.getItens();

			FichaCompletaItemDAO itemDAO = new FichaCompletaItemDAO();
			for (int i = 0; i < itens.size(); i++) {
				FichaItem item = itens.get(i);
				item.setIdFicha(idFichaCompleta);
				if (item.getOperacao().equals("i")) {
					itemDAO.cadastrarFichaCompletaDAO(item);
				} else {
					itemDAO.editarFichaCompletaItem(item);
				}
			}

			okei = statement.execute();
            
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
            sql2.append("DELETE FROM TB_FICHA WHERE ID_FICHA = ?");
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
    
    public Ficha buscarIdFicha(int id) throws PersistenciaException, SQLException {
		Connection conexao = null;
		try {
			conexao = ConexaoUtil.getConexao();
			itemDAO = new FichaCompletaItemDAO();

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ID_FICHA,"
					+ " NOME,"
					+ " RENDIMENTO,"
					+ " FOTO, MODO_PREPARO,"
					+ " MONTAGEM,"
					+ " ORIENTACOES_ARMAZENAMENTO,"
					+ " ID_EMPRESA,"
					+  "TEXTURA,"
					+  "SABOR,"
					+  "APRESENTACAO,"
					+ " TIPO_FICHA FROM TB_FICHA WHERE TIPO_FICHA = 'c' AND ID_FICHA = "+id);
			
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
				dto.setTextura(resultset.getString("TEXTURA"));
				dto.setSabor(resultset.getString("SABOR"));
				dto.setApresentacao(resultset.getString("APRESENTACAO"));
				//dto.setTipoFicha(resultset.getString("TIPO_FICHA"));
			}		
			
			List<FichaItem> itens = itemDAO.listaFichaCompletaItem(id);
			dto.setItens(itens);
			
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
			              sql.append("SHOW TABLE STATUS LIKE '"+table+"'");
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
package br.ages.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import com.mysql.jdbc.Statement;

import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.model.FichaIngrediente;
import br.ages.crud.model.FichaItem;
import br.ages.crud.model.Ingrediente;
import br.ages.crud.model.UnidadeMedida;
import br.ages.crud.model.UnidadeMedidaCaseira;
import br.ages.crud.util.ConexaoUtil;

/**
 * @author Alessandro
 */

public class FichaCompletaDAO {

    private List<Ficha> listarFichasCompleta;
    private List<FichaIngrediente> dadosRotulo;
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
            		+ "APRESENTACAO,"
            		+ "ROTULO_QNT_MEDIDA,"
            		+ "ROTULO_ID_MEDIDA,"
            		+ "ROTULO_QNT_MEDIDA_CASEIRA,"
            		+ "ROTULO_ID_MEDIDA_CASEIRA"
            		+ ")");
            sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
			statement.setDouble(12,fichaCompleta.getQntMedida());
			statement.setInt(13,fichaCompleta.getMedida().getIdUnidadeMedida());
			statement.setDouble(14,fichaCompleta.getQntMedidaCaseira());
			statement.setInt(15,fichaCompleta.getMedidaCaseira().getIdUnidadeMedidaCaseira());

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
        	e.printStackTrace();
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

    public List<FichaIngrediente> buscarDadosRotulo(int id) throws PersistenciaException, SQLException, ClassNotFoundException {
        Connection conn = null;
        dadosRotulo = new ArrayList<>();
        try {

            conn = ConexaoUtil.getConexao();
            StringBuilder sql = new StringBuilder();
            sql.append(
                    "select descricao, um.unidade_medida, um.fator_conversao, um.medida_conversao, quantidade_unidade_medida, umc.nome, " +
                            "quantidade_medida_caseira,\n" +
                    "carboidratos, kcal_carboidratos, proteinas, kcal_proteinas,\n" +
                    "lipidios, kcal_lipidios, gordura_saturada, gordura_trans, fibras_alimentares, sodio\n" +
                    "from \n" +
                    "tb_ficha f inner join tb_ficha_item fi on f.id_ficha = fi.id_ficha\n" +
                    "inner join tb_unidade_medida um\n" +
                    "on fi.id_unidade_medida = um.id_unidade_medida\n" +
                    "inner join tb_unidade_medida_caseira umc\n" +
                    "on fi.id_medida_caseira = umc.id_unidade_medida_caseira\n" +
                    "inner join tb_ingredientes i\n" +
                    "on fi.id_ingrediente = i.id\n" +
                    "where f.id_ficha =" + id
            );
            PreparedStatement statement = conn.prepareStatement(sql.toString());
            ResultSet resultset = statement.executeQuery();

            while (resultset.next()) {
                FichaIngrediente fi = new FichaIngrediente();

                Ingrediente i = new Ingrediente();
                UnidadeMedida um = new UnidadeMedida();
                UnidadeMedidaCaseira umc = new UnidadeMedidaCaseira();

                um.setUnidadeMedida(resultset.getString("um.unidade_medida"));
                um.setFatorConversao(resultset.getDouble("um.fator_conversao"));
                um.setMedidaConversao(resultset.getString("um.medida_conversao"));
                umc.setNome(resultset.getString("umc.nome"));

                i.setDescricao(resultset.getString("descricao"));
                i.setCarboidratos(resultset.getDouble("carboidratos"));
                i.setKcalCarboidratos(resultset.getDouble("kcal_carboidratos"));
                i.setProteinas(resultset.getDouble("proteinas"));
                i.setKcalProteinas(resultset.getDouble("kcal_proteinas"));
                i.setLipidios(resultset.getDouble("lipidios"));
                i.setKcalLipidios(resultset.getDouble("kcal_lipidios"));
                i.setGorduraSaturada(resultset.getDouble("gordura_saturada"));
                i.setGorduraTrans(resultset.getDouble("gordura_trans"));
                i.setFibrasAlimentares(resultset.getDouble("fibras_alimentares"));
                i.setSodio(resultset.getDouble("sodio"));

                fi.setQuantidadeMedida(resultset.getDouble("quantidade_unidade_medida"));
                fi.setQuantidadeMedidaCaseira(resultset.getDouble("quantidade_medida_caseira"));
                fi.setUnidadeMedida(um);
                fi.setUnidadeMedidaCaseira(umc);
                fi.setIngrediente(i);

                dadosRotulo.add(fi);
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
                    + "APRESENTACAO = ?,"
                    + "ROTULO_QNT_MEDIDA = ?,"
            		+ "ROTULO_ID_MEDIDA = ?,"
            		+ "ROTULO_QNT_MEDIDA_CASEIRA = ?,"
            		+ "ROTULO_ID_MEDIDA_CASEIRA = ?"
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
			statement.setDouble(10,fichaCompleta.getQntMedida());
			statement.setInt(11,fichaCompleta.getMedida().getIdUnidadeMedida());
			statement.setDouble(12,fichaCompleta.getQntMedidaCaseira());
			statement.setInt(13,fichaCompleta.getMedidaCaseira().getIdUnidadeMedidaCaseira());
            
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
        	e.printStackTrace();
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
			sql.append(
					"SELECT " +
					"F.ID_FICHA, " +
					"F.NOME, " +
					"F.RENDIMENTO, " +
					"F.FOTO, " +
					"F.MODO_PREPARO, " +
					"F.MONTAGEM, " +
					"F.ORIENTACOES_ARMAZENAMENTO, " +
					"F.ID_EMPRESA, " +
					"F.TEXTURA, " +
					"F.SABOR, " +
					"F.APRESENTACAO, " +
					"F.ROTULO_QNT_MEDIDA, " +
					"F.ROTULO_ID_MEDIDA, " +
					"UM.UNIDADE_MEDIDA, " +
					"F.ROTULO_QNT_MEDIDA_CASEIRA, " +
					"F.ROTULO_ID_MEDIDA_CASEIRA, " +
					"UMC.NOME, " +
					"F.TIPO_FICHA " +
					"FROM TB_FICHA F INNER JOIN TB_UNIDADE_MEDIDA UM " +
					"ON F.ROTULO_ID_MEDIDA = UM.ID_UNIDADE_MEDIDA JOIN TB_UNIDADE_MEDIDA_CASEIRA UMC " +
					"ON F.ROTULO_ID_MEDIDA_CASEIRA = UMC.ID_UNIDADE_MEDIDA_CASEIRA " +
					"WHERE F.TIPO_FICHA = 'c' AND F.ID_FICHA = " + id
			);
			
			PreparedStatement statement = conexao.prepareStatement(sql.toString());
			ResultSet resultset = statement.executeQuery();
			Ficha dto = null;
			if (resultset.next()) {
				dto = new Ficha();
				dto.setIdFicha(resultset.getInt("F.ID_FICHA"));
				dto.setIdEmpresa(resultset.getInt("F.ID_EMPRESA"));
				dto.setNome(resultset.getString("F.NOME"));
				dto.setRendimento(resultset.getString("F.RENDIMENTO"));
				dto.setFoto(resultset.getString("F.FOTO"));
				dto.setModoPreparo(resultset.getString("F.MODO_PREPARO"));
				dto.setMontagem(resultset.getString("F.MONTAGEM"));
				dto.setOrientacoesArmazenamento(resultset.getString("F.ORIENTACOES_ARMAZENAMENTO"));
				dto.setTextura(resultset.getString("F.TEXTURA"));
				dto.setSabor(resultset.getString("F.SABOR"));
				dto.setApresentacao(resultset.getString("F.APRESENTACAO"));
				dto.setQntMedida(resultset.getDouble("F.ROTULO_QNT_MEDIDA"));
				dto.setQntMedidaCaseira(resultset.getDouble("F.ROTULO_QNT_MEDIDA_CASEIRA"));
				
				UnidadeMedida um = new UnidadeMedida();
				um.setIdUnidadeMedida(resultset.getInt("F.ROTULO_ID_MEDIDA"));
				um.setUnidadeMedida(resultset.getString("UM.UNIDADE_MEDIDA"));
				dto.setMedida(um);
				
				UnidadeMedidaCaseira umc = new UnidadeMedidaCaseira();
				umc.setIdUnidadeMedidaCaseira(resultset.getInt("F.ROTULO_ID_MEDIDA_CASEIRA"));
				umc.setNome(resultset.getString("UMC.NOME"));
				dto.setMedidaCaseira(umc);
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
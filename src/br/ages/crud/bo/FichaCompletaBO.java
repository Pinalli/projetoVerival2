package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.ages.crud.dao.FichaCompletaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Ficha;
import br.ages.crud.util.MensagemContantes;

/**
 * @author Alessandro
 */

public class FichaCompletaBO {
	
	private FichaCompletaDAO fichaCompletaDAO = null;
	
	public FichaCompletaBO(){
		fichaCompletaDAO = new FichaCompletaDAO();
	}
	
	public int cadastrarFichaCompleta(Ficha fichaCompleta)throws NegocioException, SQLException, ParseException {
		
		try{
			return fichaCompletaDAO.cadastrarFichaCompleta(fichaCompleta);
		} catch(PersistenciaException e){
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	public boolean validarFichaCompleta(Ficha fichaCompleta) throws NegocioException{
		boolean isValido = true;
		StringBuilder msg = new StringBuilder();
		try{
			
			//Nome
			if(fichaCompleta.getNome()==null || fichaCompleta.getNome().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_NOME_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Rendimento
			if(fichaCompleta.getRendimento()==null || fichaCompleta.getRendimento().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Modo Preparo
			if(fichaCompleta.getModoPreparo()==null || fichaCompleta.getModoPreparo().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Montagem
			if(fichaCompleta.getMontagem()==null || fichaCompleta.getMontagem().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_MONTAGEM_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Orientação e armazenamento
			if(fichaCompleta.getOrientacoesArmazenamento()==null || fichaCompleta.getOrientacoesArmazenamento().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_ORIENTACAO_ARMAZENAMENTO + "<br/>");
			}
			
			//Textura
			if(fichaCompleta.getTextura()==null || fichaCompleta.getTextura().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_TEXTURA + "<br/>");
			}
			
			//Sabor
			if(fichaCompleta.getSabor()==null || fichaCompleta.getSabor().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_SABOR + "<br/>");
			}
			
			//Apresentação
			if(fichaCompleta.getApresentacao()==null || fichaCompleta.getApresentacao().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_APRESENTACAO + "<br/>");
				
				
			}
			
			//Tempo de Preparo
			if(fichaCompleta.getTempoPreparo()==null || fichaCompleta.getTempoPreparo().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_TEMPO_PREPARO + "<br/>");
			}
			
			//Utensilios e Equipamentos
			if(fichaCompleta.getUtensilios()==null || fichaCompleta.getUtensilios().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_UTENSILIOS + "<br/>");
			}
			
			//Temperatura
			if(fichaCompleta.getTemperatura()==null || fichaCompleta.getTemperatura().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_FICHA_COMPLETA_CAMPO_TEMPERATURA + "<br/>");
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
			
		}
		return isValido;
	}
	
	public List<Ficha> listarFichaCompleta() throws NegocioException, PersistenciaException, SQLException{
		
		List<Ficha> listFichaCompleta = null;
		
		try{
			listFichaCompleta = fichaCompletaDAO.listarFichasCompleta();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
		return listFichaCompleta;
	}
	
	
	//Editar
	public void editarFichaCompleta(Ficha fichaCompleta) throws NegocioException{
		
		try{
			fichaCompletaDAO.editarFichaCompleta(fichaCompleta);
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	//Remover
	public void removerFichaCompleta(Integer idFicha) throws NegocioException, SQLException, PersistenciaException {
		try{
			fichaCompletaDAO.removerFichaCompleta(idFicha);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(MensagemContantes.MSG_ERR_REMOVE_FICHA_COMPLETA_EM_PROJETO);
		}
	}
	
	//Buscar id ficha
    public Ficha buscaIdFicha(int id) throws PersistenciaException, SQLException {
        return fichaCompletaDAO.buscarIdFicha(id);
    }

    public int getProximoIdFicha() throws NegocioException, SQLException, PersistenciaException {
        try {
            return fichaCompletaDAO.getProximoIdFicha();
        } catch (PersistenciaException | SQLException e) {
            throw new NegocioException(e);
        }
    }
	
}

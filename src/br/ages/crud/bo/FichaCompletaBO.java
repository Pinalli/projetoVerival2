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
	
	public void cadastrarFichaCompleta(Ficha fichaCompleta)throws NegocioException, SQLException, ParseException {
		
		try{
			fichaCompletaDAO.cadastrarFichaCompleta(fichaCompleta);
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
				msg.append(MensagemContantes.MSG_ERR_CAMPO_NOME_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Rendimento
			if(fichaCompleta.getRendimento()==null || fichaCompleta.getRendimento().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_RENDIMENTO_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Modo Preparo
			if(fichaCompleta.getModoPreparo()==null || fichaCompleta.getModoPreparo().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_MODO_PREPARO_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Montagem
			if(fichaCompleta.getMontagem()==null || fichaCompleta.getMontagem().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_MONTAGEM_FICHA_OBRIGATORIO + "<br/>");
			}
			
			//Orienta��o e armazenamento
			if(fichaCompleta.getOrientacoesArmazenamento()==null || fichaCompleta.getOrientacoesArmazenamento().equals("")){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_ORIENTACAO_ARMAZENAMENTO_FICHA_OBRIGATORIO + "<br/>");
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
			throw new NegocioException(MensagemContantes.MSG_ERR_REMOVE_FICHA_EM_PROJETO);
		}
	}
	
}
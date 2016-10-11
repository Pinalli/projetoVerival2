package br.ages.crud.bo;

import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ages.crud.dao.EmpresaDAO;
import br.ages.crud.exception.NegocioException;
import br.ages.crud.exception.PersistenciaException;
import br.ages.crud.model.Empresa;
import br.ages.crud.model.Usuario;
import br.ages.crud.util.MensagemContantes;
import br.ages.crud.util.Util;
import br.ages.crud.validator.SenhaValidator;

/**
 * Gerencia os comportamentos de negocio do empresa Associa os parametros da
 * tela as propriedades da classe
 * 
 * @author Santana
 * 
 */
public class EmpresaBO {
	
	private EmpresaDAO empresaDAO = null;

	public EmpresaBO() {
		empresaDAO = new EmpresaDAO();
	}
	
	public boolean validaEmpresa(Empresa empresa) throws NegocioException {
		boolean isValido = true;
		StringBuilder msg = new StringBuilder();
	
		try {
			
			boolean cnpjValido = Util.isCNPJ(empresa.getCnpj());
			
			if(cnpjValido==false){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CNPJ_INVALIDA + "<br/>");
			}
			if(empresa.getEndereco()== null){
				isValido= false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_ENDERECO_OBRIGATORIO + "<br/>");
			}
			
			// Nome
			if (empresa.getTelefone() == null || "".equals(empresa.getTelefone())) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_NOME_OBRIGATORIO + "<br/>");
			}
			if (empresa.getCidade() == null || "".equals(empresa.getCidade())) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_NOME_OBRIGATORIO + "<br/>");
			}
			
			if (empresa.getNome() == null || "".equals(empresa.getNome())) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_NOME_OBRIGATORIO + "<br/>");
			}
			// Usu⳩o
			if (empresa.getResponsavel() == null || "".equals(empresa.getResponsavel())) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", " responsavel ").concat("<br/>"));
			}
			if (empresa.getRazaoSocial() == null || "".equals(empresa.getRazaoSocial())){
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_CAMPO_OBRIGATORIO.replace("?", "razao social ").concat("<br/>"));
			}

			String nome = Normalizer.normalize(empresa.getNome(), Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

			if (!nome.matches("([a-zA-Z]*)(.*)")) {
				isValido = false;
				msg.append(MensagemContantes.MSG_ERR_NOME_INVALIDO.replace("?", "Nome ").concat("<br/>"));
			}
						
			if (!isValido) {
				throw new NegocioException(msg.toString());
			}
			//

		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return isValido;

	}
	
	public void cadastraEmpresa(Empresa empresa) throws NegocioException, SQLException, ParseException {

		try {
			empresaDAO.cadastrarEmpresa(empresa);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}

	public void editaEmpresa(Empresa empresa) throws NegocioException, SQLException, ParseException {

		try {
			empresaDAO.editaEmpresa(empresa);
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

	}
	
	/**
	 * Lista as pessoas a partir das classes de DAO
	 * 
	 * @return
	 * @throws NegocioException
	 */
	public List<Empresa> listarEmpresa() throws NegocioException {

		List<Empresa> listEmpresa = null;

		try {
			listEmpresa = empresaDAO.listarEmpresa();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}

		return listEmpresa;

	}

	public Empresa buscaEmpresaId(int idEmpresa) throws NegocioException {
		try {
			Empresa empresa = empresaDAO.buscaEmpresaId(idEmpresa);

			return empresa;
		} catch (Exception e) {
			e.printStackTrace();
			throw new NegocioException(e);
		}
	}
	
	

	public void setEmpresaDAO(EmpresaDAO empresaDAO) {
		this.empresaDAO = empresaDAO;
	}
	
	/**
	 * Remove Empresa da base
	 * 
	 * @param idEmpresa
	 * @throws NegocioException
	 * @throws SQLException
	 */
	public void removerEmpresa(Integer idEmpresa) throws NegocioException, SQLException {
		try {
				empresaDAO.removerEmpresa(idEmpresa);
				
		} catch (PersistenciaException e) {
			e.printStackTrace();
			throw new NegocioException(MensagemContantes.MSG_ERR_REMOVE_EMPRESA_EM_PROJETO);
		}
	}
	
}

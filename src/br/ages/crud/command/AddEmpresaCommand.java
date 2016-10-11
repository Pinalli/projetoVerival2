package br.ages.crud.command;

import javax.servlet.http.HttpServletRequest;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.model.PerfilAcesso;
import br.ages.crud.model.Empresa;
import br.ages.crud.util.MensagemContantes;
import org.apache.log4j.Logger;

public class AddEmpresaCommand implements Command {

	private String proxima;

	private EmpresaBO empresaBO;

	@Override
	public String execute(HttpServletRequest request) {
		empresaBO = new EmpresaBO();
		proxima = "main?acao=telaEmpresa";
		String cnpj = request.getParameter("cnpj");
		String telefone = request.getParameter("telefone");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String razaoSocial = request.getParameter("razaoSocial");
		String responsavel = request.getParameter("responsavel");
		String logotipo = request.getParameter("logotipo");
		try {
			Empresa empresa = new Empresa();
			empresa.setCnpj(cnpj);
			empresa.setTelefone(telefone);
			empresa.setNome(nome);
			empresa.setEndereco(endereco);
			empresa.setCidade(cidade);
			empresa.setRazaoSocial(razaoSocial);
			empresa.setResponsavel(responsavel);
			empresa.setLogo(logotipo);
			boolean isValido = empresaBO.validaEmpresa(empresa);
			if (isValido == false) {
				request.setAttribute("msgErro", MensagemContantes.MSG_ERR_EMPRESA_DADOS_INVALIDOS);
			} else { // cadastro de pessoa com sucesso
			
			empresaBO.cadastraEmpresa(empresa);
				proxima = "main?acao=listEmpresa";
				request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_EMPRESA.replace("?", empresa.getNome()));
				}
			//proxima = "main?acao=listUser";
		} catch (Exception e) {
			request.setAttribute("msgErro", e.getMessage());
			//proxima = "main?acao=listUser";
		}

		return proxima;
	}
}

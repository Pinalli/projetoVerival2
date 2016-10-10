package br.ages.crud.command;

import br.ages.crud.bo.EmpresaBO;
import br.ages.crud.model.Empresa;
import br.ages.crud.util.MensagemContantes;

import javax.servlet.http.HttpServletRequest;


public class EditEmpresaCommand implements Command {

    private String proxima;

    private EmpresaBO empresaBO;

    @Override
    public String execute(HttpServletRequest request) {
        proxima = "empresa/editEmpresa.jsp";
        empresaBO = new EmpresaBO();
        int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));
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
            empresa.setIdEmpresa(idEmpresa);

            empresaBO.editaEmpresa(empresa);
            proxima = "main?acao=listEmpresa";
            request.setAttribute("msgSucesso", MensagemContantes.MSG_SUC_CADASTRO_EMPRESA.replace("?", empresa.getNome()));
            //proxima = "main?acao=listUser";
        } catch (Exception e) {
            request.setAttribute("msgErro", e.getMessage());
            //proxima = "main?acao=listUser";
        }


        return proxima;
    }
}

<%@page import="br.ages.crud.model.Ingrediente"%>
<%@ page import="br.ages.crud.model.Empresa" %>
<%@ page import="java.util.*" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--onkidonki-->
<jsp:include page="../template/head.jsp"></jsp:include>
<head>
<script type="text/javascript" src="js/empresa.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
</head>
<%Empresa empresa = (Empresa) request.getAttribute("empresa"); %>

<div class="panel panel-success panel-addUser">

    <div class="panel-heading text-center">
		Editar Empresa <b><%=empresa.getNome()%></b>
	</div>

	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


		<form method="post" class="form-horizontal" action="main?acao=editEmpresa">

			<div class="form-group">
				<input class="form-control" type="hidden" id="idEmpresa" name="idEmpresa" value="<%=empresa.getIdEmpresa()%>">
				<label class="col-md-3 control-label ages" for="cnpj">CNPJ</label>
				<div class="col-md-6">
					<input id="cnpj" name="cnpj" value="<%=empresa.getCnpj()%>" type="text"
						placeholder="Ex: 000.000.1000/20" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="telefone">Telefone</label>
				<div class="col-md-6">
					<input id="telefone" name="telefone" value="<%=empresa.getTelefone()%>" type="text"
						placeholder="5199017442" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="nome">Nome</label>
				<div class="col-md-6">
					<input id="nome" name="nome" value="<%= empresa.getNome()%>" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="cidade">Endereço</label>
				<div class="col-md-6">
					<input id="endereco" name="endereco" value="<%= empresa.getEndereco()%>" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="cidade">Cidade</label>
				<div class="col-md-6">
					<input id="cidade" name="cidade" value="<%= empresa.getCidade()%>" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>

			<div class="form-group">
				<label class="col-md-3 control-label ages" for="cidade">UF</label>
				<div class="col-md-6">
					<select id="uf" name="uf" placeholder="" class="form-control input-md" required="">
						<%
							Map<String,String> estados = new HashMap<String,String>();
							estados.put("AC","Acre");
							estados.put("AL", "Alagoas");
							estados.put("AP", "Amapá");
							estados.put("AM", "Amazonas");
							estados.put("BA", "Bahia");
							estados.put("CE", "Ceara");
							estados.put("DF", "Distrito Federal");
							estados.put("ES", "Espirito Santo");
							estados.put("GO", "Goiás");
							estados.put("MA","Maranhão");
							estados.put("MS","Mato Grosso do Sul");
							estados.put("MT","Mato Grosso");
							estados.put("MG","Minas Gerais");
							estados.put("PA","Pará");
							estados.put("PB","Paraíba");
							estados.put("PR","Paraná");
							estados.put("PE","Pernambuco");
							estados.put("PI","Piauí");
							estados.put("RJ","Rio de Janeiro");
							estados.put("RN","Rio Grande do Norte");
							estados.put("RS","Rio Grande do Sul");
							estados.put("RO","Rondônia");
							estados.put("RR","Roraima");
							estados.put("SC","Santa Catarina");
							estados.put("SP","São Paulo");
							estados.put("SE","Sergipe");
							estados.put("TO","Tocantins");

							for (String uf : estados.keySet()){

								if(uf.equals(empresa.getUf())){
									%>
										<option value="<%= empresa.getUf() %>" selected> <%= estados.get(empresa.getUf()) %></option>
									<%
								} else {
									%>
										<option value="<%= uf %>"> <%= estados.get(uf) %></option>
									<%
									}
							}
						%>
					</select>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="razaoSocial">Razão
					Social</label>
				<div class="col-md-6">
					<input id="razaoSocial" name="razaoSocial" value="<%= empresa.getRazaoSocial()%>" type="text"
						placeholder="" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="responsavel">Responsavel</label>
				<div class="col-md-6">
					<input id="responsavel" name="responsavel" value="<%= empresa.getResponsavel()%>" type="text"
						placeholder="Responsavel pela empresa"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="logotipo">Logo</label>
				<div class="col-md-6">
					<input id="logotipo" name="logotipo" class="input-file" type="file" value="">
				</div>
			</div>
			<div class="form-group">
				<div id="image_preview" style="display:block; margin-left:30%;">
					<img id="previewing" style="width: 150px; height: 150px;" src="upload/logo/<%= empresa.getLogo()%>" />
				</div>
			</div>
			<div id="errorMessage" class="alert alert-danger" style="display:none">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Erro! </strong> Imagem deve ser JPG, JPEG ou PNG.
			</div>


			<div class="text-center">
				<input class="btn btn-warning limpaEmpresa" id="limparForm" type="reset" value="Limpar"> 
				<input	class="btn btn-success addEmpresa pull-right" type="submit"	value="Salvar">
			</div>

		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

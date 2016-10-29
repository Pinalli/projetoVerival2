<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Ingrediente"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--onkidonki-->
<jsp:include page="../template/head.jsp"></jsp:include>
<head>
<script type="text/javascript" src="js/empresa.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://digitalbush.com/wp-content/uploads/2014/10/jquery.maskedinput.js"></script>
</head>
<div class="panel panel-success panel-addUser">

	<div class="panel-heading text-center">Cadastro de Empresa</div>


	<div class="panel-body">

		<jsp:include page="/template/msg.jsp"></jsp:include>


		<form method="post" class="form-horizontal" action="main?acao=addEmpresa">

			<div class="form-group">
				<label class="col-md-3 control-label ages" for="cnpj">CNPJ</label>
				<div class="col-md-6">
					<input id="cnpj" name="cnpj" value="${param.cnpj}" type="text"
						placeholder="Ex: 000.000.1000/20" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="telefone">Telefone</label>
				<div class="col-md-6">
					<input id="telefone" name="telefone" value="${param.telefone}" type="text"
						placeholder="5199017442" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="nome">Nome</label>
				<div class="col-md-6">
					<input id="nome" name="nome" value="${param.nome}" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="cidade">Endereço</label>
				<div class="col-md-6">
					<input id="endereco" name="endereco" value="${param.endereco}" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="cidade">Cidade</label>
				<div class="col-md-6">
					<input id="cidade" name="cidade" value="${param.cidade}" type="text" placeholder=""
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="razaoSocial">Razão
					Social</label>
				<div class="col-md-6">
					<input id="razaoSocial" name="razaoSocial" value="${param.razaoSocial}" type="text"
						placeholder="" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="responsavel">Responsavel</label>
				<div class="col-md-6">
					<input id="responsavel" name="responsavel" value="${param.responsavel}" type="text"
						placeholder="Responsavel pela empresa"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- File Button -->
			<div class="form-group">
				<label class="col-md-3 control-label ages" for="logotipo">Logo</label>
				<div class="col-md-6">
					<input id="logotipo" name="logotipo" class="input-file" type="file">
				</div>
			</div>
			<div class="form-group">
				<div id="image_preview" style="display:none; margin-left:30%;"><img id="previewing" src="" /></div>
			</div>
			<h4 id='loading'></h4>
			<div id="message"></div>


			<div class="text-center">
				<input class="btn btn-warning limpaEmpresa" id="limparForm" type="reset" value="Limpar"> 
				<input class="btn btn-success addEmpresa pull-right" type="submit"	value="Cadastrar">
			</div>

		</form>
	</div>
</div>
<jsp:include page="/template/foot.jsp"></jsp:include>

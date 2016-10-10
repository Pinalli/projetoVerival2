<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.UnidadeMedida"%>
<%@page import="br.ages.crud.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%UnidadeMedida unidadeMedida = (UnidadeMedida) request.getAttribute("unidadeMedida"); %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<div class="panel panel-success panel-addUser">
    		
		<div class="panel-heading text-center">
			Editar Unidade de Medida <b><%=unidadeMedida.getUnidadeMedida()%></b>
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
        	
        	<div class="table-responsive">
                
                <form method="post" action="main?acao=editUnidadeMedida">
					<input class="form-control" type="hidden" id="idUnidadeMedida" name="idUnidadeMedida" value="<%=unidadeMedida.getIdUnidadeMedida()%>">
					<div class="form-group">
						<label class="form-label ages">Unidade de Medida: <span class="red">*</span></label>
						<input class="form-control" id="descricaoUnidadeMedida" name="descricaoUnidadeMedida" value="<%=unidadeMedida.getUnidadeMedida()%>" type="text" maxlength="120" required>
					</div>

					<div class="form-group">
						<label class="form-label ages">Sigla de Unidade de Medida: <span class="red">*</span></label>
						<input class="form-control" id="siglaUnidadeMedida" name="siglaUnidadeMedida" value="<%=unidadeMedida.getSiglaUnidadeMedida()%>" type="text" maxlength="8" required>
					</div>

					<div class="form-group">
						<label class="form-label ages">Medida de Conversão: <span class="red">*</span></label>
						<input class="form-control" id="medidaConversao" name="medidaConversao" value="<%=unidadeMedida.getMedidaConversao()%>" type="text" maxlength="120" required>
					</div>


					<div class="form-group">
						<label class="form-label ages">Fator de conversão: <span class="red">*</span></label>
						<input class="form-control" id="fatorConversao" name="fatorConversao" value="<%=unidadeMedida.getFatorConversao()%>" type="number" step="any" min="0" maxlength="120" required>
					</div>
				    
                    <hr>
                    
                    <p>Campos que contém <span class="red">*</span> são obrigatórios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-warning limparUnidadeMedida pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-success addUnidadeMedida pull-right" type="submit" value="Salvar">
			        </div>
			        
                </form>
            </div>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
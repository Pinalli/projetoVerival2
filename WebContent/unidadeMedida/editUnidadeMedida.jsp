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
			Editar Unidade de Medida
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
        	
        	<div class="table-responsive">
                
                <form method="post" action="main?acao=editUnidadeMedida">
                	<div class="form-group">
			           	<label class="form-label ages">ID</label>
			           	<input class="form-control" id="idUnidadeMedida" name="idUnidadeMedida" value="<%=unidadeMedida.getIdUnidadeMedida() %>" type="text" maxlength="9" readonly>
		            </div>
		            
		            <div class="form-group">
			           	<label class="form-label ages">Descrição de origem: <span class="red">*</span></label>
			           	<input class="form-control" id="descricaoOrigem" name="descricaoOrigem" value="<%=unidadeMedida.getDescricaoOrigem() %>" type="text" maxlength="120" required>
		            </div>

					<div class="form-group">
			           	<label class="form-label ages">Descrição de Conversão: <span class="red">*</span></label>
			           	<input class="form-control" id="descricaoConversao" name="descricaoConversao" value="<%=unidadeMedida.getDescricaoConversao() %>" type="text" maxlength="120" required>
		            </div>
                    
					<div class="form-group">
			           	<label class="form-label ages">Sigla: <span class="red">*</span></label>
			           	<input class="form-control" id="sigla" name="sigla" value="<%=unidadeMedida.getSigla() %>" type="text" maxlength="8" required>
		            </div>
		            
		              <div class="form-group">
			           	<label class="form-label ages">Medida de conversão: <span class="red">*</span></label>
			           	<input class="form-control" id="medidaConversao" name="medidaConversao" value="<%=unidadeMedida.getMedidaConversao() %>" type="number" maxlength="120" min="0"  required>
		            </div>
				    
                    <hr>
                    
                    <p>Campos que contém <span class="red">*</span> são obrigatórios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-default limparUser pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-success addUser pull-right" type="submit" value="Salvar">
			        </div>
			        
                </form>
            </div>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
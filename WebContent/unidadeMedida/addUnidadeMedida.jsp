<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.Usuario"%>
<%@page import="br.ages.crud.model.UnidadeMedida"%>
<%@page import="br.ages.crud.model.TipoUsuario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<div class="panel panel-success panel-addUser">
    		
		<div class="panel-heading text-center">
			Cadastrar Unidade de Medida
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
        	
        	<div class="table-responsive">
                
                <form method="post" action="main?acao=addUnidadeMedida">                	
		            <div class="form-group">
			           	<label class="form-label ages">Unidade de Medida: <span class="red">*</span></label>
			           	<input class="form-control" id="unidadeMedida" name="unidadeMedida" value="" type="text" maxlength="120" required>
		            </div>

					<div class="form-group">
						<label class="form-label ages">Sigla da Unidade de Medida: <span class="red">*</span></label>
						<input class="form-control" id="siglaUnidadeMedida" name="siglaUnidadeMedida" value="" type="text" maxlength="8" required>
					</div>

					<div class="form-group">
			           	<label class="form-label ages">Medida de Convers�o: <span class="red">*</span></label>
			           	<input class="form-control" id="medidaConversao" name="medidaConversao" value="" type="text" maxlength="120" required>
		            </div>
                    

		              <div class="form-group">
			           	<label class="form-label ages">Fator de convers�o: <span class="red">*</span></label>
			           	<input class="form-control" id="fatorConversao" name="fatorConversao" value="" type="number" step="any" min="0" maxlength="120" required>
		            </div>
				    
                    <hr>
                    
                    <p>Campos que cont�m <span class="red">*</span> s�o obrigat�rios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-warning limparUnidadeMedida pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-success addUnidadeMedida pull-right" type="submit" value="Salvar">
			        </div>
			        
                </form>
            </div>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
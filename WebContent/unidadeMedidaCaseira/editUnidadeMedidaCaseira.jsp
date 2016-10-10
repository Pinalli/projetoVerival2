<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.ages.crud.model.UnidadeMedidaCaseira" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%UnidadeMedidaCaseira unidadeMedidaCaseira = (UnidadeMedidaCaseira) request.getAttribute("unidadeMedidaCaseira"); %>

<jsp:include page="../template/head.jsp"></jsp:include>
	
	<div class="panel panel-success panel-addUser">
    		
		<div class="panel-heading text-center">
			Editar Unidade Medida Caseira <b><%=unidadeMedidaCaseira.getNome() %></b>
		</div>
		
		
		<div class="panel-body">
		
        	<jsp:include page="/template/msg.jsp"></jsp:include>
        	
        	<div class="table-responsive">
                
                <form method="post" action="main?acao=editUnidadeMedidaCaseira">
                	<input class="form-control" type="hidden" id="idUnidadeMedidaCaseira" name="idUnidadeMedidaCaseira" value="<%=unidadeMedidaCaseira.getIdUnidadeMedidaCaseira()%>">
                	<!--div class="form-group">
			           	<label class="form-label ages">IdUnidadeMedidaCaseira:</label>
			           	<input class="form-control" id="idUnidadeMedidaCaseira" name="idUnidadeMedidaCaseira" value="<%=unidadeMedidaCaseira.getIdUnidadeMedidaCaseira()%>" type="text" maxlength="9" readonly>
		            </div-->
		            
		            <div class="form-group">
			           	<label class="form-label ages">Nome: <span class="red">*</span></label>
			           	<input class="form-control" id="nome" name="nome" value="<%=unidadeMedidaCaseira.getNome() %>" type="text" maxlength="120" required>
		            </div>

					<div class="form-group">
			           	<label class="form-label ages">Sigla:</label>
			           	<input class="form-control" id="sigla" name="sigla" value="<%=unidadeMedidaCaseira.getSigla() %>" type="text" maxlength="10" >
		            </div>
                        
                    <hr>
                    
                    <p>Campos que contém <span class="red">*</span> são obrigatórios</p>
                    
                    
                    <div class="text-center">
			           	<input class="btn btn-warning limparUnidadeMedidaCaseira pull-left" type="reset" value="Limpar">
			           	<input class="btn btn-success addUnidadeMedidaCaseira pull-right" type="submit" value="Salvar">
			        </div>
			        
                </form>
            </div>
		</div>
	</div>

<jsp:include page="/template/foot.jsp"></jsp:include>
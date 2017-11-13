<%@page import="br.ages.crud.model.Ingrediente"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalIngrediente.jsp"></jsp:include>
 		
<div class="panel panel-success">
   		
	<div class="panel-heading text-center">Lista de Ingredientes</div>
               
       <div class="panel-body">
       
		<jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">
        
        <table id="listaIngredientes" class="table table-responsive table-striped table-hover table-condensed table-bordered">

            <thead>
                <tr>                    
                    <th style="text-align: center;">Código</th>
					<th style="text-align: center;">Descrição</th>							
					<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
                </tr>
            </thead>

            <tbody> 
            	<%
	            	List<Ingrediente> listaIngredientes = (List<Ingrediente>) request.getAttribute("listaIngredientes");
					for (Ingrediente ing : listaIngredientes) {
				%>
				          
            	<tr>
	            	<td align="center"><%=ing.getCodigo()%></td>
	            	<td align="center"><%=ing.getDescricao()%></td>	                        	
	            	<td align="center">
						<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=ing.getId() %>" data-ingrediente="<%=ing.getDescricao()%>" 
            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
            			</form>
            		</td>
            		
            		<td align="center">
            			<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=ing.getId() %>" data-ingrediente="<%=ing.getDescricao()%>" 
            				data-target="#modalExcluir" title="Deletar"> <i class="glyphicon glyphicon-trash"></i></a>
            			</form>
            		</td>
            	</tr>
				<% 
					} 
				%>
			</tbody>
            
        </table> 
		</div>
    </div>
</div>
<jsp:include page="../template/foot.jsp"></jsp:include>
<script>

$(document).ready(function(){
	$('#listaIngredientes').dataTable({
		"language": {
            "lengthMenu": "_MENU_ Registros",
            "zeroRecords": "Sem registros - sorry",
            "info": "Mostrando _PAGE_ de _PAGES_ páginas",
            "infoEmpty": "Nenhum registros encontrados!",
            "infoFiltered": "(Filtrado _MAX_ do total deregistros)",
            "search":"",
            "searchPlaceholder": "Buscar",
           	"paginate": {
                "first":      "Primeiro",
                "last":       "Último",
                "next":       "Próximo",
                "previous":   "Anterior"
	        },
        },
        "dom": '<"pull-right"f>rtip'
	});
});;
</script>
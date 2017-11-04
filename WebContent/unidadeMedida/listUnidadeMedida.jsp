<%@page import="br.ages.crud.model.UnidadeMedida"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalUnidadeMedida.jsp"></jsp:include>
 		
<div class="panel panel-success">
   		
	<div class="panel-heading text-center">Lista de Unidades de Medida</div>
               
       <div class="panel-body">
       
		<jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">
       
        <table id="listaUnidadeMedida" class="table table-responsive table-striped table-hover table-condensed table-bordered">

            <thead>
                <tr>
                    <th style="text-align: center;">Unidade de Medida</th>
					<th style="text-align: center;">Sigla da Unidade de Medida</th>
					<th style="text-align: center;">Medida de Conversão</th>
					<th style="text-align: center;">Fator de conversao</th>
		 			<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
                </tr>
            </thead>
         <tbody> 
            	<%
					List<UnidadeMedida> listaUnidadesMedida = (List<UnidadeMedida>) request.getAttribute("listaUnidadesMedida");
					for (UnidadeMedida unidadeMedida : listaUnidadesMedida) {
				%>
				          
            	<tr>
	            	<td align="center"><%=unidadeMedida.getUnidadeMedida()%></td>
	            	<td align="center"><%=unidadeMedida.getSiglaUnidadeMedida()%></td>
	            	<td align="center"><%=unidadeMedida.getMedidaConversao()%></td>
	             	<td align="center"><%=unidadeMedida.getFatorConversao()%></td>
	             	<td align="center">
						<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=unidadeMedida.getIdUnidadeMedida() %>" data-usuario="<%=unidadeMedida.getUnidadeMedida()%>"
            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
            			</form>
            		</td>	
            		
            		<td align="center">
            			<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=unidadeMedida.getIdUnidadeMedida() %>" data-usuario="<%=unidadeMedida.getUnidadeMedida()%>"
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
	$('#listaUnidadeMedida').dataTable({
		"language": {
            "lengthMenu": "_MENU_ Registros",
            "zeroRecords": "Sem registros",
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
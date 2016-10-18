<%@page import="br.ages.crud.model.FichaSimplificada"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalFichaSimplificada.jsp"></jsp:include>
 		
<div class="panel panel-success">
   		
	<div class="panel-heading text-center">Lista de Fichas Simplificadas</div>
               
       <div class="panel-body">
       
		<jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">
       
        <table id="listaFichaSimplificada" class="table table-responsive table-striped table-hover table-condensed table-bordered">

            <thead>
                <tr>
                    <th style="text-align: center;">Nome</th>
					<th style="text-align: center;">Rendimento</th>
		 			<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
                </tr>
            </thead>
         <tbody> 
            	<%
					List<FichaSimplificada> listaFichaSimplificada = (List<FichaSimplificada>) request.getAttribute("listaFichaSimplificada");
					for (FichaSimplificada fichaSimplificada : listaFichaSimplificada) {
				%>
				          
            	<tr>
	            	<td align="center"><%=fichaSimplificada.getNome()%></td>
	            	<td align="center"><%=fichaSimplificada.getRendimento()%></td>
	            	<td align="center">
						<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%= fichaSimplificada.getIdFichaSimplificada()  %>" data-fichaS="<%=fichaSimplificada.getNome()%>"
            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
            			</form>
            		</td>	
            		
            		<td align="center">
            			<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=fichaSimplificada.getIdFichaSimplificada() %>" data-fichaS="<%=fichaSimplificada.getNome()%>"
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
	$('#listaFichaSimplificada').dataTable({
	    "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "Sem registros - sorry",
            "info": "Mostrando _PAGE_ de _PAGES_ páginas",
            "infoEmpty": "Nenhum registros encontrados!",
            "infoFiltered": "(Filtrado _MAX_ do total deregistros)",
            "search":"Busca",
           	"paginate": {
                "first":      "Primeiro",
                "last":       "Último",
                "next":       "Próximo",
                "previous":   "Anterior"
	        },
        }
	});
});;
</script>
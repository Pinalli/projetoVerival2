<%@page import="br.ages.crud.model.Ficha"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalFichaCompleta.jsp"></jsp:include>
<script src="./js/fichaCompleta/rotulo.js"></script>
<script src="./js/gerarPDF.js"></script>
<script src="http://cdn.rawgit.com/MrRio/jsPDF/master/dist/jspdf.min.js"></script>
<script src="http://html2canvas.hertzen.com/build/html2canvas.js"></script>

<div class="panel panel-success">
   		
	<div class="panel-heading text-center">Lista de Fichas Completas</div>
               
       <div class="panel-body">
       
		<jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">
       
        <table id="listaFicha" class="table table-responsive table-striped table-hover table-condensed table-bordered">

            <thead>
                <tr>
                    <th style="text-align: center;">Nome</th>
                    <th style="text-align: center;"></th>
		 			<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
                </tr>
            </thead>
         <tbody> 
            	<%
					List<Ficha> listaFicha = (List<Ficha>) request.getAttribute("listaFichaCompleta");
					for (Ficha ficha : listaFicha) {
				%>
				          
            	<tr>
	            	<td align="center"><%=ficha.getNome()%></td>
	            	
	            	<td align="center">
						<form action="" method="post">
            				<a href=""  data-toggle="modal" data-id="<%= ficha.getIdFicha()  %>" data-fichaS="<%=ficha.getNome()%>"
            				data-target="#modalVisualizar" title="Visualizar"><i class="glyphicon glyphicon-download-alt"></i></a>
            			</form>
            		</td>	
	            	<td align="center">
						<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%= ficha.getIdFicha()  %>" data-fichaS="<%=ficha.getNome()%>"
            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
            			</form>
            		</td>	
            		
            		<td align="center">
            			<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=ficha.getIdFicha() %>" data-fichaS="<%=ficha.getNome()%>"
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
	$('#listaFicha').dataTable({
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

<%@page import="br.ages.crud.model.Empresa"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalEmpresa.jsp"></jsp:include>
 		
<div class="panel panel-success">
   		
	<div class="panel-heading text-center">Empresas</div>
               
       <div class="panel-body">
       
		<jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">
       
        <table id="listaEmpresa" class="table table-responsive table-striped table-hover table-condensed table-bordered">

            <thead>
                <tr>
                    <th style="text-align: center;">CNPJ</th>
                    <th style="text-align: center;">Telefone</th>
					<th style="text-align: center;">Nome</th>
					<th style="text-align: center;">Endereço</th>
					<th style="text-align: center;">Cidade</th>
					<th style="text-align: center;">UF</th>
					<th style="text-align: center;">Razão social</th>
		 			<th style="text-align: center;"></th>
					<th style="text-align: center;"></th>
                </tr>
            </thead>
         <tbody> 
            	<%
					List<Empresa> listaEmpresa = (List<Empresa>) request.getAttribute("listaEmpresa");
					for (Empresa empresa : listaEmpresa) {
				%>
				          
            	<tr>
	            	<td align="center"><%=empresa.getCnpj()%></td>
	            	<td align="center"><%=empresa.getTelefone()%></td>
	            	<td align="center"><%=empresa.getNome()%></td>
	            	<td align="center"><%=empresa.getEndereco()%></td>
	             	<td align="center"><%=empresa.getCidade()%></td>
	             	<td align="center"><%=empresa.getUf()%></td>
	             	<td align="center"><%=empresa.getRazaoSocial()%></td>
	             	<td align="center">
						<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=empresa.getIdEmpresa() %>" data-empresa="<%=empresa.getNome()%>" 
            				data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
            			</form>
            		</td>	
            		
            		<td align="center">
            			<form action="" method="post">
            				<a href="" data-toggle="modal" data-id="<%=empresa.getIdEmpresa() %>" data-empresa="<%=empresa.getNome()%>"
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
	$('#listaEmpresa').dataTable({
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
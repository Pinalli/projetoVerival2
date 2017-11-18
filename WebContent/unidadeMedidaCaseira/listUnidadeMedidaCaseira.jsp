<%@page import="br.ages.crud.model.UnidadeMedidaCaseira"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalUnidadeMedidaCaseira.jsp"></jsp:include>

<div class="jumbotron mb-5">
	<h1 style="color: #787a89;"><span class="icon-medida-caseira text-info"></span> Lista de Medidas Caseiras</h1>
	<hr />
    <div class="panel-body">
    
        <jsp:include page="/template/msg.jsp"></jsp:include>

        <div class="table-responsive">
            <table id="listaUnidadeMedidaCaseira" class="table table-responsive table-striped table-hover table-condensed table-bordered" >
                <thead>
                <tr>
                    <th style="text-align: center;">Nome</th>
                    <th style="text-align: center;">Abreviação</th>
                    <th style="text-align: center;">Editar</th>
                    <th style="text-align: center;">Excluir</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<UnidadeMedidaCaseira> listaUnidadeMedidaCaseira =
                            (List<UnidadeMedidaCaseira>) request.getAttribute("listaUnidadeMedidaCaseira");
                    for (UnidadeMedidaCaseira unidadeMedidaCaseira : listaUnidadeMedidaCaseira) {
                %>
                <tr>
                    <td align="center"><%=unidadeMedidaCaseira.getNome()%></td>
                    <td align="center"><%=unidadeMedidaCaseira.getSigla()%></td>
                    <td align="center">
                        <form action="" method="post">
                            <a href="" data-toggle="modal" data-id="<%=unidadeMedidaCaseira.getIdUnidadeMedidaCaseira() %>" data-unidade-medida-caseira="<%=unidadeMedidaCaseira.getNome()%>"
                               data-target="#modalEditar" title="Editar">
                               <span class="icon-editar"></span>
                            </a>
                        </form>
                    </td>

                    <td align="center">
                        <form action="" method="post">
                            <a href="" data-toggle="modal" data-id="<%=unidadeMedidaCaseira.getIdUnidadeMedidaCaseira() %>" data-unidade-medida-caseira="<%=unidadeMedidaCaseira.getNome()%>"
                               data-target="#modalExcluir" title="Deletar">
                               <span class="icon-deletar"></span>
                            </a>
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
    $('#listaUnidadeMedidaCaseira').dataTable({
    	"language": {
            "lengthMenu": "_MENU_ Registros",
            "zeroRecords": "Sem registros",
            "info": "Mostrando _PAGE_ de _PAGES_ páginas",
            "infoEmpty": "Nenhum registro encontrados!",
            "infoFiltered": "(Filtrado _MAX_ do total de registros)",
            "search":"",
            "searchPlaceholder": "Buscar",
           	"paginate": {
                "first":      "Primeiro",
                "last":       "Úšltimo",
                "next":       "Próximo",
                "previous":   "Anterior"
	        },
        },
        "dom": '<"pull-right"f>rtip'
    });
});
</script>
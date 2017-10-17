<%@page import="br.ages.crud.model.UnidadeMedidaCaseira"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalUnidadeMedidaCaseira.jsp"></jsp:include>

<div class="panel panel-success">

    <div class="panel-heading text-center">Lista de Unidades de Medida</div>

    <div class="panel-body">

        <jsp:include page="/template/msg.jsp"></jsp:include>

        <div class="table-responsive">

            <table id="listaUnidadeMedidaCaseira" class="table table-responsive table-striped table-hover table-condensed table-bordered" >

                <thead>
                <tr>
                    <th style="text-align: center;">Nome</th>
                    <th style="text-align: center;">Sigla</th>
                    <th style="text-align: center;"></th>
                    <th style="text-align: center;"></th>
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
                               data-target="#modalEditar" title="Editar"> <i class="glyphicon glyphicon-pencil"></i></a>
                        </form>
                    </td>

                    <td align="center">
                        <form action="" method="post">
                            <a href="" data-toggle="modal" data-id="<%=unidadeMedidaCaseira.getIdUnidadeMedidaCaseira() %>" data-unidade-medida-caseira="<%=unidadeMedidaCaseira.getNome()%>"
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
        $('#listaUnidadeMedidaCaseira').dataTable({
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
<%@page import="br.ages.crud.model.Ingrediente"%>
<%@page import="java.util.List"%>
<jsp:include page="../template/head.jsp"></jsp:include>

<!-- MODAL / POPUP -->
<jsp:include page="../template/modalIngrediente.jsp"></jsp:include>

<div class="jumbotron mb-5">
    <h1 style="color: #787a89;"><span class="icon-ingredientes text-info"></span> Lista de Ingredientes</h1>
    <hr />
    <div class="panel-body">
        <jsp:include page="/template/msg.jsp"></jsp:include>
        <div class="table-responsive">

            <table id="listaIngredientes" class="table table-responsive table-striped table-hover table-condensed table-bordered">
                <thead>
                <tr>
                    <th style="text-align: center;">Código</th>
                    <th style="text-align: center;">Descrição</th>
                    <th style="text-align: center;">Editar</th>
                    <th style="text-align: center;">Excluir</th>
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
                               data-target="#modalEditar" title="Editar"> <i class="icon-editar"></i></a>
                        </form>
                    </td>

                    <td align="center">
                        <form action="" method="post">
                            <a href="" data-toggle="modal" data-id="<%=ing.getId() %>" data-ingrediente="<%=ing.getDescricao()%>"
                               data-target="#modalExcluir" title="Deletar"> <i class="icon-deletar"></i></a>
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
                "zeroRecords": "Sem registros",
                "info": "Mostrando _PAGE_ de _PAGES_ páginas",
                "infoEmpty": "Nenhum registros encontrados!",
                "infoFiltered": "(Filtrado _MAX_ do total de registros)",
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
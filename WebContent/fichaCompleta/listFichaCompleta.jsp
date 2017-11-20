<%@ page import="br.ages.crud.model.Ficha" %>
<%@page import="java.util.List" %>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="../template/msg.jsp"></jsp:include>
<jsp:include page="../template/modalFichaCompleta.jsp"></jsp:include>

<div class="jumbotron mb-5">
    <h1 style="color: #787a89;"><span class="icon-fichas text-info"></span> Lista de Fichas Técnicas</h1>
    <hr />
    <table id="lista-ftp" class="table table-responsive table-bordered table-hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th class="text-center">Nome da Receita</th>
            <th class="text-center">Categoria</th>
            <th class="text-center">Visualizar</th>
            <th class="text-center">Editar</th>
            <th class="text-center">Excluir</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Ficha> listaFicha = (List<Ficha>) request.getAttribute("listaFichaCompleta");
            for (Ficha ficha : listaFicha) {
        %>
        <tr>
            <td><%= ficha.getNome() %></td>
            <td><%= ficha.getCategoria() != null ? ficha.getCategoria().formatted() : "Outros" %></td>
            <td class="text-center">
                <form action="" method="post">
                    <a href="#" onclick="preencheDados();" data-toggle="modal" data-id="<%= ficha.getIdFicha() %>" data-fichaS="<%= ficha.getNome() %>" data-target="#modalVisualizar" title="Visualizar">
                        <span class="icon-visualizar"></span>
                    </a>
                </form>
            </td>
            <td class="text-center">
                <form action="" method="post">
                    <a href="#" data-toggle="modal" data-id="<%= ficha.getIdFicha()  %>" data-fichaS="<%=ficha.getNome()%>" data-target="#modalEditar" title="Editar">
                        <span class="icon-editar"></span>
                    </a>
                </form>
            </td>
            <td class="text-center">
                <form action="" method="post">
                    <a href="#" class="text-danger" data-toggle="modal" data-id="<%=ficha.getIdFicha() %>" data-fichaS="<%=ficha.getNome()%>" data-target="#modalExcluir" title="Deletar">
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

<jsp:include page="../template/foot.jsp"></jsp:include>

<script src="./js/fichaCompleta/rotulo.js"></script>
<script src="http://cdn.rawgit.com/MrRio/jsPDF/master/dist/jspdf.min.js"></script>
<script src="http://html2canvas.hertzen.com/build/html2canvas.js"></script>
<script src="./js/gerarPDF.js"></script>
<script>
    $(document).ready(function(){
        $('#lista-ftp').dataTable({
        	"columnDefs": [{ "orderable": false, "targets": [2, 3, 4] }],
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
                    "last":       "Último",
                    "next":       "Próximo",
                    "previous":   "Anterior"
                },
            },
            "dom": '<"pull-right"f>rtip'
        });
    });;
</script>
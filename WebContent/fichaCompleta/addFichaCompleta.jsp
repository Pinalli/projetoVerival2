<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<jsp:include page="../template/head.jsp"></jsp:include>
<jsp:include page="/template/msg.jsp"></jsp:include>
<jsp:include page="../template/modalFichaCompleta.jsp"></jsp:include>
<script type="text/javascript" src="js/fichaCompletaCalculos.js"></script>
<style>
    input[type='file'] {
        display: none
    }

    /* Aparência que terá o seletor de arquivo */
    .selecao-arquivo-label {
        background-color: #6d8a35;
        border-color: #5c7924;
        border-radius: 5px;
        color: #fff;
        cursor: pointer;
        margin: 10px;
        padding: 6px 20px
    }
</style>

<div class="jumbotron mb-5">
    <h1 style="color: #787a89;"><span class="icon-adicionar text-info"></span> Cadastro de Ficha Técnica de Preparo</h1>
    <hr />

    <form name="addFichaTecnicaCompleta" id="addFichaTecnicaCompletaForm" method="post" action="ajax?acao=addFichaCompletaAjaxCommand">
        <div class="row">
            <div class="col-sm-6">
                <div class="row">
                    <div class="form-group col-sm-12">
                        <label for="nome">Nome da Receita</label>
                        <input type="text" class="form-control" id="nome" name="nome" />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="nome">Rendimento</label>
                        <input type="text" class="form-control" id="nome" name="nome" />
                    </div>
                    <div class="form-group col-sm-6">
                        <label for="nome">Tempo de Preparo</label>
                        <input type="text" class="form-control" id="nome" name="nome" />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-sm-6">
                        <label for="nome">Categoria</label>
                        <select class="custom-select" id="categoria" nome="categoria" required style="width: 100%; ">
                            <option selected disabled>Selecione uma categoria</option>
                            <option value="1">Prato Principal</option>
                            <option value="2">Salada</option>
                            <option value="3">Sobremesa</option>
                            <option value="4">Guarnição</option>
                            <option value="5">Prato Base</option>
                            <option value="6">Acompanhamento</option>
                            <option value="7">Bebida</option>
                            <option value="8">Lanche</option>
                            <option value="9">Outros</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-sm-6 text-center">
                <label style="margin-bottom: 0px;">Imagem</label>
                <div class="form-group col-12">
                    <!-- 						<input id="imgFile" name="imgFile" class="input-file" type="file" value=''> -->
                    <label id="imgFileName" class="selecao-arquivo-label" for='imgFile'>Selecionar um arquivo...</label>
                    <input id="imgFile" name="imgFile" type='file' value="">
                </div>
                <div class="form-group col-md-12">
                    <div id="image_preview">
                        <img id="previewing" src="" class="img-responsive img-thumbnail center-block" />
                    </div>
                </div>
            </div>
        </div>


        <div class="card mb-3" style="margin-top: 30px;">
            <div class="card-header">Ingredientes</div>
            <div class="card-body table-row">
                <div id="elemento-ingrediente" class="row">
                    <div class="card bg-secondary mb-3 show-item-btn" id="ingrediente-1" style="margin-left: 10px; margin-right: 10px; width: 100%;">
                        <div class="card-body">
                            <div class="row">
                                <div class="form-group col-12">
                                    <label for="select-ingredientes" class="">Ingrediente</label>
                                    <select id="select-ingredientes" name="select-ingredientes"
                                        data-live-search="true" class="form-control selectBatata">
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-md-4 col-sm-6">
                                    <label for="select-unidade-medida" class="">Unidade de medida</label>
                                    <select id="select-unidade-medida"  name="select-unidade-medida" data-native-menu="false"
                                            class="form-control selectBatata">
                                    </select>
                                </div>
                                <div class="form-group col-2">
                                    <label for="qnt-unidade-medida">Quantidade</label>
                                    <input type="number" class="form-control" id="qnt-unidade-medida"
                                           onInput="alert02()" placeholder="Qnt" min="0"
                                           max="9999" step="any" name="qnt-unidade-medida"/>
                                </div>
                                <div class="form-group col-4">
                                    <label for="select-medida-caseira" class="">Medida caseira</label>
                                    <select id="select-medida-caseira" name="select-medida-caseira"
                                            data-native-menu="false" class="form-control selectBatata">
                                    </select>
                                </div>
                                <div class="form-group col-2">
                                    <label for="qnt-medida-caseira">Quantidade</label>
                                    <input type="number" class="form-control" id="qnt-medida-caseira"
                                           placeholder="Qnt" min="0" max="9999" step="any"
                                           name="qnt-medida-caseira"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-3">
                                    <label for="qnt-unidade-medida" class="">Gordura Trans</label>
                                    <input type="number" class="form-control" id="gorduraTrans"
                                        placeholder="Gordura Trans" min="0" max="9999" step="0.1" name="gorduraTrans"
                                        onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
                                </div>
                                <div class="form-group col-3">
                                    <label for="cho" class="">CHO</label>
                                    <input type="hidden" class="form-control" id="cho" placeholder="CHO" readonly>
                                    <input type="number" class="form-control" id="choShow" placeholder="CHO" readonly>
                                </div>
                                <div class="form-group col-3">
                                    <label for="ptn" class="">PTN</label>
                                    <input type="hidden" class="form-control" id="ptn"	placeholder="PTN" readonly>
                                    <input type="number" class="form-control" id="ptnShow" placeholder="PTN" readonly>
                                </div>
                                <div class="form-group col-3">
                                    <label for="lip" class="">LIP</label>
                                    <input type="hidden" class="form-control" id="lip" placeholder="LIP"  readonly>
                                    <input type="number" class="form-control" id="lipShow" placeholder="LIP"  readonly>
                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group col-3">
                                    <label for="kcal" class="">Kcal</label>
                                    <input type="hidden" class="form-control" id="kcal" placeholder="Kcal"  readonly>
                                    <input type="number" class="form-control" id="kcalShow" placeholder="Kcal"  readonly>
                                </div>
                                <div class="form-group col-3">
                                    <label for="valor-unitario" class="">Valor unitário</label>
                                    <input	type="hidden" class="form-control"	id="valor-unitario" placeholder="Valor unitário"  readonly>
                                    <input	type="number" class="form-control"	id="valor-unitarioShow" placeholder="Valor unitário"  readonly>
                                </div>
                                <div class="form-group col-3">
                                    <label for="custo-real" class="">Custo real</label>
                                    <input type="hidden" class="form-control" id="custo-real" placeholder="Custo real" readonly>
                                    <input type="number" class="form-control" id="custo-realShow" placeholder="Custo real" readonly>
                                </div>
                                <div class="form-group col-3">
                                    <label for="fator-de-correcao" class="">Fator de correção</label>
                                    <input type="hidden" class="form-control" id="fator-de-correcao" placeholder="Fator de correção" readonly>
                                    <input type="number" class="form-control" id="fator-de-correcaoShow" placeholder="Fator de correção" readonly>
                                </div>
                                <div class="form-group col-3">
                                    <label for="indice-de-coccao" class="">Índice de cocção</label>
                                    <input type="hidden" class="form-control" id="indice-de-coccao" placeholder="Índice de Cocção"  readonly>
                                    <input type="number" class="form-control" id="indice-de-coccaoShow" placeholder="Índice de Cocção"  readonly>
                                </div>
                            </div>
                            <input type="hidden" id="gordura-trans" name="gordura-trans">
                            <input type="hidden" id="gordura-saturada" name="gordura-saturada">
                            <input type="hidden" id="fibra-alimentar" name="fibra-alimentar">
                            <input type="hidden" id="sodio" name="sodio">
                            <div class="text-right btn-excluir-wrapper"></div>
                        </div>
                    </div>
                </div>

            </div>
            <button type="submit" class="btn btn-primary" id="add-row-btn" style="background-color: #6d8a35; border-color: #5c7924;">
                <span class="icon-adicionar"></span> Novo Item
            </button>
        </div>

        <div class="card mb-3">
            <div class="card-header">Informações de Preparo</div>
            <div class="card-body">
                <div class="form-group">
                    <label for="utensiliosEquipamentos">Utensílios & Equipamentos</label>
                    <textarea class="form-control" id="utensiliosEquipamentos"
                              name="utensiliosEquipamentos" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="modoPreparo">Modo de Preparo</label>
                    <textarea class="form-control" id="modoPreparo"
                              name="modoPreparo" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="montagem">Montagem</label>
                    <textarea class="form-control" id="montagem"
                              name="montagem" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="orientacaoArmazenamento">Orientações de Armazenamento</label>
                    <textarea class="form-control" id="orientacaoArmazenamento"
                              name="orientacaoArmazenamento" rows="4"></textarea>
                </div>
            </div>
        </div>

        <div class="card mb-3">
            <div class="card-header">Avaliação Sensorial</div>
            <div class="card-body">
                <div class="form-group">
                    <label for="textura">Textura</label>
                    <textarea class="form-control" id="textura"
                              name="textura" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="sabor">Sabor</label>
                    <textarea class="form-control" id="sabor"
                              name="sabor" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="apresentacao">Apresentação</label>
                    <textarea class="form-control" id="apresentacao"
                              name="apresentacao" rows="4"></textarea>
                </div>

                <div class="form-group">
                    <label for="temperatura">Temperatura</label>
                    <textarea class="form-control" id="temperatura"
                              name="temperatura" rows="4"></textarea>
                </div>
            </div>
        </div>

        <div class="card mb-3">
            <div class="card-header">Informação Nutricional</div>
            <div class="card-body">
                <div class="form-group">
                    <div class="row">
                        <div class="form-group col-md-4 col-sm-6">
                            <label for="select-unidade-medida" class="">Unidadede medida</label>
                            <select id="select-unidade-medida-rotulo"
                                    name="select-unidade-medida-rotulo" data-native-menu="false"
                                    class="form-control selectBatata">
                            </select>
                        </div>
                        <div class="form-group col-2">
                            <label for="qnt-unidade-medida-rotulo" class="">Porção</label>
                            <input type="number" class="form-control" id="qnt-unidade-medida-rotulo"
                                   placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida-rotulo"
                                   onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
                        </div>
                        <div class="form-group col-md-4 col-sm-6">
                            <label for="select-medida-caseira-rotulo" class="">Medida Caseira</label>
                            <select id="select-medida-caseira-rotulo"
                                    name="select-medida-caseira-rotulo" data-native-menu="false"
                                    class="form-control selectBatata">
                            </select>
                        </div>
                        <div class="form-group col-2">
                            <label for="qnt-unidade-medida-caseira-rotulo" class="">Porção</label>
                            <input type="number" class="form-control" id="qnt-unidade-medida-caseira-rotulo"
                                   placeholder="Qnt" min="1" max="9999" name="qnt-unidade-medida-caseira-rotulo"
                                   onKeyDown="limitText(this,4);" onKeyUp="limitText(this,4);">
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="text-right">
            <button type="submit" class="btn btn-primary"><span class="icon-ok"></span> Salvar</button>
            <button type="submit" class="btn btn-warning"><span class="icon-cancelar"></span> Limpar</button>
        </div>
    </form>
</div>

</body>
<script src="./js/fichaCompleta/telaFichaCompleta.js"></script>
<script src="./js/fichaCompleta/addFichaCompleta.js"></script>
<script src="./js/fichaCompleta/rotulo.js"></script>

<script type="text/javascript">
    function limitText(limitField, limitNum) {
        if (limitField.value.length > limitNum) {
            limitField.value = limitField.value.substring(0, limitNum);
        }
    }

    $('#imgFile').on('change', function() {
        $('#imgFileName').html(this.value);
    });
</script>

<jsp:include page="/template/foot.jsp"></jsp:include>
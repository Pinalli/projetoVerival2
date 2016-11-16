$(document).ready(function(){
    var idEmpresa = $("#idEmpresa").val();
    var result = null;
    $.get("ajax?acao=buscaEmpresaLogoAjax&idEmpresa="+idEmpresa, function(data){
        result = jQuery.parseJSON(data);
    }).done(function(){
        if(result != null){
             $("#logoEmpresa").attr("src","upload/logo/"+result);
        }
    });
});

//Função para validar senha
function validaSenha(){
    var senha = document.getElementById("senha"); //Guarda um objeto do elemento input password
    var pattern = /^[a-zA-Z]{1,8}$/; //Padrão para validação de senha
    /*
     * ^ indica o inicio do input
     * [a-zA-Z] indica que são permitidos letras maiusculas e minusculas
     * {1,8} indica que vai ter de 1 a 8 caracteres
     * $ indica o final do input
     */
    
    senha.onchange = function() { //Quando o campo for alterado vai rodar o que estiver dentro do escopo
        var senhaOk = pattern.test(senha.value); //O pattern testa o valor da senha (o que foi digitado)
        if(senhaOk){ //Se estiver dentro do padrão retorna "true"
            
        }
        else {
            alert('Senha inválida!\nDigite apenas letras.');
            senha.value = "";
        }
    };
}
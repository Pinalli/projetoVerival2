<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html><!-- Informa ao browser a vers�o do HTML. Nesse caso HTML5. -->
<html lang="pt-br"><!-- lang="pt-br" informa que a p�gina est� na linguagem portugu�s(Brasil) -->
    <head>
        <meta charset="utf-8"><!-- Codifica��o de caracteres. A UTF-8 permite utilizar caaracteres especiais e acentos -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="icon" href="img/iconutri.ico"><!-- Favicon � aquela imagem que vai na aba do navegador -->
        <link rel="stylesheet" href="css/reset.css"><!-- Esse arquivo css reseta todos os padr�es de todas as tags -->
        <link rel="stylesheet" href="css/style.css"><!-- Estilo geral de todas as p�ginas -->
        <link rel="stylesheet" href="css/index.css"><!-- Estilo dessa p�gina -->
        
        <script src="js/index.js"></script>
    </head>
    <body>
    	<jsp:include page="./template/head.jsp"></jsp:include>
  
        <!-- Conte�do principal -->
        <main>
        
        	<h1 class="welcome">Bem-<span>V</span>indo</h1><!-- T�tulo principal -->
            <img style="width: 330px; height: 300px;" class="logoEmpresa img-responsive" id="logoEmpresa" src="img/faenfinobg.png" alt="FAENFI">
            <img class="logoEmpresa img-responsive" src="img/agesnobg.png" alt="AGES">
            <input  type="hidden" id="idEmpresa" value="25" />
                
                
        
       <jsp:include page="/template/foot.jsp"></jsp:include>
    </body>
</html>
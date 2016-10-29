<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html><!-- Informa ao browser a versão do HTML. Nesse caso HTML5. -->
<html lang="pt-br"><!-- lang="pt-br" informa que a página está na linguagem português(Brasil) -->
    <head>
        <meta charset="utf-8"><!-- Codificação de caracteres. A UTF-8 permite utilizar caaracteres especiais e acentos -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Nutrição - Ficha Técnica</title><!-- Título da página -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <link rel="icon" href="img/iconutri.ico"><!-- Favicon é aquela imagem que vai na aba do navegador -->
        <link rel="stylesheet" href="css/reset.css"><!-- Esse arquivo css reseta todos os padrões de todas as tags -->
        <link rel="stylesheet" href="css/style.css"><!-- Estilo geral de todas as páginas -->
        <link rel="stylesheet" href="css/index.css"><!-- Estilo dessa página -->
        
        <script src="js/index.js"></script>
    </head>
    <body>
    	<jsp:include page="./template/head.jsp"></jsp:include>
  
        <!-- Conteúdo principal -->
        <main>
        
        	<h1 class="welcome">Bem <span>V</span>indo</h1><!-- Título principal -->
            <img class="logoEmpresa" id="logoEmpresa" src="img/faenfinobg.png" alt="FAENFI">
            <img class="logoEmpresa" src="img/agesnobg.png" alt="AGES">
            <input type="hidden" id="idEmpresa" value="19" />
                
                
        
       <jsp:include page="/template/foot.jsp"></jsp:include>
    </body>
</html>
		var a4 = [595.28, 841.89]; // Width e Height de uma folha a4
        
		function gerarPDF() {
        	var cache_width = $('#renderPDF'); //Criado um cache do CSS
    		var cache_height = $('#renderPDF'); //Criado um cache do CSS
    		
    		
    		
    		console.log(cache_width);
    		console.log(cache_height);
    		
    		var size = $("#size").val();

    		// Setar o tamanho da div pelo input fornecido pelo usuário
    		if(!isNaN(parseFloat(size)) && isFinite(size)){
    			if(size>=14.5 && size<=19.5){
    				size = size*37.795275591;
    				$("#renderPDF").width(size).css('max-width','none');
    				$("#renderPDF").height(size).css('max-height','none');

    			}
    		}


            // Aqui ele cria a imagem e cria o pdf
            html2canvas($('#renderPDF'), {
                onrendered: function (canvas) {
                    var img = canvas.toDataURL("image/png", 1.0);
                    var doc = new jsPDF({ unit: 'px', format: 'a4' });

                    doc.addImage(img, 'JPEG', 20, 20);
                    doc.save('FTP.pdf');
                    //Retorna ao CSS normal
                    $('#renderPDF').width(cache_width);
                    $('#renderPDF').height(cache_height);
                   console.log("Error");
                }
            });
        }
	
   
        function preencheDados(infoRotulo){
            $('#modalValorEnergeticoQP').html(infoRotulo.valorEnergeticoQP);
            $('#modalValorEnergeticoVD').html(infoRotulo.valorEnergeticoVD);
            $('#modalCarboidratosQP').html(infoRotulo.carboidratosQP);
            $('#modalCarboidratosVD').html(infoRotulo.carboidratosVD);
            $('#modalProteinasQP').html(infoRotulo.proteinasQP);
            $('#modalProteinasVD').html(infoRotulo.proteinasVD);
            $('#modalGordTotalQP').html(infoRotulo.gorduraTotalQP);
            $('#modalGordTotalVD').html(infoRotulo.gorduraTotalVD);
            $('#modalGordSaturadaQP').html(infoRotulo.gorduraSaturadaQP);
            $('#modalGordSaturadaVD').html(infoRotulo.gorduraSaturadaVD)
            $('#modalGordTransQP').html(infoRotulo.gorduraTransQP);
            $('#modalFibraAlimQP').html(infoRotulo.fibraAlimentarQP);
            $('#modalFibraAlimVD').html(infoRotulo.fibraAlimentarVD);
            $('#modalSodioQP').html(infoRotulo.sodioQP);
            $('#modalSodioVD').html(infoRotulo.sodioVD);
        }
        
        


        function carregaRotuloPDF(id) {

        	gerarRotulo(id).done(function(result) {
        		var resultAsJson = $.parseJSON(result);
        		var infoRotulo = calculoRotulo(resultAsJson);
        		preencheDados(infoRotulo);
        	});
        }
        
        
        
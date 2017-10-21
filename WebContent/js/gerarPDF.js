		var a4 = [595.28, 841.89]; // Width e Height de uma folha a4
        
		function gerarPDF() {
        	var cache_width = $('#renderPDF'); //Criado um cache do CSS
    		var cache_height = $('#renderPDF'); //Criado um cache do CSS
    		
    		
    		
    		console.log(cache_width);
    		console.log(cache_height);
    		
    		    var size = $("#size").val();
   		
            // Setar o tamanho da div pelo input fornecido pelo usuário
            $("#renderPDF").width(size).css('max-width','none');
            $("#renderPDF").height(size).css('max-height','none');
            
           
   	
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
	
        
       /* var representante = {
            "ingrediente":
            [
                {
                    "VE":"156kcal = 657 KJ",
                    "VEVd":8,
                    "Carboidratos": "120g",
                    "CarboidratosVd":8,
                    "Proteinas": "10g",
                    "ProteinasVd":3,
                    "GordTotal": "10g",
                    "GordTotalVd":11,
                    "GordSat": "10g",
                    "GordSatVd": 10,
                    "GordTrans": "10g",
                    "Fibra": "10g",
                    "FibraVd": 3,
                    "Sodio": "10mg",
                    "SodioVD":5
                },
                {
                    "VE":"156kcal = 657 KJ",
                    "VEVd":8,
                    "Carboidratos": "120g",
                    "CarboidratosVd":8,
                    "Proteinas": "10g",
                    "ProteinasVd":3,
                    "GordTotal": "10g",
                    "GordTotalVd":11,
                    "GordSat": "10g",
                    "GordSatVd": 10,
                    "GordTrans": "10g",
                    "Fibra": "10g",
                    "FibraVd": 3,
                    "Sodio": "10mg",
                    "SodioVd":89
                }
            ]
        }
        var len = representante.ingrediente.length/*, aryRepresentantes = [];
        
        var Ids=[];
        for (var i = 0; i < len; i++) {
            var VE= representante.ingrediente[i].VE;
            var VEVd=representante.ingrediente[i].VEVd;
            var Carb = representante.ingrediente[i].Carboidratos;
            var CarbVd=representante.ingrediente[i].CarboidratosVd;
            var Prot = representante.ingrediente[i].Proteinas;
            var ProtVD = representante.ingrediente[i].ProteinasVd;
            var GordTotal = representante.ingrediente[i].GordTotal;
            var GordTotalVd = representante.ingrediente[i].GordTotalVd;
            var GordSat = representante.ingrediente[i].GordSat;
            var GordSatVd = representante.ingrediente[i].GordSatVd;
            var GordTrans = representante.ingrediente[i].GordTrans;
            var Fibra = representante.ingrediente[i].Fibra;
            var FibraVd = representante.ingrediente[i].FibraVd;
            var Sodio = representante.ingrediente[i].Sodio;
            var SodioVd = representante.ingrediente[i].SodioVd;
            /*var strHTML = "<b>" + Carb + "<b>" +
                "<br>" + Prot +
                "<br>" + GordSat +
                "<br>" + GordTrans +
                "<br>" + Fibra +
                "<br>" + Sodio;
            aryRepresentantes.push(strHTML);
        }*/
        function preencheDados(infoRotulo){
            /*var aryUF = ["SP","SC","RJ"];
            for (var i=0; i < aryUF.length; i++){
              $('#div'+aryUF[i]).html(aryRepresentantes[i]);
            }*/ 
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
        		//console.log("AAASS"+result);
        		var resultAsJson = $.parseJSON(result);
        		var infoRotulo = calculoRotulo(resultAsJson);
        		console.log("AAAAAAAAAAAAADoceAAAAA"+infoRotulo);
        		preencheDados(infoRotulo);
        	});
        }
        
        
        
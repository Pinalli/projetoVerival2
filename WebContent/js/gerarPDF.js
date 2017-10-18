		var a4 = [595.28, 841.89]; // Width e Height de uma folha a4
        
		function gerarPDF() {
        	var cache_width = $('#renderPDF').width() + 2; //Criado um cache do CSS
    		var cache_height = $('#renderPDF').height() + 2; //Criado um cache do CSS
    		
    		
    		console.log(cache_width);
    		console.log(cache_height);
    		
    		    var height = $("#height" ).val();
    		    var width = $("#width" ).val();
    		    var a4 = [width, 840];
    		
    		
    		console.log(width);
    		console.log(height);
   		
            // Setar o tamanho da div pelo input fornecido pelo usuário
            $("#renderPDF").width(a4).css('max-width','none');
            //$("#renderPDF").height(height).css('max-height','none');
            
           
   	
            // Aqui ele cria a imagem e cria o pdf
            html2canvas($('#renderPDF'), {
                onrendered: function (canvas) {
                    var img = canvas.toDataURL("image/png", 1.0);
                    var doc = new jsPDF({ unit: 'px', format: 'a4' });

                    doc.addImage(img, 'JPEG', 50, 50);
                    doc.save('FTP.pdf');
                    //Retorna ao CSS normal
                    $('#renderPDF').width(cache_width);
                    $('#renderPDF').height(cache_height);
                   console.log("Error");
                }
            });
        }
        
        var representante = {
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
        var len = representante.ingrediente.length/*, aryRepresentantes = []*/;
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
            aryRepresentantes.push(strHTML);*/
        }
        function preencheDados(){
            /*var aryUF = ["SP","SC","RJ"];
            for (var i=0; i < aryUF.length; i++){
              $('#div'+aryUF[i]).html(aryRepresentantes[i]);
            }*/ 
            $('#valorEnergeticoQP').html(VE);
            $('#valorEnergeticoVD').html(VEVd);
            $('#carboidratosQP').html(Carb);
            $('#carboidratosVD').html(CarbVd);
            $('#proteinasQP').html(Prot);
            $('#proteinasVD').html(ProtVD);
            $('#gordTotalQP').html(GordTotal);
            $('#gordTotalVD').html(GordTotalVd);
            $('#gordSaturadaQP').html(GordSat);
            $('#gordSaturadaVD').html(GordSatVd)
            $('#gordTransQP').html(GordTrans);
            $('#fibraAlimQP').html(Fibra);
            $('#fibraAlimVD').html(FibraVd);
            $('#sodioQP').html(Sodio);
            $('#sodioVD').html(SodioVd);
        }
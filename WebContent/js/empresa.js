$(document).ready(function(e){
	$(function() {
		$("#logotipo").change(function() {
			var file = this.files[0];
			var imagefile = file.type;
			var match = [ "image/jpeg","image/png", "image/jpg" ];
			if (!((imagefile == match[0])
				|| (imagefile == match[1]) || (imagefile == match[2]))) {
				return false;
			} else {
				file.name = "logo-empresa";
				form = new FormData()
				form.append('file',file);
				form.append('empresa', true);
				console.log(form.toString());
				var reader = new FileReader();
				reader.onload = imageIsLoaded;
				reader.readAsDataURL(this.files[0]);
				if (check_multifile_logo($("#logotipo").prop("files")[0]['name'])) {
		            $.ajax({
		                url: "/FichaTP/upload",
		                cache: false,
		                contentType: false,
		                processData: false,
		                async: false,
		                data: form,
		                type: 'POST',
		                success: function(data) {
		                    
		                }
		            });
		        } else {
		            $("#logotipo").html('');
		            alert('We only accept JPG, JPEG, PNG, GIF and BMP files');
		        }
			}
		});
	});
	function imageIsLoaded(e) {
		$("#logotipo").css("color", "green");
		$('#image_preview').css("display", "block");
		$('#previewing').attr('src', e.target.result);
		$('#previewing').attr('width', '150px');
		$('#previewing').attr('height', '150px');
	};

	$("#telefone").mask("(99) 9999-9999?9").focusout(function (event) {  
	    var target, phone, element;  
	    target = (event.currentTarget) ? event.currentTarget : event.srcElement;  
	    phone = target.value.replace(/\D/g, '');
	    element = $(target);  
	    element.unmask();  
	    if(phone.length > 10) {  
	        element.mask("(99) 99999-999?9");  
	    } else {  
	        element.mask("(99) 9999-9999?9");  
	    }  
	});

	$("#cnpj").mask("99.999.999/9999-99").focusout(function (event) {  
		$("#cnpj").unmask(); 
	});

});


function check_multifile_logo(file) {
    var extension = file.substr((file.lastIndexOf('.') + 1))
    if (extension === 'jpg' || extension === 'jpeg' || extension === 'png') {
        return true;
    } else {
        return false;
    }
}
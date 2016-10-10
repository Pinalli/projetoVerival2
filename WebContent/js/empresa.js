$(document).ready(function(e){
	$("#uploadimage").on('submit', (function(e) {
		e.preventDefault();
		$("#message").empty();
		$('#loading').show();
		$.ajax({
				url : "ajax_php_file.php", 
				type : "POST", 
				data : new FormData(this),
				contentType : false, 
				cache : false, 
				processData : false,
				success : function(data){
							$('#loading').hide();
							$("#message").html(data);
							}
				});
	}));
$(function() {
	$("#file").change(function() {
		$("#message").empty();
		var file = this.files[0];
		var imagefile = file.type;
		var match = [ "image/jpeg","image/png", "image/jpg" ];
		if (!((imagefile == match[0])
			|| (imagefile == match[1]) || (imagefile == match[2]))) {
			$('#previewing').attr('src','noimage.png');
			$("#message").html();
			return false;
		} else {
			var reader = new FileReader();
			reader.onload = imageIsLoaded;
			reader.readAsDataURL(this.files[0]);
		}
	});
});
function imageIsLoaded(e) {
	$("#file").css("color", "green");
	$('#image_preview').css("display", "block");
	$('#previewing').attr('src', e.target.result);
	$('#previewing').attr('width', '250px');
	$('#previewing').attr('height', '230px');
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
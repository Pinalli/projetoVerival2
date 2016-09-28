function show() {
    var p = document.getElementById('senha');
	var p2 = document.getElementById('confirmarSenha');
    p.setAttribute('type', 'text');
	p2.setAttribute('type', 'text');
}

function hide() {
    var p = document.getElementById('senha');
	var p2 = document.getElementById('confirmarSenha');
    p.setAttribute('type', 'password');
	p2.setAttribute('type', 'password');
}

$(document).ready(function(){
var pwShown = 0;

	$("#mostrar").click(function(){
		if (pwShown == 0) {
        pwShown = 1;
        show();
    } else {
        pwShown = 0;
        hide();
    }
	});
})
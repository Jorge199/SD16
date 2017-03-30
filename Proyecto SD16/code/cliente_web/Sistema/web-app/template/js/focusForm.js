/**
 * Foco a todos los formularios
 */
$(document).ready(function(e){
	$("#patient input[id=name]").focus();
	$("#doctor input[id=name]").focus();
	$("#myFormRequest input[id=date]").focus();
	$("#diagnostic input[id=name]").focus();
	$("#article input[id=name]").focus();
	$("#articleMovement select[id=articleId]").focus();
	$("#user input[id=name]").focus();
});
/**
 * Validacion para el movimiento de stock
 */

$(document).ready(function(e){
	$("#articleMovement").validate({
				rules: {
					articleId:{
						required:true
					},
					movementType:{
						required:true
					},
					quantity:{
						number:true
					}	
				},

				messages:{
					articleId:{
						required:"El campo articulo es obligatorio"
					},
					movementType:{
						required:"El campo tipo de movimiento es obligatorio"
					},
					quantity:{
						number:"Debe estar en formato numerico"
					}	
				},
				errorPlacement: function(error, element){
					if(element.is(":text") || element.is("select") || element.is("number")){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveData(){
	if($("#articleId").val() == "" || $("#movementType").val() == ""){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if(isNaN($("#quantity").val())){
		$("#quantity").focus();
		return false;
	}
	
}
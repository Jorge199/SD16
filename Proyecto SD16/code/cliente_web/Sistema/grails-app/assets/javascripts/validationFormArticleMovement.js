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
						number:true,
						min: 1,
						max: 2147483647	
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
						number:"Debe estar en formato numerico",
						min:"El valor minimo permitido es 1",
						max:"Supera el valor maximo permitido"
					}	
				},
				errorPlacement: function(error, element){
					if(element.is("select") || element.attr("name") == "quantity"){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveDataArticleMovement(){

	if($("#articleId").val() == "" || $("#movementType").val() == ""){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if($("#quantity").val() == ""){
		$("#quantity").val(1);
	}
	if(isNaN($("#quantity").val())){
		$("#quantity").focus();
		return false;
	}
	if($("#quantity").val() < 1 || $("#quantity").val() > 2147483647){
		$("#quantity").focus();
		return false;	
	}
	
}
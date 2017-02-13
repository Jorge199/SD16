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
					if(element.is("form-group") || element.attr("name") == "quantity"){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveDataArticleMovement(){
	var articleId = $("#articleId").val();
	var movementType = $("#movementType").val();
	var quantity = $("#quantity").val();
	
	if( articleId == "" || movementType == ""){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if( quantity == ""){
		$("#quantity").val(1);
	}
	if(isNaN(quantity)){
		alert("Verifique la cantidad");
		return false;
	}
	if(quantity < 1 || quantity > 2147483647){
		alert("Verifique la cantidad");
		return false;	
	}
	
}
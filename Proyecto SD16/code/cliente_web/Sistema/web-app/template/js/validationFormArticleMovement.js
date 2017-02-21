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
						required:"El articulo es obligatorio(*)"
					},
					movementType:{
						required:"El tipo de movimiento es obligatorio(*)"
					},
					quantity:{
						number:"Debe estar en formato numerico",
						min:"El valor minimo permitido es 1",
						max:"Supera el valor maximo permitido"
					}	
				},
				errorPlacement: function(error, element){
					if(element.attr("name") == "articleId"){
						error.insertAfter("#data-article");
					}
					if(element.attr("name") == "movementType"){
						error.insertAfter("#movementType");
					}
					if(element.attr("name") == "quantity"){
						error.insertAfter("#quantity");
					}
				}
			
			});
	$(".numeric").keydown(function(event) {
		   if(event.shiftKey)
		   {
		        event.preventDefault();
		   }
		 
		   if (event.keyCode == 46 || event.keyCode == 8)    {
		   }
		   else {
		        if (event.keyCode < 95) {
		          if (event.keyCode < 48 || event.keyCode > 57) {
		                event.preventDefault();
		          }
		        } 
		        else {
		              if (event.keyCode < 96 || event.keyCode > 105) {
		                  event.preventDefault();
		              }
		        }
		      }
	});
});

function saveDataArticleMovement(){
	var articleId = $("#articleMovement select[id=articleId]").val();
	var movementType = $("#articleMovement select[id=movementType]").val();
	var quantity = $("#articleMovement input[id=quantity]").val();
	
	if( articleId == ""){
		$("#articleMovement select[id=articleId]").focus();
		return false;
	}
	if(movementType == ""){
		 $("#articleMovement select[id=movementType]").focus();
		return false;
	}
	if( quantity == ""){
		$("#quantity").val(1);
	}
	if(isNaN(quantity)){
		$("#articleMovement input[id=quantity]").focus();
		return false;
	}
	if(quantity < 1 || quantity > 2147483647){
		$("#articleMovement input[id=quantity]").focus();
		return false;	
	}
	
}
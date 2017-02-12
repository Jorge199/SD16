/**
 * Validacion para formulario de articulo
 */

$(document).ready(function(e){
	$("#article").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50]
					},
					description:{
						maxlength:100
					},
					units:{
						required:true,
						maxlength:40
					}
				},

				messages:{
					name:{
						required:"El campo nombre es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					description:{
						maxlength:"Cantidad de caracteres hasta 100"
					},
					units:{
						required:"El campo unidad es obligatorio",
						maxlength:"Cantidad de caracteres hasta 40"
					}
				},
				errorPlacement: function(error, element){
					if(element.is(":text")){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveDataArticle(){
	var name = $("#name").val();
	var description = $("#description").val();
	var units = $("#units").val();
	
	if( name == "" || units  == ""){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if(name.length < 3 || name.length > 50){
		alert("Verifique el nombre del artículo");
		return false;
	}
	if(description.length > 100){
		alert("Verifique la descripción del artículo");
		return false;
	}
	if(units.length > 40){
		alert("Verifique la unidades del artículo");
		return false;
	}

}
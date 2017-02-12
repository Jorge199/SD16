/**
 * Validacion para formulario de articulo
 */

$(document).ready(function(e){
	$("#article").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50],
						lettersonly:true
					},
					description:{
						maxlength:100
					},
					units:{
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
jQuery.validator.addMethod("lettersonly", function(value, element) {
	return this.optional(element) || /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/i.test(value);
	}, "No se admiten números");

function saveDataArticle(){
	var name = $("#name").val();
	var description = $("#description").val();
	var units = $("#units").val();
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	
	if( name == "" ){
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
	if(!(letter.test(name))){
		alert("El nombre debe tener solo letras");
		return false;
	}
	
	
}
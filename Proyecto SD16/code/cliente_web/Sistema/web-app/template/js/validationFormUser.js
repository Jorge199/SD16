/**
 * Validacion pra formulario de usuario
 */

$(document).ready(function(e){
	$("#user").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50]
					},
					userName:{
						required:true,
						rangelength:[3,50]
					},
					pass1:{
						required:true,
						equalTo:"#password2",
						rangelength:[8,16]
					},
					password2:{
						required:true,
						equalTo:"#pass1",
						rangelength:[8,16]
					},
					rolId:{
						required:true
					},
					registrationNumber:{
						required: true,
						number:true,
						rangelength:[3,10]
					}
				},

				messages:{
					name:{
						required:"El campo nombre es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					userName:{
						required:"El campo usuario es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					pass1:{
						required:"El campo contraseña es obligatorio",
						rangelength:"Debe tener entre 8 a 16 caracteres"
					},
					password2:{
						required:"El campo es obligatorio",
						equalTo:"Debe ser igual al campo contraseña",
						rangelength:"Debe tener entre 8 a 16 caracteres"
					},
					rolId:{
						required:"El campo rol es obligatorio"
					},
					registrationNumber:{
						required:"Campo matricula obligatorio",
						number:"Debe estar en formato numerico",
						rangelength:"Debe tener entre 3 a 10 caracteres",
						maxlength:"Maximo de caracteres 10"
					}
				},
				errorPlacement: function(error, element){
					if(element.is(":text") || element.is(":password") || element.is("select")){
						error.insertAfter(element);
					}
				}
			
			});
});
jQuery.validator.addMethod("lettersonly", function(value, element) {
	return this.optional(element) || /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/i.test(value);
	}, "No se admiten números");

function saveDataUser(){
	var name = $("#user input[id=name]").val();
	var userName = $("#user input[id=userName]").val();
	var pass1 = $("#user input[id=pass1]").val();
	var password2 = $("#user input[id=password2]").val();
	var updater = $("#user input[id=updater]").val();
	var registrationNumber = $("#user input[id=registrationNumber]").val();
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	
	if(name == "" || userName == "" || pass1 == "" || password2 == "" || updater == ""){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if(name.length < 3 || name.length > 50){
		alert("Verifique el nombre");
		return false;
	}
	if(userName.length < 3 || userName.length > 50){
		alert("Verifique el usuario");
		return false;
	}
	if(pass1 < 8 || pass1 > 16){
		alert("Verifique la contraseña");
		return false;
	}
	if(password2 < 8 || password2 > 16){
		alert("Verifique la contraseña");
		return false;
	}
	if(pass1 != password2){
		alert("Las contraseñas no son iguales");
		return false;
	}
	
	if(updater == "Doctor"){
		if(isNaN(registrationNumber)){
			alert("La matricula debe ser numérica");
			return false;
		}
		if(registrationNumber.length < 3 || registrationNumber.length > 10){
			alert("Verifique la matricula");
			return false;
		}
	}
	
	if(!(letter.test(name))){
		alert("El nombre debe tener solo letras");
		return false;
	}
}
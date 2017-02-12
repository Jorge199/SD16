/**
 * validacion para el formulario de doctor
 */

$(document).ready(function(e){
			$("#doctor").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50],
						lettersonly:true
					},
					last_name:{
						required:true,
						rangelength:[3,50],
						lettersonly:true
					},
					ci:{
						maxlength:10
					},
					sex:{
						required:true
					},
					speciality:{
						rangelength:[3,20]
					},
					phone:{
						maxlength:15
					},
					email:{
						email:true
					},
					address:{
						rangelength:[3,50]
					}
				},

				messages:{
					name:{
						required:"El campo nombre es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					last_name:{
						required:"El campo apellido es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					ci:{
						maxlength:"Cantidad de caracteres hasta 10"
					},
					sex:{
						required:"Este campo es obligatorio"
					},
					speciality:{
						rangelength:"Cantidad de caracteres de 3 a 20"
					},
					phone:{
						number:"Debe ser numerico",
						maxlength:"Debe tener hasta 15 numeros"
					},
					email:{
						email:"Formato de correo incorrecto"
					},
					address:{
						rangelength:"Cantidad de caracteres entre 3 a 50"
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
	}, "Solo letras");
function saveDataDoc(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	var name = $("#doctor input[id=name]").val();
	var lastName =  $("#doctor input[id=last_name]").val();
	var doc = $("#doctor input[id=ci]").val();
	var address = $("#doctor input[id=address]").val();
	var phone = $("#doctor input[id=phone]").val();
	var email = $("#doctor input[id=email]").val();
	var sex = $("#doctor :radio[id=sex]:checked").val();
	var speciality =  $("#doctor input[id=speciality]").val();
	
	if(name == "" || lastName == "" || sex === undefined){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if(name.length < 3 || name.length > 50){
		alert("Verifique su nombre");
		return false;
	}
	if(lastName.length < 3 || lastName.length > 50){
		alert("Verifique su apellido");
		return false;
	}
	if(doc.length > 10){
		if(!(doc == "")){
			alert("Verifique su documento de identidad");
			return false;
		}	
	}
	if(address.length < 3 || address.length > 50){
		if(!(address == "")){
			alert("Verifique su dirección");
			return false;	
		}	
	}
	if(isNaN(phone)){
		alert("Verifique su número de teléfono");
		return false;
	}
	if(!(phone == "")){
		if(phone.length > 15){
			alert("Verifique su número de teléfono");
			return false;
		}
	}
	if(email != ""){
		if(!expresion.test(email)){
			alert("Verifique su correo");
			return false;
		}
	}
	if(!(speciality == "")){
		if(speciality.length < 3 || speciality.length > 20){
			alert("Verifique su especialidad");
			return false;
		}
	}
	if(!(letter.test(name))){
		alert("El nombre debe tener solo letras");
		return false;
	}
	if(!(letter.test(lastName))){
		alert("El apellido debe tener solo letras");
		return false;
	}
	
}
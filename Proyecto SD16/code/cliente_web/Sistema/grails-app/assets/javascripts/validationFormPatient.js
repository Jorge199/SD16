/**
 * Validaciones para formulario paciente
 */

$(document).ready(function(e){
	$("#patient").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50],
						lettersonly:true
					},
					lastName:{
						required:true,
						rangelength:[3,50],
						lettersonly:true
					},
					document:{
						maxlength:10
					},
					address:{
						rangelength:[3,50]
					},
					phone:{
						maxlength:15
					},
					mail:{
						email:true
					},
					sex:{
						required:true
					},
					birthDate:{
						dateBR: true
					}
				},

				messages:{
					name:{
						required:"El campo nombre es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					lastName:{
						required:"El campo apellido es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					document:{
						maxlength:"Cantidad de caracteres hasta 10"
					},
					address:{
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					phone:{
						number:"Debe ser numerico",
						maxlength:"Debe tener hasta 15 numeros",
					},
					mail:{
						email:"Formato de correo incorrecto"
					},
					sex:{
						required:"Este campo es obligatorio"
					},
					birthDate:{
						dateBR:""
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

function saveDataPa(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	var name = $("#patient input[id=name]").val();
	var lastName = $("#patient input[id=lastName]").val();
	var sex = $("#patient :radio[id=sex]:checked").val();
	var doc = $("#patient input[id=document]").val();
	var address = $("#patient input[id=address]").val();
	var phone = $("#patient input[id=phone]").val();
	var mail = $("#patient input[id=mail]").val();
	
	if( name == "" || lastName == "" || sex === undefined){
		alert("Complete los campos obligatorios(*)");
		return false;
	}

	if(name.length < 3 || name.length > 50){
		alert("Verifique en nombre");
		return false;
	}
	if(lastName.length < 3 || lastName.length > 50){
		alert("Verifique el apellido");
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
	
	if(!expresion.test(mail)){
		if(mail != ""){
			alert("Verifique su correo");
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
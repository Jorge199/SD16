/**
 * validacion modal doctor
 */
$(document).ready(function(e){
			$("#myFormDoctor").validate({
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
	}, "No se admiten números");

function saveDataDoctor(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	
	if($("#myFormDoctor input[id=name]").val() == "" || $("#myFormDoctor input[id=lastName]").val() == "" || $("#myFormDoctor :radio[id=sex]:checked").val() === undefined){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if($("#myFormDoctor input[id=name]").val().length < 3 || $("#myFormDoctor input[id=name]").val().length > 50){
		alert("Verifique su nombre");
		return false;
	}
	if($("#myFormDoctor input[id=last_name]").val().length < 3 || $("#myFormDoctor input[id=last_name]").val().length > 50){
		alert("Verifique su apellido");
		return false;
	}
	if($("#myFormDoctor input[id=ci]").val().length > 10){
		if(!($("#myFormDoctor input[id=ci]").val() == "")){
			alert("Verifique su documento de identidad");
			return false;
		}	
	}
	if($("#myFormDoctor input[id=address]").val().length < 3 || $("#myFormDoctor input[id=address]").val().length > 50){
		if(!($("#myFormDoctor input[id=address]").val() == "")){
			alert("Verifique su dirección");
			return false;	
		}	
	}
	if(isNaN($("#myFormDoctor input[id=phone]").val())){
		alert("Verifique su número de teléfono");
		return false;
	}
	if(!($("#myFormDoctor input[id=phone]").val() == "")){
		if($("#myFormDoctor input[id=phone]").val().length > 15){
			alert("Verifique su número de teléfono");
			return false;
		}
	}
	
	if(!expresion.test($("#myFormDoctor input[id=email]").val())){
		if(mail != ""){
			alert("Verifique su correo");
			return false;
		}	
	}
	if(!(letter.test($("#myFormDoctor input[id=name]").val()))){
		alert("El nombre debe tener solo letras");
		return false;
	}
	if(!(letter.test($("#myFormDoctor input[id=last_name]").val()))){
		alert("El apellido debe tener solo letras");
		return false;
	}
	return true;
	
}
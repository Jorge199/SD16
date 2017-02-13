/**
 * validacion modal paciente
 */
$(document).ready(function(e){
	$("#myFormPatient").validate({
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
						number:true,
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

function saveDataPatient(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	
	if($("#myFormPatient input[id=name]").val() == "" || $("#myFormPatient input[id=lastName]").val() == "" || $("#myFormPatient :radio[id=sex]:checked").val() === undefined){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if($("#myFormPatient input[id=name]").val().length < 3 || $("#myFormPatient input[id=name]").val().length > 50){
		alert("Verifique su nombre");
		return false;
	}
	if($("#myFormPatient input[id=lastName]").val().length < 3 || $("#myFormPatient input[id=lastName]").val().length > 50){
		alert("Verifique su apellido");
		return false;
	}
	if($("#myFormPatient input[id=document]").val().length > 10){
		if(!($("#myFormPatient input[id=document]").val() == "")){
			alert("Verifique su documento de identidad");
			return false;
		}	
	}
	if($("#myFormPatient input[id=address]").val().length < 3 || $("#myFormPatient input[id=address]").val().length > 50){
		if(!($("#myFormPatient input[id=address]").val() == "")){
			alert("Verifique su dirección");
			return false;	
		}	
	}
	if(isNaN($("#myFormPatient input[id=phone]").val())){
		alert("Verifique su número de teléfono");
		return false;
	}
	if(!($("#myFormPatient input[id=phone]").val() == "")){
		if($("#myFormPatient input[id=phone]").val().length > 15){
			alert("Verifique su número de teléfono");
			return false;
		}
	}
	if(!expresion.test($("#myFormPatient input[id=mail]").val())){
		if($("#myFormPatient input[id=mail]").val() != ""){
			alert($("#myFormPatient input[id=mail]").val());
			return false;
		}	
	}
	if(!(letter.test($("#myFormPatient input[id=name]").val()))){
		alert("El nombre debe tener solo letras");
		return false;
	}
	if(!(letter.test($("#myFormPatient input[id=lastName]").val()))){
		alert("El apellido debe tener solo letras");
		return false;
	}
	return true;
}



$(function(){
	$("#myFormPatient input[id=phone]").number(true, 0 ,',','-');
});




    
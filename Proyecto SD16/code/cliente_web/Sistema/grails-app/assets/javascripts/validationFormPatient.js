/**
 * Validaciones para formulario paciente
 */

$(document).ready(function(e){
	$("#patient").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50]
					},
					lastName:{
						required:true,
						rangelength:[3,50]
					},
					document:{
						rangelength:[6,10]
					},
					address:{
						rangelength:[3,50]
					},
					phone:{
						rangelength:[9,15]
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
						rangelength:"Cantidad de caracteres de 6 a 10"
					},
					address:{
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					phone:{
						number:"Debe ser numerico",
						rangelength:"Debe tener entre 9 a 15 numeros",
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

function saveDataPa(){
	var expresion = /\w+@\w+\.+[a-z]/;
	if($("#patient input[id=name]").val() == "" || $("#patient input[id=lastName]").val() == "" || $("#patient :radio[id=sex]:checked").val() === undefined){
		alert("Complete los campos obligatorios(*)");
		return false;
	}
	if($("#patient input[id=name]").val().length < 3 || $("#patient input[id=name]").val().length > 50){
		$("#patient input[id=name]").focus();
		return false;
	}
	if($("#patient input[id=lastName]").val().length < 3 || $("#patient input[id=lastName]").val().length > 50){
		$("#patient input[id=lastName]").focus();
		return false;
	}
	if($("#patient input[id=document]").val().length < 6 || $("#patient input[id=document]").val().length > 10){
		if(!($("#patient input[id=document]").val() == "")){
			$("#patient input[id=document]").focus();
			return false;
		}	
	}
	if($("#patient input[id=address]").val().length < 3 || $("#patient input[id=address]").val().length > 50){
		if(!($("#patient input[id=address]").val() == "")){
			$("#patient input[id=address]").focus();
			return false;	
		}	
	}
	if(isNaN($("#patient input[id=phone]").val())){
		$("#patient input[id=phone]").focus();
		return false;
	}
	if(!($("#patient input[id=phone]").val() == "")){
		if($("#patient input[id=phone]").val().length < 9 || $("#patient input[id=phone]").val().length > 15){
			$("#patient input[id=phone]").focus();
			return false;
		}
	}
	if($("#patient input[id=mail]").val != ""){
		if(!expresion.test($("#patient input[id=mail]").val())){
			$("#patient input[id=mail]").focus();
			return false;
		}
	}
	
}
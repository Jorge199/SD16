/**
 * validacion modal paciente
 */
$(document).ready(function(e){
	$("#myFormPatient").validate({
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

function saveData(){
	var expresion = /\w+@\w+\.+[a-z]/;

	if($("#myFormPatient input[id=name]").val() == "" || $("#myFormPatient input[id=lastName]").val() == ""){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	if($("#myFormPatient input[id=name]").val().length < 3 || $("#myFormPatient input[id=name]").val().length > 50){
		$("#myFormPatient input[id=name]").focus();
		return false;
	}
	if($("#myFormPatient input[id=lastName]").val().length < 3 || $("#myFormPatient input[id=lastName]").val().length > 50){
		$("#myFormPatient input[id=lastName]").focus();
		return false;
	}
	if($("#myFormPatient input[id=document]").val().length < 6 || $("#myFormPatient input[id=document]").val().length > 10){
		if(!($("#myFormPatient input[id=document]").val() == "")){
			$("#myFormPatient input[id=document]").focus();
			return false;
		}	
	}
	if($("#myFormPatient input[id=address]").val().length < 3 || $("#myFormPatient input[id=address]").val().length > 50){
		if(!($("#myFormPatient input[id=address]").val() == "")){
			$("#myFormPatient input[id=address]").focus();
			return false;	
		}	
	}
	if(isNaN($("#myFormPatient input[id=phone]").val())){
		$("#myFormPatient input[id=phone]").focus();
		return false;
	}
	if(!($("#myFormPatient input[id=phone]").val() == "")){
		if($("#myFormPatient input[id=phone]").val().length < 9 || $("#myFormPatient input[id=phone]").val().length > 15){
			$("#myFormPatient input[id=phone]").focus();
			alert("no");
			return false;
		}
	}
	if($("#myFormPatient input[id=mail]").val == ""){
		if(!expresion.test($("#myFormPatient input[id=mail]").val())){
			$("#myFormPatient input[id=mail]").focus();
			return false;
		}
	}
	
}





    
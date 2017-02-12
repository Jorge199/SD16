/**
 * validacion modal doctor
 */
$(document).ready(function(e){
			$("#myFormDoctor").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50]
					},
					last_name:{
						required:true,
						rangelength:[3,50]
					},
					ci:{
						rangelength:[6,10]
					},
					speciality:{
						rangelength:[3,20]
					},
					phone:{
						rangelength:[9,15]
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
						rangelength:"Cantidad de caracteres de 6 a 10"
					},
					speciality:{
						rangelength:"Cantidad de caracteres de 3 a 20"
					},
					phone:{
						number:"Debe ser numerico",
						rangelength:"Debe tener entre 9 a 15 numeros",
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

function saveDataDoctor(){
	var expresion = /\w+@\w+\.+[a-z]/;
	if($("#myFormDoctor input[id=name]").val() == "" || $("#myFormDoctor input[id=lastName]").val() == ""){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if($("#myFormDoctor input[id=name]").val().length < 3 || $("#myFormDoctor input[id=name]").val().length > 50){
		$("#myFormDoctor input[id=name]").focus();
		return false;
	}
	if($("#myFormDoctor input[id=last_name]").val().length < 3 || $("#myFormDoctor input[id=last_name]").val().length > 50){
		$("#myFormDoctor input[id=last_name]").focus();
		return false;
	}
	if($("#myFormDoctor input[id=ci]").val().length < 6 || $("#myFormDoctor input[id=ci]").val().length > 10){
		if(!($("#myFormDoctor input[id=ci]").val() == "")){
			$("#myFormDoctor input[id=ci]").focus();
			return false;
		}	
	}
	if($("#myFormDoctor input[id=address]").val().length < 3 || $("#myFormDoctor input[id=address]").val().length > 50){
		if(!($("#myFormDoctor input[id=address]").val() == "")){
			$("#myFormDoctor input[id=address]").focus();
			return false;	
		}	
	}
	if(isNaN($("#myFormDoctor input[id=phone]").val())){
		$("#myFormDoctor input[id=phone]").focus();
		return false;
	}
	if(!($("#myFormDoctor input[id=phone]").val() == "")){
		if($("#myFormDoctor input[id=phone]").val().length < 9 || $("#myFormDoctor input[id=phone]").val().length > 15){
			$("#myFormDoctor input[id=phone]").focus();
			return false;
		}
	}
	if($("#myFormDoctor input[id=email]").val == ""){
		if(!expresion.test($("#myFormDoctor input[id=email]").val())){
			$("#myFormDoctor input[id=email]").focus();
			return false;
		}
	}
	return true;
	
}
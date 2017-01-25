/**
 * validacion para el formulario de doctor
 */

$(document).ready(function(e){
			$("form").validate({
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

function saveData(){
	var expresion = /\w+@\w+\.+[a-z]/;
	if($("#name").val() == "" || $("#lastName").val() == ""){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if($("#name").val().length < 3 || $("#name").val().length > 50){
		$("#name").focus();
		return false;
	}
	if($("#last_name").val().length < 3 || $("#last_name").val().length > 50){
		$("last_name").focus();
		return false;
	}
	if($("#ci").val().length < 6 || $("#ci").val().length > 10){
		if(!($("#ci").val() == "")){
			$("#ci").focus();
			return false;
		}	
	}
	if($("#address").val().length < 3 || $("#address").val().length > 50){
		if(!($("#address").val() == "")){
			$("#address").focus();
			return false;	
		}	
	}
	if(isNaN($("#phone").val())){
		$("#phone").focus();
		return false;
	}
	if(!($("#phone").val() == "")){
		if($("#phone").val().length < 9 || $("#phone").val().length > 15){
			$("#phone").focus();
			return false;
		}
	}
	if($("#email").val == ""){
		if(!expresion.test($("#email").val())){
			$("#email").focus();
			return false;
		}
	}
	
}
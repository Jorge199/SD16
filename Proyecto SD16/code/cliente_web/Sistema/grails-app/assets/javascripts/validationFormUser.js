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
						rangelength:[8,16]
					},
					password2:{
						required:true,
						equalTo:"#pass1",
						rangelength:[8,16]
					},
					updater:{
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
					updater:{
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
					if(element.is(":text") || element.is(":password")){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveData(){
	if($("#name").val() == "" || $("#userName").val() == "" || $("#pass1").val() == "" || $("#password2").val() == "" || $("#updater").val() == ""){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if($("#name").val().length < 3 || $("#name").val().length > 50){
		$("#name").focus();
		return false;
	}
	if($("#userName").val().length < 3 || $("#userName").val().length > 50){
		$("#userName").focus();
		return false;
	}
	if($("#pass1").val() < 8 || $("#pass1").val() > 16){
		$("#pass1").focus();
		return false;
	}
	if($("#password2").val() < 8 || $("#password2").val() > 16){
		$("#password2").focus();
		return false;
	}
	if($("#pass1").val() != $("#password2").val()){
		$("#password2").focus();
		return false;
	}
	
	if($("#updater").val() == "Doctor"){
		if(isNaN($("#registrationNumber").val())){
			$("#registrationNumber").focus();
			return false;
		}
		if($("#registrationNumber").val().length < 3 || $("#registrationNumber").val().length > 10){
			$("#registrationNumber").focus();
			return false;
		}
	}
}
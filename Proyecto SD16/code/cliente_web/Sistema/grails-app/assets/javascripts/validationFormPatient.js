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
	if($("#name").val() == "" || $("#lastName").val() == ""){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if($("#name").val().length < 3 || $("#name").val().length > 50){
		$("#name").focus();
		return false;
	}
	if($("#lastName").val().length < 3 || $("#lastName").val().length > 50){
		$("#lastName").focus();
		return false;
	}
	if($("#document").val().length < 6 || $("#document").val().length > 10){
		if(!($("#document").val() == "")){
			$("#document").focus();
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
	if($("#mail").val == ""){
		if(!expresion.test($("#mail").val())){
			$("#mail").focus();
			return false;
		}
	}
	
}
/**
 * validacion para el formulario de doctor
 */

$(document).ready(function(e){
			$("#doctor").validate({
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
					sex:{
						required:true
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
					sex:{
						required:"Este campo es obligatorio"
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

function saveDataDoc(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var name = $("#doctor input[id=name]").val();
	var lastName =  $("#doctor input[id=last_name]").val();
	var doc = $("#doctor input[id=ci]").val();
	var address = $("#doctor input[id=address]").val();
	var phone = $("#doctor input[id=phone]").val();
	var email = $("#doctor input[id=email]").val();
	var sex = $("#doctor :radio[id=sex]:checked").val();
	var speciality =  $("#doctor input[id=speciality]").val();
	
	if(name == "" || lastName == "" || sex === undefined){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if(name.length < 3 || name.length > 50){
		name.focus();
		return false;
	}
	if(lastName.length < 3 || lastName.length > 50){
		lastName.focus();
		return false;
	}
	if(doc.length < 6 || doc.length > 10){
		if(!(doc == "")){
			doc.focus();
			return false;
		}	
	}
	if(address.length < 3 || address.length > 50){
		if(!(address == "")){
			address.focus();
			return false;	
		}	
	}
	if(isNaN(phone)){
		phone.focus();
		return false;
	}
	if(!(phone == "")){
		if(phone.length < 9 || phone.length > 15){
			phone.focus();
			return false;
		}
	}
	if(email == ""){
		if(!expresion.test(email)){
			email.focus();
			return false;
		}
	}
	if(!(speciality == "")){
		if(speciality.length < 3 || speciality.length > 20){
			speciality.focus();
			return false;
		}
	}
	
}
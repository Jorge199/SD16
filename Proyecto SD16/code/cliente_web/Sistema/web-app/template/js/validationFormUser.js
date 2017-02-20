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
						rangelength:[8,16]
					},
					rolId:{
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
					rolId:{
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
					if(element.is(":text") || element.is(":password") || element.is("select")){
						error.insertAfter(element);
					}
				}
			
			});
	$(".letter").keypress(function (key) {
        window.console.log(key.charCode)
        if ((key.charCode < 97 || key.charCode > 122)//letras mayusculas
            && (key.charCode < 65 || key.charCode > 90) //letras minusculas
            && (key.charCode != 45) //retroceso
            && (key.charCode != 241) //ñ
             && (key.charCode != 209) //Ñ
             && (key.charCode != 32) //espacio
             && (key.charCode != 225) //á
             && (key.charCode != 233) //é
             && (key.charCode != 237) //í
             && (key.charCode != 243) //ó
             && (key.charCode != 250) //ú
             && (key.charCode != 193) //Á
             && (key.charCode != 201) //É
             && (key.charCode != 205) //Í
             && (key.charCode != 211) //Ó
             && (key.charCode != 218) //Ú

            )
            return false;
    });
	$(".numeric").keydown(function(event) {
		   if(event.shiftKey)
		   {
		        event.preventDefault();
		   }
		 
		   if (event.keyCode == 46 || event.keyCode == 8)    {
		   }
		   else {
		        if (event.keyCode < 95) {
		          if (event.keyCode < 48 || event.keyCode > 57) {
		                event.preventDefault();
		          }
		        } 
		        else {
		              if (event.keyCode < 96 || event.keyCode > 105) {
		                  event.preventDefault();
		              }
		        }
		      }
	});
	$("#user input[id=password2]").keyup(function(){
		if($(this).val() == $("#user input[id=pass1]").val()){
			return true;
		}else{
			return false;
		}
	});
});

function saveDataUser(){
	var name = $("#user input[id=name]").val();
	var userName = $("#user input[id=userName]").val();
	var pass1 = $("#user input[id=pass1]").val();
	var password2 = $("#user input[id=password2]").val();
	var updater = $("#user input[id=updater]").val();
	var registrationNumber = $("#user input[id=registrationNumber]").val();
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	
	if(name == ""){
		$("#user input[id=name]").focus();
		return false;
	}
	if(userName == ""){
		$("#user input[id=userName]").focus();
		return false;
	}
	if(pass1 == ""){
		alert(pass1);
		$("#user input[id=pass1]").focus();
		return false;
	}
	if(password2 == ""){
		alert(password2);
		$("#user input[id=password2]").focus();
		return false;
	}
	if(updater == ""){
		$("#user input[id=updater]").focus();
		return false;
	}
	if(name.length < 3 || name.length > 50){
		$("#user input[id=name]").focus();
		return false;
	}
	if(userName.length < 3 || userName.length > 50){
		$("#user input[id=userName]").focus();
		return false;
	}
	if(pass1 < 8 || pass1 > 16){
		$("#user input[id=pass1]").focus();
		return false;
	}
	if(password2 < 8 || password2 > 16){
		$("#user input[id=password2]").focus();
		return false;
	}
	
	if(updater == "Doctor"){
		if(isNaN(registrationNumber)){
			$("#user input[id=updater]").focus();
			return false;
		}
		if(registrationNumber.length < 3 || registrationNumber.length > 10){
			$("#user input[id=updater]").focus();
			return false;
		}
	}
}
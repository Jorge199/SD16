/**
 * validacion para el formulario de doctor
 */

$(document).ready(function(e){
			$("#contact").validate({
				rules: {
					subject:{
						required:true,
						maxlength:50
					},
					message:{
						required:true,
						maxlength:250
					},
					phone:{
						required:true,
						maxlength:17
					},
					email:{
						required:true,
						email:true
					},
				},

				messages:{
					subject:{
						required:"El asunto es obligatorio(*)",
						rangelength:"Cantidad de caracteres hasta 50"
					},
					message:{
						required:"El mensaje es obligatorio(*)",
						rangelength:"Cantidad de caracteres hasta 250"
					},
					phone:{
						required:"El telefono es obligatorio(*)",
						number:"Debe ser numerico",
						maxlength:"Debe tener hasta 14 numeros"
					},
					email:{
						required:"El correo es obligatorio(*)",
						email:"Formato de correo incorrecto"
					},
				},
				errorPlacement: function(error, element){
					if(element.is(":text")){
						error.insertAfter(element);
					}
					if(element.is(":radio")){
						error.appendTo(element.parent());
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
			$('#contact input[id=phone]').on('input', function() {
			    var p = $(this).val().replace(/[^\d]/g, '')
			    
			    if (p.length == 6 || p.length == 7 || p.length == 8 ) {
			    	p = p.replace(/(\d{3})(\d{3})/, "$1-$2");
			    }
			    if(p.length == 9 || p.length == 10 || p.length == 11){
			    	p = p.replace(/(\d{3})(\d{3})(\d{3})/, "$1-$2-$3");
			    }
			    if(p.length == 12 || p.length == 13 || p.length == 14){
			    	p = p.replace(/(\d{3})(\d{3})(\d{3})(\d{3})/, "$1-$2-$3-$4");
			    }
			    $(this).val(p);
			});
});

function saveDataContact(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	var subject = $("#contact input[id=subject]").val();
	var message =  $("#contact textArea[id=message]").val();
	var phone = $("#contact input[id=phone]").val();
	var email = $("#contact input[id=email]").val();
	
	if(subject == ""){
		$("#contact input[id=subject]").focus();
		return false;
	}
	if(message == ""){
		$("#contact textArea[id=message]").focus();
		return false;
	} 
	if(subject.length > 50){
		$("#contact input[id=subject]").focus();
		return false;
	}
	if(message.length > 250){
		$("#contact input[id=message]").focus();
		return false;
	}
	if(phone == ""){
		$("#contact input[id=phone]").focus();
		return false;
	}
	if(phone.length > 17){
		$("#contact input[id=phone]").focus();
		return false;
	}
	if(email == ""){
		$("#contact input[id=email]").focus();
		return false;
	}
	if(!expresion.test(email)){
		$("#contact input[id=email]").focus();
		return false;
	}
	
}
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
						maxlength:10
					},
					sex:{
						required:true
					},
					speciality:{
						rangelength:[3,20]
					},
					phone:{
						maxlength:17
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
						required:"El nombre es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					last_name:{
						required:"El apellido es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					ci:{
						maxlength:"Cantidad de caracteres hasta 10"
					},
					sex:{
						required:"Obligatorio(*)"
					},
					speciality:{
						rangelength:"Cantidad de caracteres de 3 a 20"
					},
					phone:{
						number:"Debe ser numerico",
						maxlength:"Debe tener hasta 14 numeros"
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
			$('#doctor input[id=phone]').on('input', function() {
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

function saveDataDoc(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var letter = /^[a-zA-Z\s áãàéèíìóõòúùñ]+$/;
	var name = $("#doctor input[id=name]").val();
	var lastName =  $("#doctor input[id=last_name]").val();
	var doc = $("#doctor input[id=ci]").val();
	var address = $("#doctor input[id=address]").val();
	var phone = $("#doctor input[id=phone]").val();
	var email = $("#doctor input[id=email]").val();
	var sex = $("#doctor :radio[id=sex]:checked").val();
	var speciality =  $("#doctor input[id=speciality]").val();
	
	if(name == ""){
		$("#doctor input[id=name]").focus();
		return false;
	}
	if(lastName == ""){
		$("#doctor input[id=last_name]").focus();
		return false;
	} 
	if(sex === undefined){
		$("#doctor :radio[id=sex]").focus();
		return false;
	}
	if(name.length < 3 || name.length > 50){
		$("#doctor input[id=name]").focus();
		return false;
	}
	if(lastName.length < 3 || lastName.length > 50){
		$("#doctor input[id=last_name]").focus();
		return false;
	}
	if(doc.length > 10){
		if(!(doc == "")){
			$("#doctor input[id=ci]").focus();
			return false;
		}	
	}
	if(address.length < 3 || address.length > 50){
		if(!(address == "")){
			$("#doctor input[id=address]").focus();
			return false;	
		}	
	}

	if(!(phone == "")){
		if(phone.length > 17){
			$("#doctor input[id=phone]").focus();
			return false;
		}
	}
	if(email != ""){
		if(!expresion.test(email)){
			$("#doctor input[id=email]").focus();
			return false;
		}
	}
	if(!(speciality == "")){
		if(speciality.length < 3 || speciality.length > 20){
			$("#doctor input[id=speciality]").focus();
			return false;
		}
	}
	
}
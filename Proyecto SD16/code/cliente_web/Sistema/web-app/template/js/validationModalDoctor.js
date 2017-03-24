/**
 * validacion modal doctor
 */
$(document).ready(function(e){
			$("#myFormDoctor").validate({
				rules: {
					name:{
						required:true,
						rangelength:[1,50]
					},
					last_name:{
						required:true,
						rangelength:[1,50]
					},
					ci:{
						maxlength:15
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
						rangelength:[1,50]
					}
				},

				messages:{
					name:{
						required:"El nombre es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 1 a 50"
					},
					last_name:{
						required:"El apellido es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 1 a 50"
					},
					ci:{
						maxlength:"Cantidad de caracteres hasta 15"
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
						rangelength:"Cantidad de caracteres entre 1 a 50"
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
			$("#myFormDoctor input[id=phone]").on('input', function() {
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
			$('#myFormDoctor input[id=ci]').on('input', function() {
			    var p = $(this).val().replace(/[^\w]/g, '')
			    
			    if (p.length == 6) {
			    	p = p.replace(/(\d{3})(\d{3})/, "$1.$2");
			    }
			    if (p.length == 7) {
			    	p = p.replace(/(\d{1})(\d{3})(\d{3})/, "$1.$2.$3");
			    }
			    if (p.length == 8) {
			    	p = p.replace(/(\d{2})(\d{3})(\d{3})/, "$1.$2.$3");
			    }
			    if (p.length == 9) {
			    	p = p.replace(/(\d{3})(\d{3})(\d{3})/, "$1.$2.$3");
			    }
			    if (p.length == 10) {
			    	p = p.replace(/(\d{1})(\d{3})(\d{3})(\d{3})/, "$1.$2.$3.$4");
			    }
			    if (p.length == 11) {
			    	p = p.replace(/(\d{2})(\d{3})(\d{3})(\d{3})/, "$1.$2.$3.$4");
			    }
			    if (p.length == 12) {
			    	p = p.replace(/(\d{3})(\d{3})(\d{3})(\d{3})/, "$1.$2.$3.$4");
			    }
			    if (p.length == 13) {
			    	p = p.replace(/(\d{1})(\d{3})(\d{3})(\d{3})(\d{3})/, "$1.$2.$3.$4.$5");
			    }
			    if (p.length == 14) {
			    	p = p.replace(/(\d{2})(\d{3})(\d{3})(\d{3})(\d{3})/, "$1.$2.$3.$4.$5");
			    }
			    if (p.length == 15) {
			    	p = p.replace(/(\d{3})(\d{3})(\d{3})(\d{3})(\d{3})/, "$1.$2.$3.$4.$5");
			    }
			    
			    $(this).val(p);
			});
			
});

function saveDataDoctor(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var name = $("#myFormDoctor input[id=name]").val();
	var lastName =  $("#myFormDoctor input[id=last_name]").val();
	var doc = $("#myFormDoctor input[id=ci]").val();
	var address = $("#myFormDoctor input[id=address]").val();
	var phone = $("#myFormDoctor input[id=phone]").val();
	var email = $("#myFormDoctor input[id=email]").val();
	var sex = $("#myFormDoctor :radio[id=sex]:checked").val();
	var speciality = $("#myFormDoctor input[id=speciality]").val();
	
	if(name == ""){
		$("#myFormDoctor input[id=name]").focus();
		return false;
	}
	if(lastName == ""){
		$("#myFormDoctor input[id=last_name]").focus();
		return false;
	}
	if(sex === undefined){
		$("#myFormDoctor :radio[id=sex]").focus();
		return false;
	}
	if(name.length < 1 || name.length > 50){
		$("#myFormDoctor input[id=name]").focus();
		return false;
	}
	if(lastName.length < 1 || lastName.length > 50){
		$("#myFormDoctor input[id=last_name]").focus();
		return false;
	}
	if(doc.length > 15){
		if(!(doc == "")){
			$("#myFormDoctor input[id=ci]").focus();
			return false;
		}	
	}
	if(address.length < 1 || address.length > 50){
		if(!(address == "")){
			address = $("#myFormDoctor input[id=address]").focus();
			return false;	
		}	
	}
	
	if(!(phone == "")){
		if(phone.length > 17){
			phone = $("#myFormDoctor input[id=phone]").focus();
			return false;
		}
	}
	
	if(!expresion.test(email)){
		if(email != ""){
			$("#myFormDoctor input[id=email]").focus();
			return false;
		}	
	}
	
	if(!(speciality == "")){
		if(speciality.length < 3 || speciality.length > 20){
			$("#myFormDoctor input[id=speciality]").focus();
			return false;
		}
	}
	
	return true;
	
}
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
						maxlength:10
					},
					address:{
						rangelength:[3,50]
					},
					phone:{
						number:true,
						maxlength:17
					},
					mail:{
						email:true
					},
					sex:{
						required:true
					},
					birthDate:{
						
					}
				},

				messages:{
					name:{
						required:"El nombre es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					lastName:{
						required:"El apellido es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					document:{
						maxlength:"Cantidad de caracteres hasta 10"
					},
					address:{
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					phone:{
						number:"Debe ser numerico",
						maxlength:"Debe tener hasta 14 numeros",
					},
					mail:{
						email:"Formato de correo incorrecto"
					},
					sex:{
						required:"Obligatorio(*)"
					},
					birthDate:{
					
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
	
	$("#myFormPatient input[id=phone]").on('input', function() {
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

function validateBirthDay(){ 
    var birth =  $("#myFormPatient input[id=birthDate]").val();
    var nowDate = new Date();
    var formatNowDate = nowDate.getDate() +'-'+(nowDate.getMonth() + 1)+'-'+nowDate.getFullYear();
    var birthDay = birth.split("-");
    var now = formatNowDate.split("-");
   
    if(now[2].length == 1){
    	now[2] = '0'+now[2];
    }
    if(birthDay[2] > now[2]){
    	return true;
    }
    
    if(now[1].length == 1){
    	now[1] = '0'+now[1];
    }
    if(birthDay[1] > now[1]){
    	return true;
    }
    
    if(now[0].length == 1){
    	now[0] = '0'+now[0];
    }
    if(birthDay[0] > now[0]){
    	return true;
    }
    return false;
}

function saveDataPatient(){
	var expresion = /\w+@\w+\.+[a-z]/;
	var name = $("#myFormPatient input[id=name]").val();
	var lastName = $("#myFormPatient input[id=lastName]").val();
	var sex = $("#myFormPatient :radio[id=sex]:checked").val();
	var doc = $("#myFormPatient input[id=document]").val();
	var address = $("#myFormPatient input[id=address]").val();
	var phone = $("#myFormPatient input[id=phone]").val();
	var mail = $("#myFormPatient input[id=mail]").val();
	var birth =  $("#myFormPatient input[id=birthDate]").val();
	
	if(name == ""){
		$("#myFormPatient input[id=name]").focus();
		return false;
	}
	if(lastName == ""){
		$("#myFormPatient input[id=lastName]").focus();
		return false;
	}
	if(sex === undefined){
		$("#myFormPatient :radio[id=sex]").focus();
		return false;
	}
	if(name.length < 3 || name.length > 50){
		$("#myFormPatient input[id=name]").focus();
		return false;
	}
	if(lastName.length < 3 || lastName.length > 50){
		$("#myFormPatient input[id=lastName]").focus();
		return false;
	}
	if(doc.length > 10){
		if(!(doc == "")){
			$("#myFormPatient input[id=document]").focus();
			return false;
		}	
	}
	if(address.length < 3 || address.length > 50){
		if(!(address == "")){
			$("#myFormPatient input[id=address]").focus();
			return false;	
		}	
	}
	if(!( phone == "")){
		if(phone.length > 17){
			$("#myFormPatient input[id=phone]").focus();
			return false;
		}
	}
	if(!expresion.test()){
		if(mail != ""){
			$("#myFormPatient input[id=mail]").focus();
			return false;
		}	
	}
	
	return true;
}







    
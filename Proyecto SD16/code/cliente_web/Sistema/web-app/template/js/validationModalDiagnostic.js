/**
 * validacion modal diagnostic
 */
$(document).ready(function(e){
			$("#myFormDiagnostic").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50]
					},
					description:{
						rangelength:[3,50]
					}
					
				},

				messages:{
					name:{
						required:"El nombre es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					description:{
						rangelength:"Cantidad de caracteres entre 3 a 50"
					}
					
				},
				errorPlacement: function(error, element){
					if(element.is(":text")){
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
});

function saveDataModalDiagnostic(){
	
	var name = $("#myFormDiagnostic input[id=name]").val();
	var description =  $("#myFormDiagnostic input[id=description]").val();
		
	if(name == ""){
		$("#myFormDiagnostic input[id=name]").focus();
		return false;
	}

	if(!(description == "")){
		if(description.length < 3 || description.length > 50){
			$("#myFormDiagnostic input[id=description]").focus();
			return false;
		}
	}
	
	return true;
	
}
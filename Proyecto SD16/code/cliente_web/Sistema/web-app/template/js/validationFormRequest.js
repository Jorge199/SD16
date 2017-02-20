/**
 * Validacion del formulario de ficha
 */
$(document).ready(function(e){
	$("#myFormRequest").validate({
				rules: {
					date:{
						required:true,
					},
					code:{
						required:true
					},
					code_cortes:{
						required:true,
					},
					patientId:{
						required:true
					},
					doctorId:{
						required:true
					},
					studyTypeId:{
						required:true
					},
					note:{
						
					},
					specimen:{
						required:true
					}
				},

				messages:{
					date:{
						required:"El campo fecha es obligatorio"
					},
					code:{
						required:"Obligatorio(*)"
					},
					code_cortes:{
						required:"Obligatorio(*)"
					},
					patientId:{
						required:"El paciente es obligatorio(*)"
					},
					doctorId:{
						required:"El doctor es obligatorio(*)"
					},
					studyTypeId:{
						required:"El tipo de estudio es obligatorio(*)"
					},
					note:{
						
					},
					specimen:{
						required:"El specimen es obligatorio(*)"
					}
					
				},
				errorPlacement: function(error, element){
					if(element.is(":text") || element.attr("name") == "specimen"){
						error.insertAfter(element);
					}
					if(element.attr("name") == "patientId"){
						error.insertAfter("#data-patient");
					}
					if(element.attr("name") == "doctorId"){
						error.insertAfter("#data-doctor");
					}
					if(element.attr("name") == "studyTypeId"){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveDataRequest(){
	var code =  $("#myFormRequest input[id=code]").val();
	var codeCortes = $("#myFormRequest input[id=code_cortes]").val();
	var selectPatient = $("#myFormRequest select[id=patientId]").val();
	var selectDoctor = $("#myFormRequest select[id=doctorId]").val();
	var study =  $("#myFormRequest select[id=studyTypeId]").val();

	if(code == ""){
		$("#myFormRequest input[id=code]").focus();
		return false;
	}
	if(codeCortes == ""){
		$("#myFormRequest input[id=code_cortes]").focus();
		return false;
	}  
	if(selectPatient == ""){
		$("#myFormRequest select[id=patientId]").focus();
		return false;
	} 
	if(selectDoctor == ""){
		$("#myFormRequest select[id=doctorId]").focus();
		return false;
	}
	if(study == ""){
		$("#myFormRequest select[id=studyTypeId]").focus();
		return false;
	}
	return true;
	
	
}

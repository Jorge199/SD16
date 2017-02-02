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
						required:true,
						number:true
					},
					code_cortes:{
						required:true,
						number:true
					},
					code_laminas:{
						required:true,
						number:true
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
						
					}
				},

				messages:{
					date:{
						required:"El campo fecha es obligatorio"
					},
					code:{
						required:"El campo codigo es obligatorio",
						number:"Debe estar en formato numerico"
					},
					code_cortes:{
						required:"El campo codigo es obligatorio",
						number:"Debe estar en formato numerico"
					},
					code_laminas:{
						required:"El campo codigo es obligatorio",
						number:"Debe estar en formato numerico"
					},
					patientId:{
						required:"El campo paciente es obligatorio"
					},
					doctorId:{
						required:"El campo doctor es obligatorio"
					},
					studyTypeId:{
						required:"El campo tipo de estudio es obligatorio"
					},
					note:{
						
					}	
					
				},
				errorPlacement: function(error, element){
					if(element.is("select")){
						if(element.attr("name") == "patientId"){
						 error.insertAfter("#data-patient");
						}
						if(element.attr("name") == "doctorId"){
							error.insertAfter("#data-doctor");
						}
						if(element.attr("name") == "studyTypeId"){
							error.insertAfter("#studyTypeId");
						}
					}
					
					if(element.is(":text")){
						if(element.attr("name") == "date"){
							 error.insertAfter("#datetimepicker2");
						}else{
							error.insertAfter(element);
						}
					}
				}
			
			});
});

function saveDataRequest(){
	var expresion = /\w+@\w+\.+[a-z]/;

	if($("#myFormRequest input[id=date]").val() == "" || $("#myFormRequest input[id=code]").val() == ""
		|| $("#myFormRequest input[id=code_cortes]").val() == "" || $("#myFormRequest input[id=code_laminas]").val() == "" 
			|| $("#myFormRequest select[id=patientId]").val() == "" || $("#myFormRequest select[id=doctorId]").val() == ""
				|| $("#myFormRequest select[id=studyTypeId]").val() == ""){
		alert("Complete los campos obligatorios (*)");
		return false;
	}
	
}

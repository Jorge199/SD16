/**
 * 
 */
$(document).ready(function(e){
		$("#report").validate({
					rules: {
						diagnostic:{
							required:true
						},
						diagnosticDetail:{
							maxlength:25
						}
					},

					messages:{
						diagnostic:{
							required:"Este campo es obligatorio"
						},
						diagnosticDetail:{
							maxlength:"Cantidad de caracteres hasta 25"
						}
					},
					errorPlacement: function(error, element){
						if(element.is(":text")){
							error.insertAfter(element);
						}
					}
				
				});
	});

	function saveDataReport(){
		if($("#diagnostic").val() == "SIN_INDICIOS"){
			alert("Complete los campos obligatorios(*)");
			return false;
		}
		if($("#report input[id=diagnosticDetail]").val() != ""){
			if($("#diagnosticDetail").val() > 25){
				alert("La descripcion admitida es hasta 25 caracteres");
				return false;
			}
		}

	}
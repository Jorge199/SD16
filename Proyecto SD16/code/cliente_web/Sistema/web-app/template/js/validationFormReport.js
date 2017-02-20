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
							required:"Campo es obligatorio(*)"
						},
						diagnosticDetail:{
							maxlength:"Cantidad de caracteres hasta 25"
						}
					},
					errorPlacement: function(error, element){
						if(element.is(":select")){
							error.insertAfter(element);
						}
					}
				
				});
	});

	function saveDataReport(){
		if($("#report select[id=diagnostic]").val() == "SIN_INDICIOS"){
			$("#diagnostic").focus();
			return false;
		}
		if($("#report input[id=diagnosticDetail]").val() != ""){
			if($("#report input[id=diagnosticDetail]").val() > 25){
				$("#report input[id=diagnosticDetail]").focus();
				return false;
			}
		}

	}
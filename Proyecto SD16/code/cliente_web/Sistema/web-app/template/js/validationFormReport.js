/**
 * 
 */
$(document).ready(function(e){
		$("#report").validate({
					rules: {
						diagnostic:{
							required:true
						},
						observations:{
							required:true
						},
						diagnosticDetail:{
							maxlength:25
						}
					},

					messages:{
						diagnostic:{
							required:"El diagnóstico es obligatorio(*)"
						},
						observations:{
							required:"El informe es obligatorio(*)"
						},
						diagnosticDetail:{
							maxlength:"Cantidad de caracteres hasta 25"
						}
					},
					errorPlacement: function(error, element){
						if(element.is(":text") || element.attr("name") == "observations"){
							error.insertAfter(element);
						}
						if(element.attr("name") == "diagnostic"){
							error.insertAfter(element);
						}
					}
				
				});
	});

	function saveDataReport(){
		
		if($("#report select[id=diagnostic]").val() == ""){
			$("#diagnostic").focus();
			return false;
		}
		
		if($("#report input[id=diagnosticDetail]").val() != ""){
			if($("#report input[id=diagnosticDetail]").val() > 25){
				$("#report input[id=diagnosticDetail]").focus();
				return false;
			}
		}
		return true;

	}
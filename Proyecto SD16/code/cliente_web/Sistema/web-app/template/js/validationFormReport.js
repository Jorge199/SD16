/**
 * 
 */
$(document).ready(function(e){
		$("#report").validate({
					rules: {
						diagnosticId:{
							required:true
						},
						observations:{
							required:true
						},
						diagnosticDetail:{
							maxlength:200
						}
					},

					messages:{
						diagnosticId:{
							required:"El diagnóstico es obligatorio(*)"
						},
						observations:{
							required:"El informe es obligatorio(*)"
						},
						diagnosticDetail:{
							maxlength:"Cantidad de caracteres hasta 200"
						}
					},
					errorPlacement: function(error, element){
						if(element.is(":text") || element.attr("name") == "observations"){
							error.insertAfter(element);
						}
						if(element.attr("name") == "diagnosticId"){
							error.insertAfter("#data-diagnostic");
						}
					}
				
				});
	});

	function saveDataReport(){
		
		if($("#report select[id=diagnosticId]").val() == ""){
			$("#diagnosticId").focus();
			return false;
		}
		
		return true;

	}
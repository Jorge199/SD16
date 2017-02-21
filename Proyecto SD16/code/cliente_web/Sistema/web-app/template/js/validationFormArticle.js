/**
 * Validacion para formulario de articulo
 */

$(document).ready(function(e){
	$("#article").validate({
				rules: {
					name:{
						required:true,
						rangelength:[3,50]
					},
					description:{
						maxlength:100
					},
					units:{
						required:true,
					}
				},

				messages:{
					name:{
						required:"El nombre es obligatorio(*)",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					description:{
						maxlength:"Cantidad de caracteres hasta 100"
					},
					units:{
						required:"La unidad es obligatorio(*)"
					}
				},
				errorPlacement: function(error, element){
					if(element.is(":text")){
						error.insertAfter(element);
					}
					if(element.attr("name") == "units"){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveDataArticle(){
	var name = $("#article input[id=name]").val();
	var description = $("#article input[id=description]").val();
	var units = $("#article input[id=units]").val();
	
	if(name == "" ){
		$("#article input[id=name]").focus();
		return false;
	}
	if($("#article select[id=units]").val() == ""){
		$("#units").focus();
		return false;
	}
	if(name.length < 3 || name.length > 50){
		$("#article input[id=name]").focus();
		return false;
	}
	if(description.length > 100){
		$("#article input[id=description]").focus();
		return false;
	}
	return true;

}
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
						required:true,
						rangelength:[3,50]
					},
					units:{
						number:true
					}
				},

				messages:{
					name:{
						required:"El campo nombre es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					description:{
						required:"El campo descripcion es obligatorio",
						rangelength:"Cantidad de caracteres entre 3 a 50"
					},
					units:{
						number:"Debe ser un numero"
					}
				},
				errorPlacement: function(error, element){
					if(element.is(":text")){
						error.insertAfter(element);
					}
				}
			
			});
});

function saveData(){
	if($("#name").val() == "" || $("#description").val() == ""){
		alert("Complete los campos obligatorios (*)")
		return false;
	}
	if($("#name").val().length < 3 || $("#name").val().length > 50){
		$("#name").focus();
		return false;
	}
	if($("#description").val().length < 3 || $("#description").val().length > 50){
		$("#description").focus();
		return false;
	}
	
}
/**
 * validar el formulario
 */

function validar(){
	var date, code, code_cortes, code_laminas, patientId, doctorId, studyTypeId, note, expresion, expresionCode;
	date = document.getElementById("date").value;
	code = document.getElementById("code").value;
	code_cortes = document.getElementById("code_cortes");
	code_laminas = document.getElementById("code_laminas");
	patientId = document.getElementById("patientId");
	doctorId = document.getElementById("doctorId");
	studyTypeId = document.getElementById("studyTypeId");
	note = document.getElementById("note");
	
	
	/* condiciones a cumplir*/
	
	if(date == "" || code == "" || code_cortes == "" || code_laminas == "" || patientId == "" || doctorId == ""
		|| studyTypeId == ""){
		alert("Complete  los campos obligatorio (*)");
		return false;
	}
	
	/*
	if(!expresion.test(email)){
		alert("El formato de correo no es valido");
		return false;
	}
	*/
}
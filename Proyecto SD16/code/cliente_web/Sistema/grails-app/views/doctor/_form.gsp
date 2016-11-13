<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label> <input
			type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$"
			title='No se deben poner numeros o caracteres' maxlength="50"
			name="name" value="${doctorInstance?.name }" />
	</div>
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label> <input
			type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$"
			title='No se deben poner numeros o caracteres.' maxlength="50"
			name="last_name" value="${doctorInstance?.lastName }" />
	</div>

	<div class="col-md-6">
		<label>C.I</label>
		<g:field type="number" class="form-control" name="ci" value="${doctorInstance?.ci}" />
	</div>
	<div class="col-md-6">
		<label>Especialidad</label> <input type="text" class="form-control"
			maxlength="20" title='Ingrese Espcialidad' name="speciality"
			value="${doctorInstance?.speciality}" />
	</div>


	<div class="col-md-6">
		<label>Teléfono</label> <input
			type="text" class="form-control"
			pattern="[\(09]\d{2}\d{2}[\)]\d{3}[\-]\d{3}" maxlength="20"
			title='Formato: (9999)999-999' name="phone"
			value="${doctorInstance?.phone}" />
	</div>
	<div class="col-md-6">
		<label>Correo</label>
		<g:field type="email" class="form-control" maxlength="50" name="email"
			value="${doctorInstance?.email}" />
	</div>
	<div class="col-md-6">
		<label>Dirección</label>
		<g:textField class="form-control" maxlength="50" name="address"
			value="${doctorInstance?.address}" />
	</div>

</div>
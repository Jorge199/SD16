

<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<div class="form-group">
		 <input
			type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$"
			title='No se deben poner numeros o caracteres' placeholder="Ingrese un Nombre"
			 maxlength="50"
			name="name" value="${doctorInstance?.name }" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label> 
		<div class="form-group">
		<input
			type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$"
			title='No se deben poner numeros o caracteres.' placeholder="Ingrese un Apellido"
			maxlength="50"
			name="last_name" value="${doctorInstance?.lastName }" />
		</div>
	</div>

	<div class="col-md-6">
		<label>C.I</label>
		<div class="form-group">
		<g:field type="text" class="form-control" name="ci" placeholder="Ingrese un número de Cédula"
			value="${doctorInstance?.ci}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Especialidad</label> 
		<div class="form-group">
		<input type="text" class="form-control"
			maxlength="20" title='Ingrese Espcialidad' placeholder="Ingrese una Especialidad"
			name="speciality"
			value="${doctorInstance?.speciality}" />
		</div>
	</div>


	<div class="col-md-6">
		<label>Teléfono</label> 
		<div class="form-group">
		<input type="text" class="form-control"
			id="phoneNum" maxlength="20" placeholder="Ingrese un Número"
			data-mask="(9999) 999-999" name="phone"
			value="${doctorInstance?.phone}" />
		</div>
	</div>
	
	<div class="col-md-6">
		<label>Correo</label>
		<div class="form-group">
		<g:field type="email" class="form-control" maxlength="50" name="email" placeholder="Ingrese un correo"
			value="${doctorInstance?.email}" />
		</div>
	</div>
	<div class="col-md-6">
		<label>Dirección</label>
		<div class="form-group">
		<g:textField class="form-control" placeholder="Ingrese una Dirección" maxlength="50" name="address"
			value="${doctorInstance?.address}" />
		</div>
	</div>

</div>
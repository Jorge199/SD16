<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<input type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$" title='No se deben poner numeros o caracteres' maxlength="50" name="name" value="${doctorInstance?.name }"/>
	</div>
        <div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<input type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$" title='No se deben poner numeros o caracteres.' maxlength="50" name="last_name" value="${doctorInstance?.lastName }"/>
	</div>
        <div class="col-md-6">
		<label>C.I<span class="required-indicator">*</span></label>
		<g:field type="number" class="form-control" required="" min="100000" max="100000000" name="ci" value="${doctorInstance?.ci}"/>
	</div>
	<div class="col-md-6">
		<label>Dirección<span class="required-indicator"></span></label>
		<g:textField class="form-control" maxlength="50" name="address" value="${doctorInstance?.address}"/>
	</div>
	<div class="col-md-6">
		<label>Correo<span class="required-indicator"></span></label>
		<g:field type="email" class="form-control" maxlength="50" name="email" value="${doctorInstance?.email}"/>
	</div>
	<div class="col-md-6">
		<label>Teléfono<span class="required-indicator"></span></label>
		<input type="text" class="form-control" pattern="[\(09]\d{2}\d{2}[\)]\d{3}[\-]\d{3}" maxlength="20" title='Formato: (9999)999-999' name="phone" value="${doctorInstance?.phone}"/>
	</div>
</div>
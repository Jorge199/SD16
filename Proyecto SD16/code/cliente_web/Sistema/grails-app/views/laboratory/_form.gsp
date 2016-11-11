
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<input type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$" title='No se deben poner numeros o caracteres' maxlength="50" name="name" value="${laboratoryInstance?.name }"/>
	</div>
	<div class="col-md-6">
		<label>Direcciòn<span class="required-indicator"></span></label>
		<g:textField class="form-control" maxlength="100" name="address" value="${laboratoryInstance?.address}"/>
	</div>
	<div class="col-md-6">
		<label>Correo<span class="required-indicator"></span></label>
		<g:field type="email" class="form-control" maxlength="50" name="email" value="${laboratoryInstance?.email }"/>
	</div>
	<div class="col-md-6">
		<label>Telèfono<span class="required-indicator"></span></label>
		<input type="text" class="form-control" pattern="[\(09]\d{2}\d{2}[\)]\d{3}[\-]\d{3}" maxlength="20" title='Formato: (9999)999-999' name="phone" value="${laboratoryInstance?.phone}"/>
	</div>
</div>



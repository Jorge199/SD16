
<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span> </label>
		<input type="text" class="form-control" required="" pattern="^[a-zA-Z ]+$" title='No se deben poner numeros o caracteres' maxlength="50" name="name" value="${laboratoryInstance?.name }"/>
	</div>
	<div class="col-md-6">
		<label>Dirección<span class="required-indicator"></span> </label>
		<g:textField class="form-control" maxlength="100" name="address" value="${laboratoryInstance?.address}"/>
	</div>
	<div class="col-md-6">
		<label>Correo<span class="required-indicator"></span> </label>
		<g:field type="email" class="form-control" maxlength="50" name="email" value="${laboratoryInstance?.email }"/>
	</div>
	<div class="col-md-6">
		<label>Teléfono</label> <input type="text" class="form-control"
			id="phoneNum" maxlength="20" placeholder="Ingrese un Número"
			data-mask="(999) 999-999" name="phone" 
			value="${laboratoryInstance?.phone}" />
        </div>
</div>




<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="name" value="${laboratoryInstance?.name }"/>
	</div>
	<div class="col-md-6">
		<label>Direcciòn<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="address" value="${laboratoryInstance?.address}"/>
	</div>
	<div class="col-md-6">
		<label>Correo<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="email" value="${laboratoryInstance?.email }"/>
	</div>
	<div class="col-md-6">
		<label>Telèfono<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="phone" value="${laboratoryInstance?.phone}"/>
	</div>
</div>



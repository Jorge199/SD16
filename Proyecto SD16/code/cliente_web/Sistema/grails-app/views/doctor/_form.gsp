<div class="row">
	<div class="col-md-6">
		<label>Nombre<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="name" value="${doctorInstance?.name }"/>
	</div>
        <div class="col-md-6">
		<label>Apellido<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="last_name" value="${doctorInstance?.lastName }"/>
	</div>
        <div class="col-md-6">
		<label>C.I<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="ci" value="${doctorInstance?.ci}"/>
	</div>
	<div class="col-md-6">
		<label>Direcciòn<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="address" value="${doctorInstance?.address}"/>
	</div>
	<div class="col-md-6">
		<label>Correo<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="email" value="${doctorInstance?.email }"/>
	</div>
	<div class="col-md-6">
		<label>Telèfono<span class="required-indicator">*</span></label>
		<g:textField class="form-control" required="" name="phone" value="${doctorInstance?.phone}"/>
	</div>
</div>